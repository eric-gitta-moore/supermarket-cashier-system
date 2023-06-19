package com.exam.supermarket.dao;

import com.exam.core.base.dao.BaseDao;
import com.exam.supermarket.po.OrderlogPo;

public class OrderlogDao extends BaseDao<OrderlogPo> {

    public OrderlogDao() {
        this.table = "orderlog";
    }
}
