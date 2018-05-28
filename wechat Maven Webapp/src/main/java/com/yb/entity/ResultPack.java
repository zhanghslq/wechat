package com.yb.entity;
/**
 * 接口返回数据
 * @author lenovo
 *
 */
public class ResultPack {
	private Integer code;
	private Object data;
	public ResultPack() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultPack(Integer code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResultPack [code=" + code + ", data=" + data + "]";
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	
}
