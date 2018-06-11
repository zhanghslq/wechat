package com.yb.util;

import com.yb.entity.Template;

/**
 * 发模板消息的工具类
 */
public class MessageUtils {
		public static boolean sendTemplateMsg(String token,Template template){  
	        boolean flag=false;
	        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token;

			return flag;
		}
}
