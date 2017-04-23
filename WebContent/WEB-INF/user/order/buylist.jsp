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
    <link rel="stylesheet" type="text/css" href="/css/userindex.css">
    <script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var val = "${sessionScope.get("USER_NAME")}";

            $.ajax({
                url:"/user/user_getBalance",
                async:true,
                type:"post",
                dataType:"json",
                data:{
                    userName: val,
                    r : Math.random()
                },
                success:function (data) {
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

                <a class="pl-10" href="${pageContext.request.contextPath}/auction/publish">我要出售</a>

                <a href="${pageContext.request.contextPath}/user/user_logout">注销</a>
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
                <a href="${pageContext.request.contextPath}/user/user">个人中心</a></li>
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
                                            <a href="/user/cash" class="ft-gray">提现</a>
                                        <a href="/user/payment" class="ft-green ml-10">充值</a>
                </span>

                    </div>

                </div>

                <ul class="account-left-nav" id="yw1">
                    <li class="nav1"><a href="/user/user">账户中心</a></li>
                    <li class="nav2"><a href="/user/order/selllist">我发布的拍卖</a></li>
                    <li class="nav3 active"><a href="/user/order/buylist">我得标的拍卖</a></li>
                    <li class="nav5"><a href="/user/setting">账号设置</a></li>
                </ul>
            </div>
        </div>
        <div class="account-right">
            <ul class="floor-nav">
                <li class="active"><a>账户中心</a></li>






            </ul>
            <!-- Tab panes -->

            <div class="account-content">




                <div class="account-record">

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
