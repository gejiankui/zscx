package org.zyd.service.inf.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.ShapeSearchVo;
import org.zyd.domain.bean.ShapeInfoBean;
import org.zyd.domain.factory.ShapeInfoFactory;
import org.zyd.domain.repository.ShapeRepos;
import org.zyd.service.convertor.ShapeInfoConvertor;
import org.zyd.service.dto.ShapeCategoryDto;
import org.zyd.service.dto.ShapeInfoDto;
import org.zyd.service.inf.ShapeInf;

import java.util.ArrayList;
import java.util.List;

public class ShapeInfImpl implements ShapeInf {

	@Autowired
	private ShapeInfoFactory shapeInfoFactory;
	@Autowired
	private ShapeRepos shapeRepos;
	@Autowired
	private ShapeInfoConvertor shapeInfoConvertor;

	@Override
	public void createShape(ShapeInfoDto shapeInfoDto) throws ZydException {
		if (null == shapeInfoDto) {
			throw new IllegalArgumentException();
		}
		if (StringUtils.isEmpty(shapeInfoDto.getShapeName())) {
			throw new ZydException(ErrorCode.EZYDS002);
		}
		//验证壶型名称
		ShapeInfoBean oldShape = shapeRepos.queryShapeInfoByName(shapeInfoDto.getShapeName());
		if (oldShape != null) {
			throw new ZydException(ErrorCode.EZYDS004);
		}
		ShapeInfoBean shape = shapeInfoConvertor.convertShapeInfo(shapeInfoDto);
		shape.save();
	}

	@Override
	public void createShapeCategory(ShapeCategoryDto shapeCategoryDto) throws ZydException {

	}

	@Override
	public ShapeInfoDto queryShapeInfo(Integer shapeId) throws ZydException {
		if (null == shapeId) {
			throw new IllegalArgumentException();
		}

		return shapeInfoConvertor.convertShapeInfo(shapeRepos.queryShapeInfoByKey(shapeId));
	}

	@Override
	public ShapeInfoDto queryShapeInfoWithRefInfoAndThanksByKey(Integer shapeId) throws ZydException {
		if (null == shapeId) {
			throw new IllegalArgumentException();
		}

		return shapeInfoConvertor.convertShapeInfo(shapeRepos.queryShapeInfoWithRefInfoAndThanksByKey(shapeId));
	}

	@Override
	public List<ShapeInfoDto> queryShapeInfos(ShapeSearchVo searchVo) throws ZydException {
		if (null == searchVo) {
			throw new IllegalArgumentException();
		}
		List<ShapeInfoBean> shapes = shapeRepos.queryShapes(searchVo);
		if (CollectionUtils.isEmpty(shapes)) {
			return null;
		}
		List<ShapeInfoDto> dtos = new ArrayList<ShapeInfoDto>();
		for (ShapeInfoBean shape : shapes) {
			dtos.add(shapeInfoConvertor.convertShapeInfo(shape));
		}
		return dtos;
	}

	@Override
	public void updateShapeInfo(ShapeInfoDto shapeInfoDto) throws ZydException {
		if (null == shapeInfoDto) {
			throw new IllegalArgumentException();
		}
		if (shapeInfoDto.getShapeId() == null) {
			throw new ZydException(ErrorCode.EZYDS007);
		}
		ShapeInfoBean shape = shapeInfoConvertor.convertShapeInfo(shapeInfoDto);
		shape.change();
	}

	@Override
	public void removeShapeInfo(Integer shapeId) throws ZydException {
		if (null == shapeId) {
			throw new IllegalArgumentException();
		}
		ShapeInfoBean shape = shapeInfoFactory.createShapeInfoBean();
		shape.setShapeId(shapeId);
		shape.remove();
	}

}
