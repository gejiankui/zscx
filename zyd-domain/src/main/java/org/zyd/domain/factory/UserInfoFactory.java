package org.zyd.domain.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.zyd.domain.bean.UserInfoBean;
import org.zyd.domain.bean.impl.UserInfoBeanImpl;
import org.zyd.store.entity.UserInfoEntity;

public class UserInfoFactory implements ApplicationContextAware {
	private ApplicationContext context;

	public UserInfoBean createUserInfoBean() {
		return this.createUserInfoBean(null);
	}

	public UserInfoBean createUserInfoBean(UserInfoEntity entity) {
		UserInfoBeanImpl rlt = new UserInfoBeanImpl(entity);
		context.getAutowireCapableBeanFactory().autowireBean(rlt);

		return rlt;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
}
