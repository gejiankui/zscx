package org.zyd.service.dto;


import java.io.Serializable;
import java.util.List;

/**
 * PugInfoDto
 *
 * @author GeJianKui
 */
public class PugInfoDto implements Serializable {

	private static final long serialVersionUID = 1175886225538597554L;
	private Integer pugId;
	private String pugName;
	private String pugFullSpell;
	private String pugSimpleSpell;
	private String thumbImg;
	private String pugImg;
	private Integer categoryId;
	private String categoryName;
	private String introduction;
	private String createBy;
	private String updateBy;
	private PugCategoryDto pugCategoryDto;
	private List<UserInfoDto> specialThanksDtos;
	private List<ReferencesInfoDto> referencesInfoDtos;

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

	public String getCreateBy() {
		return this.createBy;
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

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

	public PugCategoryDto getPugCategoryDto() {
		return pugCategoryDto;
	}

	public void setPugCategoryDto(PugCategoryDto pugCategoryDto) {
		this.pugCategoryDto = pugCategoryDto;
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
}