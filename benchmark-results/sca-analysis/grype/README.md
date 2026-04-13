# Grype — SCA Benchmark Results

**Tool**: Grype (Anchore)
**Type**: Dedicated SCA (open source)
**Version**: Latest (2026-04-09)
**Method**: Dependency resolution + Grype vulnerability database
**Date of evaluation**: 2026-04-09

---

## Results by Project

| Project | Difficulty | CVEs Detected |
|---------|-----------|:---:|
| 01 Direct N1 | EASY | 6 |
| 02 N1+N2 | MEDIUM | 28 |
| 03 Transitive N2 | MEDIUM-HARD | 0 |
| 04 Transitive N3 | MEDIUM-HARD | 5 |
| 05 N2+N3 Gradle | HARD | 0 |
| 06 Deep N4 | VERY HARD | 4 |
| 07 Unmaintained | SPECIALIZED | 0 |
| **TOTAL** | | **43** |

## Data Files

Each project folder contains:
- `2026-04-09.json` — Raw Grype JSON output (uses GHSA IDs as primary;
  CVE IDs extracted from `relatedVulnerabilities`)
- `2026-04-09.csv` — Extracted CVEs in normalized CSV format

Aggregated file:
- `grype_all_issues.csv` — All CVEs across all projects

## Key Observations

- **Only detects N1 direct dependencies**: Grype does not resolve
  transitive dependency trees from `pom.xml`. It relies on lock files
  or SBOM input for deeper analysis.
- **P03 = 0**: Despite having 63+ CVEs in N2 transitives, Grype cannot
  see them because spring-boot-starter-web is a clean wrapper.
- **P04/P06 > 0**: Grype detected dependencies in multi-module projects
  by scanning each module's `pom.xml` independently.
- **P07 = 0**: No trust/maintainer analysis capability.
- **Reproducibility**: CV = 0% over 15 runs (deterministic, frozen DB).

## Command Used

```bash
grype dir:<project-path> -o json > <output.json>
```
