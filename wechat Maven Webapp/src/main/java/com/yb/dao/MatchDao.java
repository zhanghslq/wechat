package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Match;

//比赛信息
public interface MatchDao {
	//查询未来48小时以内的球赛
	List<Match> queryMatches(@Param("openid")String openid);
	
	void insertMatches(@Param("matchs")List<Match> matchs);
}
