package com.yb.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.yb.dao.MatchDao;
import com.yb.entity.Broadcast;
import com.yb.entity.Match;
import com.yb.service.BroadcastService;

@Service
public class BroadcastServiceImpl implements BroadcastService{

	@Autowired
	private MatchDao matchDao;
	
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
			for (Broadcast broadcast : parseArray) {//前提是即时事件接口的数据全部是正在发生的球赛的数据，及时事件的数据应该是当天所有比赛的数据
				Integer id = broadcast.getId();
				Match queryById = matchDao.queryById(id);
				if(queryById!=null){//这里证明进行的比赛属于世界杯
					//如果直播不能进行选择，只是直播正在进行的比赛，需要判断比赛是否正在进行
					if(queryById.getTime().before(new Date())&&queryById.getStatus()!=8){//这个是证明球赛已经开始，并且还未结束，但是现在可能有重复，待定
						
						
						
					}
					
				}
			}
		}
		return null;
	}
	//open.leisu.com/api/sports/football/match/detail_live

	
}
