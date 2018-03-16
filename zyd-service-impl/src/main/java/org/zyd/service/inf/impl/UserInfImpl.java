package org.zyd.service.inf.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.common.util.Validator;
import org.zyd.common.vo.UserSearchVo;
import org.zyd.domain.bean.LabelInfoBean;
import org.zyd.domain.bean.UserInfoBean;
import org.zyd.domain.factory.UserInfoFactory;
import org.zyd.domain.repository.LabelRepos;
import org.zyd.domain.repository.UserRepos;
import org.zyd.service.convertor.UserInfoConvertor;
import org.zyd.service.dto.UserCategoryDto;
import org.zyd.service.dto.UserInfoDto;
import org.zyd.service.inf.UserInf;
import org.zyd.store.entity.UserCategoryEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfImpl implements UserInf {

	@Autowired
	private UserInfoFactory userInfoFactory;
	@Autowired
	private UserRepos userRepos;
	@Autowired
	private LabelRepos labelRepos;
	@Autowired
	private UserInfoConvertor userInfoConvertor;

	@Override
	public void createUser(UserInfoDto userInfoDto) throws ZydException {
		if (null == userInfoDto) {
			throw new IllegalArgumentException();
		}
		if (StringUtils.isEmpty(userInfoDto.getUserName())) {
			throw new ZydException(ErrorCode.EZYDE006);
		}
		//验证手机号
		if (StringUtils.isEmpty(userInfoDto.getPhone())) {
			UserInfoBean user = userRepos.queryUserInfoByPhone(userInfoDto.getPhone());
			if (user != null) {
				throw new ZydException(ErrorCode.EZYDE024);
			}

			if (!Validator.isMobile(userInfoDto.getPhone())) {
				throw new ZydException(ErrorCode.EZYDE003);
			}
		}
		UserInfoBean user = userInfoConvertor.convertUserInfo(userInfoDto);
		user.save();
	}

	@Override
	public UserInfoDto queryUserInfoWithMentoringRel(Integer userId) throws ZydException {
		if (null == userId) {
			throw new IllegalArgumentException();
		}
		UserInfoBean user = userRepos.queryUserInfoWithMentoringRelByUserId(userId);
		if (user == null) {
			return null;
		}
		user.setLabelInfoBeans(labelRepos.queryLabelInfoByUserId(userId));
		return userInfoConvertor.convertUserInfo(user);
	}

	@Override
	public UserInfoDto queryUserInfo(Integer userId) throws ZydException {
		if (null == userId) {
			throw new IllegalArgumentException();
		}
		UserInfoBean user = userRepos.queryUserInfoByKey(userId);
		if (user == null) {
			return null;
		}
		//		user.setLabelInfoBeans(labelRepos.queryLabelInfoByUserId(userId));
		return userInfoConvertor.convertUserInfo(user);
	}

	@Override
	public List<UserInfoDto> queryUserInfos(UserSearchVo searchVo) throws ZydException {
		if (null == searchVo) {
			throw new IllegalArgumentException();
		}
		List<UserInfoBean> users = userRepos.queryUsers(searchVo);
		if (CollectionUtils.isEmpty(users)) {
			return null;
		}
		List<UserInfoDto> dtos = new ArrayList<UserInfoDto>();
		for (UserInfoBean user : users) {
			user.setLabelInfoBeans(labelRepos.queryLabelInfoByUserId(user.getUserId()));
			dtos.add(userInfoConvertor.convertUserInfo(user));
		}
		return dtos;
	}

	@Override
	public List<UserInfoDto> queryUserByCategoryId(Integer cid) throws ZydException {
		if (null == cid) {
			throw new IllegalArgumentException();
		}
		List<UserInfoBean> users = userRepos.queryUserByCategoryId(cid);
		if (CollectionUtils.isEmpty(users)) {
			return null;
		}
		List<UserInfoDto> dtos = new ArrayList<UserInfoDto>();
		for (UserInfoBean user : users) {
			dtos.add(userInfoConvertor.convertUserInfo(user));
		}
		return dtos;
	}

	@Override
	public List<UserCategoryDto> queryUserCategory() throws ZydException {
		List<UserCategoryEntity> categories = userRepos.queryUserCategory();
		if (CollectionUtils.isEmpty(categories)) {
			return null;
		}
		return userInfoConvertor.convertUserCategoryToDto(categories);
	}

	@Override
	public void updateUserInfo(UserInfoDto userInfoDto) throws ZydException {
		if (null == userInfoDto) {
			throw new IllegalArgumentException();
		}
		if (userInfoDto.getUserId() == null) {
			throw new ZydException(ErrorCode.EZYDE025);
		}
		if (StringUtils.isEmpty(userInfoDto.getPhone())) {
			UserInfoBean user = userRepos.queryUserInfoByPhone(userInfoDto.getPhone());
			if (user != null && user.getUserId() != userInfoDto.getUserId()) {
				throw new ZydException(ErrorCode.EZYDE024);
			}
			if (!Validator.isMobile(userInfoDto.getPhone())) {
				throw new ZydException(ErrorCode.EZYDE003);
			}
		}
		UserInfoBean user = userInfoConvertor.convertUserInfo(userInfoDto);
		user.change();
	}

	@Override
	public void removeUserInfo(Integer userId) throws ZydException {
		if (null == userId) {
			throw new IllegalArgumentException();
		}
		UserInfoBean user = userInfoFactory.createUserInfoBean();
		user.setUserId(userId);
		user.remove();
	}

	@Override
	public void apprentice(Integer userId, Integer masterId, Date beginTime) throws ZydException {
		if (userId == null || masterId == null) {
			throw new IllegalArgumentException();
		}
		UserInfoBean user = userRepos.queryUserInfoByKey(userId);
		if (user == null) {
			throw new ZydException(ErrorCode.EZYDE013);
		}
		UserInfoBean master = userRepos.queryUserInfoByKey(masterId);
		if (master == null) {
			throw new ZydException(ErrorCode.EZYDE040);
		}
		user.apprentice(masterId, beginTime);
	}

}
