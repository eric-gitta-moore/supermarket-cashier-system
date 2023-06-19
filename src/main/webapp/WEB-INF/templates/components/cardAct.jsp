<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="pathInfo" type="com.exam.core.common.metadata.PathInfo"--%>
<div class="card">
    <div class="card-header">
        操作
    </div>
    <div class="card-body">
        <a class="btn btn-success" href="/${pathInfo.controller}/add">新增</a>
    </div>
</div>