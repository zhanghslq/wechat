package com.yb.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.dao.UserDao;
import com.yb.entity.Proceed;
import com.yb.entity.RankData;
import com.yb.entity.User;
import com.yb.service.UserService;
import com.yb.util.OpenUtils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
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
		Integer self = userDao.getSelf(user.getWins());
		List<User> rank = userDao.getRank();
		RankData rankData = new RankData(self, rank);
		return rankData;
	}

	@Override
	public void updateCurrencys(String openId) {
		// TODO Auto-generated method stub
		userDao.updateCurrency(openId, 100);
	}
	//只有在登录的时候用到
	@Override
	public User getUser(String openid) {
		// TODO Auto-generated method stub
		User user = userDao.getUser(openid);
		userDao.update(openid);//修改登录时间
		return user;
	}
	
}
