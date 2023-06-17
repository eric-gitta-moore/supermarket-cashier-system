package com.exam.supermarket.po;

import lombok.Data;

@Data
public class OrderPo {
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
