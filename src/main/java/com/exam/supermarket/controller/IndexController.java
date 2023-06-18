package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.supermarket.po.GoodPo;
import com.exam.supermarket.service.GoodService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet({"/index", "/index/*"})
public class IndexController extends BaseController<GoodPo> {

    public IndexController() {
        this.setService(new GoodService());
        this.setNoNeedLogin(new String[]{"index"});
    }


    @Override
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, String> fields = new HashMap<>();
        fields.put("name", "商品名");
        fields.put("stock", "库存");
        fields.put("price", "价格");
        req.setAttribute("fields", fields);
        req.getRequestDispatcher("/WEB-INF/templates/index/add.jsp").forward(req, resp);
    }
}
