package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.LabelInfoEntity;
import org.zyd.store.term.LabelInfoTerm;

import java.util.List;

/**
 * 
 * LabelInfoMapper
 *
 * @author GeJianKui
 *
 */
public interface LabelInfoMapper extends DBActionMapper<LabelInfoEntity, LabelInfoTerm>,
        PaginatingMapper<LabelInfoEntity, LabelInfoTerm> {
	List<LabelInfoEntity> selectByKeys(List<Integer> ids);
}
