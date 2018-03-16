package org.zyd.common.constants;

/**
 * 
 * 师承关系
 * 
 */
public enum MentoringRelType {
	A0500010("师傅"),
	A0500020("徒弟");

    private String desc;

    public String getDesc() {
        return this.desc;
    }

	MentoringRelType(String desc) {
        this.desc = desc;
    }
}
