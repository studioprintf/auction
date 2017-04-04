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
    if ($("#fileToUpload").value == "") {
        $("#preview" + val).css({
            "background-image": "",
            "background-size": "contain"
        });
        $("#img" + val).value = "";
        return;
    }

    alert("selected val:" + val);
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
            alert(data);
            $("#preview" + val).css({
                "background-image": "url(" + data + ") no-repeat",
                "background-size": "contain"
            });
            $("#img" + val).value = data;//服务器存放路径保存到隐藏域

        },
        error: function () {
            alert("服务器错误error");
        }
    })

}

function publishSubmit(){
    if($("#title").val()==""||$("#title").val()==null){
        alert("请输入商品标题！");
        return;
    }
    if($("#img0").value==""){
        alert("请上传宝贝主图！");
        return;
    }


}