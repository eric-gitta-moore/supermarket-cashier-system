package com.exam.supermarket.constant.enums;

public enum RoleEnum {
    ADMIN("admin"),
    CUSTOMER("customer"),
    CASHIER("cashier");
    private String value;

    private RoleEnum(String value) {
        this.value = value;
    }
}
