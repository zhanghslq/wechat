package com.yb.entity;
/**
 * 用来接收前段传的生成契约的数据
 * @author lenovo
 *
 */
public class ContractCome {
	private String code;//用戶携帶code
	private String id;
	private Integer guessType;//竞猜类型，可以0代表输赢，1代表比分
	private String stakeId;
	private Integer status;
	private Integer stakeType;
	private String stakeText;//备用，
	private String myGuess;
	private Integer matchId;
	public ContractCome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContractCome(String code, String id, Integer guessType,
			String stakeId, Integer status, Integer stakeType,
			String stakeText, String myGuess, Integer matchId) {
		super();
		this.code = code;
		this.id = id;
		this.guessType = guessType;
		this.stakeId = stakeId;
		this.status = status;
		this.stakeType = stakeType;
		this.stakeText = stakeText;
		this.myGuess = myGuess;
		this.matchId = matchId;
	}
	@Override
	public String toString() {
		return "ContractCome [code=" + code + ", id=" + id + ", guessType="
				+ guessType + ", stakeId=" + stakeId + ", status=" + status
				+ ", stakeType=" + stakeType + ", stakeText=" + stakeText
				+ ", myGuess=" + myGuess + ", matchId=" + matchId + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getGuessType() {
		return guessType;
	}
	public void setGuessType(Integer guessType) {
		this.guessType = guessType;
	}
	public String getStakeId() {
		return stakeId;
	}
	public void setStakeId(String stakeId) {
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
	
	
}
