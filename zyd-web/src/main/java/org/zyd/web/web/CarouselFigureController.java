package org.zyd.web.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zyd.common.constants.CarouselFigureType;
import org.zyd.common.exception.ZydException;
import org.zyd.service.dto.CarouselFigureDto;
import org.zyd.service.dto.GeneralizeSettingDto;
import org.zyd.service.inf.CarouselFigureInf;
import org.zyd.service.inf.GeneralizeInf;
import org.zyd.web.BaseController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/carousel")
public class CarouselFigureController extends BaseController {
	@Autowired
	private CarouselFigureInf carouselFigureInf;

	@RequestMapping("/queryCarousels")
	@ResponseBody
	public Map<String, Object> queryCarousels(Integer figureType) {
		if (StringUtils.isEmpty(figureType)) {
			return null;
		}
		Map<String, Object> respMap = new HashMap<String, Object>();
		try {
			CarouselFigureType figureTypeEnum = figureType == 1 ?
					CarouselFigureType.A0600010 :
					figureType == 2 ? CarouselFigureType.A0600020 : null;
			List<CarouselFigureDto> data = carouselFigureInf.queryCarouselFigure(figureTypeEnum);
			respMap.put("status", 0);
			respMap.put("data", data);
		} catch (ZydException e) {
			respMap.put("status", 1);
			respMap.put("msg", e.getErrorCode().getDesc());
		}
		return respMap;
	}
}
