<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/24
  Time: 9:14
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
        <link type="text/css" rel="stylesheet" href="/static/css/orderList.css">
</head>
<body>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<%--<script type="text/javascript" src="/static/js/空.js"></script>--%>
<div class="container-fluid">
    <div class="row">
        <table class="table table-hover">
            <caption style="font-size: 20px">订单列表</caption>
            <%--            <caption style="font-size: 16px">填写并核对订单信息</caption>--%>
            <caption style="text-align: right;font-size: 20px"><a id="shouye" href="/catalog;">首页</a></caption>
            <thead>
            <tr>
                <th>序号</th>
                <th>收件人</th>
                <th>收件地址</th>
                <th>电话</th>
                <th>邮编</th>
                <th>总价</th>
                <th>订单状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${requestScope.orderinfo}" varStatus="index">
                <tr>
                    <th class="c1">${index.count}</th>
                    <th class="c1">${order.acceptName}</th>
                    <th class="c1">${order.address}</th>
                    <th class="c1">${order.phone}</th>
                    <th class="c1">${order.zip}</th>
                    <th class="c1 money">￥${order.zprice}</th>
                    <th class="c1">${order.status}</th>
                    <th class="c1"><a href="/order?action=orderDetail&oid=${order.oid}">详情</a></th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
