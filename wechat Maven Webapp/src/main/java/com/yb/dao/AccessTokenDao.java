package com.yb.dao;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.AccessToken;

public interface AccessTokenDao {
	void insertToken(@Param("token")AccessToken accessToken);
	String query();
}
