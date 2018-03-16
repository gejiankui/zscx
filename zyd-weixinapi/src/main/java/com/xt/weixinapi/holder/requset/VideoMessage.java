package com.xt.weixinapi.holder.requset;

public class VideoMessage extends BaseMessage
{
    // 媒体ID
    private String mediaId;
    // 视频消息缩略图的媒体ID
    private String thumbMediaId;


    public VideoMessage()
    {

    }


    public VideoMessage(String toUserName, String fromUserName,
            long createTime, String msgType, long msgId, String mediaId,
            String thumbMediaId)
    {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        this.mediaId = mediaId;
        this.thumbMediaId = thumbMediaId;
    }


    public String getMediaId()
    {
        return mediaId;
    }


    public void setMediaId(String mediaId)
    {
        this.mediaId = mediaId;
    }


    public String getThumbMediaId()
    {
        return thumbMediaId;
    }


    public void setThumbMediaId(String thumbMediaId)
    {
        this.thumbMediaId = thumbMediaId;
    }
}
