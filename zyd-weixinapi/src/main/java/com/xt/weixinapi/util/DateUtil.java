package com.xt.weixinapi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 王帅
 * @category 时间工具类
 * @version v1.0
 */
public class DateUtil
{
    public static String formatTime(String createTime)
    {
        // 将微信传入的CreateTime转换成long类型，再乘以1000
        long msgCreateTime = Long.parseLong(createTime) * 1000L;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date(msgCreateTime));
    }
}
