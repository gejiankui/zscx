package com.xt.weixinapi.helper;

import java.util.Map;

import net.sf.json.JSONObject;

import com.xt.weixinapi.exception.WeiXinException;
import com.xt.weixinapi.util.CertificateUtil;
import com.xt.weixinapi.util.CommonConstants;
import com.xt.weixinapi.util.MessageUtil;

public class MenuHelper
{
    /* private static Logger log = LoggerFactory(MenuHelper.class); */

    /**
     * 创建菜单
     * 
     * @param requestUrl 访问的地址
     * @param outputStr 创建的菜单
     * @throws WeiXinException
     */
    public static void createMenu(String requestUrl, String outputStr)
            throws WeiXinException
    {
        String requestMethod = CommonConstants.REQUESTMETHOD_POST;
        String json = CertificateUtil.httpRequest(requestUrl, requestMethod,
                outputStr);
        Map<String, Object> map = MessageUtil.parseJSON(JSONObject
                .fromObject(json));
        Integer errcode = (Integer) map.get("errcode");
        if (ReturnCodeHelper.isRtnCodeFailed(errcode))
        {
            throw new WeiXinException(ReturnCodeHelper.getRtnCodeMsg(errcode));
        }
    }


    /**
     * 查询菜单
     * 
     * @param requestUrl 访问的url
     * @return 菜单json
     * @throws WeiXinException
     */

    public static String selectMenu(String requestUrl) throws WeiXinException
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
        String menu = (String) map.get("menu");
        return menu;
    }


    /**
     * 删除菜单
     * 
     * @param requestUrl 访问的url
     * @throws WeiXinException
     */

    public static void deleteMenu(String requestUrl) throws WeiXinException
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
    }

}
