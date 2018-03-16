package com.xt.weixinapi.holder.requset;

/**
 * @author 吴飞
 * @category 微信请求链接信息
 * @version v1.0
 */
public class LinkMessage extends BaseMessage
{
    // 消息标题
    private String title;
    // 消息描述
    private String description;
    // 消息链接
    private String url;


    public LinkMessage()
    {

    }


    public LinkMessage(String toUserName, String fromUserName, long createTime,
            String msgType, long msgId, String title, String description,
            String url)
    {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        this.title = title;
        this.description = description;
        this.url = url;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle(String title)
    {
        this.title = title;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public String getUrl()
    {
        return url;
    }


    public void setUrl(String url)
    {
        this.url = url;
    }
}