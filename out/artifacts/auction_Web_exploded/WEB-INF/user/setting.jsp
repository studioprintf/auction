
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


                <a href="/user/user">
                    欢迎您：${sessionScope.get("USER_NAME")}
                </a>

                <a class="pl-10" href="https://www.c5game.com/user/sell.html">我要出售</a>
                <a href="https://www.c5game.com/user/purchase/purchase.html">我要求购</a>


                <a href="/user_logout">注销</a>
                <a href="https://www.c5game.com/user/login/ajax.html" id="ajax-login-dailog" class="ajax-login hide"
                   data-target="#remote-dailog-modal">登录</a>
            </div>
        </div>
    </div>
    <div id="page-nav">
        <ul class="nav-links">
            <li class="">
                <a href="https://www.c5game.com">首页</a>
            </li>
            <!--            <li style="position:relative;overflow: visible"-->
            <!--                class="--><!--">-->
            <!--                <a href="--><!--">--><!--</a>-->
            <!--                <i class="hot">--><!--</i>-->
            <!--            </li>-->


            <li class=""><a href="/user/inventory.html">我的背包</a>
            </li>
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

                        <div class="user-name pull-left ml-10"><span class="name name-ellipsis">${sessionScope.get("USER_NAME")}</span></div>
                    </div>
                    <div class="user-info-list">
                        账户余额 <span class="charge ft-orange ml-10"></span>
                        <span class="pull-right">
                                            <a href="/user/cash" class="ft-gray">提现</a>
                                        <a href="/user/payment" target="_blank" class="ft-green ml-10">充值</a>
                </span>

                    </div>

                </div>

                <ul class="account-left-nav" id="yw1">
                    <li class="nav1 active"><a href="/user/user">账户中心</a></li>
                    <li class="nav2"><a href="/user/sell.html">出售管理</a></li>
                    <li class="nav3"><a href="/user/purchase/purchase.html">求购管理</a></li>
                    <li class="nav5"><a href="#">账号设置</a></li>
                </ul>
            </div>
        </div>
        <div class="account-right">
            <ul class="floor-nav">
                <li role="presentation" class="active"><a>账户信息</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="account-content">
                <div class="alert alert-danger loading-message hide">loading...</div>
                <div class="head-portrait clearfix">

                    <div class="text-center ft-white">
                        <span>${user.user_name}</span>
                    </div>


                </div>
                <form id="avatar-form" action="/api/setting/updateavatar.html" method="post" enctype="multipart/form-data">
                    <input type="file" name="avatar" style="display: none;">
                </form>
                <table class="user-detail">
                    <tbody><tr>
                        <td class="tb-icon-id"></td>
                        <td class="tb-class">编号</td>
                        <td class="tb-info">${user.user_id}</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="tb-icon-contacts"></td>
                        <td class="tb-class">用户名</td>
                        <td class="tb-info">${user.user_name}</td>
                        <td class="tb-button">
                            <a data-toggle="modal" href="/user/setting" data-target="#remote-dailog-modal" class="btn-table remote-modal">修改密码</a>
                        </td>
                    </tr>
                    <%--<tr data-url="/api/setting/updatenickname.html">--%>
                        <%--<td class="tb-icon-man"></td>--%>
                        <%--<td class="tb-class">账号昵称</td>--%>
                        <%--<td class="tb-info"><span id="nickname" class="nickname-normal">Dymond</span> <input id="nickname-input" class="input input-sm nickname-edit hide " type="text" placeholder="请输入新的昵称"></td>--%>
                        <%--<td class="tb-button">--%>
                            <%--<a class="btn-table nickname-normal" href="javascript:void(0);" id="nickname-edit" data-message="修改昵称需要5000积分,是否确定修改?">修改昵称</a>--%>

                            <%--<a id="nickname-submit" href="javascript:void(0);" class="btn-table-submit nickname-edit hide">确定</a>--%>
                            <%--<a id="nickname-cancel" href="javascript:void(0);" class="btn-table nickname-edit hide">取消</a>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <!--            <tr>-->
                    <!--                <td class="tb-icon-mail"></td>-->
                    <!--                <td class="tb-class">--><!--</td>-->
                    <!--                <td class="tb-info">--><!--</td>-->
                    <!--                <td class="tb-button"><a class="btn-table">--><!--</a></td>-->
                    <!--            </tr>-->
                    <tr>
                        <td class="tb-icon-balance"></td>
                        <td class="tb-class">账户余额</td>
                        <td class="tb-info">￥${user.balance}</td>
                    </tr>






                    <tr>
                        <td class="tb-icon-last"></td>
                        <td class="tb-class">上次登录</td>
                        <td class="tb-info">${user.sign_time}</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="tb-icon-last"></td>
                        <td class="tb-class">上次登录IP地址</td>
                        <td class="tb-info">${user.sign_ip}</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="tb-icon-clock"></td>
                        <td class="tb-class">注册时间</td>
                        <td class="tb-info">${user.register_time}</td>
                        <td></td>
                    </tr>
                    </tbody></table>
            </div>
        </div>
</body>
</html>