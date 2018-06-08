package com.yb.entity;

import java.util.List;

/**
 * 群pk的契约详情
 * @author lenovo
 *
 */
public class ContractGroupDetails {
	private String stageName;//赛事名称
	private Team home;
	private Team visit;
	private Integer guessType;
	private List<User> loser;
	private List<User> success;
	private Long currencys;//当前比赛的下注总金币
	private List<String> nearLogo;//最近进入房间的五个邮箱
	private Integer number;//房间人数   
	private List<JoinData> joiners;
	private User user;
	private Integer contractStatus;

	@Override
	public String toString() {
		return "ContractGroupDetails{" +
				"stageName='" + stageName + '\'' +
				", home=" + home +
				", visit=" + visit +
				", guessType=" + guessType +
				", loser=" + loser +
				", success=" + success +
				", currencys=" + currencys +
				", nearLogo=" + nearLogo +
				", number=" + number +
				", joiners=" + joiners +
				", user=" + user +
				", contractStatus=" + contractStatus +
				'}';
	}

	public Integer getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(Integer contractStatus) {
		this.contractStatus = contractStatus;
	}

	public ContractGroupDetails(String stageName, Team home, Team visit, Integer guessType, List<User> loser, List<User> success, Long currencys, List<String> nearLogo, Integer number, List<JoinData> joiners, User user, Integer contractStatus) {

		this.stageName = stageName;
		this.home = home;
		this.visit = visit;
		this.guessType = guessType;
		this.loser = loser;
		this.success = success;
		this.currencys = currencys;
		this.nearLogo = nearLogo;
		this.number = number;
		this.joiners = joiners;
		this.user = user;
		this.contractStatus = contractStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ContractGroupDetails(String stageName, Team home, Team visit, Integer guessType, List<User> loser, List<User> success, Long currencys, List<String> nearLogo, Integer number, List<JoinData> joiners, User user) {

		this.stageName = stageName;
		this.home = home;
		this.visit = visit;
		this.guessType = guessType;
		this.loser = loser;
		this.success = success;
		this.currencys = currencys;
		this.nearLogo = nearLogo;
		this.number = number;
		this.joiners = joiners;
		this.user = user;
	}

	public ContractGroupDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContractGroupDetails(String stageName, Team home, Team visit,
			Integer guessType, List<User> loser, List<User> success,
			Long currencys, List<String> nearLogo, Integer number,
			List<JoinData> joiners) {
		super();
		this.stageName = stageName;
		this.home = home;
		this.visit = visit;
		this.guessType = guessType;
		this.loser = loser;
		this.success = success;
		this.currencys = currencys;
		this.nearLogo = nearLogo;
		this.number = number;
		this.joiners = joiners;
	}

	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
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
	public Integer getGuessType() {
		return guessType;
	}
	public void setGuessType(Integer guessType) {
		this.guessType = guessType;
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
	public List<String> getNearLogo() {
		return nearLogo;
	}
	public void setNearLogo(List<String> nearLogo) {
		this.nearLogo = nearLogo;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public List<JoinData> getJoiners() {
		return joiners;
	}
	public void setJoiners(List<JoinData> joiners) {
		this.joiners = joiners;
	}
	
}
