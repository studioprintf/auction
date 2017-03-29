<%@ taglib prefix="c" uri="/struts-tags" %>
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
    <link rel="stylesheet" type="text/css" href="/css/index.css">
    <script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var val = "${sessionScope.get("USER_NAME")}"
            var url = "user_getBalance";
            var args = {
                "user_name": val,
                "time": new Date()
            };
            $.post(url, args, function (data) {
                $(".charge").html(data);
            });
        })

    </script>
</head>
<body class="" style="">
<div id="header" class="clearfix" style="position: fixed; z-index: 999">
    <div id="site-nav">


        <div id="login-cpanl" class="user-info">
            <div class="user-top">


                <a href="https://www.c5game.com/user.html">
                    欢迎您：${sessionScope.get("USER_NAME")}
                </a>

                <a class="pl-10" href="/auction/sell">我要出售</a>

                <a href="/user/user_logout">注销</a>
            </div>
        </div>
    </div>
    <div id="page-nav">
        <ul class="nav-links">
            <li class="">
                <a href="http://localhost:8080/index">首页</a>
            </li>
            <!--            <li style="position:relative;overflow: visible"-->
            <!--                class="--><!--">-->
            <!--                <a href="--><!--">--><!--</a>-->
            <!--                <i class="hot">--><!--</i>-->
            <!--            </li>-->


            <li class=""><a href="/user/inventory.html">我的背包</a>
            </li>
            <li class="current">
                <a href="/user.html">个人中心</a></li>
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

                        <div class="user-name pull-left ml-10"><span id="username" class="name name-ellipsis">${sessionScope.get("USER_NAME")}</span></div>
                    </div>
                    <div class="user-info-list">
                        账户余额 <span class="charge ft-orange ml-10"></span>
                        <span class="pull-right">
                                            <a href="/user/default/cash" class="ft-gray">提现</a>
                                        <a href="/user/payment" target="_blank" class="ft-green ml-10">充值</a>
                </span>

                    </div>

                </div>

                <ul class="account-left-nav" id="yw1">
                    <li class="nav1 active"><a href="/user/user">账户中心</a></li>
                    <li class="nav2"><a href="/user/sell.html">出售管理</a></li>
                    <li class="nav3"><a href="/user/purchase/purchase.html">求购管理</a></li>
                    <li class="nav4"><a href="/user/inventory.html">我的背包</a></li>
                    <li class="nav10"><a href="/user/game/index.html">STEAM游戏</a></li>
                    <li class="nav5"><a href="/user/setting">账号设置</a></li>
                    <li class="nav6"><a href="/user/message.html">联系客服</a></li>
                    <li class="nav9"><a href="/user/message/notify.html">我的消息</a></li>
                    <li class="nav7"><a href="/user/coupons.html">我的卡券</a></li>
                    <li class="nav8"><a href="/user/code/index.html">激活码</a></li>
                </ul>
            </div>
        </div>
        <div class="account-right">
            <ul class="floor-nav">
                <ul class="floor-nav">
                    <li class="active"><a>账户中心</a></li>
                    <li><a href="/user/payment">账户充值</a></li>
                    <li><a href="/user/cash">账户提现</a></li>

                    <li><a href="/user/order/buyerHistory.html">购买记录</a></li>
                    <li><a href="/user/order/sellerHistory.html">出售记录</a></li>

                </ul>
            </ul>
            <!-- Tab panes -->

            <div class="account-content">

                <div class="account-amount clearfix mb-20 mt-10">
                    <div class="amount amount1 ">
                        <p>账户余额:</p>
                        <p>
                            <span class="ft-orange">￥</span>
                            <span class="charge ft-orange ft-30 "></span>

                            <a href="/user/payment" target="_blank" class="btn btn-orange  mt-5 pull-right">充值</a>
                            <a href="/user/default/cash"
                               class="btn btn-blue ml-20 mt-5 mr-10 pull-right btn-cash-out">提现</a>
                        </p>

                    </div>

                    <div class="amount amount3">
                        <p>锁定金额</p>
                        <p>
                            ￥
                            <span class="ft-30">0</span>
                        </p>
                    </div>
                </div>


                <div class="account-record">
                    <ul class="floor-nav" role="tablist" style="overflow:visible">
                        <a href="/user.html?type=1">
                            <li role="presentation" class="active">账户流水</li>
                        </a>
                        <a href="/user.html?type=2">
                            <li role="presentation" class="">积分流水</li>
                        </a>
                        <li class="pull-right">
                            <div class="dropdown">
                                <button type="button" class="btn dropdown-toggle" id="dropdownMenu1"
                                        data-toggle="dropdown" style="background: transparent">查看全部 <span
                                        class="caret bottom-2"></span>
                                </button>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                    <li role="presentation">
                                        <a role="menuitem" tabindex="-1" href="/user.html?type=1&amp;filter=0">查看全部</a>
                                    </li>
                                    <li role="presentation">
                                        <a role="menuitem" tabindex="-1" href="/user.html?type=1&amp;filter=1">只看收入</a>
                                    </li>
                                    <li role="presentation">
                                        <a role="menuitem" tabindex="-1" href="/user.html?type=1&amp;filter=2">只看支出</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                    <table class="table sale-item-table sale-user-table">
                        <!-- 账户流水 -->
                        <tbody>
                        <tr>
                            <th>流水号</th>
                            <th>行为</th>
                            <th>资金变动</th>
                            <th>余额（￥）</th>
                            <th>时间</th>
                            <!--                    <th>--><!--</th>-->
                        </tr>
                        <tr>
                            <td colspan="6" class="text-center">暂无数据</td>
                        </tr>
                        </tbody>
                    </table>

                    <div class="sale-pagination ">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
