package com.yb.test;

import com.alibaba.fastjson.JSON;
import com.yb.entity.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
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
        String token = "10_0wp8jgPYmedHowQ-PFnbI232AfL5nmOX1UCsZh_zalKym34dRoWziHRG4y1YkL80VzPGo_xm8jVph9dQAwMhvUDHOlI_vNR0g7soDcNI75lh-SJ3Q0zdzAEOz5l_EMBiqWVhXnFSGk5wML6mSJQdAJAVMT";//查询出来的可用token

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
            try {
                entity = new StringEntity(JSON.toJSONString(accessData));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            try {
                String s = Request.Post(requestUrl).body(entity).execute().returnContent().asString();
                System.out.println("返回结果"+s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
