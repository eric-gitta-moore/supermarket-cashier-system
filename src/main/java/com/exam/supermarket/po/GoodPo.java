package com.exam.supermarket.po;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class GoodPo implements Serializable {
    private static final long serialVersionUID = -6910840172079985219L;
    private Integer id;
    private String name;
    private Integer stock;
    private Double price;
}
