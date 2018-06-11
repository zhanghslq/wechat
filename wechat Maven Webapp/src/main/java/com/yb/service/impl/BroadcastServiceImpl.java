package com.yb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yb.dao.TeamDao;
import com.yb.entity.*;
import com.yb.util.BroadcastUtils;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.yb.dao.MatchDao;
import com.yb.service.BroadcastService;

@Service
public class BroadcastServiceImpl implements BroadcastService{

	@Autowired
	private MatchDao matchDao;
	@Autowired
	private TeamDao teamDao;

	@Override
	public Object autoBroadcast() {
		// TODO Auto-generated method stub
		String asString;
		try {
			asString = Request.Get("http://open.leisu.com/api/sports/football/match/detail_live?user=cqdr&secret=JyN1wifrX2T0orlp")
					.setHeader("content-type", "application/x-www-form-urlencoded")
					.execute().returnContent().asString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("请求数据出错");
		}
		List<BroadcastData> broadcasts = new ArrayList<BroadcastData>();//准备存放直播数据
		if(asString!=null){
			List<Broadcast> parseArray = JSONArray.parseArray(asString, Broadcast.class);
			int flag=0;
			List<BroadcastData> list = new ArrayList<>();
			for (Broadcast broadcast : parseArray) {//前提是即时事件接口的数据全部是正在发生的球赛的数据，及时事件的数据应该是当天所有比赛的数据
				Integer id = broadcast.getId();
				Match queryById = matchDao.queryById(id);
				if(queryById!=null&&queryById.getStatus()!=8){//这里证明进行的比赛属于世界杯
					flag=1;

					//如果直播不能进行选择，只是直播正在进行的比赛，需要判断比赛是否正在进行
					if(queryById.getTime().before(new Date())&&queryById.getStatus()!=8){//这个是证明球赛已经开始，并且还未结束，但是现在可能有重复，待定
						Team home = teamDao.queryById(queryById.getHomeid());//主队信息
						Team visit = teamDao.queryById(queryById.getVisitid());

						List<BroadcastMessage> data=new ArrayList<BroadcastMessage>();//存放一场比赛的数据，准备返回的数据

						BroadcastData broadcastData = new BroadcastData();//
						List<Incident> incidents = broadcast.getIncidents();//从接口获取的比赛数据

						for (Incident incident : incidents) {
							StringBuilder text=new StringBuilder();//存放播报信息
							BroadcastMessage broadcastMessage = new BroadcastMessage();
							String name_zh=null;
							if(incident.getPosition()==1){//主队
								name_zh = home.getName_zh();//主队名

							}else if (incident.getPosition()==2){//客队
								name_zh = visit.getName_zh();//客队名
							}
							if(name_zh!=null){//不是中立
								if(incident.getType()==1){//进球
									Integer home_grade = queryById.getHome_grade();//上次的得分
									home_grade+=1;
									String message="精彩！"+"【进球队伍】"+"攻入了本场第"+home_grade+"个球！";
									broadcastMessage.setMinutes(incident.getTime());
									broadcastMessage.setText(message);
								}else if (incident.getType()==9){//换人
									String message=name_zh+"换人："+incident.getIn_player_name()+"替换"+incident.getOut_player_name();
									broadcastMessage.setMinutes(incident.getTime());
									broadcastMessage.setText(message);
								}else{//不属于进球和换人
									String message = BroadcastUtils.getMessage(incident.getType(), name_zh);
									if(message!=null){//证明部位空
										broadcastMessage.setText(message);//播报内容
										broadcastMessage.setMinutes(incident.getTime());//比赛分钟数
									}
								}
								data.add(broadcastMessage);//一个事件加入比赛
							}
						}
						broadcastData.setData(data);
						broadcastData.setHome(home);
						broadcastData.setVisit(visit);
						list.add(broadcastData);
					}
					//世界杯的操作
				}

			}
			if(flag==0){//没有直播数据
				BroadcastData broadcastData = new BroadcastData();
				BroadcastMessage broadcastMessage = new BroadcastMessage();
				broadcastMessage.setText("当前时间暂无比赛，敬请期待");
				ArrayList<BroadcastMessage> broadcastMessages = new ArrayList<>();
				broadcastMessages.add(broadcastMessage);
				broadcastData.setData(broadcastMessages);
				broadcasts.add(broadcastData);
				ArrayList<BroadcastData> broadcastData1 = new ArrayList<>();
				return  broadcastData1;
			}
			return list;

		}else {
			BroadcastData broadcastData = new BroadcastData();
			BroadcastMessage broadcastMessage = new BroadcastMessage();
			broadcastMessage.setText("当前时间暂无比赛，敬请期待");
			ArrayList<BroadcastMessage> broadcastMessages = new ArrayList<>();
			broadcastMessages.add(broadcastMessage);
			broadcastData.setData(broadcastMessages);
			broadcasts.add(broadcastData);
			ArrayList<BroadcastData> broadcastData1 = new ArrayList<>();
			return  broadcastData1;
		}


	}
	//open.leisu.com/api/sports/football/match/detail_live

	
}
