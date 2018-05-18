package com.yb.entity;

import java.util.List;

public class MatchData {
	private Team team;
	private Events events;
	private List<Object> matches;
	public MatchData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatchData(Team team, Events events, List<Object> matches) {
		super();
		this.team = team;
		this.events = events;
		this.matches = matches;
	}
	@Override
	public String toString() {
		return "MatchData [team=" + team + ", events=" + events + ", matches="
				+ matches + "]";
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Events getEvents() {
		return events;
	}
	public void setEvents(Events events) {
		this.events = events;
	}
	public List<Object> getMatches() {
		return matches;
	}
	public void setMatches(List<Object> matches) {
		this.matches = matches;
	}
	
}
