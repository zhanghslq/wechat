package com.yb.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.dao.ContractDao;
import com.yb.dao.ContractGroupDao;
import com.yb.dao.MatchDao;
import com.yb.dao.TeamDao;
import com.yb.entity.Banner;
import com.yb.entity.Match;
import com.yb.entity.Team;
import com.yb.service.MatchService;
import com.yb.util.OpenUtils;

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
	@Override
	public List<Banner> queryBanner(String code) {//查询当前赛事
		// TODO Auto-generated method stub
		String openId;
		try {
			openId = OpenUtils.getOpenId(code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("获取openid出错");
		}
		List<Match> queryMatches = matchDao.queryMatches(openId);//获取到的赛事，然后判断，是否是发起人，是否参加契约
		List<Banner> data = new ArrayList<Banner>();//存放包装好的返回信息
		for (Match match : queryMatches) {
			Team home = teamDao.queryById(match.getHomeid());
			Team visit = teamDao.queryById(match.getVisitid());
			Integer id = match.getId();
			//这是普通契约
			Integer queryNumber = contractDao.queryNumber(id);
			String queryCreateByUid = contractDao.queryCreateByUid(openId,id);
			String queryJoinByUid = contractDao.queryJoinByUid(openId, id);
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
			String queryCreateByUid2 = contractGroupDao.queryCreateByUid(id,openId);
			String queryJoinByUid2 = contractGroupDao.queryJoinByUid(id, openId);
			Boolean create2=false;
			Boolean join2=false;
			if(queryCreateByUid2!=null){
				create2=true;
			}
			if(queryJoinByUid2!=null){
				join2=true;
			}
			Banner banner = new Banner(match.getId(), match.getTime(), home, visit, queryNumber+queryNumberByMatchId, create, join,create2,join2);
			data.add(banner);
		}
		return data;
	}

}
