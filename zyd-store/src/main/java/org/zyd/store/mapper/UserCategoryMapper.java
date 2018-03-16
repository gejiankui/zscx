package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.UserCategoryEntity;
import org.zyd.store.term.UserCategoryTerm;

/**
 * 
 * UserCategoryMapper
 *
 * @author GeJianKui
 *
 */
public interface UserCategoryMapper extends DBActionMapper<UserCategoryEntity, UserCategoryTerm>,
        PaginatingMapper<UserCategoryEntity, UserCategoryTerm> {
	
}
