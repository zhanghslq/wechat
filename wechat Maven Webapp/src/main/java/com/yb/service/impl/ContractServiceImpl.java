package com.yb.service.impl;

import com.yb.dao.*;
import com.yb.entity.*;
import com.yb.service.ContractService;
import com.yb.util.RandomMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	public Integer insertContract(ContractCome contractCome) {
		// TODO Auto-generated method stub
		if(contractCome.getStakeType()==3){//自定义赌注,需要先添加赌注
			Stake stake = new Stake(null,3,contractCome.getStakeText(),"",null);
			stakeDao.insertStake(stake);
			contractCome.setStakeId(stake.getId());//自定义的id放进去
		}
		contractDao.insertContract(contractCome);
		Integer id = contractCome.getId();
		contractDao.insertConstractUser(id, contractCome.getOpenId(), contractCome.getMyGuess());
		contractDao.insertConstractCreate(id, contractCome.getOpenId());
		return id;//返回契约id
	}
	@Override
	public ContractDetails queryContract(Integer cid) {//获取契约详情，
		// TODO Auto-generated method stub
		ContractCome contract = contractDao.getContract(cid);//获取契约基本信息
		Integer stakeId = contract.getStakeId();
		Stake stake = stakeDao.queryById(stakeId);
		Integer matchId = contract.getMatchId();//契约所针对的比赛id
		Match queryById = matchDao.queryById(matchId);
		Team homeTeam = teamDao.queryById(queryById.getHomeid());
		Team visitTeam = teamDao.queryById(queryById.getVisitid());
		String openId = contractDao.getOpenId(cid);//创建人openid,創建人一定是有的
		User user = userDao.getUser(openId);//創建人信息
		String myGuess = contractDao.queryGuessByUid(openId, cid);
		List<String> openLists = contractDao.getOpenLists(cid);//缔结契约人列表，這個

		List<User> queryUsers = userDao.queryUsers(openLists,cid);//包括創建人在内的契約人列表
		ContractDetails contractDetails = new ContractDetails(homeTeam, visitTeam, RandomMessageUtil.getMessage(), contract.getGuessType(),
				myGuess, stake.getLogo(), stake.getName(), queryById.getStatus(),
				"", user.getNickname(), user.getImageUrl(), queryUsers,contract.getStatus(),openId);
		return contractDetails;
	}
	@Override
	public String joinContract(String openId, Integer cid,String myGuess) {//加入契约
		// TODO Auto-generated method stub
		ContractCome contract = contractDao.getContract(cid);
		if(1==contract.getStatus()){//等于1的时候，证明契约生效，不能更改
			return "error";
		}else {
			contractDao.insertConstractUser(cid, openId, myGuess);
			return "success";
		}
	}

	@Override
	public String beginStake(Integer cid) {
		// TODO Auto-generated method stub
		//契约开局，但是需要参与人数大于1
		List<String> openLists = contractDao.getOpenLists(cid);
		if(openLists.size()>1){//当人数大于1,开局
			contractDao.updateStatus(cid,1);
			return "success";
		}else {
			return "error";
		}
	}
	@Override
	public ContractDone queryContractDone(Integer cid, String openId) {
		// TODO Auto-generated method stub
		ContractCome contract = contractDao.getContract(cid);//获取契约详情
		Integer queryResult = contractDao.queryResult(openId, cid);
		String result;
		String message;
		if(1==queryResult){//0代表输，1代表赢
			result="WIN";
			message="大获全胜，一起哈皮";
		}else {
			result="LOSE";
			message="再接再厉，下次能赢";
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
		Integer stakeId = contract.getStakeId();
		Stake stake = stakeDao.queryById(stakeId);
		ContractDone contractDone = new ContractDone(result, message, loser, success, home, visit,stake.getLogo(),stake.getName(),loser.size()+success.size());
		return contractDone;
	}
	/**
	 * 这是参与本场竞彩的，包括群pk和好友赛，都放在一起了
	 */
	@Override
	public List<TheGuess> queryByMatchIdAndUid(String uid, Integer matchId) {
		// TODO Auto-generated method stub
		List<TheGuess> queryByMatchIdAndUid = contractDao.queryByMatchIdAndUid(uid, matchId);
		if(queryByMatchIdAndUid!=null&&queryByMatchIdAndUid.size()!=0){
			for (TheGuess theGuess : queryByMatchIdAndUid) {
				Integer queryNumberByCid = contractDao.queryNumberByCid(theGuess.getCid());
				theGuess.setNumber(queryNumberByCid);
			}
		}
		List<TheGuess> queryByMatchIdAndUid2 = contractGroupDao.queryByMatchIdAndUid(uid, matchId);
		if(queryByMatchIdAndUid2!=null&&queryByMatchIdAndUid2.size()!=0){
			for (TheGuess theGuess : queryByMatchIdAndUid2) {
				Integer queryNumberByCid = contractGroupDao.queryNumberByCid(theGuess.getCid());
				theGuess.setNumber(queryNumberByCid);
			}
		}
		queryByMatchIdAndUid.addAll(queryByMatchIdAndUid2);
		return queryByMatchIdAndUid;
	}
	@Override
	public void updateResultAndAutoCommit(Integer matchId, Integer homeGrade,
			Integer visitGrade) {//更新比赛结果，结算赌局
		// TODO Auto-generated method stub

	}
	public ResultPack isJoinContract(String openId,Integer cid){

		ContractCome contract = contractDao.getContract(cid);//契约详情
		if(contract!=null){

			Integer status = contract.getStatus();
			if (0!=status){//证明契约已经开局，或者结束，不是可加入的状态
				return new ResultPack(3,"契约不可加入");
			}else {
				Integer integer = contractDao.queryByOpenIdAndCid(cid, openId);
				if(integer!=null){//证明已经加入过契约
					return new ResultPack(2,"已经加入此契约了");
				}else {
					return new ResultPack(1,"契约正常，可以加入");
				}
			}
		}else {
			return new ResultPack(0,"契约不存在");
		}
	}

}
