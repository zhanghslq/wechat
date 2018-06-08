package com.yb.service;

import com.yb.entity.ContractCome;
import com.yb.entity.ContractGroupDetails;
import com.yb.entity.ContractGroupResult;
import com.yb.entity.ResultPack;

public interface ContractGroupService {
	//生成契约
	Integer createContractGroup(ContractCome contractCome);
	//加入契约
	void joinContractGroup(String code,Integer cid,String myGuess);
	//获取群pk详情
	ContractGroupDetails queryGroupDetails(Integer cid);
	//群pk开局
	void beginContractGroup(Integer cid);
	//获取群pk结果
	ContractGroupResult queryContractGroupResult(Integer cid,String code);

	ResultPack isJoinContractGroup(String openId,Integer cid);

}
