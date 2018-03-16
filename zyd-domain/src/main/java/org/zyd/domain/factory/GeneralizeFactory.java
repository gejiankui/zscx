package org.zyd.domain.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.zyd.domain.bean.GeneralizeBean;
import org.zyd.domain.bean.impl.GeneralizeBeanImpl;
import org.zyd.store.entity.GeneralizeSettingEntity;

public class GeneralizeFactory implements ApplicationContextAware {
	private ApplicationContext context;

	public GeneralizeBean createGeneralizeBean() {
		return this.createGeneralizeBean(null);
	}

	public GeneralizeBean createGeneralizeBean(GeneralizeSettingEntity entity) {
		GeneralizeBeanImpl rlt = new GeneralizeBeanImpl(entity);
		context.getAutowireCapableBeanFactory().autowireBean(rlt);

		return rlt;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
}
