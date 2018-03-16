package com.xt.weixinapi.holder.event;

public class CustomMenuEvent extends BaseEventHolder 
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // 事件KEY值，与自定义菜单接口中KEY值对应
    private String eventKey;


    public CustomMenuEvent()
    {

    }


    public CustomMenuEvent(String toUserName, String fromUserName,
            long createTime, String msgType, String event, String eventKey)
    {
        super(toUserName, fromUserName, createTime, msgType, eventKey);
        this.eventKey = eventKey;

    }


    public String getEventKey()
    {
        return eventKey;
    }


    public void setEventKey(String eventKey)
    {
        this.eventKey = eventKey;
    }

}
