# CVE Analysis Report — 01_direct_vuln_n1

**Scan Date:** 2026-04-03  
**Tool:** Claude Opus 4  
**Analyst:** Claude Opus 4 via Claude Code  
**Method:** LLM-based CVE knowledge lookup per dependency version  
**Total CVEs Found:** 5  
**Severities:** 3 CRITICAL · 1 HIGH · 1 MEDIUM  
**Scan Time:** 0s

---

## Project Description

Aplicacion Maven con vulnerabilidades directas de nivel N1. Dependencias declaradas explicitamente en pom.xml con CVEs de alto impacto.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `log4j-core` | 2.14.1 | N1 | 4 |
| `commons-text` | 1.9 | N1 | 1 |

---

## CVE Detail

### org.apache.logging.log4j : log4j-core : 2.14.1

#### CVE-2021-44228 — CRITICAL — RCE via JNDI
- **Tipo:** RCE via JNDI
- **Descripcion:** Log4Shell: JNDI features allow RCE via LDAP endpoint controlled by attacker. CVSS 10.0
- **Remediacion:** Actualizar a `log4j-core:2.17.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-44228

#### CVE-2021-45046 — CRITICAL — RCE via JNDI
- **Tipo:** RCE via JNDI
- **Descripcion:** Incomplete fix of Log4Shell in 2.15.0; MDC pattern lookup exploitation
- **Remediacion:** Actualizar a `log4j-core:2.17.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-45046

#### CVE-2021-45105 — HIGH — DoS via recursion
- **Tipo:** DoS via recursion
- **Descripcion:** Uncontrolled recursion from self-referential lookups causes DoS
- **Remediacion:** Actualizar a `log4j-core:2.17.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-45105

#### CVE-2021-44832 — MEDIUM — RCE via JDBC Appender
- **Tipo:** RCE via JDBC Appender
- **Descripcion:** Attacker with log config access can use JDBC Appender with JNDI URI
- **Remediacion:** Actualizar a `log4j-core:2.17.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-44832

### org.apache.commons : commons-text : 1.9

#### CVE-2022-42889 — CRITICAL — RCE via interpolation
- **Tipo:** RCE via interpolation
- **Descripcion:** StringSubstitutor allows RCE through script/dns/url lookups
- **Remediacion:** Actualizar a `commons-text:1.10.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42889

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `log4j-core` | 2.14.1 | **2.17.1** |
| `commons-text` | 1.9 | **1.10.0** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **0s** |
| CVEs Detected | 5 |
| Artifacts Analyzed | 2 |
| Depth | N0→N4 |
