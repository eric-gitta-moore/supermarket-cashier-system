package com.exam.supermarket.config.filter;

import com.exam.core.common.exception.SystemException;
import com.exam.supermarket.config.configuration.AppConfig;
import com.exam.supermarket.exception.DispatchException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionFilter implements Filter {

    private boolean isDebug = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        this.isDebug = AppConfig.getConfig().isDebug();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        try {
            chain.doFilter(request, response);
        } catch (SystemException e) {
            resp.sendError(e.getStatusCode());
            e.printStackTrace();

            if (isDebug) {
                req.setAttribute("stackTrace", ExceptionUtils.getStackTrace(e));
                req.setAttribute("errorMsg", ExceptionUtils.getMessage(e));
            }
        }
    }
}
