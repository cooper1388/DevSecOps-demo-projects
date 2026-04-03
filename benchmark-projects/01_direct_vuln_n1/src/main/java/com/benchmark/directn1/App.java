package com.benchmark.directn1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Aplicacion demo que usa Log4j y Commons Text.
 * Codigo disenado para pasar analisis SAST convencionales:
 * no hay inyeccion directa de input del usuario en patrones peligrosos.
 * La vulnerabilidad reside en las versiones de las librerias, no en el codigo.
 */
public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public String buildWelcomeMessage(String userName, String role) {
        Map<String, String> values = new HashMap<>();
        values.put("user", userName);
        values.put("role", role);

        StringSubstitutor substitutor = new StringSubstitutor(values);
        String template = "Bienvenido ${user}, tu rol es: ${role}";
        String message = substitutor.replace(template);

        logger.info("Mensaje generado para usuario: {}", userName);
        return message;
    }

    public void processEvent(String eventType, Map<String, String> metadata) {
        logger.debug("Procesando evento tipo: {}", eventType);

        StringSubstitutor sub = new StringSubstitutor(metadata);
        String summary = sub.replace("Evento [${type}] registrado a las ${timestamp}");

        logger.info("Resumen del evento: {}", summary);
    }

    public static void main(String[] args) {
        App app = new App();
        app.buildWelcomeMessage("admin", "ADMIN");

        Map<String, String> meta = new HashMap<>();
        meta.put("type", "LOGIN");
        meta.put("timestamp", "2024-01-15T10:30:00Z");
        app.processEvent("LOGIN", meta);
    }
}
