package com.yb.test;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.yb.entity.Broadcast;

public class TestBroad {
	public static void main(String[] args) {
		 String s="[{\"id\":2448189,\"stats\":[{\"type\":3,\"home\":1,\"away\":0},\n" +
	                "{\"type\":21,\"home\":4,\"away\":8},\n" +
	                "{\"type\":24,\"home\":26,\"away\":48},\n" +
	                "{\"type\":4,\"home\":0,\"away\":0},{\"type\":22,\"home\":2,\"away\":13},{\"type\":25,\"home\":39,\"away\":61},\n" +
	                "{\"type\":2,\"home\":1,\"away\":11},{\"type\":8,\"home\":0,\"away\":0},{\"type\":23,\"home\":57,\"away\":78}],\n" +
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
	                "{\"type\":1,\"position\":2,\"time\":48,\"player_name\":\"\"}]}]";
		 List<Broadcast> parseArray = JSONArray.parseArray(s, Broadcast.class);
		 for (Broadcast broadcast : parseArray) {
			System.out.println(broadcast);
		}
	}
}
