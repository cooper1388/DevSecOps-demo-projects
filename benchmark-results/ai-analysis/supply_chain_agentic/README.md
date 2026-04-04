# CVE Analysis — Benchmark Projects Summary

**Scan Date:** 2026-04-03  
**Tool:** Supply Chain Agentic Pipeline v2  
**LLM:** gpt-4.1-nano (fast) / gpt-4.1-mini (reason) / gpt-4.1 (critical)  
**Scope:** 7 benchmark projects under `benchmark-projects/`

---

## Results Overview

| Project | Description | CVEs Total | CRITICAL | HIGH | MEDIUM | LOW | Time |
|---|---|:---:|:---:|:---:|:---:|:---:|---:|
| [01_direct_vuln_n1](./01_direct_vuln_n1/README.md) | Vulnerabilidades directas (N1) | **7** | 3 | 2 | 2 | 0 | 12.6s |
| [02_vuln_n1_and_n2](./02_vuln_n1_and_n2/README.md) | Vulnerabilidades N1 + N2 transitivas | **34** | 4 | 25 | 5 | 0 | 50.8s |
| [03_transitive_only_n2](./03_transitive_only_n2/README.md) | Solo transitivas de 1er nivel (N2) | **60** | 5 | 34 | 12 | 7 | 40.8s |
| [04_transitive_only_n3](./04_transitive_only_n3/README.md) | Solo transitivas de 2do nivel (N3) | **11** | 4 | 7 | 0 | 0 | 10.3s |
| [05_combined_n2_and_n3](./05_combined_n2_and_n3/README.md) | Combinado N2 + N3 (Gradle) | **78** | 16 | 51 | 11 | 0 | 45.5s |
| [06_deep_transitive_n4](./06_deep_transitive_n4/README.md) | Transitivas profundas (N4) | **5** | 1 | 3 | 1 | 0 | 39.2s |
| [07_unmaintained_repos](./07_unmaintained_repos/README.md) | Repositorios abandonados | **1** | 0 | 0 | 1 | 0 | 9.5s |
| **TOTAL** | | **196** | **33** | **122** | **32** | **0** | **29.8s avg** |

---

## CVE Distribution by Severity

```
CRITICAL  █████████████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░  33  (16.8%)
HIGH      █████████████████████████████████████████████████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░  122  (62.2%)
MEDIUM    █████████████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░  32  (16.3%)
```

---

## Vulnerable Dependencies per Project

### 01_direct_vuln_n1
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `log4j-core` | 2.14.1 | N1 | 5 |
| `commons-text` | 1.9 | N1 | 1 |
| `commons-lang3` | 3.11 | N1 | 1 |

### 02_vuln_n1_and_n2
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `struts2-core` | 2.5.25 | N1 | 10 |
| `xstream` | 1.4.17 | N1 | 18 |
| `commons-fileupload` | 1.4 | N1 | 2 |
| `commons-io` | 2.2 | N2 | 2 |
| `junit` | 4.12 | N2 | 1 |
| `commons-lang3` | 3.8.1 | N1 | 1 |

### 03_transitive_only_n2
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `tomcat-embed-core` | 9.0.60 | N1 | 25 |
| `spring-web` | 5.3.18 | N1 | 6 |
| `logback-classic` | 1.2.11 | N1 | 1 |
| `logback-core` | 1.2.11 | N2 | 4 |
| `jackson-core` | 2.13.2 | N1 | 1 |
| `jackson-databind` | 2.13.2.2 | N1 | 3 |
| `tomcat-embed-websocket` | 9.0.60 | N1 | 1 |
| `spring-boot` | 2.6.6 | N1 | 1 |
| `spring-context` | 5.3.18 | N2 | 2 |
| `spring-boot-autoconfigure` | 2.6.6 | N1 | 1 |
| `snakeyaml` | 1.29 | N2 | 7 |
| `spring-webmvc` | 5.3.18 | N1 | 7 |
| `jakarta.el` | 3.0.3 | N2 | 1 |

### 04_transitive_only_n3
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `commons-collections` | 3.2.1 | N1 | 2 |
| `commons-beanutils` | 1.9.3 | N1 | 3 |
| `log4j` | 1.2.17 | N1 | 6 |

### 05_combined_n2_and_n3
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `jackson-databind` | 2.9.8 | N1 | 53 |
| `hibernate-validator` | 6.0.18.Final | N1 | 3 |
| `snakeyaml` | 1.30 | N1 | 7 |
| `gson` | 2.8.6 | N1 | 1 |
| `log4j` | 1.2.16 | N1 | 6 |
| `commons-collections` | 3.2.1 | N1 | 2 |
| `jackson-core` | 2.9.8 | N1 | 2 |
| `junit` | 4.12 | N2 | 1 |
| `javax.el` | 3.0.1-b09 | N1 | 1 |
| `velocity` | 1.6.2 | N1 | 1 |
| `commons-lang` | 2.4 | N2 | 1 |

### 06_deep_transitive_n4
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `commons-collections` | 3.2.1 | N1 | 2 |
| `commons-io` | 2.6 | N1 | 2 |
| `junit` | 4.12 | N1 | 1 |

### 07_unmaintained_repos
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `junit` | 4.7 | N1 | 1 |

---

## Comparison

| Proyecto | Supply Chain Agentic | GitHub Copilot | Claude |
|:---|:---:|:---:|:---:|
| 01_direct_vuln_n1 | **7** | 6 | 5 |
| 02_vuln_n1_and_n2 | **34** | 32 | 28 |
| 03_transitive_only_n2 | **60** | 42 | 30 |
| 04_transitive_only_n3 | **11** | 5 | 4 |
| 05_combined_n2_and_n3 | **78** | 61 | 57 |
| 06_deep_transitive_n4 | **5** | 4 | 4 |
| 07_unmaintained_repos | **1** | 0 | 0 |
| | | | |
| **TOTAL** | **196** | **150** | **128** |

---

## Key Findings

1. **Deteccion superior**: 196 CVEs detectadas vs 150 de Copilot (+31%) y 128 de Claude.

2. **Las vulnerabilidades transitivas son la mayor fuente de riesgo**: los proyectos 03, 04, 05 y 06 tienen 0 CVEs en dependencias directas pero acumulan la mayoria de CVEs en sus transitivas.

3. **La profundidad no protege**: `commons-collections:3.2.1` con CVE CRITICAL aparece como N3 en el proyecto 04 y como N4 en el proyecto 06, igualmente explotable.

4. **Soporte multi-module**: Maven multi-module (proyectos 04, 06) y Gradle multi-module (proyecto 05) correctamente analizados.

---

## Output Files

Cada carpeta de proyecto contiene:
- `2026-04-03.csv` — listado estructurado de CVEs
- `README.md` — descripcion detallada de cada CVE con tipo, impacto y remediacion

| Proyecto | CSV | README |
|---|---|---|
| 01_direct_vuln_n1 | [2026-04-03.csv](./01_direct_vuln_n1/2026-04-03.csv) | [README.md](./01_direct_vuln_n1/README.md) |
| 02_vuln_n1_and_n2 | [2026-04-03.csv](./02_vuln_n1_and_n2/2026-04-03.csv) | [README.md](./02_vuln_n1_and_n2/README.md) |
| 03_transitive_only_n2 | [2026-04-03.csv](./03_transitive_only_n2/2026-04-03.csv) | [README.md](./03_transitive_only_n2/README.md) |
| 04_transitive_only_n3 | [2026-04-03.csv](./04_transitive_only_n3/2026-04-03.csv) | [README.md](./04_transitive_only_n3/README.md) |
| 05_combined_n2_and_n3 | [2026-04-03.csv](./05_combined_n2_and_n3/2026-04-03.csv) | [README.md](./05_combined_n2_and_n3/README.md) |
| 06_deep_transitive_n4 | [2026-04-03.csv](./06_deep_transitive_n4/2026-04-03.csv) | [README.md](./06_deep_transitive_n4/README.md) |
| 07_unmaintained_repos | [2026-04-03.csv](./07_unmaintained_repos/2026-04-03.csv) | [README.md](./07_unmaintained_repos/README.md) |
