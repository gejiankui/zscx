package org.zyd.web.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zyd.common.constants.UserType;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.UserSearchVo;
import org.zyd.service.dto.UserCategoryDto;
import org.zyd.service.dto.UserInfoDto;
import org.zyd.service.inf.UserInf;
import org.zyd.web.BaseController;

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
		UserSearchVo vo = new UserSearchVo();
		vo.setUserName(sp);
		vo.setUserFullSpell(sp);
		vo.setUserSimpleSpell(sp);
		vo.setUserType(UserType.A0300020.name());
		try {
			List<UserInfoDto> data = userInf.queryUserInfos(vo);
			respMap.put("status", 0);
			respMap.put("data", CollectionUtils.isEmpty(data) ? new ArrayList<UserInfoDto>() : data);
		} catch (ZydException e) {
			respMap.put("status", 1);
			respMap.put("msg", e.getErrorCode().getDesc());
		}
		return respMap;
	}

	@RequestMapping("/getUserWithMR")
	@ResponseBody
	public Map<String, Object> getUserWithMR(Integer uId) {
		if (uId == null) {
			return null;
		}
		Map<String, Object> respMap = new HashMap<String, Object>();
		try {
			UserInfoDto data = userInf.queryUserInfoWithMentoringRel(uId);
			if (data != null && data.getIsDead() == 1) {
				data.setBirthday(StringUtils.isEmpty(data.getBirthday()) ? null : data.getBirthday().substring(0, 4));
				data.setDeathTime(StringUtils.isEmpty(data.getDeathTime()) ? null : data.getDeathTime().substring(0, 4));
			}
			respMap.put("status", 0);
			respMap.put("data", data);
		} catch (ZydException e) {
			respMap.put("status", 1);
			respMap.put("msg", e.getErrorCode().getDesc());
		}
		return respMap;
	}

	@RequestMapping("/getUser")
	@ResponseBody
	public Map<String, Object> getUser(Integer uId) {
		if (uId == null) {
			return null;
		}
		Map<String, Object> respMap = new HashMap<String, Object>();
		try {
			UserInfoDto data = userInf.queryUserInfo(uId);
			respMap.put("status", 0);
			respMap.put("data", data);
		} catch (ZydException e) {
			respMap.put("status", 1);
			respMap.put("msg", e.getErrorCode().getDesc());
		}
		return respMap;
	}

	@RequestMapping("/getUserCategory")
	@ResponseBody
	public Map<String, Object> getUserCategory() {
		Map<String, Object> respMap = new HashMap<String, Object>();
		try {
			List<UserCategoryDto> data = userInf.queryUserCategory();
			respMap.put("status", 0);
			respMap.put("data", data);
		} catch (ZydException e) {
			respMap.put("status", 1);
			respMap.put("msg", e.getErrorCode().getDesc());
		}
		return respMap;
	}

	@RequestMapping("/getUserByCid")
	@ResponseBody
	public Map<String, Object> getUserByCid(Integer cId) {
		Map<String, Object> respMap = new HashMap<String, Object>();
		try {
			List<UserInfoDto> data = userInf.queryUserByCategoryId(cId);
			respMap.put("status", 0);
			respMap.put("data", data);
		} catch (ZydException e) {
			respMap.put("status", 1);
			respMap.put("msg", e.getErrorCode().getDesc());
		}
		return respMap;
	}

}
