package com.exam.supermarket.dao;

import com.exam.core.base.dao.BaseDao;
import com.exam.supermarket.po.OrderPo;

public class OrderDao extends BaseDao<OrderPo> {

    public OrderDao() {
        this.table = "order";
    }
}
