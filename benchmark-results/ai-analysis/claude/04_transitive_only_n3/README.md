# CVE Analysis Report — 04_transitive_only_n3

**Scan Date:** 2026-04-03  
**Tool:** Claude Opus 4  
**Analyst:** Claude Opus 4 via Claude Code  
**Method:** LLM-based CVE knowledge lookup per dependency version  
**Total CVEs Found:** 4  
**Severities:** 1 CRITICAL · 3 HIGH · 0 MEDIUM  
**Scan Time:** 0s

---

## Project Description

Proyecto Maven multi-modulo donde las vulnerabilidades estan en N3: app -> lib-wrapper -> lib-core -> commons-collections:3.2.1 (gadget chain RCE).

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `commons-collections` | 3.2.1 | N3 | 2 |
| `commons-beanutils` | 1.9.3 | N3 | 2 |

---

## CVE Detail

### commons-collections : commons-collections : 3.2.1

#### CVE-2015-6420 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** InvokerTransformer enables arbitrary code execution via deserialization
- **Remediacion:** Actualizar a `commons-collections:3.2.2`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2015-6420

#### CVE-2015-7501 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Gadget chain RCE via InvokerTransformer in deserialization
- **Remediacion:** Actualizar a `commons-collections:4.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2015-7501

### commons-beanutils : commons-beanutils : 1.9.3

#### CVE-2014-0114 — HIGH — RCE via ClassLoader
- **Tipo:** RCE via ClassLoader
- **Descripcion:** Class property manipulation allows ClassLoader override
- **Remediacion:** Actualizar a `commons-beanutils:1.9.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2014-0114

#### CVE-2019-10086 — HIGH — Property Access Bypass
- **Tipo:** Property Access Bypass
- **Descripcion:** PropertyUtilsBean suppresses class property access incorrectly
- **Remediacion:** Actualizar a `commons-beanutils:1.9.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-10086

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `commons-collections` | 3.2.1 | **4.1** |
| `commons-beanutils` | 1.9.3 | **1.9.4** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **0s** |
| CVEs Detected | 4 |
| Artifacts Analyzed | 2 |
| Depth | N0→N4 |
