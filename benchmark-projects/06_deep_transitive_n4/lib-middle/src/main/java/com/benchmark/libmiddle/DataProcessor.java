package com.benchmark.libmiddle;

import com.benchmark.libdeep.CollectionHelper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Procesador de datos que delega operaciones de bajo nivel a CollectionHelper.
 */
public class DataProcessor {

    private final CollectionHelper helper;

    public DataProcessor() {
        this.helper = new CollectionHelper();
    }

    public <T> List<T> cleanCollection(Collection<T> items) {
        return helper.filterNonNull(items);
    }

    public List<String> normalizeFileNames(List<String> paths) {
        return paths.stream()
            .map(helper::normalizeFilePath)
            .collect(Collectors.toList());
    }

    public List<String> filterByExtension(List<String> files, String extension) {
        return files.stream()
            .filter(f -> extension.equals(helper.getFileExtension(f)))
            .collect(Collectors.toList());
    }
}
