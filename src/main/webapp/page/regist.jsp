<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/14
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>京东(JD.COM)-正品低价、品质保证</title>
    <link rel="icon" href="/static/pic/1.png" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="/static/css/regist.css">
</head>
<body>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/regist.js"></script>
<div class="container">
    <%--行--%>
    <div class="row row2">
        <div class="col-md-6 col-md-offset-3 font">欢迎注册</div>
        <br><br><br>
        <form id="frm" action="/user?action=regist" method="post">
            <div class="form-group">
                <label for="uname">username</label>
                <input type="text" class="form-control" name="username" id="uname" placeholder="username">
                <span class="help-block"></span>
            </div>


            <div class="form-group">
                <label for="upass">Password</label>
                <input type="password" class="form-control" name="password" id="upass" placeholder="Password">
                <span class="help-block"></span>

            </div>


            <div class="form-group">
                <label for="ubirth">birth</label>
                <input type="date" class="form-control" name="birth" id="ubirth" placeholder="birthday">
                <span class="help-block"></span>
            </div>


            <div class="form-group">
                <label for="mail">umail</label>
                <input type="email" class="form-control" name="mail" id="mail" placeholder="mial">
                <span class="help-block"></span>
            </div>
            <div class="submitbtn">
                <button type="submit" class="btn btn-default">Submit</button>
                <a id="zhucefont" href="/page/login.jsp">去登录</a>
            </div>
            <div class="res">
                <%=request.getAttribute("res") == null ? "" : request.getAttribute("res")%>
                <script>
                    if (<%=request.getAttribute("res") != null%>) {
                        if (<%=request.getAttribute("res") == "add success"%>){
                        }else {
                            $(".res").css("color","#c8121d")
                        }
                    }
                </script>
            </div>
        </form>
    </div>
</div>
</body>
</html>
