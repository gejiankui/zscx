package com.xt.weixinapi.holder.event;

public class LocationEvent extends BaseEventHolder
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // 地理位置纬度
    private double latitude;
    // 地理位置经度
    private double longitude;
    // 地理位置精度
    private double precision;


    public LocationEvent()
    {

    }


    public LocationEvent(String toUserName, String fromUserName,
            long createTime, String msgType, String event, double latitude,
            double longitude, double precision)
    {
        super(toUserName, fromUserName, createTime, msgType, event);
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
    }


    public double getLatitude()
    {
        return latitude;
    }


    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }


    public double getLongitude()
    {
        return longitude;
    }


    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }


    public double getPrecision()
    {
        return precision;
    }


    public void setPrecision(double precision)
    {
        this.precision = precision;
    }

}
