package com.xt.weixinapi.holder.event;

public class ScanCodeEvent extends BaseEventHolder
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // 事件KEY值，qrscene_为前缀，后面为二维码的参数值
    private String eventKey;
    // 二维码的ticket，可用来换取二维码图片
    private String ticket;


    public ScanCodeEvent()
    {

    }


    public ScanCodeEvent(String toUserName, String fromUserName,
            long createTime, String msgType, String event, String eventKey,
            String ticket)
    {
        super(toUserName, fromUserName, createTime, msgType, eventKey);
        this.eventKey = eventKey;
        this.ticket = ticket;
    }


    public String getEventKey()
    {
        return eventKey;
    }


    public void setEventKey(String eventKey)
    {
        this.eventKey = eventKey;
    }


    public String getTicket()
    {
        return ticket;
    }


    public void setTicket(String ticket)
    {
        this.ticket = ticket;
    }

}
