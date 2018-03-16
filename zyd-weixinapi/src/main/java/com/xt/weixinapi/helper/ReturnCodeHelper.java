package com.xt.weixinapi.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReturnCodeHelper
{
    public static final Integer CODE_1 = -1;
    public static final String MSG_1 = "系统繁忙!";

    public static final Integer CODE_0 = 0;
    public static final String MSG_0 = "请求成功!";

    public static final Integer CODE_40001 = 40001;
    public static final String MSG_40001 = "获取access_token时AppSecret错误，或者access_token无效!";

    public static final Integer CODE_40002 = 40002;
    public static final String MSG_40002 = "不合法的凭证类型!";

    public static final Integer CODE_40003 = 40003;
    public static final String MSG_40003 = "不合法的OpenID!";

    public static final Integer CODE_40004 = 40004;
    public static final String MSG_40004 = "不合法的媒体文件类型!";

    public static final Integer CODE_40005 = 40005;
    public static final String MSG_40005 = "不合法的文件类型!";

    public static final Integer CODE_40006 = 40006;
    public static final String MSG_40006 = "不合法的文件大小!";

    public static final Integer CODE_40007 = 40007;
    public static final String MSG_40007 = "不合法的媒体文件id!";

    public static final Integer CODE_40008 = 40008;
    public static final String MSG_40008 = "不合法的消息类型!";

    public static final Integer CODE_40009 = 40009;
    public static final String MSG_40009 = "不合法的图片文件大小!";

    public static final Integer CODE_40010 = 40010;
    public static final String MSG_40010 = "不合法的语音文件大小!";

    public static final Integer CODE_40011 = 40011;
    public static final String MSG_40011 = "不合法的视频文件大小!";

    public static final Integer CODE_40012 = 40012;
    public static final String MSG_40012 = "不合法的缩略图文件大小!";

    public static final Integer CODE_40013 = 40013;
    public static final String MSG_40013 = "不合法的APPID!";

    public static final Integer CODE_40014 = 40014;
    public static final String MSG_40014 = "不合法的access_token!";

    public static final Integer CODE_40015 = 40015;
    public static final String MSG_40015 = "不合法的菜单类型!";

    public static final Integer CODE_40016 = 40016;
    public static final String MSG_40016 = "不合法的按钮个数!";

    public static final Integer CODE_40017 = 40017;
    public static final String MSG_40017 = "不合法的按钮个数!";

    public static final Integer CODE_40018 = 40018;
    public static final String MSG_40018 = "不合法的按钮名字长度!";

    public static final Integer CODE_40019 = 40019;
    public static final String MSG_40019 = "不合法的按钮KEY长度!";

    public static final Integer CODE_40020 = 40020;
    public static final String MSG_40020 = "不合法的按钮URL长度!";

    public static final Integer CODE_40021 = 40021;
    public static final String MSG_40021 = "不合法的菜单版本号!";

    public static final Integer CODE_40022 = 40022;
    public static final String MSG_40022 = "不合法的子菜单级数!";

    public static final Integer CODE_40023 = 40023;
    public static final String MSG_40023 = "不合法的子菜单按钮个数!";

    public static final Integer CODE_40024 = 40024;
    public static final String MSG_40024 = "不合法的子菜单按钮类型!";

    public static final Integer CODE_40025 = 40025;
    public static final String MSG_40025 = "不合法的子菜单按钮名字长度!";

    public static final Integer CODE_40026 = 40026;
    public static final String MSG_40026 = "不合法的子菜单按钮KEY长度!";

    public static final Integer CODE_40027 = 40027;
    public static final String MSG_40027 = "不合法的子菜单按钮URL长度!";

    public static final Integer CODE_40028 = 40028;
    public static final String MSG_40028 = "不合法的自定义菜单使用用户!";

    public static final Integer CODE_40029 = 40029;
    public static final String MSG_40029 = "不合法的oauth_CODE!";

    public static final Integer CODE_40030 = 40030;
    public static final String MSG_40030 = "不合法的refresh_token!";

    public static final Integer CODE_40031 = 40031;
    public static final String MSG_40031 = "不合法的openid列表!";

    public static final Integer CODE_40032 = 40032;
    public static final String MSG_40032 = "不合法的openid列表长度!";

    public static final Integer CODE_40033 = 40033;
    public static final String MSG_40033 = "不合法的请求字符，不能包含\\uxxxx格式的字符!";

    public static final Integer CODE_40035 = 40035;
    public static final String MSG_40035 = "不合法的参数!";

    public static final Integer CODE_40038 = 40038;
    public static final String MSG_40038 = "不合法的请求格式!";

    public static final Integer CODE_40039 = 40039;
    public static final String MSG_40039 = "不合法的URL长度!";

    public static final Integer CODE_40050 = 40050;
    public static final String MSG_40050 = "不合法的分组id!";

    public static final Integer CODE_40051 = 40051;
    public static final String MSG_40051 = "分组名字不合法!";

    public static final Integer CODE_41001 = 41001;
    public static final String MSG_41001 = "缺少access_token参数!";

    public static final Integer CODE_41002 = 41002;
    public static final String MSG_41002 = "缺少appid参数!";

    public static final Integer CODE_41003 = 41003;
    public static final String MSG_41003 = "缺少refresh_token参数!";

    public static final Integer CODE_41004 = 41004;
    public static final String MSG_41004 = "缺少secret参数!";

    public static final Integer CODE_41005 = 41005;
    public static final String MSG_41005 = "缺少多媒体文件数据!";

    public static final Integer CODE_41006 = 41006;
    public static final String MSG_41006 = "缺少media_id参数!";

    public static final Integer CODE_41007 = 41007;
    public static final String MSG_41007 = "缺少子菜单数据!";

    public static final Integer CODE_41008 = 41008;
    public static final String MSG_41008 = "缺少oauth CODE!";

    public static final Integer CODE_41009 = 41009;
    public static final String MSG_41009 = "缺少openid!";

    public static final Integer CODE_42001 = 42001;
    public static final String MSG_42001 = "access_token超时!";

    public static final Integer CODE_42002 = 42002;
    public static final String MSG_42002 = "refresh_token超时!";

    public static final Integer CODE_42003 = 42003;
    public static final String MSG_42003 = "oauth_CODE超时!";

    public static final Integer CODE_43001 = 43001;
    public static final String MSG_43001 = "需要GET请求!";

    public static final Integer CODE_43002 = 43002;
    public static final String MSG_43002 = "需要POST请求!";

    public static final Integer CODE_43003 = 43003;
    public static final String MSG_43003 = "需要HTTPS请求!";

    public static final Integer CODE_43004 = 43004;
    public static final String MSG_43004 = "需要接收者关注!";

    public static final Integer CODE_43005 = 43005;
    public static final String MSG_43005 = "需要好友关系!";

    public static final Integer CODE_44001 = 44001;
    public static final String MSG_44001 = "多媒体文件为空!";

    public static final Integer CODE_44002 = 44002;
    public static final String MSG_44002 = "POST的数据包为空!";

    public static final Integer CODE_44003 = 44003;
    public static final String MSG_44003 = "图文消息内容为空!";

    public static final Integer CODE_44004 = 44004;
    public static final String MSG_44004 = "文本消息内容为空!";

    public static final Integer CODE_45001 = 45001;
    public static final String MSG_45001 = "多媒体文件大小超过限制!";

    public static final Integer CODE_45002 = 45002;
    public static final String MSG_45002 = "消息内容超过限制!";

    public static final Integer CODE_45003 = 45003;
    public static final String MSG_45003 = "标题字段超过限制!";

    public static final Integer CODE_45004 = 45004;
    public static final String MSG_45004 = "描述字段超过限制!";

    public static final Integer CODE_45005 = 45005;
    public static final String MSG_45005 = "链接字段超过限制!";

    public static final Integer CODE_45006 = 45006;
    public static final String MSG_45006 = "图片链接字段超过限制!";

    public static final Integer CODE_45007 = 45007;
    public static final String MSG_45007 = "语音播放时间超过限制!";

    public static final Integer CODE_45008 = 45008;
    public static final String MSG_45008 = "图文消息超过限制!";

    public static final Integer CODE_45009 = 45009;
    public static final String MSG_45009 = "接口调用超过限制!";

    public static final Integer CODE_45010 = 45010;
    public static final String MSG_45010 = "创建菜单个数超过限制!";

    public static final Integer CODE_45015 = 45015;
    public static final String MSG_45015 = "回复时间超过限制!";

    public static final Integer CODE_45016 = 45016;
    public static final String MSG_45016 = "系统分组，不允许修改!";

    public static final Integer CODE_45017 = 45017;
    public static final String MSG_45017 = "分组名字过长!";

    public static final Integer CODE_45018 = 45018;
    public static final String MSG_45018 = "分组数量超过上限!";

    public static final Integer CODE_46001 = 46001;
    public static final String MSG_46001 = "不存在媒体数据!";

    public static final Integer CODE_46002 = 46002;
    public static final String MSG_46002 = "不存在的菜单版本!";

    public static final Integer CODE_46003 = 46003;
    public static final String MSG_46003 = "不存在的菜单数据!";

    public static final Integer CODE_46004 = 46004;
    public static final String MSG_46004 = "不存在的用户!";

    public static final Integer CODE_47001 = 47001;
    public static final String MSG_47001 = "解析JSON/XML内容错误";

    public static final Integer CODE_48001 = 48001;
    public static final String MSG_48001 = "api功能未授权!";

    public static final Integer CODE_50001 = 50001;
    public static final String MSG_50001 = "用户未授权该api!";

    private static Map<Integer, String> returnCodeMap = new ConcurrentHashMap<Integer, String>();


    public static boolean isRtnCodeFailed(Integer returnCode)
    {
        if (!isRtnCodeOk(returnCode))
        {
            return true;
        }
        return false;
    }


    public static boolean isRtnCodeOk(Integer returnCode)
    {
        if (CODE_0.equals(returnCode) || null == returnCode)
        {
            return true;
        }
        return false;
    }


    public static String getRtnCodeMsg(Integer returnCode)
    {
        return returnCodeMap.get(returnCode);
    }

    static
    {
        returnCodeMap.put(CODE_1, MSG_1);
        returnCodeMap.put(CODE_0, MSG_0);
        returnCodeMap.put(CODE_40001, MSG_40001);
        returnCodeMap.put(CODE_40002, MSG_40002);
        returnCodeMap.put(CODE_40003, MSG_40003);
        returnCodeMap.put(CODE_40004, MSG_40004);
        returnCodeMap.put(CODE_40005, MSG_40005);
        returnCodeMap.put(CODE_40006, MSG_40006);
        returnCodeMap.put(CODE_40007, MSG_40007);
        returnCodeMap.put(CODE_40008, MSG_40008);
        returnCodeMap.put(CODE_40009, MSG_40009);
        returnCodeMap.put(CODE_40010, MSG_40010);
        returnCodeMap.put(CODE_40011, MSG_40011);
        returnCodeMap.put(CODE_40012, MSG_40012);
        returnCodeMap.put(CODE_40013, MSG_40013);
        returnCodeMap.put(CODE_40014, MSG_40014);
        returnCodeMap.put(CODE_40015, MSG_40015);
        returnCodeMap.put(CODE_40016, MSG_40016);
        returnCodeMap.put(CODE_40017, MSG_40017);
        returnCodeMap.put(CODE_40018, MSG_40018);
        returnCodeMap.put(CODE_40019, MSG_40019);
        returnCodeMap.put(CODE_40020, MSG_40020);
        returnCodeMap.put(CODE_40021, MSG_40021);
        returnCodeMap.put(CODE_40022, MSG_40022);
        returnCodeMap.put(CODE_40023, MSG_40023);
        returnCodeMap.put(CODE_40024, MSG_40024);
        returnCodeMap.put(CODE_40025, MSG_40025);
        returnCodeMap.put(CODE_40026, MSG_40026);
        returnCodeMap.put(CODE_40027, MSG_40027);
        returnCodeMap.put(CODE_40028, MSG_40028);
        returnCodeMap.put(CODE_40029, MSG_40029);
        returnCodeMap.put(CODE_40030, MSG_40030);
        returnCodeMap.put(CODE_40031, MSG_40031);
        returnCodeMap.put(CODE_40032, MSG_40032);
        returnCodeMap.put(CODE_40033, MSG_40033);
        returnCodeMap.put(CODE_40035, MSG_40035);
        returnCodeMap.put(CODE_40038, MSG_40038);
        returnCodeMap.put(CODE_40039, MSG_40039);
        returnCodeMap.put(CODE_40050, MSG_40050);
        returnCodeMap.put(CODE_40051, MSG_40051);
        returnCodeMap.put(CODE_41001, MSG_41001);
        returnCodeMap.put(CODE_41002, MSG_41002);
        returnCodeMap.put(CODE_41003, MSG_41003);
        returnCodeMap.put(CODE_41004, MSG_41004);
        returnCodeMap.put(CODE_41005, MSG_41005);
        returnCodeMap.put(CODE_41006, MSG_41006);
        returnCodeMap.put(CODE_41007, MSG_41007);
        returnCodeMap.put(CODE_41008, MSG_41008);
        returnCodeMap.put(CODE_41009, MSG_41009);
        returnCodeMap.put(CODE_42001, MSG_42001);
        returnCodeMap.put(CODE_42002, MSG_42002);
        returnCodeMap.put(CODE_42003, MSG_42003);
        returnCodeMap.put(CODE_43001, MSG_43001);
        returnCodeMap.put(CODE_43002, MSG_43002);
        returnCodeMap.put(CODE_43003, MSG_43003);
        returnCodeMap.put(CODE_43004, MSG_43004);
        returnCodeMap.put(CODE_43005, MSG_43005);
        returnCodeMap.put(CODE_44001, MSG_44001);
        returnCodeMap.put(CODE_44002, MSG_44002);
        returnCodeMap.put(CODE_44003, MSG_44003);
        returnCodeMap.put(CODE_44004, MSG_44004);
        returnCodeMap.put(CODE_45001, MSG_45001);
        returnCodeMap.put(CODE_45002, MSG_45002);
        returnCodeMap.put(CODE_45003, MSG_45003);
        returnCodeMap.put(CODE_45004, MSG_45004);
        returnCodeMap.put(CODE_45005, MSG_45005);
        returnCodeMap.put(CODE_45006, MSG_45006);
        returnCodeMap.put(CODE_45007, MSG_45007);
        returnCodeMap.put(CODE_45008, MSG_45008);
        returnCodeMap.put(CODE_45009, MSG_45009);
        returnCodeMap.put(CODE_45010, MSG_45010);
        returnCodeMap.put(CODE_45015, MSG_45015);
        returnCodeMap.put(CODE_45016, MSG_45016);
        returnCodeMap.put(CODE_45017, MSG_45017);
        returnCodeMap.put(CODE_45018, MSG_45018);
        returnCodeMap.put(CODE_46001, MSG_46001);
        returnCodeMap.put(CODE_46002, MSG_46002);
        returnCodeMap.put(CODE_46003, MSG_46003);
        returnCodeMap.put(CODE_46004, MSG_46004);
        returnCodeMap.put(CODE_47001, MSG_47001);
        returnCodeMap.put(CODE_48001, MSG_48001);
        returnCodeMap.put(CODE_50001, MSG_50001);

    }
}
