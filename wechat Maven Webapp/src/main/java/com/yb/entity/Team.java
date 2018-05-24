package com.yb.entity;

public class Team {
	private Integer id;
	private String name_zh;
	private String logo;
	private Integer matchevent_id;//比賽ID
	private Integer grade;
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Team(Integer id, String name_zh, String logo, Integer matchevent_id,
			Integer grade) {
		super();
		this.id = id;
		this.name_zh = name_zh;
		this.logo = logo;
		this.matchevent_id = matchevent_id;
		this.grade = grade;
	}
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(Integer id, String name_zh, String logo, Integer matchevent_id) {
		super();
		this.id = id;
		this.name_zh = name_zh;
		this.logo = logo;
		this.matchevent_id = matchevent_id;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", name_zh=" + name_zh + ", logo=" + logo
				+ ", matchevent_id=" + matchevent_id + "]";
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
	public Integer getMatchevent_id() {
		return matchevent_id;
	}
	public void setMatchevent_id(Integer matchevent_id) {
		this.matchevent_id = matchevent_id;
	}
	
}
