package com.yb.entity;

public class Events {
	private Integer id;
	private String name_zh;
	private String logo;
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Events(Integer id, String name_zh, String logo) {
		super();
		this.id = id;
		this.name_zh = name_zh;
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "Events [id=" + id + ", name_zh=" + name_zh + ", logo=" + logo
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName_zh() {
		return name_zh;
	}
	public void setName_zh(String name_zh) {
		this.name_zh = name_zh;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
}
