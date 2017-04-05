/**
 * Created by Dymond on 2017/4/3.
 */




$(function () {
    var editor = new wangEditor('editor');
//var user_name = "${sessionScope.get("USER_NAME")}";
    var user_name = "dymond";

    editor.config.uploadImgUrl = '/auction/uploadImg';
    editor.config.uploadImgFileName = 'publishImg';
    editor.config.uploadParams = {
        'user_name': user_name,
    }
    editor.create();


    $("#submitButton").click(function () {
            if ($("#product_title").val() == "") {
                $(this).focus();
                alert("请输入商品标题！");
                return;
            }
            if ($("#img0").val() == "") {
                alert("请上传宝贝主图！");
                return;
            }
            //待处理
            // if (editor.$txt.formatText().length == 0) {
            //     $(this).focus();
            //     alert("请输入商品描述！");
            //     return;
            // }

            if ($("#reserve_price").val() == "") {
                alert("请填写起拍价格！");
                return;
            }

            if ($("#end_time").val() == "") {
                $(this).focus();
                alert("请选择结束时间！");
                return;
            }

            if ($('input:radio[name="radio22on"]:checked').val() != null) {
                if ($("#start_time").val() == "") {
                    $(this).focus();
                    alert("请选择上架时间！");
                    return;
                }

                //待处理
                // if (getmm($("#start_time").val()) > getmm($("#end_time").val())) {
                //     alert("结束时间不能晚于上架时间");
                //     return;
                // }

            }
            var msg = "确认资料填写无误吗？";
            if (confirm(msg) == true) {
                var reserve_price = $("#reserve_price").val();
                var limit = $("#limit").val();
                var start = $("#start_time").val();
                var end = $("#end_time").val();
                var goods_title = $("#product_title").val();
                var goods_describe = editor.$txt.html().toString();
                var goods_image1 = $("#img0").val();
                var goods_image2 = $("#img1").val();
                var goods_image3 = $("#img2").val();
                var goods_image4 = $("#img3").val();
                var goods_image5 = $("#img4").val();
                //
                // alert(create_user);
                // alert(reserve_price);
                // alert(limit);
                // alert(start);
                // alert(end);
                // alert(goods_title);
                // alert(goods_describe);
                // alert(goods_image1);
                // alert(goods_image2);
                // alert(goods_image3);
                // alert(goods_image4);
                // alert(goods_image5);
                $.post(
                    "/auction/createGoods",
                    {
                        'reserve_price': parseInt(reserve_price),
                        'limit': parseInt(limit),
                        'start': start,
                        'end': end,
                        'goods_title': goods_title,
                        'goods_describe': goods_describe,
                        'goods_image1': goods_image1,
                        'goods_image2': goods_image2,
                        'goods_image3': goods_image3,
                        'goods_image4': goods_image4,
                        'goods_image5': goods_image5

                    },
                    function(){
                        alert("posted");
                    }
                )
                //
                // $.ajax({
                //     url: "/auction/createGoods",
                //     type: "POST",
                //     async: false,
                //     data: {
                //         'create_user': create_user,
                //         'reserve_price': reserve_price,
                //         'limit': limit,
                //         'start_time': start_time,
                //         'final_time': final_time,
                //         'goods_title': goods_title,
                //         'goods_describe': goods_describe,
                //         'goods_image1': goods_image1,
                //         'goods_image2': goods_image2,
                //         'goods_image3': goods_image3,
                //         'goods_image4': goods_image4,
                //         'goods_image5': goods_image5
                //
                //     },
                //     success: function (data) {
                //         if (data == '1')
                //             alert("商品发布成功");
                //
                //         else //0
                //             alert("商品发布失败");
                //     },
                //     error: function () {
                //         alert("服务器错误");
                //     }
                // })
                return true;
            }
            else {
                return false;
            }
        }


        //----submit------


    )
})

    $(".preview").click(function () {
        // alert("upload-tip click");
        var selectorId = $(this).attr("id");
        // alert("id:" + selectorId);
        val = selectorId.substr(selectorId.length - 1, 1);
        $("#fileToUpload").click();//触发file select
    })


$("#radio22on").click(function () {
    $("#fixTime").css({
        'display': ''
    })
})
$("#radio22off").click(function () {
    $("#fixTime").css({
        'display': 'none'
    })
})


var val;


Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": '00', //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function getdayTime() {
    var date = new Date().Format("yyyy-MM-dd hh:mm:ss");
    // alert(date);
    return date;
}
function getDaysAfterTime() {
    var datetime = new Date();
    var sec = parseInt(datetime.getTime()) + 7 * 1000 * 60 * 60 * 24;
    // alert(sec);
    var after = new Date(sec).Format("yyyy-MM-dd hh:mm:ss");
    // alert(after);
    return after;
}

function getmm(val) {
    var mm = new Date(val);
    alert(mm);
    return mm;
}

function fileSelected() {
    if ($("#fileToUpload").val() == "") {
        $("#preview" + val).css({
            "background-image": "",
        });
        $("#img" + val).val("");
        return;
    }

    var formData = new FormData();
    formData.append("publishImg", $("#fileToUpload")[0].files[0]);
    $.ajax({
        url: "/auction/uploadWindowImg",
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        async: false,
        success: function (data) {
            $("#preview" + val).css({

                'background-image': 'url(' + data + ')',
                'background-size': 'contain',
                'background-position': 'center',
                'background-repeat': 'no-repeat'

            });
            $("#img" + val).val(data);//服务器存放路径保存到隐藏域

        },
        error: function () {
            alert("服务器错误error");
        }
    })
}


