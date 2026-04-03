# CVE Analysis Report — 05_combined_n2_and_n3

**Scan Date:** 2026-04-03  
**Tool:** GitHub Copilot + appmod-validate-cves-for-java (GitHub Security Advisories)  
**Total CVEs Found:** 61  
**Severities:** 12 CRITICAL · 42 HIGH · 7 MEDIUM

---

## Project Description

Proyecto **Gradle multi-módulo** (`app` + `services` + `persistence`) con la **mayor cantidad de CVEs** del benchmark: 61 vulnerabilidades distribuidas en dependencias N2 y N3. El contribuyente principal es `jackson-databind:2.9.8` con 53 CVEs (incluidas 12 variantes CRITICAL de RCE via deserialization). El proyecto demuestra el efecto acumulativo de usar versiones antiguas de librerías ampliamente usadas.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `snakeyaml` | 1.30 | N2 (transitivo) | 7 |
| `gson` | 2.8.6 | N2 (transitivo) | 1 |
| `jackson-databind` | 2.9.8 | N3 (transitivo de 2do nivel) | 53 |
| `hibernate-validator` | 6.0.18.Final | N3 (transitivo) | 0 |

---

## CVE Detail

### org.yaml : snakeyaml : 1.30

Versión 1.30 comparte las mismas vulnerabilidades que 1.29 (ver proyecto 03). Resumen:

| CVE | Severity | Tipo |
|---|---|---|
| CVE-2022-1471 | HIGH | RCE via deserialization — Constructor instancia tipos Java arbitrarios |
| CVE-2022-25857 | HIGH | DoS — Sin límite de profundidad en colecciones |
| CVE-2022-38749 | MEDIUM | DoS — Stack overflow en parser |
| CVE-2022-38750 | MEDIUM | DoS — Stack overflow (variante 2) |
| CVE-2022-38751 | MEDIUM | DoS — Stack overflow (variante 3) |
| CVE-2022-38752 | MEDIUM | DoS — Stack overflow (variante 4) |
| CVE-2022-41854 | MEDIUM | DoS — Stack overflow adicional |

**Fix:** `snakeyaml:2.0`

---

### com.google.code.gson : gson : 2.8.6

#### CVE-2022-25647 — HIGH — DoS via class deserialization
- **Tipo:** Denial of Service (DoS)
- **Descripción:** Al deserializar un objeto del tipo `Class` usando `TypeAdapterFactory.create()` con `type.getRawType()`, Gson intenta resolver la clase via reflexión. Con un input malicioso que referencia clases inexistentes o circulares, se produce un `StackOverflowError` que crashea el proceso Java.
- **Impacto:** DoS en aplicaciones que usen `Gson.fromJson()` con datos de clase no confiables.
- **Remediación:** Actualizar a `gson:2.11.0`.
- **Referencia:** https://github.com/advisories/GHSA-4jrv-ppp4-jm57

---

### com.fasterxml.jackson.core : jackson-databind : 2.9.8

`jackson-databind:2.9.8` acumula **53 CVEs** — la mayor concentración de vulnerabilidades en una sola librería del benchmark. La gran mayoría son **gadgets de deserialización** que permiten RCE cuando `default typing` está habilitado.

#### ¿Qué es "default typing" en Jackson?
La opción `ObjectMapper.enableDefaultTyping()` o `@JsonTypeInfo` con `defaultImpl` permite que Jackson use el campo `@class` en el JSON para instanciar cualquier clase Java. Esto convierte cada endpoint Jackson en un vector de RCE, ya que un atacante puede especificar el tipo a instanciar.

#### CVEs CRITICAL (12) — RCE via deserialization gadgets

| CVE | Gadget (clase víctima) | Advisory |
|---|---|---|
| CVE-2019-14379 | `net.sf.ehcache` | GHSA-2jjv-x69h-vg65 |
| CVE-2019-14540 | `com.mchange.v2.c3p0` | GHSA-h822-r4r5-v8jg |
| CVE-2019-16335 | `net.sf.ehcache` | GHSA-xcfj-939q-hq83 |
| CVE-2019-16942 | `commons-dbcp`, `p6spy` | GHSA-mx7p-6679-8g3q |
| CVE-2019-16943 | `com.p6spy.engine` | GHSA-fmci-5px5-p7q7 |
| CVE-2019-17267 | `net.sf.ehcache` | GHSA-288x-38rj-q8qv |
| CVE-2019-17531 | `org.apache.log` | GHSA-gjmw-vf9h-g25v |
| CVE-2019-20330 | `net.sf.ehcache`, `com.nqadmin` | GHSA-rfx6-vp9g-rp44 |
| CVE-2020-8840 | `openjpa`, `xalan` | GHSA-4w82-r329-3q67 |
| CVE-2020-9546 | `com.ibatis.sqlmap` | GHSA-hyqf-jv5m-p736 |
| CVE-2020-9547 | `com.ibatis.sqlmap.engine` | GHSA-288c-cq79-chwc |
| CVE-2020-9548 | `br.com.anteros`, `anteros-dbcp` | GHSA-ppcg-xgx2-p6q4 |

**Descripción común:** Todos estos CVEs siguen el mismo patrón — el JSON contiene `{"@class": "com.vulnerable.Gadget", ...}` y Jackson instancia esa clase al deserializar. La clase gadget, al ser instanciada, ejecuta código arbitrario via sus constructores o setters. Cada CVE corresponde a un gadget diferente encontrado en bibliotecas comunes de Java.

**Impacto:** RCE completo en cualquier endpoint que acepte JSON con default typing habilitado.

#### CVEs HIGH (39) — RCE via deserialization gadgets adicionales

Todas las 39 variantes HIGH siguen el mismo patrón de gadget. Algunas notables:

| CVE | Tipo específico | Nota |
|---|---|---|
| CVE-2020-25649 | XXE | Serialización XML desde XmlMapper sin protección XXE |
| CVE-2020-36518 | DoS | JSON profundamente anidado → OOM sin límite de profundidad |
| CVE-2022-42003 | DoS | UNWRAP_SINGLE_VALUE_ARRAYS sin límite de profundidad |
| CVE-2022-42004 | DoS | BeanDeserializer sin límite en arrays anidados |
| CVE-2021-20190 | RCE | Gadget de `javax.swing.UIDefaults` via JNDI |
| CVE-2020-10650 | RCE | Gadgets adicionales no listados en versión 2.9.8 |

El resto de los 39 HIGH son gadgets específicos de clases en `org.apache.*`, `com.oracle.*`, `com.newrelic.*`, `com.mysql.*`, `org.docx4j.*`, etc., todos con el mismo vector de deserialización insegura.

#### CVEs MEDIUM (2)

| CVE | Tipo | Descripción |
|---|---|---|
| CVE-2019-12384 | Info Disclosure | Gadget de logback-classic permite leer archivos locales vía XXE |
| CVE-2019-12814 | Info Disclosure | Gadget de jdom permite leer archivos locales vía XMLBeans |

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `snakeyaml` | 1.30 | **2.0** |
| `gson` | 2.8.6 | **2.11.0** |
| `jackson-databind` | 2.9.8 | **2.15.x** |

**Nota importante sobre jackson-databind:** La remediación definitiva es:
1. Actualizar a `2.15.x` o superior.
2. **Deshabilitar `default typing`** (`ObjectMapper.activateDefaultTyping()`) por completo.
3. Usar `@JsonTypeInfo` con tipos conocidos y una allowlist estricta de subtipos.

---

## AI Analysis Notes

Este proyecto es el **estudio de caso más extremo del benchmark**:
- **53 CVEs en un solo artefacto** (`jackson-databind:2.9.8`) demuestran cómo una versión muy antigua de una librería ampliamente usada puede acumular vulnerabilidades durante años.
- La versión 2.9.8 data de 2018; la comunidad publicó gadgets nuevos durante 2019-2022 sin cesar.
- **La causa raíz no es solo la versión antigua**: es el diseño de la feature `default typing` que permite instanciar tipos Java arbitrarios desde JSON. Esta feature es intrínsecamente insegura.
- Como proyecto Gradle, la remediación requiere actualizar `build.gradle` en cada sub-módulo o en el `build.gradle` raíz con `configurations.all { resolutionStrategy.force 'com.fasterxml.jackson.core:jackson-databind:2.15.x' }`.
- **Contexto de riesgo real:** Este escenario es común en aplicaciones Spring heredadas que usan Spring Boot 1.x o 2.0.x donde jackson-databind 2.9.x era el default.
- Los CVEs de tipo DoS (CVE-2020-36518, CVE-2022-42003, CVE-2022-42004) son explotables **sin** default typing habilitado — aplican a cualquier aplicación que parsee JSON de fuentes no confiables.
