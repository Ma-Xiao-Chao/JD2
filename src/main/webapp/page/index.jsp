<%--
  Created by IntelliJ IDEA.
  User: 哈登
  Date: 2022/9/14
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>京东(JD.COM)-正品低价、品质保证</title>
    <link rel="icon" href="/static/pic/1.png" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="/static/css/index1.css">
</head>
<body>
<script type="text/javascript" src="/static/js/index1.js"></script>
<div id="oouter">
    <div id="outer">
        <!--第一层-->
        <div id="top">
            <div class="line" id="areaAll"><img src="/static/pic/2.png">

                <select class="allArea" id="area1" onchange="chageS()">
                    <option style="size: 40px">省</option>
                </select>

                <select class="allArea" id="area2" onchange="chageSS()">
                    <option>市</option>
                </select>

                <select class="allArea" id="area3">
                    <option>区</option>
                </select>
            </div>

            <div class="line" id="l1" >
                <c:if test="${sessionScope.username!=null}">
                    <a href="/page/logout.jsp?username=${sessionScope.username}" style="color: #c8121d">欢迎,${sessionScope.username}</a>
                </c:if>
                <c:if test="${sessionScope.username==null}">
                    <a href="/page/login.jsp">你好,请登录</a>
                </c:if>
            </div>

            <a href="/page/regist.jsp">
                <div class="line">免费注册</div>
            </a>
            <div class="line"><a href="/order?action=orderList&usid=${sessionScope.usid}">我的订单</a></div>
            <div class="line">我的京东</div>
            <div class="line">京东会员</div>
            <div id="t1">
                <div class="t1-1">企业采购</div>
                <div class="t1-1">企业购</div>
                <div class="t1-1">工业购</div>
                <div class="t1-1">礼品卡</div>
            </div>

            <!--onmouseenter="mouseEnter()" onmouseleave="mouseLeave()“-->
            <div id="t2">
                <div class="t2-1">商家服务</div>
                <div class="t2-1">合作招商</div>
                <div class="t2-1">学习中心</div>
                <div class="t2-1">商家后台</div>
            </div>


            <div class="line" id="t3">网站导航</div>
            <div class="line">手机京东</div>
            <div class="line">网站无障碍</div>
        </div>
        <!--第二层-->
        <div id="top2">
            <!--第一大列-->
            <div class="top2-line" id="t2-line1">
                <!--放图片-->
                <img src="/static/pic/top2-1.png">
            </div>

            <!--第二大列-->
            <div class="top2-line" id="t2-line2">
                <!--第二大列  第一行左-->
                <div class="t2-l2-line" id="--1">
                    <%--搜索--%>
                    <div class="tmp" id="kuang">
                        <script>
                            function search() {
                                // alert("1")
                                var form = document.getElementById("searchForm")
                                form.action = "goodsx?action=search"
                                form.submit();
                                document.getElementById("tmp-0").value = ""
                            }
                        </script>
                        <form action="#" id="searchForm" method="post">
                            <div class="tmp">
                                <input type="text" id="tmp-0" name="condition">
                            </div>
                            <div class="tmp" id="tmp-1">
                                <a href="javascript:search()">
                                    <img width="100" src="/static/pic/top2-3.png">
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
                <!--第二大列  第一行右-->
                <div class="t2-l2-line" id="--2">
                    <div id="tmp-2">
                        <img class="gouwuche" height="33" src="/static/pic/top2-4-2.png">

                        <c:if test="${sessionScope.username!=null}">
                            <div class="gouwuche" id="gouwunum">0</div>
                        </c:if>
                        <c:if test="${sessionScope.username==null}">
                            <div class="gouwuche" id="gouwunum">0</div>
                        </c:if>


                        <a href="/cart?action=indexInCart" class="gouwuhref">
                            <div class="gouwuche" id="gouwufont">我的购物车</div>
                        </a>

                    </div>
                </div>
                <!--第二大列  第二行-->
                <div class="t2-l2-line" id="--3">
                    <div id="tmp-3">
                        <div class="tmpclass1">毛绒品牌会&nbsp&nbsp</div>
                        <div class="tmpclass1">平板电视&nbsp&nbsp</div>
                        <div class="tmpclass1">京东京造&nbsp&nbsp</div>
                        <div class="tmpclass1">0元试用&nbsp&nbsp</div>
                        <div class="tmpclass1">大牌空调&nbsp&nbsp</div>
                        <div class="tmpclass1">进口超市&nbsp&nbsp</div>
                        <div class="tmpclass1">卡地亚&nbsp&nbsp</div>
                        <div class="tmpclass1">装机大赛&nbsp&nbsp</div>
                        <div class="tmpclass1">600减400</div>
                    </div>
                </div>
                <!--第二大列  第三行-->
                <div class="t2-l2-line" id="--4">
                    <div class="tmpclass2">秒杀&nbsp&nbsp</div>
                    <div class="tmpclass2">&nbsp&nbsp优惠券&nbsp&nbsp</div>
                    <div class="tmpclass2">&nbsp&nbspPLUS会员&nbsp&nbsp</div>
                    <div class="tmpclass2">&nbsp&nbsp品牌闪购&nbsp&nbsp</div>
                    <div class="tmpclass2">&nbsp&nbsp拍卖&nbsp&nbsp</div>
                    <div class="tmpclass2">&nbsp&nbsp京东家电&nbsp&nbsp</div>
                    <div class="tmpclass2">&nbsp&nbsp京东超市&nbsp&nbsp</div>
                    <div class="tmpclass2">&nbsp&nbsp京东生鲜&nbsp&nbsp</div>
                    <div class="tmpclass2">&nbsp&nbsp进口好物&nbsp&nbsp</div>
                    <div class="tmpclass2">&nbsp&nbsp京东云</div>
                </div>
            </div>

            <!--第三大列-->
            <div class="top2-line" id="t2-line3">
                <img src="/static/pic/top2-2.png">
            </div>
        </div>
        <!--第三层-->
        <div id="top3">
            <!--第一列左边一溜字-->
            <div class="top3-l" id="t3-l1">
                <%--                for增强--%>
                <%--                    <c:forEach var="catalog" items="${requestScope.clist}" varStatus="status">
                                    <div class="t3-l1-font" id="t3font1" onmouseenter="show(1,1)" onmouseleave="show(2)">
                &lt;%&ndash;                        <a href="${catalog.url}"> ${catalog.cname}</a>&ndash;%&gt;
                                    </div>
                                    </c:forEach>--%>
                <%--    for循环--%>


                <c:forEach var="i" begin="1" end="18" step="1">
                    <div class="t3-l1-font" onmouseenter="show(1,${i})" onmouseleave="show(2)">
                        <c:forEach var="catalog" items="${requestScope.clist}" varStatus="status">
                            <c:if test="${catalog.line==i}">
                                <a href="${catalog.url}?cid=${catalog.cid}&level=1"
                                   style="color: black;text-decoration: none"> ${catalog.cname}/</a>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:forEach>

                <%--                                <div class="t3-l1-font" id="t3font1" onmouseenter="show(1,1)" onmouseleave="show(2)">家用电器</div>
                                                <div class="t3-l1-font" onmouseenter="show(1,1)" onmouseleave="show(2)">手机/运营商/数码</div>
                                                <div class="t3-l1-font" onmouseenter="show(1,1)" onmouseleave="show(2)">电脑/办公</div>
                                                <div class="t3-l1-font">家居/家具/家装/厨具</div>
                                                <div class="t3-l1-font">男装/女装/童装/内衣</div>
                                                <div class="t3-l1-font">美妆/个人清洁/宠物</div>
                                                <div class="t3-l1-font">女鞋/箱包/钟表/珠宝</div>
                                                <div class="t3-l1-font">男鞋/运动/户外</div>
                                                <div class="t3-l1-font">房产/汽车/汽车用品</div>
                                                <div class="t3-l1-font">母婴/玩具乐器</div>
                                                <div class="t3-l1-font">食品/酒类/生鲜/特产</div>
                                                <div class="t3-l1-font">艺术/礼品鲜花/农贸绿植</div>
                                                <div class="t3-l1-font">医药保健/计生情趣</div>
                                                <div class="t3-l1-font">图书/文娱/教育/电子书</div>
                                                <div class="t3-l1-font">机票/酒店/旅游/生活</div>
                                                <div class="t3-l1-font">众筹/白条/保险</div>
                                                <div class="t3-l1-font">安装/维修/清洗/二手</div>
                                                <div class="t3-l1-font">工业品</div>--%>
            </div>

            <!--第二列中间大图-->
            <div class="top3-l" id="t3-l2">
                <div id="l2-inner">
                    <img src="/static/pic/top3-1.png"><img src="/static/pic/top3-2.png"><img
                        src="/static/pic/top3-3.png"><img src="/static/pic/top3-4.png"><img
                        src="/static/pic/top3-5.png">
                </div>
            </div>

            <!--第三列-->
            <div class="top3-l" id="t3-l3">
                <!--三张图-->

                <div id="l3-inner1">
                    <div class="innner1" id="inner1-1">
                        <div class="t3-l3-pic1" id="pic-1"><a href="/page/goods.jsp"><img src="/static/pic/top3-6.png"></a>
                        </div>
                        <div class="t3-l3-pic1" id="pic-2"><img src="/static/pic/top3-7.png"></div>
                        <div class="t3-l3-pic1" id="pic-3"><img src="/static/pic/top3-8.png"></div>
                    </div>
                    <div class="innner1">
                        <div class="t3-l3-pic1" id="pic-4"><img src="/static/pic/top3-9.png"></div>
                        <div class="t3-l3-pic1" id="pic-5"><img src="/static/pic/top3-10.png"></div>
                        <div class="t3-l3-pic1" id="pic-6"><img src="/static/pic/top3-11.png"></div>
                    </div>

                </div>
            </div>

            <!--第四列-->
            <div class="top3-l" id="t3-l4">
                <img src="/static/pic/top3-right.png">
            </div>
        </div>

    </div>
</div>
<%--<div class="ycc" id="ycc" onmouseenter="show(1)" onmouseleave="show(2)">--%>
<%--</div>--%>
<!--第三层的隐藏层-->
<div class="yc" id="ycc" onmouseenter="show(1)" onmouseleave="show(2)">

</div>
<!--第三层的点-->
<div id="dianceng" onmouseenter="clearInterval(A)" onmouseleave="A=setInterval('showLbt()',3000)">
    <div class="xdian" onmouseenter="changeLbt(0)"></div>
    <div class="xdian" onmouseenter="changeLbt(1)"></div>
    <div class="xdian" onmouseenter="changeLbt(2)"></div>
    <div class="xdian" onmouseenter="changeLbt(3)"></div>
    <div class="xdian" onmouseenter="changeLbt(4)"></div>
    <div class="jiantou" id="jt1"> <</div>
    <div class="jiantou" id="jt2"> ></div>
</div>

</body>
</html>
