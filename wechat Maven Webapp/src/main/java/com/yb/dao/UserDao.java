package com.yb.dao;

import org.apache.ibatis.annotations.Param;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

public interface UserDao {
	//存用户信息
	void insertUser(@Param("user")User user);
	//取用户信息
	User getUser(@Param("openid")String openid);
}
