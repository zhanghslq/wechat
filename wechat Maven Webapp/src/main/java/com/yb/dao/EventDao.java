package com.yb.dao;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Events;

public interface EventDao {
	//插入数据
	void insertEvent(@Param("events") Events events);
}
