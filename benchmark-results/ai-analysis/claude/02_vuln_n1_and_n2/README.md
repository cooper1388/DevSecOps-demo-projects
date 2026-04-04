# CVE Analysis Report — 02_vuln_n1_and_n2

**Scan Date:** 2026-04-03  
**Tool:** Claude Opus 4  
**Analyst:** Claude Opus 4 via Claude Code  
**Method:** LLM-based CVE knowledge lookup per dependency version  
**Total CVEs Found:** 28  
**Severities:** 4 CRITICAL · 20 HIGH · 4 MEDIUM  
**Scan Time:** 0s

---

## Project Description

Proyecto Maven con vulnerabilidades en dependencias directas (N1) y transitivas de primer nivel (N2). Combina struts2-core y xstream con sus transitivas.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `struts2-core` | 2.5.25 | N1 | 8 |
| `xstream` | 1.4.17 | N1 | 17 |
| `commons-fileupload` | 1.4 | N2 | 1 |
| `commons-io` | 2.6 | N2 | 2 |

---

## CVE Detail

### org.apache.struts : struts2-core : 2.5.25

#### CVE-2021-31805 — CRITICAL — RCE via OGNL
- **Tipo:** RCE via OGNL
- **Descripcion:** Double evaluation in tag attributes allows OGNL injection
- **Remediacion:** Actualizar a `struts2-core:2.5.30`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-31805

#### CVE-2020-17530 — CRITICAL — RCE via OGNL
- **Tipo:** RCE via OGNL
- **Descripcion:** Forced OGNL evaluation on tag attributes input
- **Remediacion:** Actualizar a `struts2-core:2.5.26`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-17530

#### CVE-2023-50164 — CRITICAL — Path Traversal / RCE
- **Tipo:** Path Traversal / RCE
- **Descripcion:** File upload path manipulation allows arbitrary file write
- **Remediacion:** Actualizar a `struts2-core:6.3.0.2`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-50164

#### CVE-2024-53677 — CRITICAL — Path Traversal / RCE
- **Tipo:** Path Traversal / RCE
- **Descripcion:** File upload logic vulnerability enabling path traversal
- **Remediacion:** Actualizar a `struts2-core:6.4.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-53677

#### CVE-2023-34396 — MEDIUM — DoS via OOM
- **Tipo:** DoS via OOM
- **Descripcion:** Multipart form without size limit causes Out-of-Memory
- **Remediacion:** Actualizar a `struts2-core:6.1.2.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-34396

#### CVE-2023-41835 — HIGH — File Leak
- **Tipo:** File Leak
- **Descripcion:** Temp upload files persist on disk when maxStringLength exceeded
- **Remediacion:** Actualizar a `struts2-core:2.5.32`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-41835

#### CVE-2023-34149 — MEDIUM — DoS via OOM
- **Tipo:** DoS via OOM
- **Descripcion:** Missing bounds limit in list for multipart requests
- **Remediacion:** Actualizar a `struts2-core:6.1.2.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-34149

#### CVE-2025-68493 — HIGH — Missing XML Validation
- **Tipo:** Missing XML Validation
- **Descripcion:** XML validation missing in Struts since 2.0.0
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-68493

### com.thoughtworks.xstream : xstream : 1.4.17

#### CVE-2021-39154 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** XStream allows loading and executing arbitrary code from remote host
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39154

#### CVE-2021-39153 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Code execution in runtime Java 8-14 via deserialization
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39153

#### CVE-2021-39152 — HIGH — SSRF
- **Tipo:** SSRF
- **Descripcion:** Server-Side Request Forgery via XStream deserialization
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39152

#### CVE-2021-39151 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Arbitrary code execution from remote host via deserialization
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39151

#### CVE-2021-39150 — HIGH — SSRF
- **Tipo:** SSRF
- **Descripcion:** SSRF via URL manipulation in Java 8-14
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39150

#### CVE-2021-39149 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Arbitrary code execution via manipulated XStream input
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39149

#### CVE-2021-39148 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Code execution from remote host via stream manipulation
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39148

#### CVE-2021-39147 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Arbitrary code execution via crafted deserialization stream
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39147

#### CVE-2021-39146 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Code execution via deserialization with sufficient permissions
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39146

#### CVE-2021-39145 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Remote code execution from host with sufficient permissions
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39145

#### CVE-2021-39144 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Commands execution on remote host with sufficient permissions
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39144

#### CVE-2021-39141 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Arbitrary code execution via deserialization manipulation
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39141

#### CVE-2021-39139 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Code execution with JDK <= 1.7u21 or Xalan external
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39139

#### CVE-2021-39140 — MEDIUM — DoS via CPU
- **Tipo:** DoS via CPU
- **Descripcion:** 100% CPU via recursive collections or hash collision exploit
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39140

#### CVE-2021-43859 — HIGH — DoS via recursion
- **Tipo:** DoS via recursion
- **Descripcion:** Highly recursive collections injection causes DoS by 100% CPU
- **Remediacion:** Actualizar a `xstream:1.4.19`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-43859

#### CVE-2022-41966 — HIGH — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Deeply nested objects cause stack overflow and DoS
- **Remediacion:** Actualizar a `xstream:1.4.20`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-41966

#### CVE-2022-40151 — HIGH — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Manipulated binary stream causes stack overflow
- **Remediacion:** Actualizar a `xstream:1.4.20`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-40151

### commons-fileupload : commons-fileupload : 1.4

#### CVE-2023-24998 — HIGH — DoS via header allocation
- **Tipo:** DoS via header allocation
- **Descripcion:** FileUpload 1.5 pre does not limit request parts; allows DoS
- **Remediacion:** Actualizar a `commons-fileupload:1.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-24998

### commons-io : commons-io : 2.6

#### CVE-2021-29425 — MEDIUM — Path Traversal limitado
- **Tipo:** Path Traversal limitado
- **Descripcion:** FileNameUtils.normalize with malformed input can provide access
- **Remediacion:** Actualizar a `commons-io:2.7`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-29425

#### CVE-2024-47554 — HIGH — DoS via CPU exhaustion
- **Tipo:** DoS via CPU exhaustion
- **Descripcion:** XmlStreamReader may consume excessive CPU with malicious input
- **Remediacion:** Actualizar a `commons-io:2.14.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-47554

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `struts2-core` | 2.5.25 | **6.4.0** |
| `xstream` | 1.4.17 | **1.4.20** |
| `commons-fileupload` | 1.4 | **1.5** |
| `commons-io` | 2.6 | **2.7** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **0s** |
| CVEs Detected | 28 |
| Artifacts Analyzed | 4 |
| Depth | N0→N4 |
