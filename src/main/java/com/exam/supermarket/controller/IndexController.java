package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.supermarket.po.GoodPo;
import com.exam.supermarket.service.GoodService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet({"/index", "/index/*"})
public class IndexController extends BaseController<GoodPo> {

    public IndexController() {
        this.setService(new GoodService());
        this.setNoNeedLogin(new String[]{"index"});
    }

    @Override
    protected Map<String, String> getUpdateFields(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> fields = new LinkedHashMap<>();
        fields.put("name", "商品名");
        fields.put("stock", "库存");
        fields.put("price", "价格");
        return fields;
    }

    @Override
    protected Map<String, String> getIndexFields(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> fields = new LinkedHashMap<>();
        fields.put("id", "#");
        fields.put("name", "商品名");
        fields.put("stock", "库存");
        fields.put("price", "价格");
        return fields;
    }
}
