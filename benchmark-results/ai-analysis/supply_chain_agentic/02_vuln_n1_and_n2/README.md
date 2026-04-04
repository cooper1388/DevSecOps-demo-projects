# CVE Analysis Report — 02_vuln_n1_and_n2

**Scan Date:** 2026-04-03  
**Tool:** Supply Chain Agentic Pipeline v2  
**LLM:** gpt-4.1-nano (fast) / gpt-4.1-mini (reason) / gpt-4.1 (critical)  
**Total CVEs Found:** 34  
**Severities:** 4 CRITICAL · 25 HIGH · 5 MEDIUM  
**Scan Time:** 50.8s

---

## Project Description

Proyecto Maven con vulnerabilidades en dependencias directas (N1) y transitivas de primer nivel (N2). Combina struts2-core y xstream con sus transitivas.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `struts2-core` | 2.5.25 | N1 | 10 |
| `xstream` | 1.4.17 | N1 | 18 |
| `commons-fileupload` | 1.4 | N1 | 2 |
| `commons-io` | 2.2 | N2 | 2 |
| `junit` | 4.12 | N2 | 1 |
| `commons-lang3` | 3.8.1 | N1 | 1 |

---

## CVE Detail

### org.apache.struts : struts2-core : 2.5.25

#### CVE-2023-50164 — CRITICAL — path_traversal — Exploit publico
- **Tipo:** path_traversal
- **Descripcion:** Apache Struts vulnerable to path traversal
- **Impacto:** Apache Struts vulnerable to path traversal
- **Remediacion:** Actualizar a `struts2-core:6.3.0.2`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-50164

#### CVE-2024-53677 — CRITICAL — general — Exploit publico
- **Tipo:** general
- **Descripcion:** Apache Struts file upload logic is flawed
- **Impacto:** Apache Struts file upload logic is flawed
- **Remediacion:** Actualizar a `struts2-core:6.4.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-53677

#### CVE-2023-34396 — MEDIUM — general
- **Tipo:** general
- **Descripcion:** Apache Struts vulnerable to memory exhaustion
- **Impacto:** Apache Struts vulnerable to memory exhaustion
- **Remediacion:** Actualizar a `struts2-core:6.1.2.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-34396

#### CVE-2023-41835 — HIGH — rce, input_validation
- **Tipo:** rce, input_validation
- **Descripcion:** Apache Struts Improper Control of Dynamically-Managed Code Resources vulnerability
- **Impacto:** Apache Struts Improper Control of Dynamically-Managed Code Resources vulnerability
- **Remediacion:** Actualizar a `struts2-core:2.5.32`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-41835

#### CVE-2023-34149 — MEDIUM — general
- **Tipo:** general
- **Descripcion:** Apache Struts vulnerable to memory exhaustion
- **Impacto:** Apache Struts vulnerable to memory exhaustion
- **Remediacion:** Actualizar a `struts2-core:6.1.2.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-34149

#### CVE-2020-17530 — CRITICAL — rce — Exploit publico
- **Tipo:** rce
- **Descripcion:** Remote code execution in Apache Struts
- **Impacto:** Remote code execution in Apache Struts
- **Remediacion:** Actualizar a `struts2-core:2.5.26`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-17530

#### CVE-2025-68493 — HIGH — general — Exploit publico
- **Tipo:** general
- **Descripcion:** Apache Struts 2 is Missing XML Validation
- **Impacto:** Apache Struts 2 is Missing XML Validation
- **Remediacion:** Actualizar a `struts2-core:6.1.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-68493

#### CVE-2025-66675 — HIGH — dos
- **Tipo:** dos
- **Descripcion:** Apache Struts has a Denial of Service vulnerability
- **Impacto:** Apache Struts has a Denial of Service vulnerability
- **Remediacion:** Actualizar a `struts2-core:7.1.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-66675

#### CVE-2021-31805 — CRITICAL — injection — Exploit publico
- **Tipo:** injection
- **Descripcion:** Expression Language Injection in Apache Struts
- **Impacto:** Expression Language Injection in Apache Struts
- **Remediacion:** Actualizar a `struts2-core:2.5.30`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-31805

#### CVE-2025-64775 — HIGH — dos
- **Tipo:** dos
- **Descripcion:** Apache Struts is Vulnerable to DoS via File Leak
- **Impacto:** Apache Struts is Vulnerable to DoS via File Leak
- **Remediacion:** Actualizar a `struts2-core:7.1.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-64775

### com.thoughtworks.xstream : xstream : 1.4.17

#### CVE-2021-39153 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Impacto:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39153

#### CVE-2021-39149 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Impacto:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39149

#### CVE-2021-39139 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Impacto:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39139

#### CVE-2021-39154 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Impacto:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39154

#### CVE-2021-39140 — MEDIUM — dos
- **Tipo:** dos
- **Descripcion:** XStream can cause a Denial of Service
- **Impacto:** XStream can cause a Denial of Service
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39140

#### CVE-2021-39145 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Impacto:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39145

#### CVE-2021-39150 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** A Server-Side Forgery Request can be activated unmarshalling with XStream to access data streams from an arbitrary URL referencing a resource in an intranet or the local host
- **Impacto:** A Server-Side Forgery Request can be activated unmarshalling with XStream to access data streams from an arbitrary URL referencing a resource in an intranet or the local host
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39150

#### CVE-2022-40151 — HIGH — injection, dos
- **Tipo:** injection, dos
- **Descripcion:** XStream can cause a Denial of Service by injecting deeply nested objects raising a stack overflow
- **Impacto:** XStream can cause a Denial of Service by injecting deeply nested objects raising a stack overflow
- **Remediacion:** Actualizar a `xstream:1.4.20`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-40151

#### CVE-2021-39141 — HIGH — rce — Exploit publico
- **Tipo:** rce
- **Descripcion:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Impacto:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39141

#### CVE-2021-39147 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Impacto:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39147

#### CVE-2024-47072 — HIGH — dos, overflow
- **Tipo:** dos, overflow
- **Descripcion:** XStream is vulnerable to a Denial of Service attack due to stack overflow from a manipulated binary input stream
- **Impacto:** XStream is vulnerable to a Denial of Service attack due to stack overflow from a manipulated binary input stream
- **Remediacion:** Actualizar a `xstream:1.4.21`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-47072

#### CVE-2021-39151 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Impacto:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39151

#### CVE-2022-41966 — HIGH — dos, overflow — Exploit publico
- **Tipo:** dos, overflow
- **Descripcion:** XStream can cause Denial of Service via stack overflow
- **Impacto:** XStream can cause Denial of Service via stack overflow
- **Remediacion:** Actualizar a `xstream:1.4.20`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-41966

#### CVE-2021-39144 — HIGH — general
- **Tipo:** general
- **Descripcion:** XStream is vulnerable to a Remote Command Execution attack
- **Impacto:** XStream is vulnerable to a Remote Command Execution attack
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39144

#### CVE-2021-39146 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Impacto:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39146

#### CVE-2021-39148 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Impacto:** XStream is vulnerable to an Arbitrary Code Execution attack
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39148

#### CVE-2021-43859 — HIGH — injection, dos
- **Tipo:** injection, dos
- **Descripcion:** Denial of Service by injecting highly recursive collections or maps in XStream
- **Impacto:** Denial of Service by injecting highly recursive collections or maps in XStream
- **Remediacion:** Actualizar a `xstream:1.4.19`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-43859

#### CVE-2021-39152 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** A Server-Side Forgery Request can be activated unmarshalling with XStream to access data streams from an arbitrary URL referencing a resource in an intranet or the local host
- **Impacto:** A Server-Side Forgery Request can be activated unmarshalling with XStream to access data streams from an arbitrary URL referencing a resource in an intranet or the local host
- **Remediacion:** Actualizar a `xstream:1.4.18`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-39152

### commons-fileupload : commons-fileupload : 1.4

#### CVE-2023-24998 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Apache Commons FileUpload denial of service vulnerability
- **Remediacion:** Actualizar a `commons-fileupload:9.0.71`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-24998

#### CVE-2025-48976 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Apache Commons FileUpload, Apache Commons FileUpload: FileUpload DoS via part headers
- **Remediacion:** Actualizar a `commons-fileupload:2.0.0-M4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-48976

### commons-io : commons-io : 2.2

#### CVE-2024-47554 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Apache Commons IO: Possible denial of service attack on untrusted input to XmlStreamReader
- **Remediacion:** Actualizar a `commons-io:2.14.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2024-47554

#### CVE-2021-29425 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Path Traversal and Improper Input Validation in Apache Commons IO
- **Remediacion:** Actualizar a `commons-io:2.7`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-29425

### junit : junit : 4.12

#### CVE-2020-15250 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** TemporaryFolder on unix-like systems does not limit access to created files
- **Remediacion:** Actualizar a `junit:4.13.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-15250

### org.apache.commons : commons-lang3 : 3.8.1

#### CVE-2025-48924 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** Apache Commons Lang is vulnerable to Uncontrolled Recursion when processing long inputs
- **Remediacion:** Actualizar a `commons-lang3:3.18.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-48924

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `struts2-core` | 2.5.25 | **7.1.1** |
| `xstream` | 1.4.17 | **1.4.21** |
| `commons-fileupload` | 1.4 | **9.0.71** |
| `commons-io` | 2.2 | **2.7** |
| `junit` | 4.12 | **4.13.1** |
| `commons-lang3` | 3.8.1 | **3.18.0** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **50.8s** |
| CVEs Detected | 34 |
| Artifacts Analyzed | 6 |
| Depth | N0→N4 |
