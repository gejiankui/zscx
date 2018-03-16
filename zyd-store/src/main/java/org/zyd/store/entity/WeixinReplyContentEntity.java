package org.zyd.store.entity;

import org.zyd.store.base.entity.BaseEntity;

import java.sql.Timestamp;

/**
 * WeixinReplyContentEntity
 *
 * @author GeJianKui
 */
public class WeixinReplyContentEntity extends BaseEntity {

	private Integer replyId;
	private String eventOrigType;
	private String triggerKey;
	private String replyCode;
	private String replyType;
	private String replyContent;
	private Integer isValid;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;

	public Integer getReplyId() {
		return this.replyId;
	}

	public String getEventOrigType() {
		return this.eventOrigType;
	}

	public String getTriggerKey() {
		return this.triggerKey;
	}

	public String getReplyCode() {
		return this.replyCode;
	}

	public String getReplyType() {
		return this.replyType;
	}

	public String getReplyContent() {
		return this.replyContent;
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

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public void setEventOrigType(String eventOrigType) {
		this.eventOrigType = eventOrigType == null ? null : eventOrigType.trim();
	}

	public void setTriggerKey(String triggerKey) {
		this.triggerKey = triggerKey == null ? null : triggerKey.trim();
	}

	public void setReplyCode(String replyCode) {
		this.replyCode = replyCode == null ? null : replyCode.trim();
	}

	public void setReplyType(String replyType) {
		this.replyType = replyType == null ? null : replyType.trim();
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent == null ? null : replyContent.trim();
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