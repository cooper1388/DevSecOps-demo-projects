# CVE Analysis Report — 04_transitive_only_n3

**Scan Date:** 2026-04-03  
**Tool:** Supply Chain Agentic Pipeline v2  
**LLM:** gpt-4.1-nano (fast) / gpt-4.1-mini (reason) / gpt-4.1 (critical)  
**Total CVEs Found:** 11  
**Severities:** 4 CRITICAL · 7 HIGH · 0 MEDIUM  
**Scan Time:** 10.3s

---

## Project Description

Proyecto Maven multi-modulo donde las vulnerabilidades estan en N3: app -> lib-wrapper -> lib-core -> commons-collections:3.2.1 (gadget chain RCE).

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `commons-collections` | 3.2.1 | N1 | 2 |
| `commons-beanutils` | 1.9.3 | N1 | 3 |
| `log4j` | 1.2.17 | N1 | 6 |

---

## CVE Detail

### commons-collections : commons-collections : 3.2.1

#### CVE-2015-6420 — HIGH — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Insecure Deserialization in Apache Commons Collection
- **Impacto:** Insecure Deserialization in Apache Commons Collection
- **Remediacion:** Actualizar a `commons-collections:3.2.2`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2015-6420

#### CVE-2015-7501 — CRITICAL — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Deserialization of Untrusted Data in Apache commons collections
- **Impacto:** Deserialization of Untrusted Data in Apache commons collections
- **Remediacion:** Actualizar a `commons-collections:4.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2015-7501

### commons-beanutils : commons-beanutils : 1.9.3

#### CVE-2019-10086 — HIGH — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Insecure Deserialization in Apache Commons Beanutils
- **Impacto:** Insecure Deserialization in Apache Commons Beanutils
- **Remediacion:** Actualizar a `commons-beanutils:1.9.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-10086

#### CVE-2014-0114 — HIGH — rce — Exploit publico
- **Tipo:** rce
- **Descripcion:** Arbitrary code execution in Apache Commons BeanUtils
- **Impacto:** Arbitrary code execution in Apache Commons BeanUtils
- **Remediacion:** Actualizar a `commons-beanutils:1.9.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2014-0114

#### CVE-2025-48734 — HIGH — input_validation
- **Tipo:** input_validation
- **Descripcion:** Apache Commons Improper Access Control vulnerability
- **Impacto:** Apache Commons Improper Access Control vulnerability
- **Remediacion:** Actualizar a `commons-beanutils:2.0.0-M2`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-48734

### log4j : log4j : 1.2.17

#### CVE-2019-17571 — CRITICAL — deserialization, log_injection — Exploit publico
- **Tipo:** deserialization, log_injection
- **Descripcion:** Deserialization of Untrusted Data in Log4j
- **Impacto:** Deserialization of Untrusted Data in Log4j
- **Remediacion:** Actualizar a `log4j:1.2.17`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-17571

#### CVE-2022-23305 — CRITICAL — injection, sql_injection — Exploit publico
- **Tipo:** injection, sql_injection
- **Descripcion:** SQL Injection in Log4j 1.2.x
- **Impacto:** SQL Injection in Log4j 1.2.x
- **Remediacion:** Actualizar a `log4j:1.2.17`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-23305

#### CVE-2022-23307 — CRITICAL — deserialization, log_injection
- **Tipo:** deserialization, log_injection
- **Descripcion:** Deserialization of Untrusted Data in Apache Log4j
- **Impacto:** Deserialization of Untrusted Data in Apache Log4j
- **Remediacion:** Actualizar a `log4j:1.2.17`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-23307

#### CVE-2021-4104 — HIGH — deserialization, log_injection — Exploit publico
- **Tipo:** deserialization, log_injection
- **Descripcion:** JMSAppender in Log4j 1.2 is vulnerable to deserialization of untrusted data
- **Impacto:** JMSAppender in Log4j 1.2 is vulnerable to deserialization of untrusted data
- **Remediacion:** Actualizar a `log4j:1.2.17`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-4104

#### CVE-2023-26464 — HIGH — dos, log_injection
- **Tipo:** dos, log_injection
- **Descripcion:** Apache Log4j 1.x (EOL) allows Denial of Service (DoS)
- **Impacto:** Apache Log4j 1.x (EOL) allows Denial of Service (DoS)
- **Remediacion:** Actualizar a `log4j:2.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-26464

#### CVE-2022-23302 — HIGH — deserialization, log_injection
- **Tipo:** deserialization, log_injection
- **Descripcion:** Deserialization of Untrusted Data in Log4j 1.x
- **Impacto:** Deserialization of Untrusted Data in Log4j 1.x
- **Remediacion:** Actualizar a `log4j:1.2.17`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-23302

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `commons-collections` | 3.2.1 | **4.1** |
| `commons-beanutils` | 1.9.3 | **2.0.0-M2** |
| `log4j` | 1.2.17 | **2.0** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **10.3s** |
| CVEs Detected | 11 |
| Artifacts Analyzed | 3 |
| Depth | N0→N4 |
