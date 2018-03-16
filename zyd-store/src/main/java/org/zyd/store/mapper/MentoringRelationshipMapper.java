package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.MentoringRelationshipEntity;
import org.zyd.store.term.MentoringRelationshipTerm;

/**
 * 
 * MentoringRelationshipMapper
 *
 * @author GeJianKui
 *
 */
public interface MentoringRelationshipMapper extends DBActionMapper<MentoringRelationshipEntity, MentoringRelationshipTerm>,
        PaginatingMapper<MentoringRelationshipEntity, MentoringRelationshipTerm> {
	
}
