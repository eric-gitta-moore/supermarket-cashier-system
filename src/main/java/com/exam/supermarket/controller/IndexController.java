package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.core.common.metadata.SiteMetadata;
import com.exam.supermarket.metadata.FieldDescriptor;
import com.exam.supermarket.po.GoodPo;
import com.exam.supermarket.service.GoodService;
import com.exam.supermarket.util.FieldDescriptorUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet({"/index", "/index/*"})
public class IndexController extends BaseController<GoodPo> {

    public IndexController() {
        this.setService(new GoodService());
        this.setNoNeedLogin(new String[]{"index"});
    }

    @Override
    protected void index(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("商品列表", "商品列表", "商品列表", "");
        req.setAttribute("siteMetadata", siteMetadata);
        super.index(req, resp);
    }

    @Override
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("新增商品", "新增商品", "新增商品", "");
        req.setAttribute("siteMetadata", siteMetadata);
        super.add(req, resp);
    }

    @Override
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("修改商品", "修改商品", "修改商品", "");
        req.setAttribute("siteMetadata", siteMetadata);
        super.edit(req, resp);
    }

    protected Map<String, FieldDescriptor> getFields(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, FieldDescriptor> fields = new LinkedHashMap<>();

        FieldDescriptor idDesc = new FieldDescriptor("id", "ID", false);
        idDesc.setTableHeaderLabel("#");
        idDesc.setReadonly(true);
        idDesc.setDisabled(true);
        fields.put("id", idDesc);

        FieldDescriptor usernameDesc = new FieldDescriptor("name", "商品名", true);
        fields.put("name", usernameDesc);

        FieldDescriptor nameDesc = new FieldDescriptor("stock", "库存", true);
        fields.put("stock", nameDesc);

        FieldDescriptor roleDesc = new FieldDescriptor("price", "价格", true);
        fields.put("price", roleDesc);
        return fields;
    }

    @Override
    protected Map<String, FieldDescriptor> getIndexFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"id", "name", "stock", "price"});
    }

    @Override
    protected Map<String, FieldDescriptor> getAddFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"name", "stock", "price"});
    }

    @Override
    protected Map<String, FieldDescriptor> getUpdateFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"id", "name", "stock", "price"});
    }

}
