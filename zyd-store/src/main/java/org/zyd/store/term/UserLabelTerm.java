package org.zyd.store.term;

import org.zyd.store.base.term.BaseTerm;

import java.sql.Timestamp;

/**
 * UserLabelTerm
 *
 * @author GeJianKui
 */
public class UserLabelTerm extends BaseTerm {

	private Integer userId;
	private Integer labelId;
	private Integer isValid;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;

	public Integer getUserId() {
		return this.userId;
	}

	public Integer getLabelId() {
		return this.labelId;
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

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
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
