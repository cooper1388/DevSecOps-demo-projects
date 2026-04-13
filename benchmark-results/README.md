# Benchmark Results — Comparative Analysis (10 Tools)

**Date:** 2026-04-03 to 2026-04-10
**Benchmark:** 7 synthetic Java/Kotlin projects with intentional supply chain vulnerabilities
**Ground truth:** `expected.json` per project (source: NVD + OSV API)
**Paper:** IEEE LA-CCI 2026

---

## Overall Comparison (10 Tools)

| # | Tool | Type | P01 | P02 | P03 | P04 | P05 | P06 | P07 | Total |
|---|------|------|:---:|:---:|:---:|:---:|:---:|:---:|:---:|------:|
| 1 | **Agentic SCVS** | Agentic pipeline | 38 | 61 | 100 | 11 | 99 | 5 | 1 | **315** |
| 2 | M365 Copilot GPT-5 | LLM-as-scanner | 8 | 51 | 63 | 5 | 63 | 4 | 0 | **194** |
| 3 | Google Antigravity | Agentic IDE | 8 | 28 | 65 | 10 | 61 | 4 | 0 | **177** |
| 4 | GitHub Copilot (Haiku) | LLM-as-scanner | 6 | 32 | 38 | 6 | 65 | 10 | 0 | **157** |
| 5 | Claude Opus 4 | LLM-as-scanner | 5 | 20 | 35 | 3 | 64 | 3 | 0 | **128** |
| 6 | Trivy | Dedicated SCA | 7 | 33 | 66 | 10 | 0 | 8 | 0 | **124** |
| 7 | Snyk | Dedicated SCA | 7 | 32 | 66 | 0 | 0 | 0 | 0 | **105** |
| 8 | OSV-Scanner | Dedicated SCA | 7 | 33 | 64 | 0 | 0 | 0 | 0 | **104** |
| 9 | Grype | Dedicated SCA | 6 | 28 | 0 | 5 | 0 | 4 | 0 | **43** |
| 10 | SonarQube 26.3 | SAST | 0 | 0 | 0 | 0 | 0 | 0 | 0 | **0** |

> **Note**: Antigravity total is the mean of 5 runs (176.8, rounded to 177).
> SCA tool totals are from CVE-deduplicated JSON extraction. SonarQube detects
> code smells (20 total) but 0 CVEs, as expected for SAST on clean code.

---

## Key Percentages (vs Agentic SCVS)

| Baseline | CVEs | Gap |
|----------|:----:|-----|
| M365 Copilot GPT-5 (strongest LLM) | 194 | **+62%** |
| Google Antigravity (strongest Agentic IDE) | 177 | **+78%** |
| Trivy (strongest SCA) | 124 | **+154%** |

---

## Reproducibility

| Tool | n | Mean | Std | CV | Class |
|------|--:|-----:|----:|---:|-------|
| SCA tools (4) | 15 | -- | 0 | 0% | Deterministic (frozen DB) |
| Agentic SCVS | 15 | 316.5 | 2.23 | 0.71% | Quasi-deterministic |
| Google Antigravity | 5 | 176.8 | 6.69 | 3.78% | Moderate variance |
| Claude Opus 4 | 15 | 70.3 | 17.33 | 24.6% | High variance |

> SCA tools report CV = 0% because they use frozen vulnerability databases.
> This is artificial determinism, not intrinsic precision.

---

## Tool Categories

### Agentic Pipeline
- [**Agentic SCVS**](ai-analysis/supply_chain_agentic/) — 5 autonomous agents + 3 deterministic skills + bidirectional SQLite bus. Multi-source (OSV + OSS Index + deps.dev + NVD). Depth N5.

### Agentic IDE Assistant
- [**Google Antigravity**](ai-analysis/antigravity/) — Gemini 3.1 Pro. Generates scanning scripts autonomously. OSV.dev + Maven Central. n=5 runs.

### LLM-as-Scanner
- [**M365 Copilot GPT-5**](ai-analysis/m365_copilot/) — GPT-5.4 Think Deeper. Web search against NVD/GHSA. 60-100+ reasoning steps.
- [**GitHub Copilot (Haiku)**](ai-analysis/copilot/) — Claude Haiku 4.5. GitHub Advisory Database + LLM reasoning.
- [**Claude Opus 4**](ai-analysis/claude/) — Pure LLM knowledge base analysis (NVD, MITRE, May 2025 cutoff).

### Dedicated SCA
- [**Trivy**](sca-analysis/trivy/) — Aqua Security. Local filesystem scan. Cannot scan Gradle without lock file.
- [**Snyk**](sca-analysis/snyk/) — Commercial SCA. Requires auth. Limited multi-module support.
- [**OSV-Scanner**](sca-analysis/osv-scanner/) — Google. OSV.dev database. Fails with multi-module Maven on Windows.
- [**Grype**](sca-analysis/grype/) — Anchore. Only detects N1 direct dependencies from pom.xml.

### SAST
- **SonarQube 26.3** — Static code analysis. Detects code smells, not dependency vulnerabilities. See [sast-analysis/](sast-analysis/).

---

## Cross-Analysis Summary

| Metric | SCVS | M365 | Antigravity | Copilot | Claude | Trivy | Snyk | OSV | Grype | Sonar |
|--------|:----:|:----:|:-----------:|:-------:|:------:|:-----:|:----:|:---:|:-----:|:-----:|
| **CVEs** | **315** | 194 | 177 | 157 | 128 | 124 | 105 | 104 | 43 | 0 |
| **Max depth** | N5 | N4 | N4 | N3 | N3 | N3 | N2 | N2 | N1 | N/A |
| **Multi-module** | Yes | Yes | Yes | Partial | Partial | Yes | No | No | No | Yes |
| **Trust analysis** | Yes | No | No | No | No | No | No | No | No | No |
| **License check** | Yes | No | No | No | No | No | Yes | No | No | No |
| **Abandoned detect** | Yes | No | No | No | No | No | No | No | No | No |
| **Automated** | Yes | No | Yes | Semi | Semi | Yes | Yes | Yes | Yes | Yes |

---

## Key Insights

1. **SAST and SCA are complementary, not competing.** SonarQube found 0
   vulnerabilities because the projects are SAST-clean by design — the
   vulnerabilities are in the dependency versions, not in the code.

2. **Depth is the key differentiator.** Agentic SCVS detects CVEs up to N5
   (5 levels deep). SCA tools stop at N1-N3. Each additional level exposes
   vulnerabilities that shallower tools miss entirely.

3. **P04/P05/P06 separate agentic from traditional.** All 4 dedicated SCA
   tools detect 0 CVEs in at least 2 of these 3 projects. Only LLM-based
   and agentic tools reach N3+ depth.

4. **Trust and licenses are orthogonal dimensions.** P07 has 0 CVEs but 5
   abandoned dependencies with trust CRITICAL findings. Only Agentic SCVS
   detects this risk.

5. **LLM variance is extreme.** The same dependency list yields 128-194 CVEs
   depending on the LLM model and prompt, a 1.5x variance range.

---

## Directory Structure

```
benchmark-results/
├── README.md                          ← this file
├── ai-analysis/
│   ├── supply_chain_agentic/          ← Agentic SCVS (315 CVEs)
│   ├── m365_copilot/                  ← M365 Copilot GPT-5 (194 CVEs)
│   ├── antigravity/                   ← Google Antigravity (177 CVEs)
│   ├── copilot/                       ← GitHub Copilot Haiku (157 CVEs)
│   └── claude/                        ← Claude Opus 4 (128 CVEs)
├── sca-analysis/
│   ├── trivy/                         ← Trivy (124 CVEs)
│   ├── snyk/                          ← Snyk (105 CVEs)
│   ├── osv-scanner/                   ← OSV-Scanner (104 CVEs)
│   └── grype/                         ← Grype (43 CVEs)
└── sast-analysis/                     ← SonarQube (0 CVEs, 20 code smells)
```

---

## Running the Benchmark

```bash
# AI analysis (Agentic SCVS)
python benchmark/run_benchmark.py

# SCA tools
trivy fs --scanners vuln --format json <project-path>
snyk test --json --file=pom.xml
osv-scanner scan --format json <project-path>
grype dir:<project-path> -o json

# SAST analysis
# Requires SonarQube instance — see sast-analysis/ for existing results
```
