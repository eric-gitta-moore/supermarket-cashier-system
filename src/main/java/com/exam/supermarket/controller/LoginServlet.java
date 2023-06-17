package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseServlet;
import com.exam.supermarket.constant.SessionConstant;
import com.exam.supermarket.po.UserPo;
import com.exam.supermarket.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/templates/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserPo userPo = userService.login(username, password);
        if (userPo != null) {
            req.getSession().setAttribute(SessionConstant.USER_INSTANCE, userPo);
            resp.sendRedirect("/index");
        } else {
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("alertLevel", "danger");
            doGet(req, resp);
        }
    }
}
