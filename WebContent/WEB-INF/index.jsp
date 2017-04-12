<%@ taglib prefix="c" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Dymond
  Date: 2017/3/29
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="ks-webkit537 ks-webkit ks-opera43 ks-opera ks-webkit537 ks-webkit ks-opera43 ks-opera ks-webkit602 ks-webkit ks-safari10 ks-safari">
<head>
    <title> 欢迎使用在线拍卖系统 </title>
    <script>window.g_config = {appId: 1009, toolbar: false, startTime: new Date().valueOf()};</script>
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
    <!-- assets start-->

    <!-- S GLOBAL CSS -->
    <link rel="stylesheet" href="/css/global-min.css">
    <!-- S GLOBAL CSS -->


    <style>
        .tb-footer {
            width: 100% !important;
            max-width: 100% !important;
            min-height: 125px;
            margin-top: 20px;
            padding-bottom: 9px;
            background-color: #fff;
            font-size: 12px;
        }

        .tb-footer p {
            padding-bottom: 8px;
            overflow: hidden;
            *zoom: 1;
        }

        .tb-footer b {
            margin: 0 3px;
            font-weight: 400;
            color: #ddd;
        }

        .tb-footer em,
        .tb-footer span {
            color: #9c9c9c;
        }

        .tb-footer em {
            margin-left: 30px;
            font-style: normal;
        }

        .tb-footer span {
            margin: 0 4px;
        }

        .tb-footer .tb-footer-hd,
        .tb-footer .tb-footer-bd,
        .tb-footer .tb-footer-ft {
            width: 1190px;
            max-width: 100%;
            margin-left: auto;
            margin-right: auto;
        }

        .tb-footer .tb-footer-hd a,
        .tb-footer .tb-footer-bd a {
            white-space: nowrap;
            color: #6c6c6c;
            text-decoration: none;
        }

        .tb-footer .tb-footer-hd a:hover,
        .tb-footer .tb-footer-bd a:hover {
            color: #f40;
            text-decoration: none;
        }

        .tb-footer .tb-footer-hd {
            padding-top: 7px;
            border-top: 1px solid #ddd;
        }

        .tb-footer .tb-footer-hd p {
            margin-bottom: 8px;
            line-height: 27px;
            border-bottom: 1px solid #ddd;
        }

        .tb-footer .tb-footer-ft a {
            margin-right: 15px;
        }

        .tb-footer .tb-footer-mod {
            height: 40px;
            display: inline-block;
            background-repeat: no-repeat;
            vertical-align: middle;
        }

        .tb-footer-with-logo {
            min-height: 170px;
        }
    </style>
    <style>.ww-light {
        overflow: hidden;
    }

    .ww-block {
        display: block;
        margin-top: 3px;
    }

    .ww-inline {
        display: inline-block;
        vertical-align: text-bottom;
    }

    .ww-light a {
        background-image: url("img/T15AD7FFFaXXbJnvQ_-130-60.gif");
        background-image: -webkit-image-set(url("img/T15AD7FFFaXXbJnvQ_-130-60.gif") 1x, url("img/T1Rsz7FPJaXXbZhKn7-520-240.gif") 4x);
        background-image: -moz-image-set(url("img/T15AD7FFFaXXbJnvQ_-130-60.gif") 1x, url("img/T1Rsz7FPJaXXbZhKn7-520-240.gif") 4x);
        background-image: -o-image-set(url("img/T15AD7FFFaXXbJnvQ_-130-60.gif") 1x, url("img/T1Rsz7FPJaXXbZhKn7-520-240.gif") 4x);
        background-image: -ms-image-set(url("img/T15AD7FFFaXXbJnvQ_-130-60.gif") 1x, url("img/T1Rsz7FPJaXXbZhKn7-520-240.gif") 4x);
        text-decoration: none !important;
        width: 20px;
        height: 20px;
        zoom: 1;
    }

    .ww-large a {
        width: 67px;
    }

    a.ww-offline {
        background-position: 0 -20px;
    }

    a.ww-mobile {
        background-position: 0 -40px;
    }

    .ww-small .ww-online {
        background-position: -80px 0;
    }

    .ww-small .ww-offline {
        background-position: -80px -20px;
    }

    .ww-small .ww-mobile {
        background-position: -80px -40px;
    }

    .ww-static .ww-online {
        background-position: -110px 0;
    }

    .ww-static .ww-offline {
        background-position: -110px -20px;
    }

    .ww-static .ww-mobile {
        background-position: -110px -40px;
    }

    .ww-light a span {
        display: none;
    }</style>
    <script src="/js/index.js(2).下载"></script>
    <script src="/js/index.js?v=0324"></script>
    <script src="//g.alicdn.com/secdev/adblk/index.js?v=0324"></script>
    <script src="//g.alicdn.com/secdev/sufei_data/2.2.0/index.js"></script>
    <script src="/js/index.js"></script>
    <script src="//g.alicdn.com/secdev/adblk/index.js?v=0324"></script>
    <script src="//g.alicdn.com/secdev/sufei_data/2.2.0/index.js"></script>
    <script src="/js/index.js(3).下载"></script>
    <script type="text/javascript" async="" id="tb-beacon-aplus" exparams="category=&amp;userid=&amp;aplus"
            src="/js/aplus_v2.js(1).下载"></script>
    <script async="" src="js/eg.js"></script>
    <style>.ww-light {
        overflow: hidden;
    }

    .ww-block {
        display: block;
        margin-top: 3px;
    }

    .ww-inline {
        display: inline-block;
        vertical-align: text-bottom;
    }

    .ww-light a {
        text-decoration: none !important;
        width: 20px;
        height: 20px;
        zoom: 1;
    }

    .ww-large a {
        width: 67px;
    }

    a.ww-offline {
        background-position: 0 -20px;
    }

    a.ww-mobile {
        background-position: 0 -40px;
    }

    .ww-small .ww-online {
        background-position: -80px 0;
    }

    .ww-small .ww-offline {
        background-position: -80px -20px;
    }

    .ww-small .ww-mobile {
        background-position: -80px -40px;
    }

    .ww-static .ww-online {
        background-position: -110px 0;
    }

    .ww-static .ww-offline {
        background-position: -110px -20px;
    }

    .ww-static .ww-mobile {
        background-position: -110px -40px;
    }

    .ww-light a span {
        display: none;
    }</style>
    <script type="text/javascript" async="" id="tb-beacon-aplus" exparams="category=&amp;userid=&amp;aplus"
            src="http://ajs/aplus_v2.js"></script>
    <script async="" src="https://log.mmstat.com/eg.js"></script>
</head>
<body id="home" data-spm="3065125">
<script type="text/javascript">
    var _SPM_a = '';
    var _SPM_b = '';
    var _SPM_app_name = 'auctionplatform';
    var _SPM_template_path = 'E0vYlf3FfE%2fFSTA%2bBzZd3b6QFP7VwP%2f4AgVJk6PAnek%3d';
</script>
<script type="text/javascript">
    (function (d) {
        var t = d.createElement("script");
        t.type = "text/javascript";
        t.async = true;
        t.id = "tb-beacon-aplus";
        t.setAttribute("exparams", "category=&userid=&aplus");
        t.src = ("https:" == d.location.protocol ? "https://s" : "http://a") + "js/aplus_v2.js";
        d.getElementsByTagName("head")[0].appendChild(t);
    })(document);
</script>

<!-- global 3.1 start-->
<!-- S GLOBAL HTML -->
<div id="J_SiteNav" class="site-nav">
    <div id="J_SiteNavBd" class="site-nav-bd">
        <ul id="J_SiteNavBdL" class="site-nav-bd-l">
            <li id="J_LoginInfo" class="menu" data-spm="1997563269">
                <div id="J_LoginInfoHd" class="menu-hd">

                    <c:if test="#session.USER_NAME==null" >
                    <a
                        href="/login"
                        target="_top" class="h">亲，请登录</a> <a
                        href="/register"
                        target="_top">免费注册</a></div>
                </c:if>
                <s:else>
                    <a
                            href="/user/user"
                            target="_top" class="h">欢迎你，${sessionScope.get('USER_NAME')}</a>
                </s:else>
            </li>
            <li id="J_Weekend" class="menu weekend" data-spm="1996803849"></li>
        </ul>
        <ul id="J_SiteNavBdR" class="site-nav-bd-r">
            <li class="J_Menu menu my-taobao" data-spm="1997525045">
                <div class="menu-hd J_MenuMyTaobao"><a href="/user/user" target="_top">个人中心</a><span
                        class="arrow-icon-wrapper"><span class="g-icon arrow-icon"></span></span></div>
                <div class="menu-bd menu-list">
                    <div class="menu-bd-panel"><a href="//buyertrade.taobao.com/trade/itemlist/list_bought_items.htm"
                                                  target="_top">已买到的宝贝</a><a href="//lu.taobao.com/newMyPath.htm"
                                                                             target="_top">我的足迹</a><a
                            href="//guang.taobao.com/?scm=2022.1.1.1" target="_top">爱逛街 <em
                            class="J_GuangCount guang-count"></em></a><a href="//daren.taobao.com/"
                                                                         target="_top">淘宝达人</a><a
                            href="//love.taobao.com/" target="_top">新欢</a></div>
                </div>
            </li>
            <li class="J_Menu menu seller-center" data-spm="1997525073">
                <div class="menu-hd"><a href="//mai.taobao.com/seller_admin.htm" target="_top">卖家中心</a><span
                        class="arrow-icon-wrapper"><span class="g-icon arrow-icon"></span></span></div>
                <div class="menu-bd menu-list">
                    <div class="menu-bd-panel"><a href="//mai.taobao.com/seller_admin.htm" target="_top">免费开店</a><a
                            href="//trade.taobao.com/trade/itemlist/list_sold_items.htm" target="_top">已卖出的宝贝</a><a
                            href="//sell.taobao.com/auction/goods/goods_on_sale.htm" target="_top">出售中的宝贝</a><a
                            href="//fuwu.taobao.com/?tracelog=tbdd" target="_top">卖家服务市场</a><a href="//daxue.taobao.com"
                                                                                               target="_top">卖家培训中心</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>


<script> window.g_config = {appId: 1009, toolbar: false, startTime: new Date().valueOf()};
window._poc = [['_setRate', 1000]];
TB.Global.blacklist = ["fn-cart"];
TB.Global.init(); </script>
<style> .skin-default .module {
    width: auto;
}

#server-num {
    color: #fff;
} </style>
<script>/* KISSY.use('dom',function(S,D){ var w = D.viewportWidth(); if (w > 1190) { D.addClass(document.body, 'w1190'); } else{D.addClass(document.body, 'w990');} })*/ </script>
<style> /*index start*/
.pai-specail-list-wrap .list-main .list-main-content .list-box .filter-state-soon p .time-icon, .pai-specail-list-wrap .list-main .list-main-content .list-box .list-header .header-after .time-icon, .pai-specail-list-wrap .list-side .item-list .item .item-meta .look-num, .pai-specail-list-wrap .list-side .state-look .item .item-meta .price span {
    color: #008060 !important;
}

.pai-specail-list-wrap .list-main .list-main-content .list-box .filter-state-soon .time-box, .pai-specail-list-wrap .list-main .list-main-content .list-box .list .item .item-content .item-look-box {
    background-color: #008060 !important;
}

.pai-jianlou-yu .hd h2 {
    font-weight: normal;
}

.pai-specail-list-wrap .list-main .list-main-content .list-box .list-header p .time-icon, .pai-specail-list-wrap .list-main .list-main-content .list-box .list-header .header-after .time-icon {
    font-size: 22px !important;
}

.pai-bottom, .mkt-auction-home-top .slide {
    min-width: 1190px !important;
}

/*index end*/ /*album&list start*/
.pmp-detail-banner .banner-status-soon .info-top, .pmp-detail-banner .banner-status-audit .info-top, .pmp-item-list .item .soon-info, .pmp-recommend-list .list .item .item-content .item-look-box {
    background-color: #008060 !important;
}

.pmp-item-list .item .soon-time, .pmp-item-list .item .audit-time {
    color: #008060 !important;
}

/*album&list end*/ /*detail start*/
.pm-main .pm-status-will .pm-status-mark-will {
    background: url(//gtms02.alicdn.com/tps/i2/TB1rn83GXXXXXchXXXXsZBFIVXX-76-27.png) no-repeat -4px 0 !important;
}

.pm-main .pm-status-will .pm-time .time-num {
    color: #008060 !important;
}

body[data-spm='3065513'] .site-nav .site-nav-bd {
    width: 1190px;
}

/*detail end*/
body[data-spm='7340941'] .org-single {
    margin-top: 20px;
}

body .pm-body .pm-addition .tab-menu {
    height: 61px;
}

.mkt-auction-top-2014 a.btn-down-arrow {
    left: 172px !important;
}</style>
<div id="paiheader" class="paiheader">
    <div class="mkt-auction-top-2014" data-time="&lt;?= time(); ?&gt;">
        <div id="nav">
            <div class="nav-wrap">

                <p class="logo-area">

                </p>


                <ul class="main-nav J_MainNav">

                    <li data-pattern="https://paimai.taobao.com|http://paimai.taobao.com/pmp/home.htm">
                        <a href="https://paimai.taobao.com/">
                            首页
                        </a>

                    </li>


                </ul>
                <s class="spe"></s>
                <ul class="other-nav">

                    <li class="nav&gt;-item J_OtherNavItem">
                        <a href="https://paimai.taobao.com/auctionList/my_auction_list.htm" target="_blank">
                            我的拍卖
                        </a>
                    </li>


                </ul>
                <div class="p-search" id="J_Search" role="search">

                    <form class="paimai-search-form"  method="get" target="_blank"
                          action="https://paimai.taobao.com/pmp_list/3____1_1.htm" _lpchecked="1">
                        <input id="searchKey" name="searchKey" type="text" name="q" placeholder="用拍品名称搜索" accesskey="q"
                               maxlength="512">
                        <button class="J_SearchIpt search-btn iconfont-pai-logo icon-sousuo" type="submit"></button>
                    </form>

                    <style>
                        .mkt-auction-top-2014 .paimai-search-form .iconfont-pai-logo {
                            background: #e6e6e6 url(img/T1_JfZFuXeXXadE...-14-15.png) 5px 7px no-repeat;
                        }
                    </style>


                </div>
            </div>
        </div>
    </div>
</div>
<script>
    (function (S) {
        S.ready(function () {
            document.getElementById('J_input_charset').value = document.characterSet || document.charset;
            S.use('paiheader', function (S, Mod) {
                new Mod('#paiheader');
            });
        })
    })(KISSY);
</script>

<!-- pmp-nav 3.1 end-->        <!--编辑地址:/pmp/top-slide-->


<!--编辑地址：/pmp/index-middle-->
<div id="index-middle" class="index-middle">
    <link rel="stylesheet" href="/css/mainindex.css">
    <div class="tb-module pai-album-list1501 clearfix">
        <div class="album-list">


            <div id="J_TodayAlbum" data-spm-ab="todayAlbum">
                <div class="header">
                    <span class="title iconfont-pai"><em>今</em>日专场</span>
                    <s class="line"></s>
                </div>

                <div class="content J_AlbumContent">
                    <ul class="pai-album">


                        <li id="pai-album-item-127354899" class="item state-now">
                            <a class="item-wrap" target="_blank"
                               href="https://paimai.taobao.com/pmp_album/127354899.htm?spm=a2129.3065125.0.0.SM98SK"
                               data-spm-anchor-id="a2129.3065125.0.0">
                                <div class="img-wrap">
                                    <img alt="魅惑时尚大牌箱包专场"
                                         src="img/TB2uUAJjt0opuFjSZFxXXaDNVXa_!!0-paimai.jpg_600x600Q90.jpg">
                                </div>
                                <div class="item-content">
                                    <img class="item-status-over" src="img/T1x5z2FKJXXXXKN.Q6-114-60.png">
                                    <p class="item-title">魅惑时尚大牌箱包专场</p>
                                    <p class="item-store">
                                        <em>送拍机构</em>
                                        <span>天亚嘉德国际贸易</span>
                                    </p>
                                    <p class="item-show-time">
                                        <em>开拍时间</em>
                                        <span>2017年03月27日 23:00</span>
                                    </p>

                                    <div class="item-countdown">
                                        <span class="countdown-text">距结束</span>
                                        <p class="J_PAlbum pai-countdown" data-itemid="127354899"
                                           data-now="1490683206438" data-timetoend="4646846"
                                           data-timetostart="-55830598" data-end="1490688000000"
                                           data-start="1490626800000">
                                            <span class="J_TimeLeft">01<i>时</i>17<i>分</i>26<i>秒</i></span>
                                        </p>
                                    </div>


                                    <div class="item-side-box item-bid-box">
                                        <span class="side-num">441</span>
                                        <span class="side-text">次出价</span>
                                    </div>

                                    <div class="item-side-box item-look-box">
                                        <span class="side-num">5.78万</span>
                                        <span class="side-text">次围观</span>
                                    </div>
                                </div>

                            </a>
                        </li>

                        <li id="pai-album-item-137042368" class="item state-now">
                            <a class="item-wrap" target="_blank"
                               href="https://paimai.taobao.com/pmp_album/137042368.htm">
                                <div class="img-wrap">
                                    <img alt="三佳玉业翡翠臻品收藏专场"
                                         src="img/TB2783lcdhvOuFjSZFBXXcZgFXa_!!0-paimai.jpg_600x600Q90.jpg">
                                </div>
                                <div class="item-content">
                                    <img class="item-status-over" src="img/T1x5z2FKJXXXXKN.Q6-114-60.png">
                                    <p class="item-title">三佳玉业翡翠臻品收藏专场</p>
                                    <p class="item-store">
                                        <em>送拍机构</em>
                                        <span>三佳玉业</span>
                                    </p>
                                    <p class="item-show-time">
                                        <em>开拍时间</em>
                                        <span>2017年03月28日 10:00</span>
                                    </p>

                                    <div class="item-countdown">
                                        <span class="countdown-text">距结束</span>
                                        <p class="J_PAlbum pai-countdown" data-itemid="137042368"
                                           data-now="1490683206438" data-timetoend="11846846"
                                           data-timetostart="-16230598" data-end="1490695200000"
                                           data-start="1490666400000">
                                            <span class="J_TimeLeft">03<i>时</i>17<i>分</i>26<i>秒</i></span>
                                        </p>
                                    </div>


                                    <div class="item-side-box item-bid-box">
                                        <span class="side-num">59</span>
                                        <span class="side-text">次出价</span>
                                    </div>

                                    <div class="item-side-box item-look-box">
                                        <span class="side-num">1.26万</span>
                                        <span class="side-text">次围观</span>
                                    </div>
                                </div>

                            </a>
                        </li>

                        <li id="pai-album-item-137125559" class="item state-now">
                            <a class="item-wrap" target="_blank"
                               href="https://paimai.taobao.com/pmp_album/137125559.htm">
                                <div class="img-wrap">
                                    <img alt="春心萌动气质百搭翡翠联合专场"
                                         src="img/TB2rbp7Xr_0UKFjy1XaXXbKfXXa_!!0-paimai.jpg_600x600Q90.jpg">
                                </div>
                                <div class="item-content">
                                    <img class="item-status-over" src="img/T1x5z2FKJXXXXKN.Q6-114-60.png">
                                    <p class="item-title">春心萌动气质百搭翡翠联合专场</p>
                                    <p class="item-store">
                                        <em>送拍机构</em>
                                        <span>多商家联合选送</span>
                                    </p>
                                    <p class="item-show-time">
                                        <em>开拍时间</em>
                                        <span>2017年03月28日 09:00</span>
                                    </p>

                                    <div class="item-countdown">
                                        <span class="countdown-text">距结束</span>
                                        <p class="J_PAlbum pai-countdown" data-itemid="137125559"
                                           data-now="1490683206438" data-timetoend="22646846"
                                           data-timetostart="-19830598" data-end="1490706000000"
                                           data-start="1490662800000">
                                            <span class="J_TimeLeft">06<i>时</i>17<i>分</i>26<i>秒</i></span>
                                        </p>
                                    </div>


                                    <div class="item-side-box item-bid-box">
                                        <span class="side-num">203</span>
                                        <span class="side-text">次出价</span>
                                    </div>

                                    <div class="item-side-box item-look-box">
                                        <span class="side-num">2.49万</span>
                                        <span class="side-text">次围观</span>
                                    </div>
                                </div>

                            </a>
                        </li>


                    </ul>
                </div>
            </div>
            <div id="J_FutureAlbum" data-spm-ab="futureAlbum">
                <a class="more" href="https://paimai.taobao.com/calendar.htm?date=2017-03-30" target="_blank">未来七天共<b
                        class="J_FutureAlbumCount">216</b>场 &gt;</a>
            </div>
        </div>
        <div id="J_HotItemList" class="hot-item-list">


            <div class="side-tg J_CustomItem" data-spm-ab="sideAd">

                <a href="https://www.taobao.com/markets/paimai/limitTimePC?spm=a2129.3065125.0.0.abDAii"
                   target="true ? '_blank' : '_self' ?&gt;">
                    <img src="img/TB1GOS9KFXXXXaSXVXXXXXXXXXX-280-220.jpg" alt="" width="280" height="220">
                </a>

            </div>


            <div class="header" data-spm-ab="sideTitle"><a
                    href="https://s-paimai.taobao.com/list.htm?stype=3&amp;ist=1&amp;st_rq=1&amp;_pc_client=1&amp;sorder=0"
                    target="_blank"><span class="title iconfont-pai"><em>最</em>热拍品</span></a></div>
            <div class="list-content" data-spm-ab="{{#if(isCustom)}}sidePersonalized{{else}}sideCommon{{/if}}">
                <ul class="item-list {{#if(isHot)}}state-hot{{else}}state-look{{/if}}">
                    <li class="item">
                        <div class="item-info"><a target="_blank" class="img-wrap"
                                                  href="https://paimai.taobao.com/pmp_item/546720757970.htm"><img
                                alt="绝当【9.8新】积家约会系列自动机械女表 宝瑞通典当行"
                                src="img/TB21cefjhhmpuFjSZFyXXcLdFXa_!!0-paimai.jpg_240x240Q90.jpg"></a>
                            <p class="title"><a target="_blank"
                                                href="https://paimai.taobao.com/pmp_item/546720757970.htm">绝当【9.8新】积家约会系列自动机械女表
                                宝瑞通典当行</a></p></div>
                        <div class="item-meta"><p class="price">当前价<span>￥9601</span></p>
                            <p class="bid-num"><i class="iconfont-pai">锤</i><span>60</span><em>次</em></p>
                            <p class="look-num"><span>1506</span><em>次围观</em></p></div>
                    </li>
                    <li class="item">
                        <div class="item-info"><a target="_blank" class="img-wrap"
                                                  href="https://paimai.taobao.com/pmp_item/547014493963.htm"><img
                                alt="[9.5新]欧米茄-自动机械-精钢-男表-GZ030109-0327"
                                src="img/TB20PvgiwNlpuFjy0FfXXX3CpXa_!!0-paimai.jpg_240x240Q90.jpg"></a>
                            <p class="title"><a target="_blank"
                                                href="https://paimai.taobao.com/pmp_item/547014493963.htm">[9.5新]欧米茄-自动机械-精钢-男表-GZ030109-0327</a>
                            </p></div>
                        <div class="item-meta"><p class="price">当前价<span>￥1.6601万</span></p>
                            <p class="bid-num"><i class="iconfont-pai">锤</i><span>50</span><em>次</em></p>
                            <p class="look-num"><span>1128</span><em>次围观</em></p></div>
                    </li>
                    <li class="item">
                        <div class="item-info"><a target="_blank" class="img-wrap"
                                                  href="https://paimai.taobao.com/pmp_item/547116535230.htm"><img
                                alt="[9.5新]江诗丹顿-30130/000R-9754-手动机械-男表-U120519-0327"
                                src="img/TB2kVbpbYBnpuFjSZFGXXX51pXa_!!0-paimai.jpg_240x240Q90.jpg"></a>
                            <p class="title"><a target="_blank"
                                                href="https://paimai.taobao.com/pmp_item/547116535230.htm">[9.5新]江诗丹顿-30130/000R-9754-手动机械-男表-U120519-0327</a>
                            </p></div>
                        <div class="item-meta"><p class="price">当前价<span>￥28.0001万</span></p>
                            <p class="bid-num"><i class="iconfont-pai">锤</i><span>37</span><em>次</em></p>
                            <p class="look-num"><span>10822</span><em>次围观</em></p></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <script>
        (function (S) {
            S.ready(function () {
                S.use('index-middle', function (S, Mod) {
                    new Mod('#index-middle');
                });
            })
        })(KISSY);
    </script>

    <!--编辑地址:/pmp/jianlou-->
    <div id="pm-jianlou" class="pm-jianlou">
        <div class="jianlou-title">
            <a>
                <span class="red">捡</span>
                漏
            </a>
        </div>

        <div id="JSlide">
            <div class="trigger-bar">
                <a href="javascript:void(0);" title="下翻" id="next1" class="next">右<span>1/3</span></a>
                <a href="javascript:void(0);" title="上翻" id="prev1" class="prev">左<span>1/3</span></a>

            </div>
            <div id="panel1" class="jianlou-container scrollable-panel"
                 style="width: 1190px; overflow: hidden; height: 322px;">
                <div style="position: absolute; overflow: hidden; width: 5950px; transition-duration: 0s; transform: translate3d(-1190px, 0px, 0px); backface-visibility: hidden; left: 0px;">
                    <div class="scrollable-content"
                         style="float: left; overflow: hidden; width: 1190px; display: block;">
                        <div class="itemGroup">
                            <div class="J_Item jianlou-item" id="542276018075">
                                <div class="proContent"><a target="_blank"
                                                           href="https://paimai.taobao.com/pmp_item/542276018075.htm"
                                                           class="proWrap" title="刘洪磊《银川千丈》70X180">
                                    <div class="imgWrap"><img
                                            src="img/TB2S_shep5N.eBjSZFvXXbvMFXa_!!0-paimai.jpg_300x300Q90.jpg"
                                            alt="刘洪磊《银川千丈》70X180">
                                        <div class="title">刘洪磊《银川千丈》70X180</div>
                                    </div>
                                    <div class="priceInfo"><em>当前价</em><span class="price"><span
                                            class="yen">￥</span><span class="currentPrice">1580</span></span>
                                        <div class="paiInfo"><span class="pai">锤</span><span class="bidTimes">0</span>次
                                        </div>
                                    </div>
                                </a></div>
                            </div>
                            <div class="J_Item jianlou-item" id="538964724454">
                                <div class="proContent"><a target="_blank"
                                                           href="https://paimai.taobao.com/pmp_item/538964724454.htm"
                                                           class="proWrap" title="【品相完美】大原石212.26克原皮原色和田玉精品收藏">
                                    <div class="imgWrap"><img
                                            src="img/TB2uGwMhMJlpuFjSspjXXcT.pXa_!!0-paimai.jpg_300x300Q90.jpg"
                                            alt="【品相完美】大原石212.26克原皮原色和田玉精品收藏">
                                        <div class="title">【品相完美】大原石212.26克原皮原色和田玉精品收藏</div>
                                    </div>
                                    <div class="priceInfo"><em>当前价</em><span class="price"><span
                                            class="yen">￥</span><span class="currentPrice">2.6万</span></span>
                                        <div class="paiInfo"><span class="pai">锤</span><span class="bidTimes">0</span>次
                                        </div>
                                    </div>
                                </a></div>
                            </div>
                            <div class="J_Item jianlou-item" id="523299538011">
                                <div class="proContent"><a target="_blank"
                                                           href="https://paimai.taobao.com/pmp_item/523299538011.htm"
                                                           class="proWrap" title="林彬彬 省工艺美术师 《春晓》德化白瓷艺术藏品">
                                    <div class="imgWrap"><img
                                            src="img/TB2Bu4Eh4XlpuFjSsphXXbJOXXa_!!0-paimai.jpg_300x300Q90.jpg"
                                            alt="林彬彬 省工艺美术师 《春晓》德化白瓷艺术藏品">
                                        <div class="title">林彬彬 省工艺美术师 《春晓》德化白瓷艺术藏品</div>
                                    </div>
                                    <div class="priceInfo"><em>当前价</em><span class="price"><span
                                            class="yen">￥</span><span class="currentPrice">1088</span></span>
                                        <div class="paiInfo"><span class="pai">锤</span><span class="bidTimes">0</span>次
                                        </div>
                                    </div>
                                </a></div>
                            </div>
                            <div class="J_Item jianlou-item" id="542107244312">
                                <div class="proContent"><a target="_blank"
                                                           href="https://paimai.taobao.com/pmp_item/542107244312.htm"
                                                           class="proWrap" title="【大红袍茄段】 吴小伟 工艺美术员">
                                    <div class="imgWrap"><img
                                            src="img/TB2F3iBekWM.eBjSZFhXXbdWpXa_!!0-paimai.jpg_300x300Q90.jpg"
                                            alt="【大红袍茄段】 吴小伟 工艺美术员">
                                        <div class="title">【大红袍茄段】 吴小伟 工艺美术员</div>
                                    </div>
                                    <div class="priceInfo"><em>当前价</em><span class="price"><span
                                            class="yen">￥</span><span class="currentPrice">1000</span></span>
                                        <div class="paiInfo"><span class="pai">锤</span><span class="bidTimes">0</span>次
                                        </div>
                                    </div>
                                </a></div>
                            </div>
                        </div>
                    </div>
                    <div class="scrollable-content"
                         style="float: left; overflow: hidden; width: 1190px; display: block;">
                        <div class="itemGroup">
                            <div class="J_Item jianlou-item" id="538424525251">
                                <div class="proContent"><a target="_blank"
                                                           href="https://paimai.taobao.com/pmp_item/538424525251.htm"
                                                           class="proWrap" title="【9新】卡地亚CARTIER桑托斯系列石英男表W20060D6">
                                    <div class="imgWrap"><img
                                            src="img/TB2spclaGm5V1BjSszhXXcMtXXa_!!0-paimai.jpg_300x300Q90.jpg"
                                            alt="【9新】卡地亚CARTIER桑托斯系列石英男表W20060D6">
                                        <div class="title">【9新】卡地亚CARTIER桑托斯系列石英男表W20060D6</div>
                                    </div>
                                    <div class="priceInfo"><em>当前价</em><span class="price"><span
                                            class="yen">￥</span><span class="currentPrice">1.55万</span></span>
                                        <div class="paiInfo"><span class="pai">锤</span><span class="bidTimes">0</span>次
                                        </div>
                                    </div>
                                </a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <ul class="scrollable-trigger" style="display:none">
                <li class="current"><a href="javascript:void(0);" class="current">1</a></li>
                <li class=""><a href="javascript:void(0);">2</a></li>
                <li class=""><a href="javascript:void(0);">3</a></li>
            </ul>
        </div>
    </div>
    <script>
        (function (S) {
            S.ready(function () {
                S.use('pm-jianlou', function (S, Mod) {
                    new Mod('#pm-jianlou');
                });
            })
        })(KISSY);
    </script>
</div>
<!-- mock assets -->


<!--编辑地址: /pmp/partner-institution-->



<link rel="stylesheet" type="text/css" href="/css/index(1).css">

<a id="pm-right-banner" href="https://www.taobao.com/markets/paimai/20161212/index" target="_blank"
   class="pm-right-banner" style="top: 0px; width: 77px; display: none; height: 29854px;">
    <div class="inner">
        <img alt="" src="img/TB1wkMOOpXXXXaCXXXXXXXXXXXX-77-2300.gif" style="width: 77px;height: 2300px">
        <img class="icon" alt="" src="img/TB1fLZHOpXXXXasXpXXXXXXXXXX-54-56.png"
             style="top: 555px;right:8px;width: 54px;height: 56px">
    </div>
</a>
<a href="javascript:;" target="_self" class="J_QrFt qr-ft">
    <s class="tb-icon"></s>
</a>
<script>
    (function (S) {
        S.ready(function () {
            S.use('pm-right-banner', function (S, Mod) {
                new Mod('#pm-right-banner');
            });
        })
    })(KISSY);
</script>


<script src="js/index.js(4).下载"></script>


<input type="hidden" id="J_Mpp_Switcher" value="true">
<!--TMS:1495800-->



<div class="skin-default" data-name="mkt-sidebar" data-skin="default" data-guid="14177696725030"
     id="guid-14177696725030" data-version="3" data-type="3" data-hidden="true">
    <div class="mkt-sidebar tb-finish" style="display:none"></div>
</div>


<script>KISSY.use("node", function (S) {
    S.all('#guid-14177696725030').each(function (a) {
        var b = a.attr("data-name"), c = a.one("." + b);
        c.hasClass("tb-finish") || S.use(b, function (b, d) {
            new d(a[0], c[0])
        })
    })
});</script>

<link rel="canonical" href="https://paimai.taobao.com/">
<script src="js/index.js(5).下载"></script>
<div class="grid-c">
    <div class="pm-foot clearfix">
        <link rel="stylesheet" type="text/css" href="/css/index(2).css">

        <div id="pm-footer" class="pm-bottom">
            <div class="pai-bottom-slogan">
                <ul class="slogan-list">

                    <li class="slogan-item ">
                        <i class="iconfont-pai-b">单</i>
                        <div class="meta">
                            <span>如实描述承诺</span>
                            <p>送拍机构在发拍品时会履行实物描述义务</p>
                        </div>
                    </li>

                    <li class="slogan-item ">
                        <i class="iconfont-pai-b">钱</i>
                        <div class="meta">
                            <span>保证金保障</span>
                            <p>送拍机构都会缴纳足额保证金来确保安全</p>
                        </div>
                    </li>

                    <li class="slogan-item slogan-last">
                        <i class="iconfont-pai-b">保</i>
                        <div class="meta">
                            <span>售后服务保障</span>
                            <p>送拍机构承诺提供周到的全面的售后服务</p>
                        </div>
                    </li>

                </ul>
            </div>

        </div>
        <script src="js/index.js(6).下载"></script>

    </div>

</div>
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cspan id='cnzz_stat_icon_1253345903'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "w.cnzz.com/q_stat.php%3Fid%3D1253345903' type='text/javascript'%3E%3C/script%3E"));</script>
<span id="cnzz_stat_icon_1253345903"></span>
<script src=" http://w.cnzz.com/q_stat.php?id=1253345903" type="text/javascript"></script>
<span id="cnzz_stat_icon_1253345903"></span>
<script src="php/q_stat.php" type="text/javascript"></script>
<span id="cnzz_stat_icon_1253345903"></span>
<script src="php/q_stat(1).php" type="text/javascript"></script>

<div id="J_xmpp14906824838800-1009-2"></div>
<div id="J_UmppUserContainer" style="height:1px;width:1px;overflow:hidden;position:absolute;bottom:1px"></div>
<iframe src="//mmstat.alicdn.com/aplus-proxy.html?v=20130115"
        name="{&quot;url&quot;:&quot;http://log.mmstat.com/o.gif?logtype=1&amp;title=%u73CD%u54C1%u62CD%u5356%20-%20%u95F2%u9C7C%u62CD%u5356&amp;pre=&amp;cache=6019d1b&amp;scr=1280x800&amp;spm-cnt=a2129.3065125.0.0.SM98SK&amp;category=&amp;uidaplus=&amp;aplus&amp;isbeta=7&amp;p=1&amp;o=mac&amp;b=safari10&amp;s=1280x800&amp;w=webkit&amp;ism=mac&amp;jsver=aplus_v2&amp;fp=47bb5ece873f70b723a7a4890cea6d88&amp;fp2=206030245ab6cc17e81bb52962685415&amp;tag=0&amp;stag=-3&quot;,&quot;js&quot;:&quot;//g.alicdn.com/alilog/mlog/lsproxy.js?v=20150514&quot;,&quot;referrer&quot;:&quot;file:///Users/kuboken/Downloads/%E4%B8%BB%E9%A1%B5/%E7%8F%8D%E5%93%81%E6%8B%8D%E5%8D%96%20-%20%E9%97%B2%E9%B1%BC%E6%8B%8D%E5%8D%96.html&quot;}"
        data-spm-act-id="a2129.3065125.0.i1.SM98SK"
        style="width: 1px; height: 1px; position: absolute; display: none;"></iframe>
</body>
</html>