package com.exam.supermarket.util;

import com.exam.core.common.metadata.PathInfo;
import com.exam.core.common.util.UrlUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class ActionDispatcher {

    private static final Logger logger = Logger.getLogger(ActionDispatcher.class.getName());

    public static <T extends HttpServlet> void actionDispatcher(T clazz, HttpServletRequest req,
        HttpServletResponse resp) {
        PathInfo pathInfo = UrlUtil.parsePathInfo(req.getRequestURI());
        try {
            logger.info(String.format("actionDispatcher: %s", pathInfo));

            Method method = clazz.getClass().getDeclaredMethod(pathInfo.getAction(),
                HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(clazz, req, resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
