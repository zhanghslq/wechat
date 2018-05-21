package com.yb.quartz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yb.entity.Events;
import com.yb.entity.Team;
import com.yb.util.CharSetUtil;

@Component
public class MachesQuartz {
	@Scheduled(cron="0 0 1 * * ?")//每天晚上1点
	public void  autoGrade() throws ClientProtocolException, IOException {
		String asString = Request.Get("http://docs.open.leisu.com/#/index?user=")
		.setHeader("content-type", "application/x-www-form-urlencoded")
		.execute().returnContent().asString();
		//String decodeUnicode = CharSetUtil.decodeUnicode(asString);//把unicode編碼的都變回來
		
		JSONObject fromObject = JSONObject.fromObject(asString);
		String string = fromObject.get("teams").toString();//整个team
		JSONObject json_Arr = JSONObject.fromObject(string);
		List<Team> teams = new ArrayList<Team>();
		for (Object key1 : json_Arr.keySet()) {
            String jsonObjStr = json_Arr.get(key1).toString();            
            net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(jsonObjStr);
            Team bean = (Team) net.sf.json.JSONObject.toBean(jsonObject, Team.class);
            teams.add(bean);
		 }
		
		List<Events> events = new ArrayList<Events>();
		String string2 = fromObject.get("events").toString();//整个Event对象
		JSONObject fromObject2 = JSONObject.fromObject(string2);
		for (Object key1 : fromObject2.keySet()) {
            String jsonObjStr = fromObject2.get(key1).toString();            
            net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(jsonObjStr);
            Events bean = (Events) JSONObject.toBean(jsonObject, Events.class);
           events.add(bean);
		 }
		
		String string3 = fromObject.get("matches").toString();//这是最后的比赛数组
		JSONArray jsonArray = JSONArray.fromObject(string3);
		for (Object object : jsonArray) {
			JSONArray jsonArray2 = JSONArray.fromObject(object);
			jsonArray2.get(0);//比赛id
			jsonArray2.get(1);//联赛id
			jsonArray2.get(2);//状态
			jsonArray2.get(3);//比赛时间
			//jsonArray2.get(4);//开球时间
			Object object2 = jsonArray2.get(5);
			JSONArray objhome = JSONArray.fromObject(object2);
			objhome.get(0);//主队id
			objhome.get(2);//主队比分
			Object object3 = jsonArray2.get(6);
			JSONArray objvisit = JSONArray.fromObject(object3);
			objvisit.get(0);//ke队id
			objvisit.get(2);//ke队比分
		}
		//需要把这些数据插入数据库
		
	}
	public static void main(String[] args) {
	}
}
