package com.yb.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.Proceed;
import com.yb.entity.User;


public interface UserDao {
	//存用户信息
	void insertUser(@Param("user")User user);
	//取用户信息
	User getUser(@Param("openid")String openid);
	//获取多个用户信息
	List<User> queryUsers(@Param("ids")List<String> ids,@Param("cid")String cid);
	//排行榜
	List<User> getRank();
	//获取自己的排行位置
	Integer getSelf(@Param("wins")Integer wins); 
	//当天第一次登陆送100金币,胜利获得赌注相同金币，就是修改金币数量，
	void updateCurrency(@Param("openid")String openid,@Param("num")Integer num);
	//获胜之后更改胜利场次+1
	void updateWins(@Param("openid")String openid);
	//用户竞猜输，用户参与总对局数+1
	void updateAll(@Param("openid")String openid);
	
	//查询用户进程
	Proceed queryLastContract(@Param("uid")String uid);
	Proceed queryLastContractGroup(@Param("uid")String uid);
}
