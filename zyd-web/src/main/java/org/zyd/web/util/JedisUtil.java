package org.zyd.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import javax.annotation.Resource;
import java.util.List;

/**
 * Redis缓存操作的工具类<br>
 * <p>
 * Copyright: Copyright (c) Nov 7, 2013 10:31:44 AM
 * <p>
 * Company:
 * <p>
 * 
 * @version 1.0.0
 */

@Component
public class JedisUtil
{

    /**
     * logger 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    /**
     * jedisPool redis连接池
     */
    @Resource(name = "jedisPool")
    public JedisPool jedisPool;


    /**
     * 方法描述:从连接池获取jedis对象
     * 
     * @return 返回Jedis的有效对象 date:Nov 14, 2013 add by: fangsj
     */
    public Jedis getResource()
    {
        logger.debug("[JedisUtil:getResource]: get jedis Resource from Pool...");
        Jedis jedis = null;// 声明jedis对象
        int cycleTimes = 0;// 出现异常已经循环获取的次数
        try
        {
            jedis = this.jedisPool.getResource();// 从pool中获取jedis对象
        }
        catch (JedisConnectionException ex)
        {
            try
            {
                // 获取占用异常,捕获异常,等待0.5秒后继续执行获取
                logger.debug("[JedisUtil:getResource]:redis pool is full,Program will sleep 0.5s to wait an idle.message:\n"
                        + ex.getMessage());

                while (cycleTimes < 0)
                {
                    cycleTimes++;// 获取次数 +1;
                    Thread.sleep(500);// 等待0.5s

                    logger.debug("[JedisUtil:getResource]:waiting to get an idle...");
                    try
                    {
                        jedis = this.jedisPool.getResource();// 重新获取jedis对象
                    }
                    catch (JedisConnectionException ex1)
                    {
                        logger.debug("[JedisUtil:getResource]:get an idle failed.Program will try again.");
                        // 出现获取异常,继续执行
                        continue;
                    }

                    // 获取到对象后跳出循环
                    if (jedis != null)
                    {
                        // 输出获取成功的消息
                        logger.debug("[JedisUtil:getResource]:get an idle success.");
                        break;
                    }
                    else
                    { // 如果获取出对象为null,则继续循环等待获取.
                        logger.debug("[JedisUtil:getResource]:get an idle is null.Program will try again.");
                        continue;
                    }
                }
            }
            // 处理线程截断异常
            catch (InterruptedException e)
            {
                logger.error(e.getLocalizedMessage());
            }
        }
        // 获取对象如果不为空则返回
        if (jedis != null)
        {
            logger.debug("[JedisUtil:getResource]: get jedis Resource from Pool success.");
        }
        else
        {// 当循环获取超过三次直接抛出异常 返回null
            logger.error("[JedisUtil:getResource]:get jedis object failed.if redis server is runing,please check the configration and Network connection.");
        }
        return jedis;
    }


    /**
     * 方法描述:使用完毕后将jedis对象归还连接池
     * 
     * @param jedis 从pool中获取的jedis对象 date:Nov 14, 2013 add by: fangsj
     */
    public void returnResource(Jedis jedis)
    {
        try
        {
            if (jedis != null) this.jedisPool.returnResource(jedis);// 归还对象至pool
            logger.debug("[JedisUtil:returnResource]: return jedis Resource to Pool  ...");
        }
        catch (JedisConnectionException ex)
        {
            // 归还失败,强制销毁该链接
            this.jedisPool.returnBrokenResource(jedis);
        }
    }


    /**
     * 方法描述:根据关键字从redis服务器中获取对应的value
     * 
     * @param key 键值
     * @return 存储在redis中的value date:Nov 14, 2013 add by: fangsj
     */
    public String getRedisStrValue(String key)
    {

        Jedis jedis = null;// 声明一个链接对象
        String value = null;// 获取的键值所对应的值

        try
        {
            jedis = this.getResource();// 获取jedis资源

            // 资源不为空,则获取对应的value
            if (jedis != null) value = jedis.get(key);

        }
        finally
        {
            if (jedis != null) this.returnResource(jedis);
        }
        return value;
    }


    /**
     * 方法描述:往redis中注入缓存对象
     * 
     * @param key 对象的键值
     * @param value 键值所对应的值
     * @return 返回成功与否,成功返回true 失败返回false date:Nov 18, 2013 add by: fangsj
     */
    public boolean setRedisStrValue(String key, String value)
    {

        Jedis jedis = null;// 声明一个链接对象
        boolean flag = true;// 返回标记,默认成功

        try
        {
            jedis = this.getResource();// 获取资源

            // 资源不为空则执行注入操作 否则返回注入失败
            if (jedis != null)
                jedis.set(key, value);
            else
                flag = false;
        }
        finally
        {
            // 归还资源
            if (jedis != null) this.returnResource(jedis);
        }
        return flag;
    }


    /**
     * 方法描述:往redis中注入缓存对象
     * 
     * @param key 对象的键值
     * @param value 键值所对应的值
     * @param seconds 键值存储时间,如果为负数,则不设存储上限时间 单位:秒
     * @return 返回成功与否,成功返回true 失败返回false date:Nov 18, 2013 add by: fangsj
     */
    public boolean setRedisStrValue(String key, String value, int seconds)
    {

        boolean flag = true;// 返回标记,默认成功

        // 如果设置时间为负数,则无上限时间
        if (seconds <= 0)
        {
            this.setRedisStrValue(key, value);
            return flag;
        }

        Jedis jedis = null;// 声明一个链接对象

        try
        {
            jedis = this.getResource();// 获取资源

            // 资源不为空则执行注入操作 否则返回注入失败
            if (jedis != null)
            {
                // 判断是否已经存在,如果已经存在则删除
                if (jedis.exists(key))
                {
                    jedis.del(key);
                }
                // 该方法内容为,如果含有相同的key值,则不覆盖.
                jedis.setex(key, seconds, value);
            }
            else
                flag = false;
        }
        finally
        {
            // 归还资源
            if (jedis != null) this.returnResource(jedis);
        }
        return flag;
    }


    /**
     * 方法描述:删除redis中的缓存
     * 
     * @param keys 缓存的key值
     * @return 返回是否成功,成功:true 失败:false date:Nov 18, 2013 add by: fangsj
     */
    public boolean delRedisStrValue(String... keys)
    {

        Jedis jedis = null;// 声明一个链接对象
        boolean flag = true;// 返回标记,默认成功
        try
        {
            jedis = this.getResource();// 获取资源

            // 资源不为空则执行删除操作 否则返回注入失败
            if (jedis != null)
                jedis.del(keys);
            else
                flag = false;
        }
        finally
        {
            // 归还资源
            if (jedis != null) this.returnResource(jedis);
        }
        return flag;
    }


    /**
     * 方法描述:根据关键字从redis服务器中获取对应的value
     * 
     * @param key 键值
     * @return 存储在redis中的value date:Nov 14, 2013 add by: fangsj
     */
    public List<String> getRedisStrValue(String... key)
    {

        Jedis jedis = null;// 声明一个链接对象
        List<String> value = null;// 获取的键值所对应的值

        try
        {
            jedis = this.getResource();// 获取jedis资源

            // 资源不为空,则获取对应的value
            if (jedis != null) value = jedis.mget(key);

        }
        finally
        {
            if (jedis != null) this.returnResource(jedis);
        }
        return value;
    }
}
