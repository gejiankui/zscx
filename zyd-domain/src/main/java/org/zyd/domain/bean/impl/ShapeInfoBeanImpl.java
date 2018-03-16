package org.zyd.domain.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.ShapeInfoBean;
import org.zyd.store.entity.ShapeInfoEntity;
import org.zyd.store.entity.ReferencesInfoEntity;
import org.zyd.store.entity.ShapeInfoEntity;
import org.zyd.store.entity.UserInfoEntity;
import org.zyd.store.mapper.ShapeInfoMapper;

import java.util.ArrayList;
import java.util.List;

public class ShapeInfoBeanImpl implements ShapeInfoBean {

	private ShapeInfoEntity entity;

	private List<ReferencesInfoEntity> referencesInfo;
	private List<UserInfoEntity> specialThanks;

	@Autowired
	private ShapeInfoMapper shapeInfoMapper;

	public ShapeInfoBeanImpl(ShapeInfoEntity entity) {
		this.entity = entity;
	}

	@Override
	public Integer getShapeId() {
		if (null == entity) {
			return null;
		}
		return entity.getShapeId();
	}

	@Override
	public String getShapeName() {
		if (null == entity) {
			return null;
		}
		return entity.getShapeName();
	}

	@Override
	public String getShapeFullSpell() {
		if (null == entity) {
			return null;
		}
		return entity.getShapeFullSpell();
	}

	@Override
	public String getShapeSimpleSpell() {
		if (null == entity) {
			return null;
		}
		return entity.getShapeSimpleSpell();
	}

	@Override
	public String getThumbImg() {
		if (null == entity) {
			return null;
		}
		return entity.getThumbImg();
	}

	@Override
	public String getShapeImg() {
		if (null == entity) {
			return null;
		}
		return entity.getShapeImg();
	}

	@Override
	public Integer getCategoryId() {
		if (null == entity) {
			return null;
		}
		return entity.getCategoryId();
	}

	@Override
	public String getCategoryName() {
		if (null == entity) {
			return null;
		}
		return entity.getCategoryName();
	}

	@Override
	public String getImgProvider() {
		if (null == entity){
			return null;
		}
		return entity.getImgProvider();
	}

	@Override
	public Integer getProviderId() {
		if (null == entity){
			return null;
		}
		return entity.getProviderId();
	}

	@Override
	public String getIntroduction() {
		if (null == entity) {
			return null;
		}
		return entity.getIntroduction();
	}

	@Override
	public String getCreateBy() {
		if (null == entity) {
			return null;
		}
		return entity.getCreateBy();
	}

	@Override
	public String getUpdateBy() {
		if (null == entity) {
			return null;
		}
		return entity.getUpdateBy();
	}

	@Override
	public void setShapeId(Integer shapeId) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setShapeId(shapeId);
	}

	@Override
	public void setShapeName(String shapeName) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setShapeName(shapeName);
	}

	@Override
	public void setShapeFullSpell(String shapeFullSpell) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setShapeFullSpell(shapeFullSpell);
	}

	@Override
	public void setShapeSimpleSpell(String shapeSimpleSpell) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setShapeSimpleSpell(shapeSimpleSpell);
	}

	@Override
	public void setThumbImg(String thumbImg) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setThumbImg(thumbImg);
	}

	@Override
	public void setShapeImg(String shapeImg) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setShapeImg(shapeImg);
	}

	@Override
	public void setCategoryId(Integer categoryId) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setCategoryId(categoryId);
	}

	@Override
	public void setCategoryName(String categoryName) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setCategoryName(categoryName);
	}

	@Override
	public void setImgProvider(String imgProvider) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setImgProvider(imgProvider);
	}

	@Override
	public void setProviderId(Integer providerId) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setProviderId(providerId);
	}

	@Override
	public void setIntroduction(String introduction) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setIntroduction(introduction);
	}

	@Override
	public void setCreateBy(String createBy) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setCreateBy(createBy);
	}

	@Override
	public void setUpdateBy(String updateBy) {
		if (null == entity) {
			entity = new ShapeInfoEntity();
		}
		entity.setUpdateBy(updateBy);
	}

	@Override
	public List<ReferencesInfoEntity> getReferencesInfo() {
		return referencesInfo;
	}

	@Override
	public List<UserInfoEntity> getSpecialThanks() {
		return specialThanks;
	}

	@Override
	public void setReferencesInfo(List<ReferencesInfoEntity> referencesInfo) {
		if (referencesInfo == null) {
			referencesInfo = new ArrayList<ReferencesInfoEntity>();
		}
		this.referencesInfo = referencesInfo;
	}

	@Override
	public void setSpecialThanks(List<UserInfoEntity> specialThanks) {
		if (specialThanks == null) {
			specialThanks = new ArrayList<UserInfoEntity>();
		}
		this.specialThanks = specialThanks;
	}

	@Override
	public void save() throws ZydException {
		try {
			shapeInfoMapper.insert(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void change() throws ZydException {
		try {
			shapeInfoMapper.updateBySelective(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void remove() throws ZydException {
		try {
			shapeInfoMapper.delete(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}

		if (null != entity) {
			entity.setShapeId(null);
		}
	}
}
