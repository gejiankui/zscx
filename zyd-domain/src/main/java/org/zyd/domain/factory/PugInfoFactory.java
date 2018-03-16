package org.zyd.domain.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.zyd.domain.bean.PugInfoBean;
import org.zyd.domain.bean.impl.PugInfoBeanImpl;
import org.zyd.store.entity.PugInfoEntity;

public class PugInfoFactory implements ApplicationContextAware {
	private ApplicationContext context;

	public PugInfoBean createPugInfoBean() {
		return this.createPugInfoBean(null);
	}

	public PugInfoBean createPugInfoBean(PugInfoEntity entity) {
		PugInfoBeanImpl rlt = new PugInfoBeanImpl(entity);
		context.getAutowireCapableBeanFactory().autowireBean(rlt);

		return rlt;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
}
