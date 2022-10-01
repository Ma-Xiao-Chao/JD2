<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/15
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insert</title>
    <link type="text/css" rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>

</head>
<body>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/adminupdate.js"></script>
<div class="container-fluid">
    <form id="frm" action="/admin?action=all1" method="get">
        <input name="action" style="display: none" value="insert">
    <%--    第一行 页面上方显示文字--%>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="page-header">
                    <h1>insert <small>catalog</small></h1>
                </div>
            </div>
            <div class="col-md-3">
                <div>
                    <ul class="pagination">
                        <li style="margin-top: 10px"><a href="/admin?action=all1">首页</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <%--        第二行--%>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <%--            name--%>
                <div class="form-group input">
                    <label for="cname">cname</label>
                    <input type="text" class="form-control" name="cname" id="cname" placeholder="cname">
                    <span class="help-block"></span>
                </div>
                <%--            url--%>
                <div class="form-group input">
                    <label for="url">url</label>
                    <input type="text" class="form-control" name="url" id="url" placeholder="url">
                    <span class="help-block"></span>
                </div>
                <%--            level--%>
                <div class="form-group input">
                    <label for="level">level</label>
                    <input type="text" class="form-control" name="level" id="level" placeholder="level">
                    <span class="help-block"></span>
                </div>
                <%--            parent--%>
                <div class="form-group input">
                    <label for="parent">parent</label>
                    <input type="text" class="form-control" name="parent" id="parent" placeholder="parent">
                    <span class="help-block"></span>
                </div>
                <%--            line--%>
                <div class="form-group input">
                    <label for="line">line</label>
                    <input type="text" class="form-control" name="line" id="line" placeholder="line">
                    <span class="help-block"></span>
                </div>
            </div>
        </div>
        <%--    第三行按钮--%>
        <div class="row">
            <div class="col-md-2 col-md-offset-5">
                <br><br>
                <input class="submit" type="submit" class="btn btn-default" type="submit" value="添加">
            </div>
        </div>
<%--            第四行结果--%>
        <div class="row">
            <div class="col-md-2 col-md-offset-5">
                <br><br>
                ${requestScope.result}
            </div>
        </div>
    </form>
</div>

</body>
</html>
