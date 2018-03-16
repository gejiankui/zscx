package org.zyd.webadmin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.ShapeSearchVo;
import org.zyd.service.dto.ShapeInfoDto;
import org.zyd.service.inf.ShapeInf;
import org.zyd.webadmin.BaseController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shape")
public class ShapeController extends BaseController {
	@Autowired
	private ShapeInf shapeInf;

	@RequestMapping("/search")
	@ResponseBody
	public Map<String, Object> searchShape(String sp) {
		Map<String, Object> respMap = new HashMap<String, Object>();
		ShapeSearchVo vo = new ShapeSearchVo();
		vo.setShapeName(sp);
		vo.setShapeFullSpell(sp);
		vo.setShapeSimpleSpell(sp);
		try {
			List<ShapeInfoDto> data = shapeInf.queryShapeInfos(vo);
			Map<String, List<ShapeInfoDto>> mapData = new HashMap<String, List<ShapeInfoDto>>();
			if (!CollectionUtils.isEmpty(data)) {
				for (ShapeInfoDto dto : data) {
					if (mapData.containsKey(dto.getCategoryName())){
						List<ShapeInfoDto> temp = mapData.get(dto.getCategoryName());
						temp.add(dto);
					} else {
						List<ShapeInfoDto> temp = new ArrayList<ShapeInfoDto>();
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

	@RequestMapping("/getShape")
	@ResponseBody
	public Map<String, Object> getShape(Integer sId) {
		if (sId == null) {
			return null;
		}
		Map<String, Object> respMap = new HashMap<String, Object>();
		try {
			ShapeInfoDto data = shapeInf.queryShapeInfoWithRefInfoAndThanksByKey(sId);
			respMap.put("status", 0);
			respMap.put("data", data);
		} catch (ZydException e) {
			respMap.put("status", 1);
			respMap.put("msg", e.getErrorCode().getDesc());
		}
		return respMap;
	}

}
