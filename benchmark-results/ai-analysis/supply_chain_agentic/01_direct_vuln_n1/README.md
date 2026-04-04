# CVE Analysis Report — 01_direct_vuln_n1

**Scan Date:** 2026-04-03  
**Tool:** Supply Chain Agentic Pipeline v2  
**LLM:** gpt-4.1-nano (fast) / gpt-4.1-mini (reason) / gpt-4.1 (critical)  
**Total CVEs Found:** 7  
**Severities:** 3 CRITICAL · 2 HIGH · 2 MEDIUM  
**Scan Time:** 12.6s

---

## Project Description

Aplicacion Maven con vulnerabilidades directas de nivel N1. Dependencias declaradas explicitamente en pom.xml con CVEs de alto impacto.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `log4j-core` | 2.14.1 | N1 | 5 |
| `commons-text` | 1.9 | N1 | 1 |
| `commons-lang3` | 3.11 | N1 | 1 |

---

## CVE Detail

### org.apache.logging.log4j : log4j-core : 2.14.1

#### CVE-2021-45046 — CRITICAL — log_injection — Exploit publico
- **Tipo:** log_injection
- **Descripcion:** Incomplete fix for Apache Log4j vulnerability
- **Impacto:** Incomplete fix for Apache Log4j vulnerability
- **Remediacion:** Actualizar a `log4j-core:2.0.12`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-45046

#### CVE-2021-44832 — HIGH — injection, log_injection — Exploit publico
- **Tipo:** injection, log_injection
- **Descripcion:** Improper Input Validation and Injection in Apache Log4j2
- **Impacto:** Improper Input Validation and Injection in Apache Log4j2
- **Remediacion:** Actualizar a `log4j-core:2.0.14`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-44832

#### CVE-2021-44228 — CRITICAL — rce, injection — Exploit publico
- **Tipo:** rce, injection
- **Descripcion:** Remote code injection in Log4j
- **Impacto:** Remote code injection in Log4j
- **Remediacion:** Actualizar a `log4j-core:2.0.11`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-44228

#### CVE-2021-45105 — HIGH — log_injection, input_validation — Exploit publico
- **Tipo:** log_injection, input_validation
- **Descripcion:** Apache Log4j2 vulnerable to Improper Input Validation and Uncontrolled Recursion
- **Impacto:** Apache Log4j2 vulnerable to Improper Input Validation and Uncontrolled Recursion
- **Remediacion:** Actualizar a `log4j-core:2.0.13`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-45105

#### CVE-2025-68161 — MEDIUM — log_injection
- **Tipo:** log_injection
- **Descripcion:** Apache Log4j does not verify the TLS hostname in its Socket Appender
- **Impacto:** Apache Log4j does not verify the TLS hostname in its Socket Appender
- **Remediacion:** Actualizar a `log4j-core:2.25.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-68161

### org.apache.commons : commons-text : 1.9

#### CVE-2022-42889 — CRITICAL — rce — Exploit publico
- **Tipo:** rce
- **Descripcion:** Arbitrary code execution in Apache Commons Text
- **Impacto:** Arbitrary code execution in Apache Commons Text
- **Remediacion:** Actualizar a `commons-text:1.10.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42889

### org.apache.commons : commons-lang3 : 3.11

#### CVE-2025-48924 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** Apache Commons Lang is vulnerable to Uncontrolled Recursion when processing long inputs
- **Remediacion:** Actualizar a `commons-lang3:3.18.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-48924

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `log4j-core` | 2.14.1 | **2.25.3** |
| `commons-text` | 1.9 | **1.10.0** |
| `commons-lang3` | 3.11 | **3.18.0** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **12.6s** |
| CVEs Detected | 7 |
| Artifacts Analyzed | 3 |
| Depth | N0→N4 |
