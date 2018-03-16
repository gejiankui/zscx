package com.xt.weixinapi.holder;

/**
 * 微信JS SDK jsapi_ticket
 * 
 * @author Gejiankui
 */
public class JsSignPackge {
    // 公众号的唯一标识
    private String appId;
    // 时间戳
    private String timestamp;
    // 随机字符串
    private String nonceStr;
    // 签名
    private String signature;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
