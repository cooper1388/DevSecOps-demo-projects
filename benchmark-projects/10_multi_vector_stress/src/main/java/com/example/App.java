package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.collections.CollectionUtils;
import org.yaml.snakeyaml.Yaml;
import java.util.Map;

/**
 * STRESS TEST: Aplicacion que usa TODAS las dependencias vulnerables simultaneamente.
 * Cada import activa un vector de ataque diferente.
 *
 * Vectores activos:
 * - Log4Shell (JNDI RCE) via logger
 * - Jackson deserialization (polymorphic RCE) via ObjectMapper
 * - Text4Shell (expression injection) via StringSubstitutor
 * - Commons Collections (gadget chain) en classpath
 * - SnakeYAML (constructor injection) via Yaml.load()
 * - Spring4Shell (data binding RCE) via beans en classpath
 * - Netty (HTTP smuggling) en classpath
 * - Struts2 (OGNL injection) en classpath
 *
 * Total esperado: 80-120 CVEs, 15+ criticas, multiples KEV, multiples exploits publicos
 */
public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        // VECTOR 1: Log4Shell — input del usuario en logger
        String input = args.length > 0 ? args[0] : "safe";
        logger.info("Processing: {}", input);

        // VECTOR 2: Jackson — deserializacion polimorfica
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        Object obj = mapper.readValue("{}", Object.class);

        // VECTOR 3: Text4Shell — expression interpolation
        StringSubstitutor sub = StringSubstitutor.createInterpolator();
        String result = sub.replace("${" + input + "}");

        // VECTOR 4: SnakeYAML — constructor injection
        Yaml yaml = new Yaml();
        Map<String, Object> config = yaml.load(input);

        // VECTOR 5: Commons Collections — gadget chain en classpath
        // Solo necesita estar en el classpath para que Jackson/XStream lo usen como gadget
        boolean hasData = CollectionUtils.isNotEmpty(null);

        System.out.println("All vectors loaded: " + result);
    }
}
