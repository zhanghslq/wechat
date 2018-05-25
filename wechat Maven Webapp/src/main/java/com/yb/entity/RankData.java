package com.yb.entity;

import java.util.List;

public class RankData {
	private Integer myRank;
	private List<User> ranks;
	public RankData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RankData(Integer myRank, List<User> ranks) {
		super();
		this.myRank = myRank;
		this.ranks = ranks;
	}
	@Override
	public String toString() {
		return "RankData [myRank=" + myRank + ", ranks=" + ranks + "]";
	}
	public Integer getMyRank() {
		return myRank;
	}
	public void setMyRank(Integer myRank) {
		this.myRank = myRank;
	}
	public List<User> getRanks() {
		return ranks;
	}
	public void setRanks(List<User> ranks) {
		this.ranks = ranks;
	}
	
}
