package org.zyd.common.constants;

/**
 * 
 * 性别
 *
 */
public enum Gender {
    A0100010("未输入"),
    A0100020("男"),
    A0100030("女");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	Gender(String desc) {
		this.desc = desc;
	}
}
