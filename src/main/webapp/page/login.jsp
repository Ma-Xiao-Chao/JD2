<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/14
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>京东(JD.COM)-正品低价、品质保证</title>
    <link rel="icon" href="/static/pic/1.png" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="/static/css/login.css">
</head>
<body>
<!--<script type="text/javascript" src="/static/js/login.js"></script>-->
<script type="text/javascript" src="/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/static/js/login.js"></script>
<%--容器--%>
<div class="container">
    <%--行--%>
    <div class="row row2">
        <div class="col-md-6 col-md-offset-5 font">欢迎登录</div>
        <br><br><br>
        <%--列--%>
        <div class="col-md-6 col-md-offset-3">
            <%--表单--%>
            <form id="frm" class="form-horizontal" action="/user?action=login" method="post">
                <%--username--%>
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">username</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control input" id="username" name="username"
                               placeholder="username">
                        <span class="help-block"></span>
                    </div>
                </div>
                <%--password--%>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control input" id="password" name="password"
                               placeholder="password">
                        <span class="help-block"></span>
                    </div>
                </div>
                <div class="form-group denglu">
                    <div class="col-sm-offset-2 col-sm-10 denglu">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Remember me
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group denglu">
                    <div class="col-sm-offset-2 col-sm-10 denglu">
                        <button type="submit" class="btn btn-default">sign in</button>
                        <a id="zhucefont" href="/page/regist.jsp">没有账号?点击注册</a>
                        <a id="shouye" href="/catalog">首页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <%--列--%>
        <div class="col-md-6 col-md-offset-5">
            <div class="err">
                <%=request.getAttribute("err") == null ? "" : request.getAttribute("err")%>
            </div>
            <script>

                if (<%=request.getAttribute("err") != null%>) {
                    if (<%=request.getAttribute("err") == "登录成功"%>){
                    }else {
                        $(".err").css("color","#c8121d")
                    }
                }
            </script>
        </div>
</body>
</html>

