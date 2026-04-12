# Proyectos Benchmark DevSecOps

Conjunto de proyectos sintéticos Java/Kotlin con vulnerabilidades intencionales
en dependencias, diseñados para evaluar herramientas de **Análisis de Composición
de Software (SCA)**, **LLM-as-scanner**, **Agentic IDE assistants** y pipelines
agénticos en escenarios diferenciados de riesgo en la cadena de suministro.

Cada proyecto en `benchmark-projects/` aísla un nivel específico de profundidad
de vulnerabilidad en el árbol de dependencias, permitiendo evaluar con precisión
qué tan profundo y con qué exactitud una herramienta puede detectar CVEs
conocidos y riesgos de supply chain.

Este benchmark es la base experimental del paper **"Agentic AI for Software
Supply Chain Vulnerability Analysis: A Multi-Agent DevSecOps Approach"**
(IEEE LA-CCI 2026, submitted).

> **Importante:** Las bases de datos de CVEs evolucionan con el tiempo. Nuevas
> vulnerabilidades pueden ser publicadas para librerías que se consideraban
> limpias al momento de la creación del proyecto. Siempre cruzar los resultados
> con la fecha de medición indicada abajo.

---

## Escenarios del Benchmark

Los proyectos cubren **7 casos de prueba diferenciados**, cada uno dirigido a
un nivel de profundidad o tipo de riesgo específico:

| # | Proyecto | Build | Escenario | Ground Truth |
|---|----------|-------|-----------|--------------|
| 01 | [`01_direct_vuln_n1`](benchmark-projects/01_direct_vuln_n1/) | Maven | Solo vulnerabilidades directas (N1) | 2026-04-03 |
| 02 | [`02_vuln_n1_and_n2`](benchmark-projects/02_vuln_n1_and_n2/) | Maven | Vulnerabilidades en N1 (directa) y N2 (transitiva) | 2026-04-03 |
| 03 | [`03_transitive_only_n2`](benchmark-projects/03_transitive_only_n2/) | Maven | Vulnerabilidades solo en N2 (deps directas limpias) | 2026-04-03 |
| 04 | [`04_transitive_only_n3`](benchmark-projects/04_transitive_only_n3/) | Maven multi-módulo | Vulnerabilidades solo en N3 (2 capas limpias arriba) | 2026-04-03 |
| 05 | [`05_combined_n2_and_n3`](benchmark-projects/05_combined_n2_and_n3/) | Gradle multi-módulo | Vulnerabilidades combinadas en N2 y N3 (sin N1) | 2026-04-03 |
| 06 | [`06_deep_transitive_n4`](benchmark-projects/06_deep_transitive_n4/) | Maven multi-módulo | Vulnerabilidades solo en N4 (3 capas limpias arriba) | 2026-04-03 |
| 07 | [`07_unmaintained_repos`](benchmark-projects/07_unmaintained_repos/) | Maven | Librerías abandonadas/poco mantenidas con 0 CVEs conocidos | 2026-04-03 |

### Niveles de Profundidad de Dependencias

```
app (pom.xml / build.gradle)
└── libreria-a              ← N1 (dependencia directa)
    └── libreria-b          ← N2 (transitiva de primer nivel)
        └── libreria-c      ← N3 (transitiva de segundo nivel)
            └── libreria-d  ← N4 (transitiva profunda)
                └── libreria-e  ← N5 (cuarta capa transitiva)
```

- **N1**: Declarada directamente en el archivo de build
- **N2**: Dependencia transitiva inmediata
- **N3**: Dos niveles de profundidad en el árbol transitivo
- **N4**: Tres niveles de profundidad — frecuentemente más allá del alcance
  por defecto del análisis SCA convencional
- **N5**: Cuatro niveles de profundidad — alcanzado únicamente por el pipeline
  agéntico Supply Chain Agentic

---

## Resultados del Benchmark (10 herramientas evaluadas)

Comparación completa contra **10 baselines** agrupadas en 4 categorías
(mediciones realizadas entre 2026-04-09 y 2026-04-11):

### Ranking global por CVEs detectados

| # | Tool | Categoría | CVEs | CV (%) | n runs |
|---|------|-----------|-----:|-------:|-------:|
| 1 | **Supply Chain Agentic (ours)** | Agentic pipeline | **315** | **0.71** | n=15 |
| 2 | M365 Copilot GPT-5 Think Deeper | LLM-as-scanner | 194 | — | n=1 |
| 3 | Google Antigravity (Gemini 3.1 Pro) | Agentic IDE | 177 | 3.78 | n=5 |
| 4 | GitHub Copilot (Haiku 4.5) | LLM-as-scanner | 157 | — | n=1 |
| 5 | Claude Opus 4 | LLM-as-scanner | 128 | — | n=1 |
| 6 | Trivy | Dedicated SCA | 124 | 0.00* | n=15 |
| 7 | Snyk | Dedicated SCA | 105 | — | n=1 |
| 8 | OSV-Scanner (Google) | Dedicated SCA | 104 | 0.00* | n=15 |
| 9 | Grype | Dedicated SCA | 43 | 0.00* | n=15 |
| 10 | SonarQube 26.3 | SAST | 0 | 0.00* | n=1 |

\**CV = 0% para herramientas SCA/SAST es artificial, reflejando bases de datos
de vulnerabilidades congeladas, no verdadera reproducibilidad bajo condiciones
de API en vivo.*

### Per-project: Supply Chain Agentic vs top baselines por categoría

| Proyecto | **SCVS** | M365 GPT-5 | Antigravity | Copilot Haiku | Claude Opus 4 | Trivy | Snyk | OSV | Grype | Sonar |
|----------|:--------:|:----------:|:-----------:|:-------------:|:-------------:|:-----:|:----:|:---:|:-----:|:-----:|
| 01 Direct N1       | **38** | 8   | 8   | 6   | 5   | 7   | 7   | 7   | 6   | 0 |
| 02 N1+N2           | **61** | 51  | 28  | 32  | 20  | 33  | 32  | 33  | 28  | 0 |
| 03 Trans N2        | **100**| 63  | 65  | 38  | 35  | 66  | 66  | 64  | 0   | 0 |
| 04 Trans N3        | **11** | 5   | 10  | 6   | 3   | 10  | 0   | 0   | 5   | 0 |
| 05 Gradle N2+N3    | **99** | 63  | 61  | 65  | 64  | 0   | 0   | 0   | 0   | 0 |
| 06 Deep N4         | **5**  | 4   | 4   | 10  | 3   | 8   | 0   | 0   | 4   | 0 |
| 07 Abandoned       | **1**  | 0   | 0   | 0   | 0   | 0   | 0   | 0   | 0   | 0 |
| **TOTAL**          | **315**| 194 | 177 | 157 | 128 | 124 | 105 | 104 | 43  | 0 |

---

## Hallazgos Clave del Benchmark

### Gap de detección de Supply Chain Agentic

- **+62%** vs M365 Copilot GPT-5 (el mejor LLM-as-scanner)
- **+78%** vs Google Antigravity (el mejor Agentic IDE)
- **+154%** vs Trivy (la mejor herramienta SCA dedicada)
- **∞** vs SonarQube (SAST es ciego a riesgos en dependencias)

### Reproducibilidad

- **Supply Chain Agentic**: Mean 316.5 ± 2.23 CVEs sobre n=15 runs, CV 0.71%
- **Google Antigravity**: Mean 176.8 ± 6.69 CVEs sobre n=5 runs, CV 3.78%
- SCVS es **5.3× más estable** que el mejor baseline agéntico
- Las herramientas SCA reportan CV = 0% pero es **artificial** (bases de datos
  congeladas, no robustez real)

### Profundidad y diminishing returns

- **43% de todos los CVEs detectados residen en N3 o más profundo** — nivel
  invisible para herramientas SCA convencionales limitadas a N1-N2
- Solo SCVS continúa detectando CVEs hasta **N5**
- LLM-as-scanner tools y SCA hacen plateau en N2-N3
- N6 agrega solo +8.6% CVEs a cambio de +19% tiempo y +25% costo → **N5 es
  el óptimo** coverage-vs-cost

### Contribución única: Análisis de Trust en P07

- P07 contiene únicamente librerías abandonadas **sin CVEs conocidos**
- Todas las herramientas basadas en CVE detectan 0 vulnerabilidades
- **Supply Chain Agentic es el único tool que identifica 5 dependencias con
  nivel CRITICAL de trust** (packages abandonados desde 2003-2017)
- Demuestra que CVE scanning por sí solo es insuficiente; el análisis de
  maintainer trust es necesario

### Severidad (top 4 tools)

| Tool | Critical | High | Medium | Low |
|------|---------:|-----:|-------:|----:|
| **Supply Chain Agentic** | **40** | 173 | 87 | 11 |
| M365 Copilot GPT-5 | 19 | 114 | 57 | 4 |
| Google Antigravity | 27 | 106 | 35 | 3 |
| Claude Opus 4 | 27 | 80 | 21 | 0 |

SCVS detecta proporcionalmente más vulnerabilidades **CRITICAL** que cualquier
otro baseline, gracias al deep scanning que alcanza librerías con cadenas de
deserialización conocidas (commons-collections, jackson-databind) en niveles N3+.

---

## Performance del Supply Chain Agentic

- **Execution time**: 4:14 minutos promedio (~36 segundos por proyecto)
- **LLM cost**: $0.020 por scan, distribuido en three-tier:
  - `gpt-4.1-nano` ($0.10/1M tokens) — CVE tagging, descripciones rápidas
  - `gpt-4.1-mini` ($0.40/1M tokens) — summaries, trust reasoning
  - `gpt-4.1` ($2.00/1M tokens) — reflection loop crítico (max 3 iteraciones)
- **Tokens**: ~15,000 por run completo
- **Dependency resolution**: hasta 310 transitive dependencies en N5
- **Autonomous decisions**: 7/7 adaptive triage, 4/7 reachability filter,
  3/7 reflection cycles, 2/7 inter-agent requests, 1/7 trust-in-clean

---

## Ejecutar el Benchmark

```bash
# Benchmark completo (7 proyectos)
python benchmark/run_benchmark.py

# Un solo proyecto
python benchmark/run_benchmark.py --project 04_transitive_only_n3

# Con número de runs para análisis de reproducibilidad
python benchmark/run_benchmark.py --runs 15
```

Genera CSV + README por proyecto en `benchmark-results/ai-analysis/supply_chain_agentic/`.

---

## Estructura de Resultados

La carpeta `benchmark-results/` contiene resultados de múltiples herramientas:

### Análisis basados en IA

- [`supply_chain_agentic/`](benchmark-results/ai-analysis/supply_chain_agentic/)
  — Pipeline multi-agente (315 CVEs, profundidad N0-N5, n=15 runs)
- [`copilot/`](benchmark-results/ai-analysis/copilot/) — GitHub Copilot Haiku 4.5
  (157 CVEs, validado con appmod-validate-cves-for-java)
- [`claude/`](benchmark-results/ai-analysis/claude/) — Claude Opus 4 análisis LLM
  (128 CVEs, single run con prompt controlado)
- [`m365_copilot/`](benchmark-results/ai-analysis/m365_copilot/) — Microsoft 365
  Copilot con GPT-5 Think Deeper (194 CVEs)
- [`antigravity/`](benchmark-results/ai-analysis/antigravity/) — Google Antigravity
  con Gemini 3.1 Pro (177 CVEs mean n=5)

### Análisis SCA dedicado

- [`sca-analysis/trivy/`](benchmark-results/sca-analysis/trivy/) — Trivy (124 CVEs)
- [`sca-analysis/snyk/`](benchmark-results/sca-analysis/snyk/) — Snyk (105 CVEs)
- [`sca-analysis/osv-scanner/`](benchmark-results/sca-analysis/osv-scanner/)
  — OSV-Scanner Google (104 CVEs)
- [`sca-analysis/grype/`](benchmark-results/sca-analysis/grype/) — Grype (43 CVEs)
- [`sca-analysis/sonarqube/`](benchmark-results/sca-analysis/sonarqube/)
  — SonarQube 26.3 SAST (0 CVEs en dependencias, 20 code smells)

Cada conjunto incluye archivos CSV y README por proyecto con detalle de detección.

> Los resultados deben interpretarse considerando la fecha de análisis, ya que
> las bases de datos de CVEs se actualizan continuamente.

---

## Estructura de los Proyectos

Cada proyecto sigue una estructura consistente:

```
benchmark-projects/
└── 0X_nombre_proyecto/
    ├── pom.xml / build.gradle    ← Manifiesto con dependencias vulnerables
    ├── expected.json             ← Ground truth: CVEs esperados y niveles
    ├── README.md                 ← Documentación en inglés (escenario, árbol, CVEs)
    ├── README_ES.md              ← Documentación en español
    └── src/main/java/...         ← Código Java demo que usa las librerías declaradas
```

### Proyectos multi-módulo (04, 05, 06)

Los proyectos 04, 05 y 06 usan builds multi-módulo para controlar con precisión
la profundidad de las dependencias. Cada módulo interno representa una capa
limpia en la cadena de dependencias, con librerías vulnerables de terceros
solo en el nivel objetivo.

```
0X_proyecto/
├── pom.xml (padre)
├── lib-core/       (módulo interno — sin CVEs)
├── lib-wrapper/    (módulo interno — sin CVEs)
└── app/            (objetivo de análisis — solo ve transitivas)
```

---

## Decisiones de Diseño Clave

- **Código limpio para SAST**: Todo el código Java está diseñado para pasar
  análisis SAST convencionales. Las vulnerabilidades están en las **versiones
  de las librerías**, no en patrones de código. Esto se confirma con SonarQube
  26.3 detectando 0 vulnerabilidades en dependencias.
- **Escenarios aislados**: Cada proyecto apunta exactamente a un nivel de
  profundidad, evitando solapamientos que confundirían las mediciones.
- **Diversidad de build systems**: 6 proyectos Maven (uno multi-módulo),
  1 proyecto Gradle multi-módulo, para probar compatibilidad.
- **Sin necesidad de compilación**: Los proyectos son manifiestos de build con
  código demo — no están diseñados para compilar ni ejecutar.
- **Ground truth independiente**: Los archivos `expected.json` se generan desde
  consultas directas a bases de datos de CVEs (NVD, OSV), no desde la salida
  de ninguna herramienta SCA.
- **Benchmark reproducible**: Todas las ejecuciones están documentadas con
  fechas de medición, número de runs, y coefficient of variation.

---

## Aviso Temporal sobre CVEs

Los proyectos fueron generados el **2026-04-03**. Las corridas de benchmark
se realizaron entre **2026-04-09 y 2026-04-11**. El panorama de vulnerabilidades
cambia continuamente:

- Nuevos CVEs pueden ser publicados para librerías que estaban limpias al
  momento de la generación
- CVEs existentes pueden ser disputados, rechazados o reclasificados
- Los scores CVSS pueden ser actualizados
- Las librerías pueden publicar parches que cambien la "última versión segura"

Al ejecutar benchmarks, siempre registrar la fecha de análisis y comparar
contra el ground truth de `expected.json`, anotando discrepancias que puedan
deberse a diferencias temporales.

---

## Uso Previsto

Estos proyectos están diseñados para evaluar:

- **SCA (Software Composition Analysis)**: Snyk, OWASP Dependency-Check, Trivy,
  Grype, OSV-Scanner
- **SAST (Static Application Security Testing)**: SonarQube (baseline de
  control — debe detectar 0 en dependencias)
- **LLM-as-scanner**: GitHub Copilot, M365 Copilot, Claude, GPT-4o
- **Agentic IDE assistants**: Google Antigravity, Cursor
- **Agentic pipelines**: Supply Chain Agentic y otros sistemas multi-agente
- **Generación de SBOM**: Completitud de CycloneDX y SPDX en diferentes niveles
  de profundidad
- **Gestión de Vulnerabilidades**: Priorización por severidad, análisis de
  reachability, evaluación de riesgo transitivo
- **Análisis de trust de maintainers**: Detección de librerías abandonadas
  o de baja reputación (escenario P07)

---

## Publicación Académica

Este benchmark es la base experimental del siguiente trabajo:

> **Cooper, J., Maldonado, S.** (2026). "Agentic AI for Software
> Supply Chain Vulnerability Analysis: A Multi-Agent DevSecOps Approach."
> *IEEE Latin American Conference on Computational Intelligence (LA-CCI 2026)*.
> Universidad Tecnológica de Honduras.

**Contribuciones principales**:
1. Arquitectura multi-agente con 5 agentes autónomos y bus bidireccional con
   memoria persistente
2. Análisis transitivo profundo (N0–N5) con soporte multi-módulo
3. Análisis de maintainer trust con fallback de 3 niveles
4. Ciclo de reflexión iterativa basado en tiered LLMs (gpt-4.1 family)
5. **Primer benchmark controlado** que compara conjuntamente agentic pipelines,
   agentic IDE assistants, LLM-as-scanner y dedicated SCA/SAST en una
   evaluación reproducible única

---

## Contacto

- Joseph Cooper — kenny.cooper@uth.hn
- Selvin Maldonado — selvin.maldonado@uth.hn

**Maestria en Ciberseguridad**
Universidad Tecnológica de Honduras
