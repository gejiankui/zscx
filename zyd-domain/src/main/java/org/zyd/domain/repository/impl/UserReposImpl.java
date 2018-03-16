package org.zyd.domain.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.UserSearchVo;
import org.zyd.domain.bean.UserInfoBean;
import org.zyd.domain.factory.UserInfoFactory;
import org.zyd.domain.repository.UserRepos;
import org.zyd.store.entity.MentoringRelationshipEntity;
import org.zyd.store.entity.UserCategoryEntity;
import org.zyd.store.entity.UserInfoEntity;
import org.zyd.store.mapper.MentoringRelationshipMapper;
import org.zyd.store.mapper.UserCategoryMapper;
import org.zyd.store.mapper.UserInfoMapper;
import org.zyd.store.term.MentoringRelationshipTerm;
import org.zyd.store.term.UserInfoTerm;

public class UserReposImpl implements UserRepos {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private MentoringRelationshipMapper mentoringRelationshipMapper;
	@Autowired
	private UserInfoFactory userInfoFactory;
	@Autowired
	private UserCategoryMapper userCategoryMapper;

	@Override
	public UserInfoBean queryUserInfoByKey(Integer userId) throws ZydException {
		if (null == userId) {
			throw new IllegalArgumentException();
		}
		UserInfoTerm term = new UserInfoTerm();
		term.setUserId(userId);
		List<UserInfoEntity> entities = userInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		return userInfoFactory.createUserInfoBean(entities.get(0));
	}

	@Override
	public UserInfoBean queryUserInfoByPhone(String phoneNo) throws ZydException {
		if (StringUtils.isEmpty(phoneNo)) {
			throw new IllegalArgumentException();
		}
		UserInfoTerm term = new UserInfoTerm();
		term.setPhone(phoneNo);
		List<UserInfoEntity> entities = userInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		return userInfoFactory.createUserInfoBean(entities.get(0));
	}

	@Override
	public UserInfoBean queryUserInfoWithMentoringRelByUserId(Integer userId)
			throws ZydException {
		if (null == userId) {
			throw new IllegalArgumentException();
		}
		UserInfoTerm term = new UserInfoTerm();
		term.setUserId(userId);
		List<UserInfoEntity> entities = userInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		UserInfoBean userInfoBean = userInfoFactory.createUserInfoBean(entities.get(0));

		MentoringRelationshipTerm relationshipTerm = new MentoringRelationshipTerm();
		relationshipTerm.setUserId(userId);
		List<MentoringRelationshipEntity> mentoringRelationshipEntityList = mentoringRelationshipMapper
				.select(relationshipTerm);
		if (!CollectionUtils.isEmpty(mentoringRelationshipEntityList)) {
			List<Integer> ids = new ArrayList<Integer>();
			for (MentoringRelationshipEntity entity : mentoringRelationshipEntityList) {
				ids.add(entity.getRelUserId());
			}
			List<UserInfoEntity> users = userInfoMapper.selectByKeys(ids);
			Map<Integer,String> userAvatar = new HashMap<Integer, String>();
			if (!CollectionUtils.isEmpty(users)) {
				for (UserInfoEntity user : users) {
					userAvatar.put(user.getUserId(), user.getAvatar());
				}
			}
			for (MentoringRelationshipEntity entity : mentoringRelationshipEntityList) {
				entity.setRelUserAvatar(userAvatar.get(entity.getRelUserId()));
			}
		}
		userInfoBean.setMentoringRelationshipEntityList(mentoringRelationshipEntityList);
		return userInfoBean;
	}

	@Override
	public List<UserInfoBean> queryUsers(UserSearchVo queryParam) throws ZydException {
		if (null == queryParam) {
			throw new IllegalArgumentException();
		}
		UserInfoTerm term = new UserInfoTerm();
		term.setUserName(queryParam.getUserName());
		term.setUserFullSpell(queryParam.getUserFullSpell());
		term.setUserSimpleSpell(queryParam.getUserSimpleSpell());
		term.setUserType(queryParam.getUserType());
		List<UserInfoEntity> entities = userInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		List<UserInfoBean> rlt = new ArrayList<UserInfoBean>();
		for (UserInfoEntity entity : entities) {
			rlt.add(userInfoFactory.createUserInfoBean(entity));
		}
		return rlt;
	}

	@Override
	public List<UserCategoryEntity> queryUserCategory() throws ZydException {
		return userCategoryMapper.select(null);
	}

	@Override
	public List<UserInfoBean> queryUserByCategoryId(Integer cid) throws ZydException {
		if (null == cid) {
			throw new IllegalArgumentException();
		}
		List<UserInfoEntity> entities = userInfoMapper.selectByCategoryId(cid);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		List<UserInfoBean> rlt = new ArrayList<UserInfoBean>();
		for (UserInfoEntity entity : entities) {
			rlt.add(userInfoFactory.createUserInfoBean(entity));
		}
		return rlt;
	}
}
