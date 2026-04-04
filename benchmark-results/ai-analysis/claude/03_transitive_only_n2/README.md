# CVE Analysis Report — 03_transitive_only_n2

**Scan Date:** 2026-04-03  
**Tool:** Claude Opus 4  
**Analyst:** Claude Opus 4 via Claude Code  
**Method:** LLM-based CVE knowledge lookup per dependency version  
**Total CVEs Found:** 30  
**Severities:** 5 CRITICAL · 16 HIGH · 9 MEDIUM  
**Scan Time:** 0s

---

## Project Description

Proyecto Maven donde las dependencias directas son starters/aggregators limpios (spring-boot-starter-web/validation), pero sus transitivas N2 tienen CVEs criticas (tomcat, snakeyaml, spring-webmvc).

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `tomcat-embed-core` | 9.0.60 | N2 | 16 |
| `spring-webmvc` | 5.3.18 | N2 | 1 |
| `spring-web` | 5.3.18 | N2 | 2 |
| `snakeyaml` | 1.29 | N2 | 7 |
| `jackson-databind` | 2.13.2.2 | N2 | 2 |
| `logback-classic` | 1.2.11 | N2 | 1 |
| `logback-core` | 1.2.11 | N2 | 1 |

---

## CVE Detail

### org.apache.tomcat.embed : tomcat-embed-core : 9.0.60

#### CVE-2022-22965 — CRITICAL — RCE via ClassLoader
- **Tipo:** RCE via ClassLoader
- **Descripcion:** Spring4Shell: ClassLoader manipulation via data binding on JDK 9+
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.62`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-22965

#### CVE-2022-42252 — MEDIUM — Request Smuggling
- **Tipo:** Request Smuggling
- **Descripcion:** Tomcat does not reject invalid Content-Length
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.69`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42252

#### CVE-2022-45143 — MEDIUM — XSS via JsonErrorReportValve
- **Tipo:** XSS via JsonErrorReportValve
- **Descripcion:** Unescaped JSON output in error reports
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.69`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-45143

#### CVE-2023-41080 — MEDIUM — Open Redirect
- **Tipo:** Open Redirect
- **Descripcion:** Open redirect via FormAuthenticator when redirect configured
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.80`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-41080

#### CVE-2023-28709 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** Incomplete fix for CVE-2023-24998 in Apache Tomcat
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.74`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-28709

#### CVE-2023-28708 — MEDIUM — Session Fixation
- **Tipo:** Session Fixation
- **Descripcion:** Missing Secure attribute in JSESSIONID cookie on HTTPS
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.74`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-28708

#### CVE-2023-45648 — HIGH — Request Smuggling
- **Tipo:** Request Smuggling
- **Descripcion:** Trailer header parsing does not match HTTP/1.1 spec
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.81`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-45648

#### CVE-2023-42795 — HIGH — Information Disclosure
- **Tipo:** Information Disclosure
- **Descripcion:** Incomplete cleanup in internal recycling may leak data
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.81`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-42795

#### CVE-2023-46589 — HIGH — Request Smuggling
- **Tipo:** Request Smuggling
- **Descripcion:** HTTP trailer header exceeding limits not properly handled
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.84`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-46589

#### CVE-2023-44487 — HIGH — DoS via HTTP/2
- **Tipo:** DoS via HTTP/2
- **Descripcion:** Rapid Reset Attack: HTTP/2 rapid stream resets cause DoS
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.81`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-44487

#### CVE-2024-23672 — HIGH — DoS via WebSocket
- **Tipo:** DoS via WebSocket
- **Descripcion:** WebSocket client can keep connections open indefinitely
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.86`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-23672

#### CVE-2024-24549 — HIGH — DoS via HTTP/2
- **Tipo:** DoS via HTTP/2
- **Descripcion:** HTTP/2 header excess can cause OutOfMemoryError
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.86`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-24549

#### CVE-2024-34750 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** Connection not released on HTTP/2 stream error
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.90`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-34750

#### CVE-2024-50379 — CRITICAL — RCE / TOCTOU
- **Tipo:** RCE / TOCTOU
- **Descripcion:** TOCTOU race condition in JSP compilation on case-insensitive FS
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.98`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-50379

#### CVE-2024-52316 — CRITICAL — Auth Bypass
- **Tipo:** Auth Bypass
- **Descripcion:** Jakarta Authentication bypass when authenticator fails without exception
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.96`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-52316

#### CVE-2024-56337 — HIGH — RCE / TOCTOU followup
- **Tipo:** RCE / TOCTOU followup
- **Descripcion:** Mitigation for CVE-2024-50379 requires additional config
- **Remediacion:** Actualizar a `tomcat-embed-core:9.0.98`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-56337

### org.springframework : spring-webmvc : 5.3.18

#### CVE-2022-22965 — CRITICAL — RCE via ClassLoader
- **Tipo:** RCE via ClassLoader
- **Descripcion:** Spring4Shell via ClassLoader manipulation
- **Remediacion:** Actualizar a `spring-webmvc:5.3.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-22965

### org.springframework : spring-web : 5.3.18

#### CVE-2024-38816 — HIGH — Path Traversal
- **Tipo:** Path Traversal
- **Descripcion:** Static resource serving allows path traversal
- **Remediacion:** Actualizar a `spring-web:5.3.40`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-38816

#### CVE-2024-38819 — HIGH — Path Traversal
- **Tipo:** Path Traversal
- **Descripcion:** Additional path traversal vector in resource handling
- **Remediacion:** Actualizar a `spring-web:5.3.42`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-38819

### org.yaml : snakeyaml : 1.29

#### CVE-2022-1471 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Constructor class allows deserialization of any Java type
- **Remediacion:** Actualizar a `snakeyaml:2.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-1471

#### CVE-2022-25857 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** Unbounded nesting of collections allows DoS
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-25857

#### CVE-2022-38749 — MEDIUM — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Malicious YAML causes parser crash via stack overflow
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38749

#### CVE-2022-38750 — MEDIUM — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Variant stack overflow DoS vector
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38750

#### CVE-2022-38751 — MEDIUM — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Additional stack overflow variant in parser
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38751

#### CVE-2022-38752 — MEDIUM — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Input YAML before 1.32 vulnerable to stack overflow
- **Remediacion:** Actualizar a `snakeyaml:2.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38752

#### CVE-2022-41854 — MEDIUM — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Untrusted YAML parsing causes potential stack overflow
- **Remediacion:** Actualizar a `snakeyaml:1.32`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-41854

### com.fasterxml.jackson.core : jackson-databind : 2.13.2.2

#### CVE-2022-42003 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** Deep nesting via UNWRAP_SINGLE_VALUE_ARRAYS causes DoS
- **Remediacion:** Actualizar a `jackson-databind:2.13.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42003

#### CVE-2022-42004 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** BeanDeserializer with UNWRAP_SINGLE_VALUE_ARRAYS causes resource exhaustion
- **Remediacion:** Actualizar a `jackson-databind:2.13.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42004

### ch.qos.logback : logback-classic : 1.2.11

#### CVE-2023-6378 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** Serialization via receiver component causes DoS
- **Remediacion:** Actualizar a `logback-classic:1.2.13`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-6378

### ch.qos.logback : logback-core : 1.2.11

#### CVE-2023-6378 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** Serialization via receiver component causes DoS in core
- **Remediacion:** Actualizar a `logback-core:1.2.13`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-6378

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `tomcat-embed-core` | 9.0.60 | **9.0.98** |
| `spring-webmvc` | 5.3.18 | **5.3.18** |
| `spring-web` | 5.3.18 | **5.3.42** |
| `snakeyaml` | 1.29 | **2.0** |
| `jackson-databind` | 2.13.2.2 | **2.13.4** |
| `logback-classic` | 1.2.11 | **1.2.13** |
| `logback-core` | 1.2.11 | **1.2.13** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **0s** |
| CVEs Detected | 30 |
| Artifacts Analyzed | 7 |
| Depth | N0→N4 |
