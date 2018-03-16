package org.zyd.service.dto;


import java.io.Serializable;
import java.util.List;

/**
 * ShapeInfoDto
 *
 * @author GeJianKui
 */
public class ShapeInfoDto implements Serializable {

	private static final long serialVersionUID = -7043459741580660531L;
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
	private String createBy;
	private String updateBy;
	private ShapeCategoryDto shapeCategoryDto;
	private List<UserInfoDto> specialThanksDtos;
	private List<ReferencesInfoDto> referencesInfoDtos;

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

	public String getCreateBy() {
		return this.createBy;
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

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

	public ShapeCategoryDto getShapeCategoryDto() {
		return shapeCategoryDto;
	}

	public void setShapeCategoryDto(ShapeCategoryDto shapeCategoryDto) {
		this.shapeCategoryDto = shapeCategoryDto;
	}

	public List<UserInfoDto> getSpecialThanksDtos() {
		return specialThanksDtos;
	}

	public void setSpecialThanksDtos(List<UserInfoDto> specialThanksDtos) {
		this.specialThanksDtos = specialThanksDtos;
	}

	public List<ReferencesInfoDto> getReferencesInfoDtos() {
		return referencesInfoDtos;
	}

	public void setReferencesInfoDtos(List<ReferencesInfoDto> referencesInfoDtos) {
		this.referencesInfoDtos = referencesInfoDtos;
	}

	public String getImgProvider() {
		return imgProvider;
	}

	public void setImgProvider(String imgProvider) {
		this.imgProvider = imgProvider == null ? null : imgProvider.trim();
	}
}