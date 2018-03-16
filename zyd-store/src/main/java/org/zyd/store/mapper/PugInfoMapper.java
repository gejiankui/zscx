package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PugInfoEntity;
import org.zyd.store.term.PugInfoTerm;

/**
 * 
 * PugInfoMapper
 *
 * @author GeJianKui
 *
 */
public interface PugInfoMapper extends DBActionMapper<PugInfoEntity, PugInfoTerm>,
        PaginatingMapper<PugInfoEntity, PugInfoTerm> {
	
}
