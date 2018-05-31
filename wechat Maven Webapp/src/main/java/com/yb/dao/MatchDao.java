package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Match;

//比赛信息
public interface MatchDao {
	//查询未来48小时以内的球赛
	List<Match> queryMatches(@Param("openid")String openid);
	
	void insertMatches(@Param("matchs")List<Match> matchs);
	
	Match queryById(@Param("id")Integer id);
	
	//查询比赛出结果的，进行人工干预，只查询过去两天之内的
	List<Match> queryMatchDone();
	//更改比赛状态和比分的
	void updateMatch(@Param("id")Integer id,@Param("status")Integer status,
			@Param("homeGrade")Integer homeGrade,@Param("visitGrade")Integer visitGrade);
	
}
