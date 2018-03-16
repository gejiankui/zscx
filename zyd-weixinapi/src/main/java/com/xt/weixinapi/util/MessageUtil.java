package com.xt.weixinapi.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.xt.weixinapi.holder.requset.ImageMessage;
import com.xt.weixinapi.holder.requset.LocationMessage;
import com.xt.weixinapi.holder.requset.VoiceMessage;
import com.xt.weixinapi.holder.response.Article;
import com.xt.weixinapi.holder.response.Item;
import com.xt.weixinapi.holder.response.MusicMessage;
import com.xt.weixinapi.holder.response.NewsMessage;
import com.xt.weixinapi.holder.response.TextMessage;
import com.xt.weixinapi.holder.response.VideoMessage;

/**
 * @author qinlei
 * @category 微信请求/响应类型，解析请求，文本/音乐/图文对象转微信格式XML
 * @version v1.0
 */
public class MessageUtil
{
    private static Logger log = Logger.getLogger(CertificateUtil.class);
    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

    /**
     * 返回消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：链接
     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

    /**
     * 请求消息类型：音频
     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：视频
     */
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_LOCATION = "LOCATION";

    /**
     * 事件类型：scan(已关注时的事件推送)
     */
    public static final String EVENT_TYPE_SCAN = "scan";


    /**
     * 解析微信发来的请求（XML）
     * 
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request)

    {
        // 将解析结果存储在HashMap中
        Map<String, String> map = null;

        // 从request中取得输入流
        InputStream inputStream = null;
        try
        {
            map = new HashMap<String, String>();

            inputStream = request.getInputStream();
            // 读取输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            // 得到xml根元素
            Element root = document.getRootElement();
            // 得到根元素的所有子节点
            List<Element> elementList = root.elements();

            // 遍历所有子节点
            for (Element e : elementList)
                map.put(e.getName(), e.getText());
        }
        catch (IOException e)
        {
            log.error("IO exception occurred");
            e.printStackTrace();
        }
        catch (DocumentException e)
        {
            log.error("Document exception occurred");
            e.printStackTrace();
        }
        finally
        {
            // 释放资源
            if (inputStream != null) try
            {
                inputStream.close();
            }
            catch (IOException e)
            {
                log.error("IO exception occurred");
                e.printStackTrace();
            }
        }

        return map;
    }


    @SuppressWarnings("unchecked")
    public static Map<String, Object> parseJSON(JSONObject json)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Object k : json.keySet())
        {
            Object v = json.get(k);
            // 如果内层还是数组的话，继续解析
            if (v instanceof JSONArray)
            {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator<JSONObject> it = ((JSONArray) v).iterator();
                while (it.hasNext())
                {
                    JSONObject json2 = it.next();
                    list.add(parseJSON(json2));
                }
                map.put(k.toString(), list);
            }
            else
            {
                map.put(k.toString(), v);
            }
        }
        return map;
    }


    /**
     * 文本消息对象转换成xml
     * 
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToXml(TextMessage textMessage)
    {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }


    /**
     * 文本消息对象转换成xml
     * 
     * @param imageMessage 文本消息对象
     * @return xml
     */
    public static String imageMessageToXml(ImageMessage imageMessage)
    {
        xstream.alias("xml", imageMessage.getClass());
        return xstream.toXML(imageMessage);
    }


    /**
     * 语音消息对象转换成xml
     * 
     * @param voiceMessage 语音消息对象
     * @return xml
     */
    public static String voiceMessageToXml(VoiceMessage voiceMessage)
    {
        xstream.alias("xml", voiceMessage.getClass());
        return xstream.toXML(voiceMessage);
    }


    /**
     * 视频消息对象转换成xml
     * 
     * @param videoMessage 视频消息对象
     * @return xml
     */
    public static String videoMessageToXml(VideoMessage videoMessage)
    {
        xstream.alias("xml", videoMessage.getClass());
        return xstream.toXML(videoMessage);
    }


    /**
     * 音乐消息对象转换成xml
     * 
     * @param musicMessage 音乐消息对象
     * @return xml
     */
    public static String musicMessageToXml(MusicMessage musicMessage)
    {
        xstream.alias("xml", musicMessage.getClass());
        return xstream.toXML(musicMessage);
    }


    /**
     * 图文消息对象转换成xml
     * 
     * @param newsMessage 图文消息对象
     * @return xml
     */
    public static String newsMessageToXml(NewsMessage newsMessage)
    {
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new Item().getClass());
        return xstream.toXML(newsMessage);
    }


    /**
     * 地理位置对象转换成xml
     * 
     * @param locationMessage 音乐消息对象
     * @return xml
     */
    public static String locationMessageToXml(LocationMessage locationMessage)
    {
        xstream.alias("xml", locationMessage.getClass());
        return xstream.toXML(locationMessage);
    }


    /**
     * 文本消息对象转换成json
     * 
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToJSON(TextMessage textMessage)
    {
        xstream.alias("json", textMessage.getClass());
        return xstream.toXML(textMessage);
    }


    /**
     * 语音消息对象转换成json
     * 
     * @param voiceMessage 语音消息对象
     * @return xml
     */
    public static String voiceMessageToJSON(VoiceMessage voiceMessage)
    {
        xstream.alias("json", voiceMessage.getClass());
        return xstream.toXML(voiceMessage);
    }


    /**
     * 视频消息对象转换成json
     * 
     * @param videoMessage 视频消息对象
     * @return json
     */
    public static String videoMessageToJSON(VideoMessage videoMessage)
    {
        xstream.alias("json", videoMessage.getClass());
        return xstream.toXML(videoMessage);
    }


    /**
     * 音乐消息对象转换成json
     * 
     * @param musicMessage 音乐消息对象
     * @return json
     */
    public static String musicMessageToJSON(MusicMessage musicMessage)
    {
        xstream.alias("json", musicMessage.getClass());
        return xstream.toXML(musicMessage);
    }


    /**
     * 图文消息对象转换成json
     * 
     * @param newsMessage 图文消息对象
     * @return json
     */
    public static String newsMessageToJSON(NewsMessage newsMessage)
    {
        xstream.alias("json", newsMessage.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(newsMessage);
    }

    /**
     * 扩展xstream，使其支持CDATA块
     * 
     * @date 2013-05-19
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out)
        {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;


                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz)
                {
                    super.startNode(name, clazz);
                }


                protected void writeText(QuickWriter writer, String text)
                {
                    if (cdata)
                    {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    }
                    else
                    {
                        writer.write(text);
                    }
                }
            };
        }
    });
}