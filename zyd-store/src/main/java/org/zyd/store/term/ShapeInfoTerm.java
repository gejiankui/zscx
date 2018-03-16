package org.zyd.store.term;

import org.zyd.store.base.term.BaseTerm;

import java.sql.Timestamp;

/**
 * ShapeInfoTerm
 *
 * @author GeJianKui
 */
public class ShapeInfoTerm extends BaseTerm {

	private Integer shapeId;
	private String shapeName;
	private String shapeFullSpell;
	private String shapeSimpleSpell;
	private String thumbImg;
	private String shapeImg;
	private Integer categoryId;
	private String categoryName;
	private Integer providerId;
	private String imgProvider;
	private String introduction;
	private Integer isValid;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;

	public Integer getShapeId() {
		return this.shapeId;
	}

	public String getShapeName() {
		return this.shapeName;
	}

	public String getShapeFullSpell() {
		return this.shapeFullSpell;
	}

	public String getShapeSimpleSpell() {
		return this.shapeSimpleSpell;
	}

	public String getThumbImg() {
		return this.thumbImg;
	}

	public String getShapeImg() {
		return this.shapeImg;
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

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public void setShapeId(Integer shapeId) {
		this.shapeId = shapeId;
	}

	public void setShapeName(String shapeName) {
		this.shapeName = shapeName == null ? null : shapeName.trim();
	}

	public void setShapeFullSpell(String shapeFullSpell) {
		this.shapeFullSpell = shapeFullSpell == null ? null : shapeFullSpell.trim();
	}

	public void setShapeSimpleSpell(String shapeSimpleSpell) {
		this.shapeSimpleSpell = shapeSimpleSpell == null ? null : shapeSimpleSpell.trim();
	}

	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg == null ? null : thumbImg.trim();
	}

	public void setShapeImg(String shapeImg) {
		this.shapeImg = shapeImg == null ? null : shapeImg.trim();
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

	public String getImgProvider() {
		return imgProvider;
	}

	public void setImgProvider(String imgProvider) {
		this.imgProvider = imgProvider == null ? null : imgProvider.trim();
	}
}
