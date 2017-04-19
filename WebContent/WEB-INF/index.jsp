<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Dymond
  Date: 2017/4/16
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <title>竞价</title>
    <link href="/css/css2.css" rel="stylesheet">

    <link href="/css/pagination.css" rel="stylesheet">


    <style></style>
    <link rel="stylesheet" href="/js/layer/skin/default/layer.css" id="layui_layer_skinlayercss"
          style="">
</head>
<body style="">
<div class="top">
    <div class="top_k">

        <div class="top_1 a1">


            <div class="login fl">

                欢迎使用在线拍卖系统&nbsp;&nbsp;&nbsp;&nbsp; <a
                    href="${pageContext.request.contextPath}/login" target="_blank">请登录</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
                    href="${pageContext.request.contextPath}/register">免费注册</a>
            </div>


            <div onmouseout="MM_out(this)" onmouseover="MM_over(this)" class="list fr a1 pr">
                <a href="#"><span class="icon_t fl"><img src="https://static.48.cn/Shop/images/top_icon_3.jpg"></span>
                    我的订单 <span class="jian fr"><img src="https://static.48.cn/Shop/images/jian.jpg"></span></a>
                <div class="order_p a1" style="display: none;">
                    <a href="/Order">我的周边</a><br>
                    <a href="/TOrder">我的门票</a><br>
                    <a href="/COrder">我的抽选</a>
                    <div class="jian_2"><img src="https://static.48.cn/Shop/images/jian_1.png"></div>
                </div>

            </div>


            <div class="list fr"><a href="/Account">
                <div class="icon_t fl"><img src="https://static.48.cn/Shop/images/top_icon_2.jpg"></div>
                我的账户</a></div>
        </div>
        <script>
            function MM_over(mmObj) {
                var mSubObj = mmObj.getElementsByTagName("div")[0];
                mSubObj.style.display = "block";
            }
            function MM_out(mmObj) {
                var mSubObj = mmObj.getElementsByTagName("div")[0];
                mSubObj.style.display = "none";
            }

        </script>

        <div class="top_2">

            <div class="search fl">
                <div class="bar">
                    <div class="bar_1 fl">
                        <input type="text" class="text_1" name="" id="topkey">
                    </div>
                    <div class="bar_2 fl f16"><a href="javascript:;" id="topsearch">搜 索</a></div>
                </div>

            </div>
        </div>
        <div class="clear"></div>
        <div class="top_3">
            <ul>
                <li class="dh_1 fl">
                    <a href="/Goods/index/">全部商品分类</a>
                    <ul class="columns banner_1 hidden">

                        <li class="fs20"><a class="as" href="/Tickets">剧场门票</a></li>
                        <li class="fs20"><a class="as " href="/Goods/Index/114">唱片EP</a></li>
                        <li class="fs20"><a class="as " href="/Goods/Index/115">生写照片</a></li>
                        <li class="fs20"><a class="as " href="/Goods/Index/116">文具品</a></li>
                        <li class="fs20"><a class="as " href="/Goods/Index/117">饰品</a></li>
                        <li class="fs20"><a class="as " href="/Goods/Index/118">日用服饰</a></li>
                        <li class="fs20"><a class="as " href="/Goods/Index/119">应援品</a></li>
                        <li><a class="ido" href="/Goods/CostumeInfo/123">IDOLS GENERATION
                            <div>时尚潮牌服饰</div>
                        </a></li>
                    </ul>
                </li>
                <li class="dh_3 fl"><a href="/">首页</a></li>


                <li class="dh_2 fl"><a href="/goods/integral">积分商品</a></li>
                <li class="dh_2 fl"><a href="/pai">竞价中心</a></li>
                <li class="dh_2 fl"><a href="https://pay.48.cn//Bank/OAuth/pay?s=VDB3eHhaODJDNXc9">丝瓜钱包充值</a></li>


            </ul>
        </div>
    </div>
</div>
<div class="body-content">


    <div class="ny_list">


        <div class="ny_kuang">
            <a href="/pai" class="ny_choice">全部</a>
            <div class="fl pr" onmouseover="MM_over(this)" onmouseout="MM_out(this)">
                <a href="#" class="ny_choice">演出组合</a>
                <div class="jg_p a1" style="width:50px;">
                    <a href="?orderField=&amp;key=&amp;auction=&amp;brand_id=0">GROUP</a><br>
                    <a href="?orderField=&amp;key=&amp;auction=&amp;brand_id=1">SNH48</a><br>
                    <a href="?orderField=&amp;key=&amp;auction=&amp;brand_id=2">BEJ48</a><br>
                    <a href="?orderField=&amp;key=&amp;auction=&amp;brand_id=3">GNZ48</a><br>
                    <a href="?orderField=&amp;key=&amp;auction=&amp;brand_id=4">SHY48</a>
                </div>
            </div>

            <div class="fl pr" onmouseover="MM_over(this)" onmouseout="MM_out(this)">
                <a href="#" class="ny_choice">价格排序</a>
                <div class="jg_p a1" style="display: none;">
                    <a href="?orderField=4&amp;key=&amp;auction=&amp;brand_id=-1">价格从高到低排序</a><br>
                    <a href="?orderField=5&amp;key=&amp;auction=&amp;brand_id=-1">价格从低到高排序</a>
                </div>
            </div>
            <div class="ny_sel"><input name="" type="checkbox" class="chkauction" value="1"> 仅显示正在竞价的商品</div>


        </div>

        <div class="goods">

<s:iterator value="goodsList" var="goods" status="status" >

    <div class="gs_xx">
        <ul>
            <li class="gs_1"><a href="/item/<s:property  value="goods_id"/> "> <img
                    src="<s:property value="%{goodsInfoList[#status.index].goods_image1}"/> " width="285"
                    height="285"></a></li>
            <li class="gs_2">
                <a href="/item/<s:property value="goods_id"/>"><s:property value="%{goodsInfoList[#status.index].goods_title}"/> </a>
            </li>
            <li class="gs_3">
                <span class="icon ic_xh">现货</span>


                <span class="icon ic_p">竞</span>
            </li>
            <li class="gs_4">当前现金：<span class="jg">￥0.00</span></li>
            <li class="gs_l"></li>
            <li class="gs_6">
                <span>
                                    竞价状态：<span class="actionstatus"></span>
                                    <br>

                                    <span data-two="<s:date name='#goods.final_time' format="yyyy/MM/dd HH:mm:ss"/>  " class="auctionList lxftime"
                                          data-enddate="<s:date name='#goods.start_time' format="yyyy/MM/dd HH:mm:ss"/>  "></span>
                                </span>
            </li>
        </ul>

    </div>
</s:iterator>



            <div class="gs_xx">
                <ul>
                    <li class="gs_1"><a href="/pai/item/1307"> <img
                            src="https://file.48.cn/Shop/Product//Index/201704140527160822.png" width="285"
                            height="285"></a></li>
                    <li class="gs_2">
                        <a href="/pai/item/1307">星梦剧院4月28日SNH48公演 VIP票 雨中钢琴师 UNIT签名版</a>
                    </li>
                    <li class="gs_3">
                        <span class="icon ic_1">SNH48</span>
                        <span class="icon ic_xh">现货</span>
                        <span class="icon ic_xn">虚拟商品</span>


                        <span class="icon ic_p">竞</span>
                    </li>
                    <li class="gs_4">当前现金：<span class="jg">￥0.00</span></li>
                    <li class="gs_l"></li>
                    <li class="gs_6">
                        <span class="icon ic_cj">0次出价</span>
                        <span>
                                    竞价状态：<span class="actionstatus">未开始</span>
                                    <br>

                                    <span data-two="2017/04/17 19:00:00" class="auctionList lxftime"
                                          data-enddate="2017/04/17 17:00:00">2天16时8分23秒开始</span>
                                </span>
                    </li>
                </ul>

            </div>


            <div class="gs_xx">
                <ul>
                    <li class="gs_1"><a href="/pai/item/1307"> <img
                            src="https://file.48.cn/Shop/Product//Index/201704140527160822.png" width="285"
                            height="285"></a></li>
                    <li class="gs_2">
                        <a href="/pai/item/1307">星梦剧院4月28日SNH48公演 VIP票 雨中钢琴师 UNIT签名版</a>
                    </li>
                    <li class="gs_3">
                        <span class="icon ic_1">SNH48</span>
                        <span class="icon ic_xh">现货</span>
                        <span class="icon ic_xn">虚拟商品</span>


                        <span class="icon ic_p">竞</span>
                    </li>
                    <li class="gs_4">当前现金：<span class="jg">￥0.00</span></li>
                    <li class="gs_l"></li>
                    <li class="gs_6">
                        <span class="icon ic_cj">0次出价</span>
                        <span>
                                    竞价状态：<span class="actionstatus">未开始</span>
                                    <br>

                                    <span data-two="2017/04/17 19:00:00" class="auctionList lxftime"
                                          data-enddate="2017/04/17 17:00:00">2天16时8分23秒开始</span>
                                </span>
                    </li>
                </ul>

            </div>


        </div>

        <div class="fr ma_b10 msdn" id="pagination">
            <div class="pagination"><span class="current prev">&lt;</span><span class="current">1</span><a
                    href="/pai?totalCount=1223&amp;pageNum=1&amp;brand_id=-1">2</a><a
                    href="/pai?totalCount=1223&amp;pageNum=2&amp;brand_id=-1">3</a><a
                    href="/pai?totalCount=1223&amp;pageNum=3&amp;brand_id=-1">4</a><a
                    href="/pai?totalCount=1223&amp;pageNum=4&amp;brand_id=-1">5</a><a
                    href="/pai?totalCount=1223&amp;pageNum=5&amp;brand_id=-1">6</a><a
                    href="/pai?totalCount=1223&amp;pageNum=6&amp;brand_id=-1">7</a><a
                    href="/pai?totalCount=1223&amp;pageNum=7&amp;brand_id=-1">8</a><a
                    href="/pai?totalCount=1223&amp;pageNum=8&amp;brand_id=-1">9</a><a
                    href="/pai?totalCount=1223&amp;pageNum=9&amp;brand_id=-1">10</a><a
                    href="/pai?totalCount=1223&amp;pageNum=10&amp;brand_id=-1">11</a><a
                    href="/pai?totalCount=1223&amp;pageNum=1&amp;brand_id=-1" class="next">&gt;</a></div>
        </div>

    </div>


</div>


<script src="/js/jquery-3.2.0.min.js"></script>
<%--<script src="/js/jquery.lazy.js"></script>--%>
<script src="/js/layer/layer.js"></script>
<script src="/js/snh48base.js"></script>

<script src="/js/jquery.pagination.js"></script>

<script type="text/javascript">
    $(function () {//选页按钮
        $("#pagination").pagination(${totalCount},
            {
                items_per_page: 20,
                current_page: 0,
                prev_text: "<",
                next_text: ">",
                link_to: "/index?totalCount=${totalCount}&pageNum=__id__&brand_id=-1",//分页的js中会自动把"__id__"替换为当前的数
                callback: pageselectCallback,
                show_if_single_page: false,
                load_first_page: true
            });
        function pageselectCallback() {
            return true;
        }

        $(".chkauction").click(function () {

            if ($(this).is(":checked")) {
                location.href = "?key=&brand_id=-1&orderField=&auction=" + $(this).val();
            }
            else {
                location.href = "?key=&orderField=&brand_id=-1";
            }

        })

        $("#btnsearch").click(function () {
            location.href = "?key=" + $("#txtsearch").val();

        });


    });


    function lxfEndtime() {

        var i = 0;

        $(".lxftime").each(function () {
            i++;


            var content = "";
            var flag = false;
            //var lxfday=$(this).attr("lxfday");//用来判断是否显示天数的变量
            var endtime = new Date($(this).attr("data-enddate")).getTime();

            //取结束日期(毫秒值)
            var nowtime = new Date().getTime() + difference_time;
            //今天的日期(毫秒值)
            var youtime = endtime - nowtime;//还有多久(毫秒值)
            var seconds = youtime / 1000;
            var minutes = Math.floor(seconds / 60);
            var hours = Math.floor(minutes / 60);
            var days = Math.floor(hours / 24);
            var CDay = days;
            var CHour = hours % 24;
            var CMinute = minutes % 60;
            var CSecond = Math.floor(seconds % 60);


            //"%"是取余运算，可以理解为60进一后取余数，然后只要余数。
            if (endtime <= nowtime) {
                if ($(this).attr("data-two") != "") {

                    $(this).attr("data-enddate", $(this).attr("data-two"));
                    $(this).attr("data-two", "");
                    $(this).parent().find(".actionstatus").html("竞价进行中");

                }
                else {
                    $(this).removeClass("lxftime");
                    $(this).html("已结束")

                }

                //如果结束日期小于当前日期就提示过期啦
            } else {
                if (flag || days > 0) {
                    flag = true;
                    content += days + "天";
                }
                if (flag || CHour > 0) {
                    flag = true;
                    content += CHour + "时";
                }
                if (flag || CMinute > 0) {
                    flag = true;
                    content += CMinute + "分";
                }

                if (flag || CSecond > 0) {
                    flag = true;
                    content += CSecond + "秒";
                }


                if ($(this).attr("data-two") == "") {
                    content += "结束";
                    //输出没有天数的数据
                } else {
                    content += "开始";  //输出有天数的数据
                }

                $(this).html(content);
            }

        });

        if (i > 0) {
            setTimeout("lxfEndtime()", 1000);
        }
    }
    ;
    var difference_time = 0;
    $(function () {
        var date1 = new Date();
        $.ajax({
            type: 'HEAD',
            async: true,
            success: function (data, status, xhr) {
                d = new Date(xhr.getResponseHeader('Date'));
                d = calcTime(d.getTime(), 8);
                var n = d.getTime() - new Date().getTime();
                if (difference_time = -1000000) {
                    difference_time = n - 300;
                    lxfEndtime();
                }
            },
            error: function () {
                alert("获取服务器时间失败");
                return;
            }
        })
    })
    function calcTime(d, offset) {

        // create Date object for current location
        e = new Date();

        // convert to msec
        // add local time zone offset
        // get UTC time in msec
        utc = d + (e.getTimezoneOffset() * 60000);

        // create new Date object for different city
        // using supplIEd offset
        nd = new Date(utc + (3600000 * offset));

        // return time as a string
        return nd;
    }
</script>


<script>

    $(function () {

        if ("" != "1") {

            $(".dh_1").hover(function () {
                $(".columns").show();
            }, function () {
                $(".columns").hide();
            });
        }
        $("#topsearch").click(function () {

            location.href = "/Goods?key=" + encodeURIComponent($("#topkey").val());
        })

        $("#topkey").keydown(function (e) {
            var key = e.which;
            if (key == 13 || (key == 10 && $.browser.msie && $.browser.version <= 6.0)) {
                $("#topsearch").click();
            }
        });


    })
</script>


</body>
</html>