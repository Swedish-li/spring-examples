package com.lrs.common.pojo;

import java.util.List;

public class PageResult<T> {
	private List<T> rows;
	private Integer total;

	public List<T> getRows() {
		return rows;
	}

	public PageResult(List<T> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
