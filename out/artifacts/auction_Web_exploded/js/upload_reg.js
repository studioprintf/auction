/**
 * Created by Dymond on 2017/4/3.
 */

var val;
$(function () {
    $(".preview").click(function () {
        alert("upload-tip click");
        var selectorId = $(this).attr("id");
        alert("id:" + selectorId);
        val = selectorId.substr(selectorId.length - 1, 1);
        $("#fileToUpload").click();//触发file select
    })

})


    function fileSelected() {
        alert("selected val:" + val);
        var formData = new FormData();
        formData.append("publishImg",$("#fileToUpload")[0].files[0]);
        $.ajax({
            url: "/auction/uploadWindowImg",
            type: "POST",
            data: formData,
            processData: false,
            contentType: false,
            async:false,
            success: function (data) {
                alert(data);
                $("#preview"+val).css({
                    "background-image":"url("+data+")",
                    "background-size" :"contain"
            });
            },
            error: function () {
                alert("服务器错误error");
            }
        })

    }