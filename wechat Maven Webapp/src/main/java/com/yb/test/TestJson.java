package com.yb.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.yb.entity.Events;
import com.yb.entity.Match;
import com.yb.entity.Team;

public class TestJson {
	public static void main(String[] args) {
		 String s="{\"26105\":{\"id\":26105,\"name_zh\":\"KPS\",\"name_zht\":\"KPS\",\"name_en\":\"KPS\",\n" +
	                "\"logo\":\"3a460497d6481b725045a076aa51abea.png\",\"matchevent_id\":1940},\n" +
	                "\n" +
	                "\"40479\":{\"id\":40479,\"name_zh\":\"\\u79d1\\u4ec0\\u5948\\u65afFF\",\n" +
	                "\"name_zht\":\"\\u79d1\\u4ec0\\u5948\\u65afFF\",\"name_en\":\"Korsnas FF\",\n" +
	                "\"logo\":\"icon_team_default.png\",\"matchevent_id\":1940}}";
		 String asString=getXmlString();
		 /*net.sf.json.JSONObject json_Arr = net.sf.json.JSONObject.fromObject(s);
		 for (Object key1 : json_Arr.keySet()) {
             String jsonObjStr = json_Arr.get(key1).toString();            
             net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(jsonObjStr);
             Object bean = net.sf.json.JSONObject.toBean(jsonObject, Team.class);
             System.out.println(bean);
		 }*/
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
			System.out.println(teams);
			List<Events> events = new ArrayList<Events>();
			String string2 = fromObject.get("events").toString();//整个Event对象
			JSONObject fromObject2 = JSONObject.fromObject(string2);
			for (Object key1 : fromObject2.keySet()) {
	            String jsonObjStr = fromObject2.get(key1).toString();            
	            net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(jsonObjStr);
	            Events bean = (Events) JSONObject.toBean(jsonObject, Events.class);
	           events.add(bean);
			 }
			System.out.println(events);
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
			//需要把这些数据插入数据库
			System.out.println(matches);
		 /*Object object = fromObject.get(0);
		 JSONArray fromObject2 = JSONArray.fromObject(object.toString());
		 Object object2 = fromObject2.get(5);
		 JSONArray fromObject3 = JSONArray.fromObject(object2);
		 int int1 = fromObject3.getInt(2);
		 System.out.println(int1);*/
		 
		 
	        
	}
	
	public static String getXmlString() {
		byte[] strBuffer = null;
		int flen = 0;
		File xmlfile = new File("test.json");
		try {
		InputStream in = new FileInputStream(xmlfile);
		flen = (int)xmlfile.length();
		strBuffer = new byte[flen];
		in.read(strBuffer, 0, flen);
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}finally{
			
		}
		String xmlString= new String(strBuffer);
		return xmlString;
	}
}
