package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Stage;

public interface StageDao {
	void insert(@Param("stages")List<Stage> stages);
	
	Stage queryById(@Param("id")Integer id);
}
