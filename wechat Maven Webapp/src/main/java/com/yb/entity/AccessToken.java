package com.yb.entity;

import java.util.Date;

public class AccessToken {
	private String access_token;
	private Integer expires_in;
	private Date created_time;

	@Override
	public String toString() {
		return "AccessToken{" +
				"access_token='" + access_token + '\'' +
				", expires_in=" + expires_in +
				", created_time=" + created_time +
				'}';
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public AccessToken(String access_token, Integer expires_in, Date created_time) {

		this.access_token = access_token;
		this.expires_in = expires_in;
		this.created_time = created_time;
	}

	public AccessToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccessToken(String access_token, Integer expires_in) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
	}

	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	
}
