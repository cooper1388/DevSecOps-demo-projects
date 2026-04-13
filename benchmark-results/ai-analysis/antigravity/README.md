# Google Antigravity (Gemini 3.1 Pro) — AI Benchmark Results

**Tool**: Google Antigravity IDE
**Model**: Gemini 3.1 Pro (confirmed in IDE status bar)
**Type**: Agentic IDE assistant
**Mode**: High thinking + Planning mode
**Method**: Agent generates Python scanning scripts, queries OSV.dev +
Maven Central
**Date of evaluation**: 2026-04-10 (n=5 runs)
**Total CVEs detected**: 177 (mean of 5 runs: 176.8 +/- 6.69)

---

## Results by Project (5 runs)

| Project | R1 | R2 | R3 | R4 | R5 | Mean | Std |
|---------|---:|---:|---:|---:|---:|-----:|----:|
| 01 Direct N1 | 7 | 7 | 7 | 8 | 10 | 7.8 | 1.30 |
| 02 N1+N2 | 27 | 27 | 27 | 28 | 33 | 28.4 | 2.61 |
| 03 Trans N2 | 65 | 64 | 65 | 63 | 69 | 65.2 | 2.30 |
| 04 Trans N3 | 11 | 11 | 11 | 11 | 5 | 9.8 | 2.68 |
| 05 Gradle N2+N3 | 59 | 59 | 59 | 64 | 66 | 61.4 | 3.42 |
| 06 Deep N4 | 4 | 4 | 4 | 4 | 4 | 4.0 | 0.00 |
| 07 Abandoned | 0 | 0 | 0 | 0 | 1 | 0.2 | 0.45 |
| **Total** | **173** | **172** | **173** | **178** | **188** | **176.8** | **6.69** |

## Reproducibility

- **Mean**: 176.8 CVEs
- **Std dev**: 6.69
- **CV**: 3.78%
- **Range**: [172, 188]
- 6 of 7 projects show variance (only P06 has zero variance)
- Run 5 outlier: +15 CVEs vs mean of runs 1-4

## Data Files

Each project folder contains:
- `2026-04-10.csv` — Summary results per run (5 runs)

Aggregated files:
- `antigravity_summary.csv` — Per-project summary with means
- `antigravity_all_runs.csv` — All 5 runs raw data

> **Note**: Antigravity is an agentic IDE tool. It generates its own
> scanning scripts at runtime, so output format varies between runs.
> Results were collected from the agent's structured output. The CSV files
> contain summary counts per run, not individual CVE listings.

## Prompts

Full prompts used for each project are documented in:
`benchmark/prompts/prompt_google_antigravity.md`

## Key Observations

- **NOT quasi-deterministic**: CV 3.78% over n=5 (initial n=3 suggested
  CV 0.33%, which was misleading)
- **6.5x more stable than Claude Opus 4** (CV 3.78% vs 24.6%)
- **SCVS is 5.3x more stable than Antigravity** (CV 0.71% vs 3.78%)
- **Agent generates its own scanning script** each run (source of
  variability)
- **Uses OSV.dev as primary source** (single-source vs multi-source in
  SCVS)
- **P07 = 0 in 4/5 runs**: No trust analysis capability
- **Run 5 regression in P04** (11 -> 5) + gain in P07 (0 -> 1):
  inconsistent in both directions

## Configuration

- IDE: Google Antigravity (https://antigravity.google)
- Model: Gemini 3.1 Pro (backend confirmed in status bar)
- Thinking: High
- Planning: enabled
- Session: new workspace per run
