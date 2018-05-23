package com.yb.service;

import com.yb.entity.ContractCome;
import com.yb.entity.ContractDetails;

public interface ContractService {
	//生成契约
	String insertContract(ContractCome contractCome);
	//获取契约详情
	ContractDetails queryContract(String cid);
	//参与契约
	String joinContract(String code,String cid,String myGuess);
	//重新预测
	String resetMyGuess(String myGuess,String code,String cid);
	//开局
	String beginStake(String cid);
}
