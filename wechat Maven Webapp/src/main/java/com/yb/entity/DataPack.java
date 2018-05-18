package com.yb.entity;

public class DataPack {
	private String name;
	private Integer grade;
	private String description;
	public DataPack() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataPack(String name, Integer grade, String description) {
		super();
		this.name = name;
		this.grade = grade;
		this.description = description;
	}
	@Override
	public String toString() {
		return "DataPack [name=" + name + ", grade=" + grade + ", description="
				+ description + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
