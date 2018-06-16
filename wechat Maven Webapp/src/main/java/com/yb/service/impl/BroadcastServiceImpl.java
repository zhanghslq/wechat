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
					if(queryById.getStatus()!=8){//这个是证明球赛已经开始，并且还未结束，但是现在可能有重复，待定
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
									String message="精彩！"+name_zh+"攻入了本场第"+home_grade+"个球！";
									broadcastMessage.setMinutes(incident.getTime());
									broadcastMessage.setText(message);
									broadcastMessage.setLogo("images/broadcast/进球.png");
								}else if (incident.getType()==9){//换人
									String message=name_zh+"换人："+incident.getIn_player_name()+"替换"+incident.getOut_player_name();
									broadcastMessage.setMinutes(incident.getTime());
									broadcastMessage.setText(message);
									broadcastMessage.setLogo("images/broadcast/换人.png");
								}else{//不属于进球和换人
									String message = BroadcastUtils.getMessage(incident.getType(), name_zh);
									String logo = BroadcastUtils.getLogo(incident.getType());
									if(message!=null){//证明部位空
										broadcastMessage.setLogo(logo);
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
				broadcastData1.add(broadcastData);
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
			broadcastData1.add(broadcastData);
			return  broadcastData1;
		}


	}
	//open.leisu.com/api/sports/football/match/detail_live

	@Override
	public Object testBroadcast() {
		// TODO Auto-generated method stub
		String asString="[{\"id\":2448189,\"stats\":[{\"type\":3,\"home\":1,\"away\":0},\n" +
				"{\"type\":21,\"home\":4,\"away\":8},\n" +
				"{\"type\":24,\"home\":26,\"away\":48},\n" +
				"{\"type\":4,\"home\":0,\"away\":0},\n" +
				"{\"type\":22,\"home\":2,\"away\":13},\n" +
				"{\"type\":25,\"home\":39,\"away\":61},\n" +
				"{\"type\":2,\"home\":1,\"away\":11},{\"type\":8,\"home\":0,\"away\":0},\n" +
				"{\"type\":23,\"home\":57,\"away\":78}],\n" +
				"\n" +
				"\n" +
				"\"incidents\":[{\"type\":1,\"position\":2,\"time\":11,\"player_name\":\"\"},\n" +
				"{\"type\":1,\"position\":2,\"time\":19,\"player_name\":\"\"}]},\n" +
				"\n" +
				"{\"id\":2480366,\"stats\":[{\"type\":23,\"home\":103,\"away\":63},\n" +
				"{\"type\":24,\"home\":45,\"away\":27},{\"type\":2,\"home\":6,\"away\":4},\n" +
				"{\"type\":25,\"home\":57,\"away\":43},\n" +
				"{\"type\":21,\"home\":6,\"away\":3},{\"type\":3,\"home\":0,\"away\":2},\n" +
				"{\"type\":8,\"home\":1,\"away\":0},\n" +
				"{\"type\":22,\"home\":10,\"away\":5},{\"type\":4,\"home\":0,\"away\":0}],\n" +
				"\"incidents\":[{\"type\":1,\"position\":1,\"time\":15,\"player_name\":\"\"},\n" +
				"{\"type\":1,\"position\":1,\"time\":31,\"player_name\":\"\"},\n" +
				"{\"type\":1,\"position\":2,\"time\":48,\"player_name\":\"\"}]},\n" +
				"\n" +
				"{\"id\":0,\"stats\":[{\"type\":8,\"home\":1,\"away\":2},\n" +
				"{\"type\":21,\"home\":7,\"away\":6},{\"type\":2,\"home\":7,\"away\":5},\n" +
				"{\"type\":22,\"home\":7,\"away\":4},\n" +
				"{\"type\":3,\"home\":4,\"away\":1},{\"type\":23,\"home\":85,\"away\":103},{\"type\":4,\"home\":0,\"away\":0},\n" +
				"{\"type\":24,\"home\":64,\"away\":71},{\"type\":25,\"home\":0,\"away\":0}],\n" +
				"\"incidents\":[{\"type\":3,\"position\":1,\"time\":2,\"player_name\":\"A.\\u52d2\\u666e\\u62c9\"},\n" +
				"{\"type\":3,\"position\":1,\"time\":3,\"player_name\":\"J.\\u99ac\\u7279\\u81e3\"},{\"type\":1,\"position\":2,\"time\":13,\"player_name\":\"B.\\u5361\\u62c9\\u6587\"},{\"type\":1,\"position\":2,\"time\":22,\"player_name\":\"A.\\u827e\\u8fea\\u7f8e\"},{\"type\":9,\"position\":1,\"time\":46,\"in_player_name\":\"\\u65af\\u8fea\",\"out_player_name\":\"J.\\u585e\\u8428\\u5c14\"},{\"type\":8,\"position\":1,\"time\":48,\"player_name\":\"\\u6839\\u683c\\u65af\\u9ad8\\u5361\"},{\"type\":1,\"position\":1,\"time\":60,\"player_name\":\"\\u827e\\u65af\\u8cd3\"},{\"type\":9,\"position\":2,\"time\":73,\"in_player_name\":\"\\u8cc0\\u9ad8\\u6069\",\"out_player_name\":\"\\u66fc\\u5824\\u62c9\"},\n" +
				"\n" +
				"  {\"type\":3,\"position\":2,\"time\":73,\"player_name\":\"\\u963f\\u91cc\\u5c3c\\u66fc\"},{\"type\":9,\"position\":1,\"time\":75,\"in_player_name\":\"\\u62ff\\u85a9\\u5c3c\",\"out_player_name\":\"N.\\u99ac\\u745e\\u666e\"},{\"type\":9,\"position\":1,\"time\":81,\"in_player_name\":\"P.\\u6587\\u8fea\\u62ff\",\"out_player_name\":\"J.\\u99ac\\u7279\\u81e3\"},{\"type\":3,\"position\":1,\"time\":81,\"player_name\":\"\\u9ad8\\u7956\\u62ff\"},{\"type\":3,\"position\":1,\"time\":82,\"player_name\":\"\\u65af\\u8fea\"},{\"type\":8,\"position\":2,\"time\":83,\"player_name\":\"M.\\u6606\\u5be7\\u52a0\\u65af\"},{\"type\":9,\"position\":2,\"time\":90,\"in_player_name\":\"L.\\u7dad\\u8d6b\\u62c9\\u6069\",\"out_player_name\":\"A.\\u827e\\u8fea\\u7f8e\"},{\"type\":3,\"position\":2,\"time\":90,\"player_name\":\"H.\\u6469\\u8f9b\\u9054\"}]},{\"id\":2439468,\"stats\":[{\"type\":21,\"home\":3,\"away\":0},{\"type\":8,\"home\":0,\"away\":0},{\"type\":4,\"home\":0,\"away\":0},{\"type\":25,\"home\":44,\"away\":56},{\"type\":3,\"home\":0,\"away\":0},{\"type\":24,\"home\":43,\"away\":62},{\"type\":2,\"home\":5,\"away\":6},{\"type\":23,\"home\":75,\"away\":83},{\"type\":22,\"home\":5,\"away\":11}],\"incidents\":[{\"type\":9,\"position\":2,\"time\":64,\"in_player_name\":\"\\u4ea8\\u5229\\u5b89\\u5c3c\\u4e9e\",\"out_player_name\":\"I.\\u6c99\\u8fea\\u514b\"},{\"type\":9,\"position\":1,\"time\":64,\"in_player_name\":\"\\u5a01\\u5229\",\"out_player_name\":\"J.\\u5217\\u5716\"},{\"type\":9,\"position\":2,\"time\":84,\"in_player_name\":\"F.\\u85a9\\u9054\\u8fea\",\"out_player_name\":\"S.\\u8cc0\\u65af\\u8fea\\u5361\"},{\"type\":9,\"position\":1,\"time\":88,\"in_player_name\":\"H.\\u963f\\u62c9\\u5df4\",\"out_player_name\":\"\\u5947\\u96f2\\u5766\\u5974\"}]},{\"id\":2439469,\"stats\":[{\"type\":23,\"home\":105,\"away\":119},{\"type\":24,\"home\":49,\"away\":67},{\"type\":2,\"home\":3,\"away\":8},{\"type\":25,\"home\":48,\"away\":52},{\"type\":21,\"home\":4,\"away\":4},{\"type\":3,\"home\":2,\"away\":2},{\"type\":8,\"home\":1,\"away\":0},{\"type\":22,\"home\":5,\"away\":5},{\"type\":4,\"home\":0,\"away\":0}],\"incidents\":[{\"type\":1,\"position\":2,\"time\":3,\"player_name\":\"\\u7f8e\\u5716\\u56e0 (\\u52a9\\u653b:\\u8b5a\\u7f8e\\u7d0d)\"},{\"type\":3,\"position\":2,\"time\":40,\"player_name\":\"T.\\u897f\\u62c9\"},{\"type\":1,\"position\":1,\"time\":41,\"player_name\":\"\\u76e7\\u5361\\u65af\\u54e5\\u592b\\u66fc\"},{\"type\":3,\"position\":1,\"time\":45,\"player_name\":\"T.\\u6c99\\u4e9e\\u9023\\u5c3c\"},{\"type\":1,\"position\":1,\"time\":61,\"player_name\":\"\\u76e7\\u5361\\u65af\\u54e5\\u592b\\u66fc\"},{\"type\":3,\"position\":2,\"time\":64,\"player_name\":\"\\u7f8e\\u5716\\u56e0\"},{\"type\":1,\"position\":1,\"time\":65,\"player_name\":\"\\u54c8\\u7dad\\u65af\"},{\"type\":9,\"position\":1,\"time\":66,\"in_player_name\":\"K.\\u91cc\\u80af\\u6069\",\"out_player_name\":\"\\u62c9\\u5e0c\\u7f8e\"},{\"type\":9,\"position\":2,\"time\":66,\"in_player_name\":\"N.\\u7d04\\u51f1\\u62c9\",\"out_player_name\":\"M.\\u8482\\u5967\"},{\"type\":9,\"position\":2,\"time\":70,\"in_player_name\":\"\\u54c8\\u62c9\\u62c9\",\"out_player_name\":\"\\u862d\\u862d\\u5361\\u5c3c\"},{\"type\":9,\"position\":1,\"time\":75,\"in_player_name\":\"N.\\u5967\\u535a\\u591a\\u592b\",\"out_player_name\":\"\\u76e7\\u5361\\u65af\\u54e5\\u592b\\u66fc\"},{\"type\":9,\"position\":2,\"time\":76,\"in_player_name\":\"\\u99ac\\u8482\\u4e9e\\u65af\\u5967\\u4e9e\\u62c9\",\"out_player_name\":\"\\u4f0a\\u8def\\u67e5\\u57df\\u502b\"},{\"type\":3,\"position\":1,\"time\":81,\"player_name\":\"\\u5229\\u96f2\\u6069\"},{\"type\":8,\"position\":1,\"time\":82,\"player_name\":\"B.\\u5188\\u8428\\u96f7\\u65af\"},{\"type\":9,\"position\":1,\"time\":85,\"in_player_name\":\"\\u99ac\\u57fa\\u67e5\\u57df\",\"out_player_name\":\"\\u54c8\\u7dad\\u65af\"}]},{\"id\":2444764,\"stats\":[{\"type\":23,\"home\":183,\"away\":117},{\"type\":24,\"home\":135,\"away\":63},{\"type\":2,\"home\":13,\"away\":2},{\"type\":25,\"home\":64,\"away\":36},{\"type\":21,\"home\":8,\"away\":8},{\"type\":3,\"home\":2,\"away\":4},{\"type\":8,\"home\":0,\"away\":0},{\"type\":22,\"home\":3,\"away\":2},{\"type\":4,\"home\":0,\"away\":0}],\"incidents\":[{\"type\":1,\"position\":2,\"time\":35,\"player_name\":\"Warrilow\"},{\"type\":1,\"position\":1,\"time\":48,\"player_name\":\"Hills\"},{\"type\":1,\"position\":2,\"time\":55,\"player_name\":\"Sherwood\"},{\"type\":1,\"position\":2,\"time\":77,\"player_name\":\"Kuboyama\"},{\"type\":1,\"position\":2,\"time\":80,\"player_name\":\"Kuboyama\"},{\"type\":1,\"position\":2,\"time\":85,\"player_name\":\"Kuboyama\"}]}]";

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
					if(queryById.getStatus()!=8){//这个是证明球赛已经开始，并且还未结束，但是现在可能有重复，待定
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
									String message="精彩！"+name_zh+"攻入了本场第"+home_grade+"个球！";
									broadcastMessage.setMinutes(incident.getTime());
									broadcastMessage.setText(message);
									broadcastMessage.setLogo("images/broadcast/进球.png");
								}else if (incident.getType()==9){//换人
									String message=name_zh+"换人："+incident.getIn_player_name()+"替换"+incident.getOut_player_name();
									broadcastMessage.setMinutes(incident.getTime());
									broadcastMessage.setText(message);
									broadcastMessage.setLogo("images/broadcast/换人.png");
								}else{//不属于进球和换人
									String message = BroadcastUtils.getMessage(incident.getType(), name_zh);
									String logo = BroadcastUtils.getLogo(incident.getType());
									if(message!=null){//证明部位空
										broadcastMessage.setLogo(logo);
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
				broadcastData1.add(broadcastData);
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
			broadcastData1.add(broadcastData);
			return  broadcastData1;
		}


	}
}
