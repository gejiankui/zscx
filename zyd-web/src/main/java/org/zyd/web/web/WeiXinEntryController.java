package org.zyd.web.web;

import com.xt.weixinapi.exception.WeiXinException;
import com.xt.weixinapi.helper.AccessTokenHelper;
import com.xt.weixinapi.helper.ReceiveHelper;
import com.xt.weixinapi.helper.SendHelper;
import com.xt.weixinapi.helper.UserHelper;
import com.xt.weixinapi.holder.AccessToken;
import com.xt.weixinapi.holder.event.CustomMenuEvent;
import com.xt.weixinapi.holder.event.SubscribeEvent;
import com.xt.weixinapi.holder.requset.TextMessage;
import com.xt.weixinapi.holder.response.Item;
import com.xt.weixinapi.holder.user.UserHolder;
import com.xt.weixinapi.util.MessageUtil;
import com.xt.weixinapi.util.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zyd.service.dto.WeixinReplyContentDto;
import org.zyd.service.inf.PugInf;
import org.zyd.service.inf.UserInf;
import org.zyd.service.inf.WeixinReplyContentInf;
import org.zyd.web.BaseController;
import org.zyd.web.constants.CommonConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 微信入口
 *
 * @author
 */
@Controller
@RequestMapping("/weixin")
public class WeiXinEntryController extends BaseController implements CommonConstants {
	@Autowired
	private WeixinReplyContentInf weixinReplyContentInf;

	/**
	 * 微信入口
	 *
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("/entry")
	public void entry(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if ("GET".equals(request.getMethod())) {
				this.validateGetRequest(request, response);
			}

			if ("POST".equals(request.getMethod())) {
				this.processPostRequest(request, response);
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	public void validateGetRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		String token = "zscx_ytkj";

		if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp)
				|| StringUtils.isEmpty(echostr) || StringUtils.isEmpty(token)) {
			response.sendRedirect("visit/main.do");
			return;
		}

		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(token, signature, timestamp, nonce)) {
			out.print(echostr);

		}
		try {
			out.close();
			out = null;
		} catch (Exception e) {
			out = null;
		}
	}

	/**
	 * (non-Javadoc)
	 *
	 * @throws WeiXinException
	 */
	public void processPostRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, WeiXinException {

		log.debug("processPostRequest Begin");
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding(UTF8);
		response.setCharacterEncoding(UTF8);

		// 调用核心业务类接收消息、处理消息
		String respMessage = parseAndProcRequest(request);
		log.debug("Resp Msg:\n" + respMessage);
		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		try {
			out.close();
			out = null;
		} catch (Exception e) {
			if (out != null) {
				out.close();
				out = null;
			}
		}
		log.debug("processPostRequest End");

	}

	private String parseAndProcRequest(HttpServletRequest request)
			throws WeiXinException {
		String respMsg = null;
		// xml请求解析
		Map<String, String> requestMap = MessageUtil.parseXml(request);
		// 事件请求
		if (ReceiveHelper.isEvent(requestMap)) {
			// 如果是订阅事件
			if (ReceiveHelper.isClickEvent(requestMap)) {
				CustomMenuEvent cme = ReceiveHelper
						.extractClickEvent(requestMap);
				String menuCode = cme.getEventKey();

				// 获取回复信息
				WeixinReplyContentDto reply = weixinReplyContentInf
						.queryOneMenucodeOrKeyword(menuCode,
								EVENT_ORIG_TYPE_MENU);

				reply = reply == null ? new WeixinReplyContentDto()
						: reply;

				return handleEventReplyContent(cme.getToUserName(),
						cme.getFromUserName(), reply);

			}
			// 关注
			else if (ReceiveHelper.isSubscribeEvent(requestMap)) {
				SubscribeEvent sube = ReceiveHelper
						.extractSubscribeEvent(requestMap);

				final String openId = sube.getFromUserName();

				List<WeixinReplyContentDto> replys = weixinReplyContentInf
						.getListByEventOrigType(EVENT_ORIG_TYPE_SUBSCRIBE);

				WeixinReplyContentDto replyContentHolder = replys == null
						|| replys.isEmpty() ? new WeixinReplyContentDto()
						: replys.get(0);

				return handleEventReplyContent(sube.getToUserName(),
						sube.getFromUserName(), replyContentHolder);
			}
		}
		// 消息请求
		if (ReceiveHelper.isMsg(requestMap)) {
			log.debug("is message request");
			// 如果是文本消息
			if (ReceiveHelper.isTextMsg(requestMap)) {
				log.debug("message is text");
				TextMessage reqTextObj = ReceiveHelper
						.extractTextMsg(requestMap);

				List<WeixinReplyContentDto> replies = weixinReplyContentInf
						.getListByEventOrigType(EVENT_ORIG_TYPE_MSG);

				if (replies == null || replies.isEmpty()) {
					return null;
				}

				for (WeixinReplyContentDto rc : replies) {
					if (reqTextObj.getContent().contains(rc.getTriggerKey())) {
						return handleTextReplyContent(reqTextObj, rc);
					}
				}
				WeixinReplyContentDto rc = weixinReplyContentInf
						.queryOneMenucodeOrKeyword(
								TRIGGER_KEY_OTHER_KEY_WORD,
								EVENT_ORIG_TYPE_MSG);
				rc = rc == null ? new WeixinReplyContentDto() : rc;
				return handleTextReplyContent(reqTextObj, rc);

			}
			// 其他消息
			else {
				log.debug("other message");
			}
		}

		return respMsg;
	}

	/**
	 * 回复内容
	 *
	 * @return
	 * @author fangsj
	 */
	private String handleTextReplyContent(TextMessage reqObj,
			WeixinReplyContentDto rc) {
		String replyMsg = null;
		if (REPLY_TYPE_TEXT.equals(rc.getReplyType())) {
			// If reply text
			replyMsg = SendHelper.respTextMsgViaXml(reqObj.getToUserName(),
					reqObj.getFromUserName(), rc.getReplyContent());
		}
		//		else if (REPLY_TYPE_IMAGE.equals(rc.getReplyType())) {
		//			// If reply graphics then need get graphics info
		//			List<NgWeiXinReplyGraphicHolder> graphics = replyGraphicService
		//					.getListByReplyOid(rc.getReplyOid());
		//
		//			List<Item> articles = convertGraphicToArticle(graphics, null);
		//
		//			replyMsg = SendHelper.respNewsMsgViaXml(reqObj.getToUserName(),
		//					reqObj.getFromUserName(), articles);
		//		}
		return replyMsg;
	}

	/**
	 * Handle Event Program Respones
	 *
	 * @param toUserName、fromUserName、ReplyContentHolder
	 * @return
	 * @throws
	 * @author fangsj
	 */
	//	private String handleEventReplyContent(String toUserName,
	//			String fromUserName, WeixinReplyContentDto rc,
	//			NgWeixinMenuHolder menuHolder) {
	//		String replyMsg = null;
	//		if (REPLY_TYPE_TEXT.equals(rc.getReplyType())) {
	//
	//			replyMsg = SendHelper.respTextMsgViaXml(toUserName, fromUserName,
	//					rc.getReplyContent());
	//		}
	//		//		else if (REPLY_TYPE_IMAGE.equals(rc.getReplyType())) {
	//		//			List<NgWeiXinReplyGraphicHolder> graphics = replyGraphicService
	//		//					.getListByReplyOid(rc.getReplyOid());
	//		//
	//		//			List<Item> articles = convertGraphicToArticle(graphics, menuHolder);
	//		//
	//		//			replyMsg = SendHelper.respNewsMsgViaXml(toUserName, fromUserName,
	//		//					articles);
	//		//		}
	//		return replyMsg;
	//	}

	/**
	 * Handle Event Program Respones
	 *
	 * @param toUserName
	 * @param fromUserName
	 * @param rc
	 * @return
	 * @throws
	 * @author fangsj
	 */
	private String handleEventReplyContent(String toUserName,
			String fromUserName, WeixinReplyContentDto rc) {
		String replyMsg = null;
		if (REPLY_TYPE_TEXT.equals(rc.getReplyType())) {

			replyMsg = SendHelper.respTextMsgViaXml(toUserName, fromUserName,
					rc.getReplyContent());
		}
		//		else if (REPLY_TYPE_IMAGE.equals(rc.getReplyType())) {
		//			List<NgWeiXinReplyGraphicHolder> graphics = replyGraphicService
		//					.getListByReplyOid(rc.getReplyOid());
		//
		//			List<Item> articles = convertGraphicToArticle(graphics, null);
		//
		//			replyMsg = SendHelper.respNewsMsgViaXml(toUserName, fromUserName,
		//					articles);
		//		}
		return replyMsg;
	}

	/**
	 * 图片和文字组合
	 *
	 * @return
	 * @author fangsj
	 */
	//	private List<Item> convertGraphicToArticle(
	//			List<NgWeiXinReplyGraphicHolder> graphics,
	//			NgWeixinMenuHolder menuHolder) {
	//		String picUrl = ctrlParamCacheService.getOneByCode(
	//				CTRL_PARAM_CODE_REPLY_PIC_NETWORK_PATH).getStringValue();
	//		List<Item> articles = new ArrayList<Item>();
	//		for (NgWeiXinReplyGraphicHolder rg : graphics) {
	//			String url = buildRelyDetailUrl(rg, menuHolder);
	//			Item article = new Item(rg.getTitle(), rg.getItDescr(), picUrl
	//					+ rg.getItUrl().substring(
	//					rg.getItUrl().lastIndexOf("\\") + 1), url);
	//			articles.add(article);
	//		}
	//		return articles;
	//	}

	/**
	 * @return
	 * @throws
	 * @author fangsj
	 */
	//	private String buildRelyDetailUrl(NgWeiXinReplyGraphicHolder rg,
	//			NgWeixinMenuHolder menuHolder) {
	//		String url = null;
	//
	//		if (org.apache.commons.lang.StringUtils.isNotEmpty(rg.getUrl())) {
	//			if (rg.getRelaId() != null) {
	//				url = this.appPath + rg.getUrl();
	//			} else {
	//				url = rg.getUrl();
	//			}
	//			if (menuHolder != null) {
	//				String menuName = "";
	//				try {
	//					menuName = URLEncoder
	//							.encode(menuHolder.getMenuName(), UTF8);
	//					if (url.lastIndexOf("?") != -1) {
	//						url += "&menuName=" + menuName;
	//					} else {
	//						url += "?menuName=" + menuName;
	//					}
	//				} catch (Exception e) {
	//					log.error(e.getLocalizedMessage());
	//				}
	//
	//			}
	//		}
	//		return url;
	//	}
}