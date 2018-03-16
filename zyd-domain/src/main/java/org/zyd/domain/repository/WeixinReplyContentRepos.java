package org.zyd.domain.repository;

import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.WeixinReplyContentEntity;

import java.util.List;

public interface WeixinReplyContentRepos {

	/**
	 * 查询菜单对应的回复消息<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param menuCode
	 * @param menuType
	 * @return 菜单对应的回复消息
	 * @throws ZydException
	 */
	WeixinReplyContentEntity queryOneMenucodeOrKeyword(String menuCode, String menuType);

	/**
	 * 查询事件源类型对应的回复消息<p/>
	 * <p>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 *
	 * @param origType 轮播图信息
	 * @throws ZydException
	 */
	List<WeixinReplyContentEntity> queryListByEventOrigType(String origType);

}
