<%--@elvariable id="controllerPath" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
    <jsp:include page="../common/head.jsp"/>
    <jsp:include page="../common/static.jsp"/>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container mt-3">
    <div class="row justify-content-center">
        <div class="col-9">
            <div class="card">
                <div class="card-header">新增</div>
                <form class="card-body" action="/${controllerPath}/save" method="post">
                    <%--@elvariable id="fields" type="java.util.HashMap"--%>
                    <c:forEach items="${fields}" var="item">
                        <div class="row mb-3">
                            <label for="${item.key}" class="col-sm-2 col-form-label">${item.value}</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="${item.key}" name="${item.key}">
                            </div>
                        </div>
                    </c:forEach>
                    <div class="d-flex mb-3 justify-content-end">
                        <button class="btn btn-success mx-3">保存</button>
                        <a class="btn btn-outline-primary" href="javascript:history.back()">返回</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>