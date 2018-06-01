package com.yb.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yb.entity.ContractCome;
import com.yb.entity.Proceed;
import com.yb.entity.User;


public interface UserDao {
	//存用户信息
	void insertUser(@Param("user")User user);
	//取用户信息
	User getUser(@Param("openid")String openid);
	//取用户信息只有在登录的时候用到，更新登陆时间
	void update(@Param("openid")String openid);
	//获取多个用户信息
	List<User> queryUsers(@Param("ids")List<String> ids,@Param("cid")Integer cid);
	//排行榜
	List<User> getRank();
	//获取自己的排行位置
	Integer getSelf(@Param("wins")Integer wins); 
	//当天第一次登陆送100金币,胜利获得赌注相同金币，就是修改金币数量，
	void updateCurrency(@Param("openid")String openid,@Param("num")Integer num);
	//批量更新金币，yn控制加减,顺便控制加减胜场，总 
	void addCurrency(@Param("openids")List<String> openid,@Param("num")Integer num,@Param("yn")String yn);
	void addCurrencyGroup(@Param("contractComes")ContractCome contractComes,@Param("yn")String yn);
	
	void updateAll(@Param("openids")List<String> openid);
	
	void updateWins(@Param("openids")List<String> openid);
	
	//查询用户进程
	Proceed queryLastContract(@Param("uid")String uid);
	Proceed queryLastContractGroup(@Param("uid")String uid);
}
