package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Team;

public interface TeamDao {
	void insertTeam(@Param("teams")List<Team> teams);
}
