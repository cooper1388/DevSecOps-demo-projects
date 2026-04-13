# Snyk — SCA Benchmark Results

**Tool**: Snyk (commercial SCA)
**Type**: Dedicated SCA (commercial)
**Version**: Latest CLI (2026-04-09)
**Method**: Dependency resolution + Snyk vulnerability database
**Date of evaluation**: 2026-04-09

---

## Results by Project

| Project | Difficulty | CVEs Detected |
|---------|-----------|:---:|
| 01 Direct N1 | EASY | 7 |
| 02 N1+N2 | MEDIUM | 32 |
| 03 Transitive N2 | MEDIUM-HARD | 66 |
| 04 Transitive N3 | MEDIUM-HARD | 0 |
| 05 N2+N3 Gradle | HARD | 0 |
| 06 Deep N4 | VERY HARD | 0 |
| 07 Unmaintained | SPECIALIZED | 0 |
| **TOTAL** | | **105** |

## Data Files

Each project folder contains:
- `2026-04-09.json` — Raw Snyk JSON output
- `2026-04-09.csv` — Extracted CVEs in normalized CSV format

Aggregated file:
- `snyk_all_issues.csv` — All CVEs across all projects

## Key Observations

- **P04/P05/P06 = 0**: Snyk fails to resolve multi-module Maven/Gradle
  projects in this benchmark configuration. It only detects dependencies
  declared directly in the scanned `pom.xml`.
- **P07 = 0**: No trust/maintainer analysis capability.
- **Reproducibility**: CV = 0% over 15 runs (deterministic, frozen DB).
- **Commercial tool**: Requires authentication (`snyk auth`).

## Command Used

```bash
snyk test --json --file=pom.xml > <output.json>
```
