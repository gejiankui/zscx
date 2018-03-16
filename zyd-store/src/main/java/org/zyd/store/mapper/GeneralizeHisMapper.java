package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.GeneralizeHisEntity;
import org.zyd.store.term.GeneralizeHisTerm;

/**
 * 
 * GeneralizeHisMapper
 *
 * @author GeJianKui
 *
 */
public interface GeneralizeHisMapper extends DBActionMapper<GeneralizeHisEntity, GeneralizeHisTerm>,
        PaginatingMapper<GeneralizeHisEntity, GeneralizeHisTerm> {
	
}
