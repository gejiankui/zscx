package com.xt.weixinapi.holder.response;

/**
 * @author qinlei
 * @category 微信响应音乐信息
 * @version v1.0
 */
public class MusicMessage extends BaseMessage
{
    private Music music;


    public Music getMusic()
    {
        return music;
    }


    public void setMusic(Music music)
    {
        this.music = music;
    }

}
