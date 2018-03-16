package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.CarouselFigureEntity;
import org.zyd.store.term.CarouselFigureTerm;

/**
 * 
 * CarouselFigureMapper
 *
 * @author GeJianKui
 *
 */
public interface CarouselFigureMapper extends DBActionMapper<CarouselFigureEntity, CarouselFigureTerm>,
        PaginatingMapper<CarouselFigureEntity, CarouselFigureTerm> {
	
}
