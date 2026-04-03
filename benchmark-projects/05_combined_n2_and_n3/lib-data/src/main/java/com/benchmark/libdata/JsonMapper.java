package com.benchmark.libdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Utilidad de mapeo JSON usando Jackson.
 * Codigo seguro para SAST: ObjectMapper con configuracion por defecto,
 * sin enableDefaultTyping ni deserializacion polimorfica.
 */
public class JsonMapper {

    private final ObjectMapper mapper;

    public JsonMapper() {
        this.mapper = new ObjectMapper();
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializando a JSON", e);
        }
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializando JSON", e);
        }
    }
}
