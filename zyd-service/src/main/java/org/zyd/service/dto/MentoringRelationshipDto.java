package org.zyd.service.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * MentoringRelationshipDto
 *
 * @author GeJianKui
 */
public class MentoringRelationshipDto implements Serializable {

	private static final long serialVersionUID = 3970363518325595116L;
	private Integer relId;
	private Integer userId;
	private String userName;
	private Integer relUserId;
	private String relUserName;
	private String relUserAvatar;
	private Date beginTime;
	private Date endTime;
	private String relType;
	private String createBy;
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

	public Integer getRelUserId() {
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

	public String getCreateBy() {
		return this.createBy;
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

	public void setRelUserId(Integer relUserId) {
		this.relUserId = relUserId;
	}

	public void setRelUserName(String relUserName) {
		this.relUserName = relUserName == null ? null : relUserName.trim();
	}

	public String getRelUserAvatar() {
		return relUserAvatar;
	}

	public void setRelUserAvatar(String relUserAvatar) {
		this.relUserAvatar = relUserAvatar == null ? null : relUserAvatar.trim();
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime == null ? null : (Date) beginTime.clone();
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime == null ? null : (Date) endTime.clone();
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

}