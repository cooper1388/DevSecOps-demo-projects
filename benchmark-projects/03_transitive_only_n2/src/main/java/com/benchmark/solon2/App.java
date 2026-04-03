package com.benchmark.solon2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Controlador REST simple usando Spring Boot.
 * Codigo limpio desde perspectiva SAST: validacion de input con Bean Validation,
 * sin inyeccion directa de datos en queries o comandos.
 * La vulnerabilidad NO esta en el codigo sino en las versiones transitivas:
 * snakeyaml, spring-webmvc, tomcat-embed traidos por el starter.
 */
@RestController
public class App {

    private final List<TaskItem> tasks = Collections.synchronizedList(new ArrayList<>());

    @GetMapping("/tasks")
    public List<TaskItem> listTasks() {
        return Collections.unmodifiableList(tasks);
    }

    @PostMapping("/tasks")
    public TaskItem createTask(@Valid @RequestBody TaskRequest request) {
        TaskItem task = new TaskItem();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCreatedAt(LocalDateTime.now());
        tasks.add(task);
        return task;
    }

    public static class TaskRequest implements Serializable {
        @NotBlank(message = "El titulo es obligatorio")
        @Size(max = 200, message = "El titulo no puede exceder 200 caracteres")
        private String title;

        @Size(max = 1000, message = "La descripcion no puede exceder 1000 caracteres")
        private String description;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }

    public static class TaskItem implements Serializable {
        private String title;
        private String description;
        private LocalDateTime createdAt;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    }
}
