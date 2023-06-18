package com.exam.core.base.controller;

import jakarta.servlet.http.HttpServlet;
import lombok.Getter;
import lombok.Setter;

public class BaseController extends HttpServlet {

    @Getter
    @Setter
    private String[] noNeedLogin = {"*"};

    @Getter
    @Setter
    private String[] noNeedRight = {};
}
