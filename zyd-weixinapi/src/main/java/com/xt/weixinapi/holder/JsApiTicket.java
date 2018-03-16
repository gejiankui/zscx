package com.xt.weixinapi.holder;

/**
 * 微信JS SDK jsapi_ticket
 * 
 * @author Gejiankui
 */
public class JsApiTicket {
    // 错误码 成功为0
    private String errcode;
    // 错误信息 成功为ok
    private String errmsg;
    // jsapi_ticket
    private String ticket;
    // 凭证有效时间，单位：秒
    private int expires_in;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

}
