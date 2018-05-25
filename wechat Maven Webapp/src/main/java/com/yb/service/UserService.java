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
}
