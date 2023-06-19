<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="pathInfo" type="com.exam.core.common.metadata.PathInfo"--%>
<%--@elvariable id="fields" type="java.util.Map<java.lang.String,com.exam.supermarket.metadata.FieldDescriptor>"--%>
<html>
<head>
    <jsp:include page="../common/head.jsp"/>
    <jsp:include page="../common/static.jsp"/>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-10 mt-3">
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
                                    action="/${pathInfo.controller}/save?${pageQuery}&id=${record.id}"
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
                                                           href="/${pathInfo.controller}/edit?${pageQuery}&id=${record.id}"
                                                    >修改</a>
                                                    </li>
                                                    <li><a class="dropdown-item"
                                                           href="/${pathInfo.controller}/delete?${pageQuery}&id=${record.id}"
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
                            <jsp:param name="uri" value="/${pathInfo.controller}"/>
                        </jsp:include>
                    </nav>
                </div>

                <div class="col-3">
                    <c:if test="${userInstance.role=='admin'}">
                        <jsp:include page="../components/cardAct.jsp"></jsp:include>
                    </c:if>
                    <jsp:include page="./components/stats.jsp"></jsp:include>
                    <jsp:include page="../components/cardMy.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>
