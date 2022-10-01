<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/14
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>data</title>
    <link type="text/css" rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
</head>
<body>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<%--//删除按钮弹框--%>
<script>
    $(function () {
        $(".delBtn").each(function () {
            $(this).click(function () {
/*                if (confirm('确认删除')) {
                    return true;
                } else {
                    return false;
                }*/
                return confirm('确认删除?');
            })
        })
    })
</script>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <table class="table  table-hove">
                <caption>菜单信息</caption>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>地址</th>
                    <th>级别</th>
                    <th>父级别</th>
                    <th>行号</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody class="tbody">
                <c:forEach var="catalog" items="${clist}">
                    <tr>
                        <th>${catalog.cname}</th>
                        <th>${catalog.url}</th>
                        <th>${catalog.level}</th>
                        <th>${catalog.parent}</th>
                        <th>${catalog.line}</th>
                        <th><a href="/admin?action=delete&id=${catalog.cid}&page=${requestScope.page1}" class="delBtn">删除</a>
                            <a href="/admin?action=one&id=${catalog.cid}&page=${requestScope.page1}">/修改</a>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="/admin?action=all1&page=1">首页</a></li>
                    <li><a href="/admin?action=all1&page=${requestScope.page1-1}">上页</a></li>
                    <li><a href="/admin?action=all1&page=${requestScope.page1+1}">下页</a></li>
                    <li><a href="/admin?action=all1&page=${requestScope.total}">末页</a></li>
                    <li><a href="#">${requestScope.page1}/${requestScope.total}</a></li>
                </ul>
            </nav>
        </div>
        <div class="col-md-3 col-md-offset-1">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="/admin/insert.jsp?">添加</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
