package com.yb.entity;

import java.util.Date;

public class User {
	private Integer id;
	private String openid;
	private String imageUrl;
	private String nickname;
	private Integer currency;
	private Integer wins;
	private Date lasttime;
	private Integer rownum;
	private String message;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String openid, String imageUrl, String nickname,
			Integer currency, Integer wins, Date lasttime) {
		super();
		this.openid = openid;
		this.imageUrl = imageUrl;
		this.nickname = nickname;
		this.currency = currency;
		this.wins = wins;
		this.lasttime = lasttime;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User(String openid, String imageUrl, String nickname,
			Integer currency, Integer wins, Date lasttime, Integer rownum,
			String message) {
		super();
		this.openid = openid;
		this.imageUrl = imageUrl;
		this.nickname = nickname;
		this.currency = currency;
		this.wins = wins;
		this.lasttime = lasttime;
		this.rownum = rownum;
		this.message = message;
	}
	@Override
	public String toString() {
		return "User [openid=" + openid + ", imageUrl=" + imageUrl
				+ ", nickname=" + nickname + ", currency=" + currency
				+ ", wins=" + wins + ", lasttime=" + lasttime + ", rownum="
				+ rownum + ", message=" + message + "]";
	}
	
	public Integer getRownum() {
		return rownum;
	}
	public void setRownum(Integer rownum) {
		this.rownum = rownum;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getCurrency() {
		return currency;
	}
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	public Integer getWins() {
		return wins;
	}
	public void setWins(Integer wins) {
		this.wins = wins;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	
	
}
