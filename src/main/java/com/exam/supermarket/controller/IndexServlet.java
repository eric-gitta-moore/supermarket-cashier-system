package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseServlet;
import com.exam.core.common.metadata.IPage;
import com.exam.core.common.plugin.pagination.Page;
import com.exam.supermarket.service.GoodService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends BaseServlet {

    private GoodService goodService = new GoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        req.getRequestDispatcher("/WEB-INF/templates/index.jsp").forward(req, resp);
    }
}
