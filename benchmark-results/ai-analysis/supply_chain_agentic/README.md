# CVE Analysis -- Benchmark Projects Summary

**Scan Date:** 2026-04-03
**Tool:** Supply Chain Agentic
**Analyst:** Automated pipeline (5 agents + 3 skills + bus bidireccional)
**Method:** Multi-source API scanning: OSV.dev + Sonatype OSS Index + deps.dev + NVD + GitHub Advisory. Depth N0-N5. Multi-module Maven/Gradle. Reachability filter.
**Scope:** 7 benchmark projects under `benchmark-projects/`

---

## Results Overview

| Project | Description | CVEs Total | CRITICAL | HIGH | MEDIUM | LOW |
|---|---|:---:|:---:|:---:|:---:|:---:|
| [01_direct_vuln_n1](./01_direct_vuln_n1/README.md) | Vulnerabilidades directas (N1) | **38** | 4 | 14 | 19 | 1 |
| [02_vuln_n1_and_n2](./02_vuln_n1_and_n2/README.md) | Vulnerabilidades N1 + N2 transitivas | **61** | 4 | 36 | 20 | 1 |
| [03_transitive_only_n2](./03_transitive_only_n2/README.md) | Solo transitivas de 1er nivel (N2) | **100** | 11 | 53 | 25 | 8 |
| [04_transitive_only_n3](./04_transitive_only_n3/README.md) | Solo transitivas de 2do nivel (N3) | **11** | 3 | 8 | 0 | 0 |
| [05_combined_n2_and_n3](./05_combined_n2_and_n3/README.md) | Combinado N2 + N3 (Gradle) | **99** | 17 | 59 | 21 | 1 |
| [06_deep_transitive_n4](./06_deep_transitive_n4/README.md) | Transitivas profundas (N4) | **5** | 1 | 3 | 1 | 0 |
| [07_unmaintained_repos](./07_unmaintained_repos/README.md) | Repositorios abandonados | **1** | 0 | 0 | 1 | 0 |
| **TOTAL** | | **315** | **40** | **173** | **87** | **11** |

---

## Vulnerable Dependencies per Project

### 01_direct_vuln_n1
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `snakeyaml` | 1.21 | N2+ | 8 |
| `log4j-core` | 2.14.1 | N1 | 5 |
| `junit` | 4.10 | N2+ | 4 |
| `spring-core` | 3.2.17.RELEASE | N2+ | 4 |
| `guava` | 19.0 | N2+ | 3 |
| `commons-io` | 1.4 | N2+ | 3 |
| `ant` | 1.7.0 | N2+ | 3 |
| `spring-beans` | 3.2.17.RELEASE | N1 | 2 |
| `commons-lang3` | 3.4 | N2+ | 2 |
| `commons-text` | 1.9 | N1 | 1 |
| `testng` | 7.1.0 | N2+ | 1 |
| `velocity` | 1.6.2 | N2+ | 1 |
| `commons-lang` | 2.4 | N2+ | 1 |

### 02_vuln_n1_and_n2
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `xstream` | 1.4.17 | N1 | 18 |
| `struts2-core` | 2.5.25 | N1 | 10 |
| `snakeyaml` | 1.17 | N2+ | 8 |
| `ant` | 1.7.0 | N2+ | 7 |
| `commons-io` | 1.4 | N2+ | 5 |
| `junit` | 4.11 | N2+ | 3 |
| `guava` | 19.0 | N2+ | 3 |
| `commons-fileupload` | 1.4 | N2+ | 2 |
| `commons-lang3` | 3.8.1 | N2+ | 1 |
| `testng` | 6.14.2 | N2+ | 1 |
| `spring` | 2.5.6 | N2+ | 1 |
| `velocity` | 1.6.2 | N2+ | 1 |
| `commons-lang` | 2.4 | N2+ | 1 |

### 03_transitive_only_n2
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `tomcat-embed-core` | 9.0.60 | N1 | 25 |
| `snakeyaml` | 1.17 | N2+ | 15 |
| `log4j` | 1.2.16 | N1 | 12 |
| `spring-webmvc` | 5.3.18 | N1 | 7 |
| `spring-web` | 5.3.18 | N1 | 6 |
| `jackson-databind` | 2.13.2 | N2+ | 5 |
| `logback-core` | 1.2.11 | N2+ | 5 |
| `spring-context` | 5.3.18 | N2+ | 3 |
| `spring-expression` | 5.3.18 | N2+ | 3 |
| `guava` | 19.0 | N2+ | 3 |
| `commons-collections` | 3.2.1 | N1 | 2 |
| `jackson-core` | 2.13.2 | N2+ | 2 |
| `junit` | 4.11 | N2+ | 2 |
| `logback-classic` | 1.2.11 | N2+ | 1 |
| `tomcat-embed-websocket` | 9.0.60 | N2+ | 1 |
| `spring-boot` | 2.6.6 | N2+ | 1 |
| `spring-boot-autoconfigure` | 2.6.6 | N2+ | 1 |
| `spring-beans` | 5.3.18 | N2+ | 1 |
| `spring-core` | 5.3.18 | N2+ | 1 |
| `velocity` | 1.6.2 | N2+ | 1 |
| `commons-lang` | 2.4 | N2+ | 1 |
| `spring` | 2.5.6 | N2+ | 1 |
| `jakarta.el` | 3.0.3 | N2+ | 1 |

### 04_transitive_only_n3
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `log4j` | 1.2.17 | N1 | 6 |
| `commons-beanutils` | 1.9.3 | N2+ | 3 |
| `commons-collections` | 3.2.1 | N1 | 2 |

### 05_combined_n2_and_n3
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `jackson-databind` | 2.9.8 | N1 | 53 |
| `snakeyaml` | 1.6 | N2+ | 15 |
| `log4j` | 1.2.12 | N1 | 12 |
| `junit` | 4.7 | N2+ | 4 |
| `hibernate-validator` | 6.0.18.Final | N1 | 3 |
| `jackson-core` | 2.9.8 | N2+ | 3 |
| `guava` | 16.0.1 | N2+ | 3 |
| `commons-collections` | 3.2.1 | N1 | 2 |
| `gson` | 2.8.6 | N1 | 1 |
| `javax.el` | 3.0.1-b09 | N2+ | 1 |
| `velocity` | 1.6.2 | N2+ | 1 |
| `commons-lang` | 2.4 | N2+ | 1 |

### 06_deep_transitive_n4
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `commons-collections` | 3.2.1 | N1 | 2 |
| `commons-io` | 2.6 | N2+ | 2 |
| `junit` | 4.12 | N2+ | 1 |

### 07_unmaintained_repos
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `junit` | 4.7 | N2+ | 1 |

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
| 07_unmaintained_repos | **1** | 1 | 0 |
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
| 07_unmaintained_repos | [2026-04-03.csv](./07_unmaintained_repos/2026-04-03.csv) | [README.md](./07_unmaintained_repos/README.md) |
