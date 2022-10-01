<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/25
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <button class="button" type="submit" onclick="x()" >退出登录</button>
</div>
</body>
</html>

<script>
    function x() {
        if (confirm("确认退出?")){
            var search = window.location.search;
            // alert(search)
            window.location.href="/user"+search+"&action=logout"
        }
    }
</script>


<style>
    .button{
        background-color: #c8121d;
        width: 100px;
        height: 50px;
        font-size: 20px;
        color: white;
        margin-left: 500px;
    }

</style>
