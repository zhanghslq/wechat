package com.yb.util;

import java.io.IOException;

import com.yb.entity.RequestTempData;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;

import com.alibaba.fastjson.JSON;
import com.yb.entity.AccessToken;
import org.apache.http.entity.StringEntity;

public class AccessTokenUtil {
	public static AccessToken freshAccessToken() {
			AccessToken parseObject;
			String asString;
			try {
				asString = Request.Get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxd8e55b753a567d41&secret=fd365e71704a8f1e8bc28f0f3f532314")
						.execute().returnContent().asString();
				parseObject = JSON.parseObject(asString, AccessToken.class);
				return parseObject;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("获取access_token异常");
		}
	}
	public static void main(String[] args) {
		//AccessToken freshAccessToken = freshAccessToken();
		//freshAccessTokenSystem.out.println(freshAccessToken);
		/*String id = getId();
		System.out.println(id);*/
		String id = getId();
		System.out.println(id);
	}
	//获取模板列表
	public static String getId(){
		RequestTempData requestTempData = new RequestTempData(0, 20);
		String s = JSON.toJSONString(requestTempData);
		HttpEntity entity = new StringEntity(s, "UTF-8");
		String asString ;
		try {
			asString = Request.Post("https://api.weixin.qq.com/cgi-bin/wxopen/template/library/list?access_token=10_joQhEdEadVDtBP1XPFnbI232AfL5nmOX1UCsZlFwWEaGuUrHU6LMGLvsn7KSvMpyafCdmIsT2znrwYfy3xuYn8o5UobYoNjPdeLTkYvQ8sRl1LmybEOInyQ6LwS0e19o2CIAQ-Q1Mt8m84YdIWJhAHACQD")
                    .body(entity).execute().returnContent().asString();
		} catch (IOException e) {
			e.printStackTrace();
			return  "一场";
		}
		return asString;
	}
}
