package com.xt.weixinapi.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil
{
    public static String toJSON(Object bean)
    {
        JSONObject jsonObject = JSONObject.fromObject(bean);
        return jsonObject.toString();
    }


    public static Object toBean(String json, Class beanClass)
    {
        JSONObject jsonObject = JSONObject.fromObject(json);
        return JSONObject.toBean(jsonObject, beanClass);
    }
    
    public static Object toBean(String json, Class beanClass,Map<String, Class> map)
    {
        JSONObject jsonObject = JSONObject.fromObject(json);
        return JSONObject.toBean(jsonObject, beanClass,map);
    }


    public static String toJSON(List list)
    {
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }


    public static List toList(String json, Class beanClass)
    {
        JSONArray jsonArray = JSONArray.fromObject(json);
        return JSONArray.toList(jsonArray, beanClass);
    }

}
