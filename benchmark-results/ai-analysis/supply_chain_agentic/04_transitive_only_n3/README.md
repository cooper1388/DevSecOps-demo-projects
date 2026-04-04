# CVE Analysis Report -- 04_transitive_only_n3

**Scan Date:** 2026-04-03
**Tool:** Supply Chain Agentic
**Total CVEs Found:** 11 (8 active, 3 informative)
**Severities:** 3 CRITICAL, 8 HIGH, 0 MEDIUM, 0 LOW

---

## Project Description

Maven multi-module, vulnerabilidades en N3 (commons-collections, commons-beanutils)

---

## Dependency Summary

| Artifact | Version | Level | CVEs |
|---|---|---|:---:|
| `log4j` | 1.2.17 | N1 | 6 |
| `commons-beanutils` | 1.9.3 | N2+ | 3 |
| `commons-collections` | 3.2.1 | N1 | 2 |

---

## CVE List

| CVE ID | Severity | Artifact | Description |
|---|---|---|---|
| CVE-2015-7501 | CRITICAL | `commons-collections:3.2.1` | Deserialization of Untrusted Data in Apache commons collections |
| CVE-2019-17571 | CRITICAL | `log4j:1.2.17` | Deserialization of Untrusted Data in Log4j |
| CVE-2022-23305 | CRITICAL | `log4j:1.2.17` | SQL Injection in Log4j 1.2.x |
| CVE-2015-6420 | HIGH | `commons-collections:3.2.1` | Insecure Deserialization in Apache Commons Collection |
| CVE-2022-23307 | HIGH | `log4j:1.2.17` | Deserialization of Untrusted Data in Apache Log4j |
| CVE-2021-4104 | HIGH | `log4j:1.2.17` | JMSAppender in Log4j 1.2 is vulnerable to deserialization of untrusted data |
| CVE-2023-26464 | HIGH | `log4j:1.2.17` | Apache Log4j 1.x (EOL) allows Denial of Service (DoS) |
| CVE-2022-23302 | HIGH | `log4j:1.2.17` | Deserialization of Untrusted Data in Log4j 1.x |
| CVE-2019-10086 | HIGH | `commons-beanutils:1.9.3` | Insecure Deserialization in Apache Commons Beanutils |
| CVE-2014-0114 | HIGH | `commons-beanutils:1.9.3` | Arbitrary code execution in Apache Commons BeanUtils |
| CVE-2025-48734 | HIGH | `commons-beanutils:1.9.3` | Apache Commons Improper Access Control vulnerability |
