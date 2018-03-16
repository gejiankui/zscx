package org.zyd.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * WeixinReplyContentEntity
 *
 * @author GeJianKui
 */
public class WeixinReplyContentDto implements Serializable {

	private Integer replyId;
	private String eventOrigType;
	private String triggerKey;
	private String replyCode;
	private String replyType;
	private String replyContent;
	private String createBy;
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

	public String getCreateBy() {
		return this.createBy;
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

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

}