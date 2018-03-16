package com.xt.weixinapi.helper;

import java.util.Map;

import net.sf.json.JSONObject;

import com.xt.weixinapi.exception.WeiXinException;
import com.xt.weixinapi.holder.requset.MediaInformation;
import com.xt.weixinapi.util.CertificateUtil;
import com.xt.weixinapi.util.CommonConstants;
import com.xt.weixinapi.util.MessageUtil;

public class MediaHelper implements CommonConstants
{

    /**
     * @param requestUrl 访问的地址
     * @return MediaInformation 多媒体反馈消息
     * @throws WeiXinException
     */

    public static MediaInformation uploadMedia(String requestUrl)
            throws WeiXinException
    {
        String requestMethod = REQUESTMETHOD_POST;
        String json = CertificateUtil.httpRequest(requestUrl, requestMethod,
                null);
        JSONObject jsonObject = JSONObject.fromObject(json);
        Map<String, Object> map = MessageUtil.parseJSON(jsonObject);
        Integer errcode = (Integer) map.get("errcode");
        if (ReturnCodeHelper.isRtnCodeFailed(errcode))
        {
            throw new WeiXinException(ReturnCodeHelper.getRtnCodeMsg(errcode));

        }
        String type = (String) map.get("type");
        String mediaId = (String) map.get("media_id");
        String createTime = (String) map.get("created_at");
        MediaInformation mediaInfo = new MediaInformation();
        mediaInfo.setType(type);
        mediaInfo.setMediaId(mediaId);
        mediaInfo.setCreateTime(createTime);
        return mediaInfo;
    }


    /**
     * 多媒体下载
     * 
     * @param requestUrl 访问的地址
     * @throws WeiXinException
     */
    // ***************************************
    // 未解决 正确返回http头 ，错误返回 错误码
    public static void downloadMedia(String requestUrl) throws WeiXinException
    {
        String requestMethod = REQUESTMETHOD_GET;
        String json = CertificateUtil.httpRequest(requestUrl, requestMethod,
                null);
        Map<String, Object> map = MessageUtil.parseJSON(JSONObject
                .fromObject(json));
        Integer errcode = (Integer) map.get("errcode");
        if (ReturnCodeHelper.isRtnCodeFailed(errcode))
        {
            throw new WeiXinException(ReturnCodeHelper.getRtnCodeMsg(errcode));
        }
    }
}
