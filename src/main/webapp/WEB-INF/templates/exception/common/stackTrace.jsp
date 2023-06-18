<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="errorMsg" type="java.lang.String"--%>
<h1>${errorMsg}</h1>
<div class="stack-trace">
    <%--@elvariable id="stackTrace" type="java.lang.String"--%>
    ${stackTrace}
</div>
