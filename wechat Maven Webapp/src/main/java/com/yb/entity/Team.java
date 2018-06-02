package com.yb.entity;

public class Team {
	private Integer id;
	private String name_zh;
	private String logo;
	private Integer grade;
	private String country_logo;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(Integer id, String name_zh, String logo, Integer grade,
			String country_logo) {
		super();
		this.id = id;
		this.name_zh = name_zh;
		this.logo = logo;
		this.grade = grade;
		this.country_logo = country_logo;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", name_zh=" + name_zh + ", logo=" + logo
				+ ", grade=" + grade + ", country_logo=" + country_logo + "]";
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
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getCountry_logo() {
		return country_logo;
	}
	public void setCountry_logo(String country_logo) {
		this.country_logo = country_logo;
	}
	
}
