<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">导航栏</a>
        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/cashier"/>">收银台</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/index"/>">商品管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/user"/>">会员管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/orderlog"/>">订单管理</a>
                </li>
            </ul>
            <a href="<c:url value="/login/logout"/>" class="btn btn-info">退出登录</a>
        </div>
    </div>
</nav>