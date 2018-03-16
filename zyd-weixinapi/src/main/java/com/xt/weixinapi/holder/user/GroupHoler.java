package com.xt.weixinapi.holder.user;

public class GroupHoler
{
    
//    分组id，由微信分配   
    private Integer id;
//    分组名字，UTF8编码
    private String name;
//    分组内用户数量
    private Integer count;
    
    
    public GroupHoler()
    {
       
    }
    
    
    public GroupHoler(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }


    public Integer getCount()
    {
        return count;
    }
    public void setCount(Integer count)
    {
        this.count = count;
    }
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    

}
