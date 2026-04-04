# CVE Analysis Report — 06_deep_transitive_n4

**Scan Date:** 2026-04-03  
**Tool:** Supply Chain Agentic Pipeline v2  
**LLM:** gpt-4.1-nano (fast) / gpt-4.1-mini (reason) / gpt-4.1 (critical)  
**Total CVEs Found:** 5  
**Severities:** 1 CRITICAL · 3 HIGH · 1 MEDIUM  
**Scan Time:** 39.2s

---

## Project Description

Proyecto Maven multi-modulo con 3 capas internas: app -> lib-outer -> lib-middle -> lib-deep -> commons-collections:3.2.1 en N4.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `commons-collections` | 3.2.1 | N1 | 2 |
| `commons-io` | 2.6 | N1 | 2 |
| `junit` | 4.12 | N1 | 1 |

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

### commons-io : commons-io : 2.6

#### CVE-2024-47554 — HIGH — dos
- **Tipo:** dos
- **Descripcion:** Apache Commons IO: Possible denial of service attack on untrusted input to XmlStreamReader
- **Impacto:** Apache Commons IO: Possible denial of service attack on untrusted input to XmlStreamReader
- **Remediacion:** Actualizar a `commons-io:2.14.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-47554

#### CVE-2021-29425 — HIGH — path_traversal, input_validation — Exploit publico
- **Tipo:** path_traversal, input_validation
- **Descripcion:** Path Traversal and Improper Input Validation in Apache Commons IO
- **Impacto:** Path Traversal and Improper Input Validation in Apache Commons IO
- **Remediacion:** Actualizar a `commons-io:2.7`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-29425

### junit : junit : 4.12

#### CVE-2020-15250 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** TemporaryFolder on unix-like systems does not limit access to created files
- **Remediacion:** Actualizar a `junit:4.13.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-15250

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `commons-collections` | 3.2.1 | **4.1** |
| `commons-io` | 2.6 | **2.7** |
| `junit` | 4.12 | **4.13.1** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **39.2s** |
| CVEs Detected | 5 |
| Artifacts Analyzed | 3 |
| Depth | N0→N4 |
