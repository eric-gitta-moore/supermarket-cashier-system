package com.exam.supermarket.dao;

import com.exam.core.base.dao.BaseDao;
import com.exam.supermarket.po.GoodPo;

public class GoodDao extends BaseDao<GoodPo> {

    public GoodDao() {
        this.table = "good";
    }
}
