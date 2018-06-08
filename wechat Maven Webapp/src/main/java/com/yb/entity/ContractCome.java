package com.yb.entity;
/**
 * 用来接收前段传的生成契约的数据
 * @author lenovo
 *
 */
public class ContractCome {
	private String openId;//用戶携帶code
	private Integer id;
	private Integer guessType;//竞猜类型，可以0代表输赢，1代表比分
	private Integer stakeId;
	private Integer status;
	private Integer stakeType;
	private String stakeText;//备用，
	private String myGuess;
	private Integer matchId;
	private Integer number;//留给群pk使用
	private Integer number1;

	@Override
	public String toString() {
		return "ContractCome{" +
				"openId='" + openId + '\'' +
				", id=" + id +
				", guessType=" + guessType +
				", stakeId=" + stakeId +
				", status=" + status +
				", stakeType=" + stakeType +
				", stakeText='" + stakeText + '\'' +
				", myGuess='" + myGuess + '\'' +
				", matchId=" + matchId +
				", number=" + number +
				", number1=" + number1 +
				'}';
	}

	public Integer getNumber1() {
		return number1;
	}

	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	public ContractCome(String openId) {

		this.openId = openId;
	}

	public ContractCome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContractCome(String openId, Integer id, Integer guessType,
			Integer stakeId, Integer status, Integer stakeType,
			String stakeText, String myGuess, Integer matchId, Integer number) {
		super();
		this.openId = openId;
		this.id = id;
		this.guessType = guessType;
		this.stakeId = stakeId;
		this.status = status;
		this.stakeType = stakeType;
		this.stakeText = stakeText;
		this.myGuess = myGuess;
		this.matchId = matchId;
		this.number = number;
	}

	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
