package com.exam.supermarket.service;

import com.exam.core.base.service.BaseService;
import com.exam.supermarket.dao.UserDao;
import com.exam.supermarket.po.UserPo;

import java.sql.SQLException;

public class UserService extends BaseService<UserPo> {

    public UserService() {
        this.dao = new UserDao();
    }

    public UserPo login(String username, String password) {
        UserPo userPo = new UserPo();
        userPo.setUsername(username);
        userPo.setPassword(password);
        return this.getOne(userPo);
    }
}
