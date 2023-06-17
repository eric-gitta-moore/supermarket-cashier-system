package com.exam.supermarket.po;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class OrderPo implements Serializable {
    private static final long serialVersionUID = -2868325200355998897L;
    String id;
    String customerId;
    String cashierId;
    String goodId;
    Integer num;
    String payable;
    String payment;
    String goodsTag;
    String time;
}
