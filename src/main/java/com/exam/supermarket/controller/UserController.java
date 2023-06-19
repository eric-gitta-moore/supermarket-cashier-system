package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.supermarket.metadata.FieldDescriptor;
import com.exam.supermarket.po.UserPo;
import com.exam.supermarket.service.UserService;
import com.exam.supermarket.util.FieldDescriptorUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;

@WebServlet({"/user", "/user/*"})
public class UserController extends BaseController<UserPo> {

    public UserController() {
        this.setNoNeedLogin(new String[]{});
        this.setService(new UserService());
    }


    protected Map<String, FieldDescriptor> getFields(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, FieldDescriptor> fields = new LinkedHashMap<>();

        FieldDescriptor idDesc = new FieldDescriptor("id","ID",false);
        idDesc.setTableHeaderLabel("#");
        fields.put("id", idDesc);

        FieldDescriptor usernameDesc = new FieldDescriptor("username","用户名", true);
        fields.put("username", usernameDesc);

        FieldDescriptor nameDesc = new FieldDescriptor("name","姓名", true);
        fields.put("name", nameDesc);

        FieldDescriptor roleDesc = new FieldDescriptor("role","角色", true);
        fields.put("role", roleDesc);

        FieldDescriptor vipDesc = new FieldDescriptor("vip","VIP",false);
        fields.put("vip", vipDesc);
        return fields;
    }

    @Override
    protected Map<String, FieldDescriptor> getUpdateFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req,resp),
            new String[]{"username", "password", "name", "role", "vip"});
    }

    @Override
    protected Map<String, FieldDescriptor> getIndexFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req,resp),
            new String[]{"id", "username", "name", "role", "vip"});
    }
}
