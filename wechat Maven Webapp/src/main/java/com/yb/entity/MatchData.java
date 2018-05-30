package com.yb.entity;

import java.util.Date;

public class MatchData {
	private Team home;
	private Team visit;
	private String time;
	public MatchData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatchData(Team home, Team visit, String time) {
		super();
		this.home = home;
		this.visit = visit;
		this.time = time;
	}
	@Override
	public String toString() {
		return "MatchData [home=" + home + ", visit=" + visit + ", time="
				+ time + "]";
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
