package org.zyd.domain.bean;

import org.zyd.common.constants.Gender;
import org.zyd.common.constants.Industry;
import org.zyd.common.constants.JobTitle;
import org.zyd.common.constants.UserType;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;
import org.zyd.domain.bean.operation.UserOperation;
import org.zyd.store.entity.LabelInfoEntity;
import org.zyd.store.entity.MentoringRelationshipEntity;

import java.util.List;

public interface UserInfoBean extends BaseOperation, RemoveOperation, UserOperation {

	Integer getUserId();

	String getUserName();

	String getUserFullSpell();

	String getUserSimpleSpell();

	String getUserNickname();

	String getAvatar();

	String getUserImg();

	String getUserSmallImg();

	Gender getGender();

	String getIntroduction();

	String getBirthday();

	String getDeathTime();

	Integer getIsDead();

	Integer getIsTitle();

	JobTitle getJobTitle();

	String getTitlePassDate();

	UserType getUserType();

	Industry getIndustry();

	String getWorkUnit();

	String getPhone();

	String getHomeAddr();

	String getWorkAddr();

	String getCreateBy();

	String getUpdateBy();

	List<MentoringRelationshipEntity> getMentoringRelationshipEntityList();

	List<LabelInfoBean> getLabelInfoBeans();

	void setUserId(Integer userId);

	void setUserName(String userName);

	void setUserFullSpell(String userFullSpell);

	void setUserSimpleSpell(String userSimpleSpell);

	void setUserNickname(String userNickname);

	void setAvatar(String avatar);

	void setUserSmallImg(String userSmallImg);

	void setUserImg(String userImg);

	void setGender(Gender gender);

	void setIntroduction(String introduction);

	void setBirthday(String birthday);

	void setIsDead(Integer isDead);

	void setDeathTime(String deathTime);

	void setIsTitle(Integer isTitle);

	void setJobTitle(JobTitle jobTitle);

	void setTitlePassDate(String titlePassDate);

	void setUserType(UserType userType);

	void setIndustry(Industry industry);

	void setWorkUnit(String workUnit);

	void setPhone(String phone);

	void setHomeAddr(String homeAddr);

	void setWorkAddr(String workAddr);

	void setCreateBy(String createBy);

	void setUpdateBy(String updateBy);

	void setMentoringRelationshipEntityList(
			List<MentoringRelationshipEntity> mentoringRelationshipEntityList);

	void setLabelInfoBeans(List<LabelInfoBean> labelInfoBeans);
}
