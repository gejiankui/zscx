package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.UserLabelEntity;
import org.zyd.store.term.UserLabelTerm;

/**
 * 
 * UserLabelMapper
 *
 * @author GeJianKui
 *
 */
public interface UserLabelMapper extends DBActionMapper<UserLabelEntity, UserLabelTerm>,
        PaginatingMapper<UserLabelEntity, UserLabelTerm> {
	
}
