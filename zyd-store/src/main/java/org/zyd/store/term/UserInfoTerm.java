package org.zyd.store.term;

import org.zyd.store.base.term.BaseTerm;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * UserInfoTerm
 *
 * @author GeJianKui
 */
public class UserInfoTerm extends BaseTerm {

	private Integer userId;
	private String userName;
	private String userFullSpell;
	private String userSimpleSpell;
	private String userNickname;
	private String phone;
	private String avatar;
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
	private Integer isValid;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
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

	public Integer getIsValid() {
		return this.isValid;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
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

	public void setGender(String gender) {
		this.gender = gender == null ? null : gender.trim();
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction == null ? null : introduction.trim();
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday == null ? null : birthday.trim();
	}

	public Integer getIsDead() {
		return isDead;
	}

	public void setIsDead(Integer isDead) {
		this.isDead = isDead;
	}

	public void setDeathTime(String deathTime) {
		this.deathTime = deathTime == null ? null : deathTime.trim();
	}

	public void setIsTitle(Integer isTitle) {
		this.isTitle = isTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle == null ? null : jobTitle.trim();
	}

	public void setTitlePassDate(String titlePassDate) {
		this.titlePassDate = titlePassDate == null ? null : titlePassDate.trim();
	}

	public void setUserType(String userType) {
		this.userType = userType == null ? null : userType.trim();
	}

	public void setIndustry(String industry) {
		this.industry = industry == null ? null : industry.trim();
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit == null ? null : workUnit.trim();
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
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
}
