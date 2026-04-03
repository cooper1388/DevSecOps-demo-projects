# Case 5: Combined Vulnerabilities at N2 and N3 (Transitive Only)

## Scenario

**Gradle** multi-module project where vulnerabilities are found exclusively at levels **N2 and N3**, with no vulnerability in direct dependencies (N1). This case validates the ability to detect CVEs distributed across multiple transitive levels and also Gradle build system support.

## Benchmark Objective

Validate that the SCA tool:
1. Supports Gradle projects (not just Maven)
2. Detects vulnerabilities at multiple transitive levels simultaneously
3. Can differentiate between N2 and N3 in the same dependency tree
4. Does not generate false positives for internal modules (N1)

## Project Structure

```
05_combined_n2_and_n3/
├── build.gradle            (root build, common config)
├── settings.gradle         (declares modules)
├── lib-data/               (module with vulnerable deps — N3 from app)
│   ├── build.gradle        (jackson-databind:2.9.8, hibernate-validator:6.0.18)
│   └── src/.../JsonMapper.java
├── lib-service/            (module with its own vulnerable deps + lib-data)
│   ├── build.gradle        (snakeyaml:1.30, gson:2.8.6, + lib-data)
│   └── src/.../ConfigLoader.java
└── app/                    (main application)
    ├── build.gradle        (only depends on lib-service)
    └── src/.../App.java
```

## Dependency Tree (from app/ perspective)

```
app (build.gradle)
└── lib-service:1.0.0                          ← N1 CLEAN (internal module)
    ├── snakeyaml:1.30                         ← N2 VULNERABLE
    │   (CVE-2022-1471, CVE-2022-25857, CVE-2022-38749..52)
    ├── gson:2.8.6                             ← N2 VULNERABLE
    │   (CVE-2022-25647)
    └── lib-data:1.0.0                         ← N2 CLEAN (internal module)
        ├── jackson-databind:2.9.8             ← N3 VULNERABLE
        │   (CVE-2019-12086, CVE-2020-36518, CVE-2022-42003, +50 CVEs)
        └─�� hibernate-validator:6.0.18.Final   ← N3 VULNERABLE
            (CVE-2020-10693)
```

## Expected CVEs by Level

### Level N2 (transitives of lib-service)

| Dependency | Version | Key CVEs |
|------------|---------|----------|
| `snakeyaml` | 1.30 | CVE-2022-1471 (RCE), CVE-2022-25857, CVE-2022-38749..52 |
| `gson` | 2.8.6 | CVE-2022-25647 (DoS) |

### Level N3 (transitives of lib-data, via lib-service)

| Dependency | Version | Key CVEs |
|------------|---------|----------|
| `jackson-databind` | 2.9.8 | 50+ deserialization CVEs |
| `hibernate-validator` | 6.0.18.Final | CVE-2020-10693 |

## Demo Code

- **lib-data/JsonMapper.java**: Safe ObjectMapper (no enableDefaultTyping)
- **lib-service/ConfigLoader.java**: YAML parsing + JSON conversion
- **app/App.java**: Loads YAML configuration and converts to JSON
