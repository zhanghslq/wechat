package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Evaluation;

public interface EvaluationDao {
	Evaluation queryEvaluation(@Param("openid")String openid);
	//在注册的时候，插入一个
	void insert(@Param("openId")String openId);
	//批量更新
	void update(@Param("type")Integer type,@Param("openids")List<String> openids);

	//查询用户最大的那个指
	Integer queryMax(@Param("openId")String openId);
}
