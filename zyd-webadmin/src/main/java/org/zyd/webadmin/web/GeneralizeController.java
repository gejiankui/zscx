package org.zyd.webadmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zyd.common.exception.ZydException;
import org.zyd.service.dto.GeneralizeSettingDto;
import org.zyd.service.inf.GeneralizeInf;
import org.zyd.webadmin.BaseController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/generalize")
public class GeneralizeController extends BaseController {
	@Autowired
	private GeneralizeInf generalizeInf;

	@RequestMapping("/queryGeneralizes")
	@ResponseBody
	public Map<String, Object> queryGeneralizes(Integer position) {
		if (position == null) {
			return null;
		}
		Map<String, Object> respMap = new HashMap<String, Object>();
		try {
			List<GeneralizeSettingDto> data = generalizeInf.queryGeneralizes(position);
			respMap.put("status", 0);
			respMap.put("data", data);
		} catch (ZydException e) {
			respMap.put("status", 1);
			respMap.put("msg", e.getErrorCode().getDesc());
		}
		return respMap;
	}
}
