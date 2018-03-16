package com.xt.weixinapi.helper;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.xt.weixinapi.exception.WeiXinException;
import com.xt.weixinapi.holder.user.AllGroupsHoler;
import com.xt.weixinapi.holder.user.GroupHoler;
import com.xt.weixinapi.util.CertificateUtil;
import com.xt.weixinapi.util.CommonConstants;
import com.xt.weixinapi.util.JSONUtil;
import com.xt.weixinapi.util.MessageUtil;

public class UserGroupHelper
{
    /**
     * 查询所有分组
     * 
     * @param requestUrl
     * 
     * @throws WeiXinException
     */
    public static AllGroupsHoler selectAllGroups(String requestUrl)
            throws WeiXinException
    {
        AllGroupsHoler groups = null;
        String requestMethod = CommonConstants.REQUESTMETHOD_GET;
        String json = CertificateUtil.httpRequest(requestUrl, requestMethod,
                null);
        if (!json.contains("errcode"))
        {
            Map<String, Class> map = new HashMap<String, Class>();
            // 指定AllGroupsHoler的groups字段的内部类型
            map.put("groups", GroupHoler.class);

            groups = (AllGroupsHoler) JSONUtil.toBean(json,
                    AllGroupsHoler.class, map);
        }
        Map<String, Object> map = MessageUtil.parseJSON(JSONObject
                .fromObject(json));
        Integer errcode = (Integer) map.get("errcode");
        if (ReturnCodeHelper.isRtnCodeFailed(errcode))
        {
            throw new WeiXinException(ReturnCodeHelper.getRtnCodeMsg(errcode));
        }
        return groups;

    }


    /**
     * 查询用户所在分组
     * 
     * @param requestUrl
     * @param requestMethod
     * @return
     * @throws WeiXinException
     */
    public static Integer selectUserGroupId(String requestUrl, String outputStr)
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

        return (Integer) map.get("groupid");

    }


    /**
     * 创建分组
     * 
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     * @throws WeiXinException
     */
    public static GroupHoler createGroup(String requestUrl, String outputStr)
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

        JSONObject jsonGroup = JSONObject.fromObject(map.get("group"));
        Map<String, Object> mapGroup = MessageUtil.parseJSON(jsonGroup);

        return new GroupHoler((Integer) mapGroup.get("id"),
                (String) mapGroup.get("name"));
    }


    /**
     * 修改分组名
     * 
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     * @throws WeiXinException
     */
    public static void updateGroup(String requestUrl, String outputStr)
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

    }


    /**
     * 移动用户分组
     * 
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     * @throws WeiXinException
     */

    public static void moveUserGroup(String requestUrl, String outputStr)
            throws WeiXinException
    {
        updateGroup(requestUrl, outputStr);

    }

}
