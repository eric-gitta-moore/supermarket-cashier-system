<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="userInstance" scope="session" type="com.exam.supermarket.po.UserPo"/>
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
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                </tr>
                </tbody>
            </table>
            <nav>
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled"><a class="page-link" href="#">上一页</a></li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">下一页</a></li>
                </ul>
            </nav>
        </div>

        <div class="col-3">
            <div class="card ">
                <div class="card-header">
                    我的
                </div>
                <div class="card-body">
                    用户名：${userInstance.username}
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./common/footer.jsp"/>
</body>
</html>
