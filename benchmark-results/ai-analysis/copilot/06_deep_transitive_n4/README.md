# CVE Analysis Report — 06_deep_transitive_n4

**Scan Date:** 2026-04-03  
**Tool:** GitHub Copilot + appmod-validate-cves-for-java (GitHub Security Advisories)  
**Total CVEs Found:** 4  
**Severities:** 1 CRITICAL · 2 HIGH · 1 MEDIUM

---

## Project Description

Aplicación Maven **multi-módulo de 4 capas** (`app` → `service` → `data` → `util`) con **vulnerabilidades exclusivamente en nivel N4 (transitivas de tercer nivel)**. La cadena completa de dependencias es:

```
app (N1)
  └─ service-layer (N1 → lib-service)
       └─ data-layer (N2 → lib-service → lib-data)
            └─ util-layer (N3 → lib-data → lib-util)
                 └─ commons-collections:3.2.1   (N4)
                 └─ commons-io:2.6              (N4)
```

Este proyecto representa el caso extremo donde la vulnerabilidad está **enterrada a 4 niveles de profundidad** en la cadena de dependencias, lo que la hace prácticamente invisible para herramientas básicas de análisis o para el desarrollador que revisa el `pom.xml` del módulo raíz.

---

## Dependency Summary

| Artifact | Version | Level | CVE Count |
|---|---|---|---|
| `commons-collections` | 3.2.1 | N4 (transitivo de 3er nivel) | 2 |
| `commons-io` | 2.6 | N4 (transitivo de 3er nivel) | 2 |

---

## CVE Detail

### commons-collections : commons-collections : 3.2.1

#### CVE-2015-7501 — CRITICAL — RCE via deserialization
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** `InvokerTransformer` de Apache Commons Collections permite crear cadenas de transformaciones que invocan métodos Java arbitrarios al deserializar un objeto. Un atacante envía un payload Java serializado que, cuando `ObjectInputStream.readObject()` lo procesa, ejecuta `Runtime.getRuntime().exec(comando)` via la cadena de transformadores.
- **Punto clave sobre N4:** La presencia de esta librería en el classpath hace vulnerable a la aplicación independientemente de que sea una dependencia directa, N2, N3 o N4. La JVM carga todas las clases disponibles; la profundidad de transitividad no afecta el riesgo de explotación.
- **Impacto:** RCE en cualquier endpoint que deserialice datos no confiables con Java serialization nativa.
- **Remediación:** Forzar versión `commons-collections:3.2.2` en el `pom.xml` raíz via `<dependencyManagement>`.
- **Referencia:** https://github.com/advisories/GHSA-fjq5-5j5f-mvxh

#### CVE-2015-6420 — HIGH — RCE via deserialization (variante)
- **Tipo:** Remote Code Execution (RCE)
- **Descripción:** Variante de CVE-2015-7501 con una cadena de gadgets ligeramente diferente. Usa `ChainedTransformer` y `ConstantTransformer` en combinación con `InvokerTransformer` para lograr RCE.
- **Impacto:** Idéntico a CVE-2015-7501.
- **Remediación:** `commons-collections:3.2.2` (mismo fix).
- **Referencia:** https://github.com/advisories/GHSA-6hgm-866r-3cjv

---

### commons-io : commons-io : 2.6

#### CVE-2024-47554 — HIGH — DoS via resource exhaustion
- **Tipo:** Denial of Service (DoS)
- **Descripción:** Los métodos `NullInputStream.read(byte[])` y `NullInputStream.read(byte[], int, int)` no validan si los parámetros `offset` y `length` son negativos. Pasar valores negativos puede causar loops infinitos o allocations con tamaños incorrectos, resultando en consumo masivo de CPU/memoria y DoS del servicio.
- **Vector:** Cualquier código que use `NullInputStream` con parámetros derivados de input de usuario.
- **Remediación:** Actualizar a `commons-io:2.14.0`.
- **Referencia:** https://github.com/advisories/GHSA-78wr-2p64-hpwj

#### CVE-2021-29425 — MEDIUM — Path Traversal
- **Tipo:** Path Traversal
- **Descripción:** `FileNameUtils.normalize()` en Commons IO 2.6 no normaliza correctamente rutas que combinan separadores Unix (`/`) y Windows (`\`). Una ruta como `C:\..\..\etc\passwd` o `path/../../secret` puede no ser catch como path traversal, permitiendo acceso a archivos fuera del directorio esperado.
- **Impacto:** Lectura de archivos arbitrarios del sistema si se usa `normalize()` como única defensa contra path traversal.
- **Remediación:** Actualizar a `commons-io:2.7` o superior (recomendado 2.14.0). Complementar con validación de ruta absoluta vs. directorio base.
- **Referencia:** https://github.com/advisories/GHSA-gwrp-pvrq-jmwv

---

## Remediation Summary

| Dependency | Current Version | Fix Version |
|---|---|---|
| `commons-collections` | 3.2.1 | **3.2.2** |
| `commons-io` | 2.6 | **2.14.0** |

**Estrategia de remediación para N4:** Dado que las vulnerables son transitivas de tercer nivel, la corrección se hace via `<dependencyManagement>` en el `pom.xml` del módulo raíz:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>commons-collections</groupId>
      <artifactId>commons-collections</artifactId>
      <version>3.2.2</version>
    </dependency>
    <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>2.14.0</version>
    </dependency>
  </dependencies>
</dependencyManagement>
```

---

## AI Analysis Notes

Este proyecto es el **caso de estudio de vulnerabilidades en profundidad extrema (N4)**:
- **Punto principal:** La profundidad de la transitividad no reduce el riesgo de seguridad. Una vulnerabilidad N4 es tan explotable como una N1 si el vector de ataque (ej. deserialización Java) está activo.
- **commons-collections 3.2.1** aparece en múltiples proyectos del benchmark (también en 04 como N3), demostrando que es una dependencia histórica muy arraigada en el ecosistema Java.
- **Detección:** Solo herramientas de análisis que resuelven el árbol completo de dependencias transitivas detectarán estas vulnerabilidades. Un `grep` en `pom.xml` es insuficiente.
- **Métricas de interés para investigación:** Comparar la tasa de detección de herramientas de SCA (Software Composition Analysis) entre vulnerabilidades N1 vs. N4 para evaluar su efectividad en dependencias profundas.
- **commons-io** con CVE-2024-47554 demuestra que incluso librerías de utilidades aparentemente inocuas (I/O básico) pueden tener vectores de DoS descubiertos años después de su release.
