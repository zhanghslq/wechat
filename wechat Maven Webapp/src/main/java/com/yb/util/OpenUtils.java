package com.yb.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.alibaba.fastjson.JSON;
import com.yb.entity.WeChatData;

/**
 * 通过code获取openid
 * @author lenovo
 *
 */
public class OpenUtils {
	public static WeChatData getPermission(String code) throws ClientProtocolException, IOException {
		String url="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code="+code+"&grant_type=authorization_code";
		String asString = Request.Get(url).execute().returnContent().asString();
		WeChatData parseObject = JSON.parseObject(asString, WeChatData.class);
		return parseObject;
	}
	public static String getOpenId(String code) throws ClientProtocolException, IOException {
		String url="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code="+code+"&grant_type=authorization_code";
		String asString = Request.Get(url).execute().returnContent().asString();
		WeChatData parseObject = JSON.parseObject(asString, WeChatData.class);
		String openid = parseObject.getOpenid();
		return openid;
	}
}
