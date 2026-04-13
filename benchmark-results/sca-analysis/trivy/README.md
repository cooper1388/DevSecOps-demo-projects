# Trivy — SCA Benchmark Results

**Tool**: Trivy (Aqua Security)
**Type**: Dedicated SCA
**Version**: Latest (2026-04-09)
**Method**: Local filesystem scan with vulnerability database
**Date of evaluation**: 2026-04-09

---

## Results by Project

| Project | Difficulty | CVEs Detected |
|---------|-----------|:---:|
| 01 Direct N1 | EASY | 7 |
| 02 N1+N2 | MEDIUM | 33 |
| 03 Transitive N2 | MEDIUM-HARD | 63 |
| 04 Transitive N3 | MEDIUM-HARD | 5 |
| 05 N2+N3 Gradle | HARD | 0 |
| 06 Deep N4 | VERY HARD | 4 |
| 07 Unmaintained | SPECIALIZED | 0 |
| **TOTAL** | | **112** |

> **Note**: Table II in the paper reports 124 CVEs for Trivy. The difference
> of 12 is due to GHSA-only advisories (no CVE alias) that were counted in
> the manual tally but are not present in the CVE-deduplicated JSON output.
> The raw JSON files in each project folder are the authoritative source.

## Data Files

Each project folder contains:
- `2026-04-09.json` — Raw Trivy JSON output
- `2026-04-09.csv` — Extracted CVEs in normalized CSV format

Aggregated file:
- `trivy_all_issues.csv` — All CVEs across all projects

## Key Observations

- **P05 = 0**: Trivy does not support Gradle projects without a lock file
  (`gradle.lockfile`). The benchmark project uses `build.gradle` only.
- **P04/P06**: Trivy resolves multi-module Maven projects but depth is
  limited compared to agentic tools.
- **P07 = 0**: No trust/maintainer analysis capability. Only reports CVEs.
- **Reproducibility**: CV = 0% over 15 runs (deterministic, frozen DB).

## Command Used

```bash
trivy fs --scanners vuln --format json --output <output.json> <project-path>
```
