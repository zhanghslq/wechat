package com.yb.entity;

import java.util.Date;

public class Match {
	private Integer id;
	private Integer eventid;
	private Integer status;//比赛状态
	private Date time;
	private Integer homeid;
	private Integer home_grade;//暂时没考虑比分为小数的情况，需要的话奥该数据类型并修改数据库类型
	private Integer visitid;
	private Integer visit_grade;
	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Match(Integer id, Integer eventid, Integer status, Date time,
			Integer homeid, Integer home_grade, Integer visitid,
			Integer visit_grade) {
		super();
		this.id = id;
		this.eventid = eventid;
		this.status = status;
		this.time = time;
		this.homeid = homeid;
		this.home_grade = home_grade;
		this.visitid = visitid;
		this.visit_grade = visit_grade;
	}
	@Override
	public String toString() {
		return "Match [id=" + id + ", eventid=" + eventid + ", status="
				+ status + ", time=" + time + ", homeid=" + homeid
				+ ", home_grade=" + home_grade + ", visitid=" + visitid
				+ ", visit_grade=" + visit_grade + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEventid() {
		return eventid;
	}
	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getHomeid() {
		return homeid;
	}
	public void setHomeid(Integer homeid) {
		this.homeid = homeid;
	}
	public Integer getHome_grade() {
		return home_grade;
	}
	public void setHome_grade(Integer home_grade) {
		this.home_grade = home_grade;
	}
	public Integer getVisitid() {
		return visitid;
	}
	public void setVisitid(Integer visitid) {
		this.visitid = visitid;
	}
	public Integer getVisit_grade() {
		return visit_grade;
	}
	public void setVisit_grade(Integer visit_grade) {
		this.visit_grade = visit_grade;
	}
	
}
