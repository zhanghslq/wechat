package com.yb.entity;

import java.util.Date;
/**
 * 赛事banner
 * @author lenovo
 *
 */
public class Banner {
	private Integer id;//比赛id
	private Date time;
	private Team home;
	private Team visit;
	private Integer number;//参与本场竞猜人数
	private Boolean create;//是否创建
	private Boolean join;//是否参与
	private Boolean createGroup;
	private Boolean joinGroup;
	public Banner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Banner(Integer id, Date time, Team home, Team visit, Integer number,
			Boolean create, Boolean join, Boolean createGroup, Boolean joinGroup) {
		super();
		this.id = id;
		this.time = time;
		this.home = home;
		this.visit = visit;
		this.number = number;
		this.create = create;
		this.join = join;
		this.createGroup = createGroup;
		this.joinGroup = joinGroup;
	}
	@Override
	public String toString() {
		return "Banner [id=" + id + ", time=" + time + ", home=" + home
				+ ", visit=" + visit + ", number=" + number + ", create="
				+ create + ", join=" + join + ", createGroup=" + createGroup
				+ ", joinGroup=" + joinGroup + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Team getHome() {
		return home;
	}
	public void setHome(Team home) {
		this.home = home;
	}
	public Team getVisit() {
		return visit;
	}
	public void setVisit(Team visit) {
		this.visit = visit;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Boolean getCreate() {
		return create;
	}
	public void setCreate(Boolean create) {
		this.create = create;
	}
	public Boolean getJoin() {
		return join;
	}
	public void setJoin(Boolean join) {
		this.join = join;
	}
	public Boolean getCreateGroup() {
		return createGroup;
	}
	public void setCreateGroup(Boolean createGroup) {
		this.createGroup = createGroup;
	}
	public Boolean getJoinGroup() {
		return joinGroup;
	}
	public void setJoinGroup(Boolean joinGroup) {
		this.joinGroup = joinGroup;
	}
	
	
	
}
