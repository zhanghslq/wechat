package com.yb.entity;

public class User {
	private String openid;
	private String imageUrl;
	private String nickname;
	private Integer currency;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String openid, String imageUrl, String nickname,
			Integer currency) {
		super();
		this.openid = openid;
		this.imageUrl = imageUrl;
		this.nickname = nickname;
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "User [openid=" + openid + ", imageUrl=" + imageUrl
				+ ", nickname=" + nickname + ", currency=" + currency + "]";
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
	
}
