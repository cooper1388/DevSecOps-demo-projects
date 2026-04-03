package com.example;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * VULNERABLE: Crypto debil + dependencias con CVEs
 * 1. bcprov-jdk15on 1.60 — rama descontinuada, multiples CVEs crypto
 * 2. Usa DES (56 bits) — rompible en minutos
 * 3. Usa ECB mode — no provee confidencialidad para bloques repetidos
 * 4. xmlsec 2.3.0 — XXE en XML Signature (CVE-2023-44483)
 * 5. Logback 1.2.9 — JNDI injection (CVE-2021-42550)
 * 6. Spring LDAP 2.3.4 — LDAP injection
 */
public class App {
    // VULNERABLE: clave DES hardcodeada de 8 bytes
    private static final byte[] DES_KEY = "12345678".getBytes();

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        // VULNERABLE: DES con ECB mode — criptografia debil
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(DES_KEY, "DES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);

        String sensitive = "SSN:123-45-6789";
        byte[] encrypted = cipher.doFinal(sensitive.getBytes());
        System.out.println("Encrypted (insecurely): " + new String(encrypted));
    }
}
