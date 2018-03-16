package org.zyd.common.constants;

/**
 * 
 * 错误编码
 *
 */
public enum ErrorCode {
	EZYD0001("系统错误"),
	EZYD0002("数据库错误"),
	EZYD0003("用户ID与操作者ID不一致"),
	EZYD0004("不存在所要操作的记录"),

	EZYDE002("手机不能为空"),
	EZYDE003("手机格式不正确"),
	EZYDE006("姓名不能为空"),
	EZYDE007("姓名格式不正确"),
	EZYDE008("姓名长度最大为5个汉字"),
	EZYDE013("用户不存在"),
	EZYDE024("手机号码已存在"),
	EZYDE025("用户id不能为空"),
	EZYDE026("用户账号不存在"),
	EZYDE040("师傅不存在"),
	
	
	
	EZYDG000("推广信息不存在"),
	EZYDG001("开始时间不能为空"),
	EZYDG002("结束时间不能为空"),
	EZYDG003("推广位置不能为空"),
	EZYDG004("推广信息id不能为空"),
	EZYDG005("此推广位置用户信息已存在"),


	
	EZYDP001("泥料不存在"),
	EZYDP002("名称不能为空"),
	EZYDP003("泥料类目不能为空"),
	EZYDP004("泥料已经存在"),
	EZYDP005("泥料类目名称不能为空"),
	EZYDP006("泥料类目已经存在"),
	EZYDP007("泥料id不能为空"),


	EZYDC001("轮播图类型不能为空"),
	EZYDC002("开始时间不能为空"),
	EZYDC003("结束时间不能为空"),
	EZYDC004("轮播图信息不存在"),
	EZYDC005("图片地址不能为空"),
	EZYDC006("跳转地址不能为空"),
	EZYDC007("轮播图id不能为空"),



	EZYDS001("泥料不存在"),
	EZYDS002("名称不能为空"),
	EZYDS003("泥料类目不能为空"),
	EZYDS004("泥料已经存在"),
	EZYDS005("泥料类目名称不能为空"),
	EZYDS006("泥料类目已经存在"),
	EZYDS007("泥料id不能为空"),









	EZYDZ999("");
	
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	private ErrorCode(String desc) {
		this.desc = desc;
	}
}
