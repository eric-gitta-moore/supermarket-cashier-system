package com.exam.supermarket.po;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class GoodPo implements Serializable {

    @Serial
    private static final long serialVersionUID = -6910840172079985219L;
    Integer id;
    String name;
    Integer stock;
    Double price;
}
