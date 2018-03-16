package com.xt.weixinapi.holder.requset;

/**
 * @author 吴飞
 * @category 微信请求语音信息
 * @version v1.0
 */
public class VoiceMessage extends BaseMessage
{
    // 媒体ID
    private String mediaId;
    // 语音格式
    private String format;

    // 语音识别结果，UTF8编码
    private String recognition;


    public VoiceMessage()
    {

    }


    public VoiceMessage(String toUserName, String fromUserName,
            long createTime, String msgType, long msgId, String mediaId,
            String format, String recognition)
    {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        this.mediaId = mediaId;
        this.format = format;
    }


    public String getMediaId()
    {
        return mediaId;
    }


    public void setMediaId(String mediaId)
    {
        this.mediaId = mediaId;
    }


    public String getFormat()
    {
        return format;
    }


    public void setFormat(String format)
    {
        this.format = format;
    }


    public String getRecognition()
    {
        return recognition;
    }


    public void setRecognition(String recognition)
    {
        this.recognition = recognition;
    }

}
