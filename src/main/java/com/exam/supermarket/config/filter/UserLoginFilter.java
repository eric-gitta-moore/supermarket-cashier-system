package com.exam.supermarket.config.filter;

import com.exam.supermarket.constant.SessionConstant;
import com.exam.supermarket.po.UserPo;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebFilter("/*")
public class UserLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setAttribute("uri", req.getRequestURI());
        List<String> permitSuffixList = Arrays.asList(
                ".css",
                ".js",
                ".jpg",
                ".png",
                ".webp",
                ".map",
                ".mp3"
        );
        if (permitSuffixList.stream().anyMatch(e -> req.getRequestURI().endsWith(e))) {
            chain.doFilter(request, response);
            return;
        }

        List<String> permitUrl = Arrays.asList(
                "/login",
                "/test"
        );
        if (permitUrl.contains(req.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession();
        UserPo userPo = (UserPo) session.getAttribute(SessionConstant.USER_INSTANCE);
        if (userPo == null) {
            resp.sendRedirect("/login");
            return;
        }
        chain.doFilter(request, response);
    }
}
