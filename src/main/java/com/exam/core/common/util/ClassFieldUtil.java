package com.exam.core.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassFieldUtil {

    public static Map<String, Object> getFields(Object entity, List<String> removedFields) {
        Map<String, Object> queryParam = getFieldsWithNull(entity, removedFields);
        queryParam.keySet().stream().map(k -> {
            if (queryParam.get(k) == null) {
                queryParam.remove(k);
            }
            return k;
        });
        return queryParam;
    }

    public static Map<String, Object> getFieldsWithNull(Object entity, List<String> removedFields) {
        Field[] fields = entity.getClass().getDeclaredFields();
        Map<String, Object> queryParam = new HashMap<>();
        for (Field field :
            fields) {
            if (removedFields.contains(field.getName())) {
                continue;
            }
            try {
                field.setAccessible(true);
                queryParam.put(field.getName(), field.get(entity));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return queryParam;
    }

    public static Map<String, Object> getFields(Object entity) {
        List<String> removedFields = new ArrayList<>();
        removedFields.add("serialVersionUID");
        return getFields(entity, removedFields);
    }
}
