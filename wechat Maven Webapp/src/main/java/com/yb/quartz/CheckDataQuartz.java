package com.yb.quartz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yb.entity.Match;

@Component
public class CheckDataQuartz {
	//每分钟检测一次，看比赛是否有结果了，有结果的话，就进行结算
	@Scheduled(cron="0 * * * * ?")//每分钟一次，取当天的数据
	public void  autoCheck() throws ClientProtocolException, IOException {
		String asString = Request.Get("http://docs.open.leisu.com/#/index?user=&date=")
				.setHeader("content-type", "application/x-www-form-urlencoded")
				.execute().returnContent().asString();
		JSONObject fromObject = JSONObject.fromObject(asString);
		String string3 = fromObject.get("matches").toString();//这是最后的比赛数组
		JSONArray jsonArray = JSONArray.fromObject(string3);
		List<Match> matches = new ArrayList<Match>();
		for (Object object : jsonArray) {
			JSONArray jsonArray2 = JSONArray.fromObject(object);
			int id = jsonArray2.getInt(0);//比赛id
			int eventid = jsonArray2.getInt(1);//联赛id
			int status = jsonArray2.getInt(2);//状态
			long time = jsonArray2.getLong(3);//比赛时间
			//jsonArray2.get(4);//开球时间
			Object object2 = jsonArray2.get(5);
			JSONArray objhome = JSONArray.fromObject(object2);
			int homeid = objhome.getInt(0);//主队id
			int home_grade = objhome.getInt(2);//主队比分
			Object object3 = jsonArray2.get(6);
			JSONArray objvisit = JSONArray.fromObject(object3);
			int visitid = objvisit.getInt(0);//ke队id
			int visit_grade = objvisit.getInt(2);//ke队比分
			Match match = new Match(id, eventid, status, new Date(time*1000), homeid, home_grade, visitid, visit_grade);
			matches.add(match);
		}
		//取出来的比赛集合，判断比赛状态是否完成，结束比赛的拉出来，然后判断数据库里面结束比赛没有，如果数据库里面是结束比赛的，就
		//不管，如果拉出来数据比赛完成，数据库里面没有比赛完成，就要更新比赛状态，然后结算赌注
		
	}
}
