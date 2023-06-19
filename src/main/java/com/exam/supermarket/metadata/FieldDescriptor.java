package com.exam.supermarket.metadata;

import com.exam.supermarket.constant.enums.FieldTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDescriptor {

    private Boolean readonly;

    private Boolean disabled;

    private Boolean required;

    /**
     * 暂时无用
     */
    private String extra;

    /**
     * input标签中的type属性
     */
    private FieldTypeEnum fieldType = FieldTypeEnum.TEXT;

    /**
     * 表单显示文字
     */
    private String formLabel;

    /**
     * 表格表头显示文字
     */
    private String tableHeaderLabel;

    /**
     * 修改项目时表单的value
     */
    private String value;

    /**
     * 新增项目时候的默认值
     */
    private String defaultValue;

    private String placeholder;

    /**
     * 单选多选下拉表单的选项
     * Map<String, String> value:label
     */
    private Map<String, String> options;

    /**
     * 表单name
     */
    private String fieldName;

    public FieldDescriptor(String fieldName, String formLabel, Boolean required) {
        this.formLabel = formLabel;
        this.fieldName = fieldName;
        this.required = required;
    }

    public FieldDescriptor(Boolean required) {
        this.required = required;
    }

    public FieldDescriptor(Boolean required, Boolean disabled) {
        this.disabled = disabled;
        this.required = required;
    }

    public FieldDescriptor(Boolean required, Boolean disabled, Boolean readonly) {
        this.readonly = readonly;
        this.disabled = disabled;
        this.required = required;
    }

    public String getTableHeaderLabel() {
        return tableHeaderLabel != null ? tableHeaderLabel : formLabel;
    }
}
