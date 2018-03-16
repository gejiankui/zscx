package org.zyd.common.vo;

import java.io.Serializable;

public class UserSearchVo implements Serializable{

    private static final long serialVersionUID = -8404541119437073410L;
    private String userName;
    private String userFullSpell;
    private String userSimpleSpell;
    private String userType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFullSpell() {
        return userFullSpell;
    }

    public void setUserFullSpell(String userFullSpell) {
        this.userFullSpell = userFullSpell;
    }

    public String getUserSimpleSpell() {
        return userSimpleSpell;
    }

    public void setUserSimpleSpell(String userSimpleSpell) {
        this.userSimpleSpell = userSimpleSpell;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
