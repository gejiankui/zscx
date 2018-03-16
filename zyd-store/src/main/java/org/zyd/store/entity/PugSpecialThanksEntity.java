package org.zyd.store.entity;

import org.zyd.store.base.entity.BaseEntity;

import java.sql.Timestamp;

/**
 * PugSpecialThanksEntity
 *
 * @author GeJianKui
 */
public class PugSpecialThanksEntity extends BaseEntity {

	private Integer pugId;
	private Integer userId;
	private Integer isValid;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;

	public Integer getPugId() {
		return this.pugId;
	}

	public Integer getUserId() {
		return this.userId;
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

	public void setPugId(Integer pugId) {
		this.pugId = pugId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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