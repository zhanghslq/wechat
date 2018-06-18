package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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
		Integer insertContractGroup(ContractCome contractCome);
		//生成群契约的时候还需要同时生成一条，契约是谁生成的
		void insertConstractGroupCreate(@Param("cid")Integer cid,@Param("uid")String uid);
		//生成群契约的时候，同时生成一条此人缔结契约的信息,也可当做新参加契约
		void insertConstractGroupUser(@Param("cid")Integer cid,@Param("uid")String uid,@Param("myGuess")String myGuess,@Param("number")Integer number);
		//统计结果填入每个用户契约结果
		void setResult(@Param("cid")Integer cid,@Param("uid")String uid,@Param("result")Integer result);
		
		//查询契约详情，
		ContractCome queryContractGroup(@Param("cid")Integer cid);
		//查询契约用户的下注数量，以及竞猜内容
		List<JoinData> queryContractGroupUser(@Param("cid")Integer cid);
		//查询本场赛事总的参与下注金币
		Long queryCurrencys(@Param("matchId") Integer matchId);

		Long queryCurrencyByCid(@Param("cid") Integer cid);
		//查询最近进入房间的五个人的头像
		List<String> queryNearLogo(@Param("cid")Integer cid);
		//查询房间人数
		Integer queryNumberByCid(@Param("cid")Integer cid);
		//根据id查询单个契约下注数量
		Integer queryNumberById(@Param("cid")Integer cid);
		//根据cid查询此契约下注金币总数
		Long queryCurrencysByCid(@Param("cid") Integer cid);
		//查看契约结果
		
		
		
		//查看胜利或失败的人，结算之后用来显示契约比赛完成之后的
		List<User> queryUserByResult(@Param("result")Integer result);

		//这是为了查询结果页的输赢的人
		List<User> queryUserByResultAndCid(@Param("result")Integer result,@Param("cid")Integer cid);

		//查询当事人的竞猜结果
		Integer queryResultByUidAndCid(@Param("cid")Integer cid,@Param("uid")String uid);
		
		//需要查询参与这场比赛竞猜的人数，是否创建，是否参与
		Integer queryNumberByMatchId(@Param("matchId")Integer matchId);
		
		Integer queryCreateByUid(@Param("matchId")Integer matchId,@Param("uid")String uid);
		
		Integer queryJoinByUid(@Param("matchId")Integer matchId,@Param("uid")String uid);
		
		//查询本场比赛用户签订和参与的契约
		List<TheGuess> queryByMatchIdAndUid(@Param("uid")String uid,@Param("matchId")Integer matchId);
		
		
		
		//用于自动结算
		//查询参与比赛的所有契约，0猜输赢，1猜比分
		List<Integer> queryByMatchId(@Param("matchId")Integer matchId,@Param("type")Integer type);
		//更新竞猜结果，填入用户猜测的结果
		void updateResult(@Param("cids")List<Integer> cid,@Param("result")String result,@Param("yn")String yn);
		
		//查询出来openid以及number
		List<ContractCome> queryByResult(@Param("cids")List<Integer> cid,@Param("result")Integer result);
		
		//根据openid查询历史完成的赌局
		List<ContractCome> queryByOpenId(@Param("openId")String openId);
		//根据契约id查询用户信息
		User queryUserByCid(@Param("cid")Integer cid);
		//queryByOpenIdAndCid  用来判定用户是否参加契约
        Integer queryByOpenIdAndCid(@Param("openId")String openId,@Param("cid")Integer cid);
        //更改群契约状态
        void updateStatusAutoResult(@Param("cids")List<Integer> cids,@Param("status")Integer status);
        //查询是否已经创建本场比赛的群PK,已经创建过的不能重复创建
		Integer queryCreateByUidAndMatchId(@Param("uid")String uid,@Param("matchId")Integer matchId);

		//查询比赛已经开始之后，未开局的契约
		List<Integer> queryContractGroupByMatchId(@Param("matchId")Integer matchId);
		
}
