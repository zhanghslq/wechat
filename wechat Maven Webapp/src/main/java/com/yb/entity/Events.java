package com.yb.entity;

public class Events {
	private Integer id;
	private String name;
	private String logo;
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Events(Integer id, String name, String logo) {
		super();
		this.id = id;
		this.name = name;
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "Events [id=" + id + ", name=" + name + ", logo=" + logo + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}
