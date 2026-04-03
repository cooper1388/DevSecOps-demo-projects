# Case 3: Vulnerabilities Only in First-Level Transitives (N2)

## Scenario

The **direct dependencies declared in the pom.xml have no CVEs of their own** — they are Spring Boot starters/aggregators that contain no vulnerable code. However, the **immediate transitive dependencies (N2)** brought in by these starters do contain critical vulnerabilities.

## Benchmark Objective

Validate that the SCA tool:
1. Does not generate false positives for the starters (N1) which are just aggregator POMs
2. DOES detect vulnerabilities in the immediate transitives (N2) that the starters bring in
3. Can resolve the Spring Boot dependency tree to find the actual versions

## Direct Dependencies (N1 — CLEAN)

| Dependency | Version | Direct CVEs |
|------------|---------|-------------|
| `spring-boot-starter-web` | 2.6.6 | 0 (POM aggregator) |
| `spring-boot-starter-validation` | 2.6.6 | 0 (POM aggregator) |

## Vulnerable Transitive Dependencies (N2)

| Dependency | Brought by | Version | CVEs |
|------------|-----------|---------|------|
| `snakeyaml` | starter-web → starter | 1.29 | CVE-2022-1471 (RCE), CVE-2022-25857, CVE-2022-38749..52 |
| `spring-webmvc` | starter-web | 5.3.17 | CVE-2022-22965 (Spring4Shell, CVSS 9.8) |
| `tomcat-embed-core` | starter-web → starter-tomcat | 9.0.60 | Multiple HTTP security CVEs |
| `jackson-databind` | starter-web → starter-json | 2.13.2 | CVE-2020-36518, CVE-2022-42003 |

## Dependency Tree

```
app (pom.xml)
├── spring-boot-starter-web:2.6.6          ← N1 CLEAN (POM only)
│   ├── spring-webmvc:5.3.17               ← N2 VULNERABLE (Spring4Shell)
│   ├── spring-boot-starter-tomcat:2.6.6   ← N2 CLEAN (POM only)
│   │   └── tomcat-embed-core:9.0.60       ← N3 VULNERABLE
│   ├── spring-boot-starter-json:2.6.6     ← N2 CLEAN (POM only)
│   │   └── jackson-databind:2.13.2        ← N3 VULNERABLE
│   └── spring-boot-starter:2.6.6          ← N2 CLEAN (POM only)
│       └── snakeyaml:1.29                 ← N3 VULNERABLE
└── spring-boot-starter-validation:2.6.6   ← N1 CLEAN (POM only)
    └── hibernate-validator:6.2.3.Final    ← N2 (potential CVEs)
```

**Note:** Depending on how the SCA tool counts levels (whether intermediate starters count as a level or not), some vulnerabilities may be classified as N2 or N3. The key point is that **no dependency declared directly in the pom.xml has CVEs**.

## Demo Code

`App.java` implements a basic REST controller with Bean Validation. Completely clean code from a SAST perspective.
