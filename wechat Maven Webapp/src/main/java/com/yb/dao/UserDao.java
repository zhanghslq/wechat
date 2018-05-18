package com.yb.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.User;


public interface UserDao {
	//存用户信息
	void insertUser(@Param("user")User user);
	//取用户信息
	User getUser(@Param("openid")String openid);
	//排行榜
	List<User> getRank(@Param("openid")String openid);
}
