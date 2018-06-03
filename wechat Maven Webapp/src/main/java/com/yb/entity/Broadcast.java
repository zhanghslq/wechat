package com.yb.entity;

import java.util.List;

/**
 * 用于直播
 * @author lenovo
 *
 */
public class Broadcast {
	private Integer id;
	private List<Incident> incidents;
	public Broadcast() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Broadcast(Integer id, List<Incident> incidents) {
		super();
		this.id = id;
		this.incidents = incidents;
	}
	@Override
	public String toString() {
		return "Broadcast [id=" + id + ", incidents=" + incidents + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Incident> getIncidents() {
		return incidents;
	}
	public void setIncidents(List<Incident> incidents) {
		this.incidents = incidents;
	}
	
	
}
