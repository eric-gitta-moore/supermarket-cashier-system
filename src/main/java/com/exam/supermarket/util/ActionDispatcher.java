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
import java.util.logging.Logger;

public class ActionDispatcher {

    private static final Logger logger = Logger.getLogger(ActionDispatcher.class.getName());

    public static <T extends HttpServlet> void actionDispatcher(T clazz, HttpServletRequest req,
        HttpServletResponse resp) {
        PathInfo pathInfo = UrlUtil.parsePathInfo(req.getRequestURI());
        try {
            logger.info(String.format("actionDispatcher: %s", pathInfo));

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

            Method[] declaredMethods = clazz.getClass().getDeclaredMethods();
            boolean isMethodExist = Arrays.stream(declaredMethods)
                .anyMatch(method -> pathInfo.getAction().equals(method.getName()));
            if (!isMethodExist) {
//                throw new DispatchException("请求转发错误");
                throw new DispatchException("Request forwarding error");
            }

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
