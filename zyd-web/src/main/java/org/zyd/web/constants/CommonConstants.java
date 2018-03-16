package org.zyd.web.constants;

import java.math.BigDecimal;

public interface CommonConstants {

    String USER_SESSION_KEY = "USER_SESSION_KEY";

    String SESSION_KEY_SEARCH_PARAM = "search_param";

    String SESSION_KEY_SEARCH_SORT = "search_sort";

    int SEARCH_PAGE_SIZE = 20;

    BigDecimal FREE_LOGISTICS_CONDITION = BigDecimal.valueOf(300);


    /**
     * 微信access_token
     */
    String REDIS_KEY_ACCESS_TOKEN = "wx_access_token";

    /**
     * 微信jsapi_ticket
     */
    String REDIS_KEY_JSAPI_TICKET = "wx_jsapi_ticket";

    String UTF8 = "UTF-8";

    // 回复内容类型
    String REPLY_TYPE_TEXT = "1";// 文本
    String REPLY_TYPE_IMAGE = "2";// 图片

    // 事件来源类型
    String EVENT_ORIG_TYPE_MENU = "1"; // 点击菜单触发
    String EVENT_ORIG_TYPE_MSG = "2";// 发送内容触发
    String EVENT_ORIG_TYPE_SUBSCRIBE = "3";// 关注公众号触发
    String EVENT_ORIG_TYPE_RESUBSCRIBE = "4";// 重新关注公众号触发
    String TRIGGER_KEY_OTHER_KEY_WORD ="other";

    // CTRL_PARAM
    String CTRL_PARAM_CODE_WX_APP_ID = "WX_APP_ID";// 微信appid
    String CTRL_PARAM_CODE_WX_JSAPI_TICKET_REQ_URL = "WX_JSAPI_TICKET_REQ_URL";// 微信js api ticket请求URL
    String CTRL_PARAM_CODE_WX_ACCESS_TOKEN_REQ_URL = "WX_ACCESS_TOKEN_REQ_URL";// 微信AccessToken请求URL
    String CTRL_PARAM_CODE_WX_CREATE_MENU_REQ_URL = "WX_CREATE_MENU_REQ_URL";// 微信创建菜单请求URL
    String CTRL_PARAM_CODE_WX_DELETE_MENU_REQ_URL = "WX_DELETE_MENU_REQ_URL";// 微信删除菜单请求URL
    String CTRL_PARAM_CODE_WX_AUTH_ACCESS_REQ_URL = "WX_AUTH_ACCESS_REQ_URL";// 微信授权验证请求URL
    String CTRL_PARAM_CODE_WX_AUTH_ACCESS_CALLBACK_URL = "WX_AUTH_ACCESS_CALLBACK_URL";// 微信Auth2.0授权回调URL
    String CTRL_PARAM_CODE_WX_AUTH_ACCESS_TOKEN_REQ_URL = "WX_AUTH_ACCESS_TOKEN_REQ_URL";// 微信授权验证AccessToken请求URL
    String CTRL_PARAM_CODE_WX_ACCESS_TOKEN_KEY = "WX_ACCESS_TOKEN_KEY";// 微信服务器配置Token关键字

    String WX_AUTH_ACCESS_TOKEN_REQ_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxae561e9e234530e1&secret=3ca390906fbd696aa2a6a3fcd9a4abc6&grant_type=authorization_code&code=";
    String WX_AUTH_ACCESS_CALLBACK_URL = "http://m.zishachaxun.com/zyd-web/visit/baseAccess.do";
    String WX_AUTH_ACCESS_REQ_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxae561e9e234530e1&redirect_uri=";
    String WX_ACCESS_TOKEN_REQ_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxae561e9e234530e1&secret=3ca390906fbd696aa2a6a3fcd9a4abc6";
    String WX_JSAPI_TICKET_REQ_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";
    String WX_APP_ID = "wxae561e9e234530e1";

}
