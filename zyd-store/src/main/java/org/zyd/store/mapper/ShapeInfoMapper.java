package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ShapeInfoEntity;
import org.zyd.store.term.ShapeInfoTerm;

/**
 * 
 * ShapeInfoMapper
 *
 * @author GeJianKui
 *
 */
public interface ShapeInfoMapper extends DBActionMapper<ShapeInfoEntity, ShapeInfoTerm>,
        PaginatingMapper<ShapeInfoEntity, ShapeInfoTerm> {
	
}
