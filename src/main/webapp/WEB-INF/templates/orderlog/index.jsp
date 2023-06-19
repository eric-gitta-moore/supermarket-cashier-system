<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="action" type="java.lang.String"--%>
<%--@elvariable id="pathInfo" type="com.exam.core.common.metadata.PathInfo"--%>
<%--@elvariable id="fields" type="java.util.Map<java.lang.String,com.exam.supermarket.metadata.FieldDescriptor>"--%>
<html>
<head>
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
                    <c:forEach items="${fields.values()}" var="item">
                        <th>${item.tableHeaderLabel}</th>
                    </c:forEach>
                    <c:if test="${userInstance.role=='admin'}">
                        <th>操作</th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="records" type="java.util.List<com.exam.supermarket.po.GoodPo>"--%>
                <c:forEach items="${records}" var="record">
                    <%--@elvariable id="pageQuery" type="java.lang.String"--%>
                    <form
                            action="<c:url value="/${pathInfo.controller}/save?${pageQuery}&id=${record.id}"/>"
                            method="post">
                        <tr>

                            <c:forEach items="${fields.values()}" var="fieldDesc">
                                <td>${record[fieldDesc.fieldName]}</td>
                            </c:forEach>

                                <%-- 操作 --%>
                            <c:if test="${userInstance.role=='admin'}">
                                <td>
                                    <div class="btn-group" role="group">
                                        <button type="button" class="btn btn-primary dropdown-toggle"
                                                data-bs-toggle="dropdown"
                                                aria-expanded="false">
                                            操作
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a class="dropdown-item"
                                                   href="<c:url value="/${pathInfo.controller}/change?${pageQuery}&id=${record.id}"/>"
                                            >修改</a>
                                            </li>
                                            <li><a class="dropdown-item"
                                                   href="<c:url value="/${pathInfo.controller}/delete?${pageQuery}&id=${record.id}"/>"
                                            >删除</a></li>
                                        </ul>
                                    </div>
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
                        <a class="btn btn-success" href="/${pathInfo.controller}/add">新增</a>
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
