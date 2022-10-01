<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/19
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>京东(JD.COM)-正品低价、品质保证</title>
    <link rel="icon" href="/static/pic/1.png" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="/static/css/goodsType.css">
</head>
<body>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<div class="container-fluid out">
    <div class="in1">
        <c:forEach var="goods" items="${requestScope.goods}">
            <a href="/goods?action=xiangqing&gid=${goods.gid}">
                <div class="in">
                    <div class="in2 pic"><img src="${goods.pic1}"></div>
                    <div class="in2 font">${goods.gname}</div>
                    <div class="in2 price">¥${goods.price}</div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
</body>
</html>
