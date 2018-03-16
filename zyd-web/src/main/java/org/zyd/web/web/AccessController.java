package org.zyd.web.web;

import com.xt.weixinapi.helper.AccessTokenHelper;
import com.xt.weixinapi.holder.AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.zyd.web.BaseController;
import org.zyd.web.constants.CommonConstants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Random;

/**
 * 登录操作
 *
 * @author Gejiankui
 */
@Controller
@RequestMapping("/visit")
public class AccessController extends BaseController {

	/**
	 * snsapi_base作用域的授权验证
	 *
	 * @return
	 */
	@RequestMapping("/access")
	public ModelAndView access(HttpServletRequest request) {
		String backUrl = request.getParameter("backUrl");

		log.info("-----------------------Auth2.0 handler ---------------------");

		log.info("Access via WEIXIN, jump to auto2.0 url to obtain openid");
		log.info("back url -->" + backUrl);

		Integer randomState = r(1000, 3000);
		String redirectUrl = CommonConstants.WX_AUTH_ACCESS_REQ_URL
				+ CommonConstants.WX_AUTH_ACCESS_CALLBACK_URL
				+ "&response_type=code&scope=snsapi_base&state=" + randomState + "#wechat_redirect";
		log.info("redirect url -->" + redirectUrl);
		request.getSession().setAttribute("BACK_URL", backUrl);
		request.getSession().setAttribute("STATE", randomState.toString());

		return new ModelAndView(new RedirectView(redirectUrl));
	}

	/**
	 * snsapi_base作用域的授权验证
	 *
	 * @return
	 */
	@RequestMapping("/baseAccess")
	public String baseAccess(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 基于snsapi_base的网页授权验证，用以判断此用户是否已经通过snsapi_userinfo授权验证
			String randomState = (String) request.getSession().getAttribute("STATE");
			String code = request.getParameter("code");
			String state = request.getParameter("state");
			log.info("-----------------------Call Back ---------------------");
			log.info("code -->" + code);
			log.info("state -->" + state);
			if (state == null || !randomState.equals(state)) {
				log.info("unauthorized request url --> response to error html");
			}
			// 通过code换取access_token

			// 因为使用的授权作用域为snsapi_base，此时取得access_token时也获得了用户openid
			String atUrl = CommonConstants.WX_AUTH_ACCESS_TOKEN_REQ_URL;
			String url = atUrl + code;
			log.info("token url -->" + url);
			AccessToken at = AccessTokenHelper.getAccessToken(url);

			log.info("access token = " + at.getAccess_token());
			log.info("expires in = " + at.getExpires_in());
			log.info("openid = " + at.getOpenid());
			log.info("refresh token = " + at.getRefresh_token());
			log.info("scope = " + at.getScope());

			response.addCookie(creatUserCookie(at.getOpenid(), request));

			// 若已存在则跳转访问链接
			String backUrl = (String) request.getSession().getAttribute("BACK_URL");

			// 初始CommonParameter对象

			return "redirect:" + backUrl;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return null;
		}
	}

	public int r(Integer min, Integer max) {
		Random random = new Random();

		int s = random.nextInt(max) % (max - min + 1) + min;
		return s;
	}

	// 创建客户端存储的cookie
	private Cookie creatUserCookie(String openId,
			HttpServletRequest request) throws IOException
	{
		log.info("creatUserCookie Begin");

		String ecodeValue = URLEncoder.encode(openId);
		Cookie userCookie = new Cookie("user", ecodeValue);
		userCookie.setMaxAge(2592000);
		userCookie.setPath(request.getContextPath());
		return userCookie;
	}

}
