package org.zyd.domain.repository;

import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.GeneralizeBean;

import java.util.List;

public interface GeneralizeRepos {

    /**
     * 根据推广设置id查询记录
     *
     * @param settingId 设置主键id
     * @return 推广
     * @throws ZydException
     */
    GeneralizeBean queryGeneralizeByKey(Integer settingId) throws ZydException;

    /**
     * 根据用户此推广位置数据
     *
     * @param userId 用户id
     * @param position 推广位置
     * @return 推广
     * @throws ZydException
     */
    GeneralizeBean queryGeneralizeByUser(Integer userId, Integer position) throws ZydException;

    /**
     * 综合查询
     * 
     * @param position 推广位置 1:首页，2:艺人搜索页
     * @return 用户集合
     * @throws ZydException
     */
    List<GeneralizeBean> queryGeneralizes(Integer position) throws ZydException;

}
