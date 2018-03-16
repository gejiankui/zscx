package org.zyd.service.convertor;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.*;
import org.zyd.domain.bean.PugInfoBean;
import org.zyd.domain.bean.UserInfoBean;
import org.zyd.domain.factory.PugInfoFactory;
import org.zyd.domain.factory.UserInfoFactory;
import org.zyd.service.dto.MentoringRelationshipDto;
import org.zyd.service.dto.PugInfoDto;
import org.zyd.service.dto.UserInfoDto;
import org.zyd.service.inf.PugInf;
import org.zyd.store.entity.MentoringRelationshipEntity;

import java.util.ArrayList;
import java.util.List;

public class PugInfoConvertor {
	@Autowired
	private PugInfoFactory pugInfoFactory;
	@Autowired
	private UserInfoConvertor userInfoConvertor;
	@Autowired
	private ReferencesInfoConvertor referencesInfoConvertor;

	public PugInfoDto convertPugInfo(PugInfoBean bean) {
		if (null == bean) {
			return null;
		}
		PugInfoDto dto = new PugInfoDto();
		dto.setPugId(bean.getPugId());
		dto.setPugName(bean.getPugName());
		dto.setPugFullSpell(bean.getPugFullSpell());
		dto.setPugSimpleSpell(bean.getPugSimpleSpell());
		dto.setThumbImg(bean.getThumbImg());
		dto.setPugImg(bean.getPugImg());
		dto.setCategoryId(bean.getCategoryId());
		dto.setCategoryName(bean.getCategoryName());
		dto.setIntroduction(bean.getIntroduction());
		dto.setCreateBy(bean.getCreateBy());
		dto.setUpdateBy(bean.getUpdateBy());
		dto.setReferencesInfoDtos(referencesInfoConvertor.convertReferencesInfo(bean.getReferencesInfo()));
		dto.setSpecialThanksDtos(userInfoConvertor.convertUserInfoToDto(bean.getSpecialThanks()));
		return dto;
	}

	public PugInfoBean convertPugInfo(PugInfoDto dto) {
		if (null == dto) {
			return null;
		}
		PugInfoBean bean = pugInfoFactory.createPugInfoBean();
		bean.setPugId(dto.getPugId());
		bean.setPugName(dto.getPugName());
		bean.setPugFullSpell(dto.getPugFullSpell());
		bean.setPugSimpleSpell(dto.getPugSimpleSpell());
		bean.setThumbImg(dto.getThumbImg());
		bean.setPugImg(dto.getPugImg());
		bean.setCategoryId(dto.getCategoryId());
		bean.setCategoryName(dto.getCategoryName());
		bean.setIntroduction(dto.getIntroduction());
		bean.setCreateBy(dto.getCreateBy());
		bean.setUpdateBy(dto.getUpdateBy());
		return bean;
	}

}
