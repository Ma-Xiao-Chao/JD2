<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/14
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>京东(JD.COM)-正品低价、品质保证</title>
    <link rel="icon" href="/static/pic/1.png" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="/static/css/goods.css">
</head>
<body>
<script type="text/javascript" src="/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/static/js/goods.js"></script>

<div id="outer">
    <!--    左边,放大小图-->
    <div class="in" id="left">
        <div id="pic1"><img id="ppp1" src="${goods.pic1}"></div>
        <%--        <div id="pic1"><img id="ppp1" src=""></div>--%>
        <div class="inpic" id="pic2"><img src="${goods.pic2}"></div>
        <div class="inpic" id="pic3"><img src="${goods.pic3}"></div>
        <div class="inpic" id="pic4"><img src="${goods.pic4}"></div>
    </div>

    <!--    右边信息-->
    <div class="in" id="right">
        <div style="text-align: right;font-size: 20px;margin-left: 400px">
            <a id="shouye" href="/catalog;">首页</a>
        </div>
        <div class="in2 gname">${goods.gname}</div>

        <div class="in2 gprice">京东价 ¥${goods.price}</div>
        <br><br><br>
        <a id="aCart" href="/cart?action=add&gid=${goods.gid}">
            <div class="in2 gouwuche">加入购物车</div>
        </a>
        <div class="err">
            <a href="/page/login.jsp">
                <%=request.getAttribute("err1") == null ? "" : request.getAttribute("err1")%>
            </a>
        </div>
    </div>
</div>

<%--<script>--%>
<%--    var gid = window.location.search;--%>
<%--    var xhr = new XMLHttpRequest();--%>
<%--    alert(gid)--%>
<%--    xhr.open("get","/goods"+gid+"&action=xiangqing")--%>
<%--    // alert(1)--%>
<%--    xhr.send()--%>
<%--    xhr.onreadystatechange=function(){--%>
<%--        // alert(xhr.readyState)--%>
<%--        if (xhr.readyState==4 && xhr.status==200){--%>
<%--            var g = xhr.responseText;--%>
<%--            var goods=JSON.parse(g)--%>
<%--            alert("2")--%>
<%--            // $("#pic1").innerHTML="<img src=\"goods.pic1\">"--%>
<%--            document.getElementById("ppp1").src=goods.pic1--%>

<%--        }--%>

<%--    }--%>


<%--</script>--%>

<!--隐藏层-->
<div id="goodsycc">
</div>
</body>
</html>
