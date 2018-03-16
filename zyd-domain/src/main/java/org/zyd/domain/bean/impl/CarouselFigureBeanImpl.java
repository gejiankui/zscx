package org.zyd.domain.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.common.constants.CarouselFigureType;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.CarouselFigureBean;
import org.zyd.store.entity.CarouselFigureEntity;
import org.zyd.store.mapper.CarouselFigureMapper;

import java.util.Date;

public class CarouselFigureBeanImpl implements CarouselFigureBean {

	private CarouselFigureEntity entity;

	@Autowired
	private CarouselFigureMapper carouselFigureMapper;

	public CarouselFigureBeanImpl(CarouselFigureEntity entity) {
		this.entity = entity;
	}

	@Override
	public Integer getFigureId() {
		if (null == entity) {
			return null;
		}
		return entity.getFigureId();
	}

	@Override
	public String getImgAddr() {
		if (null == entity) {
			return null;
		}
		return entity.getImgAddr();
	}

	@Override
	public String getJumpUrl() {
		if (null == entity) {
			return null;
		}
		return entity.getJumpUrl();
	}

	@Override
	public CarouselFigureType getFigureType() {
		if (null == entity) {
			return null;
		}
		return CarouselFigureType.valueOf(entity.getFigureType());
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
	public void setFigureId(Integer figureId) {
		if (null == entity) {
			entity = new CarouselFigureEntity();
		}
		entity.setFigureId(figureId);
	}

	@Override
	public void setImgAddr(String imgAddr) {
		if (null == entity) {
			entity = new CarouselFigureEntity();
		}
		entity.setImgAddr(imgAddr);
	}

	@Override
	public void setJumpUrl(String jumpUrl) {
		if (null == entity) {
			entity = new CarouselFigureEntity();
		}
		entity.setJumpUrl(jumpUrl);
	}

	@Override
	public void setFigureType(CarouselFigureType figureType) {
		if (null == entity) {
			entity = new CarouselFigureEntity();
		}
		entity.setFigureType(figureType == null ? null : figureType.name());
	}

	@Override
	public void setBeginTime(Date beginTime) {
		if (null == entity) {
			entity = new CarouselFigureEntity();
		}
		entity.setBeginTime(beginTime);
	}

	@Override
	public void setEndTime(Date endTime) {
		if (null == entity) {
			entity = new CarouselFigureEntity();
		}
		entity.setEndTime(endTime);
	}

	@Override
	public void setSort(Integer sort) {
		if (null == entity) {
			entity = new CarouselFigureEntity();
		}
		entity.setSort(sort);
	}

	@Override
	public void setCreateBy(String createBy) {
		if (null == entity) {
			entity = new CarouselFigureEntity();
		}
		entity.setCreateBy(createBy);
	}

	@Override
	public void setUpdateBy(String updateBy) {
		if (null == entity) {
			entity = new CarouselFigureEntity();
		}
		entity.setUpdateBy(updateBy);
	}

	@Override
	public void save() throws ZydException {
		try {
			carouselFigureMapper.insert(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void change() throws ZydException {
		try {
			carouselFigureMapper.updateBySelective(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void remove() throws ZydException {
		try {
			carouselFigureMapper.delete(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}

		if (null != entity) {
			entity.setFigureId(null);
		}
	}

}
