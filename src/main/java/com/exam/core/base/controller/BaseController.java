package com.exam.core.base.controller;

import com.exam.supermarket.util.AuthorActionDispatcherUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;

public class BaseController extends HttpServlet {

    @Getter
    @Setter
    private String[] noNeedLogin = {"*"};

    @Getter
    @Setter
    private String[] noNeedRight = {};

    protected void dispatch(HttpServletRequest req, HttpServletResponse resp) {
        AuthorActionDispatcherUtil.actionDispatcher(this, req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        dispatch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.doGet(req, resp);
    }
}
