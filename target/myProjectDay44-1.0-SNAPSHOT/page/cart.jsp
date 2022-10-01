<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/21
  Time: 17:49
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
    <link type="text/css" rel="stylesheet" href="/static/css/cart.css">
</head>
<body>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<div class="container-fluid">
    <div class="row">
        <table class="table table-hover">
            <caption style="font-size: 20px">购物车</caption>
            <caption style="text-align: right;font-size: 20px"><a id="shouye" href="/catalog;">首页</a></caption>
            <thead>
            <tr>
                <th class="k1"><input type="checkbox">全选</th>
                <th class="k1">序号</th>
                <th class="k3">商品</th>
                <th class="k2money">单价</th>
                <th class="k2-1"></th>
                <th class="k2">数量</th>
                <th class="k2-1"></th>
                <th class="k2">小计</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody class="tbody">
            <tr>
                <th></th>
            </tr>
            <c:forEach var="cart" items="${sessionScope.cart}" varStatus="index">
                <tr>
                    <th><input type="checkbox"></th>
                    <th>${index.count}</th>
                    <th class="picfont"><img width="60px" src="/${cart.value.goods.pic1}"> ${cart.value.goods.gname}
                    </th>
                    <th>¥<span class="danjia" id="danjia${index.count}">${cart.value.goods.price}</span></th>
                    <th class="addsub"><input type="button" value="-"
                                              onclick="subOne(${cart.value.goods.gid},${index.count})"></th>
                        <%--                                <th class="k2 k2-2">${cart.key}</th>--%>
                    <th class="k2 k2-2"><input type="text" class="num" id="num${index.count}" value="${cart.value.num}"
                                               style="width: 50px;text-align: center;"></th>
                    <th class="addsub"><input type="button" value="+"
                                              onclick="addOne(${cart.value.goods.gid},${index.count})"></th>
                    <th class="k2money">
                        ¥<span class="xiaoji" id="xiaoji${index.count}"></span>
                    </th>
                    <th><a href="javascript:del(${cart.key})">删除</a></th>
                </tr>
            </c:forEach>
            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th style="font-size: 12px;text-align: left">总计:¥<span id="zongji" style="color: red;font-size: 15px"></span></th>
                <th><a href="javascript:herf1()"><input type="button" style="background-color: red;color: white" value="去结算"></a></th>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
<script>
    // function subOne(gid) {
    //     window.location.href = "/cart?action=subOne&gid=" + gid
    // }
    function subOne(gid, index) {
        if (parseInt(document.getElementById("num" + index).value) == 1) {
            del(gid)
        } else {
            var xhr = new XMLHttpRequest();
            xhr.open("get", "/cart?action=subOne&gid=" + gid)
            xhr.send()
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    var res = JSON.parse(xhr.responseText)
                    // res=xhr.responseText
                    var num = document.getElementById("num" + index)
                    num.value = res
                    // num.
                    var xiaoji = document.getElementById("xiaoji" + index)
                    // alert(2)
                    xiaoji.innerText = parseInt(document.getElementById("danjia" + index).innerText) * parseInt(document.getElementById("num" + index).value)


                    var zongji = document.getElementById("zongji");
                    zongji.innerText=parseInt(zongji.innerText)-parseInt(document.getElementById("danjia" + index).innerText)
                }
            }
        }

    }


    function addOne(gid, index) {
        var xhr = new XMLHttpRequest();
        xhr.open("get", "/cart?action=addOne&gid=" + gid)
        xhr.send()
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                var res = JSON.parse(xhr.responseText)
                // res=xhr.responseText
                var num = document.getElementById("num" + index)
                num.value = res

                //小计
                // num.
                var xiaoji = document.getElementById("xiaoji" + index)
                // alert(2)
                xiaoji.innerText = parseInt(document.getElementById("danjia" + index).innerText) * parseInt(document.getElementById("num" + index).value)
                //总计
                var zongji = document.getElementById("zongji");
                zongji.innerText=parseInt(zongji.innerText)+parseInt(document.getElementById("danjia" + index).innerText)

                // location.reload()
            }
        }
    }

    //
    // function addOne(gid) {
    //     window.location.href = "/cart?action=addOne&gid=" + gid
    // }

    function del(key) {
        if (confirm("确认删除?")) {
            window.location.href = "/cart?action=del&gid=" + key
        }
    }



    var xiaoji = document.getElementsByClassName("xiaoji")
    var zongji = document.getElementById("zongji");
    var sum=0;
    for (var x in xiaoji) {
        xiaoji[x].innerHTML = parseInt(document.getElementsByClassName("danjia")[x].innerText) * parseInt(document.getElementsByClassName("num")[x].value)
        if (x<xiaoji.length){
            sum=sum+parseInt(xiaoji[x].innerText)
        }
        // alert(sum)
    }
    zongji.innerText=parseInt(sum)

    function herf1() {
        window.location.href="/cart?action=jiesuan&sum="+parseInt(zongji.innerText)
    }
</script>

