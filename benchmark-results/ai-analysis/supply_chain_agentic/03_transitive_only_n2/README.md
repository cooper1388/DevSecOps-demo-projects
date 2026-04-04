# CVE Analysis Report — 03_transitive_only_n2

**Scan Date:** 2026-04-03  
**Tool:** Supply Chain Agentic Pipeline v2  
**LLM:** gpt-4.1-nano (fast) / gpt-4.1-mini (reason) / gpt-4.1 (critical)  
**Total CVEs Found:** 60  
**Severities:** 5 CRITICAL · 34 HIGH · 12 MEDIUM · 7 LOW  
**Scan Time:** 40.8s

---

## Project Description

Proyecto Maven donde las dependencias directas son starters/aggregators limpios (spring-boot-starter-web/validation), pero sus transitivas N2 tienen CVEs criticas (tomcat, snakeyaml, spring-webmvc).

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `tomcat-embed-core` | 9.0.60 | N1 | 25 |
| `spring-web` | 5.3.18 | N1 | 6 |
| `logback-classic` | 1.2.11 | N1 | 1 |
| `logback-core` | 1.2.11 | N2 | 4 |
| `jackson-core` | 2.13.2 | N1 | 1 |
| `jackson-databind` | 2.13.2.2 | N1 | 2 |
| `jackson-databind` | 2.13.2 | N2 | 1 |
| `tomcat-embed-websocket` | 9.0.60 | N1 | 1 |
| `spring-boot` | 2.6.6 | N1 | 1 |
| `spring-context` | 5.3.18 | N2 | 2 |
| `spring-boot-autoconfigure` | 2.6.6 | N1 | 1 |
| `snakeyaml` | 1.29 | N2 | 7 |
| `spring-webmvc` | 5.3.18 | N1 | 7 |
| `jakarta.el` | 3.0.3 | N2 | 1 |

---

## CVE Detail

### org.apache.tomcat.embed : tomcat-embed-core : 9.0.60

#### CVE-2025-53506 — HIGH — dos
- **Tipo:** dos
- **Descripcion:** Apache Tomcat Coyote vulnerable to Denial of Service via excessive HTTP/2 streams
- **Impacto:** Apache Tomcat Coyote vulnerable to Denial of Service via excessive HTTP/2 streams
- **Remediacion:** Actualizar a `tomcat-embed-core:11.0.9`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-53506

#### CVE-2024-56337 — CRITICAL — general
- **Tipo:** general
- **Descripcion:** Apache Tomcat Time-of-check Time-of-use (TOCTOU) Race Condition vulnerability
- **Impacto:** Apache Tomcat Time-of-check Time-of-use (TOCTOU) Race Condition vulnerability
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.98`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-56337

#### CVE-2025-49124 — HIGH — general
- **Tipo:** general
- **Descripcion:** Apache Tomcat installer for Windows has an untrusted search path vulnerability
- **Impacto:** Apache Tomcat installer for Windows has an untrusted search path vulnerability
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.106`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-49124

#### CVE-2024-50379 — CRITICAL — general — Exploit publico
- **Tipo:** general
- **Descripcion:** Apache Tomcat Time-of-check Time-of-use (TOCTOU) Race Condition vulnerability
- **Impacto:** Apache Tomcat Time-of-check Time-of-use (TOCTOU) Race Condition vulnerability
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.98`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-50379

#### CVE-2024-24549 — HIGH — dos, input_validation — Exploit publico
- **Tipo:** dos, input_validation
- **Descripcion:** Apache Tomcat Denial of Service due to improper input validation vulnerability for HTTP/2 requests
- **Impacto:** Apache Tomcat Denial of Service due to improper input validation vulnerability for HTTP/2 requests
- **Remediacion:** Actualizar a `tomcat-embed-core:11.0.0-M17`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-24549

#### CVE-2025-24813 — CRITICAL — rce, info_disclosure — Exploit publico
- **Tipo:** rce, info_disclosure
- **Descripcion:** Apache Tomcat: Potential RCE and/or information disclosure and/or information corruption with partial PUT
- **Impacto:** Apache Tomcat: Potential RCE and/or information disclosure and/or information corruption with partial PUT
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.99`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-24813

#### CVE-2023-46589 — HIGH — input_validation
- **Tipo:** input_validation
- **Descripcion:** Apache Tomcat Improper Input Validation vulnerability
- **Impacto:** Apache Tomcat Improper Input Validation vulnerability
- **Remediacion:** Actualizar a `tomcat-embed-core:8.5.96`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-46589

#### CVE-2025-66614 — CRITICAL — auth_bypass
- **Tipo:** auth_bypass
- **Descripcion:** Apache Tomcat - Client certificate verification bypass
- **Impacto:** Apache Tomcat - Client certificate verification bypass
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.113`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-66614

#### CVE-2023-42795 — MEDIUM — general
- **Tipo:** general
- **Descripcion:** Apache Tomcat Incomplete Cleanup vulnerability
- **Impacto:** Apache Tomcat Incomplete Cleanup vulnerability
- **Remediacion:** Actualizar a `tomcat-embed-core:8.5.94`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-42795

#### CVE-2025-48989 — HIGH — rce, input_validation
- **Tipo:** rce, input_validation
- **Descripcion:** Apache Tomcat Improper Resource Shutdown or Release vulnerability
- **Impacto:** Apache Tomcat Improper Resource Shutdown or Release vulnerability
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.108`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-48989

#### CVE-2025-46701 — HIGH — auth_bypass — Exploit publico
- **Tipo:** auth_bypass
- **Descripcion:** Apache Tomcat - CGI security constraint bypass
- **Impacto:** Apache Tomcat - CGI security constraint bypass
- **Remediacion:** Actualizar a `tomcat-embed-core:11.0.7`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-46701

#### CVE-2025-48988 — HIGH — dos — Exploit publico
- **Tipo:** dos
- **Descripcion:** Apache Tomcat - DoS in multipart upload
- **Impacto:** Apache Tomcat - DoS in multipart upload
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.106`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-48988

#### CVE-2023-24998 — HIGH — dos — Exploit publico
- **Tipo:** dos
- **Descripcion:** Apache Commons FileUpload denial of service vulnerability
- **Impacto:** Apache Commons FileUpload denial of service vulnerability
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.71`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-24998

#### CVE-2025-61795 — LOW — rce, input_validation
- **Tipo:** rce, input_validation
- **Descripcion:** Apache Tomcat Vulnerable to Improper Resource Shutdown or Release
- **Impacto:** Apache Tomcat Vulnerable to Improper Resource Shutdown or Release
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.110`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-61795

#### CVE-2022-42252 — HIGH — general
- **Tipo:** general
- **Descripcion:** Apache Tomcat may reject request containing invalid Content-Length header
- **Impacto:** Apache Tomcat may reject request containing invalid Content-Length header
- **Remediacion:** Actualizar a `tomcat-embed-core:10.1.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42252

#### CVE-2023-41080 — HIGH — general — Exploit publico
- **Tipo:** general
- **Descripcion:** Apache Tomcat Open Redirect vulnerability
- **Impacto:** Apache Tomcat Open Redirect vulnerability
- **Remediacion:** Actualizar a `tomcat-embed-core:11.0.0-M11`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-41080

#### CVE-2023-44487 — HIGH — general — Exploit publico
- **Tipo:** general
- **Descripcion:** HTTP/2 Stream Cancellation Attack
- **Impacto:** HTTP/2 Stream Cancellation Attack
- **Remediacion:** Actualizar a `tomcat-embed-core:10.5.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-44487

#### CVE-2026-24733 — LOW — auth_bypass
- **Tipo:** auth_bypass
- **Descripcion:** Apache Tomcat - Security constraint bypass with HTTP/0.9
- **Impacto:** Apache Tomcat - Security constraint bypass with HTTP/0.9
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.113`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2026-24733

#### CVE-2023-45648 — MEDIUM — input_validation
- **Tipo:** input_validation
- **Descripcion:** Apache Tomcat Improper Input Validation vulnerability
- **Impacto:** Apache Tomcat Improper Input Validation vulnerability
- **Remediacion:** Actualizar a `tomcat-embed-core:8.5.94`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-45648

#### CVE-2022-45143 — HIGH — input_validation
- **Tipo:** input_validation
- **Descripcion:** Apache Tomcat improperly escapes input from JsonErrorReportValve
- **Impacto:** Apache Tomcat improperly escapes input from JsonErrorReportValve
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.69`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-45143

#### CVE-2025-55754 — LOW — input_validation
- **Tipo:** input_validation
- **Descripcion:** Apache Tomcat Vulnerable to Improper Neutralization of Escape, Meta, or Control Sequences
- **Impacto:** Apache Tomcat Vulnerable to Improper Neutralization of Escape, Meta, or Control Sequences
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.109`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-55754

#### CVE-2025-49125 — HIGH — rce, auth_bypass — Exploit publico
- **Tipo:** rce, auth_bypass
- **Descripcion:** Apache Tomcat - Security constraint bypass for pre/post-resources
- **Impacto:** Apache Tomcat - Security constraint bypass for pre/post-resources
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.106`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-49125

#### CVE-2024-34750 — HIGH — dos
- **Tipo:** dos
- **Descripcion:** Apache Tomcat - Denial of Service
- **Impacto:** Apache Tomcat - Denial of Service
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.90`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-34750

#### CVE-2025-55752 — HIGH — path_traversal — Exploit publico
- **Tipo:** path_traversal
- **Descripcion:** Apache Tomcat Vulnerable to Relative Path Traversal
- **Impacto:** Apache Tomcat Vulnerable to Relative Path Traversal
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.109`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-55752

#### CVE-2025-52520 — HIGH — dos, auth_bypass
- **Tipo:** dos, auth_bypass
- **Descripcion:** Apache Tomcat Catalina is vulnerable to DoS attack through bypassing of size limits
- **Impacto:** Apache Tomcat Catalina is vulnerable to DoS attack through bypassing of size limits
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.107`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-52520

### org.springframework : spring-web : 5.3.18

#### CVE-2024-38809 — MEDIUM — dos
- **Tipo:** dos
- **Descripcion:** Spring Framework DoS via conditional HTTP request
- **Impacto:** Spring Framework DoS via conditional HTTP request
- **Remediacion:** Actualizar a `spring-web:6.1.12`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-38809

#### CVE-2024-22262 — HIGH — general — Exploit publico
- **Tipo:** general
- **Descripcion:** Spring Framework URL Parsing with Host Validation
- **Impacto:** Spring Framework URL Parsing with Host Validation
- **Remediacion:** Actualizar a `spring-web:6.1.6`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-22262

#### CVE-2024-38820 — HIGH — general — Exploit publico
- **Tipo:** general
- **Descripcion:** Spring Framework DataBinder Case Sensitive Match Exception
- **Impacto:** Spring Framework DataBinder Case Sensitive Match Exception
- **Remediacion:** Actualizar a `spring-web:6.1.14`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-38820

#### CVE-2016-1000027 — CRITICAL — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Pivotal Spring Framework contains unsafe Java deserialization methods
- **Impacto:** Pivotal Spring Framework contains unsafe Java deserialization methods
- **Remediacion:** Actualizar a `spring-web:6.0.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2016-1000027

#### CVE-2024-22243 — HIGH — general — Exploit publico
- **Tipo:** general
- **Descripcion:** Spring Web vulnerable to Open Redirect or Server Side Request Forgery
- **Impacto:** Spring Web vulnerable to Open Redirect or Server Side Request Forgery
- **Remediacion:** Actualizar a `spring-web:5.3.32`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-22243

#### CVE-2024-22259 — HIGH — general
- **Tipo:** general
- **Descripcion:** Spring Framework URL Parsing with Host Validation Vulnerability
- **Impacto:** Spring Framework URL Parsing with Host Validation Vulnerability
- **Remediacion:** Actualizar a `spring-web:5.3.33`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-22259

### ch.qos.logback : logback-classic : 1.2.11

#### CVE-2023-6378 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** logback serialization vulnerability
- **Remediacion:** Actualizar a `logback-classic:1.2.13`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-6378

### ch.qos.logback : logback-core : 1.2.11

#### CVE-2025-11226 — UNKNOWN — Transitive
- **Tipo:** Transitive
- **Descripcion:** QOS.CH logback-core is vulnerable to Arbitrary Code Execution through file processing
- **Remediacion:** Actualizar a `logback-core:1.3.16`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-11226

#### CVE-2024-12801 — LOW — Transitive
- **Tipo:** Transitive
- **Descripcion:** QOS.CH logback-core Server-Side Request Forgery vulnerability
- **Remediacion:** Actualizar a `logback-core:1.3.15`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-12801

#### CVE-2024-12798 — UNKNOWN — Transitive
- **Tipo:** Transitive
- **Descripcion:** QOS.CH logback-core Expression Language Injection vulnerability
- **Remediacion:** Actualizar a `logback-core:1.3.15`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-12798

#### CVE-2026-1225 — LOW — Transitive
- **Tipo:** Transitive
- **Descripcion:** Logback allows an attacker to instantiate classes already present on the class path
- **Remediacion:** Actualizar a `logback-core:1.5.25`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2026-1225

### com.fasterxml.jackson.core : jackson-core : 2.13.2

#### CVE-2025-52999 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** jackson-core can throw a StackoverflowError when processing deeply nested data
- **Remediacion:** Actualizar a `jackson-core:2.15.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-52999

### com.fasterxml.jackson.core : jackson-databind : 2.13.2.2

#### CVE-2022-42003 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Uncontrolled Resource Consumption in Jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.13.4.2`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42003

#### CVE-2022-42004 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Uncontrolled Resource Consumption in FasterXML jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.13.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42004

### com.fasterxml.jackson.core : jackson-databind : 2.13.2

#### CVE-2020-36518 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Deeply nested json in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.12.6.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36518

### org.apache.tomcat.embed : tomcat-embed-websocket : 9.0.60

#### CVE-2024-23672 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** Denial of Service via incomplete cleanup vulnerability in Apache Tomcat
- **Remediacion:** Actualizar a `tomcat-embed-websocket:8.5.99`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-23672

### org.springframework.boot : spring-boot : 2.6.6

#### CVE-2025-22235 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Spring Boot EndpointRequest.to() creates wrong matcher if actuator endpoint is not exposed
- **Remediacion:** Actualizar a `spring-boot:3.4.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-22235

### org.springframework : spring-context : 5.3.18

#### CVE-2025-22233 — LOW — Transitive
- **Tipo:** Transitive
- **Descripcion:** Spring Framework DataBinder Case Sensitive Match Exception
- **Remediacion:** Actualizar a `spring-context:6.1.20`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-22233

#### CVE-2022-22968 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Improper handling of case sensitivity in Spring Framework
- **Remediacion:** Actualizar a `spring-context:5.2.21.RELEASE`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-22968

### org.springframework.boot : spring-boot-autoconfigure : 2.6.6

#### CVE-2023-20883 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Spring Boot Welcome Page Denial of Service
- **Remediacion:** Actualizar a `spring-boot-autoconfigure:2.5.15`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-20883

### org.yaml : snakeyaml : 1.29

#### CVE-2022-25857 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Uncontrolled Resource Consumption in snakeyaml
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-25857

#### CVE-2022-38751 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38751

#### CVE-2022-38752 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** snakeYAML before 1.32 vulnerable to Denial of Service due to Out-of-bounds Write
- **Remediacion:** Actualizar a `snakeyaml:1.32`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38752

#### CVE-2022-38749 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38749

#### CVE-2022-38750 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38750

#### CVE-2022-1471 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** SnakeYaml Constructor Deserialization Remote Code Execution
- **Remediacion:** Actualizar a `snakeyaml:2.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-1471

#### CVE-2022-41854 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** Snakeyaml vulnerable to Stack overflow leading to denial of service
- **Remediacion:** Actualizar a `snakeyaml:1.32`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-41854

### org.springframework : spring-webmvc : 5.3.18

#### CVE-2026-22737 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** Spring Framework Improper Path Limitation with Script View Templates
- **Remediacion:** Actualizar a `spring-webmvc:6.2.17`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2026-22737

#### CVE-2026-22735 — LOW — Transitive
- **Tipo:** Transitive
- **Descripcion:** Spring MVC and WebFlux has Server Sent Event stream corruption
- **Remediacion:** Actualizar a `spring-webmvc:6.2.17`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2026-22735

#### CVE-2023-20860 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Spring Framework is vulnerable to security bypass via mvcRequestMatcher pattern mismatch
- **Remediacion:** Actualizar a `spring-webmvc:5.3.26`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-20860

#### CVE-2024-38816 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Path traversal vulnerability in functional web frameworks
- **Remediacion:** Actualizar a `spring-webmvc:6.1.13`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-38816

#### CVE-2024-38819 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Spring Framework Path Traversal vulnerability
- **Remediacion:** Actualizar a `spring-webmvc:6.1.14`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-38819

#### CVE-2025-41242 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** Spring Framework MVC Applications Path Traversal Vulnerability
- **Remediacion:** Actualizar a `spring-webmvc:6.2.10`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-41242

#### CVE-2024-38828 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Spring MVC controller vulnerable to a DoS attack
- **Remediacion:** Actualizar a `spring-webmvc:5.3.42`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-38828

### org.glassfish : jakarta.el : 3.0.3

#### CVE-2021-28170 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** Improper Input Validation in Jakarta Expression Language
- **Remediacion:** Actualizar a `jakarta.el:3.0.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-28170

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `tomcat-embed-core` | 9.0.60 | **9.0.99** |
| `spring-web` | 5.3.18 | **6.1.6** |
| `logback-classic` | 1.2.11 | **1.2.13** |
| `logback-core` | 1.2.11 | **1.5.25** |
| `jackson-core` | 2.13.2 | **2.15.0** |
| `jackson-databind` | 2.13.2 | **2.12.6.1** |
| `tomcat-embed-websocket` | 9.0.60 | **8.5.99** |
| `spring-boot` | 2.6.6 | **3.4.5** |
| `spring-context` | 5.3.18 | **6.1.20** |
| `spring-boot-autoconfigure` | 2.6.6 | **2.5.15** |
| `snakeyaml` | 1.29 | **2.0** |
| `spring-webmvc` | 5.3.18 | **6.2.17** |
| `jakarta.el` | 3.0.3 | **3.0.4** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **40.8s** |
| CVEs Detected | 60 |
| Artifacts Analyzed | 14 |
| Depth | N0→N4 |
