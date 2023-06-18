package com.exam.supermarket.config.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AssetsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (isStaticFileRequest(req.getRequestURI())) {
            ServletContext servletContext = req.getServletContext();
            servletContext.getNamedDispatcher("default").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    protected boolean isStaticFileRequest(String uri) {
        List<String> permitSuffixList = Arrays.asList(
            ".css",
            ".js",
            ".jpg",
            ".png",
            ".webp",
            ".map",
            ".mp3"
        );
        return permitSuffixList.stream().anyMatch(uri::endsWith);
    }
}
