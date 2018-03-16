package org.zyd.store.entity;

import org.zyd.store.base.entity.BaseEntity;

import java.sql.Timestamp;

/**
 * PugCategoryEntity
 *
 * @author GeJianKui
 */
public class PugCategoryEntity extends BaseEntity {

	private Integer categoryId;
	private String categoryName;
	private String introduction;
	private Integer isValid;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public String getIntroduction() {
		return this.introduction;
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

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName == null ? null : categoryName.trim();
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction == null ? null : introduction.trim();
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