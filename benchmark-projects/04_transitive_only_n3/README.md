# Case 4: Vulnerabilities Only at the Third Level (N3)

## Scenario

Multi-module Maven project where vulnerabilities are found **exclusively at the third level (N3)** of the dependency tree. Levels N1 and N2 are clean internal modules (no CVEs). The vulnerable library (`commons-collections:3.2.1`) is hidden 3 levels deep.

## Benchmark Objective

Validate that the SCA tool:
1. Resolves the complete dependency tree of multi-module projects
2. Detects vulnerabilities at deep levels (N3+) of the tree
3. Does not stop analysis at the first or second level

## Project Structure

```
04_transitive_only_n3/
├── pom.xml                 (parent POM)
├── lib-core/               (module with vulnerable deps)
│   ├── pom.xml             (declares commons-collections:3.2.1)
│   └── src/.../DataTransformer.java
├── lib-wrapper/            (facade over lib-core)
│   ├── pom.xml             (only depends on lib-core)
│   └── src/.../DataService.java
└── app/                    (main application)
    ├── pom.xml             (only depends on lib-wrapper)
    └── src/.../App.java
```

## Dependency Tree (from app/ perspective)

```
app (pom.xml)
└── lib-wrapper:1.0.0                       ← N1 CLEAN (internal module)
    └── lib-core:1.0.0                      ← N2 CLEAN (internal module)
        ├── commons-collections:3.2.1       ← N3 VULNERABLE
        │   (CVE-2015-6420, CVE-2015-7501: deserialization RCE)
        └── commons-beanutils:1.9.3         ← N3 VULNERABLE
            (CVE-2014-0114, CVE-2019-10086: property injection)
```

## Expected CVEs (N3 only)

| Dependency | Version | Level | CVEs |
|------------|---------|-------|------|
| `commons-collections` | 3.2.1 | N3 | CVE-2015-6420, CVE-2015-7501 |
| `commons-beanutils` | 1.9.3 | N3 | CVE-2014-0114, CVE-2019-10086 |

## Demo Code

- **lib-core/DataTransformer.java**: Uses `CollectionUtils.collect()` and `BeanUtils.describe()` — legitimate APIs
- **lib-wrapper/DataService.java**: Facade that delegates to DataTransformer
- **app/App.java**: Consumes DataService without knowledge of underlying dependencies

All code passes SAST: no unsafe deserialization patterns or direct injection.
