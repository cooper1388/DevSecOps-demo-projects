# CVE Analysis Report -- 02_vuln_n1_and_n2

**Scan Date:** 2026-04-03
**Tool:** Supply Chain Agentic
**Total CVEs Found:** 61 (28 active, 33 informative)
**Severities:** 4 CRITICAL, 36 HIGH, 20 MEDIUM, 1 LOW

---

## Project Description

Vulnerabilidades en N1 (struts2, xstream) y N2 transitivas

---

## Dependency Summary

| Artifact | Version | Level | CVEs |
|---|---|---|:---:|
| `xstream` | 1.4.17 | N1 | 18 |
| `struts2-core` | 2.5.25 | N1 | 10 |
| `snakeyaml` | 1.17 | N2+ | 8 |
| `ant` | 1.9.7 | N2+ | 4 |
| `guava` | 19.0 | N2+ | 3 |
| `ant` | 1.7.0 | N2+ | 3 |
| `commons-fileupload` | 1.4 | N2+ | 2 |
| `commons-io` | 2.6 | N2+ | 2 |
| `commons-io` | 2.2 | N2+ | 2 |
| `commons-lang3` | 3.8.1 | N2+ | 1 |
| `junit` | 4.10 | N2+ | 1 |
| `junit` | 4.12 | N2+ | 1 |
| `testng` | 6.14.2 | N2+ | 1 |
| `spring` | 2.5.6 | N2+ | 1 |
| `velocity` | 1.6.2 | N2+ | 1 |
| `junit` | 4.11 | N2+ | 1 |
| `commons-io` | 1.4 | N2+ | 1 |
| `commons-lang` | 2.4 | N2+ | 1 |

---

## CVE List

| CVE ID | Severity | Artifact | Description |
|---|---|---|---|
| CVE-2023-50164 | CRITICAL | `struts2-core:2.5.25` | Apache Struts vulnerable to path traversal |
| CVE-2024-53677 | CRITICAL | `struts2-core:2.5.25` | Apache Struts file upload logic is flawed |
| CVE-2020-17530 | CRITICAL | `struts2-core:2.5.25` | Remote code execution in Apache Struts |
| CVE-2021-31805 | CRITICAL | `struts2-core:2.5.25` | Expression Language Injection in Apache Struts |
| CVE-2023-41835 | HIGH | `struts2-core:2.5.25` | Apache Struts Improper Control of Dynamically-Managed Code Resources vulnerabili |
| CVE-2025-68493 | HIGH | `struts2-core:2.5.25` | Apache Struts 2 is Missing XML Validation |
| CVE-2025-66675 | HIGH | `struts2-core:2.5.25` | Apache Struts has a Denial of Service vulnerability |
| CVE-2025-64775 | HIGH | `struts2-core:2.5.25` | Apache Struts is Vulnerable to DoS via File Leak |
| CVE-2021-39153 | HIGH | `xstream:1.4.17` | XStream is vulnerable to an Arbitrary Code Execution attack |
| CVE-2021-39149 | HIGH | `xstream:1.4.17` | XStream is vulnerable to an Arbitrary Code Execution attack |
| CVE-2021-39139 | HIGH | `xstream:1.4.17` | XStream is vulnerable to an Arbitrary Code Execution attack |
| CVE-2021-39154 | HIGH | `xstream:1.4.17` | XStream is vulnerable to an Arbitrary Code Execution attack |
| CVE-2021-39145 | HIGH | `xstream:1.4.17` | XStream is vulnerable to an Arbitrary Code Execution attack |
| CVE-2021-39150 | HIGH | `xstream:1.4.17` | A Server-Side Forgery Request can be activated unmarshalling with XStream to acc |
| CVE-2022-40151 | HIGH | `xstream:1.4.17` | XStream can cause a Denial of Service by injecting deeply nested objects raising |
| CVE-2021-39141 | HIGH | `xstream:1.4.17` | XStream is vulnerable to an Arbitrary Code Execution attack |
| CVE-2021-39147 | HIGH | `xstream:1.4.17` | XStream is vulnerable to an Arbitrary Code Execution attack |
| CVE-2024-47072 | HIGH | `xstream:1.4.17` | XStream is vulnerable to a Denial of Service attack due to stack overflow from a |
| CVE-2021-39151 | HIGH | `xstream:1.4.17` | XStream is vulnerable to an Arbitrary Code Execution attack |
| CVE-2022-41966 | HIGH | `xstream:1.4.17` | XStream can cause Denial of Service via stack overflow |
| CVE-2021-39144 | HIGH | `xstream:1.4.17` | XStream is vulnerable to a Remote Command Execution attack |
| CVE-2021-39146 | HIGH | `xstream:1.4.17` | XStream is vulnerable to an Arbitrary Code Execution attack |
| CVE-2021-39148 | HIGH | `xstream:1.4.17` | XStream is vulnerable to an Arbitrary Code Execution attack |
| CVE-2021-43859 | HIGH | `xstream:1.4.17` | Denial of Service by injecting highly recursive collections or maps in XStream |
| CVE-2021-39152 | HIGH | `xstream:1.4.17` | A Server-Side Forgery Request can be activated unmarshalling with XStream to acc |
| CVE-2023-24998 | HIGH | `commons-fileupload:1.4` | Apache Commons FileUpload denial of service vulnerability |
| CVE-2025-48976 | HIGH | `commons-fileupload:1.4` | Apache Commons FileUpload, Apache Commons FileUpload: FileUpload DoS via part he |
| CVE-2024-47554 | HIGH | `commons-io:2.6` | Apache Commons IO: Possible denial of service attack on untrusted input to XmlSt |
| CVE-2021-29425 | HIGH | `commons-io:2.6` | Path Traversal and Improper Input Validation in Apache Commons IO |
| CVE-2024-47554 | HIGH | `commons-io:2.2` | Apache Commons IO: Possible denial of service attack on untrusted input to XmlSt |
| CVE-2021-29425 | HIGH | `commons-io:2.2` | Path Traversal and Improper Input Validation in Apache Commons IO |
| CVE-2022-4065 | HIGH | `testng:6.14.2` | TestNG is vulnerable to Path Traversal |
| CVE-2020-11979 | HIGH | `ant:1.9.7` | Code injection in Apache Ant |
| CVE-2022-25857 | HIGH | `snakeyaml:1.17` | Uncontrolled Resource Consumption in snakeyaml |
| CVE-2022-1471 | HIGH | `snakeyaml:1.17` | SnakeYaml Constructor Deserialization Remote Code Execution |
| CVE-2017-18640 | HIGH | `snakeyaml:1.17` | SnakeYAML Entity Expansion during load operation |
| CVE-2010-1622 | HIGH | `spring:2.5.6` | Improper Control of Generation of Code ('Code Injection') in Spring Framework |
| CVE-2020-13936 | HIGH | `velocity:1.6.2` | Sandbox Bypass in Apache Velocity Engine |
| CVE-2020-11979 | HIGH | `ant:1.7.0` | Code injection in Apache Ant |
| CVE-2021-29425 | HIGH | `commons-io:1.4` | Path Traversal and Improper Input Validation in Apache Commons IO |
| CVE-2023-34396 | MEDIUM | `struts2-core:2.5.25` | Apache Struts vulnerable to memory exhaustion |
| CVE-2023-34149 | MEDIUM | `struts2-core:2.5.25` | Apache Struts vulnerable to memory exhaustion |
| CVE-2021-39140 | MEDIUM | `xstream:1.4.17` | XStream can cause a Denial of Service |
| CVE-2025-48924 | MEDIUM | `commons-lang3:3.8.1` | Apache Commons Lang is vulnerable to Uncontrolled Recursion when processing long |
| CVE-2020-15250 | MEDIUM | `junit:4.10` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2020-15250 | MEDIUM | `junit:4.12` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2023-2976 | MEDIUM | `guava:19.0` | Guava vulnerable to insecure use of temporary directory |
| CVE-2018-10237 | MEDIUM | `guava:19.0` | Denial of Service in Google Guava |
| CVE-2020-1945 | MEDIUM | `ant:1.9.7` | Sensitive Data Exposure in Apache Ant |
| CVE-2021-36374 | MEDIUM | `ant:1.9.7` | Improper Handling of Length Parameter Inconsistency in Apache Ant |
| CVE-2021-36373 | MEDIUM | `ant:1.9.7` | Improper Handling of Length Parameter Inconsistency in Apache Ant |
| CVE-2022-38751 | MEDIUM | `snakeyaml:1.17` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38752 | MEDIUM | `snakeyaml:1.17` | snakeYAML before 1.32 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38749 | MEDIUM | `snakeyaml:1.17` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38750 | MEDIUM | `snakeyaml:1.17` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-41854 | MEDIUM | `snakeyaml:1.17` | Snakeyaml vulnerable to Stack overflow leading to denial of service |
| CVE-2020-1945 | MEDIUM | `ant:1.7.0` | Sensitive Data Exposure in Apache Ant |
| CVE-2021-36373 | MEDIUM | `ant:1.7.0` | Improper Handling of Length Parameter Inconsistency in Apache Ant |
| CVE-2020-15250 | MEDIUM | `junit:4.11` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2025-48924 | MEDIUM | `commons-lang:2.4` | Apache Commons Lang is vulnerable to Uncontrolled Recursion when processing long |
| CVE-2020-8908 | LOW | `guava:19.0` | Information Disclosure in Guava |
