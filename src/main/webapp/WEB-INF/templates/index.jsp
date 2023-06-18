<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <jsp:include page="./common/head.jsp"/>
    <jsp:include page="./common/static.jsp"/>
</head>
<body>
<jsp:include page="./common/header.jsp"/>
<div class="container mt-3">
    <div class="row">
        <div class="col-9">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">商品名</th>
                    <th scope="col">价格</th>
                    <th scope="col">库存</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="goods" type="java.util.List<com.exam.supermarket.po.GoodPo>"--%>
                <c:forEach items="${goods}" var="item">
                    <%--@elvariable id="uri" type="java.lang.String"--%>
                    <%--@elvariable id="pageQuery" type="java.lang.String"--%>
                    <form action="${uri}?${pageQuery}&act=save&id=${item.id}" method="post">
                        <tr>

                            <th scope="row">${item.id}</th>
                            <c:if test="${param.id!=item.id}">
                                <td>${item.name}</td>
                                <td>${item.price}</td>
                                <td>${item.stock}</td>
                            </c:if>
                            <c:if test="${param.act=='change' && param.id==item.id}">
                                <td>
                                    <input class="form-control" type="text" name="name" value="${item.name}">
                                </td>
                                <td>
                                    <input class="form-control" type="text" name="price" value="${item.price}">
                                </td>
                                <td>
                                    <input class="form-control" type="text" name="stock" value="${item.stock}">
                                </td>
                            </c:if>
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
                                                   href="${uri}?${pageQuery}&act=change&id=${item.id}">修改</a></li>
                                            <li><a class="dropdown-item"
                                                   href="${uri}?${pageQuery}&act=delete&id=${item.id}">删除</a></li>
                                        </ul>
                                    </div>
                                </c:if>
                                <c:if test="${param.act=='change' && param.id==item.id}">
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
                                            <li><a class="dropdown-item" href="${uri}?${pageQuery}">取消</a></li>
                                        </ul>
                                    </div>
                                </c:if>
                            </td>

                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
            <nav>
                <%--@elvariable id="pagination" type="com.exam.core.common.metadata.IPage"--%>
                <%--@elvariable id="uri" type="java.lang.String"--%>
                <jsp:include page="./components/pagination.jsp">
                    <jsp:param name="total" value="${pagination.total}"/>
                    <jsp:param name="current" value="${pagination.current}"/>
                    <jsp:param name="pages" value="${pagination.pages}"/>
                    <jsp:param name="size" value="${pagination.size}"/>
                    <jsp:param name="hasWapper" value="${true}"/>
                    <jsp:param name="showSize" value="3"/>
                    <jsp:param name="pageParamName" value="page"/>
                    <jsp:param name="sizeParamName" value="size"/>
                    <jsp:param name="uri" value="${uri}"/>
                </jsp:include>
            </nav>
        </div>

        <div class="col-3">
            <div class="card ">
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
<jsp:include page="./common/footer.jsp"/>
</body>
</html>
