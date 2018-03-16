package org.zyd.domain.bean;

import org.zyd.common.constants.CarouselFigureType;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

import java.util.Date;

public interface CarouselFigureBean extends BaseOperation, RemoveOperation {
	Integer getFigureId();

	Date getBeginTime();

	Date getEndTime();

	String getImgAddr();

	String getJumpUrl();

	CarouselFigureType getFigureType();

	Integer getSort();

	String getCreateBy();

	String getUpdateBy();

	void setFigureId(Integer figureId);

	void setBeginTime(Date beginTime);

	void setEndTime(Date endTime);

	void setImgAddr(String imgAddr);

	void setJumpUrl(String jumpUrl);

	void setFigureType(CarouselFigureType figureType);

	void setSort(Integer sort);

	void setCreateBy(String createBy);

	void setUpdateBy(String updateBy);
}
