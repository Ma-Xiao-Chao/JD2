// $(function () {
//     alert("fwfawf")
//     $("#form").submit(function () {
//         //name正则表达式
//         var reg = /^[A-z0-9]{6,16}$/
//         var uname=$("#uname").val()
//         if (!reg.test(uname)){
//             err1.innerHTML = "名字格式不对"
//             err1.style.fontSize="12px"
//             err1.style.color="red"
//             return false
//         } else {
//             err1.innerHTML = "✓"
//             err1.style.color="green"
//             // return false;
//         }
//         //密码正则表达式
//         var reg2 = /^\d{6}$/
//         var userpwd=$("#upwd").val()
//         if (!reg2.test(userpwd)){
//             var err2=document.getElementById("pwdErr")
//             err2.innerHTML = "密码格式不对"
//             err2.style.fontSize="12px"
//             err2.style.color="red"
//             return false
//         } else {
//             err2.innerHTML = "✓"
//             err2.style.color="green"
//         }
//         var result1=username=="admin123"
//         var result2=userpwd=="123456"
//         if (result1 && result2 )
//             return true;
//         else {
//             alert("信息输入错误!")
//             return false
//         }
//     })
// })

$(function () {
    $("#frm").submit(function () {
        var regUsername = /^[a-zA-Z0-9]{4,12}$/
        var regPassword=/^[a-zA-Z0-9]{4,12}$/
        if (!regUsername.test($("#username").val())) {
            $(".input:eq(0)").addClass("has-error")
            $(".help-block:eq(0)").html("username格式错误!")
            return false
        }else {
            $(".input:eq(0)").removeClass("has-error")
            $(".help-block:eq(0)").html("✓")
            if (!regPassword.test($("#password").val())){
                $(".help-block:eq(1)").html("password格式错误!")
                return false
            }
            return true
        }
    })
})
