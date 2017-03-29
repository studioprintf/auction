<%--
  Created by IntelliJ IDEA.
  User: Dymond
  Date: 2017/3/28
  Time: 09:56
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

                <a class="pl-10" href="https://www.c5game.com/user/sell.html">我要出售</a>
                <a href="https://www.c5game.com/user/purchase/purchase.html">我要求购</a>


                <a href="/user_logout">注销</a>
            </div>
        </div>
    </div>
    <div id="page-nav">
        <ul class="nav-links">
            <li class="">
                <a href="https://www.c5game.com">首页</a>
            </li>


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

                        <div class="user-name pull-left ml-10"><span class="name name-ellipsis">Dymond</span></div>
                    </div>
                    <div class="user-info-list">
                        账户余额 <span class="charge ft-orange ml-10"></span>
                        <span class="pull-right">
                                            <a href="/user_cash" class="ft-gray">提现</a>
                                        <a href="/user_payment" target="_blank" class="ft-green ml-10">充值</a>
                </span>

                    </div>

                </div>

                <ul class="account-left-nav" id="yw1">
                    <li class="nav1 active"><a href="/user/user">账户中心</a></li>
                    <li class="nav2"><a href="/user/sell">出售管理</a></li>
                    <li class="nav3"><a href="/user/purchase/purchase.html">求购管理</a></li>
                    <li class="nav4"><a href="/user/inventory.html">我的背包</a></li>
                    <li class="nav10"><a href="/user/game/index.html">STEAM游戏</a></li>
                    <li class="nav5"><a href="/user/setting.html">账号设置</a></li>
                    <li class="nav6"><a href="/user/message.html">联系客服</a></li>
                    <li class="nav9"><a href="/user/message/notify.html">我的消息</a></li>
                    <li class="nav7"><a href="/user/coupons.html">我的卡券</a></li>
                    <li class="nav8"><a href="/user/code/index.html">激活码</a></li>
                </ul>
            </div>
        </div>
        <div class="account-right">
            <ul class="floor-nav">
                <li><a href="/user/user">账户中心</a></li>
                <li><a href="/user/payment">账户充值</a></li>
                <li class="active"><a>账户提现</a></li>
                <li><a href="/user/inventory/exchange.html">兑换中心</a></li>
                <li><a href="/user/order/buyerHistory.html">购买记录</a></li>
                <li><a href="/user/order/sellerHistory.html">出售记录</a></li>
                <li><a href="/user/payment/charge.html">充值卡充值</a></li>
            </ul>

            <!-- Tab panes -->
            <div class="account-content">

                <div class="account-amount clearfix mb-20">
                    <div class="amount amount1 ">
                        <p>账户余额:</p>
                        <p>
                            <span class="ft-orange">￥</span>
                            <span class="charge ft-orange ft-30">0</span>
                            <a href="/user/cash" class="btn btn-blue ml-20 mt-5 pull-right btn-cash-out">提现</a>
                            <a href="/user/payment" target="_blank" class="btn btn-orange  mt-5 pull-right">充值</a>
                        </p>
                    </div>

                    <div class="amount amount3">
                        <p>锁定金额</p>
                        <p>￥<span class="ft-30">0</span></p>
                    </div>
                </div>
                <div class="well form-inline" id="transfer-container">
                    <div class="">
                        <label>提现金额：</label>
                        <input type="text" class="input-sm transfer-form" name="money" value="" placeholder="请输入提现金额.">
                    </div>
                    <div class="transfer-choose">
                        <label class="transfer-choose-label ml-0" style="height: 30px">收款账户：</label>
                        <div class="pull-left mr-20">
                            <input class="gateway-choose account-form account-form-alipay transfer-form" id="label-bank"
                                   value="3" name="type" type="radio" checked="checked">
                            <label for="label-bank" style="position:relative;top:-2px;color:#BFC0C3;">银行卡（推荐）</label>
                        </div>
                        <div class="pull-left mr-20">
                            <input class="gateway-choose account-form account-form-alipay transfer-form"
                                   id="label-alipay" value="1" name="type" type="radio">
                            <label for="label-alipay" style="position:relative;top:-2px;color: #BFC0C3;">支付宝</label>
                        </div>
                        <div style="clear:both"></div>
                        <div class="payment-account" id="gateway-bank">
                            <div class="save-bank ">
                                <img style="position:absolute; top: -8px;left:100px" src="/images/user/arrow-up.png">
                                <div class="bank">
                                    <select class="account-form" name="bank" id="sel">
                                        <option value="0">请选择银行</option>
                                        <option value="ICBC">工商银行</option>
                                        <option value="ABC">农业银行</option>
                                        <option value="CCB">建设银行</option>
                                        <option value="CMB">招商银行</option>
                                        <option value="BOC">中国银行</option>
                                        <option value="COMM">交通银行</option>
                                        <option value="SPDB">浦发银行</option>
                                        <option value="GDB">广发银行</option>
                                        <option value="PSBC">邮储银行</option>
                                        <option value="CITIC">中信银行</option>
                                        <option value="CEB">光大银行</option>
                                        <option value="HXBANK">华夏银行</option>
                                        <option value="CMBC">民生银行</option>
                                        <option value="CIB">兴业银行</option>
                                        <option value="SPABANK">平安银行</option>
                                        <option value="BJBANK">北京银行</option>
                                        <option value="SHBANK">上海银行</option>
                                    </select>
                                    <span class="glyphicon glyphicon-chevron-down down-icon"
                                          style="cursor: pointer;z-index:1;" for="sel"></span>
                                    <input type="text" class="bank-card account-form" name="account"
                                           placeholder="请输入银行卡号">
                                    <input type="text" class="bank-card account-form " name="fullname"
                                           style="width: 100px;margin-left: 3px;" placeholder="收款人姓名">
                                    <a class="btn btn-blue ml-3 mb-3" id="confrom" data-toggle="modal"
                                       data-target="#conform">保存</a>
                                </div>
                                <p style="color:#3C74B4;position:relative;left:-10px;top:5px;">提现请保存真实姓名，否则将无法转账。</p>
                            </div>
                        </div>
                        <div class="payment-account hide" id="gateway-alipay">
                            <div class="unwrite save-alipay ">
                                <img style="position:absolute; top: -8px;left:290px" src="/images/user/arrow-up.png">
                                <input type="text" class="bank-card account-form-alipay" name="account"
                                       placeholder="请输入支付宝账号" style="margin-left:-10px;">
                                <input type="text" class="bank-card account-form-alipay" name="fullname"
                                       style="width: 100px;margin-left: 3px;" placeholder="收款人姓名">
                                <a class="btn btn-blue ml-3 mb-3" id="confrom" data-toggle="modal"
                                   data-target="#conform">保存</a>
                            </div>
                        </div>

                    </div>

                    <div class="transfer-choose hide transfer-choose-mode" id="transfer-choose-alipay">
                        <label class="transfer-choose-label ml-0">提现类型：</label>
                        <div class="mb-5">
                            <input class="radio inline transfer-form" type="radio" name="transfer_mode" id="quick"
                                   value="quick" checked="checked">
                            <label for="quick" class="transfer-label">
                                1%手续费50元封顶，100元起提，24小时内到账。 </label>
                            <div class="transfer-jian"></div>
                            ·
                        </div>
                        <!-- <div class="pull-left mb-5 ">
                            <input class="radio inline transfer-form" type="radio" name="transfer_mode" id="fast" value="fast">
                            <label for="fast" class="transfer-label" style="width:600px">快速提现，0.6%手续费，12小时内到账。手续费按整数元向上取整。</label>
                        </div>
                        <div class="pull-left mt-5">
                            <input class="radio inline transfer-form" type="radio" name="transfer_mode" id="normal" value="normal"  >
                            <label for="normal" class="transfer-label">
                                                                正常提现，免手续费，72小时内到账。限三天一次。                                                    </label>
                        </div> -->
                        <div style="clear:both"></div>
                    </div>
                    <div class="transfer-choose transfer-choose-mode" id="transfer-choose-bank">
                        <label class="transfer-choose-label ml-0" style="height:65px;">提现类型：</label>
                        <div class="mb-5">
                            <input class="radio inline transfer-form" type="radio" name="transfer_mode_bank"
                                   id="quick_bank" value="quick" checked="checked">
                            <label for="quick_bank" class="transfer-label">
                                极速提现<img src="/images/jian2.png" width="42px">，1%手续费，工作日9:30-21:00，2小时内到账。 </label>
                            <div class="transfer-jian"></div>
                        </div>
                        <div class="pull-left mb-5">
                            <input class="radio inline transfer-form" type="radio" name="transfer_mode_bank" id="fast"
                                   value="fast">
                            <label for="fast" class="transfer-label" style="width:600px">快速提现，0.6%手续费，12小时内到账。</label>
                        </div>
                        <div class="pull-left mt-5">
                            <input class="radio inline transfer-form" type="radio" name="transfer_mode_bank" id="normal"
                                   value="normal">
                            <label for="normal" class="transfer-label">
                                正常提现，免手续费，72小时内到账。 </label>
                        </div>
                        <div style="clear:both"></div>
                    </div>
                    <div class="text-left mt-10">
                        <button type="button" class="btn btn-orange btn-transfer-account mt-10"
                                style="margin-left: 70px;" data-loading-text="保存中...">提交审核
                        </button>
                    </div>
                </div>


            </div>

        </div>
    </div>
</div>
</body>
</html>