package com.exam.supermarket.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderlogStatsVo {

    /**
     * 近30日交易流水
     */
    private String monthTransaction;

    /**
     * 近30日交易订单数
     */
    private String monthOrderCount;

    /**
     * 总交易流水
     */
    private String totalTransaction;

    /**
     * 总交易订单数
     */
    private String totalOrderCount;
}
