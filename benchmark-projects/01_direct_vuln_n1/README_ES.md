# Caso 1: Vulnerabilidades Directas en Nivel N1

## Escenario

Este proyecto contiene **exclusivamente vulnerabilidades en dependencias directas** (primer nivel del arbol de dependencias). Las librerias declaradas en el `pom.xml` tienen CVEs conocidos, sin necesidad de analizar dependencias transitivas.

## Objetivo del Benchmark

Validar que la herramienta SCA es capaz de detectar vulnerabilidades en las dependencias declaradas directamente en el archivo de build. Este es el escenario mas basico y toda herramienta SCA deberia detectarlo.

## Dependencias y CVEs Esperados

| Dependencia | Version | Nivel | CVEs Principales |
|-------------|---------|-------|-----------------|
| `log4j-core` | 2.14.1 | N1 (directa) | CVE-2021-44228 (CVSS 10.0), CVE-2021-45046, CVE-2021-45105 |
| `commons-text` | 1.9 | N1 (directa) | CVE-2022-42889 (CVSS 9.8) |

## Arbol de Dependencias

```
app (pom.xml)
├── log4j-core:2.14.1          ← N1 VULNERABLE (Log4Shell)
│   └── log4j-api:2.14.1       ← N2 (sin CVEs criticos propios)
└── commons-text:1.9            ← N1 VULNERABLE (Text4Shell)
    └── commons-lang3:3.12.0    ← N2 (sin CVEs conocidos)
```

## Codigo Demo

`App.java` usa ambas librerias de forma convencional:
- **Log4j**: logging estructurado con parametros
- **Commons Text**: interpolacion de plantillas con `StringSubstitutor`

El codigo esta disenado para pasar analisis SAST: no hay inyeccion directa de entrada de usuario en patrones peligrosos. La superficie de ataque esta en las **versiones vulnerables** de las librerias.
