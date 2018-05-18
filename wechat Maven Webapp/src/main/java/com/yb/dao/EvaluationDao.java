package com.yb.dao;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Evaluation;

public interface EvaluationDao {
	Evaluation queryEvaluation(@Param("openid")String openid);
}
