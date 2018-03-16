package org.zyd.service.inf;

import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.ShapeSearchVo;
import org.zyd.service.dto.ShapeCategoryDto;
import org.zyd.service.dto.ShapeInfoDto;

import java.util.List;

public interface ShapeInf {

	/**
	 * 创建新器型<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDS002 名称不能为空
	 * EZYDS003 器型类目不能为空
	 * EZYDS004 器型已经存在
	 * </pre>
	 *
	 * @param shapeInfoDto 器型信息
	 * @throws ZydException
	 */
	void createShape(ShapeInfoDto shapeInfoDto) throws ZydException;

	/**
	 * 创建新器型类型<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDS005 器型类目名称不能为空
	 * EZYDS006 器型类目已经存在
	 * </pre>
	 *
	 * @param shapeCategoryDto 器型类型信息
	 * @throws ZydException
	 */
	void createShapeCategory(ShapeCategoryDto shapeCategoryDto) throws ZydException;

	/**
	 * 根据器型id查询器型信息<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param shapeId 器型id
	 * @return 器型信息
	 * @throws ZydException
	 */
	ShapeInfoDto queryShapeInfo(Integer shapeId) throws ZydException;

	/**
	 * 根据器型id查询器型信息<p/>
	 * 附带参考文献及特别鸣谢
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param shapeId 器型id
	 * @return 器型信息
	 * @throws ZydException
	 */
	ShapeInfoDto queryShapeInfoWithRefInfoAndThanksByKey(Integer shapeId) throws ZydException;

	/**
	 * 查询器型信息<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param searchVo
	 * @return 器型信息集合
	 * @throws ZydException
	 */
	List<ShapeInfoDto> queryShapeInfos(ShapeSearchVo searchVo) throws ZydException;

	/**
	 * 修改器型信息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDS001 器型不存在
	 * </pre>
	 *
	 * @param shapeInfoDto 器型信息
	 * @throws ZydException
	 */
	void updateShapeInfo(ShapeInfoDto shapeInfoDto) throws ZydException;

	/**
	 * 删除器型信息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDS001 器型不存在
	 * </pre>
	 *
	 * @param shapeId 器型id
	 * @throws ZydException
	 */
	void removeShapeInfo(Integer shapeId) throws ZydException;

}
