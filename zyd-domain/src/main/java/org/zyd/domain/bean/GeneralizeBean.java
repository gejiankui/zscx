package org.zyd.domain.bean;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;
import java.util.Date;

public interface GeneralizeBean extends BaseOperation, RemoveOperation {

	Integer getSettingId();

	Integer getUserId();

	String getUserName();

	Date getBeginTime();

	Date getEndTime();

	Integer getSort();

	Integer getPosition();

	String getCreateBy();

	String getUpdateBy();

	void setSettingId(Integer settingId);

	void setUserId(Integer userId);

	void setUserName(String userName);

	void setBeginTime(Date beginTime);

	void setEndTime(Date endTime);

	void setSort(Integer sort);

	void setPosition(Integer position);

	void setCreateBy(String createBy);

	void setUpdateBy(String updateBy);
}
