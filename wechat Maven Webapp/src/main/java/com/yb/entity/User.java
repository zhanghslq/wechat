package com.yb.entity;

import java.util.Date;
/**
 * 用户信息，新加all
 * @author lenovo
 *
 */
public class User {
	private Integer id;
	private String code;
	private String openid;
	private String imageUrl;
	private String nickname;
	private Integer currency;
	private Integer wins;
	private Integer allNumber;
	private Date lasttime;
	private Integer rownum;
	private String message;
	private Integer continuWins;
	
	public Integer getContinuWins() {
		return continuWins;
	}
	public void setContinuWins(Integer continuWins) {
		this.continuWins = continuWins;
	}
	public User(Integer id, String code, String openid, String imageUrl,
			String nickname, Integer currency, Integer wins, Integer allNumber,
			Date lasttime, Integer rownum, String message, Integer continuWins) {
		super();
		this.id = id;
		this.code = code;
		this.openid = openid;
		this.imageUrl = imageUrl;
		this.nickname = nickname;
		this.currency = currency;
		this.wins = wins;
		this.allNumber = allNumber;
		this.lasttime = lasttime;
		this.rownum = rownum;
		this.message = message;
		this.continuWins = continuWins;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String code, String openid, String imageUrl,
			String nickname, Integer currency, Integer wins, Date lasttime,
			Integer rownum, String message) {
		super();
		this.id = id;
		this.code = code;
		this.openid = openid;
		this.imageUrl = imageUrl;
		this.nickname = nickname;
		this.currency = currency;
		this.wins = wins;
		this.lasttime = lasttime;
		this.rownum = rownum;
		this.message = message;
	}
	
	public Integer getAllNumber() {
		return allNumber;
	}
	public void setAllNumber(Integer allNumber) {
		this.allNumber = allNumber;
	}
	public User(Integer id, String code, String openid, String imageUrl,
			String nickname, Integer currency, Integer wins, Integer allNumber,
			Date lasttime, Integer rownum, String message) {
		super();
		this.id = id;
		this.code = code;
		this.openid = openid;
		this.imageUrl = imageUrl;
		this.nickname = nickname;
		this.currency = currency;
		this.wins = wins;
		this.allNumber = allNumber;
		this.lasttime = lasttime;
		this.rownum = rownum;
		this.message = message;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", code=" + code + ", openid=" + openid
				+ ", imageUrl=" + imageUrl + ", nickname=" + nickname
				+ ", currency=" + currency + ", wins=" + wins + ", allNumber="
				+ allNumber + ", lasttime=" + lasttime + ", rownum=" + rownum
				+ ", message=" + message + ", continuWins=" + continuWins + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public Integer getRownum() {
		return rownum;
	}
	public void setRownum(Integer rownum) {
		this.rownum = rownum;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
