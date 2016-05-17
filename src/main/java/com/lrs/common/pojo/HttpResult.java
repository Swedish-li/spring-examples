package com.lrs.common.pojo;

public class HttpResult {
	private Integer code;
	private String data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "HttpResult [code=" + code + ", data=" + data + "]";
	}

}
