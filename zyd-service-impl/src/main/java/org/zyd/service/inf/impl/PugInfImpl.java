package org.zyd.service.inf.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.PugSearchVo;
import org.zyd.domain.bean.PugInfoBean;
import org.zyd.domain.factory.PugInfoFactory;
import org.zyd.domain.repository.PugRepos;
import org.zyd.service.convertor.PugInfoConvertor;
import org.zyd.service.dto.PugCategoryDto;
import org.zyd.service.dto.PugInfoDto;
import org.zyd.service.inf.PugInf;

import java.util.ArrayList;
import java.util.List;

public class PugInfImpl implements PugInf {

	@Autowired
	private PugInfoFactory pugInfoFactory;
	@Autowired
	private PugRepos pugRepos;
	@Autowired
	private PugInfoConvertor pugInfoConvertor;

	@Override
	public void createPug(PugInfoDto pugInfoDto) throws ZydException {
		if (null == pugInfoDto) {
			throw new IllegalArgumentException();
		}
		if (StringUtils.isEmpty(pugInfoDto.getPugName())) {
			throw new ZydException(ErrorCode.EZYDP002);
		}
		//验证泥料名称
		PugInfoBean oldPug = pugRepos.queryPugInfoByName(pugInfoDto.getPugName());
		if (oldPug != null) {
			throw new ZydException(ErrorCode.EZYDP004);
		}
		PugInfoBean pug = pugInfoConvertor.convertPugInfo(pugInfoDto);
		pug.save();
	}

	@Override
	public void createPugCategory(PugCategoryDto pugCategoryDto) throws ZydException {

	}

	@Override
	public PugInfoDto queryPugInfo(Integer pugId) throws ZydException {
		if (null == pugId) {
			throw new IllegalArgumentException();
		}

		return pugInfoConvertor.convertPugInfo(pugRepos.queryPugInfoByKey(pugId));
	}

	@Override
	public PugInfoDto queryPugInfoWithRefInfoAndThanksByKey(Integer pugId) throws ZydException {
		if (null == pugId) {
			throw new IllegalArgumentException();
		}

		return pugInfoConvertor.convertPugInfo(pugRepos.queryPugInfoWithRefInfoAndThanksByKey(pugId));
	}

	@Override
	public List<PugInfoDto> queryPugInfos(PugSearchVo searchVo) throws ZydException {
		if (null == searchVo) {
			throw new IllegalArgumentException();
		}
		List<PugInfoBean> pugs = pugRepos.queryPugs(searchVo);
		if (CollectionUtils.isEmpty(pugs)) {
			return null;
		}
		List<PugInfoDto> dtos = new ArrayList<PugInfoDto>();
		for (PugInfoBean pug : pugs) {
			dtos.add(pugInfoConvertor.convertPugInfo(pug));
		}
		return dtos;
	}

	@Override
	public void updatePugInfo(PugInfoDto pugInfoDto) throws ZydException {
		if (null == pugInfoDto) {
			throw new IllegalArgumentException();
		}
		if (pugInfoDto.getPugId() == null) {
			throw new ZydException(ErrorCode.EZYDP007);
		}
		PugInfoBean pug = pugInfoConvertor.convertPugInfo(pugInfoDto);
		pug.change();
	}

	@Override
	public void removePugInfo(Integer pugId) throws ZydException {
		if (null == pugId) {
			throw new IllegalArgumentException();
		}
		PugInfoBean pug = pugInfoFactory.createPugInfoBean();
		pug.setPugId(pugId);
		pug.remove();
	}

}
