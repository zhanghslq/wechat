package com.yb.service;

import com.yb.entity.RankData;
import com.yb.entity.User;

public interface UserService {
	//插入用户信息
	void insertUser(User user);
	//取用户信息
	User getUser(String openid);
	//获取排行榜
	RankData getRank(String code);
	//当天第一次登录，送100金币
	void updateCurrencys(String openId);
	
	User getUserStatus(String openid);
	
	void updateNameAndLogo(User user);
}
