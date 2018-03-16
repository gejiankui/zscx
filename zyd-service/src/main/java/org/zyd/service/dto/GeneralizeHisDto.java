package org.zyd.service.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * GeneralizeHisDto
 *
 * @author GeJianKui
 */
public class GeneralizeHisDto implements Serializable {

	private static final long serialVersionUID = -4490537567490789248L;
	private Integer hisId;
	private Integer settingId;
	private Integer userId;
	private String userName;
	private Date beginTime;
	private Date endTime;
	private Integer sort;
	private Integer position;
	private String createBy;
	private String updateBy;

	public Integer getHisId() {
		return this.hisId;
	}

	public Integer getSettingId() {
		return this.settingId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public Date getBeginTime() {
		return this.beginTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public Integer getSort() {
		return this.sort;
	}

	public Integer getPosition() {
		return this.position;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setHisId(Integer hisId) {
		this.hisId = hisId;
	}

	public void setSettingId(Integer settingId) {
		this.settingId = settingId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime == null ? null : (Date) beginTime.clone();
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime == null ? null : (Date) endTime.clone();
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

}