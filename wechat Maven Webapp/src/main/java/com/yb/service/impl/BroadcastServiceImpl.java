package com.yb.service.impl;

import java.util.List;

import org.apache.http.client.fluent.Request;

import com.alibaba.fastjson.JSONArray;
import com.yb.entity.Broadcast;
import com.yb.service.BroadcastService;

public class BroadcastServiceImpl implements BroadcastService{

	@Override
	public Object autoBroadcast() {
		// TODO Auto-generated method stub
		String asString = null;
		try {
			asString = Request.Get("http://open.leisu.com/api/sports/football/match/detail_live?user=cqdr&secret=JyN1wifrX2T0orlp")
					.setHeader("content-type", "application/x-www-form-urlencoded")
					.execute().returnContent().asString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("请求数据出错");
		}
		if(asString!=null){
			List<Broadcast> parseArray = JSONArray.parseArray(asString, Broadcast.class);
			
		}
		return null;
	}
	//open.leisu.com/api/sports/football/match/detail_live

	
}
