package com.benchmark.app;

import com.benchmark.libouter.FileService;

import java.util.Arrays;
import java.util.List;

/**
 * Aplicacion principal que consume FileService.
 * No tiene visibilidad directa de las dependencias vulnerables
 * (commons-collections, commons-io) que estan a 4 niveles de profundidad.
 */
public class App {

    private final FileService fileService;

    public App() {
        this.fileService = new FileService();
    }

    public List<String> processUploadedFiles(List<String> rawPaths) {
        List<String> normalized = fileService.listNormalizedPaths(rawPaths);
        System.out.println("Archivos normalizados: " + normalized);
        return normalized;
    }

    public List<String> findDocuments(List<String> files) {
        return fileService.findByType(files, "pdf");
    }

    public static void main(String[] args) {
        App app = new App();

        List<String> paths = Arrays.asList(
            "/uploads/../data/report.pdf",
            "/uploads/image.png",
            "/uploads/./document.pdf",
            "/uploads/data.csv"
        );

        List<String> normalized = app.processUploadedFiles(paths);
        List<String> pdfs = app.findDocuments(normalized);
        System.out.println("Documentos PDF encontrados: " + pdfs);
    }
}
