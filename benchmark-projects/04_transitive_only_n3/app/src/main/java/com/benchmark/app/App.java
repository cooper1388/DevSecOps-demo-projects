package com.benchmark.app;

import com.benchmark.libwrapper.DataService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Aplicacion principal que consume DataService (lib-wrapper).
 * No tiene visibilidad directa de las dependencias vulnerables
 * que estan en lib-core (commons-collections, commons-beanutils).
 * Las vulnerabilidades estan a 3 niveles de profundidad (N3).
 */
public class App {

    private final DataService dataService;

    public App() {
        this.dataService = new DataService();
    }

    public void processItems() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> stringified = dataService.convertToStringList(numbers);
        System.out.println("Items convertidos: " + stringified);
    }

    public void inspectObject(Object bean) {
        Map<String, String> properties = dataService.introspect(bean);
        properties.forEach((key, value) ->
            System.out.println("  " + key + " = " + value)
        );
    }

    public static void main(String[] args) {
        App app = new App();
        app.processItems();

        SampleConfig config = new SampleConfig("prod", 8080, true);
        System.out.println("Propiedades del config:");
        app.inspectObject(config);
    }

    public static class SampleConfig {
        private String environment;
        private int port;
        private boolean sslEnabled;

        public SampleConfig(String environment, int port, boolean sslEnabled) {
            this.environment = environment;
            this.port = port;
            this.sslEnabled = sslEnabled;
        }

        public String getEnvironment() { return environment; }
        public int getPort() { return port; }
        public boolean isSslEnabled() { return sslEnabled; }
    }
}
