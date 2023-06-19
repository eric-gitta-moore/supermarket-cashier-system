package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.core.common.metadata.SiteMetadata;
import com.exam.supermarket.constant.enums.FieldTypeEnum;
import com.exam.supermarket.metadata.FieldDescriptor;
import com.exam.supermarket.po.UserPo;
import com.exam.supermarket.service.UserService;
import com.exam.supermarket.util.FieldDescriptorUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet({"/user", "/user/*"})
public class UserController extends BaseController<UserPo> {

    public UserController() {
        this.setNoNeedLogin(new String[]{});
        this.setService(new UserService());
    }


    @Override
    protected void index(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("会员管理", "会员管理", "会员管理", "");
        req.setAttribute("siteMetadata", siteMetadata);
        super.index(req, resp);
    }

    @Override
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("新增会员", "新增会员", "新增会员", "");
        req.setAttribute("siteMetadata", siteMetadata);
        super.add(req, resp);
    }

    @Override
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("修改会员", "修改会员", "修改会员", "");
        req.setAttribute("siteMetadata", siteMetadata);
        super.edit(req, resp);
    }

    private Map<String, String> getRoleOptions(HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, String> map = new LinkedHashMap<>();
        map.put("admin", "管理员");
        map.put("cashier", "收银员");
        map.put("user", "用户");
        return map;
    }

    protected Map<String, FieldDescriptor> getFields(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, FieldDescriptor> fields = new LinkedHashMap<>();

        FieldDescriptor idDesc = new FieldDescriptor("id", "ID", false);
        idDesc.setTableHeaderLabel("#");
        idDesc.setReadonly(true);
        idDesc.setDisabled(true);
        fields.put("id", idDesc);

        FieldDescriptor usernameDesc = new FieldDescriptor("username", "用户名", true);
        fields.put("username", usernameDesc);

        FieldDescriptor passwordDesc = new FieldDescriptor("password", "密码", true);
        fields.put("password", passwordDesc);

        FieldDescriptor nameDesc = new FieldDescriptor("name", "姓名", true);
        fields.put("name", nameDesc);

        FieldDescriptor roleDesc = new FieldDescriptor("role", "角色", true);
        roleDesc.setFieldType(FieldTypeEnum.RADIO);
        roleDesc.setOptions(this.getRoleOptions(req, resp));
        fields.put("role", roleDesc);

        FieldDescriptor vipDesc = new FieldDescriptor("vip", "VIP", false);
        fields.put("vip", vipDesc);
        return fields;
    }

    @Override
    protected Map<String, FieldDescriptor> getIndexFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"id", "username", "name", "role", "vip"});
    }

    @Override
    protected Map<String, FieldDescriptor> getAddFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"username", "password", "name", "role", "vip"});
    }

    @Override
    protected Map<String, FieldDescriptor> getUpdateFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"id", "username", "password", "name", "role", "vip"});
    }
}
