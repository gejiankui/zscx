package org.zyd.service.inf.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.zyd.common.constants.CarouselFigureType;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.CarouselFigureBean;
import org.zyd.domain.factory.CarouselFigureFactory;
import org.zyd.domain.repository.CarouselFigureRepos;
import org.zyd.domain.repository.WeixinReplyContentRepos;
import org.zyd.service.convertor.CarouselFigureConvertor;
import org.zyd.service.convertor.WeixinReplyContentConvertor;
import org.zyd.service.dto.CarouselFigureDto;
import org.zyd.service.dto.WeixinReplyContentDto;
import org.zyd.service.inf.CarouselFigureInf;
import org.zyd.service.inf.WeixinReplyContentInf;
import org.zyd.store.entity.WeixinReplyContentEntity;

import java.util.ArrayList;
import java.util.List;

public class WeixinReplyContentInfImpl implements WeixinReplyContentInf {

	@Autowired
	private WeixinReplyContentRepos weixinReplyContentRepos;
	@Autowired
	private WeixinReplyContentConvertor weixinReplyContentConvertor;

	@Override
	public WeixinReplyContentDto queryOneMenucodeOrKeyword(String key, String origType) {
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(origType)) {
			throw new IllegalArgumentException();
		}
		WeixinReplyContentEntity replyContent = weixinReplyContentRepos.queryOneMenucodeOrKeyword(key, origType);
		if (replyContent == null) {
			return null;
		}
		return weixinReplyContentConvertor.convertReplyContent(replyContent);
	}

	@Override
	public List<WeixinReplyContentDto> getListByEventOrigType(String origType) {
		if (StringUtils.isEmpty(origType)) {
			throw new IllegalArgumentException();
		}
		List<WeixinReplyContentEntity> replyContents = weixinReplyContentRepos.queryListByEventOrigType(origType);
		if (CollectionUtils.isEmpty(replyContents)) {
			return null;
		}
		List<WeixinReplyContentDto> dtos = new ArrayList<WeixinReplyContentDto>();
		for (WeixinReplyContentEntity replyContent : replyContents) {
			dtos.add(weixinReplyContentConvertor.convertReplyContent(replyContent));
		}
		return dtos;
	}
}
