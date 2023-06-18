package com.exam.core.base.controller;

import com.exam.core.base.service.BaseService;
import com.exam.core.common.exception.SystemException;
import com.exam.core.common.metadata.IPage;
import com.exam.core.common.plugin.pagination.Page;
import com.exam.core.common.util.GenericsUtils;
import com.exam.supermarket.util.AuthorActionDispatcherUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class BaseController<T> extends HttpServlet {

    @Getter
    @Setter
    private String[] noNeedLogin = {"*"};

    @Getter
    @Setter
    private String[] noNeedRight = {};

    @Getter
    @Setter
    private BaseService<T> service;

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

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int page = 1;
        int size = 10;
        try {
            page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
            size = req.getParameter("size") == null ? 20 : Integer.valueOf(req.getParameter("size"));
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getServletPath());
            return;
        }

        IPage<T> pagination = new Page<>(page, Math.min(10, size));
        this.service.page(pagination);
        req.setAttribute("pagination", pagination);
        req.setAttribute("goods", pagination.getRecords());
        req.setAttribute("pageQuery", String.format("page=%d&size=%d", page, size));
        req.getRequestDispatcher("/WEB-INF/templates/index/index.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        throw new SystemException("无实现方法");
    }

    protected void change(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        this.index(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.service.removeById(req.getParameter("id"));
        resp.sendRedirect(req.getServletPath());
    }

    protected void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Class<T> poClass = GenericsUtils.getSuperClassGenericType(this.getClass());
        T po = null;
        try {
            po = poClass.getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        try {
            BeanUtils.populate(po, req.getParameterMap());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        this.service.saveOrUpdate(po);
        resp.sendRedirect(req.getServletPath());
    }
}
