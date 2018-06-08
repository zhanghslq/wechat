package com.yb.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import com.yb.entity.*;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.dao.ContractGroupDao;
import com.yb.dao.EventDao;
import com.yb.dao.MatchDao;
import com.yb.dao.StageDao;
import com.yb.dao.TeamDao;
import com.yb.service.ContractGroupService;
import com.yb.util.OpenUtils;

@Service
public class ContractGroupServiceImpl implements ContractGroupService{

	@Autowired
	private ContractGroupDao contractGroupDao;
	@Autowired
	private MatchDao matchDao;
	@Autowired
	private StageDao stageDao;
	@Autowired
	private TeamDao teamDao;
	
	@Transactional
	@Override
	public Integer createContractGroup(ContractCome contractCome) {//生成契约
		// TODO Auto-generated method stub
		contractGroupDao.insertContractGroup(contractCome);
		Integer id = contractCome.getId();
		contractGroupDao.insertConstractGroupCreate(id, contractCome.getOpenId());
		contractGroupDao.insertConstractGroupUser(id, contractCome.getOpenId(), contractCome.getMyGuess(), contractCome.getNumber());
		return id;
	}
	@Override
	public void joinContractGroup(String openId, Integer cid, String myGuess) {//加入契约，重置猜测答案
		// TODO Auto-generated method stub
		Integer queryNumberById = contractGroupDao.queryNumberById(cid);//得到的是下注数量
		contractGroupDao.insertConstractGroupUser(cid, openId, myGuess, queryNumberById);
	}
	@Override
	public ContractGroupDetails queryGroupDetails(Integer cid) {//查詢群pk的未完成的契约详情
		// TODO Auto-generated method stub
		ContractCome contractCome = contractGroupDao.queryContractGroup(cid);
		Match match = matchDao.queryById(contractCome.getMatchId());
	
		//这里需要取阶段的数据
		Stage queryById = stageDao.queryById(match.getStageId());
		
		Team home = teamDao.queryById(match.getHomeid());
		Team visit = teamDao.queryById(match.getVisitid());
		List<JoinData> queryContractGroupUser = contractGroupDao.queryContractGroupUser(cid);
		Long queryCurrencys = contractGroupDao.queryCurrencys(contractCome.getMatchId());
		List<String> queryNearLogo = contractGroupDao.queryNearLogo(cid);
		Integer queryNumberByCid = contractGroupDao.queryNumberByCid(cid);
		User user = contractGroupDao.queryUserByCid(cid);
		ContractGroupDetails contractGroupDetails = new ContractGroupDetails(queryById.getName_zh(), home, visit, contractCome.getGuessType(),
				null, null, queryCurrencys, queryNearLogo, queryNumberByCid, queryContractGroupUser,user,contractCome.getStatus());
		return contractGroupDetails;
	}
	@Override
	public void beginContractGroup(Integer cid) {
		// TODO Auto-generated method stub
		//先查询人数
				Integer queryNumberByCid = contractGroupDao.queryNumberByCid(cid);//参与群pk的人数
				if(queryNumberByCid>1){//群pk超过1人，自动开局
					contractGroupDao.updateStatus(cid);
				}else {
					throw new RuntimeException("群pk人数至少两人");
				}
	}
	@Override
	public ContractGroupResult queryContractGroupResult(Integer cid,String openId) {
		// TODO Auto-generated method stub
		ContractCome queryContractGroup = contractGroupDao.queryContractGroup(cid);
		Integer matchId = queryContractGroup.getMatchId();
		String message="大获全胜，一起哈皮";
		String result="WIN";
		Integer resultByUidAndCid = contractGroupDao.queryResultByUidAndCid(cid, openId);
		if(0==resultByUidAndCid){
			message="再接再厉，下局通杀";
			result="LOSE";
		}
		Match match = matchDao.queryById(matchId);
		Integer homeid = match.getHomeid();
		Integer visitid = match.getVisitid();
		Team homeTeam = teamDao.queryById(homeid);
		Team visiTeam = teamDao.queryById(visitid);
		homeTeam.setGrade(match.getHome_grade());
		visiTeam.setGrade(match.getVisit_grade());
		Long queryCurrencys = contractGroupDao.queryCurrencys(matchId);
		List<User> loserList = contractGroupDao.queryUserByResult(0);
		List<User> successList = contractGroupDao.queryUserByResult(1);
		ContractGroupResult contractGroupResult = new ContractGroupResult(message, homeTeam, visiTeam, loserList, successList, queryCurrencys,result);
		return contractGroupResult;
	}
	@Override
	public ResultPack isJoinContractGroup(String openId, Integer cid){
		ContractCome contractCome = contractGroupDao.queryContractGroup(cid);
		if(contractCome!=null){
			Integer status = contractCome.getStatus();
			if(status!=0){
				return new ResultPack(0,"契约不可加入");
			}else {
				Integer integer = contractGroupDao.queryByOpenIdAndCid(openId, cid);
				if (integer!=null){//已经参加过契约了
					return new ResultPack(0,"已经加入过此契约了");
				}else {//未参加契约，现在可以加入
					return new ResultPack(1,"可以加入");
				}
			}

		}else {
			return  new ResultPack(0,"契约不存在");
		}

	}

}
