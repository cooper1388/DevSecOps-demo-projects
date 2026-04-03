package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * VULNERABLE: Jackson Polymorphic Deserialization + Commons Collections Gadget Chain
 * ObjectMapper.enableDefaultTyping() permite que JSON malicioso instancie clases arbitrarias.
 * Combinado con commons-collections 3.2.1, un atacante puede ejecutar comandos del sistema.
 * Payload: ["org.apache.commons.collections.functors.InvokerTransformer", {"iMethodName":"exec"...}]
 */
public class App {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        // VULNERABLE: enableDefaultTyping permite deserializacion polimorfica
        mapper.enableDefaultTyping();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String untrustedJson = args.length > 0 ? args[0] : "{}";
        // VULNERABLE: deserializa input no confiable con tipos polimorficos
        Object result = mapper.readValue(untrustedJson, Object.class);
        System.out.println("Deserialized: " + result.getClass().getName());
    }
}
