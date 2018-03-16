package org.zyd.service.convertor;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.common.constants.CarouselFigureType;
import org.zyd.domain.bean.CarouselFigureBean;
import org.zyd.domain.factory.CarouselFigureFactory;
import org.zyd.service.dto.CarouselFigureDto;

public class CarouselFigureConvertor {
	@Autowired
	private CarouselFigureFactory carouselFigureFactory;

	public CarouselFigureDto convertCarouselFigure(CarouselFigureBean bean) {
		if (null == bean) {
			return null;
		}
		CarouselFigureDto dto = new CarouselFigureDto();

		dto.setFigureId(bean.getFigureId());
		dto.setImgAddr(bean.getImgAddr());
		dto.setJumpUrl(bean.getJumpUrl());
		dto.setBeginTime(bean.getBeginTime());
		dto.setEndTime(bean.getEndTime());
		dto.setFigureType(bean.getFigureType().getDesc());
		dto.setSort(bean.getSort());
		dto.setCreateBy(bean.getCreateBy());
		dto.setUpdateBy(bean.getUpdateBy());
		return dto;
	}

	public CarouselFigureBean convertCarouselFigure(CarouselFigureDto dto) {
		if (null == dto) {
			return null;
		}
		CarouselFigureBean bean = carouselFigureFactory.createCarouseFigureBean();

		bean.setFigureId(dto.getFigureId());
		bean.setImgAddr(dto.getImgAddr());
		bean.setJumpUrl(dto.getJumpUrl());
		bean.setBeginTime(dto.getBeginTime());
		bean.setEndTime(dto.getEndTime());
		bean.setFigureType(
				StringUtils.isEmpty(dto.getFigureType()) ? null : CarouselFigureType.valueOf(dto.getFigureType()));
		bean.setSort(dto.getSort());
		bean.setCreateBy(dto.getCreateBy());
		bean.setUpdateBy(dto.getUpdateBy());
		return bean;
	}

}
