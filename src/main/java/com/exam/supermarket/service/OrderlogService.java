package com.exam.supermarket.service;

import com.exam.core.base.service.BaseService;
import com.exam.supermarket.dao.OrderlogDao;
import com.exam.supermarket.po.OrderlogPo;

public class OrderlogService extends BaseService<OrderlogPo> {

    public OrderlogService() {
        this.dao = new OrderlogDao();
    }
}
