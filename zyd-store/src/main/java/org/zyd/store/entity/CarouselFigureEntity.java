package org.zyd.store.entity;

import org.zyd.store.base.entity.BaseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * CarouselFigureEntity
 *
 * @author GeJianKui
 */
public class CarouselFigureEntity extends BaseEntity {

	private Integer figureId;
	private Date beginTime;
	private Date endTime;
	private String imgAddr;
	private String jumpUrl;
	private String figureType;
	private Integer sort;
	private Integer isValid;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;

	public Integer getFigureId() {
		return this.figureId;
	}

	public Date getBeginTime() {
		return this.beginTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public String getImgAddr() {
		return this.imgAddr;
	}

	public String getJumpUrl() {
		return this.jumpUrl;
	}

	public String getFigureType() {
		return this.figureType;
	}

	public Integer getSort() {
		return this.sort;
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

	public void setFigureId(Integer figureId) {
		this.figureId = figureId;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime == null ? null : (Date) beginTime.clone();
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime == null ? null : (Date) endTime.clone();
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr == null ? null : imgAddr.trim();
	}

	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl == null ? null : jumpUrl.trim();
	}

	public void setFigureType(String figureType) {
		this.figureType = figureType == null ? null : figureType.trim();
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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