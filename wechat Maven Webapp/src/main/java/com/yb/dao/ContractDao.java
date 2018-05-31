package com.yb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.ContractCome;
import com.yb.entity.TheGuess;
import com.yb.entity.User;

public interface ContractDao {
	//生成契约
	void insertContract(@Param("contractCome")ContractCome contractCome);
	//生成契约的时候还需要同时生成一条，契约是谁生成的
	void insertConstractCreate(@Param("cid")Integer cid,@Param("uid")String uid);
	//生成契约的时候，同时生成一条此人缔结契约的信息
	void insertConstractUser(@Param("cid")Integer cid,@Param("uid")String uid,@Param("myGuess")String myGuess);
	
	//获取契约详情,需要获取契约基本信息，获取比赛，然后获取两只球队，获取契约创建人，获取契约人列表
	//契约基本信息
	ContractCome getContract(@Param("cid")Integer cid);
	//获取創建契约人id
	String getOpenId(@Param("cid")Integer cid);
	//获取契约人列表id，包括创建人,需要在业务层，通过id去查询信息
	List<String> getOpenLists(@Param("cid")Integer cid);
	//根据用户id和契约id获取用户的竞猜内容
	String queryGuessByUid(@Param("uid")String uid,@Param("cid")Integer cid);
	
	//开始赌局，契约生效
	void updateStatus(@Param("cid")Integer cid);
	
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
	
	//需要根据用户id查询是否创建了竞猜
	String queryCreateByUid(@Param("uid")String uid,@Param("matchId")Integer matchId);
	//根据用户id查询用户是否参与了竞猜,查询到的是契约id
	Integer queryJoinByUid(@Param("uid")String uid,@Param("matchId")Integer matchId);
	//根据比赛id查看参与本场比赛，好友赛，的人数
	Integer queryNumber(@Param("matchId")Integer matchId);
	//查询本契约的参与人数
	Integer queryNumberByCid(@Param("cid")Integer cid);
	
	//契约完成之后，获取结果
	Integer queryResult(@Param("uid")String uid,@Param("cid")Integer cid);
	//赢家列表，输家列表
	List<User> queryUserList(@Param("cid")Integer cid,@Param("result")Integer result);
	
	//查询本场比赛签订的契约
	List<TheGuess> queryByMatchIdAndUid(@Param("uid")String uid,@Param("matchId")Integer matchId);
	
	//根据比赛id查询契约,还可以根据类型
	List<String> queryByMatchId(@Param("matchId")Integer matchId,@Param("type")Integer type);
	//更改契约用户中的result值,涉及到竞猜
	void updateResult(@Param("cid")Integer cid,@Param("result")String result,@Param("yn")String yn);
		
	//根据契约id来查契约和结果与用户的关联
	void queryByCidAndResult(@Param("cid")Integer cid,@Param("result")String result,@Param("yn")String yn);
	
	//利用上面查出来的来对用户做更改
	
	
	
}
