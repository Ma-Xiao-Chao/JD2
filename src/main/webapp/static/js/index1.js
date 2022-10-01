window.onload = function () {
    area1 = document.getElementById("area1")
    area2 = document.getElementById("area2")
    area3 = document.getElementById("area3")

    //定义数据
    areaData = [
        {
            s1: "甘肃", s2: [
                {ss1: "兰州市", sss1: ["城关区", "榆中县", "安宁区"]},
                {ss1: "定西市", sss1: ["定西1区", "定西2区"]},
                {ss1: "陇南市", sss1: ["陇南1区", "陇南2区"]},
                {ss1: "天水市", sss1: ["天水1区"]},
                {ss1: "嘉峪关市", sss1: ["嘉峪关区"]},
            ]

        },
        {
            s1: "陕西", s2: [
                {ss1: "西安市", sss1: ["雁塔区", "长安区", "未央区"]},
                {ss1: "咸阳市", sss1: ["咸阳1区", "咸阳2区"]},
            ]
        }
    ]
    for (var x in areaData) {
        var option = document.createElement("option")
        option.innerHTML = areaData[x].s1
        area1.appendChild(option)
    }

    //第三层隐藏层的定位
    var yyc = document.getElementById("ycc")
    //文字列对象
    var t3_1 = document.getElementById("t3-l1")
    //设置属性
    //获得第一行文字定位
    var r = t3_1.getBoundingClientRect();
    yyc.style.top = r.top + "px";
    yyc.style.left = r.right + "px";


    //轮播图
    lbt = document.getElementById("t3-l2")
    //修改lbt的滚动条
    //lbt.scrollLeft=600;
    //能过定时器调用函数
    A = setInterval("showLbt()", 3000);
    // setInterval("showLbt()",25);


    //右边小轮播图
    lbt2 = document.getElementById("t3-l3")
    //修改lbt的滚动条
    //lbt.scrollLeft=600;
    //能过定时器调用函数
    setInterval("showLbt2()", 3000);

    //设置轮播图上的覆盖层：与id="lbt"的层完全相同
    dianceng = document.getElementById("dianceng");
    // alert(lay3middabs);
    r2 = lbt.getBoundingClientRect();//含有top/bottom/left/right
    dianceng.style.top = r2.top + "px";
    dianceng.style.left = r2.left + "px";

    //设置覆盖层内的圆圈
    for (var j = 0; j < dianceng.children.length; j++) {
        dianceng.children[j].style.top = 440 - (10 * j) + "px";
        dianceng.children[j].style.left = 50 + (20 * j) + "px";
    }
    //设置覆盖层内的箭头
    document.getElementById("jt1").style.top = (r2.top - 90) + "px"
    document.getElementById("jt1").style.left = (r2.left - 375) + "px"

    document.getElementById("jt2").style.top = (r2.top - 142) + "px"
    document.getElementById("jt2").style.left = (r2.left + 176) + "px"

}

function chageS() {
    //改变省后删除原来市的市子节点  重新刷新市的选项 0是---市
    while (area2.children.length > 1) {
        area2.removeChild(area2.children[1])
    }
    //改变市后删除原来区的区子节点  重新刷新市的选项
    while (area3.children.length > 1) {
        area3.removeChild(area3.children[1])
    }

    indexS = area1.selectedIndex - 1

    for (var x in areaData[indexS].s2) {
        var opt = document.createElement("option");
        opt.innerHTML = areaData[indexS].s2[x].ss1
        area2.appendChild(opt)
    }
}

function chageSS() {
    //改变市后删除原来区的区子节点  重新刷新市的选项
    while (area3.children.length > 1) {
        area3.removeChild(area3.children[1])
    }
    indexSS = area2.selectedIndex - 1
    for (var x in areaData[indexS].s2[indexSS].sss1) {
        var opt = document.createElement("option");
        opt.innerHTML = areaData[indexS].s2[indexSS].sss1[x]
        area3.appendChild(opt)
    }
}

//第三层隐藏层
function show(x, y) {
    var yingcangceng = document.getElementById("ycc")
    if (x == 1 && y != null) {
        yingcangceng.style.display = "block"
        yingcangceng.innerHTML = "";
        //ajax请求
        var xhr = new XMLHttpRequest();//基于这个对象
        xhr.open("get", "/catalog?action=selectById&line=" + y)
        xhr.send();//发送请求------进入服务器
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                // console.log(xhr.responseText)
                var res = JSON.parse(xhr.responseText);
                var table= document.createElement("table")
                // table.style.border="black solid 3px"
                for (var ids1 in res) {
                    if (ids1 % 2 == 0) {
                        //二级
                        tr=document.createElement("tr")
                        // tr.style.border="black solid 2px"
                        //列
                        td2=document.createElement("td")
                        td2.style.fontWeight='bold';
                        td2.style.fontSize='12px'
                        td2.style.width='70px';
                        //加链接
                        var a1=document.createElement("a")
                        a1.setAttribute("href",res[ids1].url+"?cid="+res[ids1].cid+"&level=2")
                        a1.style.textDecoration='none'
                        a1.style.color='black'
                        a1.innerHTML=res[ids1].cname+">"
                        td2.appendChild(a1)
                        // td2.style.border="black solid 1px"
                        tr.appendChild(td2)
                    } else {
                        //遍历三级集合
                        lis= res[ids1];
                        for (var x in lis) {
                            // div3.innerHTML = "&nbsp&nbsp&nbsp&nbsp" + lis[x].cname
                            td3=document.createElement("td")
                            td3.style.fontSize='12px'
                            td3.style.width='70px';
                            //加链接
                            var a=document.createElement("a")
                            a.setAttribute("href",lis[x].url+"?cid="+lis[x].cid+"&level=3")
                            a.style.textDecoration='none'
                            a.style.color='black'
                            a.innerHTML=lis[x].cname
                            // td3.appendChild(a)
                            // td3.innerHTML=lis[x].cname;
                            td3.appendChild(a)
                            // td3.style.border="black solid 1px"
                            tr.appendChild(td3)
                        }
                        table.appendChild(tr)
                    }
                    yingcangceng.appendChild(table)
                }
            }
        }
    } else if (x == 2) {
        yingcangceng.style.display = "none"
    } else {
        yingcangceng.style.display = "block"
    }
}


//定义变量用于控制轮播图的滚动条的距离
lbt_count = 0;

//轮播图
function showLbt() {
    lbt.scrollLeft = lbt_count;

    dianceng.children[lbt_count / 590 === 0 ? 4 : lbt_count / 590 - 1].style.backgroundColor = "#999999";
    dianceng.children[lbt_count / 590].style.backgroundColor = "#FFFFFF";//当前圆圈

    lbt_count += 590;
    // lbt_count+=5;
    if (lbt_count == 2950)
        lbt_count = 0;
}


lbt_count2 = 0;

//轮播图    ----小图
function showLbt2() {
    lbt2.scrollLeft = lbt_count2;
    lbt_count2 += 200;
    if (lbt_count2 == 400)
        lbt_count2 = 0;
}

// 小点挪动位置

function changeLbt(x) {
    //改变lbt_count的值：600--0 1200-1 1800-2 -3
    // alert(lbt_count/600);
    for (var j = 0; j < 5; j++) {
        if (j != x) {
            dianceng.children[j].style.backgroundColor = "#999999";
        }
    }
    dianceng.children[x].style.backgroundColor = "#ffffff";//当前圆圈
    lbt_count = x * 590;
    lbt.scrollLeft = lbt_count;
}


function mouseEnter() {
    document.getElementById("a3").style.display = "block";

}

function mouseLeave() {
    document.getElementById("a3").style.display = "none";
}

//左边18行
//搜索

