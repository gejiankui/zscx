package org.zyd.webadmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.PugSearchVo;
import org.zyd.service.dto.PugInfoDto;
import org.zyd.service.inf.PugInf;
import org.zyd.webadmin.BaseController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pug")
public class PugController extends BaseController {
	@Autowired
	private PugInf pugInf;

	@RequestMapping("/search")
	@ResponseBody
	public Map<String, Object> searchPug(String sp) {
		Map<String, Object> respMap = new HashMap<String, Object>();
		PugSearchVo vo = new PugSearchVo();
		vo.setPugName(sp);
		vo.setPugFullSpell(sp);
		vo.setPugSimpleSpell(sp);
		try {
			List<PugInfoDto> data = pugInf.queryPugInfos(vo);
			Map<String, List<PugInfoDto>> mapData = new HashMap<String, List<PugInfoDto>>();
			if (!CollectionUtils.isEmpty(data)) {
				for (PugInfoDto dto : data) {
					if (mapData.containsKey(dto.getCategoryName())){
						List<PugInfoDto> temp = mapData.get(dto.getCategoryName());
						temp.add(dto);
					} else {
						List<PugInfoDto> temp = new ArrayList<PugInfoDto>();
						temp.add(dto);
						mapData.put(dto.getCategoryName(), temp);
					}
				}
			}
			respMap.put("status", 0);
			respMap.put("data", mapData);
		} catch (ZydException e) {
			respMap.put("status", 1);
			respMap.put("msg", e.getErrorCode().getDesc());
		}
		return respMap;
	}

	@RequestMapping("/getPug")
	@ResponseBody
	public Map<String, Object> getPug(Integer pId) {
		if (pId == null) {
			return null;
		}
		Map<String, Object> respMap = new HashMap<String, Object>();
		try {
			PugInfoDto data = pugInf.queryPugInfoWithRefInfoAndThanksByKey(pId);
			respMap.put("status", 0);
			respMap.put("data", data);
		} catch (ZydException e) {
			respMap.put("status", 1);
			respMap.put("msg", e.getErrorCode().getDesc());
		}
		return respMap;
	}

}
