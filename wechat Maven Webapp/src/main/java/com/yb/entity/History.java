package com.yb.entity;

import java.util.Date;

public class History {
	private String timeDesc;
	private Date time;
	private Integer cid;
	private String home;
	private String visit;
	private String type;//赌局类型
	private Integer joinNumber;//参与人数
	private String result;//猜测结果
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	public History(String timeDesc, Date time, Integer cid, String home,
			String visit, String type, Integer joinNumber, String result) {
		super();
		this.timeDesc = timeDesc;
		this.time = time;
		this.cid = cid;
		this.home = home;
		this.visit = visit;
		this.type = type;
		this.joinNumber = joinNumber;
		this.result = result;
	}
	@Override
	public String toString() {
		return "History [timeDesc=" + timeDesc + ", time=" + time + ", cid="
				+ cid + ", home=" + home + ", visit=" + visit + ", type="
				+ type + ", joinNumber=" + joinNumber + ", result=" + result
				+ "]";
	}
	public String getTimeDesc() {
		return timeDesc;
	}
	public void setTimeDesc(String timeDesc) {
		this.timeDesc = timeDesc;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getVisit() {
		return visit;
	}
	public void setVisit(String visit) {
		this.visit = visit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getJoinNumber() {
		return joinNumber;
	}
	public void setJoinNumber(Integer joinNumber) {
		this.joinNumber = joinNumber;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
