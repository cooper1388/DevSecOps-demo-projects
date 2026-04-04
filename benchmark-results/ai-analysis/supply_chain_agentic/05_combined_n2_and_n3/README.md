# CVE Analysis Report — 05_combined_n2_and_n3

**Scan Date:** 2026-04-03  
**Tool:** Supply Chain Agentic Pipeline v2  
**LLM:** gpt-4.1-nano (fast) / gpt-4.1-mini (reason) / gpt-4.1 (critical)  
**Total CVEs Found:** 78  
**Severities:** 16 CRITICAL · 51 HIGH · 11 MEDIUM  
**Scan Time:** 45.5s

---

## Project Description

Proyecto Gradle multi-modulo con vulnerabilidades combinadas en N2 (snakeyaml, gson) y N3 (jackson-databind:2.9.8 con 50+ CVEs de deserializacion).

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `jackson-databind` | 2.9.8 | N1 | 53 |
| `hibernate-validator` | 6.0.18.Final | N1 | 3 |
| `snakeyaml` | 1.30 | N1 | 7 |
| `gson` | 2.8.6 | N1 | 1 |
| `log4j` | 1.2.16 | N1 | 6 |
| `commons-collections` | 3.2.1 | N1 | 2 |
| `jackson-core` | 2.9.8 | N1 | 2 |
| `junit` | 4.12 | N2 | 1 |
| `javax.el` | 3.0.1-b09 | N1 | 1 |
| `velocity` | 1.6.2 | N1 | 1 |
| `commons-lang` | 2.4 | N2 | 1 |

---

## CVE Detail

### com.fasterxml.jackson.core : jackson-databind : 2.9.8

#### CVE-2020-11619 — HIGH — general
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-11619

#### CVE-2020-25649 — HIGH — injection
- **Tipo:** injection
- **Descripcion:** XML External Entity (XXE) Injection in Jackson Databind
- **Impacto:** XML External Entity (XXE) Injection in Jackson Databind
- **Remediacion:** Actualizar a `jackson-databind:2.10.5.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-25649

#### CVE-2020-8840 — CRITICAL — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Deserialization of Untrusted Data in jackson-databind
- **Impacto:** Deserialization of Untrusted Data in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-8840

#### CVE-2020-36518 — HIGH — general — Exploit publico
- **Tipo:** general
- **Descripcion:** Deeply nested json in jackson-databind
- **Impacto:** Deeply nested json in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.12.6.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36518

#### CVE-2020-11112 — HIGH — general
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-11112

#### CVE-2021-20190 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Deserialization of untrusted data in jackson-databind
- **Impacto:** Deserialization of untrusted data in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-20190

#### CVE-2020-9546 — CRITICAL — general
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-9546

#### CVE-2020-35728 — HIGH — general — Exploit publico
- **Tipo:** general
- **Descripcion:** Serialization gadget exploit in jackson-databind
- **Impacto:** Serialization gadget exploit in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-35728

#### CVE-2019-12086 — HIGH — info_disclosure — Exploit publico
- **Tipo:** info_disclosure
- **Descripcion:** Information exposure in FasterXML jackson-databind
- **Impacto:** Information exposure in FasterXML jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-12086

#### CVE-2019-14379 — CRITICAL — deserialization
- **Tipo:** deserialization
- **Descripcion:** Deserialization of untrusted data in FasterXML jackson-databind
- **Impacto:** Deserialization of untrusted data in FasterXML jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.7.9.6`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-14379

#### CVE-2020-10969 — HIGH — general
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10969

#### CVE-2019-16335 — CRITICAL — general
- **Tipo:** general
- **Descripcion:** Polymorphic Typing issue in FasterXML jackson-databind
- **Impacto:** Polymorphic Typing issue in FasterXML jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-16335

#### CVE-2020-36182 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36182

#### CVE-2020-36180 — HIGH — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36180

#### CVE-2020-36185 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36185

#### CVE-2020-10672 — HIGH — general
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10672

#### CVE-2020-36179 — HIGH — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36179

#### CVE-2020-36183 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36183

#### CVE-2020-11113 — HIGH — general — Exploit publico
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-11113

#### CVE-2020-14062 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Deserialization of untrusted data in Jackson Databind
- **Impacto:** Deserialization of untrusted data in Jackson Databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-14062

#### CVE-2020-14061 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Deserialization of untrusted data in Jackson Databind
- **Impacto:** Deserialization of untrusted data in Jackson Databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-14061

#### CVE-2019-14892 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Polymorphic deserialization of malicious object in jackson-databind
- **Impacto:** Polymorphic deserialization of malicious object in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-14892

#### CVE-2019-12814 — HIGH — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Deserialization of untrusted data in FasterXML jackson-databind
- **Impacto:** Deserialization of untrusted data in FasterXML jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-12814

#### CVE-2020-36181 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36181

#### CVE-2019-17267 — CRITICAL — input_validation
- **Tipo:** input_validation
- **Descripcion:** Improper Input Validation in jackson-databind
- **Impacto:** Improper Input Validation in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.8.11.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-17267

#### CVE-2020-36188 — HIGH — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36188

#### CVE-2019-16943 — CRITICAL — general
- **Tipo:** general
- **Descripcion:** jackson-databind polymorphic typing issue
- **Impacto:** jackson-databind polymorphic typing issue
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-16943

#### CVE-2020-10673 — HIGH — general — Exploit publico
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10673

#### CVE-2019-17531 — CRITICAL — general
- **Tipo:** general
- **Descripcion:** jackson-databind polymorphic typing issue
- **Impacto:** jackson-databind polymorphic typing issue
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-17531

#### CVE-2019-14439 — HIGH — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Deserialization of untrusted data in FasterXML jackson-databind
- **Impacto:** Deserialization of untrusted data in FasterXML jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-14439

#### CVE-2019-20330 — CRITICAL — deserialization
- **Tipo:** deserialization
- **Descripcion:** Deserialization of Untrusted Data in jackson-databind
- **Impacto:** Deserialization of Untrusted Data in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.2`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-20330

#### CVE-2020-24616 — HIGH — injection — Exploit publico
- **Tipo:** injection
- **Descripcion:** Code Injection in jackson-databind
- **Impacto:** Code Injection in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.6`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-24616

#### CVE-2020-11620 — HIGH — general
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-11620

#### CVE-2019-14540 — CRITICAL — general — Exploit publico
- **Tipo:** general
- **Descripcion:** Polymorphic Typing issue in FasterXML jackson-databind
- **Impacto:** Polymorphic Typing issue in FasterXML jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-14540

#### CVE-2020-14060 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Deserialization of untrusted data in Jackson Databind
- **Impacto:** Deserialization of untrusted data in Jackson Databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-14060

#### CVE-2022-42003 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** Uncontrolled Resource Consumption in Jackson-databind
- **Impacto:** Uncontrolled Resource Consumption in Jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.13.4.2`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42003

#### CVE-2020-36184 — HIGH — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36184

#### CVE-2020-14195 — HIGH — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Deserialization of untrusted data in Jackson Databind
- **Impacto:** Deserialization of untrusted data in Jackson Databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-14195

#### CVE-2019-12384 — HIGH — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Deserialization of Untrusted Data in FasterXML jackson-databind
- **Impacto:** Deserialization of Untrusted Data in FasterXML jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-12384

#### CVE-2019-16942 — CRITICAL — general
- **Tipo:** general
- **Descripcion:** Polymorphic Typing in FasterXML jackson-databind
- **Impacto:** Polymorphic Typing in FasterXML jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-16942

#### CVE-2020-9548 — CRITICAL — general — Exploit publico
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.7.9.7`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-9548

#### CVE-2020-9547 — CRITICAL — general — Exploit publico
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.7.9.7`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-9547

#### CVE-2020-24750 — HIGH — deserialization — Exploit publico
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.6`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-24750

#### CVE-2019-14893 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Polymorphic deserialization of malicious object in jackson-databind
- **Impacto:** Polymorphic deserialization of malicious object in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-14893

#### CVE-2020-35491 — HIGH — general
- **Tipo:** general
- **Descripcion:** Serialization gadgets exploit in jackson-databind
- **Impacto:** Serialization gadgets exploit in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-35491

#### CVE-2020-36187 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36187

#### CVE-2020-10968 — HIGH — general
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10968

#### CVE-2022-42004 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** Uncontrolled Resource Consumption in FasterXML jackson-databind
- **Impacto:** Uncontrolled Resource Consumption in FasterXML jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.13.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42004

#### CVE-2020-10650 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** jackson-databind vulnerable to unsafe deserialization
- **Impacto:** jackson-databind vulnerable to unsafe deserialization
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10650

#### CVE-2020-11111 — HIGH — general
- **Tipo:** general
- **Descripcion:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Impacto:** jackson-databind mishandles the interaction between serialization gadgets and typing
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-11111

#### CVE-2020-36186 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36186

#### CVE-2020-36189 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Unsafe Deserialization in jackson-databind
- **Impacto:** Unsafe Deserialization in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.6.7.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36189

#### CVE-2020-35490 — HIGH — general
- **Tipo:** general
- **Descripcion:** Serialization gadgets exploit in jackson-databind
- **Impacto:** Serialization gadgets exploit in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-35490

### org.hibernate.validator : hibernate-validator : 6.0.18.Final

#### CVE-2025-35036 — HIGH — general
- **Tipo:** general
- **Descripcion:** Hibernate Validator may interpolate user-supplied input in a constraint violation message with Expression Language
- **Impacto:** Hibernate Validator may interpolate user-supplied input in a constraint violation message with Expression Language
- **Remediacion:** Actualizar a `hibernate-validator:7.0.0.CR1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-35036

#### CVE-2020-10693 — MEDIUM — input_validation
- **Tipo:** input_validation
- **Descripcion:** Improper Input Validation in Hibernate Validator
- **Impacto:** Improper Input Validation in Hibernate Validator
- **Remediacion:** Actualizar a `hibernate-validator:6.0.20.Final`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10693

#### CVE-2023-1932 — MEDIUM — xss
- **Tipo:** xss
- **Descripcion:** hibernate-validator Cross-site Scripting vulnerability
- **Impacto:** hibernate-validator Cross-site Scripting vulnerability
- **Remediacion:** Actualizar a `hibernate-validator:6.2.0.Final`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2023-1932

### org.yaml : snakeyaml : 1.30

#### CVE-2022-25857 — HIGH — rce
- **Tipo:** rce
- **Descripcion:** Uncontrolled Resource Consumption in snakeyaml
- **Impacto:** Uncontrolled Resource Consumption in snakeyaml
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-25857

#### CVE-2022-38751 — MEDIUM — dos
- **Tipo:** dos
- **Descripcion:** snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write
- **Impacto:** snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38751

#### CVE-2022-38752 — MEDIUM — dos
- **Tipo:** dos
- **Descripcion:** snakeYAML before 1.32 vulnerable to Denial of Service due to Out-of-bounds Write
- **Impacto:** snakeYAML before 1.32 vulnerable to Denial of Service due to Out-of-bounds Write
- **Remediacion:** Actualizar a `snakeyaml:1.32`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38752

#### CVE-2022-38749 — MEDIUM — dos
- **Tipo:** dos
- **Descripcion:** snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write
- **Impacto:** snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38749

#### CVE-2022-38750 — MEDIUM — dos
- **Tipo:** dos
- **Descripcion:** snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write
- **Impacto:** snakeYAML before 1.31 vulnerable to Denial of Service due to Out-of-bounds Write
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38750

#### CVE-2022-1471 — HIGH — rce, deserialization — Exploit publico
- **Tipo:** rce, deserialization
- **Descripcion:** SnakeYaml Constructor Deserialization Remote Code Execution
- **Impacto:** SnakeYaml Constructor Deserialization Remote Code Execution
- **Remediacion:** Actualizar a `snakeyaml:2.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-1471

#### CVE-2022-41854 — MEDIUM — dos, overflow
- **Tipo:** dos, overflow
- **Descripcion:** Snakeyaml vulnerable to Stack overflow leading to denial of service
- **Impacto:** Snakeyaml vulnerable to Stack overflow leading to denial of service
- **Remediacion:** Actualizar a `snakeyaml:1.32`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-41854

### com.google.code.gson : gson : 2.8.6

#### CVE-2022-25647 — HIGH — deserialization
- **Tipo:** deserialization
- **Descripcion:** Deserialization of Untrusted Data in Gson
- **Impacto:** Deserialization of Untrusted Data in Gson
- **Remediacion:** Actualizar a `gson:2.8.9`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-25647

### log4j : log4j : 1.2.16

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

### com.fasterxml.jackson.core : jackson-core : 2.9.8

#### CVE-2025-52999 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** jackson-core can throw a StackoverflowError when processing deeply nested data
- **Remediacion:** Actualizar a `jackson-core:2.15.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-52999

#### CVE-2025-49128 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** Jackson-core Vulnerable to Memory Disclosure via Source Snippet in JsonLocation
- **Remediacion:** Actualizar a `jackson-core:2.13.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-49128

### junit : junit : 4.12

#### CVE-2020-15250 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** TemporaryFolder on unix-like systems does not limit access to created files
- **Remediacion:** Actualizar a `junit:4.13.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-15250

### org.glassfish : javax.el : 3.0.1-b09

#### CVE-2021-28170 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** Improper Input Validation in Jakarta Expression Language
- **Remediacion:** Actualizar a `javax.el:3.0.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2021-28170

### org.apache.velocity : velocity : 1.6.2

#### CVE-2020-13936 — HIGH — Transitive
- **Tipo:** Transitive
- **Descripcion:** Sandbox Bypass in Apache Velocity Engine
- **Remediacion:** Actualizar a `velocity:2.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-13936

### commons-lang : commons-lang : 2.4

#### CVE-2025-48924 — MEDIUM — Transitive
- **Tipo:** Transitive
- **Descripcion:** Apache Commons Lang is vulnerable to Uncontrolled Recursion when processing long inputs
- **Remediacion:** Actualizar a `commons-lang:3.18.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2025-48924

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `jackson-databind` | 2.9.8 | **2.9.10.8** |
| `hibernate-validator` | 6.0.18.Final | **7.0.0.CR1** |
| `snakeyaml` | 1.30 | **2.0** |
| `gson` | 2.8.6 | **2.8.9** |
| `log4j` | 1.2.16 | **2.0** |
| `commons-collections` | 3.2.1 | **4.1** |
| `jackson-core` | 2.9.8 | **2.15.0** |
| `junit` | 4.12 | **4.13.1** |
| `javax.el` | 3.0.1-b09 | **3.0.4** |
| `velocity` | 1.6.2 | **2.3** |
| `commons-lang` | 2.4 | **3.18.0** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **45.5s** |
| CVEs Detected | 78 |
| Artifacts Analyzed | 11 |
| Depth | N0→N4 |
