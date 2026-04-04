# CVE Analysis Report — 05_combined_n2_and_n3

**Scan Date:** 2026-04-03  
**Tool:** Claude Opus 4  
**Analyst:** Claude Opus 4 via Claude Code  
**Method:** LLM-based CVE knowledge lookup per dependency version  
**Total CVEs Found:** 57  
**Severities:** 13 CRITICAL · 38 HIGH · 6 MEDIUM  
**Scan Time:** 0s

---

## Project Description

Proyecto Gradle multi-modulo con vulnerabilidades combinadas en N2 (snakeyaml, gson) y N3 (jackson-databind:2.9.8 con 50+ CVEs de deserializacion).

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `jackson-databind` | 2.9.8 | N3 | 48 |
| `snakeyaml` | 1.30 | N2 | 7 |
| `gson` | 2.8.6 | N2 | 1 |
| `hibernate-validator` | 6.0.18.Final | N3 | 1 |

---

## CVE Detail

### com.fasterxml.jackson.core : jackson-databind : 2.9.8

#### CVE-2019-12086 — HIGH — RCE via polymorphic deserialization
- **Tipo:** RCE via polymorphic deserialization
- **Descripcion:** mysql-connector-java gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.9`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-12086

#### CVE-2019-12384 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** logback-core gadget allows SSRF/RCE
- **Remediacion:** Actualizar a `jackson-databind:2.9.9.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-12384

#### CVE-2019-14379 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** SubTypeValidator bypass via ehcache
- **Remediacion:** Actualizar a `jackson-databind:2.9.9.2`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-14379

#### CVE-2019-14540 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** HikariCP config gadget enables RCE
- **Remediacion:** Actualizar a `jackson-databind:2.9.10`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-14540

#### CVE-2019-16335 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Polymorphic typing with c3p0 gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-16335

#### CVE-2019-16942 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** commons-dbcp gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-16942

#### CVE-2019-16943 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** p6spy gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-16943

#### CVE-2019-17267 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Polymorphic typing issue with net.sf.ehcache
- **Remediacion:** Actualizar a `jackson-databind:2.9.10`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-17267

#### CVE-2019-17531 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Apache log4j gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-17531

#### CVE-2019-20330 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** net.sf.ehcache gadget chain variant
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.2`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2019-20330

#### CVE-2020-8840 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Xbean-reflect gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.3`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-8840

#### CVE-2020-9546 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Shaded HikariConfig gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-9546

#### CVE-2020-9547 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** IBatis sqlmap gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-9547

#### CVE-2020-9548 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** anteros-dbcp gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-9548

#### CVE-2020-10650 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Ignite-jta gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10650

#### CVE-2020-10672 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** DriverManager gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10672

#### CVE-2020-10673 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Caucho-quercus gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10673

#### CVE-2020-10968 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Bus-proxy gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10968

#### CVE-2020-10969 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Javax-swing gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10969

#### CVE-2020-11111 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** shaded-hikari gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-11111

#### CVE-2020-11112 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** commons-proxy gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-11112

#### CVE-2020-11113 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** openjpa gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-11113

#### CVE-2020-11619 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Spring-aop gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-11619

#### CVE-2020-11620 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** commons-jelly gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-11620

#### CVE-2020-14060 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** aries-transaction gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-14060

#### CVE-2020-14061 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Shaded HikariConfig gadget variant
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-14061

#### CVE-2020-14062 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Jboss-remoting3 gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-14062

#### CVE-2020-14195 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Embedded Tomcat dbcp gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.5`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-14195

#### CVE-2020-24616 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** br.com.anteros gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.6`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-24616

#### CVE-2020-24750 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** com.pastdev.httpcomponents gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.6`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-24750

#### CVE-2020-25649 — HIGH — XXE
- **Tipo:** XXE
- **Descripcion:** XML external entity vulnerability in jackson-databind
- **Remediacion:** Actualizar a `jackson-databind:2.10.5.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-25649

#### CVE-2020-35490 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** org.apache.commons gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.7`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-35490

#### CVE-2020-35491 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** org.apache.commons variant gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.7`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-35491

#### CVE-2020-35728 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** com.oracle.wls gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.7`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-35728

#### CVE-2020-36179 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** ognl gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36179

#### CVE-2020-36180 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** apache commons-configuration gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36180

#### CVE-2020-36181 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Tomcat-dbcp gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36181

#### CVE-2020-36182 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** tomcat-embed gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36182

#### CVE-2020-36183 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** xercesImpl gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36183

#### CVE-2020-36184 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** org.apache.tomcat gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36184

#### CVE-2020-36185 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** org.apache.tomcat.dbcp variant gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36185

#### CVE-2020-36186 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** commons-dbcp2 gadget chain
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36186

#### CVE-2020-36187 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** com.newrelic.agent gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36187

#### CVE-2020-36188 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** com.oracle.wls.shaded gadget
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36188

#### CVE-2020-36189 — HIGH — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** com.oracle.wls shaded variant
- **Remediacion:** Actualizar a `jackson-databind:2.9.10.8`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36189

#### CVE-2020-36518 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** Deep nesting of JSON via JsonNode causes StackOverflow
- **Remediacion:** Actualizar a `jackson-databind:2.12.6.1`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-36518

#### CVE-2022-42003 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** UNWRAP_SINGLE_VALUE_ARRAYS deep nesting DoS
- **Remediacion:** Actualizar a `jackson-databind:2.13.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42003

#### CVE-2022-42004 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** BeanDeserializer UNWRAP resource exhaustion
- **Remediacion:** Actualizar a `jackson-databind:2.13.4`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-42004

### org.yaml : snakeyaml : 1.30

#### CVE-2022-1471 — CRITICAL — RCE via deserialization
- **Tipo:** RCE via deserialization
- **Descripcion:** Constructor class allows deserialization of any Java type
- **Remediacion:** Actualizar a `snakeyaml:2.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-1471

#### CVE-2022-25857 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** Unbounded nesting allows DoS
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-25857

#### CVE-2022-38749 — MEDIUM — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Stack overflow via malicious YAML
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38749

#### CVE-2022-38750 — MEDIUM — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Stack overflow variant
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38750

#### CVE-2022-38751 — MEDIUM — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Additional stack overflow variant
- **Remediacion:** Actualizar a `snakeyaml:1.31`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38751

#### CVE-2022-38752 — MEDIUM — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Stack overflow in parser before 1.32
- **Remediacion:** Actualizar a `snakeyaml:2.0`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-38752

#### CVE-2022-41854 — MEDIUM — DoS via stack overflow
- **Tipo:** DoS via stack overflow
- **Descripcion:** Potential stack overflow from untrusted YAML
- **Remediacion:** Actualizar a `snakeyaml:1.32`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-41854

### com.google.code.gson : gson : 2.8.6

#### CVE-2022-25647 — HIGH — DoS
- **Tipo:** DoS
- **Descripcion:** Deserialization of untrusted data via JsonParser
- **Remediacion:** Actualizar a `gson:2.8.9`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2022-25647

### org.hibernate.validator : hibernate-validator : 6.0.18.Final

#### CVE-2020-10693 — MEDIUM — Bypass
- **Tipo:** Bypass
- **Descripcion:** ConstraintValidator interpolation bypass
- **Remediacion:** Actualizar a `hibernate-validator:6.0.20.Final`
- **Referencia:** https://nvd.nist.gov/vuln/detail/CVE-2020-10693

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `jackson-databind` | 2.9.8 | **2.9.9.2** |
| `snakeyaml` | 1.30 | **2.0** |
| `gson` | 2.8.6 | **2.8.9** |
| `hibernate-validator` | 6.0.18.Final | **6.0.20.Final** |

---

## Scan Performance

| Metric | Value |
|---|---|
| Scan Time | **0s** |
| CVEs Detected | 57 |
| Artifacts Analyzed | 4 |
| Depth | N0→N4 |
