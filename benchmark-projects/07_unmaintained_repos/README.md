# Case 7: Risk from Unmaintained Repositories (No CVEs)

## Scenario

This project exclusively uses libraries that **have no known CVEs** but represent a **significant supply chain risk** due to being abandoned, archived, or minimally maintained. This case evaluates tool capabilities beyond simple CVE scanning.

## Benchmark Objective

Validate whether the SCA tool can detect risks beyond CVEs:
1. Libraries without recent releases (years without updates)
2. Archived or retired repositories
3. Projects with a single maintainer or no active maintainers
4. Migrated/abandoned namespaces (e.g., net.sf.opencsv → com.opencsv)
5. Libraries that could not receive security patches even if a vulnerability were discovered

## Dependencies and Maintenance Status

| Dependency | Version | Last Release | Status | GitHub Stars | Active Maintainers | CVEs |
|------------|---------|-------------|--------|-------------|-------------------|------|
| `oro:oro` | 2.0.8 | 2003 | Apache Attic (retired) | N/A | 0 | 0 |
| `findbugs:jsr305` | 3.0.2 | 2017 | Abandoned by Google | ~100 | 0 | 0 |
| `jcip-annotations` | 1.0 | 2007 | Single release, no repo | N/A | 0 | 0 |
| `paranamer` | 2.8 | 2017 | Minimal maintenance | ~50 | 1 inactive | 0 |
| `opencsv` (net.sf) | 2.3 | 2011 | Migrated to com.opencsv | N/A | 0 | 0 |

## Identified Risks

### 1. Apache ORO (`oro:oro:2.0.8`)
- Project officially retired to Apache Attic
- No updates for 20+ years
- If a security bug is found in the regex engine, there is no one to fix it

### 2. JSR-305 (`com.google.code.findbugs:jsr305:3.0.2`)
- Google abandoned the FindBugs project
- JSR-305 was never officially standardized
- Widely used as a transitive dependency but unmaintained

### 3. JCIP Annotations (`net.jcip:jcip-annotations:1.0`)
- Single release in 2007, never updated
- No active public source code repository
- Impossible to report or fix security issues

### 4. Paranamer (`com.thoughtworks:paranamer:2.8`)
- Single maintainer who became inactive
- Last significant activity in 2017
- Accesses class bytecode — potential attack surface without oversight

### 5. OpenCSV Legacy (`net.sf.opencsv:opencsv:2.3`)
- `net.sf` namespace abandoned; project migrated to `com.opencsv`
- Anyone controlling the old namespace could publish a malicious version
- Classic typosquatting/namespace hijacking risk

## What Tools Should Detect

Advanced SCA tools (like Snyk, Socket.dev, Deps.dev) go beyond CVEs and evaluate:
- **Maintenance score**: commit and release frequency
- **Contributor count**: number of active maintainers
- **Project health**: open issues, unmerged PRs, archived status
- **Namespace risk**: artifact migrations, abandoned namespaces
- **Supply chain risk**: potential for compromise due to lack of governance

## Demo Code

`App.java` uses each library conventionally:
- **ORO**: Perl5 regex pattern compilation and matching
- **JSR-305**: `@Nonnull`, `@Nullable` annotations for null-safety
- **JCIP**: `@ThreadSafe` annotation for documenting thread-safety
- **Paranamer**: Parameter name extraction from bytecode
- **OpenCSV**: Basic CSV file parsing
