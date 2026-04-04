#!/usr/bin/env python3
"""
Benchmark runner — executes the pipeline on all 7 benchmark projects
and generates CSV + README results in benchmark-results/ai-analysis/supply_chain_agentic/

Usage:
    python benchmark/run_benchmark.py
    python benchmark/run_benchmark.py --project 01_direct_vuln_n1   # single project
    python benchmark/run_benchmark.py --quick                        # skip trust/github (faster)
"""
import argparse
import csv
import json
import subprocess
import sys
import time
from collections import defaultdict
from datetime import datetime, timezone
from pathlib import Path

ROOT = Path(__file__).parent.parent
RESULTS_DIR = ROOT / "benchmark" / "benchmark-results" / "ai-analysis" / "supply_chain_agentic"
EXPECTED_DIR = ROOT / "benchmark" / "benchmark-projects"

PROJECTS = {
    "01_direct_vuln_n1": "benchmark/benchmark-projects/01_direct_vuln_n1/pom.xml",
    "02_vuln_n1_and_n2": "benchmark/benchmark-projects/02_vuln_n1_and_n2/pom.xml",
    "03_transitive_only_n2": "benchmark/benchmark-projects/03_transitive_only_n2/pom.xml",
    "04_transitive_only_n3": "benchmark/benchmark-projects/04_transitive_only_n3/pom.xml",
    "05_combined_n2_and_n3": "benchmark/benchmark-projects/05_combined_n2_and_n3/lib-data/build.gradle",
    "06_deep_transitive_n4": "benchmark/benchmark-projects/06_deep_transitive_n4/app/pom.xml",
    "07_unmaintained_repos": "benchmark/benchmark-projects/07_unmaintained_repos/pom.xml",
}

DESCRIPTIONS = {
    "01_direct_vuln_n1": "Vulnerabilidades directas (N1)",
    "02_vuln_n1_and_n2": "Vulnerabilidades N1 + N2 transitivas",
    "03_transitive_only_n2": "Solo transitivas de 1er nivel (N2)",
    "04_transitive_only_n3": "Solo transitivas de 2do nivel (N3)",
    "05_combined_n2_and_n3": "Combinado N2 + N3 (Gradle)",
    "06_deep_transitive_n4": "Transitivas profundas (N4)",
    "07_unmaintained_repos": "Repositorios abandonados",
}

CSV_FIELDS = [
    "scan_date", "project", "group_id", "artifact_id", "version",
    "dependency_level", "cve_id", "severity", "cve_type",
    "short_description", "fix_version", "advisory_url",
]


def run_pipeline(manifest: str) -> dict:
    """Run the pipeline on a manifest and return the scan report."""
    result = subprocess.run(
        [sys.executable, str(ROOT / "run_pipeline.py"),
         "--manifest-path", manifest, "--file-path", manifest],
        capture_output=True, text=True, encoding="utf-8", errors="replace",
        cwd=str(ROOT),
    )
    report_path = ROOT / "scan_report.json"
    if not report_path.exists():
        print(f"  ERROR: scan_report.json not generated", file=sys.stderr)
        return {}
    with open(report_path, "r", encoding="utf-8") as f:
        return json.load(f)


def extract_cves(scan_data: dict, project: str, scan_date: str) -> list[dict]:
    """Extract all CVEs from scan data into CSV rows."""
    vulns = scan_data.get("vulnerabilities", [])
    vi = scan_data.get("vulns_informative", [])
    rows = []

    for v in vulns + vi:
        purl = v.get("purl", "")
        parts = purl.replace("pkg:maven/", "").split("@")
        coord = parts[0] if parts else ""
        version = parts[1] if len(parts) > 1 else ""
        ga = coord.split("/")
        gid = ga[0] if ga else ""
        aid = ga[1] if len(ga) > 1 else ""
        is_active = v in vulns

        for c in v.get("cves", []):
            cve_id = c.get("cve_id", "")
            tags = c.get("tags", [])
            rows.append({
                "scan_date": scan_date,
                "project": project,
                "group_id": gid,
                "artifact_id": aid,
                "version": version,
                "dependency_level": "N1" if is_active else "N2+",
                "cve_id": cve_id,
                "severity": c.get("severity", "UNKNOWN"),
                "cve_type": ", ".join(tags[:3]) if tags else "",
                "short_description": (c.get("summary", "") or "")[:150].replace('"', "'"),
                "fix_version": c.get("fixed_version", ""),
                "advisory_url": f"https://nvd.nist.gov/vuln/detail/{cve_id}" if cve_id.startswith("CVE-") else "",
            })
    return rows


def check_ground_truth(project: str, detected_cves: set[str]) -> dict:
    """Compare detected CVEs against expected.json ground truth."""
    expected_path = EXPECTED_DIR / project / "expected.json"
    if not expected_path.exists():
        return {"expected": [], "found": 0, "missed": 0, "recall": "N/A"}

    with open(expected_path, "r", encoding="utf-8") as f:
        expected = json.load(f)

    expected_cves = expected.get("expected_cves", [])
    if not expected_cves:
        return {"expected": [], "found": 0, "missed": 0, "recall": "100%"}

    found = [cve for cve in expected_cves if cve in detected_cves]
    missed = [cve for cve in expected_cves if cve not in detected_cves]
    recall = f"{len(found)}/{len(expected_cves)}" if expected_cves else "N/A"
    return {"expected": expected_cves, "found": len(found), "missed": len(missed),
            "missed_list": missed, "recall": recall}


def write_project_csv(proj_dir: Path, rows: list[dict], scan_date: str):
    """Write per-project CSV."""
    proj_dir.mkdir(parents=True, exist_ok=True)
    csv_path = proj_dir / f"{scan_date}.csv"
    with open(csv_path, "w", newline="", encoding="utf-8") as f:
        w = csv.DictWriter(f, fieldnames=CSV_FIELDS)
        w.writeheader()
        w.writerows(rows)


def write_project_readme(proj_dir: Path, project: str, rows: list[dict],
                         ground_truth: dict, scan_date: str):
    """Write per-project README."""
    total = len(rows)
    sevs = defaultdict(int)
    deps = defaultdict(lambda: {"ver": "", "level": "", "count": 0})
    for r in rows:
        sevs[r["severity"]] += 1
        k = r["artifact_id"]
        deps[k]["ver"] = r["version"]
        deps[k]["level"] = r["dependency_level"]
        deps[k]["count"] += 1

    md = f"""# CVE Analysis Report -- {project}

**Scan Date:** {scan_date}
**Tool:** Supply Chain Agentic
**Total CVEs Found:** {total}
**Severities:** {sevs.get('CRITICAL',0)} CRITICAL, {sevs.get('HIGH',0)} HIGH, {sevs.get('MEDIUM',0)} MEDIUM, {sevs.get('LOW',0)} LOW

---

## Project Description

{DESCRIPTIONS.get(project, '')}

---

## Ground Truth

| Expected | Found | Missed | Recall |
|:---:|:---:|:---:|:---:|
| {len(ground_truth['expected'])} | {ground_truth['found']} | {ground_truth['missed']} | **{ground_truth['recall']}** |

"""
    if ground_truth.get("missed_list"):
        md += "**Missed CVEs:** " + ", ".join(ground_truth["missed_list"]) + "\n\n"

    md += """---

## Dependency Summary

| Artifact | Version | Level | CVEs |
|---|---|---|:---:|
"""
    for aid, info in sorted(deps.items(), key=lambda x: -x[1]["count"]):
        md += f"| `{aid}` | {info['ver']} | {info['level']} | {info['count']} |\n"

    md += "\n---\n\n## CVE List\n\n| CVE ID | Severity | Artifact | Description |\n|---|---|---|---|\n"
    sev_order = {"CRITICAL": 0, "HIGH": 1, "MEDIUM": 2, "LOW": 3}
    for r in sorted(rows, key=lambda x: sev_order.get(x["severity"], 4)):
        md += f"| {r['cve_id']} | {r['severity']} | `{r['artifact_id']}:{r['version']}` | {r['short_description'][:80]} |\n"

    with open(proj_dir / "README.md", "w", encoding="utf-8") as f:
        f.write(md)


def write_summary_readme(all_rows: list[dict], project_results: dict, scan_date: str):
    """Write the main summary README.md."""
    proj_stats = defaultdict(lambda: {"total": 0, "CRITICAL": 0, "HIGH": 0, "MEDIUM": 0, "LOW": 0,
                                      "deps": defaultdict(lambda: {"ver": "", "level": "", "count": 0})})
    sevs = {"CRITICAL": 0, "HIGH": 0, "MEDIUM": 0, "LOW": 0}

    for r in all_rows:
        p, s = r["project"], r["severity"]
        proj_stats[p]["total"] += 1
        if s in sevs:
            sevs[s] += 1
            proj_stats[p][s] += 1
        a = r["artifact_id"]
        proj_stats[p]["deps"][a]["ver"] = r["version"]
        proj_stats[p]["deps"][a]["level"] = r["dependency_level"]
        proj_stats[p]["deps"][a]["count"] += 1

    total = len(all_rows)

    # Read comparison data from copilot and claude
    comparison = {}
    for tool in ["supply_chain_agentic", "claude", "copilot"]:
        comparison[tool] = defaultdict(int)
        csv_path = RESULTS_DIR.parent / tool / f"{tool}_all_issues.csv"
        if csv_path.exists():
            with open(csv_path, "r", encoding="utf-8") as f:
                for r2 in csv.DictReader(f):
                    comparison[tool][r2["project"]] += 1
    tool_totals = {t: sum(v.values()) for t, v in comparison.items()}

    proj_order = sorted(proj_stats.keys())

    md = f"""# CVE Analysis -- Benchmark Projects Summary

**Scan Date:** {scan_date}
**Tool:** Supply Chain Agentic
**Analyst:** Automated pipeline (5 agents + 3 skills + bus bidireccional)
**Method:** Multi-source API scanning: OSV.dev + Sonatype OSS Index + deps.dev + NVD + GitHub Advisory. Depth N0-N5. Multi-module Maven/Gradle. Reachability filter.
**Scope:** 7 benchmark projects under `benchmark-projects/`

---

## Results Overview

| Project | Description | CVEs Total | CRITICAL | HIGH | MEDIUM | LOW |
|---|---|:---:|:---:|:---:|:---:|:---:|
"""
    for p in proj_order:
        s = proj_stats[p]
        md += f"| [{p}](./{p}/README.md) | {DESCRIPTIONS.get(p, '')} | **{s['total']}** | {s['CRITICAL']} | {s['HIGH']} | {s['MEDIUM']} | {s['LOW']} |\n"
    md += f"| **TOTAL** | | **{total}** | **{sevs['CRITICAL']}** | **{sevs['HIGH']}** | **{sevs['MEDIUM']}** | **{sevs['LOW']}** |\n"

    md += """
---

## Ground Truth Recall

| Project | Expected | Found | Recall |
|---|:---:|:---:|:---:|
"""
    for p in proj_order:
        gt = project_results.get(p, {}).get("ground_truth", {})
        md += f"| {p} | {len(gt.get('expected', []))} | {gt.get('found', 0)} | **{gt.get('recall', 'N/A')}** |\n"

    md += """
---

## Vulnerable Dependencies per Project

"""
    for p in proj_order:
        s = proj_stats[p]
        md += f"### {p}\n| Dependency | Version | Level | CVEs |\n|---|---|---|:---:|\n"
        for aid, info in sorted(s["deps"].items(), key=lambda x: -x[1]["count"]):
            md += f"| `{aid}` | {info['ver']} | {info['level']} | {info['count']} |\n"
        md += "\n"

    md += """---

## Comparison

| Proyecto | Supply Chain Agentic | GitHub Copilot | Claude |
|:---|:---:|:---:|:---:|
"""
    for p in proj_order:
        md += f"| {p} | **{comparison['supply_chain_agentic'][p]}** | {comparison['copilot'][p]} | {comparison['claude'][p]} |\n"
    md += f"| | | | |\n| **TOTAL** | **{tool_totals.get('supply_chain_agentic', 0)}** | **{tool_totals.get('copilot', 0)}** | **{tool_totals.get('claude', 0)}** |\n"

    md += f"""
---

## Output Files

Cada carpeta de proyecto contiene:
- `{scan_date}.csv` -- listado estructurado de CVEs
- `README.md` -- descripcion detallada

| Proyecto | CSV | README |
|---|---|---|
"""
    for p in proj_order:
        md += f"| {p} | [{scan_date}.csv](./{p}/{scan_date}.csv) | [README.md](./{p}/README.md) |\n"

    with open(RESULTS_DIR / "README.md", "w", encoding="utf-8") as f:
        f.write(md)


def main():
    parser = argparse.ArgumentParser(description="Run benchmark on all 7 projects")
    parser.add_argument("--project", help="Run only this project (e.g. 01_direct_vuln_n1)")
    parser.add_argument("--quick", action="store_true", help="Skip trust/github for faster execution")
    args = parser.parse_args()

    scan_date = datetime.now(timezone.utc).strftime("%Y-%m-%d")
    projects = {args.project: PROJECTS[args.project]} if args.project else PROJECTS

    print(f"{'='*60}")
    print(f"  Supply Chain Agentic Benchmark Runner")
    print(f"  Date: {scan_date}")
    print(f"  Projects: {len(projects)}")
    print(f"{'='*60}\n")

    all_rows = []
    project_results = {}
    total_start = time.time()

    # Clear DB
    for db in (ROOT / ".cache").glob("agent_bus.db*"):
        db.unlink(missing_ok=True)

    for proj, manifest in projects.items():
        print(f"[{proj}] Scanning...", end=" ", flush=True)
        start = time.time()

        scan_data = run_pipeline(manifest)
        elapsed = time.time() - start

        if not scan_data:
            print(f"FAILED ({elapsed:.1f}s)")
            continue

        rows = extract_cves(scan_data, proj, scan_date)
        all_cves = {r["cve_id"] for r in rows}
        gt = check_ground_truth(proj, all_cves)

        # Count severities
        crit = sum(1 for r in rows if r["severity"] == "CRITICAL")
        high = sum(1 for r in rows if r["severity"] == "HIGH")

        print(f"{len(rows)} CVEs ({crit}C/{high}H) | recall {gt['recall']} | {elapsed:.1f}s")

        # Write per-project files
        proj_dir = RESULTS_DIR / proj
        write_project_csv(proj_dir, rows, scan_date)
        write_project_readme(proj_dir, proj, rows, gt, scan_date)

        all_rows.extend(rows)
        project_results[proj] = {"rows": rows, "ground_truth": gt, "elapsed": elapsed}

        # Clear DB between runs
        for db in (ROOT / ".cache").glob("agent_bus.db*"):
            db.unlink(missing_ok=True)

    # Write all_issues CSV
    all_csv = RESULTS_DIR / "supply_chain_agentic_all_issues.csv"
    with open(all_csv, "w", newline="", encoding="utf-8") as f:
        w = csv.DictWriter(f, fieldnames=CSV_FIELDS)
        w.writeheader()
        w.writerows(all_rows)

    # Write summary README
    write_summary_readme(all_rows, project_results, scan_date)

    total_elapsed = time.time() - total_start
    print(f"\n{'='*60}")
    print(f"  BENCHMARK COMPLETE")
    print(f"  Total CVEs: {len(all_rows)}")
    print(f"  Time: {total_elapsed:.1f}s ({total_elapsed/60:.1f}m)")
    print(f"  Output: {RESULTS_DIR}")
    print(f"{'='*60}")


if __name__ == "__main__":
    main()
