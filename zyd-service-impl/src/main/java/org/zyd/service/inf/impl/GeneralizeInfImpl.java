package org.zyd.service.inf.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.GeneralizeBean;
import org.zyd.domain.bean.UserInfoBean;
import org.zyd.domain.factory.GeneralizeFactory;
import org.zyd.domain.repository.GeneralizeRepos;
import org.zyd.domain.repository.UserRepos;
import org.zyd.service.convertor.GeneralizeConvertor;
import org.zyd.service.dto.GeneralizeSettingDto;
import org.zyd.service.inf.GeneralizeInf;

import java.util.ArrayList;
import java.util.List;

public class GeneralizeInfImpl implements GeneralizeInf {

	@Autowired
	private GeneralizeFactory generalizeFactory;
	@Autowired
	private GeneralizeRepos generalizeRepos;
	@Autowired
	private UserRepos userRepos;
	@Autowired
	private GeneralizeConvertor generalizeConvertor;

	@Override
	public void createGeneralize(GeneralizeSettingDto generalizeSettingDto) throws ZydException {
		if (null == generalizeSettingDto) {
			throw new IllegalArgumentException();
		}
		if (generalizeSettingDto.getUserId() == null) {
			throw new ZydException(ErrorCode.EZYDE025);
		}
		if (generalizeSettingDto.getBeginTime() == null) {
			throw new ZydException(ErrorCode.EZYDG001);
		}
		if (generalizeSettingDto.getEndTime() == null) {
			throw new ZydException(ErrorCode.EZYDG002);
		}
		if (generalizeSettingDto.getPosition() == null) {
			throw new ZydException(ErrorCode.EZYDG003);
		}
		UserInfoBean userInfo = userRepos.queryUserInfoByKey(generalizeSettingDto.getUserId());
		if (userInfo == null) {
			throw new ZydException(ErrorCode.EZYDE013);
		}
		GeneralizeBean old = generalizeRepos
				.queryGeneralizeByUser(generalizeSettingDto.getUserId(), generalizeSettingDto.getPosition());
		if (old != null) {
			throw new ZydException(ErrorCode.EZYDG005);
		}
		GeneralizeBean generalizeBean = generalizeConvertor.convertGeneralize(generalizeSettingDto);
		generalizeBean.setUserName(userInfo.getUserName());
		generalizeBean.save();
	}

	@Override
	public GeneralizeSettingDto queryGeneralize(Integer settingId) throws ZydException {
		if (null == settingId) {
			throw new IllegalArgumentException();
		}
		return generalizeConvertor.convertGeneralize(generalizeRepos.queryGeneralizeByKey(settingId));
	}

	@Override
	public List<GeneralizeSettingDto> queryGeneralizes(Integer position) throws ZydException {
		if (null == position) {
			throw new IllegalArgumentException();
		}
		List<GeneralizeBean> generalizes = generalizeRepos.queryGeneralizes(position);
		if (CollectionUtils.isEmpty(generalizes)) {
			return null;
		}
		List<GeneralizeSettingDto> dtos = new ArrayList<GeneralizeSettingDto>();
		for (GeneralizeBean generalize : generalizes) {
			dtos.add(generalizeConvertor.convertGeneralize(generalize));
		}
		return dtos;
	}

	@Override
	public void updateGeneralize(GeneralizeSettingDto generalizeSettingDto) throws ZydException {
		if (null == generalizeSettingDto) {
			throw new IllegalArgumentException();
		}
		if (generalizeSettingDto.getSettingId() == null) {
			throw new ZydException(ErrorCode.EZYDG004);
		}
		GeneralizeBean generalize = generalizeConvertor.convertGeneralize(generalizeSettingDto);
		generalize.change();
	}

	@Override
	public void removeGeneralize(Integer settingId) throws ZydException {
		if (null == settingId) {
			throw new IllegalArgumentException();
		}
		GeneralizeBean generalize = generalizeFactory.createGeneralizeBean();
		generalize.setSettingId(settingId);
		generalize.remove();
	}
}
