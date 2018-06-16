package com.yb.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.yb.service.AutoService;
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
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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

	@Resource
	private AutoService autoService;

	private SimpleDateFormat sfDateFormat=new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sf=new SimpleDateFormat("MM月dd日   HH:mm");

	@Override
	public List<Match> queryMatchesTwoHours() {
		List<Match> matches = matchDao.queryMatchesTwoHours();

		return matches;
	}

	@Override
	public List<Match> queryStartedMatch() {
		List<Match> matches = matchDao.queryStartedMatch();
		return matches;
	}
	@Override
	public void handResult(Match match) {
		autoService.handResult(match);
	}

	@Override
	public void update(Match match) {//应该暂时用不到
		matchDao.updateMatch(match.getId(),match.getStatus(),match.getHome_grade(),match.getVisit_grade());
	}
	@Override
	public Match queryById(Integer id) {
		Match match = matchDao.queryById(id);

		return match;
	}

	@Override
	@Transactional
	public void updateMatch(Integer id,Integer status,Integer homeGrade,Integer visitGrade) {
		//更改比赛结果和状态，但是需要把原来计算的回退，然后重新结算
		//数据库查出来的原来的比赛信息
		Match match = matchDao.queryById(id);
		autoService.autoRevertResult(match);//回退比赛
		Match match1 = new Match();
		match1.setId(id);
		match1.setStatus(status);
		match1.setHome_grade(homeGrade);
		match1.setVisit_grade(visitGrade);
		autoService.handResult(match1);
		//需要修改的比赛信息
		matchDao.updateMatch(id,status,homeGrade,visitGrade);
	}
	@Override
	public List<Banner> queryBanner(String openId) {//查询当前赛事
		// TODO Auto-generated method stub
		//if(new Date().getTime()>1528905600000l){//世界杯开始,取当天的数据
			List<Match> queryMatches = matchDao.queryMatchesToday(openId);//获取到的赛事，然后判断，是否是发起人，是否参加契约
			if(queryMatches==null||queryMatches.size()==0){//当天的没数据了，开始取明天的数据
				queryMatches = matchDao.queryTommorrow();
			}
			List<Banner> data = new ArrayList<Banner>();//存放包装好的返回信息
			int rownum=0;
			for (Match match : queryMatches) {
				Team home = teamDao.queryById(match.getHomeid());
				Team visit = teamDao.queryById(match.getVisitid());
				Integer id = match.getId();
				//这是普通契约
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
				Random random = new Random();
				int i = random.nextInt(9999) + 1000;
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
				Banner banner = new Banner(match.getId(), time, home, visit, i, create, join,create2,join2);
				//Integer queryRownum = matchDao.queryRownum(match.getTime(),match.getId());
				rownum++;
				banner.setRownum(rownum);
				if(new Date().after(time)){//比赛已经开始
					banner.setStatus(0);//0代表不能参加
				}else {//比赛未开始
					banner.setStatus(1);
				}
				banner.setTimeDesc(sf.format(time));
				data.add(banner);
			}

			return data;
		/*}else{//世界杯未开始
			List<Match> queryMatches = matchDao.queryMatches(openId);//获取到的赛事，然后判断，是否是发起人，是否参加契约
			List<Banner> data = new ArrayList<Banner>();//存放包装好的返回信息
			int i=1;
			for (Match match : queryMatches) {
				Team home = teamDao.queryById(match.getHomeid());
				Team visit = teamDao.queryById(match.getVisitid());
				Integer id = match.getId();
				//这是普通契约
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
				Random random=new Random();
				int i1 = random.nextInt(9999) + 1000;
				Date time = match.getTime();
				Banner banner = new Banner(match.getId(), time, home, visit, i1, create, join,create2,join2);

				banner.setRownum(i);
				banner.setStatus(1);//世界杯未开始的时候，都是1
				i++;
				banner.setTimeDesc(sf.format(time));
				data.add(banner);
			}
			return data;
		}*/

	}
	@Override
	public List<Match> queryMatchDone() {//用来后台页面展示的，后台管理
		// TODO Auto-generated method stub
		List<Match> queryMatchDone = matchDao.queryMatchDone();
		/*List<MatchData> list = new ArrayList<MatchData>();
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
		}*/
		return queryMatchDone;
	}

}
