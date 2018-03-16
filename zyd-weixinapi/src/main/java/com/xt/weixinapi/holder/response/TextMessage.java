package com.xt.weixinapi.holder.response;

/**
 * @author qinlei
 * @category 微信响应文本信息
 * @version v1.0
 */
public class TextMessage extends BaseMessage
{
    // 回复的消息内容
    private String Content;


    public String getContent()
    {
        return Content;
    }


    public void setContent(String content)
    {
        this.Content = content;
    }

}
