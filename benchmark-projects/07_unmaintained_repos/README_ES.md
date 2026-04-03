# Caso 7: Riesgo por Repositorios Poco Mantenidos (Sin CVEs)

## Escenario

Este proyecto utiliza exclusivamente librerias que **no tienen CVEs conocidos** pero que representan un **riesgo significativo de supply chain** por estar abandonadas, archivadas o con mantenimiento minimo. Este caso evalua la capacidad de las herramientas mas alla del simple escaneo de CVEs.

## Objetivo del Benchmark

Validar si la herramienta SCA puede detectar riesgos que van mas alla de CVEs:
1. Librerias sin releases recientes (anos sin actualizaciones)
2. Repositorios archivados o retirados
3. Proyectos con un solo mantenedor o ningun mantenedor activo
4. Namespaces migrados/abandonados (como net.sf.opencsv → com.opencsv)
5. Librerias que no podrian recibir patches de seguridad aunque se descubriera una vulnerabilidad

## Dependencias y Estado de Mantenimiento

| Dependencia | Version | Ultimo Release | Estado | Stars GitHub | Mantenedores | CVEs |
|-------------|---------|---------------|--------|-------------|-------------|------|
| `oro:oro` | 2.0.8 | 2003 | Apache Attic (retirado) | N/A | 0 activos | 0 |
| `findbugs:jsr305` | 3.0.2 | 2017 | Abandonado por Google | ~100 | 0 activos | 0 |
| `jcip-annotations` | 1.0 | 2007 | Release unico, sin repo | N/A | 0 activos | 0 |
| `paranamer` | 2.8 | 2017 | Mantenimiento minimo | ~50 | 1 inactivo | 0 |
| `opencsv` (net.sf) | 2.3 | 2011 | Migrado a com.opencsv | N/A | 0 activos | 0 |

## Riesgos Identificados

### 1. Apache ORO (`oro:oro:2.0.8`)
- Proyecto oficialmente retirado a Apache Attic
- Sin actualizaciones desde hace 20+ anos
- Si se descubre un bug de seguridad en el motor regex, no hay quien lo corrija

### 2. JSR-305 (`com.google.code.findbugs:jsr305:3.0.2`)
- Google abandono el proyecto FindBugs
- JSR-305 nunca fue estandarizado oficialmente
- Ampliamente usado como dependencia transitiva pero sin mantenimiento

### 3. JCIP Annotations (`net.jcip:jcip-annotations:1.0`)
- Un solo release en 2007, nunca actualizado
- Sin repositorio publico de codigo fuente activo
- Imposible reportar o corregir issues de seguridad

### 4. Paranamer (`com.thoughtworks:paranamer:2.8`)
- Mantenedor unico que dejo de estar activo
- Ultima actividad significativa en 2017
- Accede a bytecode de clases — superficie de ataque potencial sin supervision

### 5. OpenCSV Legacy (`net.sf.opencsv:opencsv:2.3`)
- Namespace `net.sf` abandonado; el proyecto migro a `com.opencsv`
- Cualquier persona que controle el namespace viejo podria publicar una version maliciosa
- Riesgo clasico de typosquatting/namespace hijacking

## Que deben detectar las herramientas

Las herramientas SCA avanzadas (como Snyk, Socket.dev, Deps.dev) van mas alla de CVEs y evaluan:
- **Maintenance score**: frecuencia de commits y releases
- **Contributor count**: numero de mantenedores activos
- **Project health**: issues abiertos, PR sin merge, archivado
- **Namespace risk**: migraciones de artefactos, namespaces abandonados
- **Supply chain risk**: potencial de compromiso por falta de governance

## Codigo Demo

`App.java` usa cada libreria de forma convencional:
- **ORO**: compilacion y matching de patrones regex Perl5
- **JSR-305**: anotaciones `@Nonnull`, `@Nullable` para null-safety
- **JCIP**: anotacion `@ThreadSafe` para documentar thread-safety
- **Paranamer**: extraccion de nombres de parametros desde bytecode
- **OpenCSV**: parseo basico de archivos CSV
