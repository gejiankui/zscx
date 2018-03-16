package com.xt.weixinapi.helper;

import java.util.Map;

import net.sf.json.JSONObject;

import com.xt.weixinapi.exception.WeiXinException;
import com.xt.weixinapi.holder.user.SubscribesListHolder;
import com.xt.weixinapi.holder.user.UserHolder;
import com.xt.weixinapi.util.CertificateUtil;
import com.xt.weixinapi.util.CommonConstants;
import com.xt.weixinapi.util.JSONUtil;
import com.xt.weixinapi.util.MessageUtil;

public class UserHelper
{
    /**
     * 获取用户基本信息
     * 
     * @param requestUrl
     * @param requestMethod
     * @return
     * @throws WeiXinException
     */
    public static UserHolder getUserInfo(String requestUrl)
            throws WeiXinException
    {
        String requestMethod = CommonConstants.REQUESTMETHOD_GET;
        String json = CertificateUtil.httpRequest(requestUrl, requestMethod,
                null);
        Map<String, Object> map = MessageUtil.parseJSON(JSONObject
                .fromObject(json));
        Integer errcode = (Integer) map.get("errcode");
        if (ReturnCodeHelper.isRtnCodeFailed(errcode))
        {
            throw new WeiXinException(ReturnCodeHelper.getRtnCodeMsg(errcode));
        }

        return (UserHolder) JSONUtil.toBean(json, UserHolder.class);

    }


    /**
     * 获取关注者列表
     * 
     * @param requestUrl
     * @param requestMethod
     * @return
     * @throws WeiXinException
     */
    public static SubscribesListHolder interfaceReq(String requestUrl)
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
        return (SubscribesListHolder) JSONUtil.toBean(json,
                SubscribesListHolder.class);

    }

    /**
     * 获取用户的地理位置
     * 
     * @return
     */
    // 已经在接受时间推送的时候写过，功能多余
    // public static String gainUserMessag(LocationMessage
    // acceptlocationMessage,
    // String label, String location_X, String location_Y, String scale)
    // {
    //
    // String repMessage = null;
    // LocationMessage reqlocationMessage = new LocationMessage();
    //
    // reqlocationMessage.setCreateTime(new Date().getTime());
    // reqlocationMessage.setFromUserName(acceptlocationMessage
    // .getToUserName());
    // reqlocationMessage.setToUserName(acceptlocationMessage
    // .getFromUserName());
    // // reqlocationMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_LOCATION);
    // reqlocationMessage.setLabel(label);
    // reqlocationMessage.setLocation_X(location_X);
    // reqlocationMessage.setLocation_Y(location_Y);
    // reqlocationMessage.setScale(scale);
    // repMessage = MessageUtil.locationMessageToXml(reqlocationMessage);
    //
    // return repMessage;
    //
    // }

}
