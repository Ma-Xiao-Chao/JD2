$(function () {
    $(".usersInfo:eq(0)").click(
        function(){
            $("#rightFrame").attr("src","/userMange")
        }
    )
    // $(".usersInfo:eq(1)").click(
    //     function(){
    //         $("#rightFrame").attr("src","addUser.jsp")
    //     }
    // )
    // $(".usersInfo:eq(2)").click(
    //     function(){
    //         $("#rightFrame").attr("src","delUser.jsp")
    //     }
    // )

    $(".goodsInfo:eq(0)").click(
        function(){
            $("#rightFrame").src=""
            $("#rightFrame").attr("src","/admin?action=all1")
        }
    )
    $(".goodsInfo:eq(1)").click(
        function(){
            $("#rightFrame").src=""
            $("#rightFrame").attr("src","/agoods")
        }
    )
    $(".goodsInfo:eq(2)").click(
        function(){
            $("#rightFrame").attr("src","/orderMange")
        }
    )
})
