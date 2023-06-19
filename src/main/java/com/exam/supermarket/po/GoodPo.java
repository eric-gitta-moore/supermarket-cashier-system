package com.exam.supermarket.po;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class GoodPo implements Serializable {
    private static final long serialVersionUID = -6910840172079985219L;

    @ExcelProperty("ID")
    private Integer id;

    @ExcelProperty("商品名")
    private String name;

    @ExcelProperty("库存")
    private Integer stock;

    @ExcelProperty("价格")
    private Double price;
}
