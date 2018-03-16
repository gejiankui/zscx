package org.zyd.common.vo;

import java.io.Serializable;

public class PugSearchVo implements Serializable {

	private static final long serialVersionUID = -198701697300726300L;
	private String pugName;
	private String pugFullSpell;
	private String pugSimpleSpell;

	public String getPugName() {
		return pugName;
	}

	public void setPugName(String pugName) {
		this.pugName = pugName;
	}

	public String getPugFullSpell() {
		return pugFullSpell;
	}

	public void setPugFullSpell(String pugFullSpell) {
		this.pugFullSpell = pugFullSpell;
	}

	public String getPugSimpleSpell() {
		return pugSimpleSpell;
	}

	public void setPugSimpleSpell(String pugSimpleSpell) {
		this.pugSimpleSpell = pugSimpleSpell;
	}
}
