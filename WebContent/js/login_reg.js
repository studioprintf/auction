/**
 * Created by Dymond on 2017/3/25.
 */





//----------------------注册----------------------


$(function () {
    $("#registname").blur(function () {
        var val = $(this).val();
        val = $.trim(val);
        var $this = $(this);
        if (val != "") {
            if (val.length < 4 || val.length > 10) {
                $this.nextAll("font").remove();
                $this.nextAll("img").remove();
                $this.after("<font color='red'>用户名长度在4-10之间</font>");
            } else {
            }

//把当前节点后面的所有 font 兄弟节点删除!!
            $this.nextAll("font").remove();
            $this.nextAll("img").remove();
            var url = "user_checkName";
            var args = {
                "user_name": val,
                "time": new Date()
            };
            $.post(url, args, function (data) {
//表示可用
                if (data == "1") {
                    $this.after("<img src='http://localhost:8080/img/right_s.png'>");
                }
//不可用
                else if (data == "0") {
                    $this.after("<font color='red'>用户名已被注册!</font>");
                }
//服务器错误
                else {
                    alert("服务器错误!");
                }
            });
        }

        else {
            $this.nextAll("font").remove();
            $this.nextAll("img").remove();
            $this.after("<font color='red'>请输入用户名！</font>");

        }

    });
//用了Jquery.post(url,args,function(data){..})函数提交ajax请求到指定url，并且携带参数args，最后用一个回调函数处理请求返回结果data.


    $("#registpassword").blur(function () {

        var val = $(this).val();
        val = $.trim(val);
        var $this = $(this);
        if (val == "") {
            $this.nextAll("font").remove();
            $this.after("<font color='red'>请输入密码！</font>");
        }
        else {
            if (val.length < 4 || val.length > 20) {
                $this.nextAll("font").remove();
                $this.after("<font color='red'>密码长度在4-20之间</font>");
            }


            $this.nextAll("font").remove();
        }
    })

    $("#registemail").blur(function () {
        var val = $(this).val();
        val = $.trim(val);
        var $this = $(this);
        if (val == "") {
            $this.nextAll("font").remove();
            $this.after("<font color='red'>请输入邮箱！</font>");
        }
        else {
            $this.nextAll("font").remove();
        }
    })

    $("#regSubmit").click(function () {
        var val1 = $("#registname").val();
        var val2 = $("#registpassword").val();
        var val3 = $("#registemail").val();
        if (val1 != "" && val2 != "" && val3 != "") {
            $("#registForm").submit();
        }
    })
})


//----------------------登录----------------------
$(function () {
    $("#userIdTxt").blur(function () {
        var val = $(this).val();
        val = $.trim(val);
        if (val == "") {
            $("#userIdSpt").text("请输入用户名！");
        }
        else {
            $("#userIdSpt").text("");
        }
    })

    $("#passwdTxt").blur(function () {
        var val = $(this).val();
        val = $.trim(val);
        if (val == "") {
            $("#userPwdTip").text("请输入密码！")
        }
        else {
            $("#userPwdTip").text("");
        }
    })

    $("#loginSubmit").click(function () {
        var val1 = $("#userIdTxt").val();
        var val2 = $("#passwdTxt").val();
        if (val1 != "" && val2 != "") {
            $("#loginForm").submit();
        }
    })
})

