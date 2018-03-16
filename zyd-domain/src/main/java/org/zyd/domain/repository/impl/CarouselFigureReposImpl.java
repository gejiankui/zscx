package org.zyd.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.CarouselFigureBean;
import org.zyd.domain.bean.GeneralizeBean;
import org.zyd.domain.factory.CarouselFigureFactory;
import org.zyd.domain.repository.CarouselFigureRepos;
import org.zyd.store.entity.CarouselFigureEntity;
import org.zyd.store.entity.GeneralizeSettingEntity;
import org.zyd.store.mapper.CarouselFigureMapper;
import org.zyd.store.term.CarouselFigureTerm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarouselFigureReposImpl implements CarouselFigureRepos {

	@Autowired
	private CarouselFigureMapper carouselFigureMapper;
	@Autowired
	private CarouselFigureFactory carouselFigureFactory;

	@Override
	public List<CarouselFigureBean> queryCarouseFigure(String figureType) throws ZydException {
		if (StringUtils.isEmpty(figureType)) {
			throw new IllegalArgumentException();
		}
		Date now = new Date();
		CarouselFigureTerm term = new CarouselFigureTerm();
		term.setFigureType(figureType);
		term.setBeginTime(now);
		term.setEndTime(now);
		List<CarouselFigureEntity> entities = carouselFigureMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		List<CarouselFigureBean> rlt = new ArrayList<CarouselFigureBean>();
		for (CarouselFigureEntity entity : entities) {
			rlt.add(carouselFigureFactory.createCarouseFigureBean(entity));
		}
		return rlt;
	}

}