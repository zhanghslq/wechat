package com.yb.entity;

import java.util.List;



/**
 * 用户信息以及历史战绩
 * @author lenovo
 *
 */
public class UserAndHistory {
	private User user;
	private String rate;
	private List<History> histories;
	private String evaluation;
	private String description;

	@Override
	public String toString() {
		return "UserAndHistory{" +
				"user=" + user +
				", rate='" + rate + '\'' +
				", histories=" + histories +
				", evaluation='" + evaluation + '\'' +
				", description='" + description + '\'' +
				'}';
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserAndHistory(User user, String rate, List<History> histories, String evaluation, String description) {

		this.user = user;
		this.rate = rate;
		this.histories = histories;
		this.evaluation = evaluation;
		this.description = description;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public UserAndHistory(User user, String rate, List<History> histories, String evaluation) {

		this.user = user;
		this.rate = rate;
		this.histories = histories;
		this.evaluation = evaluation;
	}

	public List<History> getHistories() {
		return histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public UserAndHistory(User user, String rate, List<History> histories) {
		super();
		this.user = user;
		this.rate = rate;
		this.histories = histories;
	}

	public UserAndHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAndHistory(User user, String rate) {
		super();
		this.user = user;
		this.rate = rate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
}
