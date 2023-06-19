package com.exam.supermarket.bo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.exam.supermarket.po.GoodPo;
import com.exam.supermarket.po.UserPo;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderLogBo implements Serializable {

    private static final long serialVersionUID = -2868325200355998897L;

    @ExcelProperty("订单号")
    private String id;

    @ExcelProperty("顾客id")
    private String customerId;

    @ExcelProperty("顾客姓名")
    private String customerName;

    @ExcelProperty("收银员id")
    private String cashierId;

    @ExcelProperty("收银员姓名")
    private String cashierName;

    @ExcelProperty("商品货号")
    private String goodId;

    @ExcelProperty("商品")
    private List<String> goodName;

    @ExcelProperty("应付")
    private Double payable;

    @ExcelProperty("实付")
    private Double payment;

    @ExcelProperty("优惠标记")
    private String goodsTag;

    @ExcelProperty("交易时间")
    private Timestamp time;
}
