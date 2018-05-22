package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ContractGroupDao {
		//查询时间大于30分钟还未开局的契约
		List<String> queryList();
		//删除单个契约
		void delete(@Param("id")Integer id);
		//删除多个契约
		void deleteList(@Param("ids")List<Integer> ids);
}
