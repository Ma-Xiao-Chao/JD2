$(function () {
    $("#frm").submit(function () {
        var regUsername = /^[a-zA-Z0-9]{4,12}$/
        var regPassword = /^[a-zA-Z0-9]{4,12}$/
        var regbirth = /\S/
        var regmail = /\S/
        if (!regUsername.test($("#uname").val())) {
            $(".input:eq(0)").addClass("has-error")
            $(".help-block:eq(0)").html("username格式错误!")
            return false
        } else {
            $(".input:eq(0)").removeClass("has-error")
            $(".help-block:eq(0)").html("✓")
        }

        if (!regPassword.test($("#upass").val())) {
            $(".input:eq(1)").addClass("has-error")
            $(".help-block:eq(1)").html("password格式错误!")
            return false
        } else {
            $(".input:eq(1)").removeClass("has-error")
            $(".help-block:eq(1)").html("✓")
        }

        if (!regbirth.test($("#ubirth").val())) {
            $(".input:eq(2)").addClass("has-error")
            $(".help-block:eq(2)").html("日期为空!")
            return false
        } else {
            $(".input:eq(2)").removeClass("has-error")
            $(".help-block:eq(2)").html("✓")
        }

        if (!regmail.test($("#mail").val())) {
            $(".input:eq(3)").addClass("has-error")
            $(".help-block:eq(3)").html("邮箱为空!")
            return false
        } else {
            $(".input:eq(3)").removeClass("has-error")
            $(".help-block:eq(3)").html("✓")
        }
        return true

    })
})
