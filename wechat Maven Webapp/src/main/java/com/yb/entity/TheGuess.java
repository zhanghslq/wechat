package com.yb.entity;

public class TheGuess {
	private String cid;
	private String type;
	private String nickname;
	private String imageUrl;
	private Integer number;
	private Integer status;
	public TheGuess() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TheGuess(String cid, String type, String nickname, String imageUrl,
			Integer number, Integer status) {
		super();
		this.cid = cid;
		this.type = type;
		this.nickname = nickname;
		this.imageUrl = imageUrl;
		this.number = number;
		this.status = status;
	}
	@Override
	public String toString() {
		return "TheGuess [cid=" + cid + ", type=" + type + ", nickname="
				+ nickname + ", imageUrl=" + imageUrl + ", number=" + number
				+ ", status=" + status + "]";
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
