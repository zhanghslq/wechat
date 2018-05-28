package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.ContractCome;
import com.yb.entity.JoinData;
import com.yb.entity.User;

public interface ContractGroupDao {
		//查询时间大于30分钟还未开局的契约
		List<String> queryList();
		//删除单个契约
		void delete(@Param("id")Integer id);
		//删除多个契约
		void deleteList(@Param("ids")List<Integer> ids);
		//开局
		void updateStatus(@Param("cid")String cid);
		
		//生成群pk契约
		void insertContractGroup(@Param("contractCome")ContractCome contractCome);
		//生成群契约的时候还需要同时生成一条，契约是谁生成的
		void insertConstractGroupCreate(@Param("cid")String cid,@Param("uid")String uid);
		//生成群契约的时候，同时生成一条此人缔结契约的信息
		void insertConstractGroupUser(@Param("cid")String cid,@Param("uid")String uid,@Param("myGuess")String myGuess,@Param("number")Integer number);
		//统计结果填入每个用户契约结果
		void setResult(@Param("cid")String cid,@Param("uid")String uid,@Param("result")Integer result);
		
		//查询契约详情，
		ContractCome queryContractGroup(@Param("cid")String cid);
		//查询契约用户的下注数量，以及竞猜内容
		List<JoinData> queryContractGroupUser(@Param("cid")String cid);
		//查询本场赛事总的参与下注金币
		Long queryCurrencys(@Param("matchId") Integer matchId);
		//查询最近进入房间的五个人的头像
		List<String> queryNearLogo(@Param("cid")String cid);
		//查询房间人数
		Integer queryNumberByCid(@Param("cid")String cid);
		
		//查看契约结果
		
		//查看胜利或失败的人
		List<User> queryUserByResult(@Param("result")Integer result);
		//查询当事人的竞猜结果
		Integer queryResultByUidAndCid(@Param("cid")String cid,@Param("uid")String uid);
		
		
		//需要查询参与这场比赛竞猜的人数，是否创建，是否参与
		Integer queryNumberByMatchId(Integer matchId);
		
		String queryCreateByUid(Integer matchId,String uid);
		
		String queryJoinByUid(Integer matchId,String uid);
}
