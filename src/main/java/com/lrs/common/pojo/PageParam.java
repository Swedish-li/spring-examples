package com.lrs.common.pojo;

public class PageParam<T> {
	/** 查询条件 */
	private T cond;
	/** 页码 */
	private Integer page;
	/** 页面数据条数 */
	private Integer rows;

	public T getCond() {
		return cond;
	}

	public void setCond(T cond) {
		this.cond = cond;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

}
