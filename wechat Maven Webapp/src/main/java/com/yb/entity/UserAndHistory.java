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

	@Override
	public String toString() {
		return "UserAndHistory [user=" + user + ", rate=" + rate
				+ ", histories=" + histories + "]";
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
