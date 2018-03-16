package org.zyd.service.inf;

import org.zyd.common.constants.CarouselFigureType;
import org.zyd.common.exception.ZydException;
import org.zyd.service.dto.CarouselFigureDto;
import org.zyd.service.dto.GeneralizeSettingDto;

import java.util.List;

public interface CarouselFigureInf {

	/**
	 * 创建轮播图<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDC001 轮播图类型不能为空
	 * EZYDC002 开始时间不能为空
	 * EZYDC003 结束时间不能为空
	 * EZYDH003 推广位置不能为空
	 * </pre>
	 *
	 * @param carouselFigureDto 轮播图信息
	 * @throws ZydException
	 */
	void createCarouselFigure(CarouselFigureDto carouselFigureDto) throws ZydException;

	/**
	 * 查询轮播图<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param figureType
	 * @return 轮播图信息集合
	 * @throws ZydException
	 */
	List<CarouselFigureDto> queryCarouselFigure(CarouselFigureType figureType) throws ZydException;

	/**
	 * 修改轮播图信息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDC004 轮播图信息不存在
	 * </pre>
	 *
	 * @param carouselFigureDto 轮播图信息
	 * @throws ZydException
	 */
	void updateCarouselFigure(CarouselFigureDto carouselFigureDto) throws ZydException;

	/**
	 * 删除轮播图信息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDC004 轮播图信息不存在
	 *
	 * @param figureId 推广设置id
	 * @throws ZydException
	 * @see org.zyd.common.constants.ErrorCode
	 * </pre>
	 */
	void removeCarouselFigure(Integer figureId) throws ZydException;

}
