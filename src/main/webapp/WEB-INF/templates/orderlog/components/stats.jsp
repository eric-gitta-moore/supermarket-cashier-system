<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="stats" type="com.exam.supermarket.dto.OrderlogStatsVo"--%>
<div class="card mt-3">
    <div class="card-header">
        统计信息
    </div>
    <div class="card-body">
        <p class="h6">近30日交易流水：${stats.monthTransaction}</p>
        <p class="h6">近30日交易订单数：${stats.monthOrderCount}</p>
        <p class="h6">总交易流水：${stats.totalTransaction}</p>
        <p class="h6">总交易订单数：${stats.totalOrderCount}</p>
    </div>
</div>