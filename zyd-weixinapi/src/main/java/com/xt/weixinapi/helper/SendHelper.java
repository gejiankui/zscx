package com.xt.weixinapi.helper;

import java.util.Date;
import java.util.List;

import com.xt.weixinapi.holder.requset.ImageMessage;
import com.xt.weixinapi.holder.requset.VoiceMessage;
import com.xt.weixinapi.holder.response.Article;
import com.xt.weixinapi.holder.response.Item;
import com.xt.weixinapi.holder.response.Music;
import com.xt.weixinapi.holder.response.MusicMessage;
import com.xt.weixinapi.holder.response.NewsMessage;
import com.xt.weixinapi.holder.response.TextMessage;
import com.xt.weixinapi.holder.response.VideoMessage;
import com.xt.weixinapi.util.CertificateUtil;
import com.xt.weixinapi.util.CommonConstants;
import com.xt.weixinapi.util.JSONUtil;
import com.xt.weixinapi.util.MessageUtil;

/**
 * 回复微信发来的请求<发送被动响应消息>
 * 
 * @author wangshuai
 * @return
 */

public class SendHelper
{
    /**
     * 回复文本请求<发送被动响应消息>
     * 
     * @return
     */
    public static String respTextMsgViaXml(String toUsername,
            String fromUsername, String content)
    {
        TextMessage respTextMessage = new TextMessage();

        respTextMessage.setCreateTime(new Date().getTime());
        respTextMessage.setFromUserName(toUsername);
        respTextMessage.setToUserName(fromUsername);
        respTextMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
        respTextMessage.setContent(content);

        return MessageUtil.textMessageToXml(respTextMessage);

    }


    /**
     * 回复图片信息<发送被动响应消息>
     */
    public static String respImageMsgViaXml(ImageMessage reqImageMessage,
            String MediaId)
    {
        ImageMessage respImageMessage = new ImageMessage();

        respImageMessage.setCreateTime(new Date().getTime());
        respImageMessage.setFromUserName(reqImageMessage.getToUserName());
        respImageMessage.setToUserName(reqImageMessage.getFromUserName());
        respImageMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        respImageMessage.setMediaId(MediaId);

        return MessageUtil.imageMessageToXml(respImageMessage);

    }


    /**
     * 回复语音信息<发送被动响应消息>
     */
    public static String respVoiceMsgViaXml(VoiceMessage reqVoiceMessage,
            String mediaId)
    {

        VoiceMessage respVoiceMessage = new VoiceMessage();

        respVoiceMessage.setCreateTime(new Date().getTime());
        respVoiceMessage.setFromUserName(reqVoiceMessage.getToUserName());
        respVoiceMessage.setToUserName(reqVoiceMessage.getFromUserName());
        respVoiceMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_VOICE);
        respVoiceMessage.setMediaId(mediaId);

        return MessageUtil.voiceMessageToXml(respVoiceMessage);

    }


    /**
     * 回复视频信息<发送被动响应消息>
     */
    public static String respVideoMsgViaXml(VideoMessage reqVideoMessage,
            String mediaId, String title, String description)
    {
        VideoMessage respVideoMessage = new VideoMessage();

        respVideoMessage.setCreateTime(new Date().getTime());
        respVideoMessage.setFromUserName(reqVideoMessage.getToUserName());
        respVideoMessage.setToUserName(reqVideoMessage.getFromUserName());
        respVideoMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_VOICE);
        respVideoMessage.setMediaId(mediaId);
        respVideoMessage.setTitle(title);
        respVideoMessage.setDescription(description);

        return MessageUtil.videoMessageToXml(respVideoMessage);
    }


    /**
     * 回复音乐消息<发送被动响应消息>
     */
    public static String respMusicMsgViaXml(MusicMessage reqMusicMessage,
            Music music)
    {

        MusicMessage respMusicMessage = new MusicMessage();

        respMusicMessage.setCreateTime(new Date().getTime());
        respMusicMessage.setFromUserName(reqMusicMessage.getToUserName());
        respMusicMessage.setToUserName(reqMusicMessage.getFromUserName());
        respMusicMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);

        respMusicMessage.setMusic(music);

        return MessageUtil.musicMessageToXml(respMusicMessage);

    }


    /**
     * 图文消息 <发送被动响应消息>
     */
    public static String respNewsMsgViaXml(String toUsername,
            String fromUsername, List<Item> articles)
    {

        NewsMessage respNewsMessage = new NewsMessage();

        respNewsMessage.setCreateTime(new Date().getTime());
        respNewsMessage.setFromUserName(toUsername);
        respNewsMessage.setToUserName(fromUsername);
        respNewsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

        respNewsMessage.setArticles(articles);
        respNewsMessage.setArticleCount(articles.size());

        return MessageUtil.newsMessageToXml(respNewsMessage);

    }


    /**
     * 回复文本请求JSON
     * 
     * @return
     */
    public static void respTextMsgViaJson(String requestUrl,
            TextMessage reqTextMessage, String content)
    {
        TextMessage respTextMessage = new TextMessage();

        respTextMessage.setCreateTime(new Date().getTime());
        respTextMessage.setFromUserName(reqTextMessage.getToUserName());
        respTextMessage.setToUserName(reqTextMessage.getFromUserName());
        respTextMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
        respTextMessage.setContent(content);

        String requestMethod = CommonConstants.REQUESTMETHOD_POST;
        String repMessage = JSONUtil.toJSON(respTextMessage);
        CertificateUtil.httpRequest(requestUrl, requestMethod, repMessage);
    }


    /**
     * 回复图片信息JSON
     */
    public static void respImageMsgViaJson(String requestUrl,
            ImageMessage reqImageMessage, String MediaId)
    {
        ImageMessage respImageMessage = new ImageMessage();

        respImageMessage.setCreateTime(new Date().getTime());
        respImageMessage.setFromUserName(reqImageMessage.getToUserName());
        respImageMessage.setToUserName(reqImageMessage.getFromUserName());
        respImageMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        respImageMessage.setMediaId(MediaId);

        String requestMethod = CommonConstants.REQUESTMETHOD_POST;
        String repMessage = JSONUtil.toJSON(respImageMessage);
        CertificateUtil.httpRequest(requestUrl, requestMethod, repMessage);
    }


    /**
     * 回复语音信息JSON
     */
    public static void respVoiceMsgViaJson(String requestUrl,
            VoiceMessage reqVoiceMessage, String mediaId)
    {

        VoiceMessage respVoiceMessage = new VoiceMessage();

        respVoiceMessage.setCreateTime(new Date().getTime());
        respVoiceMessage.setFromUserName(reqVoiceMessage.getToUserName());
        respVoiceMessage.setToUserName(reqVoiceMessage.getFromUserName());
        respVoiceMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_VOICE);
        respVoiceMessage.setMediaId(mediaId);

        String requestMethod = CommonConstants.REQUESTMETHOD_POST;
        String repMessage = JSONUtil.toJSON(respVoiceMessage);
        CertificateUtil.httpRequest(requestUrl, requestMethod, repMessage);
    }


    /**
     * 回复视频信息JSON
     */
    public static void respVideoMsgViaJson(String requestUrl,
            VideoMessage reqVideoMessage, String mediaId, String title,
            String description)
    {
        VideoMessage respVideoMessage = new VideoMessage();

        respVideoMessage.setCreateTime(new Date().getTime());
        respVideoMessage.setFromUserName(reqVideoMessage.getToUserName());
        respVideoMessage.setToUserName(reqVideoMessage.getFromUserName());
        respVideoMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_VOICE);
        respVideoMessage.setMediaId(mediaId);
        respVideoMessage.setTitle(title);
        respVideoMessage.setDescription(description);

        String requestMethod = CommonConstants.REQUESTMETHOD_POST;
        String repMessage = JSONUtil.toJSON(respVideoMessage);
        CertificateUtil.httpRequest(requestUrl, requestMethod, repMessage);

    }


    /**
     * 回复音乐消息JSON
     */
    public static void respMusicMsgViaJson(String requestUrl,
            MusicMessage reqMusicMessage, Music music)
    {

        MusicMessage respMusicMessage = new MusicMessage();

        respMusicMessage.setCreateTime(new Date().getTime());
        respMusicMessage.setFromUserName(reqMusicMessage.getToUserName());
        respMusicMessage.setToUserName(reqMusicMessage.getFromUserName());
        respMusicMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);

        respMusicMessage.setMusic(music);

        String requestMethod = CommonConstants.REQUESTMETHOD_POST;
        String repMessage = JSONUtil.toJSON(respMusicMessage);
        CertificateUtil.httpRequest(requestUrl, requestMethod, repMessage);

    }


    /**
     * 图文消息 JSON
     */
    public static void respNewsMsgViaJson(String requestUrl,
            NewsMessage reqNewsMessage, List<Item> articles)
    {

        NewsMessage respNewsMessage = new NewsMessage();

        respNewsMessage.setCreateTime(new Date().getTime());
        respNewsMessage.setFromUserName(reqNewsMessage.getToUserName());
        respNewsMessage.setToUserName(reqNewsMessage.getFromUserName());
        respNewsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

        respNewsMessage.setArticles(articles);
        respNewsMessage.setArticleCount(articles.size());

        String requestMethod = CommonConstants.REQUESTMETHOD_POST;
        String repMessage = JSONUtil.toJSON(respNewsMessage);

        CertificateUtil.httpRequest(requestUrl, requestMethod, repMessage);

    }

}
