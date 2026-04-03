# Caso 3: Vulnerabilidades Solo en Transitivas de Primer Nivel (N2)

## Escenario

Las dependencias **directas declaradas en el pom.xml no tienen CVEs propios** — son aggregadores/starters de Spring Boot que no contienen codigo vulnerable. Sin embargo, las **dependencias transitivas inmediatas (N2)** que estos starters traen consigo si contienen vulnerabilidades criticas.

## Objetivo del Benchmark

Validar que la herramienta SCA:
1. No genera falsos positivos para los starters (N1) que son solo POMs aggregadores
2. SI detecta vulnerabilidades en las transitivas inmediatas (N2) que los starters traen
3. Puede resolver el arbol de dependencias de Spring Boot para encontrar las versiones reales

## Dependencias Directas (N1 — LIMPIAS)

| Dependencia | Version | CVEs Directos |
|-------------|---------|---------------|
| `spring-boot-starter-web` | 2.6.6 | 0 (POM aggregador) |
| `spring-boot-starter-validation` | 2.6.6 | 0 (POM aggregador) |

## Dependencias Transitivas Vulnerables (N2)

| Dependencia | Traida por | Version | CVEs |
|-------------|-----------|---------|------|
| `snakeyaml` | starter-web → starter | 1.29 | CVE-2022-1471 (RCE), CVE-2022-25857, CVE-2022-38749..52 |
| `spring-webmvc` | starter-web | 5.3.17 | CVE-2022-22965 (Spring4Shell, CVSS 9.8) |
| `tomcat-embed-core` | starter-web → starter-tomcat | 9.0.60 | Multiples CVEs de seguridad HTTP |
| `jackson-databind` | starter-web → starter-json | 2.13.2 | CVE-2020-36518, CVE-2022-42003 |

## Arbol de Dependencias

```
app (pom.xml)
├── spring-boot-starter-web:2.6.6          ← N1 LIMPIO (solo POM)
│   ├── spring-webmvc:5.3.17               ← N2 VULNERABLE (Spring4Shell)
│   ├── spring-boot-starter-tomcat:2.6.6   ← N2 LIMPIO (solo POM)
│   │   └── tomcat-embed-core:9.0.60       ← N3 VULNERABLE
│   ├── spring-boot-starter-json:2.6.6     ← N2 LIMPIO (solo POM)
│   │   └── jackson-databind:2.13.2        ← N3 VULNERABLE
│   └── spring-boot-starter:2.6.6          ← N2 LIMPIO (solo POM)
│       └── snakeyaml:1.29                 ← N3 VULNERABLE
└── spring-boot-starter-validation:2.6.6   ← N1 LIMPIO (solo POM)
    └── hibernate-validator:6.2.3.Final    ← N2 (posibles CVEs)
```

**Nota:** Dependiendo de como la herramienta SCA cuente los niveles (si los starters intermedios cuentan como nivel o no), algunas vulnerabilidades podrian clasificarse como N2 o N3. El punto clave es que **ninguna dependencia declarada directamente en el pom.xml tiene CVEs**.

## Codigo Demo

`App.java` implementa un REST controller basico con validacion Bean Validation. Codigo completamente limpio para SAST.
