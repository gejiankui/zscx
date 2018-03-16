package org.zyd.domain.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.PugInfoBean;
import org.zyd.store.entity.MentoringRelationshipEntity;
import org.zyd.store.entity.PugInfoEntity;
import org.zyd.store.entity.ReferencesInfoEntity;
import org.zyd.store.entity.UserInfoEntity;
import org.zyd.store.mapper.PugInfoMapper;

import java.util.ArrayList;
import java.util.List;

public class PugInfoBeanImpl implements PugInfoBean {

	private PugInfoEntity entity;

	private List<ReferencesInfoEntity> referencesInfo;
	private List<UserInfoEntity> specialThanks;

	@Autowired
	private PugInfoMapper pugInfoMapper;

	public PugInfoBeanImpl(PugInfoEntity entity) {
		this.entity = entity;
	}

	@Override
	public Integer getPugId() {
		if (null == entity) {
			return null;
		}
		return entity.getPugId();
	}

	@Override
	public String getPugName() {
		if (null == entity) {
			return null;
		}
		return entity.getPugName();
	}

	@Override
	public String getPugFullSpell() {
		if (null == entity) {
			return null;
		}
		return entity.getPugFullSpell();
	}

	@Override
	public String getPugSimpleSpell() {
		if (null == entity) {
			return null;
		}
		return entity.getPugSimpleSpell();
	}

	@Override
	public String getThumbImg() {
		if (null == entity) {
			return null;
		}
		return entity.getThumbImg();
	}

	@Override
	public String getPugImg() {
		if (null == entity) {
			return null;
		}
		return entity.getPugImg();
	}

	@Override
	public Integer getCategoryId() {
		if (null == entity) {
			return null;
		}
		return entity.getCategoryId();
	}

	@Override
	public String getCategoryName() {
		if (null == entity) {
			return null;
		}
		return entity.getCategoryName();
	}

	@Override
	public String getIntroduction() {
		if (null == entity) {
			return null;
		}
		return entity.getIntroduction();
	}

	@Override
	public String getCreateBy() {
		if (null == entity) {
			return null;
		}
		return entity.getCreateBy();
	}

	@Override
	public String getUpdateBy() {
		if (null == entity) {
			return null;
		}
		return entity.getUpdateBy();
	}

	@Override
	public void setPugId(Integer pugId) {
		if (null == entity) {
			entity = new PugInfoEntity();
		}
		entity.setPugId(pugId);
	}

	@Override
	public void setPugName(String pugName) {
		if (null == entity) {
			entity = new PugInfoEntity();
		}
		entity.setPugName(pugName);
	}

	@Override
	public void setPugFullSpell(String pugFullSpell) {
		if (null == entity) {
			entity = new PugInfoEntity();
		}
		entity.setPugFullSpell(pugFullSpell);
	}

	@Override
	public void setPugSimpleSpell(String pugSimpleSpell) {
		if (null == entity) {
			entity = new PugInfoEntity();
		}
		entity.setPugSimpleSpell(pugSimpleSpell);
	}

	@Override
	public void setThumbImg(String thumbImg) {
		if (null == entity) {
			entity = new PugInfoEntity();
		}
		entity.setThumbImg(thumbImg);
	}

	@Override
	public void setPugImg(String pugImg) {
		if (null == entity) {
			entity = new PugInfoEntity();
		}
		entity.setPugImg(pugImg);
	}

	@Override
	public void setCategoryId(Integer categoryId) {
		if (null == entity) {
			entity = new PugInfoEntity();
		}
		entity.setCategoryId(categoryId);
	}

	@Override
	public void setCategoryName(String categoryName) {
		if (null == entity) {
			entity = new PugInfoEntity();
		}
		entity.setCategoryName(categoryName);
	}

	@Override
	public void setIntroduction(String introduction) {
		if (null == entity) {
			entity = new PugInfoEntity();
		}
		entity.setIntroduction(introduction);
	}

	@Override
	public void setCreateBy(String createBy) {
		if (null == entity) {
			entity = new PugInfoEntity();
		}
		entity.setCreateBy(createBy);
	}

	@Override
	public void setUpdateBy(String updateBy) {
		if (null == entity) {
			entity = new PugInfoEntity();
		}
		entity.setUpdateBy(updateBy);
	}

	@Override
	public List<ReferencesInfoEntity> getReferencesInfo() {
		return referencesInfo;
	}

	@Override
	public List<UserInfoEntity> getSpecialThanks() {
		return specialThanks;
	}

	@Override
	public void setReferencesInfo(List<ReferencesInfoEntity> referencesInfo) {
		if (referencesInfo == null) {
			referencesInfo = new ArrayList<ReferencesInfoEntity>();
		}
		this.referencesInfo = referencesInfo;
	}

	@Override
	public void setSpecialThanks(List<UserInfoEntity> specialThanks) {
		if (specialThanks == null) {
			specialThanks = new ArrayList<UserInfoEntity>();
		}
		this.specialThanks = specialThanks;
	}

	@Override
	public void save() throws ZydException {
		try {
			pugInfoMapper.insert(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void change() throws ZydException {
		try {
			pugInfoMapper.updateBySelective(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}
	}

	@Override
	public void remove() throws ZydException {
		try {
			pugInfoMapper.delete(this.entity);
		} catch (Exception e) {
			throw new ZydException(ErrorCode.EZYD0002, e);
		}

		if (null != entity) {
			entity.setPugId(null);
		}
	}
}
