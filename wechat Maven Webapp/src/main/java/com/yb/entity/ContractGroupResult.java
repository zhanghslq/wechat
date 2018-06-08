package com.yb.entity;

import java.util.List;

public class ContractGroupResult {
	private String message;
	private Team home;
	private Team visit;
	private List<User> loser;
	private List<User> success;
	private Long currencys;
	private String result;
	@Override
	public String toString() {
		return "ContractGroupResult{" +
				"message='" + message + '\'' +
				", home=" + home +
				", visit=" + visit +
				", loser=" + loser +
				", success=" + success +
				", currencys=" + currencys +
				", result='" + result + '\'' +
				'}';
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ContractGroupResult(String message, Team home, Team visit, List<User> loser, List<User> success, Long currencys, String result) {

		this.message = message;
		this.home = home;
		this.visit = visit;
		this.loser = loser;
		this.success = success;
		this.currencys = currencys;
		this.result = result;
	}

	public ContractGroupResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContractGroupResult(String message, Team home, Team visit,
			List<User> loser, List<User> success, Long currencys) {
		super();
		this.message = message;
		this.home = home;
		this.visit = visit;
		this.loser = loser;
		this.success = success;
		this.currencys = currencys;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public List<User> getLoser() {
		return loser;
	}
	public void setLoser(List<User> loser) {
		this.loser = loser;
	}
	public List<User> getSuccess() {
		return success;
	}
	public void setSuccess(List<User> success) {
		this.success = success;
	}
	public Long getCurrencys() {
		return currencys;
	}
	public void setCurrencys(Long currencys) {
		this.currencys = currencys;
	}
	
}
