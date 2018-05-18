package com.yb.test;


import java.util.List;

import net.sf.json.JSONArray;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yb.entity.Team;

public class TestJson {
	public static void main(String[] args) {
		 String s="{\"26105\":{\"id\":26105,\"name_zh\":\"KPS\",\"name_zht\":\"KPS\",\"name_en\":\"KPS\",\n" +
	                "\"logo\":\"3a460497d6481b725045a076aa51abea.png\",\"matchevent_id\":1940},\n" +
	                "\n" +
	                "\"40479\":{\"id\":40479,\"name_zh\":\"\\u79d1\\u4ec0\\u5948\\u65afFF\",\n" +
	                "\"name_zht\":\"\\u79d1\\u4ec0\\u5948\\u65afFF\",\"name_en\":\"Korsnas FF\",\n" +
	                "\"logo\":\"icon_team_default.png\",\"matchevent_id\":1940}}";
		 String s2="[[2477235,1940,8,1526574600,1526578660,[26105,\"\",1,1,0,4,9,0,0],[40479,\"\",4,1,0,2,3,0,0],[\"\",0,1,\"\",\"\",\"\"],\n" +
	                "[0,\"\",1,0]],\n" +
	                "[2476571,169,8,1526574600,1526578282,[12568,\"7\",0,0,0,1,7,0,0],[10378,\"17\",0,0,0,1,3,0,0],\n" +
	                "[\"\\u5347\\u964d\\u7ea7\\u9644\\u52a0\\u8d5b \\u672c\\u573a\\u4e3a\\u9996\\u56de\\u5408\",0,1,\"20180517_\\u5468\\u56db008\",\"180504_64\",\"\"],\n" +
	                "[7162,\"2017-2018\",1,1]]]";
		 /*net.sf.json.JSONObject json_Arr = net.sf.json.JSONObject.fromObject(s);
		 for (Object key1 : json_Arr.keySet()) {
             String jsonObjStr = json_Arr.get(key1).toString();            
             net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(jsonObjStr);
             Object bean = net.sf.json.JSONObject.toBean(jsonObject, Team.class);
             System.out.println(bean);
		 }*/
		 JSONArray fromObject = JSONArray.fromObject(s2);
		 Object object = fromObject.get(0);
		 JSONArray fromObject2 = JSONArray.fromObject(object.toString());
		 Object object2 = fromObject2.get(5);
		 JSONArray fromObject3 = JSONArray.fromObject(object2);
		 int int1 = fromObject3.getInt(2);
		 System.out.println(int1);
		 
		 
	        
	}
}
