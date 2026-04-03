package com.benchmark.app;

import com.benchmark.libservice.ConfigLoader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Aplicacion principal que consume ConfigLoader.
 * No tiene visibilidad directa de snakeyaml (N2) ni jackson-databind (N3).
 * Codigo limpio para SAST: solo usa APIs de alto nivel.
 */
public class App {

    private final ConfigLoader configLoader;

    public App() {
        this.configLoader = new ConfigLoader();
    }

    public Map<String, Object> loadConfiguration(String yamlContent) {
        InputStream stream = new ByteArrayInputStream(
            yamlContent.getBytes(StandardCharsets.UTF_8)
        );
        return configLoader.loadYaml(stream);
    }

    public String configToJson(Map<String, Object> config) {
        return configLoader.convertToJson(config);
    }

    public static void main(String[] args) {
        App app = new App();

        String yaml = "server:\n  port: 8080\n  host: localhost\ndatabase:\n  url: jdbc:h2:mem:test";
        Map<String, Object> config = app.loadConfiguration(yaml);
        System.out.println("Config cargada: " + config);

        String json = app.configToJson(config);
        System.out.println("Config en JSON: " + json);
    }
}
