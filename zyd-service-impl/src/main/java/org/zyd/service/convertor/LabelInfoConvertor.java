package org.zyd.service.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.domain.bean.LabelInfoBean;
import org.zyd.domain.factory.LabelInfoFactory;
import org.zyd.service.dto.LabelInfoDto;

import java.util.ArrayList;
import java.util.List;

public class LabelInfoConvertor {
	@Autowired
	private LabelInfoFactory labelInfoFactory;

	public LabelInfoDto convertLabelInfo(LabelInfoBean bean) {
		if (null == bean) {
			return null;
		}
		LabelInfoDto dto = new LabelInfoDto();
		dto.setLabelId(bean.getLabelId());
		dto.setLabelName(bean.getLabelName());
		dto.setStyle(bean.getStyle());
		dto.setIntroduction(bean.getIntroduction());
		dto.setCreateBy(bean.getCreateBy());
		dto.setUpdateBy(bean.getUpdateBy());
		return dto;
	}

	public LabelInfoBean convertLabelInfo(LabelInfoDto dto) {
		if (null == dto) {
			return null;
		}
		LabelInfoBean bean = labelInfoFactory.createLabelInfoBean();
		bean.setLabelId(dto.getLabelId());
		bean.setLabelName(dto.getLabelName());
		bean.setStyle(dto.getStyle());
		bean.setIntroduction(dto.getIntroduction());
		bean.setCreateBy(dto.getCreateBy());
		bean.setUpdateBy(dto.getUpdateBy());
		return bean;
	}

	public List<LabelInfoBean> convertLabelInfoBean(List<LabelInfoDto> dtos) {
		if (CollectionUtils.isEmpty(dtos)) {
			return null;
		}
		List<LabelInfoBean> beans = new ArrayList();
		for (LabelInfoDto dto : dtos) {
			beans.add(this.convertLabelInfo(dto));
		}
		return beans;
	}

	public List<LabelInfoDto> convertLabelInfoDto(List<LabelInfoBean> beans) {
		if (CollectionUtils.isEmpty(beans)) {
			return null;
		}
		List<LabelInfoDto> dtos = new ArrayList();
		for (LabelInfoBean bean : beans) {
			dtos.add(this.convertLabelInfo(bean));
		}
		return dtos;
	}
}
