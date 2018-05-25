package com.yb.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.dao.UserDao;
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
	public User getUser(String openid) {
		// TODO Auto-generated method stub
		User user = userDao.getUser(openid);
		return user;
	}

	@Override
	public RankData getRank(String code) {
		// TODO Auto-generated method stub
		String openId = null;
		try {
			openId = OpenUtils.getOpenId(code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = userDao.getUser(openId);
		Integer self = userDao.getSelf(user.getWins());
		List<User> rank = userDao.getRank();
		RankData rankData = new RankData(self, rank);
		return rankData;
	}
	
}
