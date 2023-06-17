package com.exam.supermarket.service;

import com.exam.core.base.service.BaseService;
import com.exam.supermarket.dao.GoodDao;
import com.exam.supermarket.dao.OrderDao;
import com.exam.supermarket.po.GoodPo;
import com.exam.supermarket.po.OrderPo;

public class GoodService extends BaseService<GoodPo> {

    public GoodService() {
        this.dao = new GoodDao();
    }
}
