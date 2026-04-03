# Case 6: Vulnerabilities Only at the Fourth Level (N4)

## Scenario

Multi-module Maven project with **4 levels of depth** where vulnerabilities are found **exclusively at the fourth level (N4)** of the dependency tree. Three layers of internal modules (all clean) separate the application from the vulnerable libraries.

## Benchmark Objective

Validate that the SCA tool:
1. Resolves dependency trees of 4+ levels of depth
2. Does not truncate analysis at shallow levels (N1-N3)
3. Detects vulnerabilities at very deep levels of the tree
4. This is the hardest case for SCA tools that limit analysis depth

## Project Structure

```
06_deep_transitive_n4/
├── pom.xml                     (parent POM)
├── lib-deep/                   (N3 from app — depends on vulnerable libs)
│   ├── pom.xml                 (commons-collections:3.2.1, commons-io:2.6)
│   └── src/.../CollectionHelper.java
├── lib-middle/                 (N2 from app — depends on lib-deep)
│   ├── pom.xml
│   └── src/.../DataProcessor.java
├── lib-outer/                  (N1 from app — depends on lib-middle)
│   ├── pom.xml
│   └── src/.../FileService.java
└── app/                        (main application)
    ├── pom.xml                 (only depends on lib-outer)
    └── src/.../App.java
```

## Dependency Tree (from app/ perspective)

```
app (pom.xml)
└── lib-outer:1.0.0                            ← N1 CLEAN
    └── lib-middle:1.0.0                       �� N2 CLEAN
        └── lib-deep:1.0.0                     ← N3 CLEAN
            ├── commons-collections:3.2.1      ← N4 VULNERABLE
            │   (CVE-2015-6420, CVE-2015-7501)
            └── commons-io:2.6                 ← N4 VULNERABLE
                (CVE-2021-29425)
```

## Expected CVEs (N4 only)

| Dependency | Version | Level | CVEs |
|------------|---------|-------|------|
| `commons-collections` | 3.2.1 | N4 | CVE-2015-6420, CVE-2015-7501 (deserialization RCE) |
| `commons-io` | 2.6 | N4 | CVE-2021-29425 (partial path traversal) |

## Why This Matters

Many SCA tools configure a depth limit for transitive analysis (typically 2-3 levels). This test case verifies whether the tool can reach the 4th level, where critical vulnerabilities can hide in real enterprise projects.

## Demo Code

Each layer implements real functionality that justifies the module's existence:
- **lib-deep**: Collection filtering and path handling
- **lib-middle**: Data processing and extension filtering
- **lib-outer**: High-level file service
- **app**: Application that normalizes and searches files
