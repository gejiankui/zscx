package com.xt.weixinapi.holder.response;

/**
 * @author qinlei
 * @category 微信响应基础信息
 * @version v1.0
 */
public class BaseMessage
{
    // 接收方帐号（收到的OpenID）
    private String ToUserName;
    // 开发者微信号
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（text/music/news）
    private String MsgType;
    // 位0x0001被标志时，星标刚收到的消息
    //private int funcFlag;


    public String getToUserName()
    {
        return ToUserName;
    }


    public void setToUserName(String toUserName)
    {
        this.ToUserName = toUserName;
    }


    public String getFromUserName()
    {
        return FromUserName;
    }


    public void setFromUserName(String fromUserName)
    {
        this.FromUserName = fromUserName;
    }


    public long getCreateTime()
    {
        return CreateTime;
    }


    public void setCreateTime(long createTime)
    {
        this.CreateTime = createTime;
    }


    public String getMsgType()
    {
        return MsgType;
    }


    public void setMsgType(String msgType)
    {
        this.MsgType = msgType;
    }


  

}
