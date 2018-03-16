package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PugReferencesEntity;
import org.zyd.store.term.PugReferencesTerm;

/**
 * 
 * PugReferencesMapper
 *
 * @author GeJianKui
 *
 */
public interface PugReferencesMapper extends DBActionMapper<PugReferencesEntity, PugReferencesTerm>,
        PaginatingMapper<PugReferencesEntity, PugReferencesTerm> {
	
}
