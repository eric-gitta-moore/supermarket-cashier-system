<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="payable" type="java.lang.Integer"--%>
<%--@elvariable id="userInstance" type="com.exam.supermarket.po.UserPo"--%>
<%--@elvariable id="pathInfo" type="com.exam.core.common.metadata.PathInfo"--%>
<%--@elvariable id="goodIds" type="java.lang.String"--%>
<%--@elvariable id="records" type="java.util.List<com.exam.supermarket.vo.CashierGoodVo>"--%>
<%--@elvariable id="fields" type="java.util.Map<java.lang.String,com.exam.supermarket.metadata.FieldDescriptor>"--%>
<html>
<head>
    <jsp:include page="../common/head.jsp"/>
    <jsp:include page="../common/static.jsp"/>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container mt-3 ">
    <div class="row justify-content-center">
        <div class="col-3">
            <div class="card ">
                <div class="card-header">
                    操作员
                </div>
                <div class="card-body">
                    <p class="h6">用户名：${userInstance.username}</p>
                    <p class="h6">权限：${userInstance.role}</p>
                </div>
            </div>

            <div class="card mt-3">
                <div class="card-header">
                    操作
                </div>
                <div class="card-body">
                    <form action="/cashier/add" method="post">
                        <input type="text" hidden="hidden" value="${goodIds}" name="goodIds">
                        <div class="mb-3">
                            <label for="good" class="form-label">货号</label>
                            <input type="number" class="form-control" id="good" name="good" required>
                        </div>
                        <button class="btn btn-outline-primary">添加</button>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-6">
            <div class="card">
                <div class="card-header">收银台</div>
                <div class="card-body">
                    <table class="table align-middle">
                        <thead>
                        <tr>
                            <c:forEach items="${fields.values()}" var="item">
                                <th>${item.tableHeaderLabel}</th>
                            </c:forEach>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${records}" var="record">
                            <tr>
                                <c:forEach items="${fields.values()}" var="fieldDesc">
                                    <td>${record[fieldDesc.fieldName]}</td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="col-3">

            <div class="card ">
                <div class="card-header">
                    提交订单
                </div>
                <div class="card-body">
                    <form action="/cashier/submit" method="post">
                        <input type="text" hidden="hidden" value="${goodIds}" name="goodIds">
                        <div class="mb-3">
                            <label for="vip" class="form-label">VIP卡号（可留空）</label>
                            <input type="text" class="form-control" id="vip" name="vip">
                        </div>
                        <div class="mb-3">
                            <label for="payable" class="form-label">应付金额</label>
                            <input type="text" class="form-control" id="payable" value="${payable}" readonly>
                        </div>
                        <button class="btn btn-success">提交</button>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>
