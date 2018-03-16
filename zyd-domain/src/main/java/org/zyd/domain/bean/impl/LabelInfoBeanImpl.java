package org.zyd.domain.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.LabelInfoBean;
import org.zyd.domain.bean.LabelInfoBean;
import org.zyd.store.entity.LabelInfoEntity;
import org.zyd.store.entity.LabelInfoEntity;
import org.zyd.store.entity.ReferencesInfoEntity;
import org.zyd.store.entity.UserInfoEntity;
import org.zyd.store.mapper.LabelInfoMapper;

import java.util.ArrayList;
import java.util.List;

public class LabelInfoBeanImpl implements LabelInfoBean {

	private LabelInfoEntity entity;
	
	@Autowired
	private LabelInfoMapper labelInfoMapper;

	public LabelInfoBeanImpl(LabelInfoEntity entity) {
		this.entity = entity;
	}

	@Override
	public Integer getLabelId() {
		if (null == entity) {
			return null;
		}
		return entity.getLabelId();
	}

	@Override
	public String getLabelName() {
		if (null == entity) {
			return null;
		}
		return entity.getLabelName();
	}

	@Override
	public String getStyle() {
		if (null == entity) {
			return null;
		}
		return entity.getStyle();
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
	public void setLabelId(Integer labelId) {
		if (null == entity) {
			entity = new LabelInfoEntity();
		}
		entity.setLabelId(labelId);
	}

	@Override
	public void setLabelName(String labelName) {
		if (null == entity) {
			entity = new LabelInfoEntity();
		}
		entity.setLabelName(labelName);
	}

	@Override
	public void setStyle(String style) {
		if (null == entity) {
			entity = new LabelInfoEntity();
		}
		entity.setStyle(style);
	}

	@Override
	public void setIntroduction(String introduction) {
		if (null == entity) {
			entity = new LabelInfoEntity();
		}
		entity.setIntroduction(introduction);
	}

	@Override
	public void setCreateBy(String createBy) {
		if (null == entity) {
			entity = new LabelInfoEntity();
		}
		entity.setCreateBy(createBy);
	}

	@Override
	public void setUpdateBy(String updateBy) {
		if (null == entity) {
			entity = new LabelInfoEntity();
		}
		entity.setUpdateBy(updateBy);
	}

	@Override
	public void save() throws ZydException {
		try {
			labelInfoMapper.insert(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void change() throws ZydException {
		try {
			labelInfoMapper.updateBySelective(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void remove() throws ZydException {
		try {
			labelInfoMapper.delete(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}

		if (null != entity) {
			entity.setLabelId(null);
		}
	}
}
