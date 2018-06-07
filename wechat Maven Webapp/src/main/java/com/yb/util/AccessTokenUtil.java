package com.yb.util;

import java.io.IOException;

import org.apache.http.client.fluent.Request;

import com.alibaba.fastjson.JSON;
import com.yb.entity.AccessToken;

public class AccessTokenUtil {
	private static AccessToken parseObject;
	public static AccessToken freshAccessToken() {
		if(parseObject==null){
			String asString;
			try {
				asString = Request.Get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxd8e55b753a567d41&secret=fd365e71704a8f1e8bc28f0f3f532314")
						.execute().returnContent().asString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("获取access_token异常");
			}
			parseObject = JSON.parseObject(asString, AccessToken.class);
		}
		return parseObject;
	}
	public static void main(String[] args) {
		AccessToken freshAccessToken = freshAccessToken();
		System.out.println(freshAccessToken);
	}
}
