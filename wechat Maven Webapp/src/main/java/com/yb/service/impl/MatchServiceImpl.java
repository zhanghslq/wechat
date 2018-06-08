package com.yb.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.dao.ContractDao;
import com.yb.dao.ContractGroupDao;
import com.yb.dao.MatchDao;
import com.yb.dao.TeamDao;
import com.yb.entity.Banner;
import com.yb.entity.Match;
import com.yb.entity.MatchData;
import com.yb.entity.Team;
import com.yb.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService{
	@Autowired
	private MatchDao matchDao;
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private ContractDao contractDao;
	@Autowired
	private ContractGroupDao contractGroupDao;
	private SimpleDateFormat sfDateFormat=new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sf=new SimpleDateFormat("MM月dd日   HH:mm");
	
	@Override
	public List<Banner> queryBanner(String openId) {//查询当前赛事
		// TODO Auto-generated method stub
		if(new Date().getTime()>1528905600000l){//世界杯开始,取当天的数据
			List<Match> queryMatches = matchDao.queryMatchesToday(openId);//获取到的赛事，然后判断，是否是发起人，是否参加契约
			List<Banner> data = new ArrayList<Banner>();//存放包装好的返回信息
			for (Match match : queryMatches) {
				Team home = teamDao.queryById(match.getHomeid());
				Team visit = teamDao.queryById(match.getVisitid());
				Integer id = match.getId();
				//这是普通契约
				Integer queryNumber = contractDao.queryNumber(id);
				Integer queryCreateByUid = contractDao.queryCreateByUid(openId,id);
				Integer queryJoinByUid = contractDao.queryJoinByUid(openId, id);
				Boolean create=false;
				Boolean join=false;
				if(queryCreateByUid!=null){
					create=true;
				}
				if(queryJoinByUid!=null){
					join=true;
				}
				//检查群pk,
				Integer queryNumberByMatchId = contractGroupDao.queryNumberByMatchId(id);
				Integer queryCreateByUid2 = contractGroupDao.queryCreateByUid(id,openId);
				Integer queryJoinByUid2 = contractGroupDao.queryJoinByUid(id, openId);
				Boolean create2=false;
				Boolean join2=false;
				if(queryCreateByUid2!=null){
					create2=true;
				}
				if(queryJoinByUid2!=null){
					join2=true;
				}
				Date time = match.getTime();
				Banner banner = new Banner(match.getId(), time, home, visit, queryNumber+queryNumberByMatchId, create, join,create2,join2);
				Integer queryRownum = matchDao.queryRownum(match.getTime());
				banner.setRownum(queryRownum);
				banner.setTimeDesc(sf.format(time));
				data.add(banner);
			}
			return data;
		}else{//世界杯未开始
			List<Match> queryMatches = matchDao.queryMatches(openId);//获取到的赛事，然后判断，是否是发起人，是否参加契约
			List<Banner> data = new ArrayList<Banner>();//存放包装好的返回信息
			int i=1;
			for (Match match : queryMatches) {
				Team home = teamDao.queryById(match.getHomeid());
				Team visit = teamDao.queryById(match.getVisitid());
				Integer id = match.getId();
				//这是普通契约
				Integer queryNumber = contractDao.queryNumber(id);
				Integer queryCreateByUid = contractDao.queryCreateByUid(openId,id);
				Integer queryJoinByUid = contractDao.queryJoinByUid(openId, id);
				Boolean create=false;
				Boolean join=false;
				if(queryCreateByUid!=null){
					create=true;
				}
				if(queryJoinByUid!=null){
					join=true;
				}
				//检查群pk,
				Integer queryNumberByMatchId = contractGroupDao.queryNumberByMatchId(id);
				Integer queryCreateByUid2 = contractGroupDao.queryCreateByUid(id,openId);
				Integer queryJoinByUid2 = contractGroupDao.queryJoinByUid(id, openId);
				Boolean create2=false;
				Boolean join2=false;
				if(queryCreateByUid2!=null){
					create2=true;
				}
				if(queryJoinByUid2!=null){
					join2=true;
				}
				Date time = match.getTime();
				Banner banner = new Banner(match.getId(), time, home, visit, queryNumber+queryNumberByMatchId, create, join,create2,join2);

				banner.setRownum(i);
				i++;
				banner.setTimeDesc(sf.format(time));
				data.add(banner);
			}
			return data;
		}

	}
	@Override
	public List<MatchData> queryMatchDone() {//用来后台页面展示的，后台管理
		// TODO Auto-generated method stub
		List<Match> queryMatchDone = matchDao.queryMatchDone();
		List<MatchData> list = new ArrayList<MatchData>();
		if(queryMatchDone!=null&&queryMatchDone.size()!=0){
			for (Match match : queryMatchDone) {
				Integer homeid = match.getHomeid();
				Team home = teamDao.queryById(homeid);
				home.setGrade(match.getHome_grade());
				Integer visitid = match.getVisitid();
				Team visitTeam = teamDao.queryById(visitid);
				visitTeam.setGrade(match.getVisit_grade());
				MatchData matchData = new MatchData(home, visitTeam, sfDateFormat.format(match.getTime()));
				list.add(matchData);
			}
			return list;
		}
		return null;
	}

}
