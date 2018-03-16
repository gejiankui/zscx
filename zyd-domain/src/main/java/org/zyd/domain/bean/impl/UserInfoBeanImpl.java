package org.zyd.domain.bean.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.*;
import org.zyd.domain.bean.LabelInfoBean;
import org.zyd.domain.bean.UserInfoBean;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.LabelInfoEntity;
import org.zyd.store.entity.MentoringRelationshipEntity;
import org.zyd.store.entity.UserInfoEntity;
import org.zyd.store.mapper.MentoringRelationshipMapper;
import org.zyd.store.mapper.UserInfoMapper;
import org.zyd.store.term.UserInfoTerm;

public class UserInfoBeanImpl implements UserInfoBean {

	private UserInfoEntity entity;

	private List<MentoringRelationshipEntity> mentoringRelationshipEntityList;
	private List<LabelInfoBean> labelInfoBeans;

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private MentoringRelationshipMapper mentoringRelationshipMapper;

	public UserInfoBeanImpl(UserInfoEntity entity) {
		this.entity = entity;
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
	public String getUserFullSpell() {
		if (null == entity) {
			return null;
		}
		return entity.getUserFullSpell();
	}

	@Override
	public String getUserSimpleSpell() {
		if (null == entity) {
			return null;
		}
		return entity.getUserSimpleSpell();
	}

	@Override
	public String getUserNickname() {
		if (null == entity) {
			return null;
		}
		return entity.getUserNickname();
	}

	@Override
	public Gender getGender() {
		if (null == entity) {
			return null;
		}
		if (StringUtils.isEmpty(entity.getGender())) {
			return null;
		}
		return Gender.valueOf(entity.getGender());
	}

	@Override
	public String getBirthday() {
		if (null == entity) {
			return null;
		}
		return entity.getBirthday();
	}

	@Override
	public Industry getIndustry() {
		if (null == entity) {
			return null;
		}
		if (StringUtils.isEmpty(entity.getIndustry())) {
			return null;
		}
		return Industry.valueOf(entity.getIndustry());
	}

	@Override
	public String getAvatar() {
		if (null == entity) {
			return null;
		}
		return entity.getAvatar();
	}

	@Override
	public String getUserSmallImg() {
		if (null == entity) {
			return null;
		}
		return entity.getUserSmallImg();
	}
	@Override
	public String getUserImg() {
		if (null == entity) {
			return null;
		}
		return entity.getUserImg();
	}

	@Override
	public String getIntroduction() {
		if (null == entity) {
			return null;
		}
		return entity.getIntroduction();
	}

	@Override
	public Integer getIsDead() {
		if (null == entity) {
			return null;
		}
		return entity.getIsDead();
	}

	@Override
	public String getDeathTime() {
		if (null == entity) {
			return null;
		}
		return entity.getDeathTime();
	}

	@Override
	public Integer getIsTitle() {
		if (null == entity) {
			return null;
		}
		return entity.getIsTitle();
	}

	@Override
	public JobTitle getJobTitle() {
		if (null == entity) {
			return null;
		}
		if (StringUtils.isEmpty(entity.getJobTitle())) {
			return null;
		}
		return JobTitle.valueOf(entity.getJobTitle());
	}

	@Override
	public String getTitlePassDate() {
		if (null == entity) {
			return null;
		}
		return entity.getTitlePassDate();
	}

	@Override
	public UserType getUserType() {
		if (null == entity) {
			return null;
		}
		if (StringUtils.isEmpty(entity.getUserType())) {
			return null;
		}
		return UserType.valueOf(entity.getUserType());
	}

	@Override
	public String getWorkUnit() {
		if (null == entity) {
			return null;
		}
		return entity.getWorkUnit();
	}

	@Override
	public String getPhone() {
		if (null == entity) {
			return null;
		}
		return entity.getPhone();
	}

	@Override
	public String getHomeAddr() {
		if (null == entity) {
			return null;
		}
		return entity.getHomeAddr();
	}

	@Override
	public String getWorkAddr() {
		if (null == entity) {
			return null;
		}
		return entity.getWorkAddr();
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
	public void setUserId(Integer userId) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setUserId(userId);
	}

	@Override
	public void setUserName(String userName) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setUserName(userName);
	}

	@Override
	public void setUserFullSpell(String userFullSpell) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setUserFullSpell(userFullSpell);
	}

	@Override
	public void setUserSimpleSpell(String userSimpleSpell) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setUserSimpleSpell(userSimpleSpell);
	}

	@Override
	public void setUserNickname(String userNickname) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setUserNickname(userNickname);
	}

	@Override
	public void setAvatar(String avatar) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setAvatar(avatar);
	}

	@Override
	public void setUserSmallImg(String userSmallImg) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setUserSmallImg(userSmallImg);
	}

	@Override
	public void setUserImg(String userImg) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setUserImg(userImg);
	}

	@Override
	public void setGender(Gender gender) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setGender(gender == null ? null : gender.name());
	}

	@Override
	public void setIntroduction(String introduction) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setIntroduction(introduction);
	}

	@Override
	public void setBirthday(String birthday) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setBirthday(birthday);
	}

	@Override
	public void setIsDead(Integer isDead) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setIsDead(isDead);
	}

	@Override
	public void setDeathTime(String deathTime) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setDeathTime(deathTime);
	}

	@Override
	public void setIsTitle(Integer isTitle) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setIsTitle(isTitle);
	}

	@Override
	public void setJobTitle(JobTitle jobTitle) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setJobTitle(jobTitle == null ? null : jobTitle.name());
	}

	@Override
	public void setTitlePassDate(String titlePassDate) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setTitlePassDate(titlePassDate);
	}

	@Override
	public void setUserType(UserType userType) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setUserType(userType == null ? null : userType.name());
	}

	@Override
	public void setIndustry(Industry industry) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setIndustry(industry == null ? null : industry.name());
	}

	@Override
	public void setWorkUnit(String workUnit) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setWorkUnit(workUnit);
	}

	@Override
	public void setPhone(String phone) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setPhone(phone);
	}

	@Override
	public void setHomeAddr(String homeAddr) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setHomeAddr(homeAddr);
	}

	@Override
	public void setWorkAddr(String workAddr) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setWorkAddr(workAddr);
	}

	@Override
	public void setCreateBy(String createBy) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setCreateBy(createBy);
	}

	@Override
	public void setUpdateBy(String updateBy) {
		if (null == entity) {
			entity = new UserInfoEntity();
		}
		entity.setUpdateBy(updateBy);
	}

	@Override
	public List<MentoringRelationshipEntity> getMentoringRelationshipEntityList() {
		return mentoringRelationshipEntityList;
	}

	@Override
	public void setMentoringRelationshipEntityList(
			List<MentoringRelationshipEntity> mentoringRelationshipEntityList) {
		if (mentoringRelationshipEntityList == null) {
			mentoringRelationshipEntityList = new ArrayList<MentoringRelationshipEntity>();
		}
		this.mentoringRelationshipEntityList = mentoringRelationshipEntityList;
	}

	@Override
	public List<LabelInfoBean> getLabelInfoBeans() {
		return labelInfoBeans;
	}

	@Override
	public void setLabelInfoBeans(List<LabelInfoBean> labelInfoBeans) {
		if (labelInfoBeans == null) {
			labelInfoBeans = new ArrayList<LabelInfoBean>();
		}
		this.labelInfoBeans = labelInfoBeans;
	}

	@Override
	public void save() throws ZydException {
		try {
			userInfoMapper.insert(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void change() throws ZydException {
		try {
			userInfoMapper.updateBySelective(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void remove() throws ZydException {
		try {
			userInfoMapper.delete(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}

		if (null != entity) {
			entity.setUserId(null);
		}
	}

	@Override
	public void apprentice(Integer masterId, Date beginTime) throws ZydException {
		try {
			UserInfoTerm term = new UserInfoTerm();
			term.setUserId(masterId);
			List<UserInfoEntity> rlt = userInfoMapper.select(term);
			if (CollectionUtils.isEmpty(rlt)) {
				throw new ZydException(ErrorCode.EZYDE013);
			}
			UserInfoEntity master = rlt.get(0);
			Timestamp now = new Timestamp(System.currentTimeMillis());
			MentoringRelationshipEntity mentoringRelationshipEntity = new MentoringRelationshipEntity();
			mentoringRelationshipEntity.setUserId(this.getUserId());
			mentoringRelationshipEntity.setUserName(this.getUserName());
			mentoringRelationshipEntity.setRelUserId(master.getUserId());
			mentoringRelationshipEntity.setRelUserName(master.getUserName());
			mentoringRelationshipEntity.setRelType(MentoringRelType.A0500010.name());
			mentoringRelationshipEntity
					.setBeginTime(beginTime == null ? now : beginTime);
			mentoringRelationshipMapper.insert(mentoringRelationshipEntity);


			MentoringRelationshipEntity mentoringRelationshipEntity2 = new MentoringRelationshipEntity();
			mentoringRelationshipEntity2.setUserId(master.getUserId());
			mentoringRelationshipEntity2.setUserName(master.getUserName());
			mentoringRelationshipEntity2.setRelUserId(this.getUserId());
			mentoringRelationshipEntity2.setRelUserName(this.getUserName());
			mentoringRelationshipEntity2.setRelType(MentoringRelType.A0500020.name());
			mentoringRelationshipEntity
					.setBeginTime(beginTime == null ? now : beginTime);
			mentoringRelationshipMapper.insert(mentoringRelationshipEntity2);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

}
