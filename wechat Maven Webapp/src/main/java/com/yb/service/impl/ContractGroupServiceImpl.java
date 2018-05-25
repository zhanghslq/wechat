package com.yb.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.dao.ContractGroupDao;
import com.yb.dao.EventDao;
import com.yb.dao.MatchDao;
import com.yb.dao.TeamDao;
import com.yb.entity.ContractCome;
import com.yb.entity.ContractGroupDetails;
import com.yb.entity.Events;
import com.yb.entity.JoinData;
import com.yb.entity.Match;
import com.yb.entity.Team;
import com.yb.service.ContractGroupService;
import com.yb.util.OpenUtils;

@Service
public class ContractGroupServiceImpl implements ContractGroupService{

	@Autowired
	private ContractGroupDao contractGroupDao;
	@Autowired
	private MatchDao matchDao;
	@Autowired
	private EventDao eventDao;
	@Autowired
	private TeamDao teamDao;
	
	@Transactional
	@Override
	public String createContractGroup(ContractCome contractCome,String code) {//生成契约
		// TODO Auto-generated method stub
		String cid = UUID.randomUUID().toString();//先生成契约id
		contractCome.setId(cid);
		contractGroupDao.insertContractGroup(contractCome);
		String openId = null;
		try {
			openId = OpenUtils.getOpenId(code);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("获取openid出错");
		}
		contractGroupDao.insertConstractGroupCreate(cid, openId);
		contractGroupDao.insertConstractGroupUser(cid, openId, contractCome.getMyGuess(), contractCome.getNumber());
		return cid;
	}
	@Override
	public void joinContractGroup(String code, String cid, String myGuess,
			Integer number) {//加入契约，重置猜测答案
		// TODO Auto-generated method stub
		String openId = null;
		try {
			openId = OpenUtils.getOpenId(code);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("获取openid出错");
		}
		contractGroupDao.insertConstractGroupUser(cid, openId, myGuess, number);
	}
	@Override
	public ContractGroupDetails queryGroupDetails(String cid) {//查詢群pk的未完成的契约详情
		// TODO Auto-generated method stub
		ContractCome contractCome = contractGroupDao.queryContractGroup(cid);
		Match match = matchDao.queryById(contractCome.getMatchId());
		Events queryById = eventDao.queryById(match.getEventid());
		Team home = teamDao.queryById(match.getHomeid());
		Team visit = teamDao.queryById(match.getVisitid());
		
		
		List<JoinData> queryContractGroupUser = contractGroupDao.queryContractGroupUser(cid);
		Long queryCurrencys = contractGroupDao.queryCurrencys(contractCome.getMatchId());
		List<String> queryNearLogo = contractGroupDao.queryNearLogo(cid);
		Integer queryNumberByCid = contractGroupDao.queryNumberByCid(cid);
		
		ContractGroupDetails contractGroupDetails = new ContractGroupDetails(queryById.getName_zh(), home, visit, contractCome.getGuessType(),
				null, null, queryCurrencys, queryNearLogo, queryNumberByCid, queryContractGroupUser);
		return contractGroupDetails;
	}

}
