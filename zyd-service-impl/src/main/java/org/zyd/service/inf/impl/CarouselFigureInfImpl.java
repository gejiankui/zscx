package org.zyd.service.inf.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.zyd.common.constants.CarouselFigureType;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.CarouselFigureBean;
import org.zyd.domain.factory.CarouselFigureFactory;
import org.zyd.domain.repository.CarouselFigureRepos;
import org.zyd.service.convertor.CarouselFigureConvertor;
import org.zyd.service.dto.CarouselFigureDto;
import org.zyd.service.inf.CarouselFigureInf;

import java.util.ArrayList;
import java.util.List;

public class CarouselFigureInfImpl implements CarouselFigureInf {

	@Autowired
	private CarouselFigureFactory carouselFigureFactory;
	@Autowired
	private CarouselFigureRepos carouselFigureRepos;
	@Autowired
	private CarouselFigureConvertor carouselFigureConvertor;

	@Override
	public void createCarouselFigure(CarouselFigureDto carouselFigureDto) throws ZydException {
		if (null == carouselFigureDto) {
			throw new IllegalArgumentException();
		}
		if (carouselFigureDto.getBeginTime() == null) {
			throw new ZydException(ErrorCode.EZYDC002);
		}
		if (carouselFigureDto.getEndTime() == null) {
			throw new ZydException(ErrorCode.EZYDC003);
		}
		if (StringUtils.isEmpty(carouselFigureDto.getFigureType())) {
			throw new ZydException(ErrorCode.EZYDC001);
		}
		if (StringUtils.isEmpty(carouselFigureDto.getImgAddr())) {
			throw new ZydException(ErrorCode.EZYDC005);
		}
		if (StringUtils.isEmpty(carouselFigureDto.getJumpUrl())) {
			throw new ZydException(ErrorCode.EZYDC006);
		}
		CarouselFigureBean carouselFigureBean = carouselFigureConvertor.convertCarouselFigure(carouselFigureDto);
		carouselFigureBean.save();
	}

	@Override
	public List<CarouselFigureDto> queryCarouselFigure(CarouselFigureType figureType) throws ZydException {
		if (null == figureType) {
			throw new IllegalArgumentException();
		}
		List<CarouselFigureBean> carouselFigures = carouselFigureRepos.queryCarouseFigure(figureType.name());
		if (CollectionUtils.isEmpty(carouselFigures)) {
			return null;
		}
		List<CarouselFigureDto> dtos = new ArrayList<CarouselFigureDto>();
		for (CarouselFigureBean carouselFigure : carouselFigures) {
			dtos.add(carouselFigureConvertor.convertCarouselFigure(carouselFigure));
		}
		return dtos;
	}

	@Override
	public void updateCarouselFigure(CarouselFigureDto carouselFigureDto) throws ZydException {
		if (null == carouselFigureDto) {
			throw new IllegalArgumentException();
		}
		if (carouselFigureDto.getFigureId() == null) {
			throw new ZydException(ErrorCode.EZYDC007);
		}
		CarouselFigureBean carouselFigure = carouselFigureConvertor.convertCarouselFigure(carouselFigureDto);
		carouselFigure.change();
	}

	@Override
	public void removeCarouselFigure(Integer figureId) throws ZydException {
		if (null == figureId) {
			throw new IllegalArgumentException();
		}
		CarouselFigureBean carouselFigure = carouselFigureFactory.createCarouseFigureBean();
		carouselFigure.setFigureId(figureId);
		carouselFigure.remove();
	}

}
