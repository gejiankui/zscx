package org.zyd.service.inf;

import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.PugSearchVo;
import org.zyd.common.vo.UserSearchVo;
import org.zyd.service.dto.PugCategoryDto;
import org.zyd.service.dto.PugInfoDto;
import org.zyd.service.dto.UserInfoDto;

import java.util.Date;
import java.util.List;

public interface PugInf {

	/**
	 * 创建新泥料<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP002 名称不能为空
	 * EZYDP003 泥料类目不能为空
	 * EZYDP004 泥料已经存在
	 * </pre>
	 *
	 * @param pugInfoDto 泥料信息
	 * @throws ZydException
	 */
	void createPug(PugInfoDto pugInfoDto) throws ZydException;

	/**
	 * 创建新泥料类型<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP005 泥料类目名称不能为空
	 * EZYDP006 泥料类目已经存在
	 * </pre>
	 *
	 * @param pugCategoryDto 泥料类型信息
	 * @throws ZydException
	 */
	void createPugCategory(PugCategoryDto pugCategoryDto) throws ZydException;

	/**
	 * 根据泥料id查询泥料信息<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param pugId 泥料id
	 * @return 泥料信息
	 * @throws ZydException
	 */
	PugInfoDto queryPugInfo(Integer pugId) throws ZydException;

	/**
	 * 根据泥料id查询泥料信息<p/>
	 * 附带参考文献及特别鸣谢
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param pugId 泥料id
	 * @return 泥料信息
	 * @throws ZydException
	 */
	PugInfoDto queryPugInfoWithRefInfoAndThanksByKey(Integer pugId) throws ZydException;

	/**
	 * 查询泥料信息<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param searchVo
	 * @return 泥料信息集合
	 * @throws ZydException
	 */
	List<PugInfoDto> queryPugInfos(PugSearchVo searchVo) throws ZydException;

	/**
	 * 修改泥料信息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP001 泥料不存在
	 * </pre>
	 *
	 * @param pugInfoDto 泥料信息
	 * @throws ZydException
	 */
	void updatePugInfo(PugInfoDto pugInfoDto) throws ZydException;

	/**
	 * 删除泥料信息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP001 泥料不存在
	 * </pre>
	 *
	 * @param pugId 泥料id
	 * @throws ZydException
	 */
	void removePugInfo(Integer pugId) throws ZydException;

}
