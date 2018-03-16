package com.xt.weixinapi.holder.event;

public class UnsubscribeEvent extends BaseEventHolder
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public UnsubscribeEvent()
    {

    }


    public UnsubscribeEvent(String toUserName, String fromUserName,
            long createTime, String msgType, String event)
    {
        super(toUserName, fromUserName, createTime, msgType, event);
    }

}
