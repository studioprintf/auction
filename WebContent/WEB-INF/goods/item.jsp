<%--
  Created by IntelliJ IDEA.
  User: Dymond
  Date: 2017/4/11
  Time: 14:18
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
    <title>${GoodsInfo.goods_title}</title>
    <link href="/css/css20170221.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="/css/highslide.css">
    <link rel="stylesheet" type="text/css" href="/css/magiczoom.css">


    <style></style>

    <style type="text/css">.highslide img {
        cursor: url(/highslide/graphics/zoomin.cur), pointer !important;
    }

    .highslide-viewport-size {
        position: fixed;
        width: 100%;
        height: 100%;
        left: 0;
        top: 0
    }</style>
</head>
<body style="height: 100%">
<div class="top">
    <div class="top_k">

        <div class="top_1 a1">


            <form action="/Account/LogOff" class="navbar-right" id="logoutForm" method="post"><input
                    name="__RequestVerificationToken" type="hidden"
                    value="05zTx-5isbCGoyWDZ-_CFXmyEAQJOaRcgs9MMaDv-6wlcElwZbuvTJAgU6Kq_gzi7PD_HZQxuliO8ZPhSOf-2AYzHCFxmhQkvs79A4QXhZ0fePeGeRNgFrWlEHD65qrD_K7MeTbJCtPMqpU4zYwmow2">
                <div class="login fl">
                    欢迎使用在线拍卖系统&nbsp;&nbsp;&nbsp;&nbsp; <a
                        href="${pageContext.request.contextPath}/user/user">你好${sessionScope.get("USER_NAME")}</a>

                    <a href="http://user.snh48.com/shop48.php?return_url=https://shop.48.cn" id="logout2">退出</a>
                </div>
            </form>


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

            // 设置为主页
            function SetHome(obj, vrl) {
                try {
                    obj.style.behavior = 'url(#default#homepage)';
                    obj.setHomePage(vrl);
                }
                catch (e) {
                    if (window.netscape) {
                        try {
                            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                        }
                        catch (e) {
                            layer.msg("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
                        }
                        var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
                        prefs.setCharPref('browser.startup.homepage', vrl);
                    } else {
                        layer.msg("您的浏览器不支持，请按照下面步骤操作：1.打开浏览器设置。2.点击设置网页。3.输入：" + vrl + "点击确定。");
                    }
                }
            }
            // 加入收藏 兼容360和IE6
            function Addfavorite(sTitle, sURL) {
                try {
                    window.external.addFavorite(sURL, sTitle);
                }
                catch (e) {
                    try {
                        window.sidebar.addPanel(sTitle, sURL, "");
                    }
                    catch (e) {
                        layer.msg("加入收藏失败，请使用Ctrl+D进行添加");
                    }
                }
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
                        <div>时尚潮牌服饰</div>
                        </a></li>
                    </ul>
                </li>
                <li class="dh_3 fl"><a href="/">首页</a></li>


                <li class="dh_2 fl"><a href="/pai">竞价中心</a></li>
                <li class="dh_2 fl"><a href="https://pay.48.cn//Bank/OAuth/pay?s=MUh0RGZaQXRua2M9">丝瓜钱包充值</a></li>
                <li class="dh_2 fl"><a href="http://vip.48.cn/" target="_blank">VIP中心</a></li>

            </ul>
        </div>
    </div>
</div>
<div class="body-content">


    <div class="ny_list">

        <div class="item">


            <div class="i_pic">
                <div class="pic_m">
                    <a href="https://file.48.cn/Shop/Product//Index/B_201704050302556130.png" class="MagicZoom" id="sp"
                       rel="zoom-position:inner;zoom-fade:true;"
                       style="position: relative; display: inline-block; text-decoration: none; outline: 0px; width: 380px;"
                       title=""><img width="380" height="380"
                                     src="${GoodsInfo.goods_image1}"
                                     style="opacity: 1;">
                        <div class="MagicZoomBigImageCont"
                             style="overflow: hidden; z-index: 100; top: -100000px; position: absolute; width: 300px; height: 300px;">
                            <div class="MagicZoomHeader"
                                 style="position: relative; z-index: 10; left: 0px; top: 0px; padding: 3px; display: none; visibility: hidden;"></div>
                            <div style="overflow: hidden;"><img
                                    src="https://file.48.cn/Shop/Product//Index/B_201704050302556130.png"
                                    style="padding: 0px; margin: 0px; border: 0px;"></div>
                            <div style="color: rgb(255, 0, 0); font-size: 10px; font-weight: bold; font-family: Tahoma; position: absolute; width: 100%; text-align: center; left: 0px;"></div>
                        </div>
                    </a>
                </div>
                <div class="pic_list">


                    <a href="${GoodsInfo.goods_image1}" rel="zoom-id:sp;"
                       rev="${GoodsInfo.goods_image1}" style="outline: 0px;"><img
                            src="${GoodsInfo.goods_image1}" width="65" height="65"></a>


                </div>
            </div>


            <div class="i_txt ma_b10">
                <ul>
                    <li class="i_tit">${GoodsInfo.goods_title}</li>
                    <li class="i_num">


                        <span class="icon ic_xh">现货</span>
                        <%--<span class="icon ic_xn">虚拟商品</span>--%>

                        <span class="icon ic_p">竞</span>
                    </li>
                </ul>
            </div>
            <div class="i_txt">
                <div class="pai_l">
                    <ul>
                        <li><span id="leftTime"></span></li>
                        <li class="b_gray">竞价状态：
                            <span id="a_s">距竞价开始还有</span>
                            <span class="pink t" id="showcount_down"></span><!--已结束-->

                        </li>

                        <li>起拍价：<span class="fbold"> ${Goods.reserve_price}</span>元</li>
                        <li>最低加价幅度：<span class="fbold"> ${Goods.limit_price}</span>元</li>
                        <%--<li><span class="gray ">您的剩余积分：</span><span id="sp_point" class="gray "><span id="sp_point_show"--%>
                        <%--name="sp_point_show"> 7301</span> <input--%>
                        <%--type="button" class="hidden" value="查看最新积分" id="btn_point"--%>
                        <%--style="background-color: #18b4ed;border:none;color:#fff;border-radius: 5px;cursor:pointer;"></span>--%>
                        <%--</li>--%>
                        <li class="b_gray"><span class="gray">当前最高金额： </span><span id="sp_price">0</span>（人出价）
                        </li>
                        <li class="b_gray">押金：<span class="pink">￥<span
                                class="f30"> ${Goods.reserve_price} </span></span></li>
                        <li id="btnb_gray" class="b_gray l_p hidden">
                            <a href="javascript:;" id="ToAuction" class="pink_nb f16 ma_b20">立即参与竞价</a>
                        </li>
                        <li class="b_gray l_a hidden">
                            <label class="fl" style="padding-top:6px">价格 ：</label>
                            <input type="text" class="fl painpunt"
                                   style="width:55px;text-align:center;"
                                   id="txt_amt"><span
                                class="hidden" id="sp_count">
                            <%--<label class="fl"> 数量：</label>--%>
                            <%--<input type="text" value="1"--%>
                                   <%--class="fl painpunt"--%>
                                   <%--style="width:35px;"--%>
                                   <%--id="txt_num">--%>
                            </span><a
                                id="ToBids" href="javascript:;" class="pink_nb f16 ma_b20">出价</a>
                        </li>
                    </ul>

                    <div class="l_b">16 人参与竞价&nbsp;&nbsp; <span class="fr"></span></div>
                </div>
                <div class="pai_r">
                    <div class="lan_tit ma_b5">出价记录</div>
                    <div class="pr_list ma_b10">
                        <ul>
                            <li class="pr_tl"><span class="pr_1">状态</span><span class="pr_2">出价人</span><span
                                    class="pr_3">价格</span></li>
                            <li>
                                <div>
                                    <ul id="u_showlist"></ul>
                                </div>
                            </li>
                            <li class="pr_c a1"><a class="pointer"
                                                   onclick="$('html,body').animate({scrollTop:$('#s_blist').offset().top},1000)">查看更多出价记录</a>
                            </li>
                            <li class="pr_tl"></li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>

        <div class="item">
            <div class="pai_lc"><img src="/img/pai_sm_tit3.jpg"></div>
            <div class="ny_kuang" id="bg">
                <div id="font1" class="ny_choice_se"
                     onclick="setTab03Syn(1);document.getElementById('bg').className='ny_kuang'">商品详细介绍
                </div>
                <div id="showBidsList" class="ny_choice" data-id="TabTab03Con2"
                     onclick="setTab03Syn(2);document.getElementById('bg').className='ny_kuang'">出价记录
                </div>
                <div id="showEvaluationList" class="ny_choice" data-id="TabTab03Con3"
                     onclick="setTab03Syn(3);document.getElementById('bg').className='ny_kuang'"></div>
            </div>
            <div class="item_k">
                <div class="lb_1" id="TabTab03Con1" style="display: block;">
                    ${GoodsInfo.goods_describe}
                </div>
                <div class="lb_2" id="TabTab03Con2" style="display: none;">
                    <div class="pai_lc_tit" id="bidsListShow">出价记录</div>
                    <span id="s_blist"></span>
                    <div id="d_blist" style="">
                        <div class="p_jl ma_r20">
                            <ul>
                                <li>
                                    <span class="jl_1 jl_tit">状态</span>
                                    <span class="jl_2 jl_tit">出价人</span>
                                    <span class="jl_2 jl_tit">出价时间</span>
                                    <span class="jl_3 jl_tit">出价价格</span>
                                </li>
                            </ul>
                            <ul id="u_blist">
                                <li><span class="jl_1 pink">中标</span><span class="jl_2">kikuscup</span><span
                                        class="jl_2">2017/04/05 18:59:46</span><span class="jl_3 pink">16180</span></li>
                                <li><span class="jl_1 pink">中标</span><span class="jl_2">KaKaflying</span><span
                                        class="jl_2">2017/04/05 18:59:56</span><span class="jl_3 pink">12000</span></li>
                                <li><span class="jl_1 pink">中标</span><span class="jl_2">Bulls</span><span class="jl_2">2017/04/05 18:59:03</span><span
                                        class="jl_3 pink">11111</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">Knight_of_Night</span><span
                                        class="jl_2">2017/04/05 18:59:56</span><span class="jl_3 pink">7909</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">nscrc</span><span
                                        class="jl_2">2017/04/05 18:59:55</span><span class="jl_3 pink">7429</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span
                                        class="jl_2">maxi_moralez</span><span
                                        class="jl_2">2017/04/05 18:59:57</span><span class="jl_3 pink">6830</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">Perfectliz</span><span
                                        class="jl_2">2017/04/05 18:59:57</span><span class="jl_3 pink">6777</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">onhouba</span><span
                                        class="jl_2">2017/04/05 18:59:55</span><span class="jl_3 pink">6000</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">paopaomola</span><span
                                        class="jl_2">2017/04/05 18:59:52</span><span class="jl_3 pink">5909</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span
                                        class="jl_2">maxi_moralez</span><span
                                        class="jl_2">2017/04/05 18:59:45</span><span class="jl_3 pink">5830</span></li>
                            </ul>
                        </div>
                        <div class="p_jl d_blist">
                            <ul>
                                <li>
                                    <span class="jl_1 jl_tit">状态</span>
                                    <span class="jl_2 jl_tit">出价人</span>
                                    <span class="jl_2 jl_tit">出价时间</span>
                                    <span class="jl_3 jl_tit">出价价格</span>
                                </li>
                            </ul>
                            <ul id="u_blistM">
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">expangzi</span><span
                                        class="jl_2">2017/04/05 18:59:48</span><span class="jl_3 pink">5667</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">丨甄丨330</span><span
                                        class="jl_2">2017/04/05 18:59:56</span><span class="jl_3 pink">4330</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span
                                        class="jl_2">snh48071284236</span><span
                                        class="jl_2">2017/04/05 18:59:38</span><span class="jl_3 pink">3666</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">WSi</span><span
                                        class="jl_2">2017/04/05 18:59:07</span><span class="jl_3 pink">3456</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">lkkl1001</span><span
                                        class="jl_2">2017/04/05 18:59:06</span><span class="jl_3 pink">2333</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span
                                        class="jl_2">snh48071284236</span><span
                                        class="jl_2">2017/04/05 18:47:22</span><span class="jl_3 pink">1666</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">kikuscup</span><span
                                        class="jl_2">2017/04/05 18:46:09</span><span class="jl_3 pink">1233</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span
                                        class="jl_2">snh48071284236</span><span
                                        class="jl_2">2017/04/05 18:41:42</span><span class="jl_3 pink">1000</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">yaolin5888</span><span
                                        class="jl_2">2017/04/05 18:33:18</span><span class="jl_3 pink">800</span></li>
                                <li><span class="jl_1 pink">&nbsp;&nbsp;</span><span class="jl_2">治愈型mayuyu</span><span
                                        class="jl_2">2017/04/05 18:37:07</span><span class="jl_3 pink">1</span></li>
                            </ul>
                        </div>
                        <div class="clearfix"></div>
                        <div class="jl_page ma_t10 pageShowB">
                            <span class="a2"><a href="javascript:;" id="a_b_u">&lt;</a></span>&nbsp;&nbsp;
                            <span class="pink b_n">1</span> /
                            <span class="pink b_c">1</span>&nbsp;&nbsp;
                            <span class="a2"><a href="javascript:;" id="a_b_n">&gt;</a></span>
                        </div>
                    </div>
                </div>
                <div class="lb_3" id="TabTab03Con3" style="display: none;">

                </div>

            </div>

        </div>


    </div>


</div>


<script src="/js/jquery-3.2.0.min.js"></script>
<%--<script src="/js/jquery.lazy.js"></script>--%>
<script src="/js/layer/layer.js"></script>
<link rel="stylesheet" href="/js/layer/skin/default/layer.css" id="layui_layer_skinlayercss" style="">
<script src="/js/snh48base.js"></script>


<script type="text/javascript" src="/js/highslide-with-gallery.js"></script>
<script type="text/javascript" src="/js/highslide.js"></script>
<script type="text/javascript" src="/js/magiczoom.js"></script>

<script>
    var uid = ${Goods.goods_id};
    var reverse_price= ${Goods.reserve_price};
    var _brand_id = 2;
    var limit = ${Goods.limit_price};
    var markupPrice = 30.00;
    //    $("#sp_ts").html(1);
    var listname = "";
    var listname2 = "";
    var goodsnum = 3;
    var nums = 0;
    var nums2 = 0;
    var avatar = "https://uc.48.cn/avatar.php?uid={0}&size={1}";
    $(function () {
        $("#ToBuy").click(function () {
            var oid = "";
            $.ajax({
                url: "/pai/subOrderToTickets",
                type: "post",
                dataType: "json",
                data: {id: uid, r: Math.random()},
                success: function (data) {
                    oid = data;
                    if ("" == "T") {
                        if (oid == "") {
                            layer.msg("购买失败！");
                            return;
                        }
                        else {
                            location.href = "/TOrder/item/" + oid;
                        }

                    }
                    else {
                        if (oid == "") {
                            location.href = "/order/pai?id=" + 1279;
                        }
                        else {
                            location.href = "/order/item/" + oid;
                        }
                    }
                }
            });


        })

        <%--var user_id = ${sessionScope.get("USER_ID")};--%>
//        alert("user_id:" + user_id)
//        $("#btn_point").click(function () {
//            $.ajax({
//                url: "/account/GetInfoPoint",
//                type: "get",
//                dataType: "text",
//                data: {uid: user_id, isReturnPoint: true, r: Math.random()},
//                success: function (data) {
//                    if (data != "") {
//                        layer.msg("更新成功");
//                        $("#sp_point_show").html("");
//                        $("#sp_point_show").html(data);
//                    }
//                    else {
//                        layer.msg("更新失败");
//                    }
//
//                }
//            });
//        })

        //点击 立刻参与竞价 锁定押金
        $("#ToAuction").click(function () {
            layer.confirm('参与拍卖将会冻结相关押金，确认参与吗？', {
                btn: ['参与', '不参与']
            }, function () {
                $.ajax({
                    url: "/pai/CheckUserInfo",
                    type: "post",
                    dataType: "json",
                    data: {id: uid, brand_id: _brand_id, r: Math.random()},
                    success: function (data) {
                        //if(data.viewIsNum)
                        //{
                        //    $("#sp_count").show();
                        //}
                        //else
                        //{
                        //    $("#sp_count").hide();
                        //}
                        if (!data.retValue.HasError) {
                            layer.msg("参与成功，并锁定竞价押金！");
                            $(".l_p").hide();
                            $(".l_a").show();
                        }
                        else {
                            var ms = data.retValue.Message == "" ? "对不起，您暂时不能参与竞价!" : data.retValue.Message;
                            layer.msg(ms);
                            $(".l_p").show();
                            $(".l_a").hide();
                            return;
                        }
                    }
                });

            }, function () {
                return;

            });

        })



        $("#ToBids").click(function () {
            var amt = $("#txt_amt").val();
//            var num = $("#txt_num").val();
            if (amt == "") {
                layer.msg("请输入竞价价格");
                return;
            }
//            if (num == "") {
//                layer.msg("请输入竞价数量");
//                return;
//            }
            amt = parseInt(amt);
            reverse_price = parseInt(reverse_price);
            if (!(amt>reverse_price)){
                layer.msg("请输入大于底价的价格");
                return;
            }
            if (!((amt-reverse_price)%limit==0)) {
                layer.msg("请输入加价幅度的整数倍的价格");
                return;
            }
            $.ajax({
                url: "/auction/ToBids",
                type: "post",
//                dataType: "json",
                data: {
                    id: uid,
                    amt: amt,
//                    r: Math.random()
                },
                success: function (data) {
                    if (data == "1") {
                        layer.msg("出价成功");
                        //location.reload();
                        SetInfoB(uid, 20, 0);
                        getInfoByTime();
                        //$("#txt_amt").val( markupPrice+ parseFloat($("#txt_amt").val()));
                        //   $("#sp_ts").html(markupPrice+ parseFloat($("#txt_amt").val()));
                        return;
                    }
                    else {
                        var ms = data == "" ? "出价失败!" : data;
                        layer.msg(ms);
                        return;
                    }
                }
            });
        })

        $("#txt_amt").keyup(function () {
            $(this).val($(this).val().replace(/[^0-9_]/g, []));
        })
        $("#txt_amt").blur(function () {
            $(this).val($(this).val().replace(/[^0-9_]/g, []));
        })


        $("#showBidsList").click(function () {
            document.getElementById("TabTab03Con1").style.display = "none";
            document.getElementById("TabTab03Con2").style.display = "block";
            document.getElementById("TabTab03Con3").style.display = "none";
            document.getElementById("font1").className = "ny_choice";
            document.getElementById("showBidsList").className = "ny_choice_se";
            document.getElementById("showEvaluationList").className = "ny_choice";
        })
        $("#showEvaluationList").click(function () {
            document.getElementById("TabTab03Con1").style.display = "none";
            document.getElementById("TabTab03Con2").style.display = "none";
            document.getElementById("TabTab03Con3").style.display = "block";
            document.getElementById("font1").className = "ny_choice";
            document.getElementById("showBidsList").className = "ny_choice";
            document.getElementById("showEvaluationList").className = "ny_choice_se";
        })
        $("#font1").click(function () {
            document.getElementById("TabTab03Con1").style.display = "block";
            document.getElementById("TabTab03Con2").style.display = "none";
            document.getElementById("TabTab03Con3").style.display = "none";
            document.getElementById("font1").className = "ny_choice_se";
            document.getElementById("showBidsList").className = "ny_choice";
            document.getElementById("showEvaluationList").className = "ny_choice";
        })

        $("#a_b_u").click(function () {

            var bn = $(".b_n").text();
            if (bn == 1) {
                layer.msg("已经是第一页");
                return;

            }
            SetInfoB(uid, 20, bn - 1);
        })

        $("#a_b_n").click(function () {
            var bn = $(".b_n").text();
            var bc = $(".b_c").text();
            if (bn == bc) {
                layer.msg("已经是最后一页");
                return;
            }
            SetInfoB(uid, 20, parseInt(bn, 0) + 1);
        })

        $("#a_p_u").click(function () {

            var pn = $(".p_n").text();
            if (pn == 1) {
                layer.msg("已经是第一页");
                return;
            }
            var pc = $(".p_c").text();
            SetInfoP(uid, 8, pc - 1);
        })

        $("#a_p_n").click(function () {

            var pn = $(".p_n").text();
            var pc = $(".p_c").text();
            if (pn == pc) {
                layer.msg("已经是最后一页");
                return;
            }
            SetInfoP(uid, pc);
        });

        var paiMsg = "";


        //出价记录
//        function SetInfoP(uid, pn, pc) {
//
//            $.ajax({
//                url: "/pai/GetShowEvaluations",
//                type: "post",
//                dataType: "json",
//                data: {id: uid, numPerPage: pn, pageNum: pc, r: Math.random()},
//                success: function (data) {
//
//                    if (data.list != "") {
//                        var content = "";
//                        $.each(data.list, function (commentIndex, comment) {
//                            content += '<div class="pj_xx_p fl">';
//                            content += '<div class="xx_pic a1">';
//                            content += '<a href="#">';
//                            content += '<img src="' + avatar.format(comment.user_id, "small") + '" width="80" height="80"><br>' + comment.user_name;
//                            content += '</a><br>（' + comment.user_rank + '）</div>';
//                            content += '<div class="xx_txt">';
//                            content += '<div class="ly">';
//                            content += '<span class="ly_s">' + comment.evaluation_content + '</span>';
//                            content += '<span class="tim">' + comment.evaluation_time + '</span>';
//                            content += '</div>';
//                            content += '</div>';
//                            content += '</div>';
//                        });
//
//                        $("#s_plist").html(content);
//                        $(".p_n").html(data.pageNum);
//                        $(".p_c").html(data.PageCount);
//                        $(".pageShowP").show();
//
//                    }
//                    else {
//                        $("#s_plist").html("暂无记录");
//                        $(".pageShowP").hide();
//                    }
//
//                }
//
//            });
//        }

        function SetInfoB(uid, pn, pc) {
            $.ajax({
                url: "/pai/GetShowBids",
                type: "post",
                dataType: "json",
                data: {
                    id: uid,
                    numPerPage: pn,//第n页
                    pageNum: pc,
//                    r: Math.random()
                },
                success: function (data) {
                    if (data.viewPrice != "") {
                        $("#sp_price").html(data.viewPrice);
                    }
                    if (data.list != "") {
                        var content = "";
                        var content1 = "";
                        var content2 = "";
                        var isT = "";

                        $.each(data.list, function (commentIndex, comment) {

                            if ($("#showcount_down").text().trim() != "已结束") {
                                if (comment.auction_status == 1) {
                                    isT = "领先";
                                }
                                else {
                                    isT = "&nbsp;&nbsp;";
                                }
                            }
                            else {
                                if (comment.auction_status == 1) {
                                    isT = "中标";
                                }
                                else {
                                    isT = "&nbsp;&nbsp;";
                                }
                            }
                            if (commentIndex < 20) {
                                if (commentIndex < 10) {
                                    content += '<li>';
                                    content += '<span class="jl_1 pink">' + isT + '</span>';
                                    content += '<span class="jl_2">' + comment.user_name + '</span>';
                                    content += '<span class="jl_2">' + DateFormat(comment.bid_time, "yyyy/MM/dd HH:mm:ss") + '</span>';
                                    content += '<span class="jl_3 pink">' + comment.bid_amt + '</span>';
                                    content += '</li>';


                                }
                                else {
                                    content1 += '<li>';
                                    content1 += '<span class="jl_1 pink">' + isT + '</span>';
                                    content1 += '<span class="jl_2">' + comment.user_name + '</span>';
                                    content1 += '<span class="jl_2">' + DateFormat(comment.bid_time, "yyyy/MM/dd HH:mm:ss") + '</span>';
                                    content1 += '<span class="jl_3 pink">' + comment.bid_amt + '</span>';
                                    content1 += '</li>';
                                }
                            }

                        });

                        //$("#u_showlist").html("");
                        //$("#u_showlist").html(content2);

                        $("#s_blist").html("");
                        $("#d_blist").show();
                        $("#u_blist").html(content);
                        $("#u_blistM").html(content1);
                        $(".b_n").html(data.pageNum);
                        $(".b_c").html(data.PageCount);
                        $(".pageShowB").show();
                    }
                    else {
                        $("#s_blist").html("暂无记录");
                        $("#d_blist").hide();
                        $(".pageShowB").hide();

                    }
                }

            });
        }


        //加载评价与出价记录
//        SetInfoP(uid, 8, 0);

//        SetInfoB(uid, 20, 0);

//        getInfoByTime();//更新出价列表

        if (Coudown < 2) {//结束前更新时间
//            getDate();
            getServTime();
        }

        else {
            $("#showcount_down").html("已结束")
        }

    })


    function getInfoByTime() {//每3秒更新右出价列表
        if ($("#showcount_down").val() != "已结束") {
            $.ajax({
                url: "/pai/GetRightShowBids",
                type: "get",
                dataType: "json",
                data: {id: uid, r: Math.random()},
                success: function (data) {
                    if (data.viewPrice != "") {
                        $("#sp_price").html(data.viewPrice);
                    }
                    if (data.list != "") {
                        var content = "";
                        var isT = "";
                        $.each(data.list, function (commentIndex, comment) {
                            if ($("#showcount_down").text().trim() != "已结束") {
                                if (comment.auction_status == 1) {
                                    isT = "领先";
                                }
                                else {
                                    isT = "&nbsp;&nbsp;";
                                }

                            }
                            else {
                                if (comment.auction_status == 1) {
                                    isT = "中标";
                                }
                                else {
                                    isT = "&nbsp;&nbsp;";
                                }
                            }

                            if (commentIndex < 5) {
                                content += '<li class="b_gray">';
                                content += '<span class="pr_1 pink">' + isT + '</span>';
                                content += '<span class="pr_2">' + comment.user_name + '</span>';
                                content += '<span class="pr_3 pink">' + comment.bid_amt + '</span>';
                                content += '</li>';
                            }

                        });

                        $("#u_showlist").html("");
                        $("#u_showlist").html(content);
                        var t = setTimeout("getInfoByTime()", 3000);
                    }
                    else {
                        var t = setTimeout("getInfoByTime()", 3000);
                    }


                }

            });
        }

    }

    var endtime;
    var Coudown = 0;//0=等待  1=在售 2=结束
    var difference_time = -1000000;//时差初始值
    var endSay = "";
    function lxfEndtime() {
        var content = "";
        var flag = false;

        //取结束日期(毫秒值)
        var nowtime = new Date().getTime() + difference_time;


        var endtime;
        switch (Coudown) {
            case 0://等待开始
                var t = "${Goods.start_time}".replace(/\-/g, "/");
                endtime = new Date(t).getTime();
//                alert("endtime0:" + t);
                break;
            case 1://正在竞拍
                var t = "${Goods.final_time}".replace(/\-/g, "/");
                endtime = new Date(t).getTime();

//                alert("endtime1:" + t);
                break;
            case 2:

                break;
        }

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
            switch (Coudown) {
                case 0:
                    Coudown = 1;
                    $("#btnb_gray").show();
                    lxfEndtime();
                    $("#a_s").html("距竞价结束还有 ");
                    return;
                case 1:
                    Coudown = 2;
                    var t = "${Goods.final_time}".replace(/\-/g, "/");
                    endtime = new Date(t).getTime();
                    $("#a_s").html("");
                    $("#showcount_down").html("已结束");
                    $("#btnb_gray").hide();

                    setTimeout("location.reload();", 20000);
                    endSay = "后结束";
                    return;
                case 2:
                    $("#showcount_down").html("已结束");
                    $("#a_s").html("");
                    $("#btnb_gray").hide();
                    return;
            }

        }

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

        $("#showcount_down").html(content);

        setTimeout("lxfEndtime()", 1000);

    }


    var renDate = 10000;
    var count = 0;
    //    function getDate() {//时差控制
    //        count++;
    //        var date1 = new Date();
    //        $.ajax({
    //            async: false,
    //            url: "/pai/GetTime?" + date1.getTime(),
    //            success: function (data) {
    //                data.replace(/Date\([\d+]+\)/, function (a) {
    //                    eval('d = new ' + a)
    //                });
    //                d = (calcTime(d.getTime(), 8));
    //
    //                var n = d.getTime() - new Date().getTime();//服务器与本地时差
    //
    //                if (difference_time == -1000000) {
    //
    //                    difference_time = n - 300;
    //                    lxfEndtime();
    //                }
    //
    //                var date2 = new Date();
    //                var data3 = (date2.getTime() - date1.getTime()) / 1000;
    //                if (data3 < renDate) {
    //                    renDate = data3;
    //                }
    //                if (renDate > 1) {//时差大于1秒
    //                    if (count < 5) {//矫正次数少于5次，10秒后重新矫正，如矫正次数大于5次考虑网络因素放弃矫正
    //                        setTimeout("getDate()", 10000);
    //                    }
    //                }
    //
    //
    //            }
    //        });
    //    }
    function getServTime() {
        count++;
        var date1 = new Date();//请求服务器前时间
//        var d;
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
                var date2 = new Date();
                var data3 = (date2.getTime() - date1.getTime()) / 1000;
                if (data3 < renDate) {
                    renDate = data3;
                }
                if (renDate > 1) {
                    if (count < 5) {
                        setTimeout("getDate()", 10000);
                    }
                }

            },
            error: function () {
                alert("获取服务器时间失败");
                return;
            }
        })
    }

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
        if (browser.versions.mobile) {//判断是否是移动设备打开。browser代码在下面
            //location.href = "http://m.48.cn";
            location.href = window.location.href.replace('shop.48.cn', "m.48.cn");
        }

        if ("" != "1") {

            $(".dh_1").hover(function () {
                $(".columns").show();
            }, function () {
                $(".columns").hide();
            });
        }
        $("#topsearch").click(function () {

            location.href = "/search?searchKey=" + encodeURIComponent($("#topkey").val());
        })

        $("#topkey").keydown(function (e) {
            var key = e.which;
            if (key == 13 || (key == 10 && $.browser.msie && $.browser.version <= 6.0)) {
                $("#topsearch").click();
            }
        });

        $("#logout").click(function () {
            $.ajax({
                url: "https://user.48.cn/snh48.php?act=logout",
                dataType: 'jsonp',
                data: "",
                jsonp: 'callback',
                success: function (result) {
                    if (result.status == "00") {
                        $("head").append(result.desc);
                        layer.msg('退出成功', function () {

                            location.href = "/Home/Index";
                        });
                    } else {
                        location.href = "/Account/LogOff";
                    }
                }
            });
        })
    })
</script>

<div class="highslide-container"
     style="padding: 0px; border: none; margin: 0px; position: absolute; left: 0px; top: 0px; width: 100%; z-index: 1001; direction: ltr;">
    <a class="highslide-loading" title="Click to cancel" href="javascript:;"
       style="position: absolute; top: -9999px; opacity: 0.75; z-index: 1;">Loading...</a>
    <div style="display: none;"></div>
    <div class="highslide-viewport highslide-viewport-size"
         style="padding: 0px; border: none; margin: 0px; visibility: hidden;"></div>
    <table cellspacing="0"
           style="padding: 0px; border: none; margin: 0px; visibility: hidden; position: absolute; border-collapse: collapse; width: 0px;">
        <tbody style="padding: 0px; border: none; margin: 0px;">
        <tr style="padding: 0px; border: none; margin: 0px; height: auto;">
            <td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px;"></td>
            <td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px;"></td>
            <td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px;"></td>
        </tr>
        <tr style="padding: 0px; border: none; margin: 0px; height: auto;">
            <td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px;"></td>
            <td class="rounded-white highslide-outline"
                style="padding: 0px; border: none; margin: 0px; position: relative;"></td>
            <td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px;"></td>
        </tr>
        <tr style="padding: 0px; border: none; margin: 0px; height: auto;">
            <td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px;"></td>
            <td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px;"></td>
            <td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px;"></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
