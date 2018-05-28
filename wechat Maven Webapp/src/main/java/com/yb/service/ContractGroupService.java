package com.yb.service;

import com.yb.entity.ContractCome;
import com.yb.entity.ContractGroupDetails;
import com.yb.entity.ContractGroupResult;

public interface ContractGroupService {
	//生成契约
	String createContractGroup(ContractCome contractCome,String code);
	//加入契约
	void joinContractGroup(String code,String cid,String myGuess,Integer number);
	//获取群pk详情
	ContractGroupDetails queryGroupDetails(String cid);
	//群pk开局
	void beginContractGroup(String cid);
	//获取群pk结果
	ContractGroupResult queryContractGroupResult(String cid,String code);
}
