package com.yb.service;

import java.util.List;

import com.yb.entity.*;

public interface ContractService {
	//生成契约
	Integer insertContract(ContractCome contractCome);
	//获取契约详情
	ContractDetails queryContract(Integer cid);
	//参与契约
	//重新预测,两个是一样的
	String joinContract(String code,Integer cid,String myGuess);
	//开局
	String beginStake(Integer cid);
	//获取完成状态的契约
	ContractDone queryContractDone(Integer cid,String openId);
	
	List<TheGuess> queryByMatchIdAndUid(String uid,Integer matchId);
	
	//更新契约结果，结算赌局
	void updateResultAndAutoCommit(Integer matchId,Integer homeGrade,Integer visitGrade);

	//查询是否能加入契约
	ResultPack isJoinContract(String openId,Integer cid);
}
