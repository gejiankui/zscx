package org.zyd.store.term;

import org.zyd.store.base.term.BaseTerm;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * MentoringRelationshipTerm
 *
 * @author GeJianKui
 */
public class MentoringRelationshipTerm extends BaseTerm {

	private Integer relId;
	private Integer userId;
	private String userName;
	private BigDecimal relUserId;
	private String relUserName;
	private Date beginTime;
	private Date endTime;
	private String relType;
	private Integer isValid;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;

	public Integer getRelId() {
		return this.relId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public BigDecimal getRelUserId() {
		return this.relUserId;
	}

	public String getRelUserName() {
		return this.relUserName;
	}

	public Date getBeginTime() {
		return this.beginTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public String getRelType() {
		return this.relType;
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

	public void setRelId(Integer relId) {
		this.relId = relId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public void setRelUserId(BigDecimal relUserId) {
		this.relUserId = relUserId;
	}

	public void setRelUserName(String relUserName) {
		this.relUserName = relUserName == null ? null : relUserName.trim();
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime == null ? null : (Date) beginTime.clone();
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime == null ? null : (Date) endTime.clone();
	}

	public void setRelType(String relType) {
		this.relType = relType == null ? null : relType.trim();
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

}
