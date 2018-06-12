package com.yb.entity;

import java.util.List;

/**
 * 普通契约完成的返回
 * @author lenovo
 *
 */
public class ContractDone {
	private String result;
	private String message;
	private List<User> loser;
	private List<User> success;
	private Team home;
	private Team visit;
	private String logo;
	private String stakeText;
	private Integer joinNumber;

	@Override
	public String toString() {
		return "ContractDone{" +
				"result='" + result + '\'' +
				", message='" + message + '\'' +
				", loser=" + loser +
				", success=" + success +
				", home=" + home +
				", visit=" + visit +
				", logo='" + logo + '\'' +
				", stakeText='" + stakeText + '\'' +
				", joinNumber=" + joinNumber +
				'}';
	}

	public Integer getJoinNumber() {
		return joinNumber;
	}

	public void setJoinNumber(Integer joinNumber) {
		this.joinNumber = joinNumber;
	}

	public ContractDone(String result, String message, List<User> loser, List<User> success, Team home, Team visit, String logo, String stakeText, Integer joinNumber) {

		this.result = result;
		this.message = message;
		this.loser = loser;
		this.success = success;
		this.home = home;
		this.visit = visit;
		this.logo = logo;
		this.stakeText = stakeText;
		this.joinNumber = joinNumber;
	}

	public String getStakeText() {
		return stakeText;
	}

	public void setStakeText(String stakeText) {
		this.stakeText = stakeText;
	}

	public ContractDone(String result, String message, List<User> loser, List<User> success, Team home, Team visit, String logo, String stakeText) {

		this.result = result;
		this.message = message;
		this.loser = loser;
		this.success = success;
		this.home = home;
		this.visit = visit;
		this.logo = logo;
		this.stakeText = stakeText;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public ContractDone(String result, String message, List<User> loser, List<User> success, Team home, Team visit, String logo) {

		this.result = result;
		this.message = message;
		this.loser = loser;
		this.success = success;
		this.home = home;
		this.visit = visit;
		this.logo = logo;
	}

	public ContractDone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContractDone(String result, String message, List<User> loser,
			List<User> success, Team home, Team visit) {
		super();
		this.result = result;
		this.message = message;
		this.loser = loser;
		this.success = success;
		this.home = home;
		this.visit = visit;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	
}
