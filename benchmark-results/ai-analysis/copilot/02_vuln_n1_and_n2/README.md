# CVE Analysis Report — 02_vuln_n1_and_n2

**Scan Date:** 2026-04-03  
**Tool:** GitHub Copilot + appmod-validate-cves-for-java (GitHub Security Advisories)  
**Total CVEs Found:** 32  
**Severities:** 4 CRITICAL · 25 HIGH · 3 MEDIUM

---

## Project Description

Aplicación Maven con **vulnerabilidades en nivel N1 (directas) y N2 (transitivas de primer nivel)**. Las dependencias directas son `struts2-core:2.5.25` y `xstream:1.4.17`, que traen consigo un número muy elevado de CVEs. Adicionalmente, `commons-fileupload` y `commons-io` son transitivas de Struts2 con sus propias vulnerabilidades.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `struts2-core` | 2.5.25 | N1 (directo) | 10 |
| `xstream` | 1.4.17 | N1 (directo) | 18 |
| `commons-fileupload` | 1.4 | N2 (transitivo de struts2) | 2 |
| `commons-io` | 2.6 | N2 (transitivo de struts2) | 2 |

---

## CVE Detail

### org.apache.struts : struts2-core : 2.5.25

#### CVE-2020-17530 — CRITICAL — RCE via OGNL (S2-061)
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** Forced double OGNL evaluation en Struts2 cuando se usan ciertos tags con atributos que incluyen `%{...}`. Un atacante puede inyectar expresiones OGNL en parámetros HTTP que son evaluadas dos veces por el framework.
- **Impacto:** RCE sin autenticación en cualquier acción Struts2 con tags vulnerables.
- **Remediación:** Actualizar a `struts2-core:6.8.0`.
- **Referencia:** https://github.com/advisories/GHSA-c939-r8m7-4rqx

#### CVE-2021-31805 — CRITICAL — RCE via OGNL (S2-062)
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** Parche incompleto de CVE-2020-17530. Struts2 aún permite forced double evaluation bajo condiciones específicas relacionadas con tags `<s:if>` y similar con expresiones anidadas.
- **Impacto:** RCE en aplicaciones Struts2 con el fix anterior aplicado.
- **Remediación:** Actualizar a `struts2-core:6.8.0`.
- **Referencia:** https://github.com/advisories/GHSA-74q3-f3p5-p49q

#### CVE-2023-50164 — CRITICAL — Path Traversal en File Upload (S2-066)
- **Tipo:** Path Traversal → RCE
- **Descripción:** El parámetro filename en la funcionalidad de upload de archivos no es sanitizado correctamente. Un atacante puede cargar un archivo en una ubicación arbitraria del servidor usando `../` en el nombre, permitiendo sobreescribir archivos del sistema o cargar webshells JSP.
- **Impacto:** Escritura arbitraria de archivos, RCE via webshell si el directorio de deploy está en el path accessible.
- **Remediación:** Actualizar a `struts2-core:6.8.0`.
- **Referencia:** https://github.com/advisories/GHSA-fp4m-h37c-q53c

#### CVE-2024-53677 — CRITICAL — Path Traversal en File Upload (S2-067)
- **Tipo:** Path Traversal → RCE
- **Descripción:** Vulnerabilidad similar a CVE-2023-50164 pero con un vector de ataque distinto en el sistema de file upload de Struts2. El fix para S2-066 fue insuficiente.
- **Impacto:** RCE via escritura arbitraria de archivos al servidor.
- **Remediación:** Actualizar a `struts2-core:6.8.0`.
- **Referencia:** https://github.com/advisories/GHSA-3qhh-6xvj-fj37

#### CVE-2023-34396 — HIGH — DoS via OGNL injection
- **Tipo:** Denial of Service (DoS)
- **Descripción:** Uso de memoria sin límite en evaluación de expresiones OGNL maliciosas en Struts2. Input específico puede causar consumo excesivo de heap.
- **Remediación:** Actualizar a `struts2-core:6.8.0`.
- **Referencia:** https://github.com/advisories/GHSA-qr7j-263x-vhgv

#### CVE-2023-41835 — HIGH — DoS via upload multipart
- **Tipo:** Denial of Service (DoS)
- **Descripción:** Fallo en el manejo de uploads multipart malformados que puede llevar al consumo descontrolado de recursos del servidor.
- **Remediación:** Actualizar a `struts2-core:6.8.0`.
- **Referencia:** https://github.com/advisories/GHSA-hq4x-r4pg-whr7

#### CVE-2025-64775 — HIGH — RCE via OGNL
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** Nueva variante de inyección OGNL en Struts2 2.x descubierta en 2025. Permite RCE en configuraciones no mitigadas.
- **Remediación:** Actualizar a `struts2-core:6.8.0`.
- **Referencia:** https://github.com/advisories/GHSA-5g4p-2ghq-f4ww

#### CVE-2025-66675 — HIGH — DoS
- **Tipo:** Denial of Service (DoS)
- **Descripción:** Condición de agotamiento de recursos en el procesamiento de requests en Struts2 versiones afectadas.
- **Remediación:** Actualizar a `struts2-core:6.8.0`.
- **Referencia:** https://github.com/advisories/GHSA-v5gv-qq3m-x4jw

#### CVE-2025-68493 — HIGH — Security Bypass
- **Tipo:** Security Bypass
- **Descripción:** Bypass de controles de seguridad en Struts2 debido a validación incorrecta en el dispatch de acciones.
- **Remediación:** Actualizar a `struts2-core:6.8.0`.
- **Referencia:** https://github.com/advisories/GHSA-9v2q-4vgh-5cvq

#### CVE-2023-34149 — MEDIUM — DoS
- **Tipo:** Denial of Service (DoS)
- **Descripción:** Consumo de memoria no limitado en ciertas condiciones de proceso de request en Struts2, causado por allocations sin upper bound.
- **Remediación:** Actualizar a `struts2-core:6.8.0`.
- **Referencia:** https://github.com/advisories/GHSA-gfjh-rcph-7w2m

---

### com.thoughtworks.xstream : xstream : 1.4.17

XStream es una librería de serialización XML→Java. Versión 1.4.17 contiene 18 gadgets de deserialización no seguros identificados en 2021-2024. El patrón común: un XML malicioso con tipos Java arbitrarios puede ejecutar código, manipular el filesystem o realizar SSRF.

#### CVE-2021-39139 — HIGH — RCE via deserialization
- Gadget de `javax.imageio` al deserializar XML permite RCE si el tipo permitido incluye clases de image processing.
- **Fix:** 1.4.21

#### CVE-2021-39140 — MEDIUM — DoS via deserialization  
- Stack overflow causado por referencias circulares no controladas al deserializar XML.
- **Fix:** 1.4.21

#### CVE-2021-39141 a CVE-2021-39154 — HIGH — RCE via deserialization (12 variantes)
- Múltiples gadgets de deserialización usando clases de `java.awt`, `javax.xml`, `com.sun.xml.internal`, `com.sun.rowset`, etc. Cada gadget usa una cadena de invocación diferente pero el resultado es RCE o SSRF.
- **Fix:** 1.4.21

#### CVE-2021-43859 — HIGH — DoS via wildcard
- Uso de wildcards en tipos permitidos por XStream permite bypass de la lista blanca (allowlist), abriendo vectores de deserialización.
- **Fix:** 1.4.21

#### CVE-2022-40151 — HIGH — DoS via stack overflow
- XML con referencias de tipo recursivas causa StackOverflowError en el parser de XStream.
- **Fix:** 1.4.21

#### CVE-2022-41966 — HIGH — DoS via stack overflow
- Variante de CVE-2022-40151 con un vector de entrada diferente que causa el mismo crash por recursión.
- **Fix:** 1.4.21

#### CVE-2024-47072 — HIGH — DoS via stack overflow
- Input XML específicamente diseñado para causar stack overflow en el procesamiento interno de tipos de XStream.
- **Fix:** 1.4.21

---

### commons-fileupload : commons-fileupload : 1.4

#### CVE-2023-24998 — HIGH — DoS via unlimited parts
- **Tipo:** Denial of Service (DoS)
- **Descripción:** FileUpload no impone límite en la cantidad de partes de un request multipart. Un atacante puede enviar un request con millones de partes vacías, causando agotamiento de memoria y CPU en el servidor.
- **Remediación:** Actualizar a `commons-fileupload:1.6`.
- **Referencia:** https://github.com/advisories/GHSA-hfrx-6qgj-fp6c

#### CVE-2025-48976 — HIGH — DoS via malformed multipart
- **Tipo:** Denial of Service (DoS)
- **Descripción:** Manejo inseguro de requests multipart malformadas en commons-fileupload que puede causar consumo excesivo de recursos.
- **Remediación:** Actualizar a `commons-fileupload:1.6`.
- **Referencia:** https://github.com/advisories/GHSA-x4v7-jxjh-4h9r

---

### commons-io : commons-io : 2.6

#### CVE-2021-29425 — MEDIUM — Path Traversal
- **Tipo:** Path Traversal
- **Descripción:** `FileNameUtils.normalize()` en Commons IO 2.6 no normaliza correctamente rutas con separadores mixtos (slash/backslash). Una ruta como `../../etc/passwd` puede no ser filtrada, allowing acceso a archivos fuera del directorio esperado.
- **Remediación:** Actualizar a `commons-io:2.7` o superior (se recomienda 2.14.0).
- **Referencia:** https://github.com/advisories/GHSA-gwrp-pvrq-jmwv

#### CVE-2024-47554 — HIGH — DoS via resource exhaustion
- **Tipo:** Denial of Service (DoS)
- **Descripción:** Los métodos `NullInputStream.read(byte[])` y `NullInputStream.read(byte[], int, int)` aceptan parámetros negativos sin validación. Esto puede causar loops infinitos o allocations masivas, resultando en DoS.
- **Remediación:** Actualizar a `commons-io:2.14.0`.
- **Referencia:** https://github.com/advisories/GHSA-78wr-2p64-hpwj

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `struts2-core` | 2.5.25 | **6.8.0** |
| `xstream` | 1.4.17 | **1.4.21** |
| `commons-fileupload` | 1.4 | **1.6** |
| `commons-io` | 2.6 | **2.14.0** |

---

## AI Analysis Notes

Este proyecto demuestra la **combinación de CVEs en dependencias directas e indirectas de primer nivel**:
- **Struts2**: Framework MVC históricamente problemático. Sus CVEs son casi todos RCE via OGNL injection — el lenguaje de expresiones de Struts es el vector de ataque principal.
- **XStream**: Librería de serialización con el mayor número de gadgets de deserialización conocidos en el ecosistema Java. La defensa moderna requiere usar una allowlist estricta de tipos permitidos.
- **commons-fileupload**: Las vulnerabilidades DoS de multipart son clásicas — ausencia de límites en recursos de request processing.
- **commons-io**: Path traversal en normalización + DoS por parámetros no validados.
- El patrón de mayor riesgo: Struts2 + commons-fileupload combinados permiten **CVE-2023-50164** (path traversal en file upload → webshell).
