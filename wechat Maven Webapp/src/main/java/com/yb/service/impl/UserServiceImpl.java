package com.yb.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yb.dao.*;
import com.yb.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ContractDao contractDao;
	@Autowired
	private ContractGroupDao contractGroupDao;
	@Autowired
	private MatchDao matchDao;
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private EvaluationDao evaluationDao;

	private SimpleDateFormat sfDateFormat=new SimpleDateFormat("MM月dd日");
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
		evaluationDao.insert(user.getOpenid());
	}

	@Override
	public User getUserStatus(String openid) {
		// TODO Auto-generated method stub
		String message="无竞猜";
		User user = userDao.getUser(openid);
		Proceed queryLastContract = userDao.queryLastContract(openid);
		Proceed queryLastContractGroup = userDao.queryLastContractGroup(openid);
		if(queryLastContract!=null&&queryLastContractGroup!=null){
			Date time = queryLastContract.getTime();
			Date time2 = queryLastContractGroup.getTime();
			if(time.after(time2)){
				Integer result = queryLastContract.getResult();
				if(2!=result){
					message="已完成";
				}else {
					message="未完成";
				}
			}else {
				Integer result = queryLastContractGroup.getResult();
				if(2!=result){
					message="已完成";
				}else {
					message="未完成";
				}
			}
		}else if (queryLastContract!=null&&queryLastContractGroup==null) {
			Integer result = queryLastContract.getResult();
			if(2!=result){
				message="已完成";
			}else {
				message="未完成";
			}
		}else if (queryLastContract==null&&queryLastContractGroup!=null) {
			Integer result = queryLastContractGroup.getResult();
			if(2!=result){
				message="已完成";
			}else {
				message="未完成";
			}
		}
		user.setMessage(message);
		return user;
	}

	@Override
	public RankData getRank(String openId) {
		// TODO Auto-generated method stub
		User user = userDao.getUser(openId);
		Integer self = userDao.getSelf(user.getOpenid());
		List<User> rank = userDao.getRank();
		RankData rankData = new RankData(self, rank);
		return rankData;
	}

	@Override
	public void updateCurrencys(String openId) {
		// TODO Auto-generated method stub
		userDao.updateCurrency(openId, 1000);
	}
	//只有在登录的时候用到
	@Override
	public User getUser(String openid) {
		// TODO Auto-generated method stub
		User user = userDao.getUser(openid);
		userDao.update(openid);//修改登录时间
		return user;
	}

	@Override
	public void updateNameAndLogo(User user) {
		// TODO Auto-generated method stub
		userDao.updateNameAndLogo(user);
	}

	@Override
	public UserAndHistory queryUserAndHistory(String openId) {
		
		// TODO Auto-generated method stub
		User user = userDao.getUser(openId);
		Integer all = user.getAllNumber();
		Integer wins = user.getWins();
		String rate="0";
		if(all!=null&&all!=0){
			Double rateDouble=wins*1.0/all*100;
			rate=rateDouble+"%";
		}else {
			rate="0%";
		}
		List<History> list = new ArrayList<History>();//存放历史战绩的
		List<ContractCome> queryByOpenId = contractDao.queryByOpenId(openId);//得到的已经结束的
		if(queryByOpenId!=null&&queryByOpenId.size()!=0){
			for (ContractCome contractCome : queryByOpenId) {
				Integer id = contractCome.getId();//参加的契约id
				Integer matchId = contractCome.getMatchId();//契约对应的比赛id
				Match match = matchDao.queryById(matchId);
				Integer homeid = match.getHomeid();//主队id
				Integer visitid = match.getVisitid();//二队id
				Team queryById = teamDao.queryById(visitid);//客队
				Team queryById2 = teamDao.queryById(homeid);//主队
				Date time = match.getTime();//
				Integer number = contractCome.getNumber1();
				String resultString="赢";
				if(0==number){
					resultString="输";
				}
				String timeDesc = sfDateFormat.format(time);
				Integer joinNumber = contractDao.queryNumberByCid(id);//参与契约人数
				History history = new History(timeDesc, time, id, queryById2.getName_zh(),
						queryById.getName_zh(), "好友赛", joinNumber, resultString);
				list.add(history);
			}
		}//好友赛完成
		
		List<ContractCome> queryByOpenId2 = contractGroupDao.queryByOpenId(openId);
		if(queryByOpenId2!=null&&queryByOpenId2.size()!=0){
			for (ContractCome contractCome : queryByOpenId2) {
				Integer id = contractCome.getId();//参加的契约id
				Integer matchId = contractCome.getMatchId();//契约对应的比赛id
				Match match = matchDao.queryById(matchId);
				Integer homeid = match.getHomeid();//主队id
				Integer visitid = match.getVisitid();//二队id
				Team queryById = teamDao.queryById(visitid);//客队
				Team queryById2 = teamDao.queryById(homeid);//主队
				Date time = match.getTime();//
				Integer number = contractCome.getNumber();
				String resultString="赢";
				if(0==number){
					resultString="输";
				}
				String timeDesc = sfDateFormat.format(time);
				Integer joinNumber = contractDao.queryNumberByCid(id);//参与契约人数
				History history = new History(timeDesc, time, id, queryById2.getName_zh(),
						queryById.getName_zh(), "群PK", joinNumber, resultString);
				list.add(history);
			}
		}
		//查询称号的
		String evaluationName="猜球达人";
		Integer integer = evaluationDao.queryMax(openId);
		Evaluation evaluation = evaluationDao.queryEvaluation(openId);
		if(integer!=0){
			if (evaluation.getTricky_brains()==integer){
				evaluationName="整蛊专家";
			}else if (evaluation.getIron_cock()==integer){
				evaluationName="钢铁公鸡";
			}else if (evaluation.getImagination_talent()==integer){
				evaluationName="脑洞达人";
			}else if (evaluation.getFood_anchor()==integer){
				evaluationName="美食主播";
			}else if (evaluation.getWealthy()==integer){
				evaluationName="富甲一方";
			}
		}
		UserAndHistory userAndHistory = new UserAndHistory(user, rate, list,evaluationName);
		return userAndHistory;
	}
	
}
