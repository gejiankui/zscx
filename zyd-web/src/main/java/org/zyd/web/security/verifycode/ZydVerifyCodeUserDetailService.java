package org.zyd.web.security.verifycode;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zyd.common.constants.CarouselFigureType;
import org.zyd.common.exception.ZydException;
import org.zyd.common.util.Validator;
import org.zyd.service.inf.UserInf;
import org.zyd.web.security.ZydUserDetails;

public class ZydVerifyCodeUserDetailService implements UserDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(ZydVerifyCodeUserDetailService.class);
	
	@Autowired
	private UserInf userInf;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		if (!Validator.isMobile(username)) {
			throw new UsernameNotFoundException("请输入合法的手机号码");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
//		try {
//			PartyAccountDto account = userInf.queryPartyAccountDto(username);
//
//			if (null == account) {
//				throw new UsernameNotFoundException("手机号码" + username + "未注册");
//			}
//
//			if (CarouselFigureType.A0900020.equals(account.getAcntStatus())) {
//				return new ZydUserDetails(username, null, true, true, true, false, authorities, account.getPartyId());
//			}
//
//			return new ZydUserDetails(username, "0000", authorities, account.getPartyId());
//
//		} catch (ZydException e) {
//			log.error(e.getMessage(), e);
//
//			return null;
//		}
		return null;
	}

}
