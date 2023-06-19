package com.exam.core.common.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrUtil {

    /**
     * 统计searchStr在text中的出现次数
     *
     * @param text
     * @param searchStr
     * @return
     */
    public static int countOccurrences(String text, String searchStr) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(searchStr, index)) != -1) {
            count++;
            index += searchStr.length();
        }
        return count;
    }

    /**
     * 用regex分割str，统计各个子串出现次数
     * @param str
     * @param regex
     * @return
     */
    public static Map<String, Integer> statOccurrences(String str, String regex) {
        Map<String, Integer> countMap = new HashMap<>();

        // 将字符串按逗号分割成数字数组
        String[] numbers = str.split(regex);

        // 统计数字出现次数
        for (String number : numbers) {
            countMap.put(number.trim(), countMap.getOrDefault(number.trim(), 0) + 1);
        }
        return countMap;
    }

    public static Map<String, Integer> statOccurrences(Collection<String> strList) {
        Map<String, Integer> countMap = new HashMap<>();

        // 统计数字出现次数
        for (String number : strList) {
            countMap.put(number.trim(), countMap.getOrDefault(number.trim(), 0) + 1);
        }
        return countMap;
    }

}
