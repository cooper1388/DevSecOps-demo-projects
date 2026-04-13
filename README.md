# DevSecOps Benchmark Projects

A set of synthetic Java/Kotlin projects with intentional dependency
vulnerabilities, designed to benchmark **Software Composition Analysis (SCA)**
tools, **LLM-as-scanner**, **Agentic IDE assistants**, and agentic pipelines
across differentiated supply chain risk scenarios.

Each project in `benchmark-projects/` isolates a specific vulnerability depth
level in the dependency tree, enabling precise evaluation of how deep and how
accurately a tool can detect known CVEs and supply chain risks.

This benchmark is the experimental basis for the paper **"Agentic AI for
Software Supply Chain Vulnerability Analysis: A Multi-Agent DevSecOps
Approach"** (IEEE LA-CCI 2026, submitted).

> **Important:** CVE databases evolve over time. New vulnerabilities may be
> published for libraries that were considered clean at the time of project
> creation. Always cross-reference results with the measurement date listed
> below.

---

## Benchmark Scenarios

The projects cover **7 differentiated test cases**, each targeting a specific
depth level or risk type:

| # | Project | Build | Scenario | Ground Truth |
|---|---------|-------|----------|--------------|
| 01 | [`01_direct_vuln_n1`](benchmark-projects/01_direct_vuln_n1/) | Maven | Direct (N1) vulnerabilities only | 2026-04-03 |
| 02 | [`02_vuln_n1_and_n2`](benchmark-projects/02_vuln_n1_and_n2/) | Maven | Vulnerabilities at N1 (direct) and N2 (transitive) | 2026-04-03 |
| 03 | [`03_transitive_only_n2`](benchmark-projects/03_transitive_only_n2/) | Maven | Vulnerabilities only at N2 (direct deps are clean) | 2026-04-03 |
| 04 | [`04_transitive_only_n3`](benchmark-projects/04_transitive_only_n3/) | Maven (multi-module) | Vulnerabilities only at N3 (2 clean layers above) | 2026-04-03 |
| 05 | [`05_combined_n2_and_n3`](benchmark-projects/05_combined_n2_and_n3/) | Gradle (multi-module) | Combined vulnerabilities at N2 and N3 (no N1) | 2026-04-03 |
| 06 | [`06_deep_transitive_n4`](benchmark-projects/06_deep_transitive_n4/) | Maven (multi-module) | Vulnerabilities only at N4 (3 clean layers above) | 2026-04-03 |
| 07 | [`07_unmaintained_repos`](benchmark-projects/07_unmaintained_repos/) | Maven | Unmaintained/abandoned libraries with 0 CVEs | 2026-04-03 |

### Dependency Depth Levels Explained

```
app (pom.xml / build.gradle)
└── library-a              ← N1 (direct dependency)
    └── library-b          ← N2 (first-level transitive)
        └── library-c      ← N3 (second-level transitive)
            └── library-d  ← N4 (deep transitive)
                └── library-e  ← N5 (fourth transitive layer)
```

- **N1**: Declared directly in the build file
- **N2**: Immediate transitive dependency
- **N3**: Two levels deep in the transitive tree
- **N4**: Three levels deep -- often beyond default SCA analysis depth
- **N5**: Four levels deep -- only Supply Chain Agentic reaches this depth

---

## Benchmark Results (10 tools evaluated)

Full comparison against **10 baselines** grouped into 4 categories
(measurements taken between 2026-04-09 and 2026-04-11):

### Global ranking by CVEs detected

| # | Tool | Category | CVEs | CV (%) | n runs |
|---|------|----------|-----:|-------:|-------:|
| 1 | **Supply Chain Agentic** | Agentic pipeline | **315** | **0.71** | n=15 |
| 2 | M365 Copilot GPT-5 Think Deeper | LLM-as-scanner | 194 | -- | n=1 |
| 3 | Google Antigravity (Gemini 3.1 Pro) | Agentic IDE | 177 | 3.78 | n=5 |
| 4 | GitHub Copilot (Haiku 4.5) | LLM-as-scanner | 157 | -- | n=1 |
| 5 | Claude Opus 4 | LLM-as-scanner | 128 | -- | n=1 |
| 6 | Trivy | Dedicated SCA | 124 | 0.00* | n=15 |
| 7 | Snyk | Dedicated SCA | 105 | -- | n=1 |
| 8 | OSV-Scanner (Google) | Dedicated SCA | 104 | 0.00* | n=15 |
| 9 | Grype | Dedicated SCA | 43 | 0.00* | n=15 |
| 10 | SonarQube 26.3 | SAST | 0 | 0.00* | n=1 |

\**CV = 0% for SCA/SAST tools is artificial, reflecting frozen vulnerability
databases, not true reproducibility under live API conditions.*

### Per-project: Supply Chain Agentic vs top baselines by category

| Project | **SCVS** | M365 GPT-5 | Antigravity | Copilot Haiku | Claude Opus 4 | Trivy | Snyk | OSV | Grype | Sonar |
|---------|:--------:|:----------:|:-----------:|:-------------:|:-------------:|:-----:|:----:|:---:|:-----:|:-----:|
| 01 Direct N1       | **38** | 8   | 8   | 6   | 5   | 7   | 7   | 7   | 6   | 0 |
| 02 N1+N2           | **61** | 51  | 28  | 32  | 20  | 33  | 32  | 33  | 28  | 0 |
| 03 Trans N2        | **100**| 63  | 65  | 38  | 35  | 66  | 66  | 64  | 0   | 0 |
| 04 Trans N3        | **11** | 5   | 10  | 6   | 3   | 10  | 0   | 0   | 5   | 0 |
| 05 Gradle N2+N3    | **99** | 63  | 61  | 65  | 64  | 0   | 0   | 0   | 0   | 0 |
| 06 Deep N4         | **5**  | 4   | 4   | 10  | 3   | 8   | 0   | 0   | 4   | 0 |
| 07 Abandoned       | **1**  | 0   | 0   | 0   | 0   | 0   | 0   | 0   | 0   | 0 |
| **TOTAL**          | **315**| 194 | 177 | 157 | 128 | 124 | 105 | 104 | 43  | 0 |

---

## Key Benchmark Findings

### Detection gap of Supply Chain Agentic

- **+62%** vs M365 Copilot GPT-5 (strongest LLM-as-scanner)
- **+78%** vs Google Antigravity (strongest Agentic IDE)
- **+154%** vs Trivy (strongest dedicated SCA)
- **Infinity** vs SonarQube (SAST is blind to dependency risks)

### Reproducibility

- **Supply Chain Agentic**: Mean 316.5 +/- 2.23 CVEs over n=15 runs, CV 0.71%
- **Google Antigravity**: Mean 176.8 +/- 6.69 CVEs over n=5 runs, CV 3.78%
- SCVS is **5.3x more stable** than the best agentic baseline
- SCA tools report CV = 0% but this is **artificial** (frozen databases,
  not real robustness)

### Depth and diminishing returns

- **43% of all CVEs detected reside at N3 or deeper** -- a level invisible
  to conventional SCA tools limited to N1-N2
- Only SCVS continues detecting CVEs up to **N5**
- LLM-as-scanner tools and SCA plateau at N2-N3
- N6 adds only +8.6% CVEs at the cost of +19% time and +25% cost -- **N5
  is the optimal** coverage-vs-cost tradeoff

### Unique contribution: Trust analysis in P07

- P07 contains only abandoned libraries **with no known CVEs**
- All CVE-based tools detect 0 vulnerabilities
- **Supply Chain Agentic is the only tool that identifies 5 dependencies
  with CRITICAL trust level** (packages abandoned since 2003-2017)
- Demonstrates that CVE scanning alone is insufficient; maintainer trust
  analysis is necessary

### Severity (top 4 tools)

| Tool | Critical | High | Medium | Low |
|------|---------:|-----:|-------:|----:|
| **Supply Chain Agentic** | **40** | 173 | 87 | 11 |
| M365 Copilot GPT-5 | 19 | 114 | 57 | 4 |
| Google Antigravity | 27 | 106 | 35 | 3 |
| Claude Opus 4 | 27 | 80 | 21 | 0 |

SCVS detects proportionally more **CRITICAL** vulnerabilities than any other
baseline, thanks to deep scanning that reaches libraries with known
deserialization chains (commons-collections, jackson-databind) at N3+ levels.

---

## Running the Benchmark

```bash
# Full benchmark (all 7 projects)
python benchmark/run_benchmark.py

# Single project
python benchmark/run_benchmark.py --project 04_transitive_only_n3

# With number of runs for reproducibility analysis
python benchmark/run_benchmark.py --runs 15
```

Generates CSV + README per project in `benchmark-results/ai-analysis/supply_chain_agentic/`.

---

## Benchmark Results Directory

The `benchmark-results/` folder contains results from all evaluated tools:

### AI-based analysis

- [`supply_chain_agentic/`](benchmark-results/ai-analysis/supply_chain_agentic/)
  -- Multi-agent pipeline (315 CVEs, depth N0-N5, n=15 runs)
- [`m365_copilot/`](benchmark-results/ai-analysis/m365_copilot/) -- Microsoft 365
  Copilot with GPT-5 Think Deeper (194 CVEs)
- [`antigravity/`](benchmark-results/ai-analysis/antigravity/) -- Google Antigravity
  with Gemini 3.1 Pro (177 CVEs mean n=5)
- [`copilot/`](benchmark-results/ai-analysis/copilot/) -- GitHub Copilot Haiku 4.5
  (157 CVEs, validated with appmod-validate-cves-for-java)
- [`claude/`](benchmark-results/ai-analysis/claude/) -- Claude Opus 4 LLM analysis
  (128 CVEs, single run with controlled prompt)

### Dedicated SCA analysis

- [`sca-analysis/trivy/`](benchmark-results/sca-analysis/trivy/) -- Trivy (124 CVEs)
- [`sca-analysis/snyk/`](benchmark-results/sca-analysis/snyk/) -- Snyk (105 CVEs)
- [`sca-analysis/osv-scanner/`](benchmark-results/sca-analysis/osv-scanner/)
  -- OSV-Scanner Google (104 CVEs)
- [`sca-analysis/grype/`](benchmark-results/sca-analysis/grype/) -- Grype (43 CVEs)

### SAST analysis

- [`sast-analysis/`](benchmark-results/sast-analysis/)
  -- SonarQube 26.3 SAST (0 CVEs in dependencies, 20 code smells)

Each result set includes per-project CSV files and README with detection details.

> Results should be interpreted considering the analysis date, as CVE databases
> are continuously updated.

---

## Project Structure

Each project follows a consistent structure:

```
benchmark-projects/
└── 0X_project_name/
    ├── pom.xml / build.gradle    ← Build manifest with vulnerable dependencies
    ├── expected.json             ← Ground truth: expected CVEs and dependency levels
    ├── README.md                 ← English documentation (scenario, tree, expected CVEs)
    ├── README_ES.md              ← Spanish documentation
    └── src/main/java/...         ← Demo Java code that uses the declared libraries
```

### Multi-module projects (04, 05, 06)

Projects 04, 05, and 06 use multi-module builds to precisely control dependency
depth. Each internal module represents a clean layer in the dependency chain,
with vulnerable third-party libraries only at the target depth level.

```
0X_project/
├── pom.xml (parent)
├── lib-core/       (internal module -- no CVEs)
├── lib-wrapper/    (internal module -- no CVEs)
└── app/            (analysis target -- only sees transitives)
```

---

## Key Design Decisions

- **SAST-clean code**: All Java code is designed to pass conventional SAST
  analysis. Vulnerabilities are in library versions, not in code patterns.
  Confirmed with SonarQube 26.3 detecting 0 dependency vulnerabilities.
- **Isolated scenarios**: Each project targets exactly one depth level,
  avoiding overlap that would confuse benchmark measurements.
- **Build system diversity**: 6 Maven projects (one multi-module), 1 Gradle
  multi-module project, to test tool compatibility.
- **No compilation required**: Projects are build manifests with demo code --
  they are not designed to compile or run.
- **Ground truth independence**: `expected.json` files are generated from
  direct CVE database queries (NVD, OSV), not from any SCA tool output.
- **Reproducible benchmark**: All runs are documented with measurement dates,
  number of runs, and coefficient of variation.

---

## CVE Temporal Notice

All projects were generated on **2026-04-03**. Benchmark runs were performed
between **2026-04-09 and 2026-04-11**. The vulnerability landscape changes
continuously:

- New CVEs may be published for libraries that were clean at generation time
- Existing CVEs may be disputed, rejected, or reclassified
- CVSS scores may be updated
- Libraries may release patches that change the "latest safe version"

When running benchmarks, always record the analysis date and compare against
the `expected.json` ground truth, noting any discrepancies that may be due to
temporal differences.

---

## Intended Use

These projects are designed to evaluate:

- **SCA (Software Composition Analysis)**: Snyk, OWASP Dependency-Check,
  Trivy, Grype, OSV-Scanner
- **SAST (Static Application Security Testing)**: SonarQube (control baseline
  -- should detect 0 in dependencies)
- **LLM-as-scanner**: GitHub Copilot, M365 Copilot, Claude, GPT-4o
- **Agentic IDE assistants**: Google Antigravity, Cursor
- **Agentic pipelines**: Supply Chain Agentic and other multi-agent systems
- **SBOM Generation**: CycloneDX, SPDX completeness at different depth levels
- **Vulnerability Management**: Prioritization by severity, reachability
  analysis, transitive risk assessment
- **Maintainer trust analysis**: Detection of abandoned or low-reputation
  libraries (P07 scenario)

---

## Academic Publication

This benchmark is the experimental basis for the following work:

> **Cooper, J., Maldonado, S.** (2026). "Agentic AI for Software
> Supply Chain Vulnerability Analysis: A Multi-Agent DevSecOps Approach."
> *IEEE Latin American Conference on Computational Intelligence (LA-CCI 2026)*.
> Universidad Tecnologica de Honduras.

**Main contributions**:
1. Multi-agent architecture with 5 autonomous agents and bidirectional bus
   with persistent memory
2. Deep transitive analysis (N0-N5) with multi-module support
3. Maintainer trust analysis with 3-level fallback
4. Iterative reflection cycle based on tiered LLMs (gpt-4.1 family)
5. **First controlled benchmark** jointly comparing agentic pipelines,
   agentic IDE assistants, LLM-as-scanner, and dedicated SCA/SAST in a
   single reproducible evaluation

---

## License

Apache-2.0 (see [`LICENSE`](LICENSE) file)

## Contact

- Joseph Cooper -- kenny.cooper@uth.hn
- Selvin Maldonado -- selvin.maldonado@uth.hn

**Master in Cybersecurity**
Universidad Tecnologica de Honduras
