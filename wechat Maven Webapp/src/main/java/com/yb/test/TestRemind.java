package com.yb.test;

import com.yb.entity.*;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestRemind {
    public static void main(String[] args) {
         SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String token = "10_oaABf5EJbMUKOljTfrON2x0WIMuQwrJQK9XK8_OVwiUmPiwEnIemvax_4GQkdbNNkeoTIdpDtN8DzRS8kQDXcGPIGmkp4Cy0XgM1BaLQ8HlvrmruMi2m-gdhDyImFF6tPJJG0OUChMcGcF-aSDXeAIAYJD";//查询出来的可用token

        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token;
        AccessData accessData = new AccessData();
        Data data = new Data();
        data.setKeyWord1(new KeyWord(simpleDateFormat.format(new Date())));//时间
        data.setKeyWord2(new KeyWord("世界杯"));//名称
        data.setKeyWord3(new KeyWord("小组赛"));//类别
        data.setKeyWord4(new KeyWord("测试主队"+ "VS "+"测试客队"));//比赛双方信息
        accessData.setData(data);
        accessData.setTemplate_id("ieGlFt3tw-MeWygXztLbAgiuxzkt1SSn8-x7wMUJmrw");
            accessData.setForm_id("1529112675609");
            accessData.setTouser("om9W35XZSDg9jD69BD1Uc_CYId50");
            HttpEntity entity= null;

        String sdata="";
            try {
                sdata = JSONObject.fromObject(accessData).toString();
                System.out.println(sdata);
                entity = new StringEntity(sdata);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            try {
                String s = Request.Post(requestUrl).bodyString(sdata, ContentType.APPLICATION_JSON)
                        //.body(entity)
                        .execute().returnContent().asString();
                System.out.println("返回结果"+s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
