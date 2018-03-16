package org.zyd.service.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.ShapeInfoBean;
import org.zyd.domain.factory.ShapeInfoFactory;
import org.zyd.service.dto.ShapeInfoDto;

public class ShapeInfoConvertor {
	@Autowired
	private ShapeInfoFactory shapeInfoFactory;
	@Autowired
	private UserInfoConvertor userInfoConvertor;
	@Autowired
	private ReferencesInfoConvertor referencesInfoConvertor;

	public ShapeInfoDto convertShapeInfo(ShapeInfoBean bean) {
		if (null == bean) {
			return null;
		}
		ShapeInfoDto dto = new ShapeInfoDto();
		dto.setShapeId(bean.getShapeId());
		dto.setShapeName(bean.getShapeName());
		dto.setShapeFullSpell(bean.getShapeFullSpell());
		dto.setShapeSimpleSpell(bean.getShapeSimpleSpell());
		dto.setThumbImg(bean.getThumbImg());
		dto.setShapeImg(bean.getShapeImg());
		dto.setCategoryId(bean.getCategoryId());
		dto.setCategoryName(bean.getCategoryName());
		dto.setImgProvider(bean.getImgProvider());
		dto.setProviderId(bean.getProviderId());
		dto.setIntroduction(bean.getIntroduction());
		dto.setCreateBy(bean.getCreateBy());
		dto.setUpdateBy(bean.getUpdateBy());
		dto.setReferencesInfoDtos(referencesInfoConvertor.convertReferencesInfo(bean.getReferencesInfo()));
		dto.setSpecialThanksDtos(userInfoConvertor.convertUserInfoToDto(bean.getSpecialThanks()));
		return dto;
	}

	public ShapeInfoBean convertShapeInfo(ShapeInfoDto dto) {
		if (null == dto) {
			return null;
		}
		ShapeInfoBean bean = shapeInfoFactory.createShapeInfoBean();
		bean.setShapeId(dto.getShapeId());
		bean.setShapeName(dto.getShapeName());
		bean.setShapeFullSpell(dto.getShapeFullSpell());
		bean.setShapeSimpleSpell(dto.getShapeSimpleSpell());
		bean.setThumbImg(dto.getThumbImg());
		bean.setShapeImg(dto.getShapeImg());
		bean.setCategoryId(dto.getCategoryId());
		bean.setCategoryName(dto.getCategoryName());
		bean.setProviderId(dto.getProviderId());
		bean.setImgProvider(dto.getImgProvider());
		bean.setIntroduction(dto.getIntroduction());
		bean.setCreateBy(dto.getCreateBy());
		bean.setUpdateBy(dto.getUpdateBy());
		return bean;
	}

}
