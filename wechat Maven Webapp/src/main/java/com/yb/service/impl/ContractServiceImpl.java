package com.yb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.dao.ContractDao;
import com.yb.dao.ContractGroupDao;
import com.yb.entity.ContractCome;
import com.yb.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService{

	@Autowired
	private ContractDao contractDao;
	@Autowired
	private ContractGroupDao contractGroupDao;
	@Override
	public void insertContract(ContractCome contractCome) {
		// TODO Auto-generated method stub
		if(contractCome.getStakeType()==3){//自定义赌注,需要先添加赌注
			
		}
	}

}
