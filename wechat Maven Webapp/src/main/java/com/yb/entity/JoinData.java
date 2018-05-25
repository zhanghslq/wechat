package com.yb.entity;
/**
 * 群pk中下注人数
 * @author lenovo
 *
 */
public class JoinData {
	private String name;
	private String imageUrl;
	private String myGuess;
	private Integer number;
	public JoinData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JoinData(String name, String imageUrl, String myGuess, Integer number) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.myGuess = myGuess;
		this.number = number;
	}
	@Override
	public String toString() {
		return "JoinData [name=" + name + ", imageUrl=" + imageUrl
				+ ", myGuess=" + myGuess + ", number=" + number + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getMyGuess() {
		return myGuess;
	}
	public void setMyGuess(String myGuess) {
		this.myGuess = myGuess;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
