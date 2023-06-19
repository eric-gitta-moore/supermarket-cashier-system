package com.exam.supermarket.po;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class OrderlogPo implements Serializable {
    private static final long serialVersionUID = -2868325200355998897L;

    @ExcelProperty("订单号")
    private String id;

    @ExcelProperty("顾客id")
    private String customerId;

    @ExcelProperty("收银员id")
    private String cashierId;

    @ExcelProperty("商品id")
    private String goodId;

    @ExcelProperty("应付")
    private Double payable;

    @ExcelProperty("实付")
    private Double payment;

    @ExcelProperty("优惠标记")
    private String goodsTag;

    @ExcelProperty("交易时间")
    private Timestamp time;
}
