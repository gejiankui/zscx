package org.zyd.domain.repository;

import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.ShapeSearchVo;
import org.zyd.domain.bean.ShapeInfoBean;

import java.util.List;

public interface ShapeRepos {

    /**
     * 根据壶型id查询壶型信息
     * 
     * @param shapeId 壶型id
     * @return 壶型信息
     * @throws ZydException
     */
    ShapeInfoBean queryShapeInfoByKey(Integer shapeId) throws ZydException;

    /**
     * 根据壶型id查询壶型信息
     * 附带参考文献及特别鸣谢
     *
     * @param shapeId 壶型id
     * @return 壶型信息
     * @throws ZydException
     */
    ShapeInfoBean queryShapeInfoWithRefInfoAndThanksByKey(Integer shapeId) throws ZydException;

    /**
     * 根据壶型名称查询壶型信息
     *
     * @param shapeName 壶型名称
     * @return 壶型信息
     * @throws ZydException
     */
    ShapeInfoBean queryShapeInfoByName(String shapeName) throws ZydException;

    /**
     * 综合查询
     * 
     * @param shapeSearchVo 查询条件
     * @return 壶型集合
     * @throws ZydException
     */
    List<ShapeInfoBean> queryShapes(ShapeSearchVo shapeSearchVo) throws ZydException;

}
