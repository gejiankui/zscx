package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ReferencesInfoEntity;
import org.zyd.store.term.ReferencesInfoTerm;

import java.util.List;

/**
 * ReferencesInfoMapper
 *
 * @author GeJianKui
 */
public interface ReferencesInfoMapper extends DBActionMapper<ReferencesInfoEntity, ReferencesInfoTerm>,
		PaginatingMapper<ReferencesInfoEntity, ReferencesInfoTerm> {
	List<ReferencesInfoEntity> selectByKeys(List<Integer> ids);
}
