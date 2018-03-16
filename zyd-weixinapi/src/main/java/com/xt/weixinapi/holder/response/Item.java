//*****************************************************************************
//
// File Name       :  Item.java
// Date Created    :  2014-1-6
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
public class Item
{
    // 图文消息名称
    private String Title;
    // 图文消息描述
    private String Description;
    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致
    private String PicUrl;
    // 点击图文消息跳转链接
    private String Url;
    
    public Item()
    {

    }
    public Item(String title, String description, String picUrl, String url)
    {
        // 图文消息名称
        this.setTitle(title);
        // 图文消息描述
        this.setDescription(description);
        // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致
        this.setPicUrl(picUrl);
        // 点击图文消息跳转链接
        this.setUrl(url);
    }

    public String getTitle()
    {
        return Title;
    }


    public void setTitle(String title)
    {
        this.Title = title;
    }


    public String getDescription()
    {
        return Description;
    }


    public void setDescription(String description)
    {
        this.Description = description;
    }


    public String getPicUrl()
    {
        return PicUrl;
    }


    public void setPicUrl(String picUrl)
    {
        this.PicUrl = picUrl;
    }


    public String getUrl()
    {
        return Url;
    }


    public void setUrl(String url)
    {
        this.Url = url;
    }
}
