# CVE Analysis -- Benchmark Projects Summary

**Scan Date:** 2026-04-03
**Tool:** Claude Opus 4
**Analyst:** Claude Opus 4 via Claude Code
**Method:** LLM-based CVE analysis using Claude Opus 4 knowledge base (NVD, GitHub Advisory, MITRE up to May 2025).
**Scope:** 7 benchmark projects under `benchmark-projects/`

---

## Results Overview

| Project | Description | CVEs Total | CRITICAL | HIGH | MEDIUM | LOW |
|---|---|:---:|:---:|:---:|:---:|:---:|
| [01_direct_vuln_n1](./01_direct_vuln_n1/README.md) | Vulnerabilidades directas (N1) | **5** | 3 | 1 | 1 | 0 |
| [02_vuln_n1_and_n2](./02_vuln_n1_and_n2/README.md) | Vulnerabilidades N1 + N2 transitivas | **28** | 4 | 20 | 4 | 0 |
| [03_transitive_only_n2](./03_transitive_only_n2/README.md) | Solo transitivas de 1er nivel (N2) | **30** | 5 | 16 | 9 | 0 |
| [04_transitive_only_n3](./04_transitive_only_n3/README.md) | Solo transitivas de 2do nivel (N3) | **4** | 1 | 3 | 0 | 0 |
| [05_combined_n2_and_n3](./05_combined_n2_and_n3/README.md) | Combinado N2 + N3 (Gradle) | **57** | 13 | 38 | 6 | 0 |
| [06_deep_transitive_n4](./06_deep_transitive_n4/README.md) | Transitivas profundas (N4) | **4** | 1 | 2 | 1 | 0 |
| **TOTAL** | | **128** | **27** | **80** | **21** | **0** |

---

## Vulnerable Dependencies per Project

### 01_direct_vuln_n1
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `log4j-core` | 2.14.1 | N1 | 4 |
| `commons-text` | 1.9 | N1 | 1 |

### 02_vuln_n1_and_n2
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `xstream` | 1.4.17 | N1 | 17 |
| `struts2-core` | 2.5.25 | N1 | 8 |
| `commons-io` | 2.6 | N2 | 2 |
| `commons-fileupload` | 1.4 | N2 | 1 |

### 03_transitive_only_n2
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `tomcat-embed-core` | 9.0.60 | N2 | 16 |
| `snakeyaml` | 1.29 | N2 | 7 |
| `spring-web` | 5.3.18 | N2 | 2 |
| `jackson-databind` | 2.13.2.2 | N2 | 2 |
| `spring-webmvc` | 5.3.18 | N2 | 1 |
| `logback-classic` | 1.2.11 | N2 | 1 |
| `logback-core` | 1.2.11 | N2 | 1 |

### 04_transitive_only_n3
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `commons-collections` | 3.2.1 | N3 | 2 |
| `commons-beanutils` | 1.9.3 | N3 | 2 |

### 05_combined_n2_and_n3
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `jackson-databind` | 2.9.8 | N3 | 48 |
| `snakeyaml` | 1.30 | N2 | 7 |
| `gson` | 2.8.6 | N2 | 1 |
| `hibernate-validator` | 6.0.18.Final | N3 | 1 |

### 06_deep_transitive_n4
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `commons-collections` | 3.2.1 | N4 | 2 |
| `commons-io` | 2.6 | N4 | 2 |

---

## Comparison

| Proyecto | Supply Chain Agentic | GitHub Copilot | Claude |
|:---|:---:|:---:|:---:|
| 01_direct_vuln_n1 | **38** | 6 | 5 |
| 02_vuln_n1_and_n2 | **61** | 32 | 28 |
| 03_transitive_only_n2 | **100** | 42 | 30 |
| 04_transitive_only_n3 | **11** | 5 | 4 |
| 05_combined_n2_and_n3 | **99** | 61 | 57 |
| 06_deep_transitive_n4 | **5** | 4 | 4 |
| | | | |
| **TOTAL** | **315** | **151** | **128** |

---

## Output Files

Cada carpeta de proyecto contiene:
- `2026-04-03.csv` -- listado estructurado de CVEs
- `README.md` -- descripcion detallada

| Proyecto | CSV | README |
|---|---|---|
| 01_direct_vuln_n1 | [2026-04-03.csv](./01_direct_vuln_n1/2026-04-03.csv) | [README.md](./01_direct_vuln_n1/README.md) |
| 02_vuln_n1_and_n2 | [2026-04-03.csv](./02_vuln_n1_and_n2/2026-04-03.csv) | [README.md](./02_vuln_n1_and_n2/README.md) |
| 03_transitive_only_n2 | [2026-04-03.csv](./03_transitive_only_n2/2026-04-03.csv) | [README.md](./03_transitive_only_n2/README.md) |
| 04_transitive_only_n3 | [2026-04-03.csv](./04_transitive_only_n3/2026-04-03.csv) | [README.md](./04_transitive_only_n3/README.md) |
| 05_combined_n2_and_n3 | [2026-04-03.csv](./05_combined_n2_and_n3/2026-04-03.csv) | [README.md](./05_combined_n2_and_n3/README.md) |
| 06_deep_transitive_n4 | [2026-04-03.csv](./06_deep_transitive_n4/2026-04-03.csv) | [README.md](./06_deep_transitive_n4/README.md) |
