package org.zyd.store.entity;

import org.zyd.store.base.entity.BaseEntity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * ReferencesInfoEntity
 *
 * @author GeJianKui
 */
public class ReferencesInfoEntity extends BaseEntity {

	private Integer refId;
	private String refName;
	private String author;
	private String introduction;
	private Date publicationDate;
	private Integer isValid;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;

	public Integer getRefId() {
		return this.refId;
	}

	public String getRefName() {
		return this.refName;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public Date getPublicationDate() {
		return this.publicationDate;
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

	public void setRefId(Integer refId) {
		this.refId = refId;
	}

	public void setRefName(String refName) {
		this.refName = refName == null ? null : refName.trim();
	}

	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction == null ? null : introduction.trim();
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate == null ? null : (Date) publicationDate.clone();
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