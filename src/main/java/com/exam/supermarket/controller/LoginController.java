package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.supermarket.constant.SessionConstant;
import com.exam.supermarket.po.UserPo;
import com.exam.supermarket.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/login", "/login/*"})
public class LoginController extends BaseController {

    private UserService userService = new UserService();

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/templates/login/login.jsp").forward(req, resp);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
