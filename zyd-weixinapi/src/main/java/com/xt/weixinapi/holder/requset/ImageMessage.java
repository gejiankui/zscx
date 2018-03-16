package com.xt.weixinapi.holder.requset;

/**
 * @author 吴飞
 * @category 微信请求图片信息
 * @version v1.0
 */
public class ImageMessage extends BaseMessage
{

    // 媒体ID
    private String mediaId;
    // 图片链接
    private String picUrl;


    public ImageMessage()
    {

    }


    public ImageMessage(String toUserName, String fromUserName,
            long createTime, String msgType, long msgId, String mediaId,
            String picUrl)
    {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        this.mediaId = mediaId;
        this.picUrl = picUrl;
    }


    public String getPicUrl()
    {
        return picUrl;
    }


    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }


    public String getMediaId()
    {
        return mediaId;
    }


    public void setMediaId(String mediaId)
    {
        this.mediaId = mediaId;
    }
}
