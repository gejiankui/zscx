package org.zyd.common.constants;

/**
 * 
 * 账号类型
 * 
 */
public enum UserType {
	A0300010("普通"),
	A0300020("艺人");
	
    private String desc;

    public String getDesc() {
        return this.desc;
    }

	UserType(String desc) {
        this.desc = desc;
    }
}
