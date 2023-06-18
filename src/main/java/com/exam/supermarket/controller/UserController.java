package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.supermarket.po.UserPo;
import com.exam.supermarket.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet({"/user", "/user/*"})
public class UserController extends BaseController<UserPo> {
    public UserController() {
        this.setNoNeedLogin(new String[]{});
        this.setService(new UserService());
    }

    @Override
    protected Map<String, String> getUpdateFields(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> fields = new LinkedHashMap<>();
        fields.put("username", "商品名");
        fields.put("password", "库存");
        fields.put("name", "名字");
        fields.put("role", "角色");
        fields.put("vip", "会员卡");
        return fields;
    }

    @Override
    protected Map<String, String> getIndexFields(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> fields = new LinkedHashMap<>();
        fields.put("id", "#");
        fields.put("username", "用户名");
        fields.put("name", "名字");
        fields.put("role", "角色");
        fields.put("vip", "会员卡");
        return fields;
    }
}
