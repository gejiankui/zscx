package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ShapeCategoryEntity;
import org.zyd.store.term.ShapeCategoryTerm;

/**
 * 
 * ShapeCategoryMapper
 *
 * @author GeJianKui
 *
 */
public interface ShapeCategoryMapper extends DBActionMapper<ShapeCategoryEntity, ShapeCategoryTerm>,
        PaginatingMapper<ShapeCategoryEntity, ShapeCategoryTerm> {
	
}
