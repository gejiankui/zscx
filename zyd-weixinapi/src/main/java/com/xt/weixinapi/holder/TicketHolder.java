package com.xt.weixinapi.holder;

public class TicketHolder
{
    private Integer expireSeconds;
    private String ticket;
    public TicketHolder()
    {
        
    }

    public TicketHolder(Integer expireSeconds, String ticket)
    {
        this.expireSeconds = expireSeconds;
        this.ticket = ticket;
    }

    public Integer getExpireSeconds()
    {
        return expireSeconds;
    }


    public void setExpireSeconds(Integer expireSeconds)
    {
        this.expireSeconds = expireSeconds;
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
