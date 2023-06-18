package com.exam.supermarket.util;

import com.exam.core.common.metadata.PathInfo;
import com.exam.core.common.util.UrlUtil;
import com.exam.supermarket.exception.DispatchException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

public class ActionDispatcherUtil {

    private static final Logger logger = Logger.getLogger(ActionDispatcherUtil.class.getName());

    protected static void setAttrs(HttpServletRequest req, PathInfo pathInfo) {
        req.setAttribute("model", pathInfo.getModule());
        req.setAttribute("controller", pathInfo.getController());
        req.setAttribute("action", pathInfo.getAction());
        req.setAttribute("actionPath",
            String.format("%s/%s/%s",
                pathInfo.getModule(),
                pathInfo.getController(),
                pathInfo.getAction())
        );
        req.setAttribute("controllerPath",
            String.format("%s/%s",
                pathInfo.getModule(),
                pathInfo.getController())
        );
    }

    public static <T extends HttpServlet> void dispatch(PathInfo pathInfo, T clazz, HttpServletRequest req,
        HttpServletResponse resp) {
        try {
            Set<Method> methodSet = new LinkedHashSet<>();
            methodSet.addAll(Arrays.asList(clazz.getClass().getDeclaredMethods()));
            methodSet.addAll(Arrays.asList(clazz.getClass().getSuperclass().getDeclaredMethods()));

            Method method = methodSet.stream()
                .filter(e -> {
                    if (!pathInfo.getAction().equals(e.getName())) {
                        return false;
                    }
                    if (e.getParameterCount() != 2) {
                        return false;
                    }
                    if (e.getParameterTypes()[0] != HttpServletRequest.class) {
                        return false;
                    }
                    if (e.getParameterTypes()[1] != HttpServletResponse.class) {
                        return false;
                    }
                    return true;
                }).findFirst().orElse(null);
            if (method == null) {
//                throw new DispatchException("请求转发错误");
                throw new DispatchException("Request forwarding error");
            }

            method.setAccessible(true);
            method.invoke(clazz, req, resp);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends HttpServlet> void actionDispatcher(T clazz, HttpServletRequest req,
        HttpServletResponse resp) {
        PathInfo pathInfo = UrlUtil.parsePathInfo(req.getRequestURI());

        logger.info(String.format("actionDispatcher: %s", pathInfo));
        setAttrs(req, pathInfo);
        dispatch(pathInfo, clazz, req, resp);
    }

}
