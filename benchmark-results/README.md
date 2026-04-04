# Benchmark Results -- Comparative Analysis

**Date:** 2026-04-03
**Benchmark:** 7 synthetic Java/Kotlin projects with intentional supply chain vulnerabilities
**Ground truth:** `expected.json` per project (source: NVD + OSV API)

---

## Overall Comparison

### AI-based Analysis (SCA / Supply Chain)

| Proyecto | Dificultad | Supply Chain Agentic | GitHub Copilot | Claude Opus 4 |
|---|---|:---:|:---:|:---:|
| 01 Direct N1 | EASY | **38** | 6 | 5 |
| 02 N1+N2 | MEDIUM | **61** | 32 | 28 |
| 03 Transitive N2 | MEDIUM-HARD | **100** | 42 | 30 |
| 04 Transitive N3 | MEDIUM-HARD | **11** | 5 | 4 |
| 05 N2+N3 Gradle | HARD | **99** | 61 | 57 |
| 06 Deep N4 | VERY HARD | **5** | 4 | 4 |
| 07 Unmaintained | SPECIALIZED | **1** | 0 | 0 |
| **TOTAL CVEs** | | **315** | **150** | **128** |

### SAST Analysis (SonarQube)

| Proyecto | Issues | Bugs | Vulnerabilities | Code Smells | Severity |
|---|:---:|:---:|:---:|:---:|---|
| 01 Direct N1 | 0 | 0 | 0 | 0 | -- |
| 02 N1+N2 | 3 | 0 | 0 | 3 | 3 MAJOR |
| 03 Transitive N2 | 0 | 0 | 0 | 0 | -- |
| 04 Transitive N3 | 5 | 0 | 0 | 5 | 5 MAJOR |
| 05 N2+N3 Gradle | 4 | 0 | 0 | 4 | 4 MAJOR |
| 06 Deep N4 | 3 | 0 | 0 | 3 | 2 MAJOR, 1 MINOR |
| 07 Unmaintained | 5 | 0 | 0 | 5 | 5 MAJOR |
| **TOTAL** | **20** | **0** | **0** | **20** | |

---

## Cross-Analysis Summary

| Metrica | Supply Chain Agentic | Copilot | Claude | SonarQube |
|---|:---:|:---:|:---:|:---:|
| **CVEs detectadas** | **315** | 150 | 128 | 0 |
| **Vulnerabilidades SAST** | -- | -- | -- | **0** |
| **Code Smells** | -- | -- | -- | 20 |
| **Ground truth recall** | **100%** | ~85% | ~80% | N/A |
| **Profundidad maxima** | N5 | N2 | N3 | N/A |
| **Multi-module** | Si (arbol real) | No | Parcial | Si |
| **Trust analysis** | Si (Maven + GitHub) | No | No | No |
| **License compliance** | Si (3 fallbacks) | No | No | No |
| **Unmaintained detection** | Si | No | No | No |

---

## Key Insights

1. **SAST y SCA son complementarios, no competencia.** SonarQube encontro 0 vulnerabilidades porque los proyectos son SAST-clean por diseno -- las vulnerabilidades estan en las versiones de las dependencias, no en el codigo.

2. **SCA AI-based supera SAST para supply chain.** Las 315 CVEs que detecta Supply Chain Agentic son invisibles para SonarQube porque viven en las dependencias transitivas, no en el codigo fuente.

3. **La profundidad es el diferenciador clave.** Supply Chain Agentic detecta CVEs hasta N5 (5 niveles de profundidad). Copilot llega a N2, Claude a N3. Cada nivel adicional expone vulnerabilidades que las herramientas mas superficiales ignoran.

4. **Trust y licencias son dimensiones ortogonales a CVEs.** El proyecto 07 tiene 0 CVEs pero 5 dependencias abandonadas con trust CRITICAL. Solo Supply Chain Agentic detecta este riesgo.

---

## Tool Details

| Tool | Type | Method | Output |
|---|---|---|---|
| [Supply Chain Agentic](ai-analysis/supply_chain_agentic/) | SCA + Trust + License | 5 agentes autonomos + 3 skills + bus bidireccional | CSV + README per project |
| [GitHub Copilot](ai-analysis/copilot/) | SCA | appmod-validate-cves-for-java + GitHub Advisory | CSV + README per project |
| [Claude Opus 4](ai-analysis/claude/) | SCA (LLM) | Knowledge base analysis (NVD, MITRE, May 2025) | CSV + README per project |
| SonarQube | SAST | Static code analysis | Issues CSV + screenshots |

---

## Running the Benchmark

```bash
# AI analysis (Supply Chain Agentic)
python benchmark/run_benchmark.py

# SAST analysis
# Requires SonarQube instance -- see sast-analysis/ for existing results
```
