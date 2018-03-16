package com.xt.weixinapi.holder.requset;

/**
 * @author 吴飞
 * @category 微信请求文本信息
 * @version v1.0
 */
public class TextMessage extends BaseMessage
{
    // 消息内容
    private String content;


    public TextMessage()
    {

    }


    public TextMessage(String toUserName, String fromUserName, long createTime,
            String msgType, long msgId, String content)
    {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        this.content = content;
    }


    public String getContent()
    {
        return content;
    }


    public void setContent(String content)
    {
        this.content = content;
    }
}
