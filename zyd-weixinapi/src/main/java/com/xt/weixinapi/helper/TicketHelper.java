package com.xt.weixinapi.helper;

import java.util.Map;

import net.sf.json.JSONObject;

import com.xt.weixinapi.exception.WeiXinException;
import com.xt.weixinapi.holder.TicketHolder;
import com.xt.weixinapi.util.CertificateUtil;
import com.xt.weixinapi.util.CommonConstants;
import com.xt.weixinapi.util.JSONUtil;
import com.xt.weixinapi.util.MessageUtil;

public class TicketHelper
{

    /**
     * 创建二维码
     * 
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     */
    public static TicketHolder createTicket(String requestUrl, String outputStr)
            throws WeiXinException
    {
        String requestMethod = CommonConstants.REQUESTMETHOD_POST;
        String json = CertificateUtil.httpRequest(requestUrl, requestMethod,
                outputStr);
        JSONObject jsonObject = JSONObject.fromObject(json);

        Map<String, Object> map = MessageUtil.parseJSON(jsonObject);
        Integer errcode = (Integer) map.get("errcode");
        if (ReturnCodeHelper.isRtnCodeFailed(errcode))
        {
            throw new WeiXinException(ReturnCodeHelper.getRtnCodeMsg(errcode));
        }

        return (TicketHolder) JSONUtil.toBean(json, TicketHolder.class);

    }


    /**
     * 通过ticket换取二维码
     * 
     * @param requestUrl 访问的url地址
     * @param requestMethod 访问的
     * @param outputStr
     * @return
     * @throws WeiXinException
     */
    // ***************************************
    // ticket正确情况下，http 返回码是200，是一张图片，可以直接展示或者下载。
    public static JSONObject ticketQRCode(String requestUrl)
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

        return null;
    }
}
