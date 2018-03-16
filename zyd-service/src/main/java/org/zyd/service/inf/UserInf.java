package org.zyd.service.inf;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.UserSearchVo;
import org.zyd.service.dto.UserCategoryDto;
import org.zyd.service.dto.UserInfoDto;

public interface UserInf {

	/**
	 * 创建新用户<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDE003 手机格式不正确
	 * EZYDE006 姓名不能为空
	 * EZYDE024 手机号码已存在
	 * </pre>
	 *
	 * @param userInfoDto 用户信息
	 * @throws ZydException
	 */
	void createUser(UserInfoDto userInfoDto) throws ZydException;

	/**
	 * 根据用户id查询用户基本信息，附带师徒关系<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param userId 用户id
	 * @return 用户基本信息
	 * @throws ZydException
	 */
	UserInfoDto queryUserInfoWithMentoringRel(Integer userId) throws ZydException;

	/**
	 * 根据用户id查询用户基本信息<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param userId 用户id
	 * @return 用户基本信息
	 * @throws ZydException
	 */
	UserInfoDto queryUserInfo(Integer userId) throws ZydException;

	/**
	 * 查询用户信息<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param searchVo
	 * @return 用户信息集合
	 * @throws ZydException
	 */
	List<UserInfoDto> queryUserInfos(UserSearchVo searchVo) throws ZydException;

	/**
	 * 查询用户分类信息<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @return 用户分类信息集合
	 * @throws ZydException
	 */
	List<UserCategoryDto> queryUserCategory() throws ZydException;

	/**
	 * 查询用户信息<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param cid 分类id
	 * @return 用户信息集合
	 * @throws ZydException
	 */
	List<UserInfoDto> queryUserByCategoryId(Integer cid) throws ZydException;

	/**
	 * 修改用户信息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
	 * EZYDE025 用户id不能为空
	 * </pre>
	 *
	 * @param userInfoDto 用户信息
	 * @throws ZydException
	 */
	void updateUserInfo(UserInfoDto userInfoDto) throws ZydException;

	/**
	 * 删除用户信息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDE013   会员不存在
	 * EZYDE023   联系信息不存在
	 * </pre>
	 *
	 * @param userId 用户id
	 * @throws ZydException
	 */
	void removeUserInfo(Integer userId) throws ZydException;

	/**
	 * 拜师<p/>
	 *
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDE013   会员不存在
	 * </pre>
	 *
	 * @param userId 徒弟id
	 * @param masterId 师傅id
	 * @throws ZydException
	 */
	void apprentice(Integer userId, Integer masterId, Date beginTime) throws ZydException;

}
