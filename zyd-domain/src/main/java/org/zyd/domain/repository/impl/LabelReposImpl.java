package org.zyd.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.LabelInfoBean;
import org.zyd.domain.factory.LabelInfoFactory;
import org.zyd.domain.repository.LabelRepos;
import org.zyd.store.entity.LabelInfoEntity;
import org.zyd.store.entity.UserLabelEntity;
import org.zyd.store.mapper.LabelInfoMapper;
import org.zyd.store.mapper.UserLabelMapper;
import org.zyd.store.term.LabelInfoTerm;
import org.zyd.store.term.UserLabelTerm;

import java.util.ArrayList;
import java.util.List;

public class LabelReposImpl implements LabelRepos {

	@Autowired
	private LabelInfoMapper labelInfoMapper;
	@Autowired
	private UserLabelMapper userLabelMapper;
	@Autowired
	private LabelInfoFactory labelInfoFactory;

	@Override
	public LabelInfoBean queryLabelInfoByKey(Integer labelId) throws ZydException {
		if (null == labelId) {
			throw new IllegalArgumentException();
		}
		LabelInfoTerm term = new LabelInfoTerm();
		term.setLabelId(labelId);
		List<LabelInfoEntity> entities = labelInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		return labelInfoFactory.createLabelInfoBean(entities.get(0));
	}

	@Override
	public List<LabelInfoBean> queryLabelInfoByUserId(Integer userId) throws ZydException {
		if (null == userId) {
			throw new IllegalArgumentException();
		}
		UserLabelTerm term = new UserLabelTerm();
		term.setUserId(userId);
		List<UserLabelEntity> entities = userLabelMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		List<Integer> ids = new ArrayList();
		for (UserLabelEntity entity : entities) {
			ids.add(entity.getLabelId());
		}
		List<LabelInfoEntity> labelInfos = labelInfoMapper.selectByKeys(ids);
		if (CollectionUtils.isEmpty(labelInfos)) {
			return null;
		}
		List<LabelInfoBean> beans = new ArrayList<LabelInfoBean>();
		for (LabelInfoEntity labelInfo : labelInfos) {
			beans.add(labelInfoFactory.createLabelInfoBean(labelInfo));
		}
		return beans;
	}

}
