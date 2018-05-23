package com.yb.entity;
/**
 * 契约详情的契约人列表
 * @author lenovo
 *
 */
public class ContractPeople {
	private String nickname;
	private String logo;
	private String myGuess;
	public ContractPeople() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContractPeople(String nickname, String logo, String myGuess) {
		super();
		this.nickname = nickname;
		this.logo = logo;
		this.myGuess = myGuess;
	}
	@Override
	public String toString() {
		return "ContractPeople [nickname=" + nickname + ", logo=" + logo
				+ ", myGuess=" + myGuess + "]";
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
	public String getMyGuess() {
		return myGuess;
	}
	public void setMyGuess(String myGuess) {
		this.myGuess = myGuess;
	}
	
}
