package com.exam.core.common.util;

import java.util.Map;

public class SqlUtil {

    /**
     * 拼接where语句
     *
     * @param sql 确保传入的sql末尾包含 where 1=1 <br>
     *            例子：select * from good where 1=1
     * @param columnMap
     * @return
     */
    public static String concatWhere(String sql, Map<String, Object> columnMap) {
        if (columnMap == null) {
            return sql;
        }
        StringBuilder builder = new StringBuilder(sql);
        for (var item :
            columnMap.entrySet()) {
            builder.append(" and ").append(item.getKey()).append("=?");
        }
        return builder.toString();
    }

}
