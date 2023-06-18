package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.core.common.metadata.IPage;
import com.exam.core.common.plugin.pagination.Page;
import com.exam.supermarket.po.GoodPo;
import com.exam.supermarket.service.GoodService;
import com.exam.supermarket.util.ActionDispatcherUtil;
import com.exam.supermarket.util.AuthorActionDispatcherUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet({"/index", "/index/*"})
public class IndexController extends BaseController {

    private GoodService goodService = new GoodService();

    public IndexController() {
        this.setNoNeedLogin(new String[]{"index"});
        this.setNoNeedRight(new String[]{"add", "change", "delete", "save"});
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorActionDispatcherUtil.actionDispatcher(this, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Integer page = 1;
        Integer size = 10;
        try {
            page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
            size = req.getParameter("size") == null ? 20 : Integer.valueOf(req.getParameter("size"));
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getServletPath());
            return;
        }

        IPage<GoodPo> pagination = new Page<>(page, Math.min(10, size));
        goodService.page(pagination);
        req.setAttribute("pagination", pagination);
        req.setAttribute("goods", pagination.getRecords());
        req.setAttribute("pageQuery", String.format("page=%d&size=%d", page, size));
        req.getRequestDispatcher("/WEB-INF/templates/index/index.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, String> fields = new HashMap<>();
        fields.put("name", "商品名");
        fields.put("stock", "库存");
        fields.put("price", "价格");
        req.setAttribute("fields", fields);
        req.getRequestDispatcher("/WEB-INF/templates/index/add.jsp").forward(req, resp);
    }

    protected void change(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        this.index(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.goodService.removeById(req.getParameter("id"));
        resp.sendRedirect(req.getServletPath());
    }

    protected void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        GoodPo goodPo = new GoodPo();
        try {
            BeanUtils.populate(goodPo, req.getParameterMap());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        this.goodService.saveOrUpdate(goodPo);
        resp.sendRedirect(req.getServletPath());
    }
}
