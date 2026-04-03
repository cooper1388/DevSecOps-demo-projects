package com.benchmark.libservice;

import com.benchmark.libdata.JsonMapper;
import org.yaml.snakeyaml.Yaml;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.Map;

/**
 * Servicio de carga de configuracion que soporta YAML y JSON.
 * Usa SnakeYAML para parseo de archivos de configuracion y
 * delega a lib-data (JsonMapper) para operaciones JSON.
 */
public class ConfigLoader {

    private final Yaml yaml;
    private final JsonMapper jsonMapper;
    private final Gson gson;

    public ConfigLoader() {
        this.yaml = new Yaml();
        this.jsonMapper = new JsonMapper();
        this.gson = new Gson();
    }

    public Map<String, Object> loadYaml(InputStream input) {
        return yaml.load(input);
    }

    public String convertToJson(Map<String, Object> config) {
        return jsonMapper.toJson(config);
    }

    public <T> T parseConfig(String json, Class<T> configClass) {
        return gson.fromJson(json, configClass);
    }
}
