package com.exam.supermarket.service;

import com.exam.core.base.service.BaseService;
import com.exam.supermarket.dao.GoodDao;
import com.exam.supermarket.po.GoodPo;

public class GoodService extends BaseService<GoodPo> {

    public GoodService() {
        this.dao = new GoodDao();
    }
}
