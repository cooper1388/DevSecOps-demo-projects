# Proyectos Benchmark DevSecOps

Conjunto de proyectos sintéticos Java/Kotlin con vulnerabilidades intencionales en dependencias, diseñados para evaluar herramientas de **Analisis de Composicion de Software (SCA)** en escenarios diferenciados de riesgo en la cadena de suministro.

Cada proyecto en `benchmark-projects/` aisla un nivel específico de profundidad de vulnerabilidad en el árbol de dependencias, permitiendo evaluar con precisión que tan profundo y con que exactitud una herramienta SCA puede detectar CVEs conocidos y riesgos de supply chain.

> **Importante:** Las bases de datos de CVEs evolucionan con el tiempo. Nuevas vulnerabilidades pueden ser publicadas para librerias que se consideraban limpias al momento de la creacion del proyecto. Siempre cruzar los resultados con la fecha de generacion indicada abajo.

## Escenarios del Benchmark

Los proyectos cubren **7 casos de prueba diferenciados**, cada uno dirigido a un nivel de profundidad o tipo de riesgo específico:

| # | Proyecto | Build | Escenario | Fecha de Generacion |
|---|----------|-------|-----------|---------------------|
| 01 | [`01_direct_vuln_n1`](benchmark-projects/01_direct_vuln_n1/) | Maven | Solo vulnerabilidades directas (N1) | 2026-04-03 |
| 02 | [`02_vuln_n1_and_n2`](benchmark-projects/02_vuln_n1_and_n2/) | Maven | Vulnerabilidades en N1 (directa) y N2 (transitiva) | 2026-04-03 |
| 03 | [`03_transitive_only_n2`](benchmark-projects/03_transitive_only_n2/) | Maven | Vulnerabilidades solo en N2 (deps directas limpias) | 2026-04-03 |
| 04 | [`04_transitive_only_n3`](benchmark-projects/04_transitive_only_n3/) | Maven (multi-modulo) | Vulnerabilidades solo en N3 (2 capas limpias arriba) | 2026-04-03 |
| 05 | [`05_combined_n2_and_n3`](benchmark-projects/05_combined_n2_and_n3/) | Gradle (multi-modulo) | Vulnerabilidades combinadas en N2 y N3 (sin N1) | 2026-04-03 |
| 06 | [`06_deep_transitive_n4`](benchmark-projects/06_deep_transitive_n4/) | Maven (multi-modulo) | Vulnerabilidades solo en N4 (3 capas limpias arriba) | 2026-04-03 |
| 07 | [`07_unmaintained_repos`](benchmark-projects/07_unmaintained_repos/) | Maven | Librerias abandonadas/poco mantenidas con 0 CVEs | 2026-04-03 |

### Niveles de Profundidad de Dependencias

```
app (pom.xml / build.gradle)
├── libreria-a              ← N1 (dependencia directa)
│   ├── libreria-b          ← N2 (transitiva de primer nivel)
│   │   ├── libreria-c      ← N3 (transitiva de segundo nivel)
│   │   │   └── libreria-d  ← N4 (transitiva profunda)
```

- **N1**: Declarada directamente en el archivo de build
- **N2**: Dependencia transitiva inmediata (dependencia de una dependencia directa)
- **N3**: Dos niveles de profundidad en el arbol transitivo
- **N4**: Tres niveles de profundidad -- frecuentemente mas alla del alcance por defecto del analisis SCA
- **N5**: Cuatro niveles de profundidad -- solo Supply Chain Agentic alcanza este nivel

## Resultados Mas Recientes (2026-04-03)

| Proyecto | Supply Chain Agentic | GitHub Copilot | Claude Opus 4 |
|---|:---:|:---:|:---:|
| 01_direct_vuln_n1 | **38** | 6 | 5 |
| 02_vuln_n1_and_n2 | **61** | 32 | 28 |
| 03_transitive_only_n2 | **100** | 42 | 30 |
| 04_transitive_only_n3 | **11** | 5 | 4 |
| 05_combined_n2_and_n3 | **99** | 61 | 57 |
| 06_deep_transitive_n4 | **5** | 4 | 4 |
| 07_unmaintained_repos | **1** | 0 | 0 |
| **TOTAL** | **315** | **150** | **128** |

Ground truth recall: **100%** en los 7 proyectos para Supply Chain Agentic.

## Ejecutar el Benchmark

```bash
# Benchmark completo (7 proyectos)
python benchmark/run_benchmark.py

# Un solo proyecto
python benchmark/run_benchmark.py --project 04_transitive_only_n3
```

Genera CSV + README por proyecto en `benchmark-results/ai-analysis/supply_chain_agentic/`.

## Resultados del Benchmark

La carpeta `benchmark-results/` contiene resultados de 3 analisis basados en IA:

- [`supply_chain_agentic/`](benchmark-results/ai-analysis/supply_chain_agentic/) -- Pipeline automatizado (315 CVEs, profundidad N0-N5)
- [`copilot/`](benchmark-results/ai-analysis/copilot/) -- GitHub Copilot + appmod-validate-cves-for-java (150 CVEs)
- [`claude/`](benchmark-results/ai-analysis/claude/) -- Claude Opus 4 analisis LLM (128 CVEs)

Cada conjunto incluye archivos CSV y README por proyecto con detalle de deteccion.

> Los resultados deben interpretarse considerando la fecha de analisis, ya que las bases de datos de CVEs se actualizan continuamente.

## Estructura de los Proyectos

Cada proyecto sigue una estructura consistente:

```
benchmark-projects/
├── 0X_nombre_proyecto/
│   ├── pom.xml / build.gradle     Manifiesto con dependencias vulnerables
│   ├── expected.json              Ground truth: CVEs esperados y niveles
│   ├── README.md                  Documentacion en ingles (escenario, arbol, CVEs)
│   ├── README_ES.md               Documentacion en espanol
│   └── src/main/java/...          Codigo Java demo que usa las librerias declaradas
```

### Proyectos multi-modulo (04, 05, 06)

Los proyectos 04, 05 y 06 usan builds multi-modulo para controlar con precision la profundidad de las dependencias. Cada modulo interno representa una capa limpia en la cadena de dependencias, con librerias vulnerables de terceros solo en el nivel objetivo.

```
0X_proyecto/
├── pom.xml (padre)
├── lib-core/       (modulo interno — sin CVEs)
├── lib-wrapper/    (modulo interno — sin CVEs)
└── app/            (objetivo de analisis — solo ve transitivas)
```

## Decisiones de Diseno Clave

- **Código limpio para SAST**: Todo el código Java esta disenado para pasar análisis SAST convencionales. Las vulnerabilidades estan en las versiones de las librerias, no en patrones de código.
- **Escenarios aislados**: Cada proyecto apunta exactamente a un nivel de profundidad, evitando solapamientos que confundirian las mediciones.
- **Diversidad de build systems**: 5 proyectos Maven, 1 proyecto Gradle, y variantes multi-modulo para probar compatibilidad.
- **Sin necesidad de compilacion**: Los proyectos son manifiestos de build con codigo demo — no estan disenados para compilar ni ejecutar.
- **Ground truth independiente**: Los archivos `expected.json` se generan desde consultas directas a bases de datos de CVEs (NVD, OSV), no desde la salida de ninguna herramienta SCA.

## Aviso Temporal sobre CVEs

Todos los proyectos fueron generados el **2026-04-03**. El panorama de vulnerabilidades cambia continuamente:

- Nuevos CVEs pueden ser publicados para librerias que estaban limpias al momento de la generación
- CVEs existentes pueden ser disputados, rechazados o reclasificados
- Los scores CVSS pueden ser actualizados
- Las librerias pueden publicar parches que cambien la "última version segura"

Al ejecutar benchmarks, siempre registrar la fecha de analisis y comparar contra el ground truth de `expected.json`, anotando discrepancias que puedan deberse a diferencias temporales.

## Uso Previsto

Estos proyectos estan diseñados para evaluar:

- **SCA (Software Composition Analysis)**: Snyk, OWASP Dependency-Check, Trivy, Grype, etc.
- **Seguridad de Cadena de Suministro**: Pipelines agenticos, analisis de confianza, scoring de mantenimiento
- **Generación de SBOM**: Completitud de CycloneDX y SPDX en diferentes niveles de profundidad
- **Gestión de Vulnerabilidades**: Priorizacion por severidad, analisis de alcanzabilidad, evaluación de riesgo transitivo
