package com.exam.supermarket.service;

import com.exam.core.base.service.BaseService;
import com.exam.supermarket.dao.OrderDao;
import com.exam.supermarket.dao.UserDao;
import com.exam.supermarket.po.OrderPo;
import com.exam.supermarket.po.UserPo;

public class OrderService extends BaseService<OrderPo> {

    public OrderService() {
        this.dao = new OrderDao();
    }
}
