package com.yb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.entity.RankData;
import com.yb.entity.ResultPack;
import com.yb.entity.User;
import com.yb.service.UserService;
import com.yb.util.OpenUtils;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	//微信授权登录
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public ResultPack login(@RequestBody User user1){
		 try {
			System.out.println("进入方法");
			System.out.println("code==========="+user1.getCode());
	 		String openId = OpenUtils.getOpenId(user1.getCode());
	 		System.out.println("获取到的openId"+openId);
	        User user = userService.getUser(openId);
	        if(user==null){
	        	User user2 = new User(null,null,openId,user1.getImageUrl(),user1.getNickname(),8000,0,new Date(),null,null);
	        	userService.insertUser(user2);
	        	return  new ResultPack(1, user2);
	        }else {
	        	User user2 = new User();
	        	user2.setOpenid(openId);
	        	user2.setImageUrl(user1.getImageUrl());
	        	user2.setNickname(user1.getNickname());
	        	userService.updateNameAndLogo(user2);
	        	Date lasttime = user.getLasttime();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
				String format = simpleDateFormat.format(lasttime);
				if(!simpleDateFormat.format(new Date()).equals(format)){//当天第一次登陆,送100金币
					userService.updateCurrencys(openId);
				}
				return new ResultPack(1, user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
	@RequestMapping("/getMessage")
	@ResponseBody
	public Object getMessage(String openId){
		try {
			User user = userService.getUserStatus(openId);
			return new ResultPack(1, user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
	@RequestMapping("/getRank")
	@ResponseBody
	public ResultPack getRank(String openId){
		try {
			RankData rank = userService.getRank(openId);
			return new ResultPack(1, rank);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
}
