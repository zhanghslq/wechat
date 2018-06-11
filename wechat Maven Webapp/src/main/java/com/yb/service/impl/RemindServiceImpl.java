package com.yb.service.impl;

import com.alibaba.fastjson.JSON;
import com.yb.dao.*;
import com.yb.entity.*;
import com.yb.service.RemindService;
import com.yb.util.AccessTokenUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RemindServiceImpl implements RemindService{


    @Autowired
    private RemindDao remindDao;
    @Autowired
    private AccessTokenDao accessTokenDao;
    @Autowired
    private MatchDao matchDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private StageDao stageDao;
    @Override
    public void insert(Remind remind) {
        remindDao.insert(remind);
    }
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void remind() {//自动提醒
        //查询出来需要提醒的

        //需要先查询还有十分钟开始的比赛
        List<Match> matches = matchDao.queryMatchesTenMinutes();
        if(matches!=null&&matches.size()!=0){//最近有比赛去查询
            for (Match match : matches) { //然后遍历比赛
                List<Remind> reminds = remindDao.queryAllByMatchId(match.getId());//查出来的需要提醒的比赛
                String token = accessTokenDao.query();//查询出来的可用token
                String requestUrl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token;
                AccessData accessData = new AccessData();
                Data data = new Data();
                Date time = match.getTime();//比赛时间
                Team team = teamDao.queryById(match.getHomeid());//主队
                Team visit = teamDao.queryById(match.getVisitid());//客队
                Stage stage = stageDao.queryById(match.getStageId());

                data.setKeyWord1(new KeyWord(simpleDateFormat.format(time)));//时间
                data.setKeyWord2(new KeyWord("世界杯"));//名称
                data.setKeyWord3(new KeyWord(stage.getName_zh()));//类别
                data.setKeyWord4(new KeyWord(team.getName_zh()+" VS "+visit.getName_zh()));//比赛双方信息
                accessData.setData(data);
                accessData.setTemplate_id("ieGlFt3tw-MeWygXztLbAgiuxzkt1SSn8-x7wMUJmrw");
                for (Remind remind : reminds) {
                    accessData.setForm_id(remind.getForm_id());
                    accessData.setTouser(remind.getUid());
                    HttpEntity entity= null;
                    try {
                        entity = new StringEntity(JSON.toJSONString(accessData));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    try {
                        Request.Post(requestUrl).body(entity).execute().returnContent().asString();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            }
    }

    @Override
    public void updateAccessToken() {//更新accessToken
        AccessToken accessToken = AccessTokenUtil.freshAccessToken();
        accessTokenDao.insertToken(accessToken);
    }
}
