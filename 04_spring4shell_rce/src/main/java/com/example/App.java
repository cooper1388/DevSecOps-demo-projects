package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * VULNERABLE: Spring4Shell (CVE-2022-22965)
 * Spring data binding permite a un atacante modificar propiedades de ClassLoader
 * via parametros HTTP, escribiendo un webshell JSP en el servidor.
 * Payload: class.module.classLoader.resources.context.parent.pipeline.first.pattern=%{...}
 */
@Controller
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/search")
    public String search(@RequestParam String query) {
        // VULNERABLE: Spring data binding procesa parametros HTTP sin restriccion
        // Un atacante puede inyectar propiedades del ClassLoader
        return "results";
    }
}
