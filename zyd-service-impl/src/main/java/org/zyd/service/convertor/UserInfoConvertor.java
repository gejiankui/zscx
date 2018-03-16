package org.zyd.service.convertor;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.*;
import org.zyd.domain.bean.UserInfoBean;
import org.zyd.domain.factory.UserInfoFactory;
import org.zyd.service.dto.MentoringRelationshipDto;
import org.zyd.service.dto.UserCategoryDto;
import org.zyd.service.dto.UserInfoDto;
import org.zyd.store.entity.MentoringRelationshipEntity;
import org.zyd.store.entity.UserCategoryEntity;
import org.zyd.store.entity.UserInfoEntity;

import java.util.ArrayList;
import java.util.List;

public class UserInfoConvertor {
	@Autowired
	private UserInfoFactory userInfoFactory;
	@Autowired
	private LabelInfoConvertor labelInfoConvertor;

	public UserInfoDto convertUserInfo(UserInfoBean bean) {
		if (null == bean) {
			return null;
		}
		UserInfoDto dto = new UserInfoDto();
		dto.setUserId(bean.getUserId());
		dto.setUserName(bean.getUserName());
		dto.setUserFullSpell(bean.getUserFullSpell());
		dto.setUserSimpleSpell(bean.getUserSimpleSpell());
		dto.setUserNickname(bean.getUserNickname());
		dto.setPhone(bean.getPhone());
		dto.setAvatar(bean.getAvatar());
		dto.setUserImg(bean.getUserImg());
		dto.setUserSmallImg(bean.getUserSmallImg());
		dto.setGender(bean.getGender() == null ? null : bean.getGender().getDesc());
		dto.setIntroduction(bean.getIntroduction());
		dto.setBirthday(bean.getBirthday());
		dto.setIsDead(bean.getIsDead());
		dto.setDeathTime(bean.getDeathTime());
		dto.setIsTitle(bean.getIsTitle());
		dto.setJobTitle(bean.getJobTitle() == null ? null : bean.getJobTitle().getDesc());
		dto.setTitlePassDate(bean.getTitlePassDate());
		dto.setUserType(bean.getUserType() == null ? null : bean.getUserType().getDesc());
		dto.setIndustry(bean.getIndustry() == null ? null : bean.getIndustry().getDesc());
		dto.setWorkUnit(bean.getWorkUnit());
		dto.setHomeAddr(bean.getHomeAddr());
		dto.setWorkAddr(bean.getWorkAddr());
		dto.setCreateBy(bean.getCreateBy());
		dto.setUpdateBy(bean.getUpdateBy());
		dto.setMentoringRelationshipDtos(this.convertMentoringRel(bean.getMentoringRelationshipEntityList()));
		dto.setLabelInfoDtos(labelInfoConvertor.convertLabelInfoDto(bean.getLabelInfoBeans()));
		return dto;
	}

	public List<MentoringRelationshipDto> convertMentoringRel(
			List<MentoringRelationshipEntity> mentoringRelationshipEntities) {
		if (CollectionUtils.isEmpty(mentoringRelationshipEntities)) {
			return null;
		}
		List<MentoringRelationshipDto> rlt = new ArrayList<MentoringRelationshipDto>();
		for (MentoringRelationshipEntity entity : mentoringRelationshipEntities) {
			MentoringRelationshipDto dto = new MentoringRelationshipDto();
			dto.setUserId(entity.getUserId());
			dto.setUserName(entity.getUserName());
			dto.setBeginTime(entity.getBeginTime());
			dto.setCreateBy(entity.getCreateBy());
			dto.setEndTime(entity.getEndTime());
			dto.setRelId(entity.getRelId());
			dto.setRelUserId(entity.getRelUserId());
			dto.setRelType(StringUtils.isEmpty(entity.getRelType()) ?
					null :
					MentoringRelType.valueOf(entity.getRelType()).getDesc());
			dto.setRelUserName(entity.getRelUserName());
			dto.setRelUserAvatar(entity.getRelUserAvatar());
			rlt.add(dto);
		}
		return rlt;
	}

	public UserInfoBean convertUserInfo(UserInfoDto dto) {
		if (null == dto) {
			return null;
		}
		UserInfoBean bean = userInfoFactory.createUserInfoBean();
		bean.setUserId(dto.getUserId());
		bean.setUserName(dto.getUserName());
		bean.setUserFullSpell(dto.getUserFullSpell());
		bean.setUserSimpleSpell(dto.getUserSimpleSpell());
		bean.setUserNickname(dto.getUserNickname());
		bean.setPhone(dto.getPhone());
		bean.setAvatar(dto.getAvatar());
		bean.setUserImg(dto.getUserImg());
		bean.setUserSmallImg(dto.getUserSmallImg());
		bean.setGender(StringUtils.isEmpty(dto.getGender()) ? null : Gender.valueOf(dto.getGender()));
		bean.setIntroduction(dto.getIntroduction());
		bean.setBirthday(dto.getBirthday());
		bean.setIsDead(dto.getIsDead());
		bean.setDeathTime(dto.getDeathTime());
		bean.setIsTitle(dto.getIsTitle());
		bean.setJobTitle(StringUtils.isEmpty(dto.getJobTitle()) ? null : JobTitle.valueOf(dto.getJobTitle()));
		bean.setTitlePassDate(dto.getTitlePassDate());
		bean.setUserType(StringUtils.isEmpty(dto.getUserType()) ? null : UserType.valueOf(dto.getUserType()));
		bean.setIndustry(StringUtils.isEmpty(dto.getIndustry()) ? null : Industry.valueOf(dto.getIndustry()));
		bean.setLabelInfoBeans(labelInfoConvertor.convertLabelInfoBean(dto.getLabelInfoDtos()));
		bean.setWorkUnit(dto.getWorkUnit());
		bean.setHomeAddr(dto.getHomeAddr());
		bean.setWorkAddr(dto.getWorkAddr());
		bean.setCreateBy(dto.getCreateBy());
		bean.setUpdateBy(dto.getUpdateBy());
		return bean;
	}

	public List<UserInfoDto> convertUserInfoToDto(List<UserInfoEntity> entities) {
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		List<UserInfoDto> dtos = new ArrayList<UserInfoDto>();
		for (UserInfoEntity entity : entities) {
			UserInfoDto dto = new UserInfoDto();
			dto.setUserId(entity.getUserId());
			dto.setUserName(entity.getUserName());
			dto.setUserFullSpell(entity.getUserFullSpell());
			dto.setUserSimpleSpell(entity.getUserSimpleSpell());
			dto.setUserNickname(entity.getUserNickname());
			dto.setPhone(entity.getPhone());
			dto.setAvatar(entity.getAvatar());
			dto.setUserImg(entity.getUserImg());
			dto.setUserSmallImg(entity.getUserSmallImg());
			dto.setGender(entity.getGender());
			dto.setIntroduction(entity.getIntroduction());
			dto.setBirthday(entity.getBirthday());
			dto.setIsDead(entity.getIsDead());
			dto.setDeathTime(entity.getDeathTime());
			dto.setIsTitle(entity.getIsTitle());
			dto.setJobTitle(entity.getJobTitle());
			dto.setTitlePassDate(entity.getTitlePassDate());
			dto.setUserType(entity.getUserType());
			dto.setIndustry(entity.getIndustry());
			dto.setWorkUnit(entity.getWorkUnit());
			dto.setHomeAddr(entity.getHomeAddr());
			dto.setWorkAddr(entity.getWorkAddr());
			dto.setCreateBy(entity.getCreateBy());
			dto.setUpdateBy(entity.getUpdateBy());
			dtos.add(dto);
		}
		return dtos;
	}

	public List<UserCategoryDto> convertUserCategoryToDto(List<UserCategoryEntity> entities) {
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		List<UserCategoryDto> dtos = new ArrayList<UserCategoryDto>();
		for (UserCategoryEntity entity : entities) {
			UserCategoryDto dto = new UserCategoryDto();
			dto.setCategoryId(entity.getCategoryId());
			dto.setCategoryName(entity.getCategoryName());
			dto.setIntroduction(entity.getIntroduction());
			dto.setCreateBy(entity.getCreateBy());
			dto.setUpdateBy(entity.getUpdateBy());
			dtos.add(dto);
		}
		return dtos;
	}
}
