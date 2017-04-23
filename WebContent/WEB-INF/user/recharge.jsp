<%--
  Created by IntelliJ IDEA.
  User: Dymond
  Date: 2017/3/28
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/min.css">


    <title>个人中心</title>
    <link rel="Shortcut Icon" href="/images/logo.png" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.skin.css">
    <link rel="stylesheet" type="text/css" href="/css/head-foot.css">
    <link rel="stylesheet" type="text/css" href="/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="/css/jedate.css">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/userindex.css">
    <script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>

    <script type="text/javascript">
        $(function () {
            var val = "${sessionScope.get("USER_NAME")}";

            $.ajax({
                url: "/user/user_getBalance",
                async: true,
                type: "post",
                dataType: "json",
                data: {
                    userName: val,
                    r: Math.random()
                },
                success: function (data) {
                    $(".charge").html(data.balance);
                    $(".frozen").html(data.frozen_amount);
                }
            })
        })
    </script>
</head>
<body class="" style="">
<div id="header" class="clearfix" style="position: fixed; z-index: 999">
    <div id="site-nav">


        <div id="login-cpanl" class="user-info">
            <div class="user-top">


                <a href="/user/user">
                    欢迎您：${sessionScope.get("USER_NAME")}
                </a>



                <a href="/user_logout">注销</a>
                <a href="https://www.c5game.com/user/login/ajax.html" id="ajax-login-dailog" class="ajax-login hide"
                   data-target="#remote-dailog-modal">登录</a>
            </div>
        </div>
    </div>
    <div id="page-nav">
        <ul class="nav-links">
            <li class="">
                <a href="${pageContext.request.contextPath}/index">首页</a>
            </li>
            <!--            <li style="position:relative;overflow: visible"-->
            <!--                class="--><!--">-->
            <!--                <a href="--><!--">--><!--</a>-->
            <!--                <i class="hot">--><!--</i>-->
            <!--            </li>-->


            <li class="current">
                <a href="/user/user">个人中心</a></li>
        </ul>
    </div>
</div>

<div class="container">


    <div class="top-notice" data-tpl="top-notice-tpl" data-url="/api/notice.html"></div>
    <div id="content">
        <div id="sticky-wrapper" class="sticky-wrapper" style="height: 841px;">
            <div class="account-left" style="bottom: 0px; width: 290px;">
                <div class="user-bg">
                    <div class="user-pic-name">

                        <div class="user-name pull-left ml-10"><span id="username"
                                                                     class="name name-ellipsis">${sessionScope.get("USER_NAME")}</span>
                        </div>
                    </div>
                    <div class="user-info-list">
                        账户余额 <span class="charge ft-orange ml-10"></span>
                        <span class="pull-right">
                                            <a href="/user/cash" class="ft-gray">提现</a>
                                        <a href="/user/payment" class="ft-green ml-10">充值</a>
                </span>

                    </div>

                </div>

                <ul class="account-left-nav" id="yw1">
                    <li class="nav1 active"><a href="/user/user">账户中心</a></li>
                    <li class="nav2"><a href="/user/selllist">我发布的拍卖</a></li>
                    <li class="nav3"><a href="/user/order/buylist">我得标的拍卖</a></li>
                    <li class="nav5"><a href="/user/order/setting">账号设置</a></li>
                </ul>
            </div>
        </div>
        <div class="account-right">
            <ul class="floor-nav">
                <li ><a href="/user/user">账户中心</a></li>
                <li class="active"><a href="/user/payment">账户充值</a></li>
                <li><a href="/user/cash">账户提现</a></li>

                <li><a href="/user/order/payHistory">购买记录</a></li>
                <li><a href="/user/order/sellHistory">出售记录</a></li>

            </ul>

            <!-- Tab panes -->
            <div class="tab-content account-content">
                <div role="tabpanel" class="tab-pane active">

                        <div class="form-group">
                            <label class="col-sm-3 control-label">账户余额 (￥)：</label>
                            <div class="col-sm-9">
                                <div class="form-text">
                                    <span class="ft-orange ft-14 charge"></span>
                                </div>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">充值金额：</label>
                            <div class="col-sm-9">
                                <input type="text" name="amount" class="input-sm" id="input-money" value="100"><span
                                    class="ml-10 pay-tips">建议单次充值不超过3000</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label ">充值方式：</label>
                            <div class="col-sm-9">
                                <div class="pull-left mt-5 mr-20">
                                    <input value="alipay" id="gateway-alipay" checked="checked" type="radio"
                                           name="gateway">
                                    <label for="gateway-alipay" style="position:relative;top:-2px;"><img
                                            class="mr-2 bottom-2" src="/images/alipayicon.png" alt=""> 支付宝 </label>
                                </div>
                                <div class="pull-left mt-5 mr-20">
                                    <input value="weixin" id="gateway-weixin" type="radio" name="gateway">
                                    <label for="gateway-weixin" style="position:relative;top:-2px;"><img
                                            class="mr-2 bottom-2" src="/images/wecharticon.png" alt=""> 微信支付 </label>
                                </div>
                                <!-- <div class="pull-left mt-5 mr-20">
                                    <input value="webmoney" id="gateway-webmoney" type="radio" name="gateway">
                                    <label for="gateway-webmoney"
                                           style="position:relative;top:-2px;"><img class="mr-2 bottom-2"
                                                                                    src="#"
                                                                                    alt="">WebMoney                            </label>
                                </div> -->
                                <div class="pull-left mt-5 mr-20">
                                    <input value="bank" id="gateway-bank" type="radio" name="gateway">
                                    <label for="gateway-bank" style="position:relative;top:-2px;">
                                        <img class="mr-2 bottom-2" src="/images/unionicon.png" alt="">银联快捷（限¥1000以上，不支持信用卡）</label>
                                </div>
                            </div>
                        </div>

                        <div class="payment-account hide" id="bank-card">
                            <img style="position:absolute; top: -8px;left:410px" src="/images/user/arrow-up.png">
                            <a href="#" id="add-bank-card">+添加新的银行卡</a>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-3"></div>
                            <div class="col-sm-9">
                                <div class="text-info hide payment-tips" style="height:50px;">
                                    <span class="payment-tips-content">-</span>
                                    <br><span class="text-success mt-5"
                                              style="position: relative;top: 5px;">Recharge $<span
                                        id="usd-money">-</span> to get ¥<span id="cny-money">-</span></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"></label>
                            <div class="col-sm-9">
                                <button type="button" class="btn btn-yellow" id="btn-payment" data-loading-text="正在提交">
                                    确认充值
                                </button>

                            </div>
                        </div>



                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function () {
        $("#input-money").keyup(function () {
            $(this).val($(this).val().replace(/[^0-9_]/g, []));
        })
        $("input-money").blur(function () {
            $(this).val($(this).val().replace(/[^0-9_]/g, []));
        })
    })

    $("#btn-payment").click(function () {
        url = "/user/user_recharge";
        val = $("#input-money").val();
        $.post(
            url,
            {
                'amount': val,
                'r': Math.random()
            },
            function (data) {
                if (data == "1") {
                    window.location.href="${pageContext.request.contextPath}/user/recharge_succ";
                }
                else {
                    alert(data);
                }
            }
        )

    })
</script>