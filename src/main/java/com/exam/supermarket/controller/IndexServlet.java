package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseServlet;
import com.exam.core.common.metadata.IPage;
import com.exam.core.common.plugin.pagination.Page;
import com.exam.supermarket.po.GoodPo;
import com.exam.supermarket.service.GoodService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/index")
public class IndexServlet extends BaseServlet {

    private GoodService goodService = new GoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("act");
        if ("delete".equals(act)) {
            delete(req, resp);
            return;
        }

        Integer page = 1;
        Integer size = 10;
        try {
            page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
            size = req.getParameter("size") == null ? 20 : Integer.valueOf(req.getParameter("size"));
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getServletPath());
            return;
        }

        IPage pagination = new Page(page, Math.min(20, size));
        goodService.page(pagination);
        req.setAttribute("pagination", pagination);
        req.setAttribute("goods", pagination.getRecords());
        req.setAttribute("pageQuery", String.format("page=%d&size=%d", page, size));
        req.getRequestDispatcher("/WEB-INF/templates/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("act");
        if ("save".equals(act)) {
            save(req, resp);
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.goodService.removeById(req.getParameter("id"));
        resp.sendRedirect(req.getServletPath());
    }

    protected void save(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
        GoodPo goodPo = new GoodPo();
        try {
            BeanUtils.populate(goodPo, req.getParameterMap());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        this.goodService.updateById(goodPo);
        resp.sendRedirect(req.getServletPath());
    }
}
