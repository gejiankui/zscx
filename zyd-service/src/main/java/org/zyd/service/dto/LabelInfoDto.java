package org.zyd.service.dto;

import java.io.Serializable;

/**
 * LabelInfoEntity
 *
 * @author GeJianKui
 */
public class LabelInfoDto implements Serializable {

	private static final long serialVersionUID = -413599100341673308L;
	private Integer labelId;
	private String labelName;
	private String style;
	private String introduction;
	private String createBy;
	private String updateBy;

	public Integer getLabelId() {
		return this.labelId;
	}

	public String getLabelName() {
		return this.labelName;
	}

	public String getStyle() {
		return this.style;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName == null ? null : labelName.trim();
	}

	public void setStyle(String style) {
		this.style = style == null ? null : style.trim();
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction == null ? null : introduction.trim();
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

}