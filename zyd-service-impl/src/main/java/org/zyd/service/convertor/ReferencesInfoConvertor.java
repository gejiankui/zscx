package org.zyd.service.convertor;

import org.springframework.util.CollectionUtils;
import org.zyd.service.dto.ReferencesInfoDto;
import org.zyd.store.entity.ReferencesInfoEntity;

import java.util.ArrayList;
import java.util.List;

public class ReferencesInfoConvertor {

	public List<ReferencesInfoDto> convertReferencesInfo(List<ReferencesInfoEntity> entities) {
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		List<ReferencesInfoDto> dtos = new ArrayList<ReferencesInfoDto>();

		for (ReferencesInfoEntity entity : entities) {
			ReferencesInfoDto dto = new ReferencesInfoDto();
			dto.setRefId(entity.getRefId());
			dto.setRefName(entity.getRefName());
			dto.setAuthor(entity.getAuthor());
			dto.setIntroduction(entity.getIntroduction());
			dto.setPublicationDate(entity.getPublicationDate());
			dto.setCreateBy(entity.getCreateBy());
			dto.setUpdateBy(entity.getUpdateBy());
			dtos.add(dto);
		}
		return dtos;
	}
}
