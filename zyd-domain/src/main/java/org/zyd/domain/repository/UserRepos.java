package org.zyd.domain.repository;

import java.util.List;

import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.UserSearchVo;
import org.zyd.domain.bean.UserInfoBean;
import org.zyd.store.entity.UserCategoryEntity;

public interface UserRepos {

    /**
     * 根据会员id查询会员标识
     * 
     * @param userId 会员id
     * @return 会员标识
     * @throws ZydException
     */
    UserInfoBean queryUserInfoByKey(Integer userId) throws ZydException;

    /**
     * 根据手机号查询会员标识
     *
     * @param phoneNo 手机号
     * @return 会员标识
     * @throws ZydException
     */
    UserInfoBean queryUserInfoByPhone(String phoneNo) throws ZydException;

    /**
     * 根据会员id查询带师承关系的会员标识
     *
     * @param userId 会员id
     * @return 会员标识
     * @throws ZydException
     */
    UserInfoBean queryUserInfoWithMentoringRelByUserId(Integer userId) throws ZydException;

    /**
     * 综合查询
     * 
     * @param userSearchVo 查询条件
     * @return 用户集合
     * @throws ZydException
     */
    List<UserInfoBean> queryUsers(UserSearchVo userSearchVo) throws ZydException;

    /**
     * 查询用户分类
     *
     * @return 用户分类集合
     * @throws ZydException
     */
    List<UserCategoryEntity> queryUserCategory() throws ZydException;

    /**
     * 查询用户信息<p/>
     *
     * @param cid 分类id
     * @return 用户信息集合
     * @throws ZydException
     */
    List<UserInfoBean> queryUserByCategoryId(Integer cid) throws ZydException;

}
