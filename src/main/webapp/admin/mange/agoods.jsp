<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/26
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>data</title>
    <link type="text/css" rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
</head>
<body>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<%--//删除按钮弹框--%>
<script>
    $(function () {
        $(".delBtn").each(function () {
            $(this).click(function () {
                /*                if (confirm('确认删除')) {
                                    return true;
                                } else {
                                    return false;
                                }*/
                return confirm('确认删除?');
            })
        })
    })
</script>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-10 col-md-offset-1 temp">
            <table class="table  table-hove">
                <caption>物品信息</caption>
                <thead>
                <tr>
                    <th class="headFont">名称</th>
                    <th class="headFont">价格</th>
                    <th class="headFont">库存</th>
                    <th class="headFont">生产日期</th>
                    <th class="headFont">一级id</th>
                    <th class="headFont">二级id</th>
                    <th class="headFont">三级id</th>
                    <th class="headFont">pic1</th>
                    <th class="headFont">pic2</th>
                    <th class="headFont">pic3</th>
                    <th class="headFont">pic4</th>
                    <th class="headFont">操作</th>
                </tr>
                </thead>
                <tbody class="tbody">
                <c:forEach var="goods" items="${glist}">
                    <tr>
                        <th class="font name">${goods.gname}</th>
                        <th class="font">${goods.price}</th>
                        <th class="font">${goods.store}</th>
                        <th class="font">${goods.pubdate}</th>
                        <th class="font">${goods.cid1}</th>
                        <th class="font">${goods.cid2}</th>
                        <th class="font">${goods.cid3}</th>
                        <th class="font pic">${goods.pic1}</th>
                        <th class="font pic">${goods.pic2}</th>
                        <th class="font pic">${goods.pic3}</th>
                        <th class="font pic">${goods.pic4}</th>
                        <th class="font pic"><a href="###/admin?action=delete&id=${catalog.cid}&page=${requestScope.page1}" class="delBtn">删除</a>
                            <a href="###/admin?action=one&id=${catalog.cid}&page=${requestScope.page1}">/修改</a>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="/agoods?page=1">首页</a></li>
                    <li><a href="/agoods?page=${requestScope.page1-1}">上页</a></li>
                    <li><a href="/agoods?page=${requestScope.page1+1}">下页</a></li>
                    <li><a href="/agoods?page=${requestScope.total}">末页</a></li>
                    <li><a href="#">${requestScope.page1}/${requestScope.total}</a></li>
                </ul>
            </nav>
        </div>
        <div class="col-md-3 col-md-offset-1">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="####/admin/insert.jsp?">添加</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
<style>
    .headFont{
        font-size: 12px;
        font-weight: 500;
    }
    .font{
        font-size: 12px;
        font-weight: 500;
    }
    .pic{
        width: 100px;
    }

    .name{
        width: 150px;
    }
    .temp {
        width: 1245px;
        margin-left: 0;
    }
</style>
