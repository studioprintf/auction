<%--
  Created by IntelliJ IDEA.
  User: Dymond
  Date: 2017/3/31
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html class="ks-webkit602 ks-webkit ks-safari10 ks-safari">
<head>


    <link rel="stylesheet" href="/css/entry.css" charset="utf-8">

    <title>商品发布</title>


    <link rel="stylesheet" href="/css/p_c2c_20110728_header-min.css">


    <style></style>
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/scss.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/410.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/helper.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/pop.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/struct.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/modules.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/commit.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/editor.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/tpl.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/api.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index2.css">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/dropdown.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/help.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/warning.css" rel="stylesheet">
    <link charset="utf-8" href="${pageContext.request.contextPath}/css/simple_inline.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wangEditor.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.skin.css"/>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css"/>--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>


    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.0.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
</head>
<body data-spm="7873970">

<!-- from c2c vmcommon -->
<div id="header">
    <div id="site-nav">
        <p class="login-info">
            您好，<a class="user-nick" href="//jianghu.taobao.com/?t=1490971721284" target="_top">jianxuanfeng</a>！<a
                id="J_Logout" href="https://login.taobao.com/member/logout.jhtml?f=top" target="_top">退出</a>
        </p>
        <ul class="quick-menu">
            <li class="home"><a href="//www.taobao.com/">淘宝网首页</a></li>
            <li class="menu-item">
                <div class="menu">
                    <a class="menu-hd" style="width:36px;"
                       href="//ju.atpanel.com/?url=//love.taobao.com?ad_id=&amp;am_id=&amp;cm_id=&amp;pm_id=15004294216338fc3746"
                       target="_top" rel="nofollow">我要买<b></b></a>
                    <div class="menu-bd" style="width:82px;height:75px;line-height:1.7;">
                        <div class="menu-bd-panel" style="padding:8px 10px;">
                            <div>
                                <a href="//ju.atpanel.com/?url=//list.taobao.com/browse/cat-0.htm?ad_id=&amp;am_id=&amp;cm_id=&amp;pm_id=15006048193468e03af6"
                                   target="_top" rel="nofollow">商品分类</a>
                                <a href="//ju.atpanel.com/?url=//love.taobao.com/guang/index.htm?ad_id=&amp;am_id=&amp;cm_id=&amp;pm_id=1500604820c8c4721fc4"
                                   target="_top" rel="nofollow">大家正在买</a>
                                <a href="//ju.atpanel.com/?url=//love.taobao.com/toukui/index.htm?ad_id=&amp;am_id=&amp;cm_id=&amp;pm_id=150060482114b4eabfba"
                                   target="_top" rel="nofollow">品味连连看</a>
                            </div>
                        </div>
                    </div>
                </div>
            </li>

            <li class="mytaobao menu-item">
                <div class="menu">
                    <a class="menu-hd" href="//i.taobao.com/my_taobao.htm" target="_top" rel="nofollow">我的淘宝<b></b></a>
                    <div class="menu-bd" style="height: 36px;">
                        <div class="menu-bd-panel" id="myTaobaoPanel">
                            <div>
                                <a href="//trade.taobao.com/trade/itemlist/list_bought_items.htm" target="_top"
                                   rel="nofollow">已买到的宝贝</a>
                            </div>
                        </div>
                    </div>
                </div>
            </li>

            <style>
                #site-nav .seller-center .menu-hd {
                    width: 48px;
                }

                #site-nav .seller-center .menu-bd {
                    width: 94px;
                    line-height: 1.7;
                }

                #site-nav .seller-center .menu-bd-panel {
                    padding: 8px 10px;
                }
            </style>
            <li class="seller-center menu-item">
                <div class="menu">
                    <a class="menu-hd" href="//mai.taobao.com/seller_admin.htm" target="_top" rel="nofollow">卖家中心<b></b></a>
                    <div class="menu-bd">
                        <div class="menu-bd-panel">
                            <div>
                                <a href="//trade.taobao.com/trade/itemlist/list_sold_items.htm" target="_top"
                                   rel="nofollow">已卖出的宝贝</a>
                                <a href="//sell.taobao.com/auction/goods/goods_on_sale.htm" target="_top"
                                   rel="nofollow">出售中的宝贝</a>
                            </div>
                        </div>
                    </div>
                </div>
            </li>


        </ul>
    </div>
    <!-- -->


</div>
<script>TB.Header.init();</script>
<!-- end c2c vmcommon -->


<div id="page" control_type="root">
    <div data-spm="1998855314" id="main"><h1>1. 商品基本信息</h1>
        <div class="struct rootStruct" control_type="struct" control_classpath="xsell/modules/struct/index"
             id="itemBasic">
            <table class="showbar" id="settings">
                <tbody>
                <tr>
                    <td class="bar"><em style="display: inline;">*<em></em></em><label for="title"
                                                                                       style="display: inline;">宝贝标题</label>
                    </td>
                    <td>
                        <div class="texbox title-box" control_type="title"
                             control_classpath="xsell/modules/textbox/title" control_id="title" >
                            <div class="inputbox"><input id="product_title" type="text" aria-required="true"> <span
                                    class="input-count"><strong>0</strong>/60</span></div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bar"><em style="display: inline;">*<em></em></em><label for="multiMedia"
                                                                                       style="display: inline;">电脑端宝贝图片</label>
                    </td>
                    <td>
                        <div class="block info" style="margin: 0px 0px 3px;">宝贝主图大小不能超过3MB；700*700
                            以上图片上传后宝贝详情页自动提供放大镜功能。 第五张图发商品白底图可增加手淘首页曝光机会 <a
                                    href="//taobaosell.bbs.taobao.com/detail.html?appId=23012&amp;postId=6529756"
                                    target="_blank">查看规范</a></div>
                        <div class="multmedia-wrap clearfix" control_type="multi_media"
                             control_classpath="xsell/modules/multi_media/index" control_id="multiMedia"
                             id="multiMedia">
                            <div class="multimage-wrap" control_type="multi_img"
                                 control_classpath="xsell/modules/multi_img/index" control_id="multiMedia.image">
                                <ul class="image-list">
                                    <li data-media="image" aria-label="宝贝主图: 按Enter键打开图片空间选择图片，按Esc退出弹层">
                                        <div class="operate" id="operate0"><i class="icon iconfont icon-sortleft toleft"
                                                                title="左移"></i><i
                                                class="icon iconfont icon-sortright toright" title="右移"></i><i
                                                class="icon iconfont icon-remove del" title="删除"></i></div>
                                        <div class="preview" id="preview0"><a title="上传图片" tabindex="1" class="upload-tip"
                                                                style="display: inline;"><i
                                                class="icon iconfont icon-tianjia"></i></a></div>
                                        <span class="info"><em>*</em>宝贝主图</span></li>

                                    <li data-media="image" aria-label="宝贝主图: 按Enter键打开图片空间选择图片，按Esc退出弹层">
                                        <div class="operate" id="operate1"><i class="icon iconfont icon-sortleft toleft"
                                                                title="左移"></i><i
                                                class="icon iconfont icon-sortright toright" title="右移"></i><i
                                                class="icon iconfont icon-remove del" title="删除"></i></div>
                                        <div class="preview" id="preview1"><a title="上传图片" tabindex="2" class="upload-tip"
                                                                style="display: inline;"><i
                                                class="icon iconfont icon-tianjia"></i></a></div>
                                    </li>

                                    <li data-media="image" aria-label="宝贝主图: 按Enter键打开图片空间选择图片，按Esc退出弹层">
                                        <div class="operate" id="operate2"><i class="icon iconfont icon-sortleft toleft"
                                                                title="左移"></i><i
                                                class="icon iconfont icon-sortright toright" title="右移"></i><i
                                                class="icon iconfont icon-remove del" title="删除"></i></div>
                                        <div class="preview" id="preview2"><a title="上传图片" tabindex="3" class="upload-tip"
                                                                style="display: inline;"><i
                                                class="icon iconfont icon-tianjia"></i></a></div>
                                    </li>


                                    <li data-media="image" aria-label="宝贝主图: 按Enter键打开图片空间选择图片，按Esc退出弹层">
                                        <div class="operate" id="operate3"><i class="icon iconfont icon-sortleft toleft"
                                                                title="左移"></i><i
                                                class="icon iconfont icon-sortright toright" title="右移"></i><i
                                                class="icon iconfont icon-remove del" title="删除"></i></div>
                                        <div class="preview" id="preview3"><a title="上传图片" tabindex="4" class="upload-tip"
                                                                style="display: inline;"><i
                                                class="icon iconfont icon-tianjia"></i></a></div>
                                    </li>
                                    <li data-media="image" aria-label="宝贝主图: 按Enter键打开图片空间选择图片，按Esc退出弹层">
                                        <div class="operate" id="operate4"><i class="icon iconfont icon-sortleft toleft"
                                                                title="左移"></i><i
                                                class="icon iconfont icon-sortright toright" title="右移"></i><i
                                                class="icon iconfont icon-remove del" title="删除"></i></div>
                                        <div class="preview" id="preview4"><a title="上传图片" tabindex="5" class="upload-tip"
                                                                style="display: inline;"><i
                                                class="icon iconfont icon-tianjia"></i></a></div>
                                </ul>

                            </div>
                        </div>

                    </td>
                </tr>
                <tr>
                    <td class="bar"><em style="display: none;">*<em></em></em><label for="descForPC"
                                                                                     style="display: none;"></label>
                    </td>
                    <td>
<!--Editor-->
                        <div style="width: 90%">
                            <div style="width: 600px; height: 400px;" id="editor">
                                <p></p>
                            </div>
                        </div>





<!--             -->
                    </td>
                </tr>
                <tr style="display: none;">
                    <td class="bar"><em style="display: none;">*<em></em></em><label for="tspWlsDesc"
                                                                                     style="display: none;"></label>
                    </td>
                    <td>
                        <div control_type="mobile_shenbi" control_classpath="xsell/modules/desc/shenbi/mobile"
                             control_id="tspWlsDesc" class="shenbi-mobile" style="display: none;">
                            <div id="shenbi10">
                                <div class="wl-box" style="width: 100%; height: 498px;">
                                    <div class="wl-title"><a href="javascript:;" class="shenbi-close"></a><a href="#"
                                                                                                             style="display: inline;"
                                                                                                             id="J_shenbiUpdatewl_1"
                                                                                                             class="shenbi-update">修改</a>淘宝神笔宝贝详情编辑器
                                    </div>
                                    <iframe id="J_wlFrame_1" width="100%" frameborder="0"
                                            src="//sell.xiangqing.taobao.com/sell/editStart.html?frameId=wl_1&amp;actionStatus=0&amp;catId=140116&amp;itemId=547775982219&amp;clientType=1&amp;"
                                            style="height: 448px;"></iframe>
                                    <iframe style="display:none;" id="J_wlFrame_pob_1" width="100%" frameborder="0"
                                            src="about:blank;"></iframe>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <h1>2. 竞拍设定</h1>
        <div class="struct rootStruct" control_type="struct" control_classpath="xsell/modules/struct/index"
             id="otherInfomation">
            <table class="showbar">
                <tbody>
                <tr>
                    <td class="bar"><em style="display: inline;">*<em></em></em><label
                                                                                     style="display: inline;">起拍价格</label>
                    </td>
                    <td>
                        <input type="text" id="reserve_price" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"  />元
                    </td>
                </tr>
                <tr>
                    <td class="bar"><em style="display: inline;"><em></em></em><label
                            style="display: inline;">加价幅度</label>
                    </td>
                    <td>
                        <select id="limit" >
                            <option value="1" selected="selected">1</option>
                            <option value="10" >10</option>
                            <option value="100">100</option>
                            <option value="200">200</option>
                            <option value="500">500</option>
                            <option value="1000">1000</option>
                        </select>元
                    </td>
                </tr>

                <!--开始时间-->
                <tr>
                    <td class="bar"><em style="display: inline;">*<em></em></em><label
                                                                                       style="display: inline;">开始时间</label>
                    </td>
                    <td>
                        <div class="checkbox-wrap" control_type="radio" control_classpath="xsell/modules/radio/index"
                             control_id="startTime" id="startTime"><label><input type="radio"
                                                                                                     aria-label="上架时间:单选，左右方向键切换选项，空格键选中当前项，当前项立刻上架"
                                                                                                     name="radio22"
                                                                                                     value="0" id="radio22off"
                                                                                                     checked="checked">立刻上架</label><label>
                            <input
                                type="radio" aria-label="上架时间:单选，左右方向键切换选项，空格键选中当前项，当前项定时上架" name="radio22" id="radio22on" value="1">定时上架</label>
                        </div>
                    </td>
                </tr>
                <tr style="display: none" id="fixTime">
                    <td class="bar"><em style="display: inline;">*<em></em></em><label
                            style="display: inline;">上架时间</label>
                    </td>
                    <!--time picker-->
                    <td>
                        <input  type="text" value="" id="start_time" readonly class="form_datetime">
                    </td>
                </tr>

                <!--结束时间-->
                <tr>
                    <td class="bar"><em style="display: inline;">*<em></em></em><label
                                                                                       style="display: inline;">结束时间</label>
                    </td>
                    <td>
                        <input  type="text" value="" ID="end_time" readonly class="form_datetime">
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
        <h1></h1>
        <div id="commit" control_type="commit_sell" control_classpath="xsell/modules/commit_sell/index"
             control_id="commitBtn" class="floatbar rootStruct">
            <button class="blue" type="button" id="submitButton">发 布</button>
        </div>
    </div>
</div>




<!--图片上传隐藏域  using Ajax-->
<form id="uploadForm" enctype="multipart/form-data">
<input type="file" name="fileToUpload" id="fileToUpload" accept="image/gif, image/jpeg ,image/png" onchange="fileSelected();" style="display:none;" multiple="multiple"/>
</form>


<form id="submitForm">
<input type="hidden" id="img0" name="img0" value=""/>
<input type="hidden" id="img1" name="img1" value=""/>
<input type="hidden" id="img2" name="img2"  value=""/>
<input type="hidden" id="img3" name="img3"  value=""/>
<input type="hidden" id="img4" name="img4"  value=""/>
</form>
<!---->


<div style="padding:25px 0px"></div>


<script type="text/javascript" src="/js/upload_reg.js"></script>
<script type="text/javascript" src="/js/wangEditor.min.js"></script>
<script type="text/javascript">
    $("#start_time").datetimepicker({
        format: "yyyy-mm-dd hh:ii:00",
        autoclose: true,
        todayBtn: false,
        startDate: getTenMinAfterTime(),
        endDate: getDaysAfterTime(),

         minuteStep: 10
    });

    $("#end_time").datetimepicker({
        format: "yyyy-mm-dd hh:ii:00",
        autoclose: true,
        todayBtn: false,
        startDate: getTenMinAfterTime(),
        endDate: getDaysAfterTime(),
         minuteStep: 10
    });
</script>

</body>
</html>
