package com.yb.entity;

import java.util.Date;

/**
 * 用来插入数据库
 * @author lenovo
 *
 */
public class ContractData {
	private Integer id;
	private Integer guessType;
	private Integer stakeId;
	private Integer status;
	private Integer matchId;
	private Date time;
	public ContractData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContractData(Integer id, Integer guessType, Integer stakeId,
			Integer status, Integer matchId, Date time) {
		super();
		this.id = id;
		this.guessType = guessType;
		this.stakeId = stakeId;
		this.status = status;
		this.matchId = matchId;
		this.time = time;
	}
	@Override
	public String toString() {
		return "ContractData [id=" + id + ", guessType=" + guessType
				+ ", stakeId=" + stakeId + ", status=" + status + ", matchId="
				+ matchId + ", time=" + time + "]";
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
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
