# CVE Analysis Report -- 03_transitive_only_n2

**Scan Date:** 2026-04-03
**Tool:** Supply Chain Agentic
**Total CVEs Found:** 100 (52 active, 48 informative)
**Severities:** 11 CRITICAL, 53 HIGH, 25 MEDIUM, 8 LOW

---

## Project Description

Dependencias directas limpias, vulnerabilidades solo en transitivas N2

---

## Dependency Summary

| Artifact | Version | Level | CVEs |
|---|---|---|:---:|
| `tomcat-embed-core` | 9.0.60 | N1 | 25 |
| `snakeyaml` | 1.17 | N2+ | 8 |
| `spring-webmvc` | 5.3.18 | N1 | 7 |
| `snakeyaml` | 1.29 | N2+ | 7 |
| `log4j` | 1.2.12 | N1 | 6 |
| `spring-web` | 5.3.18 | N1 | 6 |
| `log4j` | 1.2.16 | N1 | 6 |
| `logback-core` | 1.2.11 | N2+ | 5 |
| `jackson-databind` | 2.13.2 | N2+ | 3 |
| `spring-context` | 5.3.18 | N2+ | 3 |
| `spring-expression` | 5.3.18 | N2+ | 3 |
| `guava` | 19.0 | N2+ | 3 |
| `commons-collections` | 3.2.1 | N1 | 2 |
| `jackson-core` | 2.13.2 | N2+ | 2 |
| `jackson-databind` | 2.13.2.2 | N2+ | 2 |
| `logback-classic` | 1.2.11 | N2+ | 1 |
| `tomcat-embed-websocket` | 9.0.60 | N2+ | 1 |
| `spring-boot` | 2.6.6 | N2+ | 1 |
| `spring-boot-autoconfigure` | 2.6.6 | N2+ | 1 |
| `spring-beans` | 5.3.18 | N2+ | 1 |
| `spring-core` | 5.3.18 | N2+ | 1 |
| `velocity` | 1.6.2 | N2+ | 1 |
| `commons-lang` | 2.4 | N2+ | 1 |
| `junit` | 4.12 | N2+ | 1 |
| `spring` | 2.5.6 | N2+ | 1 |
| `jakarta.el` | 3.0.3 | N2+ | 1 |
| `junit` | 4.11 | N2+ | 1 |

---

## CVE List

| CVE ID | Severity | Artifact | Description |
|---|---|---|---|
| CVE-2024-56337 | CRITICAL | `tomcat-embed-core:9.0.60` | Apache Tomcat Time-of-check Time-of-use (TOCTOU) Race Condition vulnerability |
| CVE-2024-50379 | CRITICAL | `tomcat-embed-core:9.0.60` | Apache Tomcat Time-of-check Time-of-use (TOCTOU) Race Condition vulnerability |
| CVE-2025-24813 | CRITICAL | `tomcat-embed-core:9.0.60` | Apache Tomcat: Potential RCE and/or information disclosure and/or information co |
| CVE-2025-66614 | CRITICAL | `tomcat-embed-core:9.0.60` | Apache Tomcat - Client certificate verification bypass |
| CVE-2023-20860 | CRITICAL | `spring-webmvc:5.3.18` | Spring Framework is vulnerable to security bypass via mvcRequestMatcher pattern  |
| CVE-2015-7501 | CRITICAL | `commons-collections:3.2.1` | Deserialization of Untrusted Data in Apache commons collections |
| CVE-2019-17571 | CRITICAL | `log4j:1.2.12` | Deserialization of Untrusted Data in Log4j |
| CVE-2022-23305 | CRITICAL | `log4j:1.2.12` | SQL Injection in Log4j 1.2.x |
| CVE-2016-1000027 | CRITICAL | `spring-web:5.3.18` | Pivotal Spring Framework contains unsafe Java deserialization methods |
| CVE-2019-17571 | CRITICAL | `log4j:1.2.16` | Deserialization of Untrusted Data in Log4j |
| CVE-2022-23305 | CRITICAL | `log4j:1.2.16` | SQL Injection in Log4j 1.2.x |
| CVE-2025-53506 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat Coyote vulnerable to Denial of Service via excessive HTTP/2 stream |
| CVE-2025-49124 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat installer for Windows has an untrusted search path vulnerability |
| CVE-2024-24549 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat Denial of Service due to improper input validation vulnerability f |
| CVE-2023-46589 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat Improper Input Validation vulnerability |
| CVE-2025-48989 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat Improper Resource Shutdown or Release vulnerability |
| CVE-2025-46701 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat - CGI security constraint bypass |
| CVE-2025-48988 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat - DoS in multipart upload |
| CVE-2023-24998 | HIGH | `tomcat-embed-core:9.0.60` | Apache Commons FileUpload denial of service vulnerability |
| CVE-2022-42252 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat may reject request containing invalid Content-Length header |
| CVE-2023-41080 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat Open Redirect vulnerability |
| CVE-2023-44487 | HIGH | `tomcat-embed-core:9.0.60` | HTTP/2 Stream Cancellation Attack |
| CVE-2022-45143 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat improperly escapes input from JsonErrorReportValve |
| CVE-2025-49125 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat - Security constraint bypass for pre/post-resources |
| CVE-2024-34750 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat - Denial of Service |
| CVE-2025-55752 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat Vulnerable to Relative Path Traversal |
| CVE-2025-52520 | HIGH | `tomcat-embed-core:9.0.60` | Apache Tomcat Catalina is vulnerable to DoS attack through bypassing of size lim |
| CVE-2024-38816 | HIGH | `spring-webmvc:5.3.18` | Path traversal vulnerability in functional web frameworks |
| CVE-2024-38819 | HIGH | `spring-webmvc:5.3.18` | Spring Framework Path Traversal vulnerability |
| CVE-2024-38828 | HIGH | `spring-webmvc:5.3.18` | Spring MVC controller vulnerable to a DoS attack |
| CVE-2015-6420 | HIGH | `commons-collections:3.2.1` | Insecure Deserialization in Apache Commons Collection |
| CVE-2022-23307 | HIGH | `log4j:1.2.12` | Deserialization of Untrusted Data in Apache Log4j |
| CVE-2021-4104 | HIGH | `log4j:1.2.12` | JMSAppender in Log4j 1.2 is vulnerable to deserialization of untrusted data |
| CVE-2023-26464 | HIGH | `log4j:1.2.12` | Apache Log4j 1.x (EOL) allows Denial of Service (DoS) |
| CVE-2022-23302 | HIGH | `log4j:1.2.12` | Deserialization of Untrusted Data in Log4j 1.x |
| CVE-2024-22262 | HIGH | `spring-web:5.3.18` | Spring Framework URL Parsing with Host Validation |
| CVE-2024-38820 | HIGH | `spring-web:5.3.18` | Spring Framework DataBinder Case Sensitive Match Exception |
| CVE-2024-22243 | HIGH | `spring-web:5.3.18` | Spring Web vulnerable to Open Redirect or Server Side Request Forgery |
| CVE-2024-22259 | HIGH | `spring-web:5.3.18` | Spring Framework URL Parsing with Host Validation Vulnerability |
| CVE-2022-23307 | HIGH | `log4j:1.2.16` | Deserialization of Untrusted Data in Apache Log4j |
| CVE-2021-4104 | HIGH | `log4j:1.2.16` | JMSAppender in Log4j 1.2 is vulnerable to deserialization of untrusted data |
| CVE-2023-26464 | HIGH | `log4j:1.2.16` | Apache Log4j 1.x (EOL) allows Denial of Service (DoS) |
| CVE-2022-23302 | HIGH | `log4j:1.2.16` | Deserialization of Untrusted Data in Log4j 1.x |
| CVE-2023-6378 | HIGH | `logback-classic:1.2.11` | logback serialization vulnerability |
| CVE-2025-52999 | HIGH | `jackson-core:2.13.2` | jackson-core can throw a StackoverflowError when processing deeply nested data |
| CVE-2022-42003 | HIGH | `jackson-databind:2.13.2.2` | Uncontrolled Resource Consumption in Jackson-databind |
| CVE-2022-42004 | HIGH | `jackson-databind:2.13.2.2` | Uncontrolled Resource Consumption in FasterXML jackson-databind |
| CVE-2025-22235 | HIGH | `spring-boot:2.6.6` | Spring Boot EndpointRequest.to() creates wrong matcher if actuator endpoint is n |
| CVE-2023-20883 | HIGH | `spring-boot-autoconfigure:2.6.6` | Spring Boot Welcome Page Denial of Service |
| CVE-2023-6378 | HIGH | `logback-core:1.2.11` | logback serialization vulnerability |
| CVE-2020-36518 | HIGH | `jackson-databind:2.13.2` | Deeply nested json in jackson-databind |
| CVE-2022-42003 | HIGH | `jackson-databind:2.13.2` | Uncontrolled Resource Consumption in Jackson-databind |
| CVE-2022-42004 | HIGH | `jackson-databind:2.13.2` | Uncontrolled Resource Consumption in FasterXML jackson-databind |
| CVE-2022-22970 | HIGH | `spring-beans:5.3.18` | Denial of service in Spring Framework |
| CVE-2025-41249 | HIGH | `spring-core:5.3.18` | Spring Framework annotation detection mechanism may result in improper authoriza |
| CVE-2024-38820 | HIGH | `spring-context:5.3.18` | Spring Framework DataBinder Case Sensitive Match Exception |
| CVE-2022-22968 | HIGH | `spring-context:5.3.18` | Improper handling of case sensitivity in Spring Framework |
| CVE-2022-25857 | HIGH | `snakeyaml:1.29` | Uncontrolled Resource Consumption in snakeyaml |
| CVE-2022-1471 | HIGH | `snakeyaml:1.29` | SnakeYaml Constructor Deserialization Remote Code Execution |
| CVE-2020-13936 | HIGH | `velocity:1.6.2` | Sandbox Bypass in Apache Velocity Engine |
| CVE-2022-25857 | HIGH | `snakeyaml:1.17` | Uncontrolled Resource Consumption in snakeyaml |
| CVE-2022-1471 | HIGH | `snakeyaml:1.17` | SnakeYaml Constructor Deserialization Remote Code Execution |
| CVE-2017-18640 | HIGH | `snakeyaml:1.17` | SnakeYAML Entity Expansion during load operation |
| CVE-2010-1622 | HIGH | `spring:2.5.6` | Improper Control of Generation of Code ('Code Injection') in Spring Framework |
| CVE-2023-42795 | MEDIUM | `tomcat-embed-core:9.0.60` | Apache Tomcat Incomplete Cleanup vulnerability |
| CVE-2023-45648 | MEDIUM | `tomcat-embed-core:9.0.60` | Apache Tomcat Improper Input Validation vulnerability |
| CVE-2026-22737 | MEDIUM | `spring-webmvc:5.3.18` | Spring Framework Improper Path Limitation with Script View Templates |
| CVE-2025-41242 | MEDIUM | `spring-webmvc:5.3.18` | Spring Framework MVC Applications Path Traversal Vulnerability |
| CVE-2024-38809 | MEDIUM | `spring-web:5.3.18` | Spring Framework DoS via conditional HTTP request |
| CVE-2024-23672 | MEDIUM | `tomcat-embed-websocket:9.0.60` | Denial of Service via incomplete cleanup vulnerability in Apache Tomcat |
| CVE-2023-20861 | MEDIUM | `spring-expression:5.3.18` | Spring Framework vulnerable to denial of service via specially crafted SpEL expr |
| CVE-2024-38808 | MEDIUM | `spring-expression:5.3.18` | Spring Framework vulnerable to Denial of Service |
| CVE-2023-20863 | MEDIUM | `spring-expression:5.3.18` | Spring Framework vulnerable to denial of service |
| CVE-2022-38751 | MEDIUM | `snakeyaml:1.29` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38752 | MEDIUM | `snakeyaml:1.29` | snakeYAML before 1.32 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38749 | MEDIUM | `snakeyaml:1.29` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38750 | MEDIUM | `snakeyaml:1.29` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-41854 | MEDIUM | `snakeyaml:1.29` | Snakeyaml vulnerable to Stack overflow leading to denial of service |
| CVE-2025-48924 | MEDIUM | `commons-lang:2.4` | Apache Commons Lang is vulnerable to Uncontrolled Recursion when processing long |
| CVE-2023-2976 | MEDIUM | `guava:19.0` | Guava vulnerable to insecure use of temporary directory |
| CVE-2018-10237 | MEDIUM | `guava:19.0` | Denial of Service in Google Guava |
| CVE-2022-38751 | MEDIUM | `snakeyaml:1.17` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38752 | MEDIUM | `snakeyaml:1.17` | snakeYAML before 1.32 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38749 | MEDIUM | `snakeyaml:1.17` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-38750 | MEDIUM | `snakeyaml:1.17` | snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write |
| CVE-2022-41854 | MEDIUM | `snakeyaml:1.17` | Snakeyaml vulnerable to Stack overflow leading to denial of service |
| CVE-2020-15250 | MEDIUM | `junit:4.12` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2021-28170 | MEDIUM | `jakarta.el:3.0.3` | Improper Input Validation in Jakarta Expression Language |
| CVE-2020-15250 | MEDIUM | `junit:4.11` | TemporaryFolder on unix-like systems does not limit access to created files |
| CVE-2025-61795 | LOW | `tomcat-embed-core:9.0.60` | Apache Tomcat Vulnerable to Improper Resource Shutdown or Release |
| CVE-2026-24733 | LOW | `tomcat-embed-core:9.0.60` | Apache Tomcat - Security constraint bypass with HTTP/0.9 |
| CVE-2025-55754 | LOW | `tomcat-embed-core:9.0.60` | Apache Tomcat Vulnerable to Improper Neutralization of Escape, Meta, or Control  |
| CVE-2026-22735 | LOW | `spring-webmvc:5.3.18` | Spring MVC and WebFlux has Server Sent Event stream corruption |
| CVE-2024-12801 | LOW | `logback-core:1.2.11` | QOS.CH logback-core Server-Side Request Forgery vulnerability |
| CVE-2026-1225 | LOW | `logback-core:1.2.11` | Logback allows an attacker to instantiate classes already present on the class p |
| CVE-2025-22233 | LOW | `spring-context:5.3.18` | Spring Framework DataBinder Case Sensitive Match Exception |
| CVE-2020-8908 | LOW | `guava:19.0` | Information Disclosure in Guava |
| GHSA-72hv-8253-57qq | UNKNOWN | `jackson-core:2.13.2` | jackson-core: Number Length Constraint Bypass in Async Parser Leads to Potential |
| CVE-2025-11226 | UNKNOWN | `logback-core:1.2.11` | QOS.CH logback-core is vulnerable to Arbitrary Code Execution through file proce |
| CVE-2024-12798 | UNKNOWN | `logback-core:1.2.11` | QOS.CH logback-core Expression Language Injection vulnerability |
