package com.yb.service;

import com.yb.entity.User;


public interface UserService {
	void insertUser(User user);
	//取用户信息
	User getUser(String openid);
}
