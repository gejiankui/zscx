package org.zyd.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * UserInfoDto
 *
 * @author GeJianKui
 */
public class UserInfoDto implements Serializable {

	private static final long serialVersionUID = 1598415290804275266L;

	private List<MentoringRelationshipDto> mentoringRelationshipDtos;
	private List<LabelInfoDto> labelInfoDtos;

	private Integer userId;
	private String userName;
	private String userFullSpell;
	private String userSimpleSpell;
	private String userNickname;
	private String phone;
	private String avatar;
	private String userSmallImg;
	private String userImg;
	private String gender;
	private String introduction;
	private String birthday;
	private Integer isDead;
	private String deathTime;
	private Integer isTitle;
	private String jobTitle;
	private String titlePassDate;
	private String userType;
	private String industry;
	private String workUnit;
	private String homeAddr;
	private String workAddr;
	private String createBy;
	private String updateBy;

	public Integer getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getUserFullSpell() {
		return this.userFullSpell;
	}

	public String getUserSimpleSpell() {
		return this.userSimpleSpell;
	}

	public String getUserNickname() {
		return this.userNickname;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public String getUserSmallImg() {
		return userSmallImg;
	}

	public String getUserImg() {
		return this.userImg;
	}

	public String getGender() {
		return this.gender;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public Integer getIsDead() {
		return isDead;
	}

	public void setIsDead(Integer isDead) {
		this.isDead = isDead;
	}

	public String getDeathTime() {
		return this.deathTime;
	}

	public Integer getIsTitle() {
		return this.isTitle;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public String getTitlePassDate() {
		return this.titlePassDate;
	}

	public String getUserType() {
		return this.userType;
	}

	public String getIndustry() {
		return this.industry;
	}

	public String getWorkUnit() {
		return this.workUnit;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public void setUserFullSpell(String userFullSpell) {
		this.userFullSpell = userFullSpell == null ? null : userFullSpell.trim();
	}

	public void setUserSimpleSpell(String userSimpleSpell) {
		this.userSimpleSpell = userSimpleSpell == null ? null : userSimpleSpell.trim();
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname == null ? null : userNickname.trim();
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar == null ? null : avatar.trim();
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg == null ? null : userImg.trim();
	}

	public void setUserSmallImg(String userSmallImg) {
		this.userSmallImg = userSmallImg == null ? null : userSmallImg.trim();
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction == null ? null : introduction.trim();
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday == null ? null : birthday.trim();
	}

	public void setDeathTime(String deathTime) {
		this.deathTime = deathTime == null ? null : deathTime.trim();
	}

	public void setIsTitle(Integer isTitle) {
		this.isTitle = isTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setTitlePassDate(String titlePassDate) {
		this.titlePassDate = titlePassDate == null ? null : titlePassDate.trim();
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit == null ? null : workUnit.trim();
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr == null ? null : homeAddr.trim();
	}

	public String getWorkAddr() {
		return workAddr;
	}

	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr == null ? null : workAddr.trim();
	}

	public List<MentoringRelationshipDto> getMentoringRelationshipDtos() {
		return mentoringRelationshipDtos;
	}

	public void setMentoringRelationshipDtos(
			List<MentoringRelationshipDto> mentoringRelationshipDtos) {
		this.mentoringRelationshipDtos = mentoringRelationshipDtos;
	}

	public List<LabelInfoDto> getLabelInfoDtos() {
		return labelInfoDtos;
	}

	public void setLabelInfoDtos(List<LabelInfoDto> labelInfoDtos) {
		this.labelInfoDtos = labelInfoDtos;
	}
}