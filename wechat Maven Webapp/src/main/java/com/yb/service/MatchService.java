package com.yb.service;

import java.util.List;

import com.yb.entity.Banner;
import com.yb.entity.Match;
import com.yb.entity.MatchData;

public interface MatchService {
	List<Banner> queryBanner(String openId);
	
	List<Match> queryMatchDone();

	void updateMatch(Integer id,Integer status,Integer homeGrade,Integer visitGrade);//回退版本，然后手动结算，改变比赛

	Match queryById(Integer id);

	void handResult(Match match);//没有回退只有手动结算

	void update(Match match);//这种只改变比赛，不管比赛结算

	List<Match> queryMatchesTwoHours();//两个小时之内的比赛，用于比赛提醒

	List<Match> queryStartedMatch();//已经开始的比赛
}
