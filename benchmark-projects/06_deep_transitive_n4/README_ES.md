# Caso 6: Vulnerabilidades Solo en el Cuarto Nivel (N4)

## Escenario

Proyecto multi-modulo Maven con **4 niveles de profundidad** donde las vulnerabilidades se encuentran **exclusivamente en el cuarto nivel (N4)** del arbol de dependencias. Tres capas de modulos internos (todos limpios) separan la aplicacion de las librerias vulnerables.

## Objetivo del Benchmark

Validar que la herramienta SCA:
1. Resuelve arboles de dependencias de 4+ niveles de profundidad
2. No trunca el analisis en niveles superficiales (N1-N3)
3. Detecta vulnerabilidades en niveles muy profundos del arbol
4. Este es el caso mas dificil para herramientas SCA que limitan la profundidad de analisis

## Estructura del Proyecto

```
06_vuln_solo_n4/
├── pom.xml                     (parent POM)
├── lib-deep/                   (N3 desde app — depende de libs vulnerables)
│   ├── pom.xml                 (commons-collections:3.2.1, commons-io:2.6)
│   └── src/.../CollectionHelper.java
├── lib-middle/                 (N2 desde app — depende de lib-deep)
│   ├── pom.xml
│   └── src/.../DataProcessor.java
├── lib-outer/                  (N1 desde app — depende de lib-middle)
│   ├── pom.xml
│   └── src/.../FileService.java
└── app/                        (aplicacion principal)
    ├── pom.xml                 (solo depende de lib-outer)
    └── src/.../App.java
```

## Arbol de Dependencias (desde perspectiva de app/)

```
app (pom.xml)
└── lib-outer:1.0.0                            ← N1 LIMPIO
    └── lib-middle:1.0.0                       ← N2 LIMPIO
        └── lib-deep:1.0.0                     ← N3 LIMPIO
            ├── commons-collections:3.2.1      ← N4 VULNERABLE
            │   (CVE-2015-6420, CVE-2015-7501)
            └── commons-io:2.6                 ← N4 VULNERABLE
                (CVE-2021-29425)
```

## CVEs Esperados (solo en N4)

| Dependencia | Version | Nivel | CVEs |
|-------------|---------|-------|------|
| `commons-collections` | 3.2.1 | N4 | CVE-2015-6420, CVE-2015-7501 (deserializacion RCE) |
| `commons-io` | 2.6 | N4 | CVE-2021-29425 (path traversal parcial) |

## Por que es importante

Muchas herramientas SCA configuran un limite de profundidad en el analisis de transitivas (tipicamente 2-3 niveles). Este caso de prueba verifica si la herramienta puede alcanzar el 4to nivel, donde en proyectos empresariales reales pueden ocultarse vulnerabilidades criticas.

## Codigo Demo

Cada capa implementa una funcionalidad real que justifica la existencia del modulo:
- **lib-deep**: Filtrado de colecciones y manejo de paths
- **lib-middle**: Procesamiento de datos y filtrado por extension
- **lib-outer**: Servicio de archivos de alto nivel
- **app**: Aplicacion que normaliza y busca archivos
