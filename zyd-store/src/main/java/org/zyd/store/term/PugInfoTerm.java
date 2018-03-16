package org.zyd.store.term;

import org.zyd.store.base.term.BaseTerm;

import java.sql.Timestamp;

/**
 * PugInfoTerm
 *
 * @author GeJianKui
 */
public class PugInfoTerm extends BaseTerm {

	private Integer pugId;
	private String pugName;
	private String pugFullSpell;
	private String pugSimpleSpell;
	private String thumbImg;
	private String pugImg;
	private Integer categoryId;
	private String categoryName;
	private String introduction;
	private Integer isValid;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;

	public Integer getPugId() {
		return this.pugId;
	}

	public String getPugName() {
		return this.pugName;
	}

	public String getPugFullSpell() {
		return this.pugFullSpell;
	}

	public String getPugSimpleSpell() {
		return this.pugSimpleSpell;
	}

	public String getThumbImg() {
		return this.thumbImg;
	}

	public String getPugImg() {
		return this.pugImg;
	}

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

	public void setPugId(Integer pugId) {
		this.pugId = pugId;
	}

	public void setPugName(String pugName) {
		this.pugName = pugName == null ? null : pugName.trim();
	}

	public void setPugFullSpell(String pugFullSpell) {
		this.pugFullSpell = pugFullSpell == null ? null : pugFullSpell.trim();
	}

	public void setPugSimpleSpell(String pugSimpleSpell) {
		this.pugSimpleSpell = pugSimpleSpell == null ? null : pugSimpleSpell.trim();
	}

	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg == null ? null : thumbImg.trim();
	}

	public void setPugImg(String pugImg) {
		this.pugImg = pugImg == null ? null : pugImg.trim();
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
