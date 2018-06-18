package com.yb.util;

import com.yb.entity.Template;
import net.sf.json.JSONObject;

public class HttpUtils {
    public static boolean sendTemplateMsg(Template template,String token){
        boolean flag=false;
        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";
        requestUrl=requestUrl.replace("ACCESS_TOKEN", token);
        String jsonString = template.toJSON();
        JSONObject jsonResult=CommonUtil.httpsRequest(requestUrl, "POST", jsonString);
        if(jsonResult!=null){
            int errorCode=jsonResult.getInt("errcode");
            String errorMessage=jsonResult.getString("errmsg");
            if(errorCode==0){
                flag=true;
            }else{
                System.out.println("模板消息发送失败:"+errorCode+","+errorMessage);
                flag=false;
            }
        }
        return flag;
    }
}
