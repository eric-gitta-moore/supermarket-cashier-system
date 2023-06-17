package com.exam.core.common.util;

import java.lang.reflect.Field;
import java.util.*;

public class ClassFieldUtil {

    public static Map<String, Object> getFields(Object entity, List<String> removedFields) {
        Map<String, Object> queryParam = getFieldsWithNull(entity, removedFields);
        Iterator<Map.Entry<String, Object>> iterator = queryParam.entrySet().iterator();
        for (; iterator.hasNext(); ) {
            Map.Entry<String, Object> next = iterator.next();
            if (next.getValue() == null) {
                iterator.remove();
            }
        }
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
