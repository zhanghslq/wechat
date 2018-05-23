package com.yb.entity;

import java.util.List;

/**
 * 获取契约详情
 * @author lenovo
 *
 */
public class ContractDetails {
	private Team home;//主队信息
	private Team visit;//客队信息
	private String message;//描述文案
	private Integer guessType;//竞猜类型
	private String myGuess;//我的竞猜内容
	private String stakeLogo;//赌注图标，如果是自定义类型，都是统一图标
	private String stakeText;//赌注内容
	private Integer matchStatus;//比赛状态
	private String miutes;//自动开局时间，有待考虑
	private String nickname;//发起人昵称
	private String logo;//发起人头像
	private List<User> contractDetails;//契约人
	public ContractDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContractDetails(Team home, Team visit, String message,
			Integer guessType, String myGuess, String stakeLogo,
			String stakeText, Integer matchStatus, String miutes,
			String nickname, String logo, List<User> contractDetails) {
		super();
		this.home = home;
		this.visit = visit;
		this.message = message;
		this.guessType = guessType;
		this.myGuess = myGuess;
		this.stakeLogo = stakeLogo;
		this.stakeText = stakeText;
		this.matchStatus = matchStatus;
		this.miutes = miutes;
		this.nickname = nickname;
		this.logo = logo;
		this.contractDetails = contractDetails;
	}
	@Override
	public String toString() {
		return "ContractDetails [home=" + home + ", visit=" + visit
				+ ", message=" + message + ", guessType=" + guessType
				+ ", myGuess=" + myGuess + ", stakeLogo=" + stakeLogo
				+ ", stakeText=" + stakeText + ", matchStatus=" + matchStatus
				+ ", miutes=" + miutes + ", nickname=" + nickname + ", logo="
				+ logo + ", contractDetails=" + contractDetails + "]";
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getGuessType() {
		return guessType;
	}
	public void setGuessType(Integer guessType) {
		this.guessType = guessType;
	}
	public String getMyGuess() {
		return myGuess;
	}
	public void setMyGuess(String myGuess) {
		this.myGuess = myGuess;
	}
	public String getStakeLogo() {
		return stakeLogo;
	}
	public void setStakeLogo(String stakeLogo) {
		this.stakeLogo = stakeLogo;
	}
	public String getStakeText() {
		return stakeText;
	}
	public void setStakeText(String stakeText) {
		this.stakeText = stakeText;
	}
	public Integer getMatchStatus() {
		return matchStatus;
	}
	public void setMatchStatus(Integer matchStatus) {
		this.matchStatus = matchStatus;
	}
	public String getMiutes() {
		return miutes;
	}
	public void setMiutes(String miutes) {
		this.miutes = miutes;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public List<User> getContractDetails() {
		return contractDetails;
	}
	public void setContractDetails(List<User> contractDetails) {
		this.contractDetails = contractDetails;
	}
	
	
}
