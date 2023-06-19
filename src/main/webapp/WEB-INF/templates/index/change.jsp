<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="pathInfo" type="com.exam.core.common.metadata.PathInfo"--%>
<%--@elvariable id="record" type="java.util.Map"--%>
<%--@elvariable id="fields" type="java.util.Map<java.lang.String,com.exam.supermarket.metadata.FieldDescriptor>"--%>
<html>
<head>
    <jsp:include page="../common/head.jsp"/>
    <jsp:include page="../common/static.jsp"/>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container mt-3">
    <div class="row justify-content-center">
        <div class="col-9">
            <div class="card">
                <div class="card-header">修改</div>
                <form class="card-body" action="/${pathInfo.controller}/save" method="post">

                    <input name="id" value="${record.get('id')}" hidden="hidden">

                    <c:forEach items="${fields.values()}" var="fieldDesc">
                        <div class="row mb-3">
                            <label for="${fieldDesc.fieldName}"
                                   class="col-sm-2 col-form-label">${fieldDesc.formLabel}</label>
                            <div class="col-sm-10">
                                <input type="text"
                                       class="form-control"
                                       id="${fieldDesc.fieldName}"
                                <c:if test="${fieldDesc.fieldName!='id'}">
                                       name="${fieldDesc.fieldName}"
                                </c:if>
                                       value="${record.get(fieldDesc.fieldName)}"
                                       <c:if test="${fieldDesc.disabled}">disabled</c:if>
                                       <c:if test="${fieldDesc.required}">required</c:if>
                                       <c:if test="${fieldDesc.readonly}">readonly</c:if>
                                >
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