package com.yb.entity;
/**
 * 用来接收前段传的生成契约的数据
 * @author lenovo
 *
 */
public class ContractCome {
	private Integer id;
	private Integer guessType;//竞猜类型，可以0代表输赢，1代表比分
	private Integer stakeId;
	private Integer stakeType;
	private String stakeText;//备用，
	private String myGuess;
	public ContractCome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContractCome(Integer id, Integer guessType, Integer stakeId,
			Integer stakeType, String stakeText, String myGuess) {
		super();
		this.id = id;
		this.guessType = guessType;
		this.stakeId = stakeId;
		this.stakeType = stakeType;
		this.stakeText = stakeText;
		this.myGuess = myGuess;
	}
	@Override
	public String toString() {
		return "ContractCome [id=" + id + ", guessType=" + guessType
				+ ", stakeId=" + stakeId + ", stakeType=" + stakeType
				+ ", stakeText=" + stakeText + ", myGuess=" + myGuess + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGuessType() {
		return guessType;
	}
	public void setGuessType(Integer guessType) {
		this.guessType = guessType;
	}
	public Integer getStakeId() {
		return stakeId;
	}
	public void setStakeId(Integer stakeId) {
		this.stakeId = stakeId;
	}
	public Integer getStakeType() {
		return stakeType;
	}
	public void setStakeType(Integer stakeType) {
		this.stakeType = stakeType;
	}
	public String getStakeText() {
		return stakeText;
	}
	public void setStakeText(String stakeText) {
		this.stakeText = stakeText;
	}
	public String getMyGuess() {
		return myGuess;
	}
	public void setMyGuess(String myGuess) {
		this.myGuess = myGuess;
	}
	
}
