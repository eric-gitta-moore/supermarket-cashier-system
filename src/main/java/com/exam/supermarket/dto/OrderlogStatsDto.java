package com.exam.supermarket.dto;

import lombok.Data;

@Data
public class OrderlogStatsDto {

    /**
     * 近30日交易流水
     */
    private Double monthTransaction;

    /**
     * 近30日交易订单数
     */
    private Integer monthOrderCount;

    /**
     * 总交易流水
     */
    private Double totalTransaction;

    /**
     * 总交易订单数
     */
    private Integer totalOrderCount;
}
