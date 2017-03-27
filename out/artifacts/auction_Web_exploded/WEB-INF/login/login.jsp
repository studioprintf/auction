<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="referrer" content="always">
    <title>

        在线拍卖系统</title>


    <link rel="stylesheet" href="/css/base.css">

    <link id="css" rel="stylesheet" type="text/css" href="/css/zclc2.1460959081.css">

    <style></style>
    <link charset="utf-8" rel="stylesheet" href="/css/jquery-ui.css">
    <link charset="utf-8" rel="stylesheet" href="/css/white.css">
    <script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
    <script type="text/javascript" src="/js/login_reg.js"></script>
</head>
<body>
<div class="z_top_container">
    <div class="z_top b-header-blur-black">
        <div class="z_header">
            <div class="z_top_nav">
                <ul>
                    <li class="home">
                        <a class="i-link" href="http://localhost:8080/"><span>主站</span></a>
                    </li>


                </ul>

            </div>
            <div class="uns_box">
                <ul class="menu">

                    <li id="i_menu_login_reg" guest="yes" class="u-i" style="display: list-item;">
                        <a id="i_menu_login_btn" class="i-link login"
                           href="http://localhost:8080/login"><span>登录</span></a><i class="s-line"></i><a
                            id="i_menu_register_btn" class="i-link register"
                            href="http://localhost:8080/register"><span>注册</span></a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>
<div class="top_bg">
    <div class="top"></div>
</div>
<div class="head_foot_content">
    <div class="header">
        <div class="header-layer"></div>
        <a class="header-link" target="_blank" href="http://www.bilibili.com" data-loc-id="142"></a>
        <div class="lin">
            <div class="tit">
                <img src="https://static-s.bilibili.com/passport/img/t2.png" alt="登录">
            </div>
        </div>
        <div class="content-bd" status="available">

            <div class="line"></div>
            <div class="content-r">
                <form action="/user_login" method="post" id="loginForm" jveventinit="1">

                    <div class="box">
                        <span id="userIdSpt" jvnormaltip="&amp;nbsp;">&nbsp;</span>
                        <input style="margin-bottom: 0" id="userIdTxt" type="text" placeholder="用户名" name="user_name"
                               class="email ui-autocomplete-input" jvdefault="用户名" jvcorrecttip=""
                               jvtipid="userIdSpt" maxlength="50" jvpattern="^.{1,50}$" jverrortip="请输入注册时用的邮箱或者手机号呀"
                               autocomplete="off">
                    </div>
                    <div class="box">
                        <span id="userPwdTip" jvnormaltip="&amp;nbsp;">&nbsp;</span>
                        <input id="passwdTxt" type="password" placeholder="密码" name="user_password" class="password"
                               jverrortip="喵，你没输入密码么？" jvpattern="^.{3,30}$" jvtipid="userPwdTip">
                    </div>
                    <div class="box">
                        <a href="/resetpwd" class="mima">忘记密码？&gt; </a>
                        <span style="line-height: 30px;" class="begin" id="vdcodeSpt">&nbsp;</span>
                        <input id="checkImage" type="text" style="text-transform: uppercase;" placeholder="验证码"
                               class="code jv-box-default" jvdefault="验证码" name="checkImage" jvcorrecttip=""
                               jvtipid="vdcodeSpt" maxlength="10" jvpattern="^.{1,10}$" jverrortip="请输入验证码"
                               autocomplete="off">
                        <div class="sj_yzm" style="display: none"></div>
                        <i></i> <img id="captchaImg" name="checkImage" src="<s:url action="user_createImage" />"
                                     class="yzm" alt="显示验证码" >
                        <p id="refreshCaptchaAch" onclick="return changeImg();">换一张</p>
                        <div class="box">

                        </div>
                        <input type="button" class="login" value="登录" id="loginSubmit"/>
                        <a class="zhuce" href="/register">注册</a>
                </form>


            </div>
        </div>
    </div>
</div>



</body>
</html>