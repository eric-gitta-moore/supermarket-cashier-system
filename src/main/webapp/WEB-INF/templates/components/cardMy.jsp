<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card mt-3">
    <div class="card-header">
        我的
    </div>
    <div class="card-body">
        <%--@elvariable id="userInstance" type="com.exam.supermarket.po.UserPo"--%>
        用户名：${userInstance.username}
    </div>
</div>