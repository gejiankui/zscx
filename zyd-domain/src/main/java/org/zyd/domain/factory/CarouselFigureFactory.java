package org.zyd.domain.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.zyd.domain.bean.CarouselFigureBean;
import org.zyd.domain.bean.impl.CarouselFigureBeanImpl;
import org.zyd.store.entity.CarouselFigureEntity;

public class CarouselFigureFactory implements ApplicationContextAware {
	private ApplicationContext context;

	public CarouselFigureBean createCarouseFigureBean() {
		return this.createCarouseFigureBean(null);
	}

	public CarouselFigureBean createCarouseFigureBean(CarouselFigureEntity entity) {
		CarouselFigureBeanImpl rlt = new CarouselFigureBeanImpl(entity);
		context.getAutowireCapableBeanFactory().autowireBean(rlt);

		return rlt;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
}
