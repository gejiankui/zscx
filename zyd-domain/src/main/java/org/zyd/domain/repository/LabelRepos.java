package org.zyd.domain.repository;

import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.LabelInfoBean;

import java.util.List;

public interface LabelRepos {

	/**
	 * 根据标签id查询标签信息
	 *
	 * @param labelId 标签id
	 * @return 标签信息
	 * @throws ZydException
	 */
	LabelInfoBean queryLabelInfoByKey(Integer labelId) throws ZydException;

	/**
	 * 根据用户id查询标签信息
	 *
	 * @param userId 用户id
	 * @return 标签信息
	 * @throws ZydException
	 */
	List<LabelInfoBean> queryLabelInfoByUserId(Integer userId) throws ZydException;

	/**
	 * 综合查询
	 *
	 * @param labelSearchVo 查询条件
	 * @return 标签集合
	 * @throws ZydException
	 */
//	List<LabelInfoBean> queryLabels(LabelSearchVo labelSearchVo) throws ZydException;

}
