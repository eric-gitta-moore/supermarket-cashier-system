package com.exam.supermarket.constant.enums;

import lombok.Getter;

public enum FieldTypeEnum {
    TEXT("input", "text"),

    TEXTAREA("textarea"),

    SELECT("select"),

    PASSWORD("input", "password"),

    CHECKBOX("input", "checkbox"),

    INPUT_BUTTON("input", "button"),

    DATE("input", "date"),

    MONTH("input", "month"),

    RANGE("input", "range"),

    TIME("input", "time"),

    WEEK("input", "week"),

    DATETIME("input", "datetime"),

    FILE("input", "file"),

    RADIO("input", "radio");


    /**
     * 表单控件类型
     */
    @Getter
    private String value;

    /**
     * 表单控件中type属性的值
     */
    @Getter
    private String type;

    private FieldTypeEnum(String value) {
        this.value = value;
    }

    private FieldTypeEnum(String value, String type) {
        this.value = value;
        this.type = type;
    }
}
