package com.yb.service;

import com.yb.entity.ContractCome;
import com.yb.entity.ContractDetails;
import com.yb.entity.ContractDone;

public interface ContractService {
	//生成契约
	String insertContract(ContractCome contractCome);
	//获取契约详情
	ContractDetails queryContract(String cid);
	//参与契约
	//重新预测,两个是一样的
	String joinContract(String code,String cid,String myGuess);
	//开局
	String beginStake(String cid);
	//获取完成状态的契约
	ContractDone queryContractDone(String cid,String code);
}
