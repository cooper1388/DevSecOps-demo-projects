# CVE Analysis Report — 07_unmaintained_repos

**Scan Date:** 2026-04-03  
**Tool:** Supply Chain Agentic Pipeline v2  
**LLM:** gpt-4.1-nano (fast) / gpt-4.1-mini (reason) / gpt-4.1 (critical)  
**Total CVEs Found:** 1  
**Severities:** 0 CRITICAL · 0 HIGH · 1 MEDIUM  
**Scan Time:** 9.5s

---

## Project Description

Proyecto con 5 dependencias abandonadas sin CVEs conocidos. Caso control para evaluar deteccion de riesgo operativo por falta de mantenimiento.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `junit` | 4.7 | N1 | 1 |

---

## CVE Detail

### junit : junit : 4.7

#### CVE-2020-15250 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** TemporaryFolder on unix-like systems does not limit access to created files
- **Remediacion:** Actualizar a `junit:4.13.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-15250

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `junit` | 4.7 | **4.13.1** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **9.5s** |
| CVEs Detected | 1 |
| Artifacts Analyzed | 1 |
| Depth | N0→N4 |
