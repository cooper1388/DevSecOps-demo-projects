# DevSecOps Benchmark Projects

A set of synthetic Java/Kotlin projects with intentional dependency vulnerabilities, designed to benchmark **Software Composition Analysis (SCA)** tools across differentiated supply chain risk scenarios.

Each project in `benchmark-projects/` isolates a specific vulnerability depth level in the dependency tree, enabling precise evaluation of how deep and how accurately an SCA tool can detect known CVEs and supply chain risks.

> **Important:** CVE databases evolve over time. New vulnerabilities may be published for libraries that were considered clean at the time of project creation. Always cross-reference results with the generation date listed below.

## Benchmark Scenarios

The projects cover **7 differentiated test cases**, each targeting a specific depth level or risk type:

| # | Project | Build | Scenario | Generation Date |
|---|---------|-------|----------|----------------|
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
├── library-a              ← N1 (direct dependency)
│   ├── library-b          ← N2 (first-level transitive)
│   │   ├── library-c      ← N3 (second-level transitive)
│   │   │   └── library-d  ← N4 (deep transitive)
```

- **N1**: Declared directly in the build file
- **N2**: Immediate transitive dependency (dependency of a direct dependency)
- **N3**: Two levels deep in the transitive tree
- **N4**: Three or more levels deep — often beyond default SCA analysis depth

## Benchmark Results

The `benchmark-results/` folder contains results from different SCA tool analyses performed on these projects. These results serve as a baseline for comparing tool effectiveness across scenarios.

Each result set includes:
- The tool name and version used
- Date of analysis
- Detected vs. expected CVEs per project
- Detection rate by dependency depth level (N1 through N4)

> Results should be interpreted considering the analysis date, as CVE databases are continuously updated.

## Project Structure

Each project follows a consistent structure:

```
benchmark-projects/
├── 0X_project_name/
│   ├── pom.xml / build.gradle     Build manifest with vulnerable dependencies
│   ├── expected.json              Ground truth: expected CVEs and dependency levels
│   ├── README.md                  English documentation (scenario, tree, expected CVEs)
│   ├── README_ES.md               Spanish documentation
│   └── src/main/java/...          Demo Java code that uses the declared libraries
```

### Multi-module projects (04, 05, 06)

Projects 04, 05, and 06 use multi-module builds to precisely control dependency depth. Each internal module represents a clean layer in the dependency chain, with vulnerable third-party libraries only at the target depth level.

```
0X_project/
├── pom.xml (parent)
├── lib-core/       (internal module — no CVEs)
├── lib-wrapper/    (internal module — no CVEs)
└── app/            (analysis target — only sees transitives)
```

## Key Design Decisions

- **SAST-clean code**: All Java code is designed to pass conventional SAST analysis. Vulnerabilities are in library versions, not in code patterns.
- **Isolated scenarios**: Each project targets exactly one depth level, avoiding overlap that would confuse benchmark measurements.
- **Build system diversity**: 5 Maven projects, 1 Gradle project, and multi-module variants to test tool compatibility.
- **No compilation required**: Projects are build manifests with demo code — they are not designed to compile or run.
- **Ground truth independence**: `expected.json` files are generated from direct CVE database queries (NVD, OSV), not from any SCA tool output.

## CVE Temporal Notice

All projects were generated on **2026-04-03**. The vulnerability landscape changes continuously:

- New CVEs may be published for libraries that were clean at generation time
- Existing CVEs may be disputed, rejected, or reclassified
- CVSS scores may be updated
- Libraries may release patches that change the "latest safe version"

When running benchmarks, always record the analysis date and compare against the `expected.json` ground truth, noting any discrepancies that may be due to temporal differences.

## Intended Use

These projects are designed to evaluate:

- **SCA (Software Composition Analysis)**: Snyk, OWASP Dependency-Check, Trivy, Grype, etc.
- **Supply Chain Security**: Agentic pipelines, trust analysis, maintenance scoring
- **SBOM Generation**: CycloneDX, SPDX completeness at different depth levels
- **Vulnerability Management**: Prioritization by severity, reachability analysis, transitive risk assessment
