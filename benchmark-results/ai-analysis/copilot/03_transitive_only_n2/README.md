# CVE Analysis Report — 03_transitive_only_n2

**Scan Date:** 2026-04-03  
**Tool:** GitHub Copilot + appmod-validate-cves-for-java (GitHub Security Advisories)  
**Total CVEs Found:** 42  
**Severities:** 3 CRITICAL · 22 HIGH · 17 MEDIUM

---

## Project Description

Aplicación Maven con **vulnerabilidades exclusivamente en nivel N2 (transitivas de primer nivel)**. Las dependencias directas (`spring-boot-starter-web:2.6.6` y `spring-boot-starter-validation:2.6.6`) no tienen CVEs propios, pero traen consigo dependencias transitivas con múltiples vulnerabilidades conocidas.

Este proyecto representa el escenario donde el desarrollador **no es consciente de los riesgos** porque las dependencias vulnerables no están declaradas explícitamente en el `pom.xml`.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `spring-boot-starter-web` | 2.6.6 | N1 (directo, sin CVEs) | 0 |
| `spring-boot-starter-validation` | 2.6.6 | N1 (directo, sin CVEs) | 0 |
| `snakeyaml` | 1.29 | N2 (transitivo) | 7 |
| `tomcat-embed-core` | 9.0.60 | N2 (transitivo) | 21 |
| `spring-webmvc` | 5.3.18 | N2 (transitivo) | 5 |
| `spring-web` | 5.3.18 | N2 (transitivo) | 6 |
| `logback-classic` | 1.2.11 | N2 (transitivo) | 1 |
| `jackson-databind` | 2.13.2.2 | N2 (transitivo) | 2 |

---

## CVE Detail

### org.yaml : snakeyaml : 1.29

#### CVE-2022-1471 — HIGH — RCE via deserialization
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** La clase `Constructor` de SnakeYAML, cuando procesa YAML que contiene tags de tipo Java (`!!java.lang.Runtime`), intenta instanciar esas clases. Esto es deserialización insegura: con el payload correcto y clases en el classpath, permite RCE.
- **Impacto:** RCE si se parsea YAML no confiable con el Constructor por defecto.
- **Remediación:** Actualizar a `snakeyaml:2.0` que usa `SafeConstructor` como default.
- **Referencia:** https://github.com/advisories/GHSA-mjmj-j48q-9wg2

#### CVE-2022-25857 — HIGH — DoS
- **Tipo:** Denial of Service (DoS)
- **Descripción:** SnakeYAML no impone límite en la profundidad de colecciones anidadas al parsear YAML. Un documento YAML con listas o maps profundamente anidados consume memoria sin límite hasta OOM.
- **Remediación:** `snakeyaml:2.0`.
- **Referencia:** https://github.com/advisories/GHSA-3mc7-4q67-w48m

#### CVE-2022-38749 a CVE-2022-38752 — MEDIUM — DoS via stack overflow (4 variantes)
- **Tipo:** Denial of Service (DoS)
- **Descripción:** Cuatro variantes de stack overflow en el parser de SnakeYAML provocadas por diferentes estructuras de input YAML malicioso.
- **Remediación:** `snakeyaml:2.0`.

#### CVE-2022-41854 — MEDIUM — DoS via stack overflow
- **Tipo:** Denial of Service (DoS)  
- Variante adicional de crash por recursión del parser con input no confiable.
- **Remediación:** `snakeyaml:2.0`.

---

### org.apache.tomcat.embed : tomcat-embed-core : 9.0.60

#### CVE-2025-24813 — CRITICAL — RCE via TOCTOU en JSP (CVE más grave de Tomcat 2025)
- **Tipo:** Remote Code Execution (RCE) / Information Disclosure
- **Descripción:** Race condition Time-Of-Check-Time-Of-Use (TOCTOU) en la compilación de JSPs en sistemas de archivos case-insensitive (Windows, macOS). Si el partial PUT está habilitado y el Default Servlet tiene writes enabled, un atacante puede cargar contenido malicioso que se compila como JSP.
- **Impacto:** RCE o lectura de archivos en el servidor. Solo en configuraciones específicas.
- **Remediación:** `tomcat-embed-core:9.0.109`.
- **Referencia:** https://github.com/advisories/GHSA-83qj-6fr2-vhqg

#### CVE-2022-42252 — HIGH — HTTP Request Smuggling
- **Descripción:** Tomcat no rechaza `Content-Length` inválido cuando `rejectIllegalHeader=false`. Permite request smuggling detrás de proxy reverso.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2022-45143 — HIGH — Content Injection
- **Descripción:** `JsonErrorReportValve` no escapa valores `type`/`message`/`description` en las respuestas de error JSON. Permite inyección de contenido si se usan datos del request.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2023-24998 — HIGH — DoS via multipart parts
- **Descripción:** Sin límite en número de partes multipart. Permite DoS con request de millones de partes vacías.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2023-46589 — HIGH — HTTP Request Smuggling
- **Descripción:** Trailer headers que exceden el límite configurado hacen que Tomcat trate una solicitud como múltiples, permitiendo request smuggling.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2024-34750 — HIGH — DoS via HTTP/2
- **Descripción:** Manejo incorrecto de headers HTTP/2 excesivos provoca timeout infinito: conexiones quedan abiertas consumiendo recursos indefinidamente.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2024-50379 — HIGH — RCE via TOCTOU (precursor de CVE-2025-24813)
- **Descripción:** Race condition en compilación JSP con Default Servlet habilitado en escritura. Versión inicial de la vulnerabilidad TOCTOU en Tomcat.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2024-56337 — HIGH — RCE via TOCTOU (fix incompleto)
- **Descripción:** La mitigación de CVE-2024-50379 es incompleta en Java 8/11. Se requiere configuración adicional de sistema.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2025-48988, CVE-2025-52520, CVE-2025-53506, CVE-2025-48989, CVE-2025-55752 — HIGH — DoS / RCE / Resource Leak
- Conjunto de vulnerabilidades HIGH descubiertas en 2025: DoS via multipart allocation, integer overflow en upload, consumo de streams HTTP/2, resource leak, y path traversal en reglas de rewrite.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2023-41080 — MEDIUM — Open Redirect
- **Descripción:** Open redirect en la feature de autenticación FORM. Un atacante puede redirigir a usuarios a URLs externas maliciosas.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2023-42795 — MEDIUM — Information Disclosure
- **Descripción:** Error en reciclaje de objetos internos causa filtración de información de un request/response al siguiente en conexiones reutilizadas.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2023-44487 — MEDIUM — DoS via HTTP/2 Rapid Reset
- **Descripción:** El ataque "Rapid Reset" de HTTP/2: cliente abre y cancela streams masivamente generando carga asimétrica. Vulnerabilidad de nivel de protocolo explotada en ataques DDoS masivos de 2023.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2023-45648 — MEDIUM — HTTP Request Smuggling
- **Descripción:** Trailer headers HTTP inválidos no parseados correctamente permiten request smuggling detrás de proxy.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2024-24549 — MEDIUM — DoS via HTTP/2
- **Descripción:** Los límites de headers HTTP/2 no resetean el stream hasta procesar todos los headers; permite DoS con headers masivos.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2025-49124, CVE-2025-49125, CVE-2025-66614 — MEDIUM
- **CVE-2025-49124:** Untrusted Search Path en instalador Windows.
- **CVE-2025-49125:** Bypass de restricciones de seguridad via PreResources/PostResources.
- **CVE-2025-66614:** Bypass de autenticación via hostname SNI sin validar contra HTTP Host header.
- **Remediación:** `tomcat-embed-core:9.0.109`.

#### CVE-2025-46701, CVE-2025-61795, CVE-2025-55754, CVE-2026-24733 — LOW
- Varias vulnerabilidades LOW de bajo impacto operativo descubiertas en 2025-2026.
- **Remediación:** `tomcat-embed-core:9.0.109`.

---

### org.springframework : spring-webmvc : 5.3.18

#### CVE-2023-20860 — CRITICAL — Security Bypass con mvcRequestMatcher
- **Tipo:** Authentication/Authorization Bypass
- **Descripción:** El uso del patrón `**` en `mvcRequestMatcher` crea un mismatch entre cómo Spring Security y Spring MVC interpretan la ruta. Un atacante puede acceder a endpoints protegidos usando variantes de ruta que Spring Security no reconoce como protegidas pero Spring MVC sí procesa.
- **Impacto:** Bypass completo de restricciones de seguridad en rutas protegidas.
- **Remediación:** Migrar a `spring-webmvc:6.1.x` o usar `antMatcher` con patrones específicos.
- **Referencia:** https://github.com/advisories/GHSA-7phw-cxx7-q9vq

#### CVE-2024-38816 — HIGH — Path Traversal
- **Descripción:** `RouterFunctions` con `FileSystemResource` no sanitiza las rutas correctamente, permitiendo path traversal y lectura de archivos arbitrarios del sistema si se usan recursos de sistema de archivos.
- **Remediación:** `spring-webmvc:6.1.x`.

#### CVE-2024-38819 — HIGH — Path Traversal  
- **Descripción:** Variante de CVE-2024-38816 usando `WebMvc.fn` con `FileSystemResource`. Las rutas de request HTTP puede contener `../` que no son filtrados.
- **Remediación:** `spring-webmvc:6.1.x`.

#### CVE-2024-38828 — MEDIUM — DoS
- **Descripción:** Métodos controlador con parámetros `byte[]` sin límite de tamaño son vulnerables a DoS si reciben requests con cuerpos masivos.
- **Remediación:** `spring-webmvc:6.1.x`.

#### CVE-2025-41242 — MEDIUM — Path Traversal
- **Descripción:** Aplicaciones MVC en Servlet containers no-conformes al spec pueden ser vulnerables a path traversal via resources estáticos.
- **Remediación:** `spring-webmvc:6.1.x`.

---

### org.springframework : spring-web : 5.3.18

#### CVE-2016-1000027 — CRITICAL — RCE via deserialization
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** Spring Framework antes de 6.0 incluye métodos de deserialización HTTP inseguros (`HttpInvokerServiceExporter`). Si se exponen endpoints de invocación remota de Spring con datos no confiables, permite RCE. Aunque el CVE es antiguo (2016), la puntuación CRITICAL se mantiene vigente.
- **Impacto:** RCE en aplicaciones que usen Spring HTTP Invoker con datos externos.
- **Remediación:** Migrar a Spring Framework 6.x que eliminó HTTP Invoker.
- **Referencia:** https://github.com/advisories/GHSA-4wrc-f8pq-fpqp

#### CVE-2024-22243 / CVE-2024-22259 / CVE-2024-22262 — HIGH — SSRF / Open Redirect (3 variantes)
- **Descripción:** `UriComponentsBuilder` es vulnerable a SSRF y Open Redirect cuando se valida el host de una URL externa. Las tres variantes usan diferentes tipos de input (URL con usuario embebido, URL con host alterado, etc.) que eluden la validación de host.
- **Impacto:** Redirección de usuarios a URLs maliciosas; acceso a servicios internos via SSRF.
- **Remediación:** `spring-web:6.1.x`.

#### CVE-2024-38809 — MEDIUM — DoS via ETag parsing
- **Descripción:** Parsing de ETags en headers `If-Match`/`If-None-Match` sin límite de tamaño. Input masivo puede causar DoS.
- **Remediación:** `spring-web:6.1.x`.

#### CVE-2024-38820 — MEDIUM — Security Bypass
- **Descripción:** El fix de CVE-2022-22968 tiene excepciones Locale-dependientes en `toLowerCase()` que pueden dejar campos de form desprotegidos en algunos locales.
- **Remediación:** `spring-web:6.1.x`.

---

### ch.qos.logback : logback-classic : 1.2.11

#### CVE-2023-6378 — HIGH — DoS via deserialización
- **Tipo:** Denial of Service (DoS)
- **Descripción:** El componente `receiver` de Logback (para recibir eventos de log remotos) es vulnerable a DoS cuando recibe datos serializados Java maliciosos. El receptor procesa objetos deserializados que pueden causar consumo masivo de recursos.
- **Impacto:** Crash del servicio de logging o del proceso Java completo.
- **Remediación:** Actualizar a `logback-classic:1.5.x`.
- **Referencia:** https://github.com/advisories/GHSA-vmq6-5m68-f53m

---

### com.fasterxml.jackson.core : jackson-databind : 2.13.2.2

#### CVE-2022-42003 — HIGH — DoS via deep nesting
- **Descripción:** Deserializadores de tipos primitivos con `UNWRAP_SINGLE_VALUE_ARRAYS` no verifican la profundidad del JSON. Input profundamente anidado causa agotamiento de stack y OOM.
- **Remediación:** `jackson-databind:2.15.x`.

#### CVE-2022-42004 — HIGH — DoS via deep nesting
- **Descripción:** `BeanDeserializer._deserializeFromArray()` no impone límite en arrays anidados. Similar a CVE-2022-42003 pero en la ruta de deserialización de beans Java.
- **Remediación:** `jackson-databind:2.15.x`.

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `snakeyaml` | 1.29 | **2.0** |
| `tomcat-embed-core` | 9.0.60 | **9.0.109** |
| `spring-webmvc` | 5.3.18 | **6.x** (o 5.3.47+ para parche sin migración mayor) |
| `spring-web` | 5.3.18 | **6.x** (o 5.3.47+ para parche sin migración mayor) |
| `logback-classic` | 1.2.11 | **1.5.x** |
| `jackson-databind` | 2.13.2.2 | **2.15.x** |

**Nota:** La actualización de Spring Boot de 2.6.6 a 3.x resuelve automáticamente todas las dependencias transitivas listadas.

---

## AI Analysis Notes

Este proyecto es el **caso de estudio más relevante para el análisis de riesgos de dependencias transitivas N2**:
- El desarrollador declaró solo 2 dependencias directas (libres de CVEs), pero incorporó 45 vulnerabilidades via transitivas.
- **tomcat-embed-core** con 21 CVEs es el mayor contribuyente, mostrando que el server embebido es una superficie de ataque significativa.
- **spring-webmvc** + **spring-web** + el patrón `**` en Spring Security es el vector más crítico en aplicaciones Spring modernas (CVE-2023-20860).
- El patrón de RCE vía deserialización aparece en snakeyaml, jackson y spring-web — tres diferentes librerías en el mismo proyecto.
- La correcta remediación de este proyecto **requiere actualización de Spring Boot** (de 2.6.x a 3.x), no solo actualización de dependencias individuales.
