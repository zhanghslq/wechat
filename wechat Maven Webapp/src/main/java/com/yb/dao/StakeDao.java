package com.yb.dao;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Stake;

public interface StakeDao {
	//插入自定义赌注，赌注类型都为自定义
	void insertStake(@Param("id")String id,@Param("name")String name);
	
	Stake queryById(@Param("id")String id);
}
