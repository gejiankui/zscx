package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.UserInfoEntity;
import org.zyd.store.term.UserInfoTerm;

import java.util.List;

/**
 * 
 * UserInfoMapper
 *
 * @author GeJianKui
 *
 */
public interface UserInfoMapper extends DBActionMapper<UserInfoEntity, UserInfoTerm>,
        PaginatingMapper<UserInfoEntity, UserInfoTerm> {
	List<UserInfoEntity> selectByKeys(List<Integer> ids);

	List<UserInfoEntity> selectByCategoryId(Integer cid);
}
