package org.zyd.service.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * ReferencesInfoDto
 *
 * @author GeJianKui
 */
public class ReferencesInfoDto implements Serializable {

	private static final long serialVersionUID = -1341325907236649668L;
	private Integer refId;
	private String refName;
	private String author;
	private String introduction;
	private Date publicationDate;
	private String createBy;
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

	public String getCreateBy() {
		return this.createBy;
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

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

}