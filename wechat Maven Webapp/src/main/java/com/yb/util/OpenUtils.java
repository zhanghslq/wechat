package com.yb.util;

import org.apache.http.client.fluent.Request;

import com.alibaba.fastjson.JSON;
import com.yb.entity.WeChatData;

/**
 * 通过code获取openid
 * @author lenovo
 *
 */
public class OpenUtils {
	public static WeChatData getPermission(String code){
		try {
			String url="https://api.weixin.qq.com/sns/jscode2session?appid=wxd8e55b753a567d41&secret=fd365e71704a8f1e8bc28f0f3f532314&js_code="+code+"&grant_type=authorization_code";
			String asString = Request.Get(url).execute().returnContent().asString();
			WeChatData parseObject = JSON.parseObject(asString, WeChatData.class);
			return parseObject;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("获取openid出错");
		}
	}
	public static String getString(String code){
		try {
			String url="https://api.weixin.qq.com/sns/jscode2session?appid=wxd8e55b753a567d41&secret=fd365e71704a8f1e8bc28f0f3f532314&js_code="+code+"&grant_type=authorization_code";
			String asString = Request.Get(url).execute().returnContent().asString();
			return asString;
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("获取openid异常");
		}
	}
	public static String getOpenId(String code){
		try {
			String url="https://api.weixin.qq.com/sns/jscode2session?appid=wxd8e55b753a567d41&secret=fd365e71704a8f1e8bc28f0f3f532314&js_code="+code+"&grant_type=authorization_code";
			String asString = Request.Get(url).execute().returnContent().asString();
			System.out.println(asString);
			WeChatData parseObject = JSON.parseObject(asString, WeChatData.class);
			String openid = parseObject.getOpenid();
			return openid;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("获取openid异常");
		}
	}
}
