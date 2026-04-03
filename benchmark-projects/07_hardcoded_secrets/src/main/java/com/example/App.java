package com.example;

import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;
import java.sql.DriverManager;
import java.util.Map;

/**
 * VULNERABLE: Multiples secrets hardcodeados + dependencias con CVEs
 * 1. API keys en codigo fuente
 * 2. Credenciales de base de datos en strings
 * 3. Tokens de servicio embebidos
 * 4. SnakeYAML 1.30 con RCE (CVE-2022-1471)
 * 5. Gson 2.8.6 con DoS (CVE-2022-25647)
 */
public class App {
    // VULNERABLE: API keys hardcodeadas
    private static final String AWS_ACCESS_KEY = "AKIAIOSFODNN7EXAMPLE";
    private static final String AWS_SECRET_KEY = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
    private static final String GITHUB_TOKEN = "ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    private static final String SLACK_WEBHOOK = "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX";

    // VULNERABLE: Credenciales de base de datos
    private static final String DB_URL = "jdbc:mysql://prod-db.internal:3306/users";
    private static final String DB_USER = "admin";
    private static final String DB_PASS = "P@ssw0rd!2024";

    // VULNERABLE: JWT secret key
    private static final String JWT_SECRET = "my-super-secret-jwt-key-do-not-share";

    public static void main(String[] args) throws Exception {
        // Conexion con credenciales hardcodeadas
        var conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

        // VULNERABLE: SnakeYAML parsea input no confiable (CVE-2022-1471)
        Yaml yaml = new Yaml();
        String untrustedYaml = args.length > 0 ? args[0] : "name: test";
        Map<String, Object> config = yaml.load(untrustedYaml);

        // Serializa config (podria exponer secrets en logs)
        Gson gson = new Gson();
        System.out.println(gson.toJson(config));
    }
}
