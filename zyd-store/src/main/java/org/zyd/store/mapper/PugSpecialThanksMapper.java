package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PugSpecialThanksEntity;
import org.zyd.store.term.PugSpecialThanksTerm;

/**
 * 
 * PugSpecialThanksMapper
 *
 * @author GeJianKui
 *
 */
public interface PugSpecialThanksMapper extends DBActionMapper<PugSpecialThanksEntity, PugSpecialThanksTerm>,
        PaginatingMapper<PugSpecialThanksEntity, PugSpecialThanksTerm> {
	
}
