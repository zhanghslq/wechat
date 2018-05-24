package com.yb.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.dao.ContractDao;
import com.yb.dao.ContractGroupDao;
import com.yb.dao.MatchDao;
import com.yb.dao.StakeDao;
import com.yb.dao.TeamDao;
import com.yb.dao.UserDao;
import com.yb.entity.ContractCome;
import com.yb.entity.ContractDetails;
import com.yb.entity.ContractDone;
import com.yb.entity.Match;
import com.yb.entity.Stake;
import com.yb.entity.Team;
import com.yb.entity.User;
import com.yb.service.ContractService;
import com.yb.util.OpenUtils;

@Service
public class ContractServiceImpl implements ContractService{
	@Autowired
	private ContractDao contractDao;
	@Autowired
	private ContractGroupDao contractGroupDao;
	@Autowired
	private StakeDao stakeDao;
	@Autowired
	private MatchDao matchDao;
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private UserDao userDao;
	@Override
	@Transactional
	public String insertContract(ContractCome contractCome) {
		// TODO Auto-generated method stub
		String cid = UUID.randomUUID().toString();
		contractCome.setId(cid);
		String openId="";
		try {
			openId = OpenUtils.getOpenId(contractCome.getCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("获取openid出现异常");
		}
		if(contractCome.getStakeType()==3){//自定义赌注,需要先添加赌注
			String sid = UUID.randomUUID().toString();//赌注id，利用UUID生成，主键变成字符串类型的
			stakeDao.insertStake(sid,contractCome.getStakeText());
			contractCome.setStakeId(sid);//自定义的id放进去
		}
		contractDao.insertContract(contractCome);
		contractDao.insertConstractUser(cid, openId, contractCome.getMyGuess());
		contractDao.insertConstractCreate(cid, openId);
		return cid;//返回契约id
	}
	@Override
	public ContractDetails queryContract(String cid) {//获取契约详情，
		// TODO Auto-generated method stub
		ContractCome contract = contractDao.getContract(cid);//获取契约基本信息
		String stakeId = contract.getStakeId();
		Stake stake = stakeDao.queryById(stakeId);
		Integer matchId = contract.getMatchId();//契约所针对的比赛id
		Match queryById = matchDao.queryById(matchId);
		Team homeTeam = teamDao.queryById(queryById.getHomeid());
		Team visitTeam = teamDao.queryById(queryById.getVisitid());
		
		String openId = contractDao.getOpenId(cid);//创建人openid,創建人一定是有的
		User user = userDao.getUser(openId);//創建人信息
		String myGuess = contractDao.queryGuessByUid(openId, cid);
		List<String> openLists = contractDao.getOpenLists(cid);//缔结契约人列表，這個
		List<User> queryUsers = userDao.queryUsers(openLists);//包括創建人在内的契約人列表
		ContractDetails contractDetails = new ContractDetails(homeTeam, visitTeam, "文案", contract.getGuessType(),
				myGuess, stake.getLogo(), stake.getName(), queryById.getStatus(),
				"30minutes待定", user.getNickname(), user.getImageUrl(), queryUsers);
		return contractDetails;
	}
	@Override
	public String joinContract(String code, String cid,String myGuess) {//加入契约
		// TODO Auto-generated method stub
		ContractCome contract = contractDao.getContract(cid);
		if(1==contract.getStatus()){//等于1的时候，证明契约生效，不能更改
			return "error";
		}else {
			String openId;
			try {
				openId = OpenUtils.getOpenId(code);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("获取openid出错");
			}
			contractDao.insertConstractUser(cid, openId, myGuess);
			return "success";
		}
		
	}
	
	@Override
	public String beginStake(String cid) {
		// TODO Auto-generated method stub
		//契约开局，但是需要参与人数大于1
		List<String> openLists = contractDao.getOpenLists(cid);
		if(openLists.size()>1){//当人数大于1,开局
			contractDao.updateStatus(cid);
			return "success";
		}else {
			return "error";
		}
	}
	@Override
	public ContractDone queryContractDone(String cid, String code) {
		// TODO Auto-generated method stub
		String openId="";
		try {
			openId = OpenUtils.getOpenId(code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("获取openid出错");
		}
		ContractCome contract = contractDao.getContract(cid);//获取契约详情
		Integer queryResult = contractDao.queryResult(openId, cid);
		String result;
		String message;
		if(0==queryResult){//0代表输，1代表赢
			result="WIN";
			message="";
		}else {
			result="LOSE";
			message="";
		}
		List<User> loser = contractDao.queryUserList(cid, 0);//获取 胜利或者输的人列表
		List<User> success = contractDao.queryUserList(cid, 1);//获取 胜利或者输的人列表
		Integer matchId = contract.getMatchId();
		Match match = matchDao.queryById(matchId);
		Integer home_grade = match.getHome_grade();
		Integer visit_grade = match.getVisit_grade();
		Integer homeid = match.getHomeid();
		Integer visitid = match.getVisitid();
		Team home = teamDao.queryById(homeid);
		home.setGrade(home_grade);
		Team visit = teamDao.queryById(visitid);
		visit.setGrade(visit_grade);
		ContractDone contractDone = new ContractDone(result, message, loser, success, home, visit);
		return contractDone;
	}

}
