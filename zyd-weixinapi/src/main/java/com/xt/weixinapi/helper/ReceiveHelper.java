package com.xt.weixinapi.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import org.apache.log4j.Logger;

import com.xt.weixinapi.exception.WeiXinException;
import com.xt.weixinapi.holder.event.CustomMenuEvent;
import com.xt.weixinapi.holder.event.LocationEvent;
import com.xt.weixinapi.holder.event.ScanCodeEvent;
import com.xt.weixinapi.holder.event.SubscribeEvent;
import com.xt.weixinapi.holder.event.UnsubscribeEvent;
import com.xt.weixinapi.holder.requset.ImageMessage;
import com.xt.weixinapi.holder.requset.LinkMessage;
import com.xt.weixinapi.holder.requset.LocationMessage;
import com.xt.weixinapi.holder.requset.TextMessage;
import com.xt.weixinapi.holder.requset.VideoMessage;
import com.xt.weixinapi.holder.requset.VoiceMessage;
import com.xt.weixinapi.util.MessageUtil;

public class ReceiveHelper {
	protected static final Logger LOG = Logger.getLogger(ReceiveHelper.class);

	public static boolean isEvent(Map<String, String> requestMap) {
		// 消息类型
		String msgType = requestMap.get("MsgType");

		if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
			return true;
		}

		return false;
	}

	public static boolean isMsg(Map<String, String> requestMap) {
		if (isLinkMsg(requestMap)) {
			return true;
		}
		if (isLocationMsg(requestMap)) {
			return true;
		}
		if (isVideoMsg(requestMap)) {
			return true;
		}
		if (isVoiceMsg(requestMap)) {
			return true;
		}
		if (isImageMsg(requestMap)) {
			return true;
		}
		if (isTextMsg(requestMap)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 判是否是用户扫描二维码时的事件推送
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static boolean isScanEvent(Map<String, String> requestMap)

	{
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 事件类型
		String eventType = requestMap.get("Event");

		// 用户扫描二维码时的事件推送
		if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)
				&& MessageUtil.EVENT_TYPE_SCAN.equals(eventType)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 获取用户扫描二维码时的事件
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static ScanCodeEvent extractScanEvent(Map<String, String> requestMap)
			throws WeiXinException {
		if (!isScanEvent(requestMap)) {
			String msgType = requestMap.get("MsgType");
			throw new WeiXinException("The request msgType(" + msgType
					+ ") is not a scan event!");
		}

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 发送时间
		long createTime = Long.parseLong(requestMap.get("CreateTime"));

		// 事件类型
		String eventType = requestMap.get("Event");

		// 事件KEY值，qrscene_为前缀，后面为二维码的参数值
		String eventKey = requestMap.get("EventKey");
		// 二维码的ticket，可用来换取二维码图片
		String ticket = requestMap.get("Ticket");

		// 用户扫描二维码时的事件对象
		ScanCodeEvent scan = new ScanCodeEvent(toUserName, fromUserName,
				createTime, msgType, eventType, eventKey, ticket);

		return scan;

	}

	/**
	 * 
	 * 判是否是上报地理位置事件
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static boolean isLocationEvent(Map<String, String> requestMap)

	{
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 事件类型
		String eventType = requestMap.get("Event");

		// 上报地理位置事件
		if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)
				&& MessageUtil.EVENT_TYPE_LOCATION.equals(eventType)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 获取上报地理位置事件
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static LocationEvent extractLocationEvent(
			Map<String, String> requestMap) throws WeiXinException {
		if (!isLocationEvent(requestMap)) {
			String msgType = requestMap.get("MsgType");
			throw new WeiXinException("The request msgType(" + msgType
					+ ") is not a location event!");
		}

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 发送时间
		long createTime = Long.parseLong(requestMap.get("CreateTime"));

		// 事件类型
		String eventType = requestMap.get("Event");

		// 地理位置纬度
		Long latitude = Long.parseLong(requestMap.get("Latitude").trim());
		// 地理位置经度
		Long longitude = Long.parseLong(requestMap.get("Longitude").trim());
		// 地理位置精度
		Long precision = Long.parseLong(requestMap.get("Precision").trim());
		// 上报地理位置事件对象
		LocationEvent location = new LocationEvent(toUserName, fromUserName,
				createTime, msgType, eventType, latitude, longitude, precision);
		return location;

	}

	/**
	 * 
	 * 判是否是菜单点击事件
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static boolean isClickEvent(Map<String, String> requestMap)
	{
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 事件类型
		String eventType = requestMap.get("Event");

		// 菜单点击事件
		if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)
				&& MessageUtil.EVENT_TYPE_CLICK.equals(eventType)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 获取菜单点击事件
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static CustomMenuEvent extractClickEvent(
			Map<String, String> requestMap) throws WeiXinException {
		if (!isClickEvent(requestMap)) {
			String msgType = requestMap.get("MsgType");
			throw new WeiXinException("The request msgType(" + msgType
					+ ") is not a click event!");
		}

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 发送时间
		long createTime = Long.parseLong(requestMap.get("CreateTime"));

		// 事件类型
		String eventType = requestMap.get("Event");

		// 跳转到URL的菜单点击不会上报
		String eventKey = requestMap.get("EventKey");
		CustomMenuEvent cust = new CustomMenuEvent(toUserName, fromUserName,
				createTime, msgType, eventType, eventKey);
		return cust;

	}

	/**
	 * 
	 * 判是否是取消订阅事件
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static boolean isUnsubscribeEvent(Map<String, String> requestMap)

	{
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 事件类型
		String eventType = requestMap.get("Event");

		// 取消订阅事件
		if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)
				&& MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals(eventType)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 获取取消关注事件
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static UnsubscribeEvent extractUnsubscribeEvent(
			Map<String, String> requestMap) throws WeiXinException {
		if (!isUnsubscribeEvent(requestMap)) {
			String msgType = requestMap.get("MsgType");
			throw new WeiXinException("The request msgType(" + msgType
					+ ") is not a unsubscribe event!");
		}
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 发送时间
		long createTime = Long.parseLong(requestMap.get("CreateTime"));

		// 事件类型
		String eventType = requestMap.get("Event");

		// 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
		UnsubscribeEvent unsub = new UnsubscribeEvent(toUserName, fromUserName,
				createTime, msgType, eventType);
		return unsub;

	}

	/**
	 * 
	 * 判是否是订阅事件
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static boolean isSubscribeEvent(Map<String, String> requestMap)

	{
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 事件类型
		String eventType = requestMap.get("Event");

		// 订阅事件
		if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)
				&& MessageUtil.EVENT_TYPE_SUBSCRIBE.equals(eventType)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 获取关注事件
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static SubscribeEvent extractSubscribeEvent(
			Map<String, String> requestMap) throws WeiXinException {
		if (!isSubscribeEvent(requestMap)) {
			String msgType = requestMap.get("MsgType");
			throw new WeiXinException("The request msgType(" + msgType
					+ ") is not a subscribe event!");
		}

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 发送时间
		long createTime = Long.parseLong(requestMap.get("CreateTime"));

		// 事件类型
		String eventType = requestMap.get("Event");
		// 二维码的ticket
		String ticket = requestMap.get("Ticket");
		// 扫描带参数二维码事件, 用户未关注时，进行关注后的事件推送
		String eventKey = requestMap.get("EventKey");

		// 关注事件对象
		SubscribeEvent sub = new SubscribeEvent(toUserName, fromUserName,
				createTime, msgType, eventType, eventKey, ticket);

		return sub;

	}

	/**
	 * 
	 * 判是否是链接消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static boolean isLinkMsg(Map<String, String> requestMap) {
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 链接消息
		if (MessageUtil.REQ_MESSAGE_TYPE_LINK.equals(msgType)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 获取链接消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static LinkMessage extractLinkMsg(Map<String, String> requestMap)
			throws WeiXinException {
		if (!isLinkMsg(requestMap)) {
			String msgType = requestMap.get("MsgType");
			throw new WeiXinException("The request msgType(" + msgType
					+ ") is not a link message!");
		}

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 发送时间
		long createTime = Long.parseLong(requestMap.get("CreateTime"));
		// 消息id
		long msgId = Long.parseLong(requestMap.get("MsgId"));

		// 消息标题
		String title = requestMap.get("Title");
		// 消息描述
		String description = requestMap.get("Description");
		// 消息链接
		String url = requestMap.get("Url");

		// 链接消息对象
		LinkMessage link = new LinkMessage(toUserName, fromUserName,
				createTime, msgType, msgId, title, description, url);
		return link;

	}

	/**
	 * 
	 * 判是否是地理位置消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static boolean isLocationMsg(Map<String, String> requestMap) {
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 地理位置消息
		if (MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equals(msgType)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 获取地理位置消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static LocationMessage extractLocationMsg(
			Map<String, String> requestMap) throws WeiXinException {
		if (!isLocationMsg(requestMap)) {
			String msgType = requestMap.get("MsgType");
			throw new WeiXinException("The request msgType(" + msgType
					+ ") is not a location message!");
		}

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 发送时间
		long createTime = Long.parseLong(requestMap.get("CreateTime"));
		// 消息id
		long msgId = Long.parseLong(requestMap.get("MsgId"));

		// 地理位置维度
		String location_X = requestMap.get("Location_X");
		// 地理位置经度
		String location_Y = requestMap.get("Location_Y");
		// 地图缩放大小
		String scale = requestMap.get("Scale");
		// 地理位置信息
		String label = requestMap.get("Label");

		// 地理位置消息对象
		LocationMessage location = new LocationMessage(toUserName,
				fromUserName, createTime, msgType, msgId, location_X,
				location_Y, scale, label);

		return location;
	}

	/**
	 * 
	 * 判是否是视频消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static boolean isVideoMsg(Map<String, String> requestMap) {
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 视频消息
		if (MessageUtil.REQ_MESSAGE_TYPE_VIDEO.equals(msgType)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 获取视频消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static VideoMessage extractVideoMsg(Map<String, String> requestMap)
			throws WeiXinException {
		if (!isVideoMsg(requestMap)) {
			String msgType = requestMap.get("MsgType");
			throw new WeiXinException("The request msgType(" + msgType
					+ ") is not a video message!");
		}

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 发送时间
		long createTime = Long.parseLong(requestMap.get("CreateTime"));
		// 消息id
		long msgId = Long.parseLong(requestMap.get("MsgId"));

		// 媒体ID
		String mediaId = requestMap.get("MediaId");
		// 视频消息缩略图的媒体ID
		String thumbMediaId = requestMap.get("ThumbMediaId");
		// 视频消息对象
		VideoMessage video = new VideoMessage(toUserName, fromUserName,
				createTime, msgType, msgId, mediaId, thumbMediaId);
		return video;
	}

	/**
	 * 
	 * 判是否是语音消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static boolean isVoiceMsg(Map<String, String> requestMap) {
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 语音消息
		if (MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(msgType)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 获取音频消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static VoiceMessage extractVoiceMsg(Map<String, String> requestMap)
			throws WeiXinException {
		if (!isVoiceMsg(requestMap)) {
			String msgType = requestMap.get("MsgType");
			throw new WeiXinException("The request msgType(" + msgType
					+ ") is not a voice message!");
		}

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 发送时间
		long createTime = Long.parseLong(requestMap.get("CreateTime"));
		// 消息id
		long msgId = Long.parseLong(requestMap.get("MsgId"));

		// 媒体ID
		String mediaId = requestMap.get("MediaId");
		// 语音格式
		String format = requestMap.get("Format");
		// 语音识别结果，UTF8编码
		String recognition = requestMap.get("Recognition");

		// 音频消息对象
		return new VoiceMessage(toUserName, fromUserName, createTime, msgType,
				msgId, mediaId, format, recognition);
	}

	/**
	 * 
	 * 判是否是图片消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static boolean isImageMsg(Map<String, String> requestMap) {
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 图片消息
		if (MessageUtil.REQ_MESSAGE_TYPE_IMAGE.equals(msgType)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * 获取图片消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static ImageMessage extractImageMsg(Map<String, String> requestMap)
			throws WeiXinException {
		if (!isImageMsg(requestMap)) {
			String msgType = requestMap.get("MsgType");
			throw new WeiXinException("The request msgType(" + msgType
					+ ") is not a image message!");
		}

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 发送时间
		long createTime = Long.parseLong(requestMap.get("CreateTime"));
		// 消息id
		long msgId = Long.parseLong(requestMap.get("MsgId"));
		// 图片Url
		String picUrl = requestMap.get("PicUrl");
		// 媒体ID
		String mediaId = requestMap.get("MediaId");

		// 图片消息对象
		ImageMessage img = new ImageMessage(toUserName, fromUserName,
				createTime, msgType, msgId, mediaId, picUrl);

		return img;
	}

	/**
	 * 
	 * 判是否是文本消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws
	 */
	public static boolean isTextMsg(Map<String, String> requestMap) {
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 文本消息
		if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) {
			return true;
		}

		return false;
	}

	/**
	 * 获取文本消息
	 * 
	 * @author liyur
	 * @param %param name% %param description%
	 * @return
	 * @throws WeiXinException
	 * 
	 */
	public static TextMessage extractTextMsg(Map<String, String> requestMap)
			throws WeiXinException {
		if (!isTextMsg(requestMap)) {
			String msgType = requestMap.get("MsgType");
			throw new WeiXinException("The request msgType(" + msgType
					+ ") is not a text message!");
		}

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 发送时间
		long createTime = Long.parseLong(requestMap.get("CreateTime"));
		// 消息id
		long msgId = Long.parseLong(requestMap.get("MsgId"));
		// 文本内容
		String content = requestMap.get("Content");
		// 文本消息对象
		TextMessage text = new TextMessage(toUserName, fromUserName,
				createTime, msgType, msgId, content);

		return text;
	}

	/**
	 * 18. * 验证签名 19. * 20. * @param signature 21. * @param timestamp 22. * @param
	 * nonce 23. * @return 24.
	 */
	public static boolean messageValidate(String token, String signature,
			String timestamp, String nonce) {
		/*
		 * if(null != token && !"".equals(token.trim())) { ReceiveManage.token =
		 * token; }
		 */
		String[] arr = new String[] { token, timestamp, nonce };
		// 将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;

		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		content = null;
		// 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}

	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}

}
