package com.yb.entity;

public class JoinContract {
	private String openId;
	private Integer cid;
	private String myGuess;
	public JoinContract() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JoinContract(String openId, Integer cid, String myGuess) {
		super();
		this.openId = openId;
		this.cid = cid;
		this.myGuess = myGuess;
	}
	@Override
	public String toString() {
		return "JoinContract [openId=" + openId + ", cid=" + cid + ", myGuess="
				+ myGuess + "]";
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getMyGuess() {
		return myGuess;
	}
	public void setMyGuess(String myGuess) {
		this.myGuess = myGuess;
	}
	
}
