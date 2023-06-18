<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="action" type="java.lang.String"--%>
<%--@elvariable id="controllerPath" type="java.lang.String"--%>
<html>
<head>
    <title>会员管理</title>
    <jsp:include page="../common/head.jsp"/>
    <jsp:include page="../common/static.jsp"/>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container mt-3">
    <div class="row">
        <div class="col-9">
            <table class="table align-middle">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">用户名</th>
                    <th scope="col">昵称</th>
                    <th scope="col">角色</th>
                    <th scope="col">会员卡</th>
                    <c:if test="${userInstance.role=='admin'}">
                        <th scope="col">操作</th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="goods" type="java.util.List<com.exam.supermarket.po.GoodPo>"--%>
                <c:forEach items="${goods}" var="item">
                    <%--@elvariable id="pageQuery" type="java.lang.String"--%>
                    <form
                            action="<c:url value="/${controllerPath}/save?${pageQuery}&id=${item.id}"/>"
                            method="post">
                        <tr>

                            <th scope="row">${item.id}</th>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                            <td>${item.stock}</td>

                                <%-- 操作 --%>
                            <c:if test="${userInstance.role=='admin'}">
                                <td>
                                    <c:if test="${param.id!=item.id}">
                                        <div class="btn-group" role="group">
                                            <button type="button" class="btn btn-primary dropdown-toggle"
                                                    data-bs-toggle="dropdown"
                                                    aria-expanded="false">
                                                操作
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item"
                                                       href="<c:url value="/${controllerPath}/change?${pageQuery}&id=${item.id}"/>"
                                                >修改</a>
                                                </li>
                                                <li><a class="dropdown-item"
                                                       href="<c:url value="/${controllerPath}/delete?${pageQuery}&id=${item.id}"/>"
                                                >删除</a></li>
                                            </ul>
                                        </div>
                                    </c:if>
                                    <c:if test="${action=='change' && param.id==item.id}">
                                        <div class="btn-group" role="group">
                                            <button type="button" class="btn btn-outline-success dropdown-toggle"
                                                    data-bs-toggle="dropdown"
                                                    aria-expanded="false">
                                                操作
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li>
                                                    <button class="dropdown-item">保存</button>
                                                </li>
                                                <li><a class="dropdown-item"
                                                       href="<c:url value="/index?${pageQuery}"/>">取消</a></li>
                                            </ul>
                                        </div>
                                    </c:if>
                                </td>
                            </c:if>

                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
            <nav>
                <%--@elvariable id="pagination" type="com.exam.core.common.metadata.IPage"--%>
                <jsp:include page="../components/pagination.jsp">
                    <jsp:param name="total" value="${pagination.total}"/>
                    <jsp:param name="current" value="${pagination.current}"/>
                    <jsp:param name="pages" value="${pagination.pages}"/>
                    <jsp:param name="size" value="${pagination.size}"/>
                    <jsp:param name="hasWapper" value="${true}"/>
                    <jsp:param name="showSize" value="3"/>
                    <jsp:param name="pageParamName" value="page"/>
                    <jsp:param name="sizeParamName" value="size"/>
                    <jsp:param name="uri" value="/index"/>
                </jsp:include>
            </nav>
        </div>

        <div class="col-3">
            <c:if test="${userInstance.role=='admin'}">
                <div class="card">
                    <div class="card-header">
                        操作
                    </div>
                    <div class="card-body">
                        <a class="btn btn-success" href="/${controllerPath}/add">新增</a>
                    </div>
                </div>
            </c:if>
            <div class="card mt-3">
                <div class="card-header">
                    我的
                </div>
                <div class="card-body">
                    <%--@elvariable id="userInstance" type="com.exam.supermarket.po.UserPo"--%>
                    用户名：${userInstance.username}
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>
