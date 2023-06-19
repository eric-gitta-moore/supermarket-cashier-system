package com.exam.supermarket.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CashierGoodVo implements Serializable {

    private static final long serialVersionUID = -6910840172079985219L;

    private Integer id;

    private String name;

    private Integer stock;

    private Double price;

    private Integer num;

}
