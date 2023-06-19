<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="pathInfo" type="com.exam.core.common.metadata.PathInfo"--%>
<div class="card">
    <div class="card-header">
        操作
    </div>
    <div class="card-body d-flex flex-wrap gap-2">
        <a class="btn btn-primary" href="/${pathInfo.controller}/add">新增</a>
        <a class="btn btn-success" href="/${pathInfo.controller}/exportXls">导出Excel</a>
        <button class="btn btn-success" onclick="$('#importXls').click()">导入Excel</button>
    </div>
    <div style="display: none">
        <form action="/${pathInfo.controller}/importXls" method="post" enctype="multipart/form-data" target="_blank"
              id="importXlsFrom">
            <input type="file" name="file" accept=".xlsx" id="importXls">
        </form>
    </div>
    <script>
        $(document).ready(function init() {
            $('#importXls').on('change', function () {
                $('#importXlsFrom').submit()
            });
        })
    </script>
</div>