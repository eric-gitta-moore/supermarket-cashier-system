package com.exam.core.common.util;

public class StrUtil {

    public static int countOccurrences(String text, String searchStr) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(searchStr, index)) != -1) {
            count++;
            index += searchStr.length();
        }
        return count;
    }

}
