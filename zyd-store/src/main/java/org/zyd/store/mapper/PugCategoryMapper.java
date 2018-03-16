package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PugCategoryEntity;
import org.zyd.store.term.PugCategoryTerm;

/**
 * 
 * PugCategoryMapper
 *
 * @author GeJianKui
 *
 */
public interface PugCategoryMapper extends DBActionMapper<PugCategoryEntity, PugCategoryTerm>,
        PaginatingMapper<PugCategoryEntity, PugCategoryTerm> {
	
}
