# Caso 5: Vulnerabilidades Combinadas en N2 y N3 (Solo Transitivas)

## Escenario

Proyecto **Gradle** multi-modulo donde las vulnerabilidades se encuentran exclusivamente en niveles **N2 y N3**, sin ninguna vulnerabilidad en las dependencias directas (N1). Este caso valida la capacidad de detectar CVEs distribuidos en multiples niveles transitivos y tambien el soporte para Gradle como build system.

## Objetivo del Benchmark

Validar que la herramienta SCA:
1. Soporta proyectos Gradle (no solo Maven)
2. Detecta vulnerabilidades en multiples niveles transitivos simultaneamente
3. Puede diferenciar entre N2 y N3 en un mismo arbol de dependencias
4. No genera falsos positivos para los modulos internos (N1)

## Estructura del Proyecto

```
05_vuln_n2_y_n3/
├── build.gradle            (root build, config comun)
├── settings.gradle         (declara modulos)
├── lib-data/               (modulo con deps vulnerables — N3 desde app)
│   ├── build.gradle        (jackson-databind:2.9.8, hibernate-validator:6.0.18)
│   └── src/.../JsonMapper.java
├── lib-service/            (modulo con deps vulnerables propias + lib-data)
│   ├── build.gradle        (snakeyaml:1.30, gson:2.8.6, + lib-data)
│   └── src/.../ConfigLoader.java
└── app/                    (aplicacion principal)
    ├── build.gradle        (solo depende de lib-service)
    └── src/.../App.java
```

## Arbol de Dependencias (desde perspectiva de app/)

```
app (build.gradle)
└── lib-service:1.0.0                          ← N1 LIMPIO (modulo interno)
    ├── snakeyaml:1.30                         ← N2 VULNERABLE
    │   (CVE-2022-1471, CVE-2022-25857, CVE-2022-38749..52)
    ├── gson:2.8.6                             ← N2 VULNERABLE
    │   (CVE-2022-25647)
    └── lib-data:1.0.0                         ← N2 LIMPIO (modulo interno)
        ├── jackson-databind:2.9.8             ← N3 VULNERABLE
        │   (CVE-2019-12086, CVE-2020-36518, CVE-2022-42003, +50 CVEs)
        └── hibernate-validator:6.0.18.Final   ← N3 VULNERABLE
            (CVE-2020-10693)
```

## CVEs Esperados por Nivel

### Nivel N2 (transitivas de lib-service)

| Dependencia | Version | CVEs Principales |
|-------------|---------|-----------------|
| `snakeyaml` | 1.30 | CVE-2022-1471 (RCE), CVE-2022-25857, CVE-2022-38749..52 |
| `gson` | 2.8.6 | CVE-2022-25647 (DoS) |

### Nivel N3 (transitivas de lib-data, via lib-service)

| Dependencia | Version | CVEs Principales |
|-------------|---------|-----------------|
| `jackson-databind` | 2.9.8 | 50+ CVEs de deserializacion |
| `hibernate-validator` | 6.0.18.Final | CVE-2020-10693 |

## Codigo Demo

- **lib-data/JsonMapper.java**: ObjectMapper seguro (sin enableDefaultTyping)
- **lib-service/ConfigLoader.java**: Parseo YAML + conversion JSON
- **app/App.java**: Carga configuracion YAML y convierte a JSON
