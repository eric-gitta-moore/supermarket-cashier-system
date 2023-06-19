<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.stream.*" %>

<%
    List<Integer> pageNums;
    int current = Integer.parseInt(request.getParameter("current"));
    int pages = Integer.parseInt(request.getParameter("pages"));

    // 必须是奇数
    int showSize = Integer.parseInt(request.getParameter("showSize"));
    if (showSize % 2 == 0) {
        showSize++;
    }
    boolean isFirst = current <= 1;
    boolean isEnd = current >= pages;

    if (!isFirst && !isEnd) {
        // 中间页
        int offset = (showSize - 1) / 2;
        int[] res = IntStream.rangeClosed(current - offset, current + offset).toArray();
        pageNums = Arrays.stream(res).boxed().toList();
    } else if (isFirst && !isEnd) {
        // 首页
        int offset = (showSize - 1);
        int[] res = IntStream.rangeClosed(current, Math.min(pages, current + offset)).toArray();
        pageNums = Arrays.stream(res).boxed().toList();
    } else {
        // 尾页
        int offset = (showSize - 1);
        int[] res = IntStream.rangeClosed(Math.max(1, current - offset), pages).toArray();
        pageNums = Arrays.stream(res).boxed().toList();
    }
%>
<c:if test="${param.hasWapper}">
    <ul class="pagination justify-content-center">
</c:if>

<li class="page-item">
    <a class="page-link"
       href="${param.uri}?${param.pageParamName}=1&${param.sizeParamName}=${param.size}"
    >首页</a>
</li>

<li class="page-item <c:if test="${param.current<=1}">disabled</c:if>">
    <a class="page-link"
       href="${param.uri}?${param.pageParamName}=${param.current-1}&${param.sizeParamName}=${param.size}"
    >上一页</a>
</li>

<c:forEach items="<%=pageNums%>" var="num">
    <li class="page-item  <c:if test="${num==param.current}">active</c:if>">
        <a class="page-link"
           href="${param.uri}?${param.pageParamName}=${num}&${param.sizeParamName}=${param.size}"
        >${num}</a>
    </li>
</c:forEach>

<li class="page-item <c:if test="${param.current>=param.pages}">disabled</c:if>">
    <a class="page-link"
       href="${param.uri}?${param.pageParamName}=${param.current+1}&${param.sizeParamName}=${param.size}"
    >下一页</a>
</li>

<li class="page-item">
    <a class="page-link"
       href="${param.uri}?${param.pageParamName}=${param.pages}&${param.sizeParamName}=${param.size}"
    >末页</a>
</li>

<c:if test="${param.hasWapper}">
    </ul>
</c:if>