package org.zyd.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.GeneralizeBean;
import org.zyd.domain.factory.GeneralizeFactory;
import org.zyd.domain.repository.GeneralizeRepos;
import org.zyd.store.entity.GeneralizeSettingEntity;
import org.zyd.store.mapper.GeneralizeSettingMapper;
import org.zyd.store.term.GeneralizeSettingTerm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeneralizeReposImpl implements GeneralizeRepos {

	@Autowired
	private GeneralizeSettingMapper generalizeSettingMapper;
	@Autowired
	private GeneralizeFactory generalizeFactory;

	@Override
	public GeneralizeBean queryGeneralizeByKey(Integer settingId) throws ZydException {
		if (null == settingId) {
			throw new IllegalArgumentException();
		}
		GeneralizeSettingTerm term = new GeneralizeSettingTerm();
		term.setSettingId(settingId);
		List<GeneralizeSettingEntity> entities = generalizeSettingMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		return generalizeFactory.createGeneralizeBean(entities.get(0));
	}

	@Override
	public GeneralizeBean queryGeneralizeByUser(Integer userId, Integer position) throws ZydException {
		if (null == userId || position == null) {
			throw new IllegalArgumentException();
		}
		GeneralizeSettingTerm term = new GeneralizeSettingTerm();
		term.setUserId(userId);
		term.setPosition(position);
		List<GeneralizeSettingEntity> entities = generalizeSettingMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		return generalizeFactory.createGeneralizeBean(entities.get(0));
	}

	@Override
	public List<GeneralizeBean> queryGeneralizes(Integer position) throws ZydException {
		if (position == null) {
			throw new IllegalArgumentException();
		}
		Date now = new Date();
		GeneralizeSettingTerm term = new GeneralizeSettingTerm();
		term.setPosition(position);
		term.setBeginTime(now);
		term.setEndTime(now);
		List<GeneralizeSettingEntity> entities = generalizeSettingMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		List<GeneralizeBean> rlt = new ArrayList<GeneralizeBean>();
		for (GeneralizeSettingEntity entity : entities) {
			rlt.add(generalizeFactory.createGeneralizeBean(entity));
		}
		return rlt;
	}

}