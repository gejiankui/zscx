package org.zyd.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.CarouselFigureBean;
import org.zyd.domain.factory.CarouselFigureFactory;
import org.zyd.domain.repository.CarouselFigureRepos;
import org.zyd.domain.repository.WeixinReplyContentRepos;
import org.zyd.store.entity.CarouselFigureEntity;
import org.zyd.store.entity.WeixinReplyContentEntity;
import org.zyd.store.mapper.CarouselFigureMapper;
import org.zyd.store.mapper.WeixinReplyContentMapper;
import org.zyd.store.term.CarouselFigureTerm;
import org.zyd.store.term.WeixinReplyContentTerm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeixinReplyContentReposImpl implements WeixinReplyContentRepos {

	@Autowired
	private WeixinReplyContentMapper weixinReplyContentMapper;

	@Override
	public WeixinReplyContentEntity queryOneMenucodeOrKeyword(String key, String origType) {
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(origType)) {
			throw new IllegalArgumentException();
		}
		WeixinReplyContentTerm term = new WeixinReplyContentTerm();
		term.setTriggerKey(key);
		term.setEventOrigType(origType);
		List<WeixinReplyContentEntity> entities = weixinReplyContentMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		return entities.get(0);
	}

	@Override
	public List<WeixinReplyContentEntity> queryListByEventOrigType(String origType) {
		if (StringUtils.isEmpty(origType)) {
			throw new IllegalArgumentException();
		}
		WeixinReplyContentTerm term = new WeixinReplyContentTerm();
		term.setEventOrigType(origType);
		List<WeixinReplyContentEntity> entities = weixinReplyContentMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		return entities;
	}
}