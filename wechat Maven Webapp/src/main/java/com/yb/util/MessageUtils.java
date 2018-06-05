package com.yb.util;

import com.yb.entity.Template;

public class MessageUtils {
		public static boolean sendTemplateMsg(String token,Template template){  
	        boolean flag=false;  
	        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";  
	        //這是获取accesstoken的接口
	        String requestUrl1="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";  
	        
	        requestUrl=requestUrl.replace("ACCESS_TOKEN", token);
			return flag;  
	        //JSONObject jsonResult=CommonUtil.httpsRequest(, "POST", template.toJSON()); 
	        /*if(jsonResult!=null){  
	            int errorCode=jsonResult.getInt("errcode");  
	            String errorMessage=jsonResult.getString("errmsg");  
	            if(errorCode==0){  
	                flag=true;  
	            }else{  
	                System.out.println("模板消息发送失败:"+errorCode+","+errorMessage);  
	                flag=false;  
	            }  
	        }  
	        return flag;  */
	}
}
