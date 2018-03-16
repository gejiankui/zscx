package org.zyd.webadmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zyd.common.constants.UserType;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.UserSearchVo;
import org.zyd.service.dto.UserInfoDto;
import org.zyd.service.inf.UserInf;
import org.zyd.webadmin.BaseController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private UserInf userInf;

	@RequestMapping("/search")
	@ResponseBody
	public Map<String, Object> searchUser(String sp) {
		if (StringUtils.isEmpty(sp)) {
			return null;
		}
		Map<String, Object> respMap = new HashMap<String, Object>();
		return respMap;
	}

	@RequestMapping("/getUserWithMR")
	@ResponseBody
	public Map<String, Object> getUserWithMR(Integer uId) {
		if (uId == null) {
			return null;
		}
		Map<String, Object> respMap = new HashMap<String, Object>();
		return respMap;
	}

	@RequestMapping("/getUser")
	@ResponseBody
	public Map<String, Object> getUser(Integer uId) {
		if (uId == null) {
			return null;
		}
		Map<String, Object> respMap = new HashMap<String, Object>();
		return respMap;
	}
}
