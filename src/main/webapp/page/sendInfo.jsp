<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/23
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8" isELIgnored="false"--%>
<%--%>--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>京东(JD.COM)-正品低价、品质保证</title>
    <link rel="icon" href="/static/pic/1.png" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="/static/css/sendInfo.css">
</head>
<body>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/空.js"></script>
<div class="container-fluid">
    <form id="frm" action="/cart?action=cart2db" method="post">
        <div class="row">
            <table class="table table-hover">
                <caption style="font-size: 20px">结算页</caption>
                <%--            <caption style="font-size: 16px">填写并核对订单信息</caption>--%>
                <caption style="text-align: right;font-size: 20px"><a id="shouye" href="/catalog;">首页</a></caption>
                <thead>
                <tr>
                    <th>填写并核对订单信息</th>
                    <th></th>
                </tr>
                </thead>
                <tbody class="tbody">
                <tr>
                    <th>收货人信息</th>
                    <th>
                        <font class="font">收件人:</font>
                        <br>
                        <div class="input-group input-group-sm">
                            <input type="text" id="name" class="form-control" name="acceptName" placeholder="name"
                                   aria-describedby="sizing-addon3">
                            <span class="help-block"></span>
                        </div>
                        <br>
                        <font class="font">收货地址:</font>
                        <br>
                        <div class="input-group input-group-sm">
                            <input type="text" id="address" class="form-control" name="address" placeholder="address"
                                   aria-describedby="sizing-addon3">
                            <span class="help-block"></span>
                        </div>
                        <br>
                        <font class="font">联系电话:</font>
                        <br>
                        <div class="input-group input-group-sm">
                            <input type="text" id="phone" class="form-control" name="phone" placeholder="phone"
                                   aria-describedby="sizing-addon3">
                            <span class="help-block"></span>
                        </div>
                        <br>
                        <font class="font">邮编:</font>
                        <br>
                        <div class="input-group input-group-sm">
                            <input type="text" id="zip" class="form-control" placeholder="zip" name="zip" aria-describedby="sizing-addon3">
                        </div>
                        <span class="help-block"></span>

                    </th>
                </tr>

                <tr>
                    <th>支付方式</th>
                    <th><input class="money" type="submit" value="货到付款"> <input class="money" type="button"
                                                                                value="在线支付">
                    </th>
                </tr>
                <tr>
                    <th>送货清单</th>
                    <th>
                        <div>
                            <table>

                                <c:forEach var="cart" items="${sessionScope.cart}" varStatus="index">
                                    <tr>
                                        <th class="neirong neirong1"><img width="60px" src="/${cart.value.goods.pic1}">
                                        </th>
                                        <th class="neirong neirong2">${cart.value.goods.gname}</th>
                                        <th class="neirong neirong4">¥${cart.value.goods.price}</th>
                                        <th class="neirong neirong3">x${cart.value.num}</th>
                                        <th class="neirong neirong5">¥${cart.value.goods.price*cart.value.num}</th>
                                    </tr>
                                    <tr>
                                        <th>&nbsp;</th>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </th>
                </tr>
                </tbody>
            </table>

            <div class="yingfumoney">应付总额:<span class="zongji">¥<span class="money1">${requestScope.sum}</span></span>
                <input type="hidden" name="sumMoney" value="${requestScope.sum}">
            </div>
            <div><input class="submitanniu" type="submit" value="去支付"></div>
        </div>
    </form>
</div>
<script>
    $(function () {
        $("#frm").submit(function () {
            var namereg = /^[\u4E00-\u9FA5]{2,4}$/;
            var addressreg=/^\S{2,50}$/
            var phonereg=/^((1[0-9]{2})+\d{8})$/
            var zipreg=/^\d{6}$/
            if (!namereg.test($("#name").val())) {
                $(".input:eq(0)").addClass("has-error")
                $(".help-block:eq(0)").html("acceptName格式错误!")
                return false
            }else {
                $(".input:eq(0)").removeClass("has-error")
                $(".help-block:eq(0)").html("✓")
            }

            if (!addressreg.test($("#address").val())) {
                $(".input:eq(1)").addClass("has-error")
                $(".help-block:eq(1)").html("address格式错误!")
                return false
            }else {
                $(".input:eq(1)").removeClass("has-error")
                $(".help-block:eq(1)").html("✓")
            }

            if (!phonereg.test($("#phone").val())) {
                $(".input:eq(2)").addClass("has-error")
                $(".help-block:eq(2)").html("phone格式错误!")
                return false
            }else {
                $(".input:eq(2)").removeClass("has-error")
                $(".help-block:eq(2)").html("✓")
            }
            if (!zipreg.test($("#zip").val())) {
                $(".input:eq(3)").addClass("has-error")
                $(".help-block:eq(3)").html("zip格式错误!")
                return false
            }else {
                $(".input:eq(2)").removeClass("has-error")
                $(".help-block:eq(3)").html("✓")
            }
        })
    })
</script>
</body>
</html>
<style>
    .help-block{
        color: #5cb85c;
        font-size: 12px;
        font-weight: 400;
    }
</style>
