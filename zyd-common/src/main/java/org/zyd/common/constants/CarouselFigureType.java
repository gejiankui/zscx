package org.zyd.common.constants;

/**
 * 
 * 轮播图类型
 *
 */
public enum CarouselFigureType {
    A0600010("泥料首页"),
    A0600020("壶型首页");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	CarouselFigureType(String desc) {
		this.desc = desc;
	}
}
