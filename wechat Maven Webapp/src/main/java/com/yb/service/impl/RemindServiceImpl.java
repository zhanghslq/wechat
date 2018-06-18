package com.yb.service.impl;

import com.alibaba.fastjson.JSON;
import com.yb.dao.*;
import com.yb.entity.*;
import com.yb.service.AutoService;
import com.yb.service.RemindService;
import com.yb.util.AccessTokenUtil;
import com.yb.util.HttpUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @Autowired
    private AutoService autoService;
    @Override
    public void insert(Remind remind) {
        Remind remind1 = remindDao.queryByMatchIdAndUid(remind.getOpenId(), remind.getMatchId());
        if(remind1==null){//如果没有这场比赛的赛事提醒，才会添加赛事提醒
            remindDao.insert(remind);
        }
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
                if(token==null){
                    autoService.autoAccessToken();
                    token=accessTokenDao.query();
                }
                String requestUrl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token;
                Data data = new Data();
                Date time = match.getTime();//比赛时间
                Team team = teamDao.queryById(match.getHomeid());//主队
                Team visit = teamDao.queryById(match.getVisitid());//客队
                Stage stage = stageDao.queryById(match.getStageId());

                List<Integer> ids = new ArrayList<>();
                for (Remind remind : reminds) {
                    ids.add(remind.getId());
                    Template tem=new Template();
                    tem.setTemplateId("ieGlFt3tw-MeWygXztLbAgiuxzkt1SSn8-x7wMUJmrw");
                    tem.setFormId(remind.getForm_id());
                    tem.setTopColor("#00DD00");
                    tem.setToUser(remind.getOpenId());
                    List<TemplateParam> paras=new ArrayList<TemplateParam>();
                    paras.add(new TemplateParam("keyword1",simpleDateFormat.format(time),"#0044BB"));
                    paras.add(new TemplateParam("keyword2","世界杯","#0044BB"));
                    paras.add(new TemplateParam("keyword3",stage.getName_zh(),"#AAAAAA"));
                    paras.add(new TemplateParam("keyword4",team.getName_zh()+" VS "+visit.getName_zh(),"#0044BB"));
                    tem.setTemplateParamList(paras);
                    boolean result= HttpUtils.sendTemplateMsg(tem,token);
                }
                if(ids.size()!=0){
                    remindDao.updateStatus(ids);
                }
            }
            }
    }

}
