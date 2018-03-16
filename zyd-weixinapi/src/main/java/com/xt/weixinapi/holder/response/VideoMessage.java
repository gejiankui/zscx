package com.xt.weixinapi.holder.response;

public class VideoMessage extends BaseMessage
{
    // 视频标题
    private String title;
    // 视频消息的描述
    private String description;
    // 媒体ID
    private String mediaId;


    public String getMediaId()
    {
        return mediaId;
    }


    public void setMediaId(String mediaId)
    {
        this.mediaId = mediaId;
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

}
