package com.exam.supermarket.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderlogPo implements Serializable {
    private static final long serialVersionUID = -2868325200355998897L;
    private String id;
    private String customerId;
    private String cashierId;
    private String goodId;
    private Integer num;
    private String payable;
    private String payment;
    private String goodsTag;
    private String time;
}
