package org.zyd.domain.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.zyd.domain.bean.LabelInfoBean;
import org.zyd.domain.bean.impl.LabelInfoBeanImpl;
import org.zyd.store.entity.LabelInfoEntity;

public class LabelInfoFactory implements ApplicationContextAware {
	private ApplicationContext context;

	public LabelInfoBean createLabelInfoBean() {
		return this.createLabelInfoBean(null);
	}

	public LabelInfoBean createLabelInfoBean(LabelInfoEntity entity) {
		LabelInfoBeanImpl rlt = new LabelInfoBeanImpl(entity);
		context.getAutowireCapableBeanFactory().autowireBean(rlt);

		return rlt;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
}
