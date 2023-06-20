package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.core.common.metadata.SiteMetadata;
import com.exam.supermarket.constant.SessionConstant;
import com.exam.supermarket.po.UserPo;
import com.exam.supermarket.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 登录注册找回密码
 */
@WebServlet({"/login", "/login/*"})
public class LoginController extends BaseController {

    public LoginController() {
        this.setService(new UserService());
    }

    @Override
    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SiteMetadata siteMetadata = new SiteMetadata("登录", "登录", "登录", "");
        req.setAttribute("siteMetadata", siteMetadata);
        this.autoForward(req, resp);
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute(SessionConstant.USER_INSTANCE);
        resp.sendRedirect("/login");
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserPo userPo = ((UserService) this.getService()).login(username, password);
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
