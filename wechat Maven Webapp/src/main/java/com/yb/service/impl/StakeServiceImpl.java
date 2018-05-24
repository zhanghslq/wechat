package com.yb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.dao.StakeDao;
import com.yb.entity.Stake;
import com.yb.service.StakeService;

@Service
public class StakeServiceImpl implements StakeService{

	@Autowired
	private StakeDao stakeDao;
	@Override
	public List<Stake> queryAll() {
		// TODO Auto-generated method stub
		List<Stake> queryAll = stakeDao.queryAll();
		return queryAll;
	}

}
