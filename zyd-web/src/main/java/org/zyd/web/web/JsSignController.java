package org.zyd.web.web;

import com.xt.weixinapi.exception.WeiXinException;
import com.xt.weixinapi.helper.AccessTokenHelper;
import com.xt.weixinapi.helper.JsApiTicketHelper;
import com.xt.weixinapi.holder.AccessToken;
import com.xt.weixinapi.holder.JsApiTicket;
import com.xt.weixinapi.holder.JsSignPackge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zyd.web.BaseController;
import org.zyd.web.constants.CommonConstants;
import org.zyd.web.util.JedisUtil;

@Controller
@RequestMapping("/jsSign")
public class JsSignController extends BaseController {
	@Autowired
	private JedisUtil jedisUtil;


	@RequestMapping("/signature")
	@ResponseBody
	protected JsSignPackge getSignaturePackage(String url) {
		// 如果accessToken为空则重新获取Access Token
		try {
			String jsApiTicket = jedisUtil.getRedisStrValue(CommonConstants.REDIS_KEY_JSAPI_TICKET);
			if (StringUtils.isEmpty(jsApiTicket)) {
				String acctok = jedisUtil.getRedisStrValue(CommonConstants.REDIS_KEY_ACCESS_TOKEN);
				if (StringUtils.isEmpty(acctok)) {
					String accessTokenUrl = CommonConstants.WX_ACCESS_TOKEN_REQ_URL;
					AccessToken at = AccessTokenHelper.getAccessToken(accessTokenUrl);
					if (at != null && !StringUtils.isEmpty(at.getAccess_token())) {
						acctok = at.getAccess_token();
						jedisUtil.setRedisStrValue(CommonConstants.REDIS_KEY_ACCESS_TOKEN, acctok, 3600);
					}
				}
				String ticketUrl = CommonConstants.WX_JSAPI_TICKET_REQ_URL;
				StringBuffer sburl = new StringBuffer(ticketUrl);
				sburl.append(acctok).append("&type=jsapi");
				JsApiTicket jsApiT = JsApiTicketHelper.getJsApiTicket(sburl.toString());
				if (jsApiT != null && !StringUtils.isEmpty(jsApiT.getTicket())) {
					jsApiTicket = jsApiT.getTicket();
					jedisUtil.setRedisStrValue(CommonConstants.REDIS_KEY_JSAPI_TICKET, jsApiTicket, 3600);
				}
			}
			return JsApiTicketHelper.generateJsSignPackge(CommonConstants.WX_APP_ID, jsApiTicket, url);
		} catch (WeiXinException e) {
			log.error(e.getLocalizedMessage());
		}
		return null;
	}

}
