package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Team;

public interface TeamDao {

	void insertTeam(@Param("teams")List<Team> teams);
	
	Team queryById(@Param("id")Integer id);
	//手动更改球队信息
	void update(@Param("team") Team team);

	List<Team> queryAll();
}
