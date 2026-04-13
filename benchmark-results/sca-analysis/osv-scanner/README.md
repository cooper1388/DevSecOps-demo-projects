# OSV-Scanner — SCA Benchmark Results

**Tool**: OSV-Scanner (Google)
**Type**: Dedicated SCA (open source)
**Version**: Latest (2026-04-09)
**Method**: Dependency resolution + OSV.dev vulnerability database
**Date of evaluation**: 2026-04-09

---

## Results by Project

| Project | Difficulty | CVEs Detected |
|---------|-----------|:---:|
| 01 Direct N1 | EASY | 7 |
| 02 N1+N2 | MEDIUM | 33 |
| 03 Transitive N2 | MEDIUM-HARD | 63 |
| 04 Transitive N3 | MEDIUM-HARD | 0 |
| 05 N2+N3 Gradle | HARD | 0 |
| 06 Deep N4 | VERY HARD | 0 |
| 07 Unmaintained | SPECIALIZED | 0 |
| **TOTAL** | | **103** |

> **Note**: Table II in the paper reports 104 CVEs for OSV-Scanner. The
> difference of 1 is due to a GHSA-only advisory without a CVE alias in the
> P03 output. The raw JSON files are the authoritative source.

## Data Files

Each project folder contains:
- `2026-04-09.json` — Raw OSV-Scanner JSON output
- `2026-04-09.csv` — Extracted CVEs in normalized CSV format

Aggregated file:
- `osv_scanner_all_issues.csv` — All CVEs across all projects

## Key Observations

- **P04/P05/P06 = 0**: OSV-Scanner fails with multi-module Maven projects
  on Windows. It cannot resolve inter-module dependencies.
- **P07 = 0**: No trust/maintainer analysis capability.
- **Reproducibility**: CV = 0% over 15 runs (deterministic, frozen DB).

## Command Used

```bash
osv-scanner scan --format json --output <output.json> <project-path>
```
