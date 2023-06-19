<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="toast" type="com.exam.supermarket.vo.ToastVo"--%>
<div class="toast-container position-fixed bottom-0 end-0 p-3">
    <div class="toast <c:if test="${!empty toast.msg}">show</c:if> ">
        <div class="toast-header">
            <strong class="me-auto">${toast.title}</strong>
            <small>现在</small>
            <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
        </div>
        <div class="toast-body">
            ${toast.msg}
        </div>
    </div>
</div>