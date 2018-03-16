//获取应用根路径
var myBaseUrl = "";
var Fun = {};
(function () {

    var pathName = location.pathname;
    var idx = pathName.indexOf("/", 1);
    myBaseUrl = idx == -1 ? pathName : pathName.substring(0, idx + 1);

    Fun.myBaseUrl = myBaseUrl;
    Fun.getReqParam = function () {
        var reqParams = {};
        var searchStrParams = location.search;
        searchStrParams = searchStrParams.substring(1);
        searchStrParams = decodeURI(searchStrParams);
        var searchParams = searchStrParams.split("&");
        for (var i = 0; i < searchParams.length; i++) {
            var eqIndex = searchParams[i].indexOf("=");
            var key = searchParams[i].substring(0, eqIndex);
            var value = searchParams[i].substring(eqIndex + 1, searchParams[i].length);
            if (key) {
                if (key.indexOf("[]") != -1) {
                    if (!reqParams[key.substring(0, key.length - 2)]) {
                        reqParams[key.substring(0, key.length - 2)] = new Array();
                    }
                    reqParams[key.substring(0, key.length - 2)].push(decodeURIComponent(value));
                }
                else {
                    reqParams[key] = value ? decodeURIComponent(value) : undefined;
                }

            }
        }
        return reqParams;
    };
    Fun.reqParams = Fun.getReqParam() || {};
})();
Fun.cookie = (function () {
    this.addCookie = function (k, v, e) {
        var arguSize = arguments.length;
        var kv = k + "=" + v;
        if (arguSize == 3) {
            var exp = new Date();
            exp.setTime(exp.getTime() + e * 24 * 60 * 60 * 1000);
            kv = kv + ";expires=" + exp.toGMTString();
        }
        document.cookie = kv;
    };
    this.removeCookie = function (k) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var v = getCookie(k);
        if (v != null) document.cookie = k + "=" + v + ";expires=" + exp.toGMTString();
    };
    this.getCookie = function (k) {
        var val = undefined;
        var arr = document.cookie.match(new RegExp("(^| )" + k + "=([^;]*)(;|$)"));
        if (arr) {
            val = arr[2];
        }
        return val;
    };
    this.getCookies = function () {
        var cookies = {};
        var cookiesArray = document.cookie.split("; ");
        for (var i = 0; i < cookiesArray.length; i++) {
            var cookie = cookiesArray[i].split("=");
            if (cookie[0]) {
                cookies[cookie[0]] = cookie[1];
            }
        }
        return cookies;
    };
    return this;
})();
Fun.loader = (function () {
    this.show = function (title) {
        $("#loader #title").html(title);
        $('#mask').show();
        $('#loader').css("visibility", "visible");
    };
    this.hide = function (title) {
        $('#mask').hide();
        $('#loader').css("visibility", "hidden");
    };
    return this;
})();
Fun.toast = (function () {
    this.pop = function (info) {
        if ($('#toast').text() == "") {
            var alt = '<div id="toast" style="display:none; position: fixed; top: 80%; width: 100%; text-align: center;">'
                + '<span id="toastContent" style="border-radius: 6px; padding: 8px 15px; background-color: #000; color: #fff; font-size: 0.9rem; -moz-opacity: 0.6; opacity: 0.6; filter: alpha(opacity=60);">'
                + '请稍后重试！</span></div>';
            $(document.body).append(alt);
        }
        $("#toastContent").text(info);
        $('#toast').fadeIn(1000);
        setTimeout("Fun.toast.dis()", 3000);
    };
    this.dis = function () {
        $('#toast').fadeOut(1000);
    };
    return this;
})();
Fun.user = function () {
    //清除cookie后 Fun.user 还会存在用户信息
    var userJson = Fun.cookie.getCookie("user");
    var userObject = undefined;
    if (userJson) {
        userObject = decodeURIComponent(userJson);
        // userObject = $.parseJSON(decodeUserJson);//转存字符串
    }
    return userObject;
};
Fun.checkLogin = function (url) {
    var result = true;
    var user = Fun.user();
    var currUrl = url || location.href;
    if (!user) {
        result = false;
        location.href = Fun.myBaseUrl + "visit/access.do?backUrl=" + encodeURIComponent(currUrl);
    }
    return result;
};
Fun.redirect = function (url, params) {
    var redirectUrl = Fun.myBaseUrl + url;
    //请求参数存在且不为空
    if (url && params && !$.isEmptyObject(params)) {
        redirectUrl += "?" + getParamStr(params, new Array());
    }
    location.href = redirectUrl;
}
function getParamStr(params, reqParams, useIndex) {
    for (var key in params) {
        if (!$.isPlainObject(params[key]) && !$.isArray(params[key])) {
            reqParams.push(key + "=" + params[key]);
        }
        else if ($.isPlainObject(params[key])) {
            getParamStr(params[key], reqParams);
        }
        else if ($.isArray(params[key])) {
            for (var i = 0; i < params[key].length; i++) {
                reqParams.push(key + "[]" + "=" + params[key][i]);
            }
        }
    }

    return reqParams && reqParams.join("&");
}
Fun.checkWx = function () {
    var useragent = navigator.userAgent;
    if (useragent.match(/MicroMessenger/i) != 'MicroMessenger') {
        // 这里警告框会阻塞当前页面继续加载
        alert('已禁止本次访问：您必须使用微信内置浏览器访问本页面！');
        // 以下代码是用javascript强行关闭当前页面
        var opened = window.open(Fun.myBaseUrl + 'pages/qr_code.html', '_self');
        opened.opener = null;
        opened.close();
    }
}

Fun.jsConfig = function jsConfig() {
    $.ajax({
        url: Fun.myBaseUrl + 'jsSign/signature.do?url=' + encodeURIComponent(location.href),
        type: 'post',
        dataType: 'json',
        success: function (resp) {
            wx.config({
                debug: false,
                appId: resp.appId,
                timestamp: resp.timestamp,
                nonceStr: resp.nonceStr,
                signature: resp.signature,
                jsApiList: [
                    'checkJsApi',
                    'onMenuShareTimeline',
                    'onMenuShareAppMessage'
                ]
            });
        },
    });
}
//检查登录
//Fun.checkWx();
// Fun.checkLogin();
// Fun.jsConfig();