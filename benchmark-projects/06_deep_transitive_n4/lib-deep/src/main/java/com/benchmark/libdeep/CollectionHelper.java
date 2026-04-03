package com.benchmark.libdeep;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Utilidad de bajo nivel para filtrado de colecciones y manejo de paths.
 */
public class CollectionHelper {

    public <T> List<T> filterNonNull(Collection<T> items) {
        List<T> result = new ArrayList<>(items);
        CollectionUtils.filter(result, (Predicate) object -> object != null);
        return result;
    }

    public String normalizeFilePath(String path) {
        return FilenameUtils.normalize(path);
    }

    public String getFileExtension(String filename) {
        return FilenameUtils.getExtension(filename);
    }
}
