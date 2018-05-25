package com.yb.service;

import com.yb.entity.ContractCome;
import com.yb.entity.ContractGroupDetails;

public interface ContractGroupService {
	//生成契约
	String createContractGroup(ContractCome contractCome,String code);
	//加入契约
	void joinContractGroup(String code,String cid,String myGuess,Integer number);
	//获取未完成的契约详情
	ContractGroupDetails queryGroupDetails(String cid);
}
