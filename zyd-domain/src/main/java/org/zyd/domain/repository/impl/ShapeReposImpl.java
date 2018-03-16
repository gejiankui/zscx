package org.zyd.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.zyd.common.exception.ZydException;
import org.zyd.common.vo.ShapeSearchVo;
import org.zyd.domain.bean.ShapeInfoBean;
import org.zyd.domain.factory.ShapeInfoFactory;
import org.zyd.domain.repository.ShapeRepos;
import org.zyd.store.entity.*;
import org.zyd.store.mapper.*;
import org.zyd.store.term.ShapeInfoTerm;
import org.zyd.store.term.ShapeReferencesTerm;
import org.zyd.store.term.ShapeSpecialThanksTerm;

import java.util.ArrayList;
import java.util.List;

public class ShapeReposImpl implements ShapeRepos {

	@Autowired
	private ShapeInfoMapper shapeInfoMapper;
	@Autowired
	private ShapeInfoFactory shapeInfoFactory;
	@Autowired
	private ReferencesInfoMapper referencesInfoMapper;
	@Autowired
	private ShapeReferencesMapper shapeReferencesMapper;
	@Autowired
	private ShapeSpecialThanksMapper shapeSpecialThanksMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public ShapeInfoBean queryShapeInfoByKey(Integer shapeId) throws ZydException {
		if (null == shapeId) {
			throw new IllegalArgumentException();
		}
		ShapeInfoTerm term = new ShapeInfoTerm();
		term.setShapeId(shapeId);
		List<ShapeInfoEntity> entities = shapeInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		return shapeInfoFactory.createShapeInfoBean(entities.get(0));
	}

	@Override
	public ShapeInfoBean queryShapeInfoWithRefInfoAndThanksByKey(Integer shapeId) throws ZydException {
		if (null == shapeId) {
			throw new IllegalArgumentException();
		}
		ShapeInfoTerm term = new ShapeInfoTerm();
		term.setShapeId(shapeId);
		List<ShapeInfoEntity> entities = shapeInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		ShapeInfoBean shapeInfoBean = shapeInfoFactory.createShapeInfoBean(entities.get(0));

		//参考文献
		ShapeReferencesTerm shapeRefTerm = new ShapeReferencesTerm();
		shapeRefTerm.setShapeId(shapeId);
		List<ShapeReferencesEntity> shapeReferencesEntityList = shapeReferencesMapper.select(shapeRefTerm);
		if (!CollectionUtils.isEmpty(shapeReferencesEntityList)) {
			List<Integer> refIds = new ArrayList<Integer>();
			for (ShapeReferencesEntity entity : shapeReferencesEntityList) {
				refIds.add(entity.getRefId());
			}
			List<ReferencesInfoEntity> refInfos = referencesInfoMapper.selectByKeys(refIds);
			shapeInfoBean.setReferencesInfo(refInfos);
		}

		//特别鸣谢
		ShapeSpecialThanksTerm shapeSpecialThanksTerm = new ShapeSpecialThanksTerm();
		shapeSpecialThanksTerm.setShapeId(shapeId);
		List<ShapeSpecialThanksEntity> shapeSpecialThanksEntityList = shapeSpecialThanksMapper.select(shapeSpecialThanksTerm);
		if (!CollectionUtils.isEmpty(shapeSpecialThanksEntityList)) {
			List<Integer> userIds = new ArrayList<Integer>();
			for (ShapeSpecialThanksEntity entity : shapeSpecialThanksEntityList) {
				userIds.add(entity.getUserId());
			}
			List<UserInfoEntity> userInfos = userInfoMapper.selectByKeys(userIds);
			shapeInfoBean.setSpecialThanks(userInfos);
		}
		return shapeInfoBean;
	}

	@Override
	public ShapeInfoBean queryShapeInfoByName(String shapeName) throws ZydException {
		if (StringUtils.isEmpty(shapeName)) {
			throw new IllegalArgumentException();
		}
		ShapeInfoTerm term = new ShapeInfoTerm();
		term.setShapeName(shapeName);
		List<ShapeInfoEntity> entities = shapeInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		return shapeInfoFactory.createShapeInfoBean(entities.get(0));
	}

	@Override
	public List<ShapeInfoBean> queryShapes(ShapeSearchVo shapeSearchVo) throws ZydException {
		if (null == shapeSearchVo) {
			throw new IllegalArgumentException();
		}
		ShapeInfoTerm term = new ShapeInfoTerm();
		term.setShapeName(shapeSearchVo.getShapeName());
		term.setShapeFullSpell(shapeSearchVo.getShapeFullSpell());
		term.setShapeSimpleSpell(shapeSearchVo.getShapeSimpleSpell());
		List<ShapeInfoEntity> entities = shapeInfoMapper.select(term);
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		List<ShapeInfoBean> rlt = new ArrayList<ShapeInfoBean>();
		for (ShapeInfoEntity entity : entities) {
			rlt.add(shapeInfoFactory.createShapeInfoBean(entity));
		}
		return rlt;
	}

}
