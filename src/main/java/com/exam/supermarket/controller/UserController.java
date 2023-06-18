package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.supermarket.po.UserPo;
import com.exam.supermarket.service.UserService;
import jakarta.servlet.annotation.WebServlet;

@WebServlet({"/user", "/user/*"})
public class UserController extends BaseController<UserPo> {
    public UserController() {
        this.setNoNeedLogin(new String[]{});
        this.setService(new UserService());
    }
}
