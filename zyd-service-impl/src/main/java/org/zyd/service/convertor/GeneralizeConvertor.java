package org.zyd.service.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.GeneralizeBean;
import org.zyd.domain.factory.GeneralizeFactory;
import org.zyd.service.dto.GeneralizeSettingDto;

public class GeneralizeConvertor {
	@Autowired
	private GeneralizeFactory generalizeFactory;

	public GeneralizeSettingDto convertGeneralize(GeneralizeBean bean) {
		if (null == bean) {
			return null;
		}
		GeneralizeSettingDto dto = new GeneralizeSettingDto();

		dto.setSettingId(bean.getSettingId());
		dto.setUserId(bean.getUserId());
		dto.setUserName(bean.getUserName());
		dto.setBeginTime(bean.getBeginTime());
		dto.setEndTime(bean.getEndTime());
		dto.setSort(bean.getSort());
		dto.setPosition(bean.getPosition());
		dto.setCreateBy(bean.getCreateBy());
		dto.setUpdateBy(bean.getUpdateBy());
		return dto;
	}

	public GeneralizeBean convertGeneralize(GeneralizeSettingDto dto) {
		if (null == dto) {
			return null;
		}
		GeneralizeBean bean = generalizeFactory.createGeneralizeBean();

		bean.setSettingId(dto.getSettingId());
		bean.setUserId(dto.getUserId());
		bean.setUserName(dto.getUserName());
		bean.setBeginTime(dto.getBeginTime());
		bean.setEndTime(dto.getEndTime());
		bean.setSort(dto.getSort());
		bean.setPosition(dto.getPosition());
		bean.setCreateBy(dto.getCreateBy());
		bean.setUpdateBy(dto.getUpdateBy());
		return bean;
	}

}
