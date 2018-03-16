package org.zyd.domain.bean;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;
import org.zyd.store.entity.ReferencesInfoEntity;
import org.zyd.store.entity.UserInfoEntity;

import java.util.List;

public interface ShapeInfoBean extends BaseOperation, RemoveOperation {
	Integer getShapeId();

	String getShapeName();

	String getShapeFullSpell();

	String getShapeSimpleSpell();

	String getThumbImg();

	String getShapeImg();

	Integer getCategoryId();

	String getCategoryName();

	Integer getProviderId();

	String getImgProvider();

	String getIntroduction();

	String getCreateBy();

	String getUpdateBy();

	List<ReferencesInfoEntity> getReferencesInfo();

	List<UserInfoEntity> getSpecialThanks();

	void setShapeId(Integer shapeId);

	void setShapeName(String shapeName);

	void setShapeFullSpell(String shapeFullSpell);

	void setShapeSimpleSpell(String shapeSimpleSpell);

	void setThumbImg(String thumbImg);

	void setShapeImg(String shapeImg);

	void setCategoryId(Integer categoryId);

	void setCategoryName(String categoryName);

	void setProviderId(Integer providerId);

	void setImgProvider(String imgProvider);

	void setIntroduction(String introduction);

	void setCreateBy(String createBy);

	void setUpdateBy(String updateBy);

	void setReferencesInfo(List<ReferencesInfoEntity> referencesInfo);

	void setSpecialThanks(List<UserInfoEntity> specialThanks);
}
