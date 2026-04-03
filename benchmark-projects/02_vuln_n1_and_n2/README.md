# Case 2: Vulnerabilities at Level N1 (Direct) and N2 (Transitive)

## Scenario

This project contains vulnerabilities **both in direct dependencies (N1) and in their immediate transitive dependencies (N2)**. SCA tools must detect CVEs at both levels of the dependency tree.

## Benchmark Objective

Validate that the SCA tool:
1. Detects CVEs in dependencies declared directly in the pom.xml (N1)
2. Also detects CVEs in the dependencies those libraries bring along (N2)
3. Can differentiate between direct and transitive vulnerabilities

## Dependencies and Expected CVEs

### Level N1 (Direct)

| Dependency | Version | Key CVEs |
|------------|---------|----------|
| `struts2-core` | 2.5.25 | CVE-2020-17530, CVE-2021-31805, CVE-2023-50164 (OGNL injection) |
| `xstream` | 1.4.17 | CVE-2021-39139 to CVE-2021-39154, CVE-2021-43859, CVE-2022-41966 |

### Level N2 (Transitive from struts2-core and xstream)

| Dependency | Parent | Version | CVEs |
|------------|--------|---------|------|
| `commons-fileupload` | struts2-core | 1.4 | CVE-2023-24998 (DoS via part limit) |
| `xpp3_min` | xstream | 1.1.4c | XML Pull Parser family vulnerabilities |

## Dependency Tree

```
app (pom.xml)
├── struts2-core:2.5.25              ← N1 VULNERABLE
│   ├── commons-fileupload:1.4       ← N2 VULNERABLE (CVE-2023-24998)
│   ├── ognl:3.1.29                  ← N2 (potential CVEs)
│   ├── freemarker:2.3.31            ← N2
│   └── commons-lang3:3.12.0         ← N2
└── xstream:1.4.17                   ← N1 VULNERABLE
    ├── xpp3_min:1.1.4c              ← N2 VULNERABLE
    └── xmlpull:1.1.3.1              ← N2
```

## Demo Code

`App.java` uses XStream to serialize/deserialize events in XML. The code:
- Configures `allowTypes` for specific classes (SAST best practice)
- Does not deserialize direct external input
- Vulnerabilities are in the library versions, not in the usage pattern
