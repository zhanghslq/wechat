package com.yb.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.yb.entity.WeChatData;
import com.yb.util.OpenUtils;

public class Test {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		/* String string ="{\"session_key\":\"NSLRcknUk4DmRuUFnX8a+w==\",\"openid\":\"om9W35Siht5C9hWmXkbYkXB2f7xI\"}";
		 WeChatData parseObject = JSON.parseObject(string, WeChatData.class);
		 System.out.println(parseObject);*/
		 WeChatData permission = OpenUtils.getPermission("061abTrU1OwCjW0G8crU1ztSrU1abTra");
		System.out.println(permission);
	}
}
