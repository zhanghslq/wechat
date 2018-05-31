package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Stake;

public interface StakeDao {
	//插入自定义赌注，赌注类型都为自定义
	void insertStake(@Param("stake")Stake stake);
	
	Stake queryById(@Param("id")Integer id);
	//查询赌注的情况，需要几个不会动的，到时候先插入，按照时间排序，查出来最早的几个
	List<Stake> queryAll();
}
