//*****************************************************************************
//
// File Name       :  Music.java
// Date Created    :  2014-1-7
// Last Changed By :  $Author: $
// Last Changed On :  $Date: $
// Revision        :  $Rev: $
// Description     :  TODO To fill in a brief description of the purpose of
//                    this class.
//
// Cloudycd Pte Ltd.  Copyright (c) 2014.  All Rights Reserved.
//
//*****************************************************************************

package com.xt.weixinapi.holder.response;

/**
 * TODO To provide an overview of this class.
 *
 * @author liyur
 */
public class Music
{
    public Music()
    {

    }


    public Music(String title, String description, String musicUrl,
            String hQMusicUrl, String thumbMediaId)
    {
        // 音乐名称
        this.title = title;
        // 音乐描述
        this.description = description;
        // 音乐链接
        this.musicUrl = musicUrl;
        // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
        this.hQMusicUrl = hQMusicUrl;
        // 缩略图的媒体id，通过上传多媒体文件，得到的id
        this.thumbMediaId = thumbMediaId;
    }

    // 音乐名称
    private String title;
    // 音乐描述
    private String description;
    // 音乐链接
    private String musicUrl;
    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String hQMusicUrl;
    // 缩略图的媒体id，通过上传多媒体文件，得到的id
    private String thumbMediaId;


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


    public String getMusicUrl()
    {
        return musicUrl;
    }


    public void setMusicUrl(String musicUrl)
    {
        this.musicUrl = musicUrl;
    }


    public String gethQMusicUrl()
    {
        return hQMusicUrl;
    }


    public void sethQMusicUrl(String hQMusicUrl)
    {
        this.hQMusicUrl = hQMusicUrl;
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
