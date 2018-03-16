package org.zyd.common.constants;

/**
 * 
 * 职称
 *
 */
public enum JobTitle {
    A0200010("无"),
    A0200020("研究员级高级工艺美术师"),
    A0200030("高级工艺美术师"),
	A0200040("工艺美术师"),
	A0200050("助理工艺美术师"),
	A0200060("工艺美术员");

	private String desc;

	public String getDesc() {
		return this.desc;
	}

	JobTitle(String desc) {
		this.desc = desc;
	}
}
