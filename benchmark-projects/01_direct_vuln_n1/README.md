# Case 1: Direct Vulnerabilities at Level N1

## Scenario

This project contains **only vulnerabilities in direct dependencies** (first level of the dependency tree). The libraries declared in `pom.xml` have known CVEs, without requiring transitive dependency analysis.

## Benchmark Objective

Validate that the SCA tool can detect vulnerabilities in dependencies declared directly in the build file. This is the most basic scenario and every SCA tool should detect it.

## Dependencies and Expected CVEs

| Dependency | Version | Level | Key CVEs |
|------------|---------|-------|----------|
| `log4j-core` | 2.14.1 | N1 (direct) | CVE-2021-44228 (CVSS 10.0), CVE-2021-45046, CVE-2021-45105 |
| `commons-text` | 1.9 | N1 (direct) | CVE-2022-42889 (CVSS 9.8) |

## Dependency Tree

```
app (pom.xml)
├── log4j-core:2.14.1          ← N1 VULNERABLE (Log4Shell)
│   └── log4j-api:2.14.1       ← N2 (no critical CVEs)
└── commons-text:1.9            ← N1 VULNERABLE (Text4Shell)
    └── commons-lang3:3.12.0    ← N2 (no known CVEs)
```

## Demo Code

`App.java` uses both libraries conventionally:
- **Log4j**: structured logging with parameters
- **Commons Text**: template interpolation with `StringSubstitutor`

The code is designed to pass SAST analysis: there is no direct injection of user input into dangerous patterns. The attack surface lies in the **vulnerable versions** of the libraries.
