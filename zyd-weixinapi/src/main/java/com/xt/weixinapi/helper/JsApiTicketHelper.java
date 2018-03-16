package com.xt.weixinapi.helper;

import java.util.Map;
import java.util.Random;

import net.sf.json.JSONObject;

import com.xt.weixinapi.exception.WeiXinException;
import com.xt.weixinapi.holder.JsApiTicket;
import com.xt.weixinapi.holder.JsSignPackge;
import com.xt.weixinapi.util.CertificateUtil;
import com.xt.weixinapi.util.CommonConstants;
import com.xt.weixinapi.util.JSONUtil;
import com.xt.weixinapi.util.MessageUtil;
import com.xt.weixinapi.util.SignUtil;

public class JsApiTicketHelper {

    /**
     * 获取jsapi_ticket 
     * 
     * @param requestUrl
     * @return
     */
    public static JsApiTicket getJsApiTicket(String requestUrl) throws WeiXinException 
    {
        String requestMethod = CommonConstants.REQUESTMETHOD_GET;
        String json = CertificateUtil.httpRequest(requestUrl, requestMethod, null);
        JSONObject jsonObject = JSONObject.fromObject(json);

        Map<String, Object> map = MessageUtil.parseJSON(jsonObject);
        Integer errcode = (Integer) map.get("errcode");
        if (ReturnCodeHelper.isRtnCodeFailed(errcode)) 
        {
            throw new WeiXinException(ReturnCodeHelper.getRtnCodeMsg(errcode));
        }

        return (JsApiTicket) JSONUtil.toBean(json, JsApiTicket.class);

    }

    public static JsSignPackge generateJsSignPackge(String appId, String jsApiTicket, String url){
        JsSignPackge jsp = new JsSignPackge();
        String timestamp = String.valueOf((int) (System.currentTimeMillis() / 1000));
        String noncestr = getRandomString(10);
        String sign = SignUtil.generateSignature(jsApiTicket, url, timestamp, noncestr);
        jsp.setAppId(appId);
        jsp.setNonceStr(noncestr);
        jsp.setSignature(sign);
        jsp.setTimestamp(timestamp);
        return jsp;
    }
    
    public static String getRandomString(int length){  
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
          
        for(int i = 0 ; i < length; ++i){  
            int number = random.nextInt(62);//[0,62)  
              
            sb.append(str.charAt(number));  
        }  
        return sb.toString();  
    }  
}
