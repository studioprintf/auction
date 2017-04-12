
var lazyloadSize = {
    '2_8080': '160160',
    '2_120120': '220220',
    '2_160160': '320320',
    '2_180180': '320320',
    '2_220220': '320320',
    '2_320320': '320320',
    '2_480480': '480480',
    '1_8080': '8080',
    '1_120120': '120120',
    '1_160160': '160160',
    '1_180180': '180180',
    '1_220220': '220220',
    '1_320320': '320320',
    '1_480480': '480480',
    '2_8060': '160160',
    '2_12090': '220220',
    '2_160120': '320320',
    '2_180135': '320320',
    '2_220165': '320320',
    '2_320300': '320320',
    '2_480360': '480480',
    '1_8060': '8080',
    '1_12090': '120120',
    '1_160120': '160160',
    '1_180135': '180180',
    '1_220165': '220220',
    '1_320300': '320320',
    '1_480360': '480480',
};
$.fn.lazyload = function (options) {
    $(this).each(function () {
        var self = this;
        var settings = {
            threshold: 0, //闂撮殧
            container: window, //
            outTime: 1000, //鍔犺浇瓒呮椂
            srcProperty: 'truesrc', //鐪熷疄src鍦板潃
            child: 'img'		//瀛愰€夋嫨鍣�
        };
        if (options) {
            $.extend(settings, options);
        }
        var DATA_NAME = 'touch_lazyload_event_' + settings.mode + '_' + settings.srcProperty;
        var DATA_NAME_Timeout = DATA_NAME + '_timeout';
        var CHILD_NAME = DATA_NAME + '_child';
        if (settings.act == 'run') {
            try {
                $(self).data(DATA_NAME)();
                return;
            } catch (e) {
            }
        }
        clearTimeout($(self).data(DATA_NAME_Timeout));
        if ($(self).data(DATA_NAME)) {
            $(settings.container).unbind('scroll', $(self).data(DATA_NAME));
        }
        $(self).data(CHILD_NAME, []);
        if (settings.act == 'stop') {
            return;
        }
        $(self).find(settings.child).each(function () {
            $(self).data(CHILD_NAME).push(this);
        });
        var length = $(self).data(CHILD_NAME).length;
        $(self).data(DATA_NAME, function () {
            clearTimeout($(self).data(DATA_NAME_Timeout));
            $(self).data(DATA_NAME_Timeout, setTimeout(function () {
                var scrollTop = $(settings.container).scrollTop();
                var height = $(settings.container).height();
                var isload = false;
                for (var i = 0; i < length;) {
                    var element = $(self).data(CHILD_NAME)[i];
                    var top = $(element).offset().top;
                    var src = $(element).attr(settings.srcProperty);
                    if (src) {
                        if (height + scrollTop < top - settings.threshold || top + $(element).height() + settings.threshold < scrollTop) {
                            if (isload) {
                                break;
                            }
                            i++;
                        } else {
                            isload = true;
                            $(element).attr(settings.srcProperty, null);
                            clearTimeout($(this).data('setTimeout'));
                            if ($(element).hasClass('shoe')) {
                                var srcs = src.match(/(\d+)(\.[a-zA-Z]+)$/);
                                src = src.replace(srcs[0], lazyloadSize[window['pxDevicePixelRatio'] + '_' + srcs[1]] + srcs[2]);
                                srcs = null;
                            }
                            var tagName = "";
                            try {
                                tagName = $(element).attr('tagName').toLowerCase();
                            } catch (e) {
                                tagName = $(element)[0].tagName.toLowerCase();
                            }
                            if (tagName == 'img') {
                                if (/(^|\s)img\d+($|\s)/.test($(element).parent().attr('class'))) {
                                    $(element).parent().css('background-image', 'none');
                                }
                                $(element).attr('src', src);
                            } else {
                                $(element).css({ "background-image": "url(" + src + ")" });
                            }
                            /*(function(src, element) {
                                var img = $('<img style="display: none;"/>').appendTo('body').one('load', function() {
                                    clearTimeout($(this).data('setTimeout'));
                                    if ($(element).hasClass('shoe')) {
                                        var srcs = src.match(/(\d+)(\.[a-zA-Z]+)$/);
                                        src = src.replace(srcs[0], lazyloadSize[window['pxDevicePixelRatio'] + '_' + srcs[1]] + srcs[2]);
                                        srcs = null;
                                    }
                                    if ($(element).attr('tagName').toLowerCase() == 'img') {
                                        if (/(^|\s)img\d+($|\s)/.test($(element).parent().attr('class'))) {
                                            $(element).parent().css('background-image', 'none');
                                        }
                                        $(element).attr('src', src);
                                    } else {
                                        $(element).css({"background-image": "url(" + src + ")"});
                                    }
                                    img.remove();
                                }).attr('src', src);
                                img.data('setTimeout', setTimeout(function() {
                                    img.trigger('load');
                                }, settings.outTime));
                            })(src, element);*/
                            $(self).data(CHILD_NAME).splice(i, 1);
                            length--;
                        }
                    } else {
                        $(self).data(CHILD_NAME).splice(i, 1);
                        length--;
                    }
                }
                if (!length) {
                    clearTimeout($(self).data(DATA_NAME_Timeout));
                    if ($(self).data(DATA_NAME)) {
                        $(settings.container).unbind('scroll', $(self).data(DATA_NAME));
                    }
                    $(self).data(CHILD_NAME, null);
                }
            }, 200));
        });
        $(settings.container).bind('scroll', $(self).data(DATA_NAME));
        $(self).data(DATA_NAME)();
    });
    return $(this);
};

$('body').lazyload({ child: '[truesrc]' });