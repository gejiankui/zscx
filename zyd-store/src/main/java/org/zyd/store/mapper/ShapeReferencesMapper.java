package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ShapeReferencesEntity;
import org.zyd.store.term.ShapeReferencesTerm;

/**
 * 
 * ShapeReferencesMapper
 *
 * @author GeJianKui
 *
 */
public interface ShapeReferencesMapper extends DBActionMapper<ShapeReferencesEntity, ShapeReferencesTerm>,
        PaginatingMapper<ShapeReferencesEntity, ShapeReferencesTerm> {
	
}
