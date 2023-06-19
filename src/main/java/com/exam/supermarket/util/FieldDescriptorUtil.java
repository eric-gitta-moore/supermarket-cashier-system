package com.exam.supermarket.util;

import com.exam.supermarket.metadata.FieldDescriptor;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FieldDescriptorUtil {
    public static Map<String, FieldDescriptor> filterDescriptor(Map<String, FieldDescriptor> descriptors, String[] includes) {
        List<String> fields = Arrays.asList(includes);
        Map<String, FieldDescriptor> result = new LinkedHashMap<>();
        fields.forEach(e -> result.put(e, descriptors.get(e)));
        return result;
    }

}
