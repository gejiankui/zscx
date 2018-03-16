package org.zyd.domain.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.common.constants.*;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.GeneralizeBean;
import org.zyd.store.entity.GeneralizeSettingEntity;
import org.zyd.store.mapper.GeneralizeSettingMapper;
import java.util.Date;

public class GeneralizeBeanImpl implements GeneralizeBean {

	private GeneralizeSettingEntity entity;

	@Autowired
	private GeneralizeSettingMapper generalizeSettingMapper;

	public GeneralizeBeanImpl(GeneralizeSettingEntity entity) {
		this.entity = entity;
	}

	@Override
	public Integer getSettingId() {
		if (null == entity) {
			return null;
		}
		return entity.getSettingId();
	}

	@Override
	public Integer getUserId() {
		if (null == entity) {
			return null;
		}
		return entity.getUserId();
	}

	@Override
	public String getUserName() {
		if (null == entity) {
			return null;
		}
		return entity.getUserName();
	}

	@Override
	public Date getBeginTime() {
		if (null == entity) {
			return null;
		}
		return entity.getBeginTime();
	}

	@Override
	public Date getEndTime() {
		if (null == entity) {
			return null;
		}
		return entity.getEndTime();
	}

	@Override
	public Integer getSort() {
		if (null == entity) {
			return null;
		}
		return entity.getSort();
	}

	@Override
	public Integer getPosition() {
		if (null == entity) {
			return null;
		}
		return entity.getPosition();
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
	public void setSettingId(Integer settingId) {
		if (null == entity) {
			entity = new GeneralizeSettingEntity();
		}
		entity.setSettingId(settingId);
	}

	@Override
	public void setUserId(Integer userId) {
		if (null == entity) {
			entity = new GeneralizeSettingEntity();
		}
		entity.setUserId(userId);
	}

	@Override
	public void setUserName(String userName) {
		if (null == entity) {
			entity = new GeneralizeSettingEntity();
		}
		entity.setUserName(userName);
	}

	@Override
	public void setBeginTime(Date beginTime) {
		if (null == entity) {
			entity = new GeneralizeSettingEntity();
		}
		entity.setBeginTime(beginTime);
	}

	@Override
	public void setEndTime(Date endTime) {
		if (null == entity) {
			entity = new GeneralizeSettingEntity();
		}
		entity.setEndTime(endTime);
	}

	@Override
	public void setSort(Integer sort) {
		if (null == entity) {
			entity = new GeneralizeSettingEntity();
		}
		entity.setSort(sort);
	}

	@Override
	public void setPosition(Integer position) {
		if (null == entity) {
			entity = new GeneralizeSettingEntity();
		}
		entity.setPosition(position);
	}

	@Override
	public void setCreateBy(String createBy) {
		if (null == entity) {
			entity = new GeneralizeSettingEntity();
		}
		entity.setCreateBy(createBy);
	}

	@Override
	public void setUpdateBy(String updateBy) {
		if (null == entity) {
			entity = new GeneralizeSettingEntity();
		}
		entity.setUpdateBy(updateBy);
	}

	@Override
	public void save() throws ZydException {
		try {
			generalizeSettingMapper.insert(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void change() throws ZydException {
		try {
			generalizeSettingMapper.updateBySelective(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void remove() throws ZydException {
		try {
			generalizeSettingMapper.delete(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}

		if (null != entity) {
			entity.setUserId(null);
		}
	}

}
