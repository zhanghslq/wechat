package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Events;

public interface EventDao {
	//插入数据
	void insertEvent(@Param("events") List<Events> events);
	void insertEventBean(@Param("event") Events events);
	Events queryById(@Param("id")Integer id);
}
