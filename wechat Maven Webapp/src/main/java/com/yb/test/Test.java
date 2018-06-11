package com.yb.test;

import java.io.IOException;

import com.yb.util.Md5Utils;
import org.apache.http.client.ClientProtocolException;

import com.yb.entity.WeChatData;
import com.yb.util.OpenUtils;

public class Test {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		/* String string ="{\"session_key\":\"NSLRcknUk4DmRuUFnX8a+w==\",\"openid\":\"om9W35Siht5C9hWmXkbYkXB2f7xI\"}";
		 WeChatData parseObject = JSON.parseObject(string, WeChatData.class);
		 System.out.println(parseObject);*/
		/*WeChatData permission = OpenUtils.getPermission("061abTrU1OwCjW0G8crU1ztSrU1abTra");
		System.out.println(permission);*/
		/*String string = new String("\u5206\u7ec4\u8d5b");
		System.out.println(string);*/
		String test = Md5Utils.MD5("test");
		System.out.println(test);
	}
}
