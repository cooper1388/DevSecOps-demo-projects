package com.benchmark.libwrapper;

import com.benchmark.libcore.DataTransformer;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Servicio facade que expone funcionalidades de lib-core.
 * No introduce dependencias vulnerables propias.
 */
public class DataService {

    private final DataTransformer transformer;

    public DataService() {
        this.transformer = new DataTransformer();
    }

    public List<String> convertToStringList(Collection<?> items) {
        return transformer.transformToStrings(items);
    }

    public Map<String, String> introspect(Object bean) {
        return transformer.describeBean(bean);
    }

    public void transfer(Object source, Object target) {
        transformer.copyProperties(target, source);
    }
}
