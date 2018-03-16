package org.zyd.domain.repository;

import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.CarouselFigureBean;

import java.util.List;

public interface CarouselFigureRepos {

    /**
     * 综合查询
     *
     * @param figureType 推广位置 A0600010:泥料首页，A0600020:壶型首页
     * @return 轮播图
     * @throws ZydException
     */
    List<CarouselFigureBean> queryCarouseFigure(String figureType) throws ZydException;

}
