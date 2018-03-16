package org.zyd.domain.repository;

import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.PugSearchVo;
import org.zyd.domain.bean.PugInfoBean;

import java.util.List;

public interface PugRepos {

    /**
     * 根据泥料id查询泥料信息
     * 
     * @param pugId 泥料id
     * @return 泥料信息
     * @throws ZydException
     */
    PugInfoBean queryPugInfoByKey(Integer pugId) throws ZydException;

    /**
     * 根据泥料id查询泥料信息
     * 附带参考文献及特别鸣谢
     *
     * @param pugId 泥料id
     * @return 泥料信息
     * @throws ZydException
     */
    PugInfoBean queryPugInfoWithRefInfoAndThanksByKey(Integer pugId) throws ZydException;

    /**
     * 根据泥料名称查询泥料信息
     *
     * @param pugName 泥料名称
     * @return 泥料信息
     * @throws ZydException
     */
    PugInfoBean queryPugInfoByName(String pugName) throws ZydException;

    /**
     * 综合查询
     * 
     * @param pugSearchVo 查询条件
     * @return 泥料集合
     * @throws ZydException
     */
    List<PugInfoBean> queryPugs(PugSearchVo pugSearchVo) throws ZydException;

}
