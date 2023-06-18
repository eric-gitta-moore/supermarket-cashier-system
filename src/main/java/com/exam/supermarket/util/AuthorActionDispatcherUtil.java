package com.exam.supermarket.util;


import com.exam.core.common.metadata.PathInfo;
import com.exam.core.common.util.UrlUtil;
import com.exam.supermarket.constant.SessionConstant;
import com.exam.supermarket.constant.enums.RoleEnum;
import com.exam.supermarket.exception.UnauthorizedException;
import com.exam.supermarket.po.UserPo;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class AuthorActionDispatcherUtil extends ActionDispatcherUtil {

    private static final Logger logger = Logger.getLogger(AuthorActionDispatcherUtil.class.getName());

    protected static <T extends HttpServlet> boolean isAuthor(T clazz, HttpServletRequest req,
        HttpServletResponse resp) {
        PathInfo pathInfo = UrlUtil.parsePathInfo(req.getRequestURI());

        List<String> noNeedLogin;
        List<String> noNeedRight;
        try {
            Method getNoNeedLogin = clazz.getClass().getMethod("getNoNeedLogin");
            noNeedLogin = Arrays.asList((String[]) getNoNeedLogin.invoke(clazz));
            Method getNoNeedRight = clazz.getClass().getMethod("getNoNeedRight");
            noNeedRight = Arrays.asList((String[]) getNoNeedRight.invoke(clazz));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        if (noNeedLogin.contains("*")) {
            return true;
        }

        UserPo userPo = (UserPo) req.getSession().getAttribute(SessionConstant.USER_INSTANCE);

        if (noNeedLogin.contains(pathInfo.getAction())) {
            // 允许匿名
            return true;
        } else if (noNeedRight.contains(pathInfo.getAction())) {
            // 需要登录，不需要鉴权
            return userPo != null;
        } else {
            // 需要鉴权
            return RoleEnum.ADMIN.getValue().equals(userPo.getRole());
        }
    }

    public static <T extends HttpServlet> void actionDispatcher(T clazz, HttpServletRequest req,
        HttpServletResponse resp) {
        PathInfo pathInfo = UrlUtil.parsePathInfo(req.getRequestURI());

        logger.info(String.format("actionDispatcher: %s", pathInfo));
        setAttrs(req, pathInfo);

        if (!isAuthor(clazz, req, resp)) {
            throw new UnauthorizedException("Access Denied");
        }
        dispatch(pathInfo, clazz, req, resp);
    }
}
