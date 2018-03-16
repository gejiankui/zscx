package org.zyd.service.convertor;

import org.zyd.service.dto.WeixinReplyContentDto;
import org.zyd.store.entity.WeixinReplyContentEntity;

public class WeixinReplyContentConvertor {

	public WeixinReplyContentDto convertReplyContent(WeixinReplyContentEntity entity) {
		if (null == entity) {
			return null;
		}
		WeixinReplyContentDto dto = new WeixinReplyContentDto();
		dto.setReplyId(entity.getReplyId());
		dto.setReplyType(entity.getReplyType());
		dto.setReplyCode(entity.getReplyCode());
		dto.setReplyContent(entity.getReplyContent());
		dto.setEventOrigType(entity.getEventOrigType());
		dto.setTriggerKey(entity.getTriggerKey());
		dto.setCreateBy(entity.getCreateBy());
		dto.setUpdateBy(entity.getUpdateBy());
		return dto;
	}

}
