(function () {

    if (window.magicJS) {
        return
    }

    var a = {
        version: "v2.4.3",
        UUID: 0,
        storage: {},
        $uuid: function (c) {
            return (c.$J_UUID || (c.$J_UUID = ++$J.UUID))
        },
        getStorage: function (c) {
            return ($J.storage[c] || ($J.storage[c] = {}))
        },
        $F: function () { },
        $false: function () {
            return false
        },
        defined: function (c) {
            return (undefined != c)
        },
        exists: function (c) {
            return !!(c)
        },
        j1: function (c) {
            if (!$J.defined(c)) {
                return false
            }
            if (c.$J_TYPE) {
                return c.$J_TYPE
            }
            if (!!c.nodeType) {
                if (1 == c.nodeType) {
                    return "element"
                }
                if (3 == c.nodeType) {
                    return "textnode"
                }
            }
            if (c.length && c.item) {
                return "collection"
            }
            if (c.length && c.callee) {
                return "arguments"
            }
            if ((c instanceof window.Object || c instanceof window.Function) && c.constructor === $J.Class) {
                return "class"
            }
            if (c instanceof window.Array) {
                return "array"
            }
            if (c instanceof window.Function) {
                return "function"
            }
            if (c instanceof window.String) {
                return "string"
            }
            if ($J.j21.trident) {
                if ($J.defined(c.cancelBubble)) {
                    return "event"
                }
            } else {
                if (c instanceof window.Event || c === window.event || c.constructor == window.MouseEvent) {
                    return "event"
                }
            }
            if (c instanceof window.Date) {
                return "date"
            }
            if (c instanceof window.RegExp) {
                return "regexp"
            }
            if (c === window) {
                return "window"
            }
            if (c === document) {
                return "document"
            }
            return typeof (c)
        },
        extend: function (j, h) {
            if (!(j instanceof window.Array)) {
                j = [j]
            }
            for (var g = 0, d = j.length; g < d; g++) {
                if (!$J.defined(j)) {
                    continue
                }
                for (var f in (h || {})) {
                    try {
                        j[g][f] = h[f]
                    } catch (c) { }
                }
            }
            return j[0]
        },
        implement: function (h, g) {
            if (!(h instanceof window.Array)) {
                h = [h]
            }
            for (var f = 0, c = h.length; f < c; f++) {
                if (!$J.defined(h[f])) {
                    continue
                }
                if (!h[f].prototype) {
                    continue
                }
                for (var d in (g || {})) {
                    if (!h[f].prototype[d]) {
                        h[f].prototype[d] = g[d]
                    }
                }
            }
            return h[0]
        },
        nativize: function (f, d) {
            if (!$J.defined(f)) {
                return f
            }
            for (var c in (d || {})) {
                if (!f[c]) {
                    f[c] = d[c]
                }
            }
            return f
        },
        $try: function () {
            for (var d = 0, c = arguments.length; d < c; d++) {
                try {
                    return arguments[d]()
                } catch (f) { }
            }
            return null
        },
        $A: function (f) {
            if (!$J.defined(f)) {
                return $mjs([])
            }
            if (f.toArray) {
                return $mjs(f.toArray())
            }
            if (f.item) {
                var d = f.length || 0,
					c = new Array(d);
                while (d--) {
                    c[d] = f[d]
                }
                return $mjs(c)
            }
            return $mjs(Array.prototype.slice.call(f))
        },
        now: function () {
            return new Date().getTime()
        },
        detach: function (h) {
            var f;
            switch ($J.j1(h)) {
                case "object":
                    f = {};
                    for (var g in h) {
                        f[g] = $J.detach(h[g])
                    }
                    break;
                case "array":
                    f = [];
                    for (var d = 0, c = h.length; d < c; d++) {
                        f[d] = $J.detach(h[d])
                    }
                    break;
                default:
                    return h
            }
            return $J.$(f)
        },
        $: function (d) {
            if (!$J.defined(d)) {
                return null
            }
            if (d.$J_EXTENDED) {
                return d
            }
            switch ($J.j1(d)) {
                case "array":
                    d = $J.nativize(d, $J.extend($J.Array, {
                        $J_EXTENDED: $J.$F
                    }));
                    d.j14 = d.forEach;
                    return d;
                    break;
                case "string":
                    var c = document.getElementById(d);
                    if ($J.defined(c)) {
                        return $J.$(c)
                    }
                    return null;
                    break;
                case "window":
                case "document":
                    $J.$uuid(d);
                    d = $J.extend(d, $J.Doc);
                    break;
                case "element":
                    $J.$uuid(d);
                    d = $J.extend(d, $J.Element);
                    break;
                case "event":
                    d = $J.extend(d, $J.Event);
                    break;
                case "textnode":
                    return d;
                    break;
                case "function":
                case "array":
                case "date":
                default:
                    break
            }
            return $J.extend(d, {
                $J_EXTENDED: $J.$F
            })
        },
        $new: function (c, f, d) {
            return $mjs($J.doc.createElement(c)).setProps(f || {}).j6(d || {})
        }
    };
    window.magicJS = window.$J = a;
    window.$mjs = a.$;
    $J.Array = {
        $J_TYPE: "array",
        indexOf: function (g, h) {
            var c = this.length;
            for (var d = this.length, f = (h < 0) ? Math.max(0, d + h) : h || 0; f < d; f++) {
                if (this[f] === g) {
                    return f
                }
            }
            return -1
        },
        contains: function (c, d) {
            return this.indexOf(c, d) != -1
        },
        forEach: function (c, g) {
            for (var f = 0, d = this.length; f < d; f++) {
                if (f in this) {
                    c.call(g, this[f], f, this)
                }
            }
        },
        filter: function (c, j) {
            var h = [];
            for (var g = 0, d = this.length; g < d; g++) {
                if (g in this) {
                    var f = this[g];
                    if (c.call(j, this[g], g, this)) {
                        h.push(f)
                    }
                }
            }
            return h
        },
        map: function (c, h) {
            var g = [];
            for (var f = 0, d = this.length; f < d; f++) {
                if (f in this) {
                    g[f] = c.call(h, this[f], f, this)
                }
            }
            return g
        }
    };
    $J.implement(String, {
        $J_TYPE: "string",
        j26: function () {
            return this.replace(/^\s+|\s+$/g, "")
        },
        trimLeft: function () {
            return this.replace(/^\s+/g, "")
        },
        trimRight: function () {
            return this.replace(/\s+$/g, "")
        },
        j25: function (c) {
            return (this.toString() === c.toString())
        },
        icompare: function (c) {
            return (this.toLowerCase().toString() === c.toLowerCase().toString())
        },
        j22: function () {
            return this.replace(/-\D/g, function (c) {
                return c.charAt(1).toUpperCase()
            })
        },
        dashize: function () {
            return this.replace(/[A-Z]/g, function (c) {
                return ("-" + c.charAt(0).toLowerCase())
            })
        },
        j17: function (c) {
            return parseInt(this, c || 10)
        },
        toFloat: function () {
            return parseFloat(this)
        },
        j18: function () {
            return !this.replace(/true/i, "").j26()
        },
        has: function (d, c) {
            c = c || "";
            return (c + this + c).indexOf(c + d + c) > -1
        }
    });
    a.implement(Function, {
        $J_TYPE: "function",
        j24: function () {
            var d = $J.$A(arguments),
				c = this,
				f = d.shift();
            return function () {
                return c.apply(f || null, d.concat($J.$A(arguments)))
            }
        },
        j16: function () {
            var d = $J.$A(arguments),
				c = this,
				f = d.shift();
            return function (g) {
                return c.apply(f || null, $mjs([g || window.event]).concat(d))
            }
        },
        j27: function () {
            var d = $J.$A(arguments),
				c = this,
				f = d.shift();
            return window.setTimeout(function () {
                return c.apply(c, d)
            }, f || 0)
        },
        j28: function () {
            var d = $J.$A(arguments),
				c = this;
            return function () {
                return c.j27.apply(c, d)
            }
        },
        interval: function () {
            var d = $J.$A(arguments),
				c = this,
				f = d.shift();
            return window.setInterval(function () {
                return c.apply(c, d)
            }, f || 0)
        }
    });
    var b = navigator.userAgent.toLowerCase();
    $J.j21 = {
        features: {
            xpath: !!(document.evaluate),
            air: !!(window.runtime),
            query: !!(document.querySelector)
        },
        engine: (window.opera) ? "presto" : !!(window.ActiveXObject) ? "trident" : (!navigator.taintEnabled) ? "webkit" : (undefined != document.getBoxObjectFor || null != window.mozInnerScreenY) ? "gecko" : "unknown",
        version: "",
        platform: b.match(/ip(?:ad|od|hone)/) ? "ios" : (b.match(/(?:webos|android)/) || navigator.platform.match(/mac|win|linux/i) || ["other"])[0].toLowerCase(),
        backCompat: document.compatMode && "backcompat" == document.compatMode.toLowerCase(),
        getDoc: function () {
            return (document.compatMode && "backcompat" == document.compatMode.toLowerCase()) ? document.body : document.documentElement
        },
        ready: false,
        onready: function () {
            if ($J.j21.ready) {
                return
            }
            $J.j21.ready = true;
            $J.body = $mjs(document.body);
            $mjs(document).raiseEvent("domready")
        }
    };
    $J.j21.touchScreen = $J.$A(["ios", "webos", "android"]).contains($J.j21.platform);
    (function () {
        function c() {
            return !!(arguments.callee.caller)
        }
        $J.j21.version = ("presto" == $J.j21.engine) ? !!(document.head) ? 270 : !!(window.applicationCache) ? 260 : !!(window.localStorage) ? 250 : ($J.j21.features.query) ? 220 : ((c()) ? 211 : ((document.getElementsByClassName) ? 210 : 200)) : ("trident" == $J.j21.engine) ? !!(window.msPerformance || window.performance) ? 900 : !!(window.XMLHttpRequest && window.postMessage) ? 6 : ((window.XMLHttpRequest) ? 5 : 4) : ("webkit" == $J.j21.engine) ? (($J.j21.features.xpath) ? (($J.j21.features.query) ? 525 : 420) : 419) : ("gecko" == $J.j21.engine) ? !!(document.head) ? 200 : !!document.readyState ? 192 : !!(window.localStorage) ? 191 : ((document.getElementsByClassName) ? 190 : 181) : "";
        $J.j21[$J.j21.engine] = $J.j21[$J.j21.engine + $J.j21.version] = true;
        if (window.chrome) {
            $J.j21.chrome = true
        }
    })();
    $J.Element = {
        j13: function (c) {
            return this.className.has(c, " ")
        },
        j2: function (c) {
            if (c && !this.j13(c)) {
                this.className += (this.className ? " " : "") + c
            }
            return this
        },
        j3: function (c) {
            c = c || ".*";
            this.className = this.className.replace(new RegExp("(^|\\s)" + c + "(?:\\s|$)"), "$1").j26();
            return this
        },
        j4: function (c) {
            return this.j13(c) ? this.j3(c) : this.j2(c)
        },
        j5: function (d) {
            d = (d == "float" && this.currentStyle) ? "styleFloat" : d.j22();
            var c = null;
            if (this.currentStyle) {
                c = this.currentStyle[d]
            } else {
                if (document.defaultView && document.defaultView.getComputedStyle) {
                    css = document.defaultView.getComputedStyle(this, null);
                    c = css ? css.getPropertyValue([d.dashize()]) : null
                }
            }
            if (!c) {
                c = this.style[d]
            }
            if ("opacity" == d) {
                return $J.defined(c) ? parseFloat(c) : 1
            }
            if (/^(border(Top|Bottom|Left|Right)Width)|((padding|margin)(Top|Bottom|Left|Right))$/.test(d)) {
                c = parseInt(c) ? c : "0px"
            }
            return ("auto" == c ? null : c)
        },
        j6Prop: function (d, c) {
            try {
                if ("opacity" == d) {
                    this.j23(c);
                    return this
                }
                if ("float" == d) {
                    this.style[("undefined" === typeof (this.style.styleFloat)) ? "cssFloat" : "styleFloat"] = c;
                    return this
                }
                this.style[d.j22()] = c + (("number" == $J.j1(c) && !$mjs(["zIndex", "zoom"]).contains(d.j22())) ? "px" : "")
            } catch (f) { }
            return this
        },
        j6: function (d) {
            for (var c in d) {
                this.j6Prop(c, d[c])
            }
            return this
        },
        j19s: function () {
            var c = {};
            $J.$A(arguments).j14(function (d) {
                c[d] = this.j5(d)
            }, this);
            return c
        },
        j23: function (h, d) {
            d = d || false;
            h = parseFloat(h);
            if (d) {
                if (h == 0) {
                    if ("hidden" != this.style.visibility) {
                        this.style.visibility = "hidden"
                    }
                } else {
                    if ("visible" != this.style.visibility) {
                        this.style.visibility = "visible"
                    }
                }
            }
            if ($J.j21.trident) {
                if (!this.currentStyle || !this.currentStyle.hasLayout) {
                    this.style.zoom = 1
                }
                try {
                    var g = this.filters.item("DXImageTransform.Microsoft.Alpha");
                    g.enabled = (1 != h);
                    g.opacity = h * 100
                } catch (c) {
                    this.style.filter += (1 == h) ? "" : "progid:DXImageTransform.Microsoft.Alpha(enabled=true,opacity=" + h * 100 + ")"
                }
            }
            this.style.opacity = h;
            return this
        },
        setProps: function (c) {
            for (var d in c) {
                this.setAttribute(d, "" + c[d])
            }
            return this
        },
        hide: function () {
            return this.j6({
                display: "none",
                visibility: "hidden"
            })
        },
        show: function () {
            return this.j6({
                display: "block",
                visibility: "visible"
            })
        },
        j7: function () {
            return {
                width: this.offsetWidth,
                height: this.offsetHeight
            }
        },
        j10: function () {
            return {
                top: this.scrollTop,
                left: this.scrollLeft
            }
        },
        j11: function () {
            var c = this,
				d = {
				    top: 0,
				    left: 0
				};
            do {
                d.left += c.scrollLeft || 0;
                d.top += c.scrollTop || 0;
                c = c.parentNode
            } while (c);
            return d
        },
        j8: function () {
            if ($J.defined(document.documentElement.getBoundingClientRect)) {
                var c = this.getBoundingClientRect(),
					f = $mjs(document).j10(),
					h = $J.j21.getDoc();
                return {
                    top: c.top + f.y - h.clientTop,
                    left: c.left + f.x - h.clientLeft
                }
            }
            var g = this,
				d = t = 0;
            do {
                d += g.offsetLeft || 0;
                t += g.offsetTop || 0;
                g = g.offsetParent
            } while (g && !(/^(?:body|html)$/i).test(g.tagName));
            return {
                top: t,
                left: d
            }
        },
        j9: function () {
            var d = this.j8();
            var c = this.j7();
            return {
                top: d.top,
                bottom: d.top + c.height,
                left: d.left,
                right: d.left + c.width
            }
        },
        update: function (f) {
            try {
                this.innerHTML = f
            } catch (d) {
                this.innerText = f
            }
            return this
        },
        remove: function () {
            return (this.parentNode) ? this.parentNode.removeChild(this) : this
        },
        kill: function () {
            $J.$A(this.childNodes).j14(function (c) {
                if (3 == c.nodeType || 8 == c.nodeType) {
                    return
                }
                $mjs(c).kill()
            });
            this.remove();
            this.je3();
            if (this.$J_UUID) {
                $J.storage[this.$J_UUID] = null;
                delete $J.storage[this.$J_UUID]
            }
            return null
        },
        append: function (g, d) {
            d = d || "bottom";
            var c = this.firstChild;
            ("top" == d && c) ? this.insertBefore(g, c) : this.appendChild(g);
            return this
        },
        j32: function (f, d) {
            var c = $mjs(f).append(this, d);
            return this
        },
        enclose: function (c) {
            this.append(c.parentNode.replaceChild(this, c));
            return this
        },
        hasChild: function (c) {
            if (!(c = $mjs(c))) {
                return false
            }
            return (this == c) ? false : (this.contains && !($J.j21.webkit419)) ? (this.contains(c)) : (this.compareDocumentPosition) ? !!(this.compareDocumentPosition(c) & 16) : $J.$A(this.byTag(c.tagName)).contains(c)
        }
    };
    $J.Element.j19 = $J.Element.j5;
    $J.Element.j20 = $J.Element.j6;
    if (!window.Element) {
        window.Element = $J.$F;
        if ($J.j21.engine.webkit) {
            window.document.createElement("iframe")
        }
        window.Element.prototype = ($J.j21.engine.webkit) ? window["[[DOMElement.prototype]]"] : {}
    }
    $J.implement(window.Element, {
        $J_TYPE: "element"
    });
    $J.Doc = {
        j7: function () {
            if ($J.j21.presto925 || $J.j21.webkit419) {
                return {
                    width: self.innerWidth,
                    height: self.innerHeight
                }
            }
            return {
                width: $J.j21.getDoc().clientWidth,
                height: $J.j21.getDoc().clientHeight
            }
        },
        j10: function () {
            return {
                x: self.pageXOffset || $J.j21.getDoc().scrollLeft,
                y: self.pageYOffset || $J.j21.getDoc().scrollTop
            }
        },
        j12: function () {
            var c = this.j7();
            return {
                width: Math.max($J.j21.getDoc().scrollWidth, c.width),
                height: Math.max($J.j21.getDoc().scrollHeight, c.height)
            }
        }
    };
    $J.extend(document, {
        $J_TYPE: "document"
    });
    $J.extend(window, {
        $J_TYPE: "window"
    });
    $J.extend([$J.Element, $J.Doc], {
        j29: function (g, d) {
            var c = $J.getStorage(this.$J_UUID),
				f = c[g];
            if (undefined != d && undefined == f) {
                f = c[g] = d
            }
            return ($J.defined(f) ? f : null)
        },
        j30: function (f, d) {
            var c = $J.getStorage(this.$J_UUID);
            c[f] = d;
            return this
        },
        j31: function (d) {
            var c = $J.getStorage(this.$J_UUID);
            delete c[d];
            return this
        }
    });
    if (!(window.HTMLElement && window.HTMLElement.prototype && window.HTMLElement.prototype.getElementsByClassName)) {
        $J.extend([$J.Element, $J.Doc], {
            getElementsByClassName: function (c) {
                return $J.$A(this.getElementsByTagName("*")).filter(function (f) {
                    try {
                        return (1 == f.nodeType && f.className.has(c, " "))
                    } catch (d) { }
                })
            }
        })
    }
    $J.extend([$J.Element, $J.Doc], {
        byClass: function () {
            return this.getElementsByClassName(arguments[0])
        },
        byTag: function () {
            return this.getElementsByTagName(arguments[0])
        }
    });
    $J.Event = {
        $J_TYPE: "event",
        stop: function () {
            if (this.stopPropagation) {
                this.stopPropagation()
            } else {
                this.cancelBubble = true
            }
            if (this.preventDefault) {
                this.preventDefault()
            } else {
                this.returnValue = false
            }
            return this
        },
        j15: function () {
            var d, c;
            d = ((/touch/i).test(this.type)) ? this.targetTouches[0] : this;
            return (!$J.defined(d)) ? {
                x: 0,
                y: 0
            } : {
                x: d.pageX || d.clientX + $J.j21.getDoc().scrollLeft,
                y: d.pageY || d.clientY + $J.j21.getDoc().scrollTop
            }
        },
        getTarget: function () {
            var c = this.target || this.srcElement;
            while (c && 3 == c.nodeType) {
                c = c.parentNode
            }
            return c
        },
        getRelated: function () {
            var d = null;
            switch (this.type) {
                case "mouseover":
                    d = this.relatedTarget || this.fromElement;
                    break;
                case "mouseout":
                    d = this.relatedTarget || this.toElement;
                    break;
                default:
                    return d
            }
            try {
                while (d && 3 == d.nodeType) {
                    d = d.parentNode
                }
            } catch (c) {
                d = null
            }
            return d
        },
        getButton: function () {
            if (!this.which && this.button !== undefined) {
                return (this.button & 1 ? 1 : (this.button & 2 ? 3 : (this.button & 4 ? 2 : 0)))
            }
            return this.which
        }
    };
    $J._event_add_ = "addEventListener";
    $J._event_del_ = "removeEventListener";
    $J._event_prefix_ = "";
    if (!document.addEventListener) {
        $J._event_add_ = "attachEvent";
        $J._event_del_ = "detachEvent";
        $J._event_prefix_ = "on"
    }
    $J.extend([$J.Element, $J.Doc], {
        je1: function (g, f) {
            var i = ("domready" == g) ? false : true,
				d = this.j29("events", {});
            d[g] = d[g] || {};
            if (d[g].hasOwnProperty(f.$J_EUID)) {
                return this
            }
            if (!f.$J_EUID) {
                f.$J_EUID = Math.floor(Math.random() * $J.now())
            }
            var c = this,
				h = function (j) {
				    return f.call(c)
				};
            if ("domready" == g) {
                if ($J.j21.ready) {
                    f.call(this);
                    return this
                }
            }
            if (i) {
                h = function (j) {
                    j = $J.extend(j || window.e, {
                        $J_TYPE: "event"
                    });
                    return f.call(c, $mjs(j))
                };
                this[$J._event_add_]($J._event_prefix_ + g, h, false)
            }
            d[g][f.$J_EUID] = h;
            return this
        },
        je2: function (g) {
            var i = ("domready" == g) ? false : true,
				d = this.j29("events");
            if (!d || !d[g]) {
                return this
            }
            var h = d[g],
				f = arguments[1] || null;
            if (g && !f) {
                for (var c in h) {
                    if (!h.hasOwnProperty(c)) {
                        continue
                    }
                    this.je2(g, c)
                }
                return this
            }
            f = ("function" == $J.j1(f)) ? f.$J_EUID : f;
            if (!h.hasOwnProperty(f)) {
                return this
            }
            if ("domready" == g) {
                i = false
            }
            if (i) {
                this[$J._event_del_]($J._event_prefix_ + g, h[f], false)
            }
            delete h[f];
            return this
        },
        raiseEvent: function (g, d) {
            var l = ("domready" == g) ? false : true,
				j = this,
				i;
            if (!l) {
                var f = this.j29("events");
                if (!f || !f[g]) {
                    return this
                }
                var h = f[g];
                for (var c in h) {
                    if (!h.hasOwnProperty(c)) {
                        continue
                    }
                    h[c].call(this)
                }
                return this
            }
            if (j === document && document.createEvent && !el.dispatchEvent) {
                j = document.documentElement
            }
            if (document.createEvent) {
                i = document.createEvent(g);
                i.initEvent(d, true, true)
            } else {
                i = document.createEventObject();
                i.eventType = g
            }
            if (document.createEvent) {
                j.dispatchEvent(i)
            } else {
                j.fireEvent("on" + d, i)
            }
            return i
        },
        je3: function () {
            var c = this.j29("events");
            if (!c) {
                return this
            }
            for (var d in c) {
                this.je2(d)
            }
            this.j31("events");
            return this
        }
    });
    (function () {
        if ($J.j21.webkit && $J.j21.version < 420) {
            (function () {
                ($mjs(["loaded", "complete"]).contains(document.readyState)) ? $J.j21.onready() : arguments.callee.j27(50)
            })()
        } else {
            if ($J.j21.trident && window == top) {
                (function () {
                    ($J.$try(function () {
                        $J.j21.getDoc().doScroll("left");
                        return true
                    })) ? $J.j21.onready() : arguments.callee.j27(50)
                })()
            } else {
                $mjs(document).je1("DOMContentLoaded", $J.j21.onready);
                $mjs(window).je1("load", $J.j21.onready)
            }
        }
    })();
    $J.Class = function () {
        var h = null,
			d = $J.$A(arguments);
        if ("class" == $J.j1(d[0])) {
            h = d.shift()
        }
        var c = function () {
            for (var l in this) {
                this[l] = $J.detach(this[l])
            }
            if (this.constructor.$parent) {
                this.$parent = {};
                var o = this.constructor.$parent;
                for (var n in o) {
                    var j = o[n];
                    switch ($J.j1(j)) {
                        case "function":
                            this.$parent[n] = $J.Class.wrap(this, j);
                            break;
                        case "object":
                            this.$parent[n] = $J.detach(j);
                            break;
                        case "array":
                            this.$parent[n] = $J.detach(j);
                            break
                    }
                }
            }
            var i = (this.init) ? this.init.apply(this, arguments) : this;
            delete this.caller;
            return i
        };
        if (!c.prototype.init) {
            c.prototype.init = $J.$F
        }
        if (h) {
            var g = function () { };
            g.prototype = h.prototype;
            c.prototype = new g;
            c.$parent = {};
            for (var f in h.prototype) {
                c.$parent[f] = h.prototype[f]
            }
        } else {
            c.$parent = null
        }
        c.constructor = $J.Class;
        c.prototype.constructor = c;
        $J.extend(c.prototype, d[0]);
        $J.extend(c, {
            $J_TYPE: "class"
        });
        return c
    };
    a.Class.wrap = function (c, d) {
        return function () {
            var g = this.caller;
            var f = d.apply(c, arguments);
            return f
        }
    };
    $J.FX = new $J.Class({
        options: {
            fps: 50,
            duration: 500,
            transition: function (c) {
                return -(Math.cos(Math.PI * c) - 1) / 2
            },
            onStart: $J.$F,
            onComplete: $J.$F,
            onBeforeRender: $J.$F
        },
        styles: null,
        init: function (d, c) {
            this.el = $mjs(d);
            this.options = $J.extend(this.options, c);
            this.timer = false
        },
        start: function (c) {
            this.styles = c;
            this.state = 0;
            this.curFrame = 0;
            this.startTime = $J.now();
            this.finishTime = this.startTime + this.options.duration;
            this.timer = this.loop.j24(this).interval(Math.round(1000 / this.options.fps));
            this.options.onStart.call();
            return this
        },
        stop: function (c) {
            c = $J.defined(c) ? c : false;
            if (this.timer) {
                clearInterval(this.timer);
                this.timer = false
            }
            if (c) {
                this.render(1);
                this.options.onComplete.j27(10)
            }
            return this
        },
        calc: function (f, d, c) {
            return (d - f) * c + f
        },
        loop: function () {
            var d = $J.now();
            if (d >= this.finishTime) {
                if (this.timer) {
                    clearInterval(this.timer);
                    this.timer = false
                }
                this.render(1);
                this.options.onComplete.j27(10);
                return this
            }
            var c = this.options.transition((d - this.startTime) / this.options.duration);
            this.render(c)
        },
        render: function (c) {
            var d = {};
            for (var f in this.styles) {
                if ("opacity" === f) {
                    d[f] = Math.round(this.calc(this.styles[f][0], this.styles[f][1], c) * 100) / 100
                } else {
                    d[f] = Math.round(this.calc(this.styles[f][0], this.styles[f][1], c))
                }
            }
            this.options.onBeforeRender(d);
            this.set(d)
        },
        set: function (c) {
            return this.el.j6(c)
        }
    });
    $J.FX.Transition = {
        linear: function (c) {
            return c
        },
        sineIn: function (c) {
            return -(Math.cos(Math.PI * c) - 1) / 2
        },
        sineOut: function (c) {
            return 1 - $J.FX.Transition.sineIn(1 - c)
        },
        expoIn: function (c) {
            return Math.pow(2, 8 * (c - 1))
        },
        expoOut: function (c) {
            return 1 - $J.FX.Transition.expoIn(1 - c)
        },
        quadIn: function (c) {
            return Math.pow(c, 2)
        },
        quadOut: function (c) {
            return 1 - $J.FX.Transition.quadIn(1 - c)
        },
        cubicIn: function (c) {
            return Math.pow(c, 3)
        },
        cubicOut: function (c) {
            return 1 - $J.FX.Transition.cubicIn(1 - c)
        },
        backIn: function (d, c) {
            c = c || 1.618;
            return Math.pow(d, 2) * ((c + 1) * d - c)
        },
        backOut: function (d, c) {
            return 1 - $J.FX.Transition.backIn(1 - d)
        },
        elasticIn: function (d, c) {
            c = c || [];
            return Math.pow(2, 10 * --d) * Math.cos(20 * d * Math.PI * (c[0] || 1) / 3)
        },
        elasticOut: function (d, c) {
            return 1 - $J.FX.Transition.elasticIn(1 - d, c)
        },
        bounceIn: function (f) {
            for (var d = 0, c = 1; 1; d += c, c /= 2) {
                if (f >= (7 - 4 * d) / 11) {
                    return c * c - Math.pow((11 - 6 * d - 11 * f) / 4, 2)
                }
            }
        },
        bounceOut: function (c) {
            return 1 - $J.FX.Transition.bounceIn(1 - c)
        },
        none: function (c) {
            return 0
        }
    };
    $J.PFX = new $J.Class($J.FX, {
        init: function (c, d) {
            this.el_arr = c;
            this.options = $J.extend(this.options, d);
            this.timer = false
        },
        start: function (c) {
            this.$parent.start([]);
            this.styles_arr = c;
            return this
        },
        render: function (c) {
            for (var d = 0; d < this.el_arr.length; d++) {
                this.el = $mjs(this.el_arr[d]);
                this.styles = this.styles_arr[d];
                this.$parent.render(c)
            }
        }
    });
    $J.win = $mjs(window);
    $J.doc = $mjs(document)
})();
$J.$Ff = function () {
    return false
};
var MagicZoom = {
    version: "v3.1.29",
    options: {},
    defaults: {
        opacity: 50,
        opacityReverse: false,
        smoothingSpeed: 40,
        fps: 25,
        zoomWidth: 300,
        zoomHeight: 300,
        zoomDistance: 15,
        zoomPosition: "right",
        dragMode: false,
        moveOnClick: false,
        alwaysShowZoom: false,
        preservePosition: false,
        x: -1,
        y: -1,
        clickToActivate: false,
        clickToInitialize: false,
        smoothing: true,
        showTitle: "top",
        thumbChange: "click",
        zoomFade: false,
        zoomFadeInSpeed: 400,
        zoomFadeOutSpeed: 200,
        hotspots: "",
        preloadSelectorsSmall: true,
        preloadSelectorsBig: false,
        showLoading: true,
        loadingMsg: "Loading zoom..",
        loadingOpacity: 75,
        loadingPositionX: -1,
        loadingPositionY: -1,
        selectorsMouseoverDelay: 200,
        selectorsEffect: "dissolve",
        selectorsEffectSpeed: 400,
        fitZoomWindow: true,
        entireImage: false,
        enableRightClick: false,
        mouseoverDelay: 0
    },
    z40: $mjs([/^(opacity)(\s+)?:(\s+)?(\d+)$/i, /^(opacity-reverse)(\s+)?:(\s+)?(true|false)$/i, /^(smoothing\-speed)(\s+)?:(\s+)?(\d+)$/i, /^(fps)(\s+)?:(\s+)?(\d+)$/i, /^(zoom\-width)(\s+)?:(\s+)?(\d+)(px)?/i, /^(zoom\-height)(\s+)?:(\s+)?(\d+)(px)?/i, /^(zoom\-distance)(\s+)?:(\s+)?(\d+)(px)?/i, /^(zoom\-position)(\s+)?:(\s+)?(right|left|top|bottom|custom|inner)$/i, /^(drag\-mode)(\s+)?:(\s+)?(true|false)$/i, /^(move\-on\-click)(\s+)?:(\s+)?(true|false)$/i, /^(always\-show\-zoom)(\s+)?:(\s+)?(true|false)$/i, /^(preserve\-position)(\s+)?:(\s+)?(true|false)$/i, /^(x)(\s+)?:(\s+)?([\d.]+)(px)?/i, /^(y)(\s+)?:(\s+)?([\d.]+)(px)?/i, /^(click\-to\-activate)(\s+)?:(\s+)?(true|false)$/i, /^(click\-to\-initialize)(\s+)?:(\s+)?(true|false)$/i, /^(smoothing)(\s+)?:(\s+)?(true|false)$/i, /^(show\-title)(\s+)?:(\s+)?(true|false|top|bottom)$/i, /^(thumb\-change)(\s+)?:(\s+)?(click|mouseover)$/i, /^(zoom\-fade)(\s+)?:(\s+)?(true|false)$/i, /^(zoom\-fade\-in\-speed)(\s+)?:(\s+)?(\d+)$/i, /^(zoom\-fade\-out\-speed)(\s+)?:(\s+)?(\d+)$/i, /^(hotspots)(\s+)?:(\s+)?([a-z0-9_\-:\.]+)$/i, /^(preload\-selectors\-small)(\s+)?:(\s+)?(true|false)$/i, /^(preload\-selectors\-big)(\s+)?:(\s+)?(true|false)$/i, /^(show\-loading)(\s+)?:(\s+)?(true|false)$/i, /^(loading\-msg)(\s+)?:(\s+)?([^;]*)$/i, /^(loading\-opacity)(\s+)?:(\s+)?(\d+)$/i, /^(loading\-position\-x)(\s+)?:(\s+)?(\d+)(px)?/i, /^(loading\-position\-y)(\s+)?:(\s+)?(\d+)(px)?/i, /^(selectors\-mouseover\-delay)(\s+)?:(\s+)?(\d+)$/i, /^(selectors\-effect)(\s+)?:(\s+)?(dissolve|fade|false)$/i, /^(selectors\-effect\-speed)(\s+)?:(\s+)?(\d+)$/i, /^(fit\-zoom\-window)(\s+)?:(\s+)?(true|false)$/i, /^(entire\-image)(\s+)?:(\s+)?(true|false)$/i, /^(enable\-right\-click)(\s+)?:(\s+)?(true|false)$/i, /^(mouseover\-delay)(\s+)?:(\s+)?(\d+)$/i]),
    zooms: $mjs([]),
    z9: function (b) {
        for (var a = 0; a < MagicZoom.zooms.length; a++) {
            if (MagicZoom.zooms[a].z31) {
                MagicZoom.zooms[a].pause()
            } else {
                if (MagicZoom.zooms[a].options.clickToInitialize && MagicZoom.zooms[a].initMouseEvent) {
                    MagicZoom.zooms[a].initMouseEvent = b
                }
            }
        }
    },
    stop: function (a) {
        if (a.zoom) {
            a.zoom.stop();
            return true
        }
        return false
    },
    start: function (a) {
        if (!a.zoom) {
            var b = null;
            while (b = a.firstChild) {
                if (b.tagName == "IMG") {
                    break
                }
                a.removeChild(b)
            }
            while (b = a.lastChild) {
                if (b.tagName == "IMG") {
                    break
                }
                a.removeChild(b)
            }
            if (!a.firstChild || a.firstChild.tagName != "IMG") {
                throw "Invalid Magic Zoom"
            }
            MagicZoom.zooms.push(new MagicZoom.zoom(a))
        } else {
            a.zoom.start()
        }
    },
    update: function (d, a, c, b) {
        if (d.zoom) {
            d.zoom.update(a, c, b);
            return true
        }
        return false
    },
    refresh: function () {
        $J.$A(window.document.getElementsByTagName("A")).j14(function (a) {
            if (/MagicZoom/.test(a.className)) {
                if (MagicZoom.stop(a)) {
                    MagicZoom.start.j27(100, a)
                } else {
                    MagicZoom.start(a)
                }
            }
        }, this)
    },
    getXY: function (a) {
        if (a.zoom) {
            return {
                x: a.zoom.options.x,
                y: a.zoom.options.y
            }
        }
    },
    x7: function (c) {
        var b, a;
        b = "";
        for (a = 0; a < c.length; a++) {
            b += String.fromCharCode(14 ^ c.charCodeAt(a))
        }
        return b
    }
};
MagicZoom.z48 = function () {
    this.init.apply(this, arguments)
};
MagicZoom.z48.prototype = {
    init: function (a) {
        this.cb = null;
        this.z10 = null;
        this.onErrorHandler = this.onError.j16(this);
        this.z11 = null;
        this.width = 0;
        this.height = 0;
        this.border = {
            left: 0,
            right: 0,
            top: 0,
            bottom: 0
        };
        this.padding = {
            left: 0,
            right: 0,
            top: 0,
            bottom: 0
        };
        this.ready = false;
        this._tmpp = null;
        if ("string" == $J.j1(a)) {
            this._tmpp = $J.$new("div").j6({
                position: "absolute",
                top: "-10000px",
                width: "1px",
                height: "1px",
                overflow: "hidden"
            }).j32($J.body);
            this.self = $J.$new("img").j32(this._tmpp);
            this.z12();
            this.self.src = a
        } else {
            this.self = $mjs(a);
            this.z12();
            this.self.src = a.src
        }
    },
    _cleanup: function () {
        if (this._tmpp) {
            if (this.self.parentNode == this._tmpp) {
                this.self.remove().j6({
                    position: "static",
                    top: "auto"
                })
            }
            this._tmpp.kill();
            this._tmpp = null
        }
    },
    onError: function (a) {
        if (a) {
            $mjs(a).stop()
        }
        if (this.cb) {
            this._cleanup();
            this.cb.call(this, false)
        }
        this.unload()
    },
    z12: function (a) {
        this.z10 = null;
        if (a == true || !(this.self.src && (this.self.complete || this.self.readyState == "complete"))) {
            this.z10 = function (b) {
                if (b) {
                    $mjs(b).stop()
                }
                if (this.ready) {
                    return
                }
                this.ready = true;
                this.z14();
                if (this.cb) {
                    this._cleanup();
                    this.cb.call()
                }
            }.j16(this);
            this.self.je1("load", this.z10);
            $mjs(["abort", "error"]).j14(function (b) {
                this.self.je1(b, this.onErrorHandler)
            }, this)
        } else {
            this.ready = true
        }
    },
    update: function (c) {
        this.unload();
        var b = $J.$new("a", {
            href: c
        });
        if (this.self.src.has(b.href)) {
            this.ready = true
        } else {
            this.z12(true);
            this.self.src = c
        }
        b = null
    },
    z14: function () {
        this.width = this.self.width;
        this.height = this.self.height;
        if (this.width == 0 && this.height == 0 && $J.j21.webkit) {
            this.width = this.self.naturalWidth;
            this.height = this.self.naturalHeight
        }
        $mjs(["Left", "Right", "Top", "Bottom"]).j14(function (a) {
            this.padding[a.toLowerCase()] = this.self.j19("padding" + a).j17();
            this.border[a.toLowerCase()] = this.self.j19("border" + a + "Width").j17()
        }, this);
        if ($J.j21.presto || ($J.j21.trident && !$J.j21.backCompat)) {
            this.width -= this.padding.left + this.padding.right;
            this.height -= this.padding.top + this.padding.bottom
        }
    },
    getBox: function () {
        var a = null;
        a = this.self.j9();
        return {
            top: a.top + this.border.top,
            bottom: a.bottom - this.border.bottom,
            left: a.left + this.border.left,
            right: a.right - this.border.right
        }
    },
    z13: function () {
        if (this.z11) {
            this.z11.src = this.self.src;
            this.self = null;
            this.self = this.z11
        }
    },
    load: function (a) {
        if (this.ready) {
            if (!this.width) {
                this.z14()
            }
            this._cleanup();
            a.call()
        } else {
            this.cb = a
        }
    },
    unload: function () {
        if (this.z10) {
            this.self.je2("load", this.z10)
        }
        $mjs(["abort", "error"]).j14(function (a) {
            this.self.je2(a, this.onErrorHandler)
        }, this);
        this.z10 = null;
        this.cb = null;
        this.width = null;
        this.ready = false;
        this._new = false
    }
};
MagicZoom.zoom = function () {
    this.construct.apply(this, arguments)
};
MagicZoom.zoom.prototype = {
    construct: function (b, a) {
        this.z29 = -1;
        this.z31 = false;
        this.ddx = 0;
        this.ddy = 0;
        this.options = $J.detach(MagicZoom.defaults);
        if (b) {
            this.c = $mjs(b)
        }
        this.z38(this.c.rel);
        if (a) {
            this.z38(a)
        }
        this.z45 = null;
        this.mouseoverDelay = this.options.mouseoverDelay;
        if (b) {
            this.z15 = this.mousedown.j16(this);
            this.z16 = this.mouseup.j16(this);
            this.z17 = this.show.j24(this, false);
            this.z18 = this.z30.j24(this);
            this.z44Bind = this.z44.j16(this);
            this.c.je1("click", function (c) {
                if (!$J.j21.trident) {
                    this.blur()
                }
                $mjs(c).stop();
                return false
            });
            this.c.je1("mousedown", this.z15);
            this.c.je1("mouseup", this.z16);
            this.c.unselectable = "on";
            this.c.style.MozUserSelect = "none";
            this.c.onselectstart = $J.$Ff;
            if (!this.options.enableRightClick) {
                this.c.oncontextmenu = $J.$Ff
            }
            this.c.j6({
                position: "relative",
                display: "inline-block",
                textDecoration: "none",
                outline: "0",
                cursor: "hand"
            });
            if ($J.j21.gecko181 || $J.j21.presto) {
                this.c.j6({
                    display: "block"
                })
            }
            if (this.c.j5("textAlign") == "center") {
                this.c.j6({
                    margin: "auto auto"
                })
            }
            this.c.zoom = this
        } else {
            this.options.clickToInitialize = false
        }
        if (!this.options.clickToInitialize) {
            this.z19()
        }
    },
    z19: function () {
        var b, i, h, c, a;
        a = ["", "#ff0000", 10, "bold", "center", "100%"];
        if (!this.z8) {
            this.z8 = new MagicZoom.z48(this.c.firstChild);
            this.z1 = new MagicZoom.z48(this.c.href)
        } else {
            this.z1.update(this.c.href)
        }
        if (!this.z2) {
            this.z2 = {
                self: $mjs(document.createElement("DIV")).j2("MagicZoomBigImageCont").j6({
                    overflow: "hidden",
                    zIndex: 100,
                    top: "-100000px",
                    position: "absolute",
                    width: this.options.zoomWidth + "px",
                    height: this.options.zoomHeight + "px"
                }),
                zoom: this,
                z22: "0px"
            };
            this.z2.hide = function () {
                if (this.self.style.top != "-100000px" && !this.zoom.z5.z39) {
                    this.z22 = this.self.style.top;
                    this.self.style.top = "-100000px"
                }
            };
            this.z2.z23 = this.z2.hide.j24(this.z2);
            if ($J.j21.trident) {
                b = $mjs(document.createElement("IFRAME"));
                b.src = "javascript:''";
                b.j6({
                    left: "0px",
                    top: "0px",
                    position: "absolute"
                }).frameBorder = 0;
                this.z2.z24 = this.z2.self.appendChild(b)
            }
            this.z2.z42 = $mjs(document.createElement("DIV")).j2("MagicZoomHeader").j6({
                position: "relative",
                zIndex: 10,
                left: "0px",
                top: "0px",
                padding: "3px"
            }).hide();
            i = document.createElement("DIV");
            i.style.overflow = "hidden";
            i.appendChild(this.z1.self);
            this.z1.self.j6({
                padding: "0px",
                margin: "0px",
                border: "0px"
            });
            if (this.options.showTitle == "bottom") {
                this.z2.self.appendChild(i);
                this.z2.self.appendChild(this.z2.z42)
            } else {
                this.z2.self.appendChild(this.z2.z42);
                this.z2.self.appendChild(i)
            }
            if (this.options.zoomPosition == "custom" && $mjs(this.c.id + "-big")) {
                $mjs(this.c.id + "-big").appendChild(this.z2.self)
            } else {
                this.c.appendChild(this.z2.self)
            }
            if ("undefined" !== typeof (a)) {
                this.z2.g = $mjs(document.createElement("div")).j6({
                    color: a[1],
                    fontSize: a[2] + "px",
                    fontWeight: a[3],
                    fontFamily: "Tahoma",
                    position: "absolute",
                    width: a[5],
                    textAlign: a[4],
                    left: "0px"
                }).update(MagicZoom.x7(a[0]));
                this.z2.self.appendChild(this.z2.g)
            }
        }
        if (this.options.showTitle != "false" && this.options.showTitle != false && this.c.title != "" && this.options.zoomPosition != "inner") {
            c = this.z2.z42;
            while (h = c.firstChild) {
                c.removeChild(h)
            }
            this.z2.z42.appendChild(document.createTextNode(this.c.title));
            this.z2.z42.show()
        } else {
            this.z2.z42.hide()
        }
        this.c.z47 = this.c.title;
        this.c.title = "";
        this.z8.load(this.z20.j24(this))
    },
    z20: function (a) {
        if (!a && a !== undefined) {
            return
        }
        if (!this.options.opacityReverse) {
            this.z8.self.j23(1)
        }
        this.c.j6({
            width: this.z8.width + "px"
        });
        if (this.options.showLoading) {
            this.z25 = setTimeout(this.z18, 400)
        }
        if (this.options.hotspots != "" && $mjs(this.options.hotspots)) {
            this.z26()
        }
        if (this.c.id != "") {
            this.z27()
        }
    
        this.z1.load(this.z21.j24(this))
   
    },
    z21: function (c) {
  
        var b, a;
        if (!c && c !== undefined) {
            clearTimeout(this.z25);
            if (this.options.showLoading && this.z4) {
                this.z4.hide()
            }
            return
        }
        a = this.z8.self.j9();
        b = this.z2.z42.j7();
     
        if (this.options.fitZoomWindow || this.options.entireImage) {
            if ((this.z1.width < this.options.zoomWidth) || this.options.entireImage) {
                this.options.zoomWidth = this.z1.width;
                this.z2.self.j6({
                    width: this.options.zoomWidth
                });
                b = this.z2.z42.j7()
            }
            if ((this.z1.height < this.options.zoomHeight) || this.options.entireImage) {
                this.options.zoomHeight = this.z1.height + b.height
            }
        }
        if (this.options.showTitle == "bottom") {
            this.z1.self.parentNode.style.height = (this.options.zoomHeight - b.height) + "px"
        }
        this.z2.self.j6({
            height: this.options.zoomHeight + "px",
            width: this.options.zoomWidth + "px"
        }).j23(1);
        if ($J.j21.trident) {
            this.z2.z24.j6({
                width: this.options.zoomWidth + "px",
                height: this.options.zoomHeight + "px"
            })
        }
        switch (this.options.zoomPosition) {
            case "custom":
                break;
            case "right":
                this.z2.self.style.left = a.right - a.left + this.options.zoomDistance + "px";
                this.z2.z22 = "0px";
                break;
            case "left":
                this.z2.self.style.left = "-" + (this.options.zoomDistance + this.options.zoomWidth) + "px";
                this.z2.z22 = "0px";
                break;
            case "top":
                this.z2.self.style.left = "0px";
                this.z2.z22 = "-" + (this.options.zoomDistance + this.options.zoomHeight) + "px";
                break;
            case "bottom":
                this.z2.self.style.left = "0px";
                this.z2.z22 = a.bottom - a.top + this.options.zoomDistance + "px";
                break;
            case "inner":
                this.z2.self.j6({
                    left: "0px",
                    height: this.z8.height + "px",
                    width: this.z8.width + "px"
                });
                this.options.zoomWidth = this.z8.width;
                this.options.zoomHeight = this.z8.height;
                this.z2.z22 = "0px";
                break
        }
        this.zoomViewHeight = this.options.zoomHeight - b.height;
        if (this.z2.g) {
            this.z2.g.j6({
                top: this.options.showTitle == "bottom" ? "0px" : ((this.options.zoomHeight - 20) + "px")
            })
        }
        this.z1.self.j6({
            position: "relative",
            borderWidth: "0px",
            padding: "0px",
            left: "0px",
            top: "0px"
        });
        this.z28();
        if (this.options.alwaysShowZoom) {
            if (this.options.x == -1) {
                this.options.x = this.z8.width / 2
            }
            if (this.options.y == -1) {
                this.options.y = this.z8.height / 2
            }
            this.show()
        } else {
            if (this.options.zoomFade) {
                this.z3 = new $J.FX(this.z2.self)
            }
            this.z2.self.j6({
                top: "-100000px"
            })
        }
        if (this.options.showLoading && this.z4) {
            this.z4.hide()
        }
        this.c.je1("mousemove", this.z44Bind);
        this.c.je1("mouseout", this.z44Bind);
        if (!this.options.clickToActivate || this.options.clickToInitialize) {
            this.z31 = true
        }
        if (this.options.clickToInitialize && this.initMouseEvent) {
            this.z44(this.initMouseEvent)
        }
        this.z29 = $J.now()
    },
    z30: function () {
        if (this.z1.ready) {
            return
        }
        this.z4 = $mjs(document.createElement("DIV")).j2("MagicZoomLoading").j23(this.options.loadingOpacity / 100).j6({
            display: "block",
            overflow: "hidden",
            position: "absolute",
            visibility: "hidden",
            "z-index": 20,
            "max-width": (this.z8.width - 4)
        });
        this.z4.appendChild(document.createTextNode(this.options.loadingMsg));
        this.c.appendChild(this.z4);
        var a = this.z4.j7();
        this.z4.j6({
            left: (this.options.loadingPositionX == -1 ? ((this.z8.width - a.width) / 2) : (this.options.loadingPositionX)) + "px",
            top: (this.options.loadingPositionY == -1 ? ((this.z8.height - a.height) / 2) : (this.options.loadingPositionY)) + "px"
        });
        this.z4.show()
    },
    z27: function () {
        var d, c, a, f;
        this.selectors = $mjs([]);
        $J.$A(document.getElementsByTagName("A")).j14(function (b) {
            d = new RegExp("^" + this.c.id + "$");
            c = new RegExp("zoom\\-id(\\s+)?:(\\s+)?" + this.c.id + "($|;)");
            if (d.test(b.rel) || c.test(b.rel)) {
                if (!$mjs(b).z37) {
                    b.z37 = function (g) {
                        if (!$J.j21.trident) {
                            this.blur()
                        }
                        $mjs(g).stop();
                        return false
                    };
                    b.je1("click", b.z37)
                }
                if (!b.z35) {
                    b.z35 = function (h, g) {
                        if (h.type == "mouseout") {
                            if (this.z36) {
                                clearTimeout(this.z36)
                            }
                            this.z36 = false;
                            return
                        }
                        if (g.title != "") {
                            this.c.title = g.title
                        }
                        if (h.type == "mouseover") {
                            this.z36 = setTimeout(this.update.j24(this, g.href, g.rev, g.rel), this.options.selectorsMouseoverDelay)
                        } else {
                            this.update(g.href, g.rev, g.rel)
                        }
                    }.j16(this, b);
                    b.je1(this.options.thumbChange, b.z35);
                    if (this.options.thumbChange == "mouseover") {
                        b.je1("mouseout", b.z35)
                    }
                }
                b.j6({
                    outline: "0"
                });
                if (this.options.preloadSelectorsSmall) {
                    f = new Image();
                    f.src = b.rev
                }
                if (this.options.preloadSelectorsBig) {
                    a = new Image();
                    a.src = b.href
                }
                this.selectors.push(b)
            }
        }, this)
    },
    stop: function (a) {
        try {
            this.pause();
            this.c.je2("mousemove", this.z44Bind);
            this.c.je2("mouseout", this.z44Bind);
            if (undefined === a) {
                this.z5.self.hide()
            }
            if (this.z3) {
                this.z3.stop()
            }
            this.z7 = null;
            this.z31 = false;
            if (this.selectors !== undefined) {
                this.selectors.j14(function (c) {
                    if (undefined === a) {
                        c.je2(this.options.thumbChange, c.z35);
                        if (this.options.thumbChange == "mouseover") {
                            c.je2("mouseout", c.z35)
                        }
                        c.z35 = null;
                        c.je2("click", c.z37);
                        c.z37 = null
                    }
                }, this)
            }
            if (this.options.hotspots != "" && $mjs(this.options.hotspots)) {
                $mjs(this.options.hotspots).hide();
                $mjs(this.options.hotspots).z32.insertBefore($mjs(this.options.hotspots), $mjs(this.options.hotspots).z33);
                if (this.c.z34) {
                    this.c.removeChild(this.c.z34)
                }
            }
            this.z1.unload();
            if (this.options.opacityReverse) {
                this.c.j3("MagicZoomPup");
                this.z8.self.j23(1)
            }
            this.z3 = null;
            if (this.z4) {
                this.c.removeChild(this.z4)
            }
            if (undefined === a) {
                this.z8.unload();
                this.c.removeChild(this.z5.self);
                this.z2.self.parentNode.removeChild(this.z2.self);
                this.z5 = null;
                this.z2 = null;
                this.z1 = null;
                this.z8 = null
            }
            if (this.z25) {
                clearTimeout(this.z25);
                this.z25 = null
            }
            this.z45 = null;
            this.c.z34 = null;
            this.z4 = null;
            if (this.c.title == "") {
                this.c.title = this.c.z47
            }
            this.z29 = -1
        } catch (b) { }
    },
    start: function (a) {
        if (this.z29 != -1) {
            return
        }
        this.construct(false, a)
    },
    update: function (c, d, i) {
        var j, f, k, b, g, a, h;
        h = null;
        if ($J.now() - this.z29 < 300 || this.z29 == -1 || this.ufx) {
            j = 300 - $J.now() + this.z29;
            if (this.z29 == -1) {
                j = 300
            }
            this.z36 = setTimeout(this.update.j24(this, c, d, i), j);
            return
        }
        f = function (l) {
            if (undefined != c) {
                this.c.href = c
            }
            if (undefined === i) {
                i = ""
            }
            if (this.options.preservePosition) {
                i = "x: " + this.options.x + "; y: " + this.options.y + "; " + i
            }
            if (undefined != d) {
                this.z8.update(d);
                if (l !== undefined) {
                    this.z8.load(l)
                }
            }
        };
        b = this.z8.width;
        g = this.z8.height;
        this.stop(true);
        if (this.options.selectorsEffect != "false") {
            this.ufx = true;
            a = new MagicZoom.z48(d);
            this.c.appendChild(a.self);
            a.self.j6({
                opacity: 0,
                position: "absolute",
                left: "0px",
                top: "0px"
            });
            k = function () {
                var l, n, m;
                l = {};
                m = {};
                n = {
                    opacity: [0, 1]
                };
                if (b != a.width || g != a.height) {
                    m.width = n.width = l.width = [b, a.width];
                    m.height = n.height = l.height = [g, a.height]
                }
                if (this.options.selectorsEffect == "fade") {
                    l.opacity = [1, 0]
                }
                new $J.PFX([this.c, a.self, this.c.firstChild], {
                    duration: this.options.selectorsEffectSpeed,
                    onComplete: function () {
                        f.call(this, function () {
                            a.unload();
                            this.c.removeChild(a.self);
                            a = null;
                            if (l.opacity) {
                                $mjs(this.c.firstChild).j6({
                                    opacity: 1
                                })
                            }
                            this.ufx = false;
                            this.start(i);
                            if (h) {
                                h.j27(10)
                            }
                        }.j24(this))
                    }.j24(this)
                }).start([m, n, l])
            };
            a.load(k.j24(this))
        } else {
            f.call(this, function () {
                this.c.j6({
                    width: this.z8.width + "px",
                    height: this.z8.height + "px"
                });
                this.start(i);
                if (h) {
                    h.j27(10)
                }
            }.j24(this))
        }
    },
    z38: function (b) {
        var a, f, d, c;
        a = null;
        f = [];
        d = $mjs(b.split(";"));
        for (c in MagicZoom.options) {
            f[c.j22()] = MagicZoom.options[c]
        }
        d.j14(function (g) {
            MagicZoom.z40.j14(function (h) {
                a = h.exec(g.j26());
                if (a) {
                    switch ($J.j1(MagicZoom.defaults[a[1].j22()])) {
                        case "boolean":
                            f[a[1].j22()] = a[4] === "true";
                            break;
                        case "number":
                            f[a[1].j22()] = parseFloat(a[4]);
                            break;
                        default:
                            f[a[1].j22()] = a[4]
                    }
                }
            }, this)
        }, this);
        if (f.dragMode && undefined === f.alwaysShowZoom) {
            f.alwaysShowZoom = true
        }
        this.options = $J.extend(this.options, f)
    },
    z28: function () {
        var a;
        if (!this.z5) {
            this.z5 = {
                self: $mjs(document.createElement("DIV")).j2("MagicZoomPup").j6({
                    zIndex: 10,
                    position: "absolute",
                    overflow: "hidden"
                }).hide(),
                width: 20,
                height: 20
            };
            this.c.appendChild(this.z5.self)
        }
        if (this.options.entireImage) {
            this.z5.self.j6({
                "border-width": "0px"
            })
        }
        this.z5.z39 = false;
        this.z5.height = this.zoomViewHeight / (this.z1.height / this.z8.height);

        this.z5.width = this.options.zoomWidth / (this.z1.width / this.z8.width);
        if (this.z5.width > this.z8.width) {
            this.z5.width = this.z8.width
        }
        if (this.z5.height > this.z8.height) {
            this.z5.height = this.z8.height
        }
        this.z5.width = Math.round(this.z5.width);
        this.z5.height = Math.round(this.z5.height);
        this.z5.borderWidth = this.z5.self.j19("borderLeftWidth").j17();
        this.z5.self.j6({
            width: (this.z5.width - 2 * ($J.j21.backCompat ? 0 : this.z5.borderWidth)) + "px",
            height: (this.z5.height - 2 * ($J.j21.backCompat ? 0 : this.z5.borderWidth)) + "px"
        });
        if (!this.options.opacityReverse && !this.options.enableRightClick) {
            this.z5.self.j23(parseFloat(this.options.opacity / 100));
            if (this.z5.z43) {
                this.z5.self.removeChild(this.z5.z43);
                this.z5.z43 = null
            }
        } else {
            if (this.z5.z43) {
                this.z5.z43.src = this.z8.self.src
            } else {
                a = this.z8.self.cloneNode(false);
                a.unselectable = "on";
                this.z5.z43 = $mjs(this.z5.self.appendChild(a)).j6({
                    position: "absolute",
                    zIndex: 5
                })
            }
            if (this.options.opacityReverse) {
                this.z5.self.j23(1)
            } else {
                if (this.options.enableRightClick) {
                    this.z5.z43.j23(0.009)
                }
                this.z5.self.j23(parseFloat(this.options.opacity / 100))
            }
        }
    },
    z44: function (b, a) {
        if (!this.z31 || b === undefined) {
            return false
        }
        $mjs(b).stop();
        if (a === undefined) {
            a = $mjs(b).j15()
        }
        if (this.z7 === null || this.z7 === undefined) {
            this.z7 = this.z8.getBox()
        }
        if (a.x > this.z7.right || a.x < this.z7.left || a.y > this.z7.bottom || a.y < this.z7.top) {
            this.pause();
            return false
        }
        if (b.type == "mouseout") {
            return false
        }
        if (this.options.dragMode && !this.z46) {
            return false
        }
        if (!this.options.moveOnClick) {
            a.x -= this.ddx;
            a.y -= this.ddy
        }
        if ((a.x + this.z5.width / 2) >= this.z7.right) {
            a.x = this.z7.right - this.z5.width / 2
        }
        if ((a.x - this.z5.width / 2) <= this.z7.left) {
            a.x = this.z7.left + this.z5.width / 2
        }
        if ((a.y + this.z5.height / 2) >= this.z7.bottom) {
            a.y = this.z7.bottom - this.z5.height / 2
        }
        if ((a.y - this.z5.height / 2) <= this.z7.top) {
            a.y = this.z7.top + this.z5.height / 2
        }
        this.options.x = a.x - this.z7.left;
        this.options.y = a.y - this.z7.top;
        if (this.z45 === null) {
            if ($J.j21.trident) {
                this.c.style.zIndex = 1
            }
            this.z45 = setTimeout(this.z17, 10 + this.mouseoverDelay);
            this.mouseoverDelay = 0
        }
        return true
    },
    show: function () {
        
        var f, i, d, c, h, g, b, a;
        f = this.z5.width / 2;
        i = this.z5.height / 2;
   
        this.z5.self.style.left = this.options.x - f + this.z8.border.left + "px";

        this.z5.self.style.top = this.options.y - i + this.z8.border.top + "px";

    
        if (this.options.opacityReverse) {
            this.z5.z43.style.left = "-" + (parseFloat(this.z5.self.style.left) + this.z5.borderWidth) + "px";
            this.z5.z43.style.top = "-" + (parseFloat(this.z5.self.style.top) + this.z5.borderWidth) + "px"
        }
        d = (this.options.x - f) * (this.z1.width / this.z8.width);
        c = (this.options.y - i) * (this.z1.height / this.z8.height);
        if (this.z1.width - d < this.options.zoomWidth) {
            d = this.z1.width - this.options.zoomWidth;
            if (d < 0) {
                d = 0
            }
        }
        if (this.z1.height - c < this.zoomViewHeight) {
            c = this.z1.height - this.zoomViewHeight;
            if (c < 0) {
                c = 0
            }
        }
        if (document.documentElement.dir == "rtl") {
            d = (this.options.x + this.z5.width / 2 - this.z8.width) * (this.z1.width / this.z8.width)
        }
        d = Math.round(d);
        c = Math.round(c);
        if (this.options.smoothing === false || !this.z5.z39) {
            this.z1.self.style.left = (-d) + "px";
            this.z1.self.style.top = (-c) + "px"
        } else {
            h = parseInt(this.z1.self.style.left);
            g = parseInt(this.z1.self.style.top);
            b = (-d - h);
            a = (-c - g);
            if (!b && !a) {
                this.z45 = null;
                return
            }
            b *= this.options.smoothingSpeed / 100;
            if (b < 1 && b > 0) {
                b = 1
            } else {
                if (b > -1 && b < 0) {
                    b = -1
                }
            }
            h += b;
            a *= this.options.smoothingSpeed / 100;
            if (a < 1 && a > 0) {
                a = 1
            } else {
                if (a > -1 && a < 0) {
                    a = -1
                }
            }
            g += a;
            this.z1.self.style.left = h + "px";
            this.z1.self.style.top = g + "px"
        }
        if (!this.z5.z39) {
            if (this.z3) {
                this.z3.stop();
                this.z3.options.onComplete = $J.$F;
                this.z3.options.duration = this.options.zoomFadeInSpeed;
                this.z2.self.j23(0);
                this.z3.start({
                    opacity: [0, 1]
                })
            }
            if (this.options.zoomPosition != "inner") {
                this.z5.self.show()
            }
            this.z2.self.style.top = this.z2.z22;
            if (this.options.opacityReverse) {
                this.c.j2("MagicZoomPup").j20({
                    "border-width": "0px"
                });
                this.z8.self.j23(parseFloat((100 - this.options.opacity) / 100))
            }
            this.z5.z39 = true
        }
        if (this.z45) {
            this.z45 = setTimeout(this.z17, 1000 / this.options.fps)
        }
    },
    pause: function () {
        if (this.z45) {
            clearTimeout(this.z45);
            this.z45 = null
        }
        if (!this.options.alwaysShowZoom && this.z5.z39) {
            this.z5.z39 = false;
            this.z5.self.hide();
            if (this.z3) {
                this.z3.stop();
                this.z3.options.onComplete = this.z2.z23;
                this.z3.options.duration = this.options.zoomFadeOutSpeed;
                var a = this.z2.self.j19("opacity");
                this.z3.start({
                    opacity: [a, 0]
                })
            } else {
                this.z2.hide()
            }
            if (this.options.opacityReverse) {
                this.c.j3("MagicZoomPup");
                this.z8.self.j23(1)
            }
        }
        this.z7 = null;
        if (this.options.clickToActivate) {
            this.z31 = false
        }
        if (this.options.dragMode) {
            this.z46 = false
        }
        if ($J.j21.trident) {
            this.c.style.zIndex = 0
        }
        this.mouseoverDelay = this.options.mouseoverDelay
    },
    mousedown: function (b) {
        $mjs(b).stop();
        if (this.options.clickToInitialize && !this.z8) {
            this.initMouseEvent = b;
            this.z19();
            return
        }
        if (this.z1 && this.options.clickToActivate && !this.z31) {
            this.z31 = true;
            this.z44(b)
        }
        if (this.options.dragMode) {
            this.z46 = true;
            if (!this.options.moveOnClick) {
                var a = b.j15();
                this.ddx = a.x - this.options.x - this.z7.left;
                this.ddy = a.y - this.options.y - this.z7.top;
                if (Math.abs(this.ddx) > this.z5.width / 2 || Math.abs(this.ddy) > this.z5.height / 2) {
                    this.z46 = false;
                    return
                }
            }
        }
        if (this.options.moveOnClick) {
            this.z44(b)
        }
    },
    mouseup: function (a) {
        $mjs(a).stop();
        if (this.options.dragMode) {
            this.z46 = false
        }
    }
};
if ($J.j21.trident) {
    try {
        document.execCommand("BackgroundImageCache", false, true)
    } catch (e) { }
}
$mjs(document).je1("domready", MagicZoom.refresh);
$mjs(document).je1("mousemove", MagicZoom.z9);