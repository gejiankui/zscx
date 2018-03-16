package com.xt.weixinapi.helper;

import java.util.Map;

import net.sf.json.JSONObject;

import com.xt.weixinapi.exception.WeiXinException;
import com.xt.weixinapi.holder.AccessToken;
import com.xt.weixinapi.util.CertificateUtil;
import com.xt.weixinapi.util.CommonConstants;
import com.xt.weixinapi.util.JSONUtil;
import com.xt.weixinapi.util.MessageUtil;

public class AccessTokenHelper
{

    /**
     * 获取accessToken(获取用户授权的access_token同样使用此方法)
     * 
     * @param requestUrl 全局唯一票据
     * @return accessToken
     * @throws WeiXinException
     */
    public static AccessToken getAccessToken(String requestUrl)
            throws WeiXinException
    {
        String requestMethod = CommonConstants.REQUESTMETHOD_GET;
        String json = CertificateUtil.httpRequest(requestUrl, requestMethod,
                null);
        JSONObject jsonObject = JSONObject.fromObject(json);

        Map<String, Object> map = MessageUtil.parseJSON(jsonObject);
        Integer errcode = (Integer) map.get("errcode");
        if (ReturnCodeHelper.isRtnCodeFailed(errcode))
        {
            throw new WeiXinException(ReturnCodeHelper.getRtnCodeMsg(errcode));
        }

        return (AccessToken) JSONUtil.toBean(json, AccessToken.class);

    }

}
