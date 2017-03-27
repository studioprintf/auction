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
    <div class="zcdl_content pos_re">
        <div class="line"></div>
        <div class="reg-title title1"></div>
        <div class="center_title">
            <form action="/user_register" method="post" id="registForm" jveventinit="1">
                <div class="new_phone center_div">
                    <input class="user_id_password" type="text" name="user_name"
                           id="registname"
                           placeholder="用户名">

                </div>
                <p id="unameTip" class="yzm_x mar_t_69"></p>
                <div class="new_phone center_div">
                    <input class="user_id_password" type="password" id="registpassword" name="user_password"
                           placeholder="密码（6-16个字符组成，区分大小写）" jvmethod="checkPwd">
                </div>

                <p class="yzm_x mar_t_56" id="userpwdTip"></p>

                <div class="new_phone center_div">
                    <input class="user_id_password" type="text" name="user_email"
                           id="registemail"
                           placeholder="填写注册邮箱">

                </div>

                <p class="yzm_x mar_r_160" id="errTipPhone" style="margin-top: -67px;"></p>

                <p class="yzm_x" id="captchTip"></p>
                <br/>
                <br/>
                <input class="next_step center_div mar_t_120 " type="button" value="注册" id="regSubmit"/>

            </form>
        </div>
        <div class="phone_window" id="phone_window"></div>
    </div>
</div>


</body>
</html>