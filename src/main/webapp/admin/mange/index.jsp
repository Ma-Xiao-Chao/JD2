<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/9
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>--index--</title>
    <link type="text/css" rel="stylesheet" href="/admin/mange/stataic/boostrap/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="/admin/mange/stataic/css/index.css">
</head>
<body>
<script type="text/javascript" src="/admin/mange/stataic/boostrap/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/admin/mange/stataic/boostrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/admin/mange/stataic/js/index.js"></script>

<div class="container-fluid">
    <%--    第一行 页面上方显示文字--%>
    <div class="row">
        <div class="col-md-0">
            <div class="page-header">
                <h1>Welcome <small>my admin page</small></h1>
            </div>
        </div>
    </div>
    <%--    第二行--%>
    <div class="row">
        <%--        左边--%>
        <div class="col-md-2">
            <div class="btn-group-vertical" role="group" aria-label="...">
                <%--用户管理--%>
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default btn-lg dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                        用户管理
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li class="usersInfo"><a href="#">用户信息</a></li>
                        <li class="usersInfo"><a href="#">#</a></li>
                        <li class="usersInfo"><a href="#">#</a></li>
                        <li class="usersInfo"><a href="#">#</a></li>
                    </ul>
                </div>
                <%--商品管理--%>
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default btn-lg dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                        商品管理
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li class="goodsInfo"><a href="#">菜单管理</a></li>
                        <li class="goodsInfo"><a href="#">商品管理</a></li>
                        <li class="goodsInfo"><a href="#">订单管理</a></li>
                        <li class="goodsInfo"><a href="#">#</a></li>
                    </ul>
                </div>
                <%-- 退出--%>
                <div class="btn-group " role="group">
                    <button type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        退出系统
                    </button>
                </div>
            </div>
        </div>
        <%--    右边--%>
        <div class="col-md-10 right">
            <iframe id="rightFrame" src="/admin/mange/welcome.jsp"></iframe>
        </div>
    </div>

</div>

</body>
</html>
