# Caso 4: Vulnerabilidades Solo en el Tercer Nivel (N3)

## Escenario

Proyecto multi-modulo Maven donde las vulnerabilidades se encuentran **exclusivamente en el tercer nivel (N3)** del arbol de dependencias. Los niveles N1 y N2 son modulos internos limpios (sin CVEs). La libreria vulnerable (`commons-collections:3.2.1`) esta oculta a 3 niveles de profundidad.

## Objetivo del Benchmark

Validar que la herramienta SCA:
1. Resuelve el arbol de dependencias completo de proyectos multi-modulo
2. Detecta vulnerabilidades en niveles profundos (N3+) del arbol
3. No se detiene en el primer o segundo nivel de analisis

## Estructura del Proyecto

```
04_vuln_solo_n3/
├── pom.xml                 (parent POM)
├── lib-core/               (modulo con deps vulnerables)
│   ├── pom.xml             (declara commons-collections:3.2.1)
│   └── src/.../DataTransformer.java
├── lib-wrapper/            (facade sobre lib-core)
│   ├── pom.xml             (solo depende de lib-core)
│   └── src/.../DataService.java
└── app/                    (aplicacion principal)
    ├── pom.xml             (solo depende de lib-wrapper)
    └── src/.../App.java
```

## Arbol de Dependencias (desde perspectiva de app/)

```
app (pom.xml)
└── lib-wrapper:1.0.0                       ← N1 LIMPIO (modulo interno)
    └── lib-core:1.0.0                      ← N2 LIMPIO (modulo interno)
        ├── commons-collections:3.2.1       ← N3 VULNERABLE
        │   (CVE-2015-6420, CVE-2015-7501: deserializacion RCE)
        └── commons-beanutils:1.9.3         ← N3 VULNERABLE
            (CVE-2014-0114, CVE-2019-10086: inyeccion de propiedades)
```

## CVEs Esperados (solo en N3)

| Dependencia | Version | Nivel | CVEs |
|-------------|---------|-------|------|
| `commons-collections` | 3.2.1 | N3 | CVE-2015-6420, CVE-2015-7501 |
| `commons-beanutils` | 1.9.3 | N3 | CVE-2014-0114, CVE-2019-10086 |

## Codigo Demo

- **lib-core/DataTransformer.java**: Usa `CollectionUtils.collect()` y `BeanUtils.describe()` — APIs legitimas
- **lib-wrapper/DataService.java**: Facade que delega a DataTransformer
- **app/App.java**: Consume DataService sin conocer las dependencias subyacentes

Todo el codigo pasa SAST: no hay patrones de deserializacion insegura ni inyeccion directa.
