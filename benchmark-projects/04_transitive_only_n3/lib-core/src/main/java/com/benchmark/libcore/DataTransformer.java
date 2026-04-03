package com.benchmark.libcore;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.StringValueTransformer;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Servicio de transformacion de datos que usa Commons Collections y BeanUtils.
 * Codigo limpio desde perspectiva SAST: usa APIs seguras de las librerias.
 */
public class DataTransformer {

    public List<String> transformToStrings(Collection<?> items) {
        Transformer transformer = StringValueTransformer.getInstance();
        Collection<?> transformed = CollectionUtils.collect(items, transformer);
        return new ArrayList<>((Collection<String>) transformed);
    }

    public Map<String, String> describeBean(Object bean) {
        try {
            return BeanUtils.describe(bean);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Error describing bean", e);
        }
    }

    public void copyProperties(Object dest, Object orig) {
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error copying properties", e);
        }
    }
}
