package com.xt.weixinapi.holder.response;

import java.util.List;

/**
 * @author qinlei
 * @category 微信响应图文信息
 * @version v1.0
 */
public class NewsMessage extends BaseMessage
{
    // 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    private List<Item> Articles;


    public int getArticleCount()
    {
        return ArticleCount;
    }


    public void setArticleCount(int articleCount)
    {
        this.ArticleCount = articleCount;
    }


	public List<Item> getArticles() {
		return Articles;
	}


	public void setArticles(List<Item> articles) {
		Articles = articles;
	}


}
