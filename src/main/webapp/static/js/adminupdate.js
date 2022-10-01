$(function () {
    $("#frm").submit(function () {
        var regcname = /^\S{1,40}$/
        var reglevel = /^[1-3]{1}$/
        var reparent = /^[1-5]?$/
        var regurl = /^\S*$/

        var regline = /^[0-9]|[1][0-8]{1,2}$/

        //cname
        if (!regcname.test($("#cname").val())) {
            $(".input:eq(0)").addClass("has-error")
            $(".help-block:eq(0)").html("cname格式错误!")
            return false
        } else {
            $(".input:eq(0)").removeClass("has-error")
            $(".help-block:eq(0)").html("✓")
        }
        //url
        if (!regurl.test($("#url").val())) {
            $(".input:eq(1)").addClass("has-error")
            $(".help-block:eq(1)").html("url格式错误!")
            return false
        } else {
            $(".input:eq(1)").removeClass("has-error")
            $(".help-block:eq(1)").html("✓")
        }
        //level
        if (!reglevel.test($("#level").val())) {
            $(".input:eq(2)").addClass("has-error")
            $(".help-block:eq(2)").html("level格式错误!")
            return false
        } else {
            $(".input:eq(2)").removeClass("has-error")
            $(".help-block:eq(2)").html("✓")
        }
        //parent
        if (!reparent.test($("#parent").val())) {
            $(".input:eq(3)").addClass("has-error")
            $(".help-block:eq(3)").html("parent格式错误!")
            return false
        } else {
            $(".input:eq(3)").removeClass("has-error")
            $(".help-block:eq(3)").html("✓")
        }
        //line
        if (!regline.test($("#line").val())) {
            $(".input:eq(4)").addClass("has-error")
            $(".help-block:eq(4)").html("line格式错误!")
            return false
        } else {
            $(".input:eq(4)").removeClass("has-error")
            $(".help-block:eq(4)").html("✓")
        }
        return true;
    })
})
