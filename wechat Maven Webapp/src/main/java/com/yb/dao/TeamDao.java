package com.yb.dao;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Team;

public interface TeamDao {
	void insertTeam(@Param("team")Team team);
}
