$(function(){
    //一次获得所有，逐个触发事件
    $(".inpic").each(function(){
        //$(this)表示jquery中当前对象
        var img=$(this).html();
        $(this).mouseenter(function(){
            //将鼠标经过时的图片地址传给big所在的层
            $("#pic1").html(img); //取html();赋值html("hello")

        });
    });


//    隐藏层
    //获得big的定位
    pic1=document.getElementById("pic1")
    legth=pic1.getBoundingClientRect()

    goodycc=document.getElementById("goodsycc")
    goodycc.style.top=-(legth.bottom+238)+"px"
    goodycc.style.left=-(legth.left-740)+"px"

    $("#pic1").mouseenter(function () {
        goodycc.style.display="block"
        goodycc.innerHTML=pic1.innerHTML
    }).mouseleave(function () {
        goodycc.style.display="none"
    }).mousemove(function () {
        biliWidth=(event.clientX-$("#pic1")[0].getBoundingClientRect().left)/480
        biliheight=(event.clientY-$("#pic1")[0].getBoundingClientRect().top)/470

        $("#goodsycc")[0].scrollLeft=(biliWidth*800)-240
        $("#goodsycc")[0].scrollTop=(biliheight*830)-235

    })


})


