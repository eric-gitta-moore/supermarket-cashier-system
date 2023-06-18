package com.exam.supermarket.constant.enums;


import lombok.Getter;

public enum RoleEnum {
    ADMIN("admin"),
    CUSTOMER("customer"),
    CASHIER("cashier");

    @Getter
    private String value;

    private RoleEnum(String value) {
        this.value = value;
    }
}
