package com.xt.weixinapi.holder.requset;

/**
 * @author 吴飞
 * @category 微信请求基础信息
 * @version v1.0
 */
public class BaseMessage
{
    // 开发者微信号
    private String toUserName;
    // 发送方帐号（一个OpenID）
    private String fromUserName;
    // 消息创建时间 （整型）
    private long createTime;
    // 消息类型（text/image/location/link）
    private String msgType;
    // 消息id，64位整型
    private long msgId;


    public BaseMessage()
    {

    }


    public BaseMessage(String toUserName, String fromUserName, long createTime,
            String msgType, long msgId)
    {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.msgId = msgId;
    }


    public String getToUserName()
    {
        return toUserName;
    }


    public void setToUserName(String toUserName)
    {
        this.toUserName = toUserName;
    }


    public String getFromUserName()
    {
        return fromUserName;
    }


    public void setFromUserName(String fromUserName)
    {
        this.fromUserName = fromUserName;
    }


    public long getCreateTime()
    {
        return createTime;
    }


    public void setCreateTime(long createTime)
    {
        this.createTime = createTime;
    }


    public String getMsgType()
    {
        return msgType;
    }


    public void setMsgType(String msgType)
    {
        this.msgType = msgType;
    }


    public long getMsgId()
    {
        return msgId;
    }


    public void setMsgId(long msgId)
    {
        this.msgId = msgId;
    }
}