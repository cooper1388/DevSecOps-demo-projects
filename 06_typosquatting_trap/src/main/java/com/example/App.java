package com.example;

import org.apache.commons.text.StringSubstitutor;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * VULNERABLE: Multiples vectores de ataque
 * 1. Text4Shell (CVE-2022-42889): StringSubstitutor evalua expresiones peligrosas
 * 2. bcprov-jdk15on descontinuado: rama de crypto obsoleta con vulns conocidas
 * 3. Usa MD5 (crypto debil) en vez de SHA-256
 * 4. Guava 29 con temp dir info disclosure
 */
public class App {
    public static void main(String[] args) throws Exception {
        // VULNERABLE: Text4Shell — StringSubstitutor ejecuta lookups peligrosos
        Map<String, String> values = new HashMap<>();
        values.put("user", args.length > 0 ? args[0] : "admin");
        StringSubstitutor sub = StringSubstitutor.createInterpolator();
        // Un atacante puede inyectar: ${script:javascript:java.lang.Runtime.exec('calc')}
        String result = sub.replace("Hello ${user}");

        // VULNERABLE: Crypto debil — MD5 no es resistente a colisiones
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest("password123".getBytes());

        System.out.println("Result: " + result);
    }
}
