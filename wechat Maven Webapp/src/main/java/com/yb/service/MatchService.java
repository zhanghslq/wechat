package com.yb.service;

import java.util.List;

import com.yb.entity.Banner;
import com.yb.entity.Match;
import com.yb.entity.MatchData;

public interface MatchService {
	List<Banner> queryBanner(String openId);
	
	List<Match> queryMatchDone();

	void updateMatch(Integer id,Integer status,Integer homeGrade,Integer visitGrade);

	Match queryById(Integer id);
}
