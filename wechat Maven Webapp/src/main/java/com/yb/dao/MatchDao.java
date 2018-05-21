package com.yb.dao;

import java.util.List;

import com.yb.entity.Match;

//比赛信息
public interface MatchDao {
	//查询未来48小时以内的球赛
	List<Match> queryMatches(String openid);
}
