package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * VULNERABLE (indirectamente): Las dependencias directas parecen seguras.
 * Pero en sus transitivas profundas hay:
 * - snakeyaml 1.29 (CVE-2022-1471 — RCE via constructor injection)
 * - jackson-databind antiguo (deserializacion insegura)
 * - tomcat-embed vulnerable
 * - woodstox-core con XXE
 * Ningun import directo revela la vulnerabilidad.
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Server started — no direct vulnerable imports visible");
    }
}
