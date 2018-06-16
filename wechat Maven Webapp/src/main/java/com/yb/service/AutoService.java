package com.yb.service;

import com.yb.entity.Match;

public interface AutoService {
	void autoCheck();
	void autoResult();
	void autoData();
	void handResult(Match match);//手动结算
	void autoRevertResult(Match match);//手动回退比赛
	void autoAccessToken();
}
