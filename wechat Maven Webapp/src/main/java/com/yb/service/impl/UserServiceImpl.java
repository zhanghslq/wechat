package com.yb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.dao.UserDao;
import com.yb.entity.User;
import com.yb.service.UserService;

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
	
}
