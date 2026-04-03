# Caso 2: Vulnerabilidades en Nivel N1 (Directo) y N2 (Transitivo)

## Escenario

Este proyecto contiene vulnerabilidades **tanto en las dependencias directas (N1) como en sus dependencias transitivas inmediatas (N2)**. Las herramientas SCA deben detectar CVEs en ambos niveles del arbol de dependencias.

## Objetivo del Benchmark

Validar que la herramienta SCA:
1. Detecta CVEs en dependencias declaradas directamente en el pom.xml (N1)
2. Tambien detecta CVEs en las dependencias que esas librerias traen consigo (N2)
3. Puede diferenciar entre vulnerabilidades directas y transitivas

## Dependencias y CVEs Esperados

### Nivel N1 (Directas)

| Dependencia | Version | CVEs Principales |
|-------------|---------|-----------------|
| `struts2-core` | 2.5.25 | CVE-2020-17530, CVE-2021-31805, CVE-2023-50164 (OGNL injection) |
| `xstream` | 1.4.17 | CVE-2021-39139 a CVE-2021-39154, CVE-2021-43859, CVE-2022-41966 |

### Nivel N2 (Transitivas de struts2-core y xstream)

| Dependencia | Padre | Version | CVEs |
|-------------|-------|---------|------|
| `commons-fileupload` | struts2-core | 1.4 | CVE-2023-24998 (DoS via limite de partes) |
| `xpp3_min` | xstream | 1.1.4c | Vulnerabilidades de la familia XML Pull Parser |

## Arbol de Dependencias

```
app (pom.xml)
├── struts2-core:2.5.25              ← N1 VULNERABLE
│   ├── commons-fileupload:1.4       ← N2 VULNERABLE (CVE-2023-24998)
│   ├── ognl:3.1.29                  ← N2 (posibles CVEs)
│   ├── freemarker:2.3.31            ← N2
│   └── commons-lang3:3.12.0         ← N2
└── xstream:1.4.17                   ← N1 VULNERABLE
    ├── xpp3_min:1.1.4c              ← N2 VULNERABLE
    └── xmlpull:1.1.3.1              ← N2
```

## Codigo Demo

`App.java` usa XStream para serializar/deserializar eventos en XML. El codigo:
- Configura `allowTypes` para clases especificas (buena practica SAST)
- No deserializa input externo directo
- Las vulnerabilidades estan en las versiones de las librerias, no en el patron de uso
