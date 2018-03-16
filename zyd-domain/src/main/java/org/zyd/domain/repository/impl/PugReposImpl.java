package org.zyd.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.PugSearchVo;
import org.zyd.domain.bean.PugInfoBean;
import org.zyd.domain.factory.PugInfoFactory;
import org.zyd.domain.repository.PugRepos;
import org.zyd.store.entity.*;
import org.zyd.store.mapper.*;
import org.zyd.store.term.PugInfoTerm;
import org.zyd.store.term.PugReferencesTerm;
import org.zyd.store.term.PugSpecialThanksTerm;
import org.zyd.store.term.ReferencesInfoTerm;

import java.util.ArrayList;
import java.util.List;

public class PugReposImpl implements PugRepos {

	@Autowired
	private PugInfoMapper pugInfoMapper;
	@Autowired
	private PugInfoFactory pugInfoFactory;
	@Autowired
	private ReferencesInfoMapper referencesInfoMapper;
	@Autowired
	private PugReferencesMapper pugReferencesMapper;
	@Autowired
	private PugSpecialThanksMapper pugSpecialThanksMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public PugInfoBean queryPugInfoByKey(Integer pugId) throws ZydException {
		if (null == pugId) {
			throw new IllegalArgumentException();
		}
		PugInfoTerm term = new PugInfoTerm();
		term.setPugId(pugId);
		List<PugInfoEntity> entities = pugInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		return pugInfoFactory.createPugInfoBean(entities.get(0));
	}

	@Override
	public PugInfoBean queryPugInfoWithRefInfoAndThanksByKey(Integer pugId) throws ZydException {
		if (null == pugId) {
			throw new IllegalArgumentException();
		}
		PugInfoTerm term = new PugInfoTerm();
		term.setPugId(pugId);
		List<PugInfoEntity> entities = pugInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		PugInfoBean pugInfoBean = pugInfoFactory.createPugInfoBean(entities.get(0));

		//参考文献
		PugReferencesTerm pugRefTerm = new PugReferencesTerm();
		pugRefTerm.setPugId(pugId);
		List<PugReferencesEntity> pugReferencesEntityList = pugReferencesMapper.select(pugRefTerm);
		if (!CollectionUtils.isEmpty(pugReferencesEntityList)) {
			List<Integer> refIds = new ArrayList<Integer>();
			for (PugReferencesEntity entity : pugReferencesEntityList) {
				refIds.add(entity.getRefId());
			}
			List<ReferencesInfoEntity> refInfos = referencesInfoMapper.selectByKeys(refIds);
			pugInfoBean.setReferencesInfo(refInfos);
		}

		//特别鸣谢
		PugSpecialThanksTerm pugSpecialThanksTerm = new PugSpecialThanksTerm();
		pugSpecialThanksTerm.setPugId(pugId);
		List<PugSpecialThanksEntity> pugSpecialThanksEntityList = pugSpecialThanksMapper.select(pugSpecialThanksTerm);
		if (!CollectionUtils.isEmpty(pugSpecialThanksEntityList)) {
			List<Integer> userIds = new ArrayList<Integer>();
			for (PugSpecialThanksEntity entity : pugSpecialThanksEntityList) {
				userIds.add(entity.getUserId());
			}
			List<UserInfoEntity> userInfos = userInfoMapper.selectByKeys(userIds);
			pugInfoBean.setSpecialThanks(userInfos);
		}
		return pugInfoBean;
	}

	@Override
	public PugInfoBean queryPugInfoByName(String pugName) throws ZydException {
		if (StringUtils.isEmpty(pugName)) {
			throw new IllegalArgumentException();
		}
		PugInfoTerm term = new PugInfoTerm();
		term.setPugName(pugName);
		List<PugInfoEntity> entities = pugInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		return pugInfoFactory.createPugInfoBean(entities.get(0));
	}

	@Override
	public List<PugInfoBean> queryPugs(PugSearchVo pugSearchVo) throws ZydException {
		if (null == pugSearchVo) {
			throw new IllegalArgumentException();
		}
		PugInfoTerm term = new PugInfoTerm();
		term.setPugName(pugSearchVo.getPugName());
		term.setPugFullSpell(pugSearchVo.getPugFullSpell());
		term.setPugSimpleSpell(pugSearchVo.getPugSimpleSpell());
		List<PugInfoEntity> entities = pugInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		List<PugInfoBean> rlt = new ArrayList<PugInfoBean>();
		for (PugInfoEntity entity : entities) {
			rlt.add(pugInfoFactory.createPugInfoBean(entity));
		}
		return rlt;
	}

}
