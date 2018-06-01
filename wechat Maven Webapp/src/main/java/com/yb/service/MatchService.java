package com.yb.service;

import java.util.List;

import com.yb.entity.Banner;
import com.yb.entity.Match;
import com.yb.entity.MatchData;

public interface MatchService {
	List<Banner> queryBanner(String openId);
	
	List<MatchData> queryMatchDone();
}
