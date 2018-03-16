package org.zyd.domain.bean;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface LabelInfoBean extends BaseOperation, RemoveOperation {
	Integer getLabelId() ;

	String getLabelName() ;

	String getStyle() ;

	String getIntroduction() ;

	String getCreateBy() ;

	String getUpdateBy() ;

	void setLabelId(Integer labelId) ;

	void setLabelName(String labelName) ;

	void setStyle(String style) ;

	void setIntroduction(String introduction) ;

	void setCreateBy(String createBy) ;

	void setUpdateBy(String updateBy) ;
}
