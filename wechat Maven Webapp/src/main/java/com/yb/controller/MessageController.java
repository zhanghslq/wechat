package com.yb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.Template;
import com.yb.entity.TemplateParam;
import com.yb.util.CommonUtil;
import com.yb.util.Configure;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class MessageController {

    /**
     * 获取openId
     * @param request
     * @param model
     * @throws IOException
     */


    /**
     * 发送微信消息
     * @param request
     * @param model
     */
    public void sendMessage(String openId,String formId,HttpServletRequest request,Model model){
        Template tem=new Template();
        tem.setTemplateId("WsHtokVPQi807XPVUm7HRr7MofSzhroc47hbOc5Yk1s");
        tem.setFormId(formId);
        tem.setTopColor("#00DD00");
        tem.setToUser(openId);
        tem.setUrl("");

        List<TemplateParam> paras=new ArrayList<TemplateParam>();
        paras.add(new TemplateParam("keyword1","猪猪侠","#0044BB"));
        paras.add(new TemplateParam("keyword2","999","#0044BB"));
        paras.add(new TemplateParam("keyword3","成个猪栏最叻就系你","#AAAAAA"));
        paras.add(new TemplateParam("keyword4","666","#0044BB"));

        tem.setTemplateParamList(paras);
        boolean result=sendTemplateMsg(tem);
        System.out.println(result);
    }

    public static void main(String[] args) {
        Template tem=new Template();
        tem.setTemplateId("ieGlFt3tw-MeWygXztLbAgiuxzkt1SSn8-x7wMUJmrw");
        tem.setFormId("1529143986356");
        tem.setTopColor("#00DD00");
        tem.setToUser("om9W35XZSDg9jD69BD1Uc_CYId50");
        List<TemplateParam> paras=new ArrayList<TemplateParam>();
        paras.add(new TemplateParam("keyword1","猪猪侠","#0044BB"));
        paras.add(new TemplateParam("keyword2","999","#0044BB"));
        paras.add(new TemplateParam("keyword3","成个猪栏最叻就系你","#AAAAAA"));
        paras.add(new TemplateParam("keyword4","666","#0044BB"));

        tem.setTemplateParamList(paras);
        boolean result=sendTemplateMsg(tem);
        System.out.println(result);
    }

    public static boolean sendTemplateMsg(Template template){
        String token = "10_e0_Mayd2K5SzssXmev1wFH8b6LWj1u8qFVVCYccXrpMeT_3ptQfvpJATia_yWwrEXCaasKUWSXDfvz-lrmkMfZpKYjTmqTVd5PdIo5HymzI_Sb7EstQL26c1wmQHDGeAEAXTW";
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


    /**
     *获取token
     * @param template
     * @return
     */

}