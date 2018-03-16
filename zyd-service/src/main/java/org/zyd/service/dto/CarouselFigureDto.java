package org.zyd.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * CarouselFigureDto
 *
 * @author GeJianKui
 */
public class CarouselFigureDto implements Serializable {

	private static final long serialVersionUID = 5876535166398112112L;

	private Integer figureId;
	private Date beginTime;
	private Date endTime;
	private String imgAddr;
	private String jumpUrl;
	private String figureType;
	private Integer sort;
	private String createBy;
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

	public String getCreateBy() {
		return this.createBy;
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

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

}