# M365 Copilot GPT-5 Think Deeper — AI Benchmark Results

**Tool**: Microsoft 365 Copilot (productivity, NOT GitHub Copilot)
**Model**: GPT-5.4 Think Deeper (extended reasoning mode)
**Type**: LLM-as-scanner
**Method**: Web search in real-time against NVD/GHSA/OpenCVE/Tenable
**Account**: University license (UTH)
**Reasoning**: 60-100+ steps per project
**Date of evaluation**: 2026-04-10
**Total CVEs detected**: 194

---

## Results by Project

| Project | Difficulty | CVEs | Severity |
|---------|-----------|:---:|----------|
| 01 Direct N1 | EASY | 8 | 3C/2H/3M/0L |
| 02 N1+N2 | MEDIUM | 51 | 4C/35H/12M/0L |
| 03 Transitive N2 | MEDIUM-HARD | 63 | 1C/24H/34M/4L |
| 04 Transitive N3 | MEDIUM-HARD | 5 | 2C/3H/0M/0L |
| 05 N2+N3 Gradle | HARD | 63 | 7C/50H/6M/0L |
| 06 Deep N4 | VERY HARD | 4 | 2C/0H/2M/0L |
| 07 Unmaintained | SPECIALIZED | 0 | 0/0/0/0 |
| **TOTAL** | | **194** | **19C/114H/57M/4L** |

## Data Files

Each project folder contains:
- `2026-04-10.csv` — Summary results (tool, project, CVE count, severity)

Aggregated file:
- `m365_copilot_summary.csv` — All projects summary

> **Note**: M365 Copilot is a conversational AI tool. Unlike CLI SCA tools,
> it does not produce machine-readable JSON output. Results were collected
> from structured chat responses using controlled prompts. The per-project
> CSV files contain summary counts, not individual CVE listings.

## Prompts

Full prompts used for each project are documented in:
`benchmark/prompts/prompt_m365_copilot_gpt5.md`

## Key Observations

- **Strongest LLM-based tool tested** (194 CVEs, rank #2 overall)
- **Competitive with dedicated SCA** in P03 (63 vs 64-69 for SCA tools)
- **Over-counts in small projects**: P02 = 51 vs 33 for SCA tools
  (extended reasoning finds version-range CVEs)
- **Not scalable**: 60-100+ reasoning steps per project, slow for
  practical use
- **P07 = 0**: No trust/maintainer analysis capability
- **Single run**: No reproducibility data (not automatable)

## Configuration

- Temperature: default (not configurable in M365 Copilot Chat)
- Web search: enabled (real-time queries to NVD, GHSA, OpenCVE, Tenable)
- Think Deeper: enabled (extended reasoning)
- Session: new chat per project to avoid cross-contamination
