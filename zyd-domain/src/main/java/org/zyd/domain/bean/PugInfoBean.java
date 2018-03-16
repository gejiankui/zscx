package org.zyd.domain.bean;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;
import org.zyd.store.entity.ReferencesInfoEntity;
import org.zyd.store.entity.UserInfoEntity;
import org.zyd.store.term.ReferencesInfoTerm;

import java.util.List;

public interface PugInfoBean extends BaseOperation, RemoveOperation {
	Integer getPugId();

	String getPugName();

	String getPugFullSpell();

	String getPugSimpleSpell();

	String getThumbImg();

	String getPugImg();

	Integer getCategoryId();

	String getCategoryName();

	String getIntroduction();

	String getCreateBy();

	String getUpdateBy();

	List<ReferencesInfoEntity> getReferencesInfo();

	List<UserInfoEntity> getSpecialThanks();

	void setPugId(Integer pugId);

	void setPugName(String pugName);

	void setPugFullSpell(String pugFullSpell);

	void setPugSimpleSpell(String pugSimpleSpell);

	void setThumbImg(String thumbImg);

	void setPugImg(String pugImg);

	void setCategoryId(Integer categoryId);

	void setCategoryName(String categoryName);

	void setIntroduction(String introduction);

	void setCreateBy(String createBy);

	void setUpdateBy(String updateBy);

	void setReferencesInfo(List<ReferencesInfoEntity> referencesInfo);

	void setSpecialThanks(List<UserInfoEntity> specialThanks);
}
