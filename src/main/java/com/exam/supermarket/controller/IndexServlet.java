package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseServlet;
import com.exam.supermarket.po.GoodPo;
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
        goodService.list();
        req.getRequestDispatcher("/WEB-INF/templates/index.jsp").forward(req, resp);
    }
}
