# CVE Analysis Report -- 01_direct_vuln_n1

**Scan Date:** 2026-04-03
**Tool:** Supply Chain Agentic
**Total CVEs Found:** 38 (8 active, 30 informative)
**Severities:** 4 CRITICAL, 14 HIGH, 19 MEDIUM, 1 LOW

---

## Project Description

Vulnerabilidades directas de nivel N1 (log4j-core, commons-text)

---

## Dependency Summary

| Artifact | Version | Level | CVEs |
|---|---|---|:---:|
| `snakeyaml` | 1.21 | N2+ | 8 |
| `log4j-core` | 2.14.1 | N1 | 5 |
| `spring-core` | 3.2.17.RELEASE | N2+ | 4 |
| `guava` | 19.0 | N2+ | 3 |
| `ant` | 1.7.0 | N2+ | 3 |
| `spring-beans` | 3.2.17.RELEASE | N1 | 2 |
| `commons-io` | 2.5 | N2+ | 2 |
| `commons-text` | 1.9 | N1 | 1 |
| `commons-lang3` | 3.11 | N2+ | 1 |
| `junit` | 4.13 | N2+ | 1 |
| `testng` | 7.1.0 | N2+ | 1 |
| `junit` | 4.12 | N2+ | 1 |
| `commons-lang3` | 3.4 | N2+ | 1 |
| `velocity` | 1.6.2 | N2+ | 1 |
| `junit` | 4.11 | N2+ | 1 |
| `commons-io` | 1.4 | N2+ | 1 |
| `commons-lang` | 2.4 | N2+ | 1 |
| `junit` | 4.10 | N2+ | 1 |

---

## CVE List

| CVE ID | Severity | Artifact | Description |
|---|---|---|---|
| CVE-2021-45046 | CRITICAL | `log4j-core:2.14.1` | Incomplete fix for Apache Log4j vulnerability |
| CVE-2021-44228 | CRITICAL | `log4j-core:2.14.1` | Remote code injection in Log4j |
| CVE-2022-42889 | CRITICAL | `commons-text:1.9` | Arbitrary code execution in Apache Commons Text |
| CVE-2022-22965 | CRITICAL | `spring-beans:3.2.17.RELEASE` | Remote Code Execution in Spring Framework |
| CVE-2021-44832 | HIGH | `log4j-core:2.14.1` | Improper Input Validation and Injection in Apache Log4j2 |
| CVE-2021-45105 | HIGH | `log4j-core:2.14.1` | Apache Log4j2 vulnerable to Improper Input Validation and Uncontrolled Recursion |
| CVE-2022-22970 | HIGH | `spring-beans:3.2.17.RELEASE` | Denial of service in Spring Framework |
| CVE-2022-4065 | HIGH | `testng:7.1.0` | TestNG is vulnerable to Path Traversal |
| CVE-2022-25857 | HIGH | `snakeyaml:1.21` | Uncontrolled Resource Consumption in snakeyaml |
| CVE-2022-1471 | HIGH | `snakeyaml:1.21` | SnakeYaml Constructor Deserialization Remote Code Execution |
| CVE-2017-18640 | HIGH | `snakeyaml:1.21` | SnakeYAML Entity Expansion during load operation |
| CVE-2024-47554 | HIGH | `commons-io:2.5` | Apache Commons IO: Possible denial of service attack on untrusted input to XmlSt |
| CVE-2021-29425 | HIGH | `commons-io:2.5` | Path Traversal and Improper Input Validation in Apache Commons IO |
| CVE-2018-1272 | HIGH | `spring-core:3.2.17.RELEASE` | Possible privilege escalation in org.springframework:spring-core |
| CVE-2016-5007 | HIGH | `spring-core:3.2.17.RELEASE` | Spring Security and Spring Framework may not recognize certain paths that should |
| CVE-2020-13936 | HIGH | `velocity:1.6.2` | Sandbox Bypass in Apache Velocity Engine |
| CVE-2020-11979 | HIGH | `ant:1.7.0` | Code injection in Apache Ant |
| CVE-2021-29425 | HIGH | `commons-io:1.4` | Path Traversal and Improper Input Validation in Apache Commons IO |
| CVE-2025-68161 | MEDIUM | `log4j-core:2.14.1` | Apache Log4j does not verify the TLS hostname in its Socket Appender |
| CVE-2025-48924 | MEDIUM | `commons-lang3:3.11` | Apache Commons Lang is vulnerable to Uncontrolled Recursion when processing long |
| CVE-2020-15250 | MEDIUM | `junit:4.13` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2023-2976 | MEDIUM | `guava:19.0` | Guava vulnerable to insecure use of temporary directory |
| CVE-2018-10237 | MEDIUM | `guava:19.0` | Denial of Service in Google Guava |
| CVE-2022-38751 | MEDIUM | `snakeyaml:1.21` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38752 | MEDIUM | `snakeyaml:1.21` | snakeYAML before 1.32 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38749 | MEDIUM | `snakeyaml:1.21` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38750 | MEDIUM | `snakeyaml:1.21` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-41854 | MEDIUM | `snakeyaml:1.21` | Snakeyaml vulnerable to Stack overflow leading to denial of service |
| CVE-2020-15250 | MEDIUM | `junit:4.12` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2025-48924 | MEDIUM | `commons-lang3:3.4` | Apache Commons Lang is vulnerable to Uncontrolled Recursion when processing long |
| CVE-2018-1271 | MEDIUM | `spring-core:3.2.17.RELEASE` | Path Traversal in org.springframework:spring-core |
| CVE-2018-1257 | MEDIUM | `spring-core:3.2.17.RELEASE` | Denial of Service in org.springframework:spring-core |
| CVE-2020-1945 | MEDIUM | `ant:1.7.0` | Sensitive Data Exposure in Apache Ant |
| CVE-2021-36373 | MEDIUM | `ant:1.7.0` | Improper Handling of Length Parameter Inconsistency in Apache Ant |
| CVE-2020-15250 | MEDIUM | `junit:4.11` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2025-48924 | MEDIUM | `commons-lang:2.4` | Apache Commons Lang is vulnerable to Uncontrolled Recursion when processing long |
| CVE-2020-15250 | MEDIUM | `junit:4.10` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2020-8908 | LOW | `guava:19.0` | Information Disclosure in Guava |
