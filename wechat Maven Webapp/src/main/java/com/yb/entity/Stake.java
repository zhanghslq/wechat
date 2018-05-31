package com.yb.entity;

import java.util.Date;

public class Stake {
	private Integer id;
	private Integer type;
	private String name;
	private String logo;
	private Date time;
	public Stake() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stake(Integer id, Integer type, String name, String logo, Date time) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.logo = logo;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Stake [id=" + id + ", type=" + type + ", name=" + name
				+ ", logo=" + logo + ", time=" + time + "]";
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
