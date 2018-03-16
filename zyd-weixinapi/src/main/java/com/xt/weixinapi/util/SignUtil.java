package com.xt.weixinapi.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author qinlei
 * @category 微信初始验证/表情符号转换工具类
 * @version v1.0
 */
public class SignUtil
{
    // 与接口配置信息中的Token要一致
    public static String token = "zscx_ytkj";


    /**
     * 18. * 验证签名 19. * 20. * @param signature 21. * @param timestamp 22. * @param
     * nonce 23. * @return 24.
     */
    public static boolean checkSignature(String token, String signature,
            String timestamp, String nonce)
    {
        if (null != token && !"".equals(token.trim()))
        {
            SignUtil.token = token;
        }
        String[] arr = new String[] { SignUtil.token, timestamp, nonce };
        // 将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
        {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;

        try
        {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 
     * 功能描述: 根据有效的jsapi_ticket 生成js-sdk权限验证签名
     *
     * @param jsApiTicket
     * @param url
     * @param timestamp
     * @param noncestr
     * @return
     */
    public static String generateSignature(String jsApiTicket, String url,
            String timestamp, String noncestr)
    {
        StringBuilder content = new StringBuilder();
        content.append("jsapi_ticket=").append(jsApiTicket).append("&noncestr=").append(noncestr).append("&timestamp=")
                .append(timestamp).append("&url=").append(url);
        MessageDigest md = null;
        String tmpStr = null;

        try
        {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        content = null;
        return tmpStr;
    }


    /**
     * 将字节数组转换为十六进制字符串
     * 
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray)
    {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++)
        {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }


    /**
     * 将字节转换为十六进制字符串
     * 
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte)
    {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }


    /**
     * emoji表情转换(hex -> utf-16)
     * 
     * @param hexEmoji
     * @return
     */
    public static String emoji(int hexEmoji)
    {
        return String.valueOf(Character.toChars(hexEmoji));
    }
}
