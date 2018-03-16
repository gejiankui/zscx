package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.GeneralizeSettingEntity;
import org.zyd.store.term.GeneralizeSettingTerm;

/**
 * 
 * GeneralizeSettingMapper
 *
 * @author GeJianKui
 *
 */
public interface GeneralizeSettingMapper extends DBActionMapper<GeneralizeSettingEntity, GeneralizeSettingTerm>,
        PaginatingMapper<GeneralizeSettingEntity, GeneralizeSettingTerm> {
	
}
