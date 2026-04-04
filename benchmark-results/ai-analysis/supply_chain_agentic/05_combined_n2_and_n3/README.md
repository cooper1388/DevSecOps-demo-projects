# CVE Analysis Report -- 05_combined_n2_and_n3

**Scan Date:** 2026-04-03
**Tool:** Supply Chain Agentic
**Total CVEs Found:** 99 (78 active, 21 informative)
**Severities:** 17 CRITICAL, 59 HIGH, 21 MEDIUM, 1 LOW

---

## Project Description

Gradle multi-module, vulnerabilidades combinadas N2+N3

---

## Dependency Summary

| Artifact | Version | Level | CVEs |
|---|---|---|:---:|
| `jackson-databind` | 2.9.8 | N1 | 53 |
| `snakeyaml` | 1.6 | N2+ | 8 |
| `snakeyaml` | 1.30 | N1 | 7 |
| `log4j` | 1.2.16 | N1 | 6 |
| `log4j` | 1.2.12 | N1 | 6 |
| `hibernate-validator` | 6.0.18.Final | N1 | 3 |
| `jackson-core` | 2.9.8 | N2+ | 3 |
| `guava` | 16.0.1 | N2+ | 3 |
| `commons-collections` | 3.2.1 | N1 | 2 |
| `gson` | 2.8.6 | N1 | 1 |
| `javax.el` | 3.0.1-b09 | N2+ | 1 |
| `velocity` | 1.6.2 | N2+ | 1 |
| `junit` | 4.12 | N2+ | 1 |
| `junit` | 4.8.2 | N2+ | 1 |
| `junit` | 4.11 | N2+ | 1 |
| `junit` | 4.7 | N2+ | 1 |
| `commons-lang` | 2.4 | N2+ | 1 |

---

## CVE List

| CVE ID | Severity | Artifact | Description |
|---|---|---|---|
| CVE-2020-8840 | CRITICAL | `jackson-databind:2.9.8` | Deserialization of Untrusted Data in jackson-databind |
| CVE-2020-9546 | CRITICAL | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2019-14379 | CRITICAL | `jackson-databind:2.9.8` | Deserialization of untrusted data in FasterXML jackson-databind |
| CVE-2019-16335 | CRITICAL | `jackson-databind:2.9.8` | Polymorphic Typing issue in FasterXML jackson-databind |
| CVE-2019-17267 | CRITICAL | `jackson-databind:2.9.8` | Improper Input Validation in jackson-databind |
| CVE-2019-16943 | CRITICAL | `jackson-databind:2.9.8` | jackson-databind polymorphic typing issue |
| CVE-2019-17531 | CRITICAL | `jackson-databind:2.9.8` | jackson-databind polymorphic typing issue |
| CVE-2019-20330 | CRITICAL | `jackson-databind:2.9.8` | Deserialization of Untrusted Data in jackson-databind |
| CVE-2019-14540 | CRITICAL | `jackson-databind:2.9.8` | Polymorphic Typing issue in FasterXML jackson-databind |
| CVE-2019-16942 | CRITICAL | `jackson-databind:2.9.8` | Polymorphic Typing in FasterXML jackson-databind |
| CVE-2020-9548 | CRITICAL | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2020-9547 | CRITICAL | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2019-17571 | CRITICAL | `log4j:1.2.16` | Deserialization of Untrusted Data in Log4j |
| CVE-2022-23305 | CRITICAL | `log4j:1.2.16` | SQL Injection in Log4j 1.2.x |
| CVE-2015-7501 | CRITICAL | `commons-collections:3.2.1` | Deserialization of Untrusted Data in Apache commons collections |
| CVE-2019-17571 | CRITICAL | `log4j:1.2.12` | Deserialization of Untrusted Data in Log4j |
| CVE-2022-23305 | CRITICAL | `log4j:1.2.12` | SQL Injection in Log4j 1.2.x |
| CVE-2020-11619 | HIGH | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2020-25649 | HIGH | `jackson-databind:2.9.8` | XML External Entity (XXE) Injection in Jackson Databind |
| CVE-2020-36518 | HIGH | `jackson-databind:2.9.8` | Deeply nested json in jackson-databind |
| CVE-2020-11112 | HIGH | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2021-20190 | HIGH | `jackson-databind:2.9.8` | Deserialization of untrusted data in jackson-databind |
| CVE-2020-35728 | HIGH | `jackson-databind:2.9.8` | Serialization gadget exploit in jackson-databind |
| CVE-2019-12086 | HIGH | `jackson-databind:2.9.8` | Information exposure in FasterXML jackson-databind |
| CVE-2020-10969 | HIGH | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2020-36182 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2020-36180 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2020-36185 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2020-10672 | HIGH | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2020-36179 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2020-36183 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2020-11113 | HIGH | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2020-14062 | HIGH | `jackson-databind:2.9.8` | Deserialization of untrusted data in Jackson Databind |
| CVE-2020-14061 | HIGH | `jackson-databind:2.9.8` | Deserialization of untrusted data in Jackson Databind |
| CVE-2019-14892 | HIGH | `jackson-databind:2.9.8` | Polymorphic deserialization of malicious object in jackson-databind |
| CVE-2019-12814 | HIGH | `jackson-databind:2.9.8` | Deserialization of untrusted data in FasterXML jackson-databind |
| CVE-2020-36181 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2020-36188 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2020-10673 | HIGH | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2019-14439 | HIGH | `jackson-databind:2.9.8` | Deserialization of untrusted data in FasterXML jackson-databind |
| CVE-2020-24616 | HIGH | `jackson-databind:2.9.8` | Code Injection in jackson-databind |
| CVE-2020-11620 | HIGH | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2020-14060 | HIGH | `jackson-databind:2.9.8` | Deserialization of untrusted data in Jackson Databind |
| CVE-2022-42003 | HIGH | `jackson-databind:2.9.8` | Uncontrolled Resource Consumption in Jackson-databind |
| CVE-2020-36184 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2020-14195 | HIGH | `jackson-databind:2.9.8` | Deserialization of untrusted data in Jackson Databind |
| CVE-2019-12384 | HIGH | `jackson-databind:2.9.8` | Deserialization of Untrusted Data in FasterXML jackson-databind |
| CVE-2020-24750 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2019-14893 | HIGH | `jackson-databind:2.9.8` | Polymorphic deserialization of malicious object in jackson-databind |
| CVE-2020-35491 | HIGH | `jackson-databind:2.9.8` | Serialization gadgets exploit in jackson-databind |
| CVE-2020-36187 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2020-10968 | HIGH | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2022-42004 | HIGH | `jackson-databind:2.9.8` | Uncontrolled Resource Consumption in FasterXML jackson-databind |
| CVE-2020-10650 | HIGH | `jackson-databind:2.9.8` | jackson-databind vulnerable to unsafe deserialization |
| CVE-2020-11111 | HIGH | `jackson-databind:2.9.8` | jackson-databind mishandles the interaction between serialization gadgets and ty |
| CVE-2020-36186 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2020-36189 | HIGH | `jackson-databind:2.9.8` | Unsafe Deserialization in jackson-databind |
| CVE-2020-35490 | HIGH | `jackson-databind:2.9.8` | Serialization gadgets exploit in jackson-databind |
| CVE-2025-35036 | HIGH | `hibernate-validator:6.0.18.Final` | Hibernate Validator may interpolate user-supplied input in a constraint violatio |
| CVE-2022-25857 | HIGH | `snakeyaml:1.30` | Uncontrolled Resource Consumption in snakeyaml |
| CVE-2022-1471 | HIGH | `snakeyaml:1.30` | SnakeYaml Constructor Deserialization Remote Code Execution |
| CVE-2022-25647 | HIGH | `gson:2.8.6` | Deserialization of Untrusted Data in Gson |
| CVE-2022-23307 | HIGH | `log4j:1.2.16` | Deserialization of Untrusted Data in Apache Log4j |
| CVE-2021-4104 | HIGH | `log4j:1.2.16` | JMSAppender in Log4j 1.2 is vulnerable to deserialization of untrusted data |
| CVE-2023-26464 | HIGH | `log4j:1.2.16` | Apache Log4j 1.x (EOL) allows Denial of Service (DoS) |
| CVE-2022-23302 | HIGH | `log4j:1.2.16` | Deserialization of Untrusted Data in Log4j 1.x |
| CVE-2015-6420 | HIGH | `commons-collections:3.2.1` | Insecure Deserialization in Apache Commons Collection |
| CVE-2022-23307 | HIGH | `log4j:1.2.12` | Deserialization of Untrusted Data in Apache Log4j |
| CVE-2021-4104 | HIGH | `log4j:1.2.12` | JMSAppender in Log4j 1.2 is vulnerable to deserialization of untrusted data |
| CVE-2023-26464 | HIGH | `log4j:1.2.12` | Apache Log4j 1.x (EOL) allows Denial of Service (DoS) |
| CVE-2022-23302 | HIGH | `log4j:1.2.12` | Deserialization of Untrusted Data in Log4j 1.x |
| CVE-2025-52999 | HIGH | `jackson-core:2.9.8` | jackson-core can throw a StackoverflowError when processing deeply nested data |
| CVE-2020-13936 | HIGH | `velocity:1.6.2` | Sandbox Bypass in Apache Velocity Engine |
| CVE-2022-25857 | HIGH | `snakeyaml:1.6` | Uncontrolled Resource Consumption in snakeyaml |
| CVE-2022-1471 | HIGH | `snakeyaml:1.6` | SnakeYaml Constructor Deserialization Remote Code Execution |
| CVE-2017-18640 | HIGH | `snakeyaml:1.6` | SnakeYAML Entity Expansion during load operation |
| CVE-2020-10693 | MEDIUM | `hibernate-validator:6.0.18.Final` | Improper Input Validation in Hibernate Validator |
| CVE-2023-1932 | MEDIUM | `hibernate-validator:6.0.18.Final` | hibernate-validator Cross-site Scripting vulnerability |
| CVE-2022-38751 | MEDIUM | `snakeyaml:1.30` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38752 | MEDIUM | `snakeyaml:1.30` | snakeYAML before 1.32 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38749 | MEDIUM | `snakeyaml:1.30` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38750 | MEDIUM | `snakeyaml:1.30` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-41854 | MEDIUM | `snakeyaml:1.30` | Snakeyaml vulnerable to Stack overflow leading to denial of service |
| CVE-2025-49128 | MEDIUM | `jackson-core:2.9.8` | Jackson-core Vulnerable to Memory Disclosure via Source Snippet in JsonLocation |
| CVE-2021-28170 | MEDIUM | `javax.el:3.0.1-b09` | Improper Input Validation in Jakarta Expression Language |
| CVE-2020-15250 | MEDIUM | `junit:4.12` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2022-38751 | MEDIUM | `snakeyaml:1.6` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38752 | MEDIUM | `snakeyaml:1.6` | snakeYAML before 1.32 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38749 | MEDIUM | `snakeyaml:1.6` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38750 | MEDIUM | `snakeyaml:1.6` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-41854 | MEDIUM | `snakeyaml:1.6` | Snakeyaml vulnerable to Stack overflow leading to denial of service |
| CVE-2023-2976 | MEDIUM | `guava:16.0.1` | Guava vulnerable to insecure use of temporary directory |
| CVE-2018-10237 | MEDIUM | `guava:16.0.1` | Denial of Service in Google Guava |
| CVE-2020-15250 | MEDIUM | `junit:4.8.2` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2020-15250 | MEDIUM | `junit:4.11` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2020-15250 | MEDIUM | `junit:4.7` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2025-48924 | MEDIUM | `commons-lang:2.4` | Apache Commons Lang is vulnerable to Uncontrolled Recursion when processing long |
| CVE-2020-8908 | LOW | `guava:16.0.1` | Information Disclosure in Guava |
| GHSA-72hv-8253-57qq | UNKNOWN | `jackson-core:2.9.8` | jackson-core: Number Length Constraint Bypass in Async Parser Leads to Potential |
