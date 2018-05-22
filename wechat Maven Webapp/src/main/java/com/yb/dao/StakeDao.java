package com.yb.dao;

import org.apache.ibatis.annotations.Param;

public interface StakeDao {
	//插入自定义赌注
	void insertStake(@Param("name")String name);
}
