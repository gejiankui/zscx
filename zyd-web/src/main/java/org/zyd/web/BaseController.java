package org.zyd.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.zyd.web.constants.CommonConstants;
import org.zyd.web.security.password.ZydPwdUserDetails;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;

public abstract class BaseController {

    protected static final Logger log = LoggerFactory.getLogger(BaseController.class);

    protected BigDecimal getPartyId() {
        ZydPwdUserDetails party = (ZydPwdUserDetails) getSession().getAttribute(CommonConstants.USER_SESSION_KEY);
        return party.getPartyId();
    }

    protected HttpSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request.getSession();
    }

}
