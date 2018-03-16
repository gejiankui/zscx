package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.WeixinReplyContentEntity;
import org.zyd.store.term.WeixinReplyContentTerm;

/**
 * 
 * WeixinReplyContentMapper
 *
 * @author GeJianKui
 *
 */
public interface WeixinReplyContentMapper extends DBActionMapper<WeixinReplyContentEntity, WeixinReplyContentTerm>,
        PaginatingMapper<WeixinReplyContentEntity, WeixinReplyContentTerm> {
	
}
