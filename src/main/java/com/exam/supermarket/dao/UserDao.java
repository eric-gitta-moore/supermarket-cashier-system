package com.exam.supermarket.dao;

import com.exam.core.base.dao.BaseDao;
import com.exam.supermarket.po.UserPo;

public class UserDao extends BaseDao<UserPo> {

    public UserDao() {
        this.table = "user";
    }
}
