package org.zyd.service.inf;

import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.UserSearchVo;
import org.zyd.service.dto.GeneralizeSettingDto;
import org.zyd.service.dto.UserInfoDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface GeneralizeInf {

	/**
	 * 创建新推广信息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDE013 用户不存在
	 * EZYDE025 用户id不能为空
	 * EZYDG001 开始时间不能为空
	 * EZYDH002 结束时间不能为空
	 * EZYDH003 推广位置不能为空
	 * </pre>
	 *
	 * @param generalizeSettingDto 推广信息
	 * @throws ZydException
	 */
	void createGeneralize(GeneralizeSettingDto generalizeSettingDto) throws ZydException;

	/**
	 * 根据设置id查询推广信息<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param settingId 推广设置id
	 * @return 推广信息
	 * @throws ZydException
	 */
	GeneralizeSettingDto queryGeneralize(Integer settingId) throws ZydException;

	/**
	 * 查询推广信息<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param position
	 * @return 推广信息集合
	 * @throws ZydException
	 */
	List<GeneralizeSettingDto> queryGeneralizes(Integer position) throws ZydException;

	/**
	 * 修改推广信息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDG000 推广信息不存在
	 * </pre>
	 *
	 * @param generalizeSettingDto 推广信息
	 * @throws ZydException
	 */
	void updateGeneralize(GeneralizeSettingDto generalizeSettingDto) throws ZydException;

	/**
	 * 删除推广信息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDG000 推广信息不存在
	 * @see org.zyd.common.constants.ErrorCode
	 * </pre>
	 *
	 * @param settingId 推广设置id
	 * @throws ZydException
	 */
	void removeGeneralize(Integer settingId) throws ZydException;

}
