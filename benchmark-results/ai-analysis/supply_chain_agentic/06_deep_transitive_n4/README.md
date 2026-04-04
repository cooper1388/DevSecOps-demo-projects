# CVE Analysis Report -- 06_deep_transitive_n4

**Scan Date:** 2026-04-03
**Tool:** Supply Chain Agentic
**Total CVEs Found:** 5 (2 active, 3 informative)
**Severities:** 1 CRITICAL, 3 HIGH, 1 MEDIUM, 0 LOW

---

## Project Description

Maven multi-module 4 capas, vulnerabilidades en N4

---

## Dependency Summary

| Artifact | Version | Level | CVEs |
|---|---|---|:---:|
| `commons-collections` | 3.2.1 | N1 | 2 |
| `commons-io` | 2.6 | N2+ | 2 |
| `junit` | 4.12 | N2+ | 1 |

---

## CVE List

| CVE ID | Severity | Artifact | Description |
|---|---|---|---|
| CVE-2015-7501 | CRITICAL | `commons-collections:3.2.1` | Deserialization of Untrusted Data in Apache commons collections |
| CVE-2015-6420 | HIGH | `commons-collections:3.2.1` | Insecure Deserialization in Apache Commons Collection |
| CVE-2024-47554 | HIGH | `commons-io:2.6` | Apache Commons IO: Possible denial of service attack on untrusted input to XmlSt |
| CVE-2021-29425 | HIGH | `commons-io:2.6` | Path Traversal and Improper Input Validation in Apache Commons IO |
| CVE-2020-15250 | MEDIUM | `junit:4.12` | TemporaryFolder on unix-like systems does not limit access to created files |
