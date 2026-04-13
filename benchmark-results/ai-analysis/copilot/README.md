# CVE Analysis — Benchmark Projects Summary

**Scan Date:** 2026-04-03 (original), 2026-04-09 (revalidation)  
**Tool:** GitHub Copilot Chat (VS Code extension)  
**Model:** Claude Haiku 4.5 (identified in Copilot response metadata)  
**Scope:** 7 benchmark projects under `benchmark-projects/`

---

## Results Overview

| Project | Description | CVEs Total | CRITICAL | HIGH | MEDIUM | LOW |
|---|---|:---:|:---:|:---:|:---:|:---:|
| [01_direct_vuln_n1](./01_direct_vuln_n1/README.md) | Vulnerabilidades directas (N1) | **6** | 3 | 1 | 2 | 0 |
| [02_vuln_n1_and_n2](./02_vuln_n1_and_n2/README.md) | Vulnerabilidades N1 + N2 transitivas | **32** | 4 | 25 | 3 | 0 |
| [03_transitive_only_n2](./03_transitive_only_n2/README.md) | Solo transitivas de 1er nivel (N2) | **38** | 3 | 20 | 15 | 0 |
| [04_transitive_only_n3](./04_transitive_only_n3/README.md) | Solo transitivas de 2do nivel (N3) | **6** | 1 | 5 | 0 | 0 |
| [05_combined_n2_and_n3](./05_combined_n2_and_n3/README.md) | Combinado N2 + N3 (Gradle) | **65** | 12 | 46 | 7 | 0 |
| [06_deep_transitive_n4](./06_deep_transitive_n4/README.md) | Transitivas profundas (N4) | **10** | 2 | 5 | 3 | 0 |
| [07_unmaintained_repos](./07_unmaintained_repos/README.md) | Repositorios abandonados | **0** | 0 | 0 | 0 | 0 |
| **TOTAL** | | **157** | **25** | **102** | **30** | **0** |

> **Note**: Original scan (2026-04-03) detected 150 CVEs. Revalidation
> (2026-04-09) with identical prompts detected 157 CVEs. Differences:
> P03 -4 (truncation), P04 +1 (new CVE), P05 +4 (jackson-core 2025),
> P06 +6 (broader depth analysis). Per-project CSVs contain original data.

---

## CVE Distribution by Severity

```
CRITICAL  ████████████████████████░  24  (16.0%)
HIGH      ████████████████████████████████████████████████████████████████████████████░  96  (64.0%)
MEDIUM    ████████████████████░  30  (20.0%)
LOW       0   (0.0%)
```

---

## Vulnerable Dependencies per Project

### 01_direct_vuln_n1
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `log4j-core` | 2.14.1 | N1 | 5 |
| `commons-text` | 1.9 | N1 | 1 |

### 02_vuln_n1_and_n2
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `struts2-core` | 2.5.25 | N1 | 10 |
| `xstream` | 1.4.17 | N1 | 18 |
| `commons-fileupload` | 1.4 | N2 | 2 |
| `commons-io` | 2.6 | N2 | 2 |

### 03_transitive_only_n2
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `tomcat-embed-core` | 9.0.60 | N2 | 25 |
| `spring-webmvc` | 5.3.18 | N2 | 7 |
| `spring-web` | 5.3.18 | N2 | 6 |
| `snakeyaml` | 1.29 | N2 | 7 |
| `jackson-databind` | 2.13.2.2 | N2 | 2 |
| `logback-classic` | 1.2.11 | N2 | 1 |

### 04_transitive_only_n3
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `commons-collections` | 3.2.1 | N3 | 2 |
| `commons-beanutils` | 1.9.3 | N3 | 3 |

### 05_combined_n2_and_n3
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `jackson-databind` | 2.9.8 | N3 | 53 |
| `snakeyaml` | 1.30 | N2 | 7 |
| `gson` | 2.8.6 | N2 | 1 |

### 06_deep_transitive_n4
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `commons-collections` | 3.2.1 | N4 | 2 |
| `commons-io` | 2.6 | N4 | 2 |

### 07_unmaintained_repos
| Dependency | Version | Level | CVEs |
|---|---|---|:---:|
| `oro` | 2.0.8 | N1 | 0 |
| `jsr305` | 3.0.2 | N1 | 0 |
| `jcip-annotations` | 1.0 | N1 | 0 |
| `opencsv` | 2.3 | N1 | 0 |

---

## Key Findings

1. **El proyecto 05** (`jackson-databind:2.9.8`) concentra el 39.9% del total de CVEs (61/153) en un solo artefacto, con 53 CVEs en `jackson-databind:2.9.8` incluyendo 12 CRITICAL de RCE via deserialización.

2. **Las vulnerabilidades transitivas son la mayor fuente de riesgo**: los proyectos 03, 04, 05 y 06 tienen 0 CVEs en dependencias directas pero acumulan 115 CVEs en sus transitivas (75% del total).

3. **La profundidad no protege**: `commons-collections:3.2.1` con CVE CRITICAL (CVE-2015-7501) aparece como N3 en el proyecto 04 y como N4 en el proyecto 06, igualmente explotable en ambos casos.

4. **El proyecto 07 (sin CVEs) es el caso control**: dependencias abandonadas no siempre tienen CVEs registrados, pero representan riesgo operativo por ausencia de mantenimiento futuro.

5. **Patrones de vulnerabilidad más frecuentes**:
   - RCE via deserialización Java (gadgets): 40+ CVEs
   - Denial of Service (DoS): 35+ CVEs
   - Path Traversal: 8 CVEs
   - HTTP Request Smuggling: 6 CVEs
   - SSRF / Open Redirect: 5 CVEs
   - Security/Auth Bypass: 5 CVEs

---

## Output Files

Cada carpeta de proyecto contiene:
- `2026-04-03.csv` — listado estructurado de CVEs con columnas: `scan_date`, `project`, `group_id`, `artifact_id`, `version`, `dependency_level`, `cve_id`, `severity`, `cve_type`, `short_description`, `fix_version`, `advisory_url`
- `README.md` — descripción detallada de cada CVE con tipo, impacto y remediación

| Proyecto | CSV | README |
|---|---|---|
| 01_direct_vuln_n1 | [2026-04-03.csv](./01_direct_vuln_n1/2026-04-03.csv) | [README.md](./01_direct_vuln_n1/README.md) |
| 02_vuln_n1_and_n2 | [2026-04-03.csv](./02_vuln_n1_and_n2/2026-04-03.csv) | [README.md](./02_vuln_n1_and_n2/README.md) |
| 03_transitive_only_n2 | [2026-04-03.csv](./03_transitive_only_n2/2026-04-03.csv) | [README.md](./03_transitive_only_n2/README.md) |
| 04_transitive_only_n3 | [2026-04-03.csv](./04_transitive_only_n3/2026-04-03.csv) | [README.md](./04_transitive_only_n3/README.md) |
| 05_combined_n2_and_n3 | [2026-04-03.csv](./05_combined_n2_and_n3/2026-04-03.csv) | [README.md](./05_combined_n2_and_n3/README.md) |
| 06_deep_transitive_n4 | [2026-04-03.csv](./06_deep_transitive_n4/2026-04-03.csv) | [README.md](./06_deep_transitive_n4/README.md) |
| 07_unmaintained_repos | [2026-04-03.csv](./07_unmaintained_repos/2026-04-03.csv) | [README.md](./07_unmaintained_repos/README.md) |
