# CVE Analysis — Claude Opus 4

**Scan Date:** 2026-04-03
**Analyst:** Claude Opus 4 via Claude Code
**Method:** LLM-based CVE analysis using Claude Opus 4 knowledge base.
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
| [07_unmaintained_repos](./07_unmaintained_repos/README.md) | Repositorios abandonados | **0** | 0 | 0 | 0 | 0 |
| **TOTAL** | | **128** | **27** | **80** | **21** | **0** |

---

## Comparison

| Proyecto | Claude | Supply Chain Agentic | GitHub Copilot |
|:---|:---:|:---:|:---:|
| 01_direct_vuln_n1 | **5** | 7 | 6 |
| 02_vuln_n1_and_n2 | **28** | 34 | 32 |
| 03_transitive_only_n2 | **30** | 60 | 42 |
| 04_transitive_only_n3 | **4** | 11 | 5 |
| 05_combined_n2_and_n3 | **57** | 78 | 61 |
| 06_deep_transitive_n4 | **4** | 5 | 4 |
| 07_unmaintained_repos | **0** | 1 | 0 |
| | | | |
| **TOTAL** | **128** | **196** | **150** |

---

## Methodology

This analysis was performed by Claude Opus 4 as an LLM-based security assessment:

1. Each project's `pom.xml` or `build.gradle` was read manually
2. Dependencies and their exact versions were identified (including multi-module projects)
3. CVEs were recalled from Claude's training data (NVD, GitHub Advisory, MITRE up to May 2025)
4. Each CVE was verified for version applicability
5. Transitive dependencies were analyzed where the build structure reveals them

> **Note:** This analysis is limited to CVEs in Claude's training data. Post-May 2025 CVEs are not included.

---

## Output Files

| Project | CSV | README |
|---|---|---|
| 01_direct_vuln_n1 | [2026-04-03.csv](./01_direct_vuln_n1/2026-04-03.csv) | [README.md](./01_direct_vuln_n1/README.md) |
| 02_vuln_n1_and_n2 | [2026-04-03.csv](./02_vuln_n1_and_n2/2026-04-03.csv) | [README.md](./02_vuln_n1_and_n2/README.md) |
| 03_transitive_only_n2 | [2026-04-03.csv](./03_transitive_only_n2/2026-04-03.csv) | [README.md](./03_transitive_only_n2/README.md) |
| 04_transitive_only_n3 | [2026-04-03.csv](./04_transitive_only_n3/2026-04-03.csv) | [README.md](./04_transitive_only_n3/README.md) |
| 05_combined_n2_and_n3 | [2026-04-03.csv](./05_combined_n2_and_n3/2026-04-03.csv) | [README.md](./05_combined_n2_and_n3/README.md) |
| 06_deep_transitive_n4 | [2026-04-03.csv](./06_deep_transitive_n4/2026-04-03.csv) | [README.md](./06_deep_transitive_n4/README.md) |
| 07_unmaintained_repos | [2026-04-03.csv](./07_unmaintained_repos/2026-04-03.csv) | [README.md](./07_unmaintained_repos/README.md) |
