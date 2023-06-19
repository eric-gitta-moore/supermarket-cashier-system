package com.exam.supermarket.metadata;

import com.exam.supermarket.constant.enums.FieldTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDescriptor {

    private Boolean readonly;
    private Boolean disabled;
    private Boolean required;
    private String extra;
    private FieldTypeEnum fieldType;
    /**
     * 表单显示文字
     */
    private String formLabel;
    /**
     * 表格表头显示文字
     */
    private String tableHeaderLabel;
    private String value;
    private String defaultValue;
    private String placeholder;
    private String radioItems;
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
