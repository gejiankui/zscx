package com.xt.weixinapi.holder.user;

import java.io.Serializable;

public class UserHolder implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // 用户是否订阅该公众号标识
    private Integer subscribe;
    // 用户的标识，对当前公众号唯一
    private String openid;
    // 用户的昵称
    private String nickname;
    // 用户的性别
    private Integer sex;
    // 用户的语言
    private String language;
    // 用户所在城市
    private String city;
    // 用户所在省份
    private String province;
    // 用户所在国家
    private String country;
    // 用户头像
    private String headimgurl;
    // 用户关注时间，为时间戳
    private long subscribe_time;
    // 用户特权信息
    private String[] privilege;
    
    private String[] tagid_list;
    
    private String groupid;

    private String remark;

    public UserHolder()
    {

    }


    public UserHolder(Integer subscribe, String openid, String nickname,
            Integer sex, String language, String city, String province,
            String country, String headimgurl, long subscribe_time,
            String[] privilege)
    {
        super();
        this.subscribe = subscribe;
        this.openid = openid;
        this.nickname = nickname;
        this.sex = sex;
        this.language = language;
        this.city = city;
        this.province = province;
        this.country = country;
        this.headimgurl = headimgurl;
        this.subscribe_time = subscribe_time;
        this.privilege = privilege;
    }


    public Integer getSubscribe()
    {
        return subscribe;
    }


    public void setSubscribe(Integer subscribe)
    {
        this.subscribe = subscribe;
    }


    public String getOpenid()
    {
        return openid;
    }


    public void setOpenid(String openid)
    {
        this.openid = openid;
    }


    public String getNickname()
    {
        return nickname;
    }


    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }


    public Integer getSex()
    {
        return sex;
    }


    public void setSex(Integer sex)
    {
        this.sex = sex;
    }


    public String getLanguage()
    {
        return language;
    }


    public void setLanguage(String language)
    {
        this.language = language;
    }


    public String getCity()
    {
        return city;
    }


    public void setCity(String city)
    {
        this.city = city;
    }


    public String getProvince()
    {
        return province;
    }


    public void setProvince(String province)
    {
        this.province = province;
    }


    public String getCountry()
    {
        return country;
    }


    public void setCountry(String country)
    {
        this.country = country;
    }


    public String getHeadimgurl()
    {
        return headimgurl;
    }


    public void setHeadimgurl(String headimgurl)
    {
        this.headimgurl = headimgurl;
    }


    public long getSubscribe_time()
    {
        return subscribe_time;
    }


    public void setSubscribe_time(long subscribe_time)
    {
        this.subscribe_time = subscribe_time;
    }


    public String[] getPrivilege()
    {
        return privilege;
    }


    public void setPrivilege(String[] privilege)
    {
        this.privilege = privilege;
    }


    public String[] getTagid_list() {
        return tagid_list;
    }


    public void setTagid_list(String[] tagid_list) {
        this.tagid_list = tagid_list;
    }


    public String getGroupid() {
        return groupid;
    }


    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }


    public String getRemark() {
        return remark;
    }


    public void setRemark(String remark) {
        this.remark = remark;
    }



}
