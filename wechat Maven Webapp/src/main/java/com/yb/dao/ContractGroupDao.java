package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.ContractCome;
import com.yb.entity.JoinData;
import com.yb.entity.TheGuess;
import com.yb.entity.User;

public interface ContractGroupDao {
		//查询时间大于30分钟还未开局的契约
		List<Integer> queryList();
		//删除单个契约
		void delete(@Param("id")Integer id);
		//删除多个契约
		void deleteList(@Param("ids")List<Integer> ids);
		//根据契约删除用户与契约中间表的数据
		void deleteFromCuByCid(@Param("cid")Integer cid);
		//根据契约id删除契约与创建者的中间表
		void deleteFromCrateByCid(@Param("cid")Integer cid);
		//开局
		void updateStatus(@Param("cid")Integer cid);
		
		//生成群pk契约
		Integer insertContractGroup(@Param("contractCome")ContractCome contractCome);
		//生成群契约的时候还需要同时生成一条，契约是谁生成的
		Integer insertConstractGroupCreate(@Param("cid")Integer cid,@Param("uid")String uid);
		//生成群契约的时候，同时生成一条此人缔结契约的信息
		Integer insertConstractGroupUser(@Param("cid")Integer cid,@Param("uid")String uid,@Param("myGuess")String myGuess,@Param("number")Integer number);
		//统计结果填入每个用户契约结果
		void setResult(@Param("cid")Integer cid,@Param("uid")String uid,@Param("result")Integer result);
		
		//查询契约详情，
		ContractCome queryContractGroup(@Param("cid")Integer cid);
		//查询契约用户的下注数量，以及竞猜内容
		List<JoinData> queryContractGroupUser(@Param("cid")Integer cid);
		//查询本场赛事总的参与下注金币
		Long queryCurrencys(@Param("matchId") Integer matchId);
		//查询最近进入房间的五个人的头像
		List<String> queryNearLogo(@Param("cid")Integer cid);
		//查询房间人数
		Integer queryNumberByCid(@Param("cid")Integer cid);
		
		//查看契约结果
		
		//查看胜利或失败的人
		List<User> queryUserByResult(@Param("result")Integer result);
		//查询当事人的竞猜结果
		Integer queryResultByUidAndCid(@Param("cid")Integer cid,@Param("uid")String uid);
		
		
		//需要查询参与这场比赛竞猜的人数，是否创建，是否参与
		Integer queryNumberByMatchId(Integer matchId);
		
		String queryCreateByUid(Integer matchId,String uid);
		
		String queryJoinByUid(Integer matchId,String uid);
		
		//查询本场比赛签订的契约
		List<TheGuess> queryByMatchIdAndUid(@Param("uid")String uid,@Param("matchId")Integer matchId);
}
