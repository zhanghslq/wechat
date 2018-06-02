package com.yb.entity;
/**
 * 阶段数据
 * @author lenovo
 *
 */
public class Stage {
	private Integer id;
	private Integer type;
	private Integer mode;
	private String name_zh;
	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stage(Integer id, Integer type, Integer mode, String name_zh) {
		super();
		this.id = id;
		this.type = type;
		this.mode = mode;
		this.name_zh = name_zh;
	}
	@Override
	public String toString() {
		return "Stage [id=" + id + ", type=" + type + ", mode=" + mode
				+ ", name_zh=" + name_zh + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	public String getName_zh() {
		return name_zh;
	}
	public void setName_zh(String name_zh) {
		this.name_zh = name_zh;
	}
	
}
