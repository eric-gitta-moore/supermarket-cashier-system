package com.exam.supermarket.config;

import com.exam.supermarket.constant.SessionConstant;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebFilter(value = "/*")
public class UserLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        List<String> permitUrl = new ArrayList<>(Arrays.asList(
            new String[]{
                "/login",
                "/test",
            }
        ));
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (permitUrl.contains(req.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute(SessionConstant.USER_ID);
        if (userId == null) {
            resp.sendRedirect("/login");
            return;
        }
        chain.doFilter(request, response);
    }
}
