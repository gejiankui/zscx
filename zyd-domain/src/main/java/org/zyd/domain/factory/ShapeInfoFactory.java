package org.zyd.domain.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.zyd.domain.bean.ShapeInfoBean;
import org.zyd.domain.bean.impl.ShapeInfoBeanImpl;
import org.zyd.store.entity.ShapeInfoEntity;

public class ShapeInfoFactory implements ApplicationContextAware {
	private ApplicationContext context;

	public ShapeInfoBean createShapeInfoBean() {
		return this.createShapeInfoBean(null);
	}

	public ShapeInfoBean createShapeInfoBean(ShapeInfoEntity entity) {
		ShapeInfoBeanImpl rlt = new ShapeInfoBeanImpl(entity);
		context.getAutowireCapableBeanFactory().autowireBean(rlt);

		return rlt;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
}
