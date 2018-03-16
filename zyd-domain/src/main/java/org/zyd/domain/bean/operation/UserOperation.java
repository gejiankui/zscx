package org.zyd.domain.bean.operation;

import org.zyd.common.exception.ZydException;

import java.math.BigDecimal;
import java.util.Date;

public interface UserOperation {

	/**
	 * 拜师
	 *
	 * @param masterId 师傅
	 * @param beginTime 开始时间
	 * @throws ZydException
	 */
	void apprentice(Integer masterId, Date beginTime) throws ZydException;

}
