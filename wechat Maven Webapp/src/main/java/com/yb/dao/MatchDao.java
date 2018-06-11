package com.yb.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Match;

//比赛信息
public interface MatchDao {
	//查询未来四场球赛，未开赛前使用
	List<Match> queryMatches(@Param("openid")String openid);
	//查询今天的比赛
	List<Match> queryMatchesToday(@Param("openid")String openid);

	//查询两个小时内的比赛,为赛事提醒做准备
	List<Match> queryMatchesTwoHours();

	//查询十分钟内的比赛,为赛事提醒做准备
	List<Match> queryMatchesTenMinutes();
	//插入数据
	void insertMatches(@Param("matchs")List<Match> matchs);
	
	Match queryById(@Param("id")Integer id);
	
	//查询比赛出结果的，进行人工干预，只查询过去两天之内的
	List<Match> queryMatchDone();
	//更改比赛状态和比分的
	void updateMatch(@Param("id")Integer id,@Param("status")Integer status,
			@Param("homeGrade")Integer homeGrade,@Param("visitGrade")Integer visitGrade);
	
	Integer queryRownum(@Param("time")Date time);



	
}
