<%--
  Created by IntelliJ IDEA.
  User: Dymond
  Date: 2017/4/21
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <li class="nav2"><a href="/user/order/selllist">我发布的拍卖</a></li>
                    <li class="nav3"><a href="/user/order/buylist">我得标的拍卖</a></li>
                    <li class="nav5"><a href="/user/setting">账号设置</a></li>
                </ul>
            </div>
        </div>
        <div class="account-right">
            <ul class="floor-nav">
                <li><a href="/user/user">账户中心</a></li>
                <li><a href="/user/payment">账户充值</a></li>
                <li><a href="/user/cash">账户提现</a></li>

                <li class="active"> <a href="/user/order/payHistory">购买记录</a></li>
                <li><a href="/user/order/sellHistory">出售记录</a></li>

            </ul>

            <div class="tab-content account-content">

                <div class="sale-record">

                    <table class="table sale-item-table sale-record-group wide">
                        <colgroup>
                            <col style="width:30%;">
                            <col style="width:20%;">
                            <col style="width:8%;">
                            <col style="width:20%;">
                            <col style="width:10%;">
                            <col style="width:12%">
                        </colgroup>
                        <tbody><tr class="sale-item-title">
                            <th>商品名称</th>
                            <th>销售编号</th>
                            <th>类型</th>
                            <th>卖家</th>
                            <th>账户记录</th>
                            <th>购买时间</th>
                        </tr>
                        <tr>
                            <td colspan="6" class="text-center">
                                没有任何记录        </td>
                        </tr>

                        </tbody></table>
                    <div class="sale-pagination">
                    </div>
                </div>



            </div>
        </div>

    </div>
</div>
</body>
</html>
