package com.benchmark.libouter;

import com.benchmark.libmiddle.DataProcessor;

import java.util.List;

/**
 * Servicio de archivos de alto nivel. Delega a DataProcessor.
 */
public class FileService {

    private final DataProcessor processor;

    public FileService() {
        this.processor = new DataProcessor();
    }

    public List<String> listNormalizedPaths(List<String> rawPaths) {
        return processor.normalizeFileNames(rawPaths);
    }

    public List<String> findByType(List<String> files, String type) {
        return processor.filterByExtension(files, type);
    }
}
