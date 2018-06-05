package com.yb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yb.dao.ContractDao;
import com.yb.dao.ContractGroupDao;
import com.yb.dao.EvaluationDao;
import com.yb.dao.EventDao;
import com.yb.dao.MatchDao;
import com.yb.dao.StageDao;
import com.yb.dao.TeamDao;
import com.yb.dao.UserDao;
import com.yb.entity.ContractCome;
import com.yb.entity.Events;
import com.yb.entity.Match;
import com.yb.entity.Stage;
import com.yb.entity.Team;
import com.yb.service.AutoService;
import com.yb.util.CountryUtil;
@Service
@Transactional
public class AutoServiceImpl implements AutoService{
	@Autowired
	private ContractGroupDao contractGroupDao;
	@Autowired
	private ContractDao contractDao;
	@Autowired
	private MatchDao matchDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private EvaluationDao evaluationDao;
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private EventDao eventDao;
	@Autowired
	private StageDao stageDao;
	@Override
	public void autoCheck() {
		// TODO Auto-generated method stub
		List<Integer> list = contractDao.queryList();//超过30分钟未开局的契约id
		if(list!=null&&list.size()!=0){//这是好友契约的遍历
			for (Integer cid : list) {
				Integer queryNumberByCid = contractDao.queryNumberByCid(cid);//参与契约的人数
				if(queryNumberByCid>1){
					contractDao.updateStatus(cid);//人数大于1开局
				}else {
					contractDao.deleteFromCrateByCid(cid);
					contractDao.deleteFromCuByCid(cid);
					contractDao.delete(cid);
				}
			}
		}
		List<Integer> queryList = contractGroupDao.queryList();//群pk的超过30分钟未开局的契约
		if(queryList!=null&&queryList.size()!=0){
			for (Integer cid : queryList) {
				Integer queryNumberByCid = contractGroupDao.queryNumberByCid(cid);//参与群pk的人数
				if(queryNumberByCid>1){//群pk超过1人，自动开局
					contractGroupDao.updateStatus(cid);
				}else {//不符合开局条件的删除
					contractGroupDao.deleteFromCrateByCid(cid);
					contractGroupDao.deleteFromCuByCid(cid);
					contractGroupDao.delete(cid);
				}
			}
		}
	}

	@Override
	public void autoResult() {
		// TODO Auto-generated method stub
		String asString = null;
		try {
			asString = Request.Get("http://open.leisu.com/api/sports/football/wc2018/fixtures?user=cqdr&secret=JyN1wifrX2T0orlp")
					.connectTimeout(2000)  
	                .socketTimeout(2000)
					.setHeader("content-type", "application/x-www-form-urlencoded")
					.execute().returnContent().asString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("请求数据出错");
		}
		if(asString!=null){
			JSONObject fromObject = JSONObject.fromObject(asString);
			String string3 = fromObject.get("matches").toString();//这是最后的比赛数组
			JSONArray jsonArray = JSONArray.fromObject(string3);
			List<Match> matches = new ArrayList<Match>();
			for (Object object : jsonArray) {
				JSONArray jsonArray2 = JSONArray.fromObject(object);
				int id = jsonArray2.getInt(0);//比赛id
				int stageid = jsonArray2.getInt(1);//阶段id
				int homeid = jsonArray2.getInt(2);//主队id
				int visitid = jsonArray2.getInt(3);//客id
				int round = jsonArray2.getInt(4);//比赛轮次
				int status = jsonArray2.getInt(5);//比赛状态
				long time = jsonArray2.getLong(6);//比赛时间
				
				Object object2 = jsonArray2.get(8);//这是主队比分
				JSONArray objhome = JSONArray.fromObject(object2);
				int home_grade = objhome.getInt(0);//主队比分
				int home_addgrade = objhome.getInt(5);//主队加时比分
				int homediangrade = objhome.getInt(6);//主队点球比分
				Object object3 = jsonArray2.get(9);//客队比分
				JSONArray objvisit = JSONArray.fromObject(object3);
				int visit_grade = objvisit.getInt(0);//ke队比分
				int visit_addgrade = objvisit.getInt(5);//ke队加时比分
				int visitdiangrade = objvisit.getInt(6);//ke队点球比分
				Match match = new Match(id, stageid, status, new Date(time*1000), homeid,
				home_grade+home_addgrade+homediangrade, visitid, visit_grade+visit_addgrade+visitdiangrade,round);
				matches.add(match);
			}
			//取出来的比赛集合，判断比赛状态是否完成，结束比赛的拉出来，然后判断数据库里面结束比赛没有，如果数据库里面是结束比赛的，就
			//不管，如果拉出来数据比赛完成，数据库里面没有比赛完成，就要更新比赛状态，然后结算赌注
			if(matches!=null&&matches.size()!=0){
				for (Match match : matches) {
					if(8==match.getStatus()){//证明比赛结束
						//根据id查询数据库中的比赛状态是不是已完成的
						Match queryById = matchDao.queryById(match.getId());
						if(queryById!=null){//等于null的时候证明数据库不存在这个比赛，正常不会出现
							if(queryById.getStatus()!=8){//现在数据库是不等于8的时候认为比赛没完成，可能有意外情况，比如其他的也可以代表完成
								//数据库不等于8证明未完成，实际完成了，需要更新比赛结果
								Integer home_grade = match.getHome_grade();//主队得分
								//需要取分数,更新比赛
								Integer visit_grade = match.getVisit_grade();//客队得分
								String myGuess0="";//猜输赢的结果
								String myGuess1=home_grade+":"+visit_grade;//猜比分的结果
								if(home_grade>visit_grade){
									myGuess0="赢";
								}else if (visit_grade>home_grade) {
									myGuess0="输";
								}else {
									myGuess0="平";
								}
								//开始查询这个参与赛事的契约,里面只有契约id和赌注id是正常的，其他未查询，结果为空
								List<ContractCome> queryByMatchId = contractDao.queryByMatchId(match.getId(), 0);//猜输赢的
								if(queryByMatchId!=null&&queryByMatchId.size()!=0){
									contractDao.updateResult(queryByMatchId, myGuess0, "yes");
									contractDao.updateResult(queryByMatchId, myGuess0, "no");
								}
								List<ContractCome> queryByMatchId1 = contractDao.queryByMatchId(match.getId(), 1);//猜比分的
								if(queryByMatchId1!=null&&queryByMatchId1.size()!=0){
									contractDao.updateResult(queryByMatchId1, myGuess1, "yes");
									contractDao.updateResult(queryByMatchId1, myGuess1, "no");//更改中间表的result，0代表猜测错误，1代表猜测正确
								}
								List<Integer> arrayList1 = new ArrayList<Integer>();//赌注为50大洋
								List<Integer> arrayList2 = new ArrayList<Integer>();//赌注为100大洋
								List<Integer> arrayList3 = new ArrayList<Integer>();//赌注为整人类型
								List<Integer> arrayList4 = new ArrayList<Integer>();//赌注为美食
								List<Integer> arrayList5 = new ArrayList<Integer>();//赌注为自定义
								queryByMatchId.addAll(queryByMatchId1);
								for (ContractCome contractCome : queryByMatchId) {
									Integer stakeId = contractCome.getStakeId();
									Integer id = contractCome.getId();//契约id
									if(1==stakeId){//赌注为50大洋
										arrayList1.add(id);
									}else if (2==stakeId) {//赌注为100大洋
										arrayList2.add(id);
									}else if(3==stakeId||4==stakeId||7==stakeId||8==stakeId){//整人，结算的时候需要记录结果，更新整人和输赢数据
										arrayList3.add(id);
									}else if (5==stakeId||9==stakeId) {//请吃炸鸡
										arrayList4.add(id);
									}else {//剩余为自定义的
										arrayList5.add(id);
									}
								}//遍历结束
								if(arrayList1!=null&&arrayList1.size()!=0){
									List<String> queryByResult = contractDao.queryByResult(arrayList1, 0);//50金币猜错的 
									if(queryByResult!=null&&queryByResult.size()!=0){//不为空的话
										userDao.addCurrency(queryByResult, 50, "no");
									}
									List<String> queryByResult1 = contractDao.queryByResult(arrayList1, 1);//50金币猜对的 
									if(queryByResult1!=null&&queryByResult1.size()!=0){//不为空的话
										userDao.addCurrency(queryByResult1, 50, "yes");
										evaluationDao.update(4, queryByResult1);
									}
								}
								if(arrayList2!=null&&arrayList2.size()!=0){
									List<String> queryByResult2 = contractDao.queryByResult(arrayList2, 1);//100金币猜对的 
									if(queryByResult2!=null&&queryByResult2.size()!=0){//不为空的话
										userDao.addCurrency(queryByResult2, 100, "yes");
										evaluationDao.update(4, queryByResult2);
									}
									List<String> queryByResult3 = contractDao.queryByResult(arrayList2, 0);//100金币猜错的 
									if(queryByResult3!=null&&queryByResult3.size()!=0){//不为空的话
										userDao.addCurrency(queryByResult3, 100, "no");
									}
								}
								if(arrayList3!=null&&arrayList3.size()!=0){
									
									List<String> queryByResult4 = contractDao.queryByResult(arrayList3, 1);//整蛊猜对的 
									if(queryByResult4!=null&&queryByResult4.size()!=0){//不为空的话
										userDao.updateWins(queryByResult4);
										evaluationDao.update(1, queryByResult4);
									}
									List<String> queryByResult5 = contractDao.queryByResult(arrayList3, 0);//整蛊猜错的 
									if(queryByResult5!=null&&queryByResult5.size()!=0){//不为空的话
										userDao.updateAll(queryByResult5);
									}
								}
								if(arrayList4!=null&&arrayList4.size()!=0){
									
									List<String> queryByResult6 = contractDao.queryByResult(arrayList4, 1);//美食猜对的 
									if(queryByResult6!=null&&queryByResult6.size()!=0){//不为空的话
										userDao.updateWins(queryByResult6);
										evaluationDao.update(2, queryByResult6);
									}
									List<String> queryByResult7 = contractDao.queryByResult(arrayList4, 0);//美食猜错的 
									if(queryByResult7!=null&&queryByResult7.size()!=0){//不为空的话
										userDao.updateAll(queryByResult7);
									}
								}
								if(arrayList5!=null&&arrayList5.size()!=0){
									List<String> queryByResult8 = contractDao.queryByResult(arrayList5, 1);//自定义猜对的 
									if(queryByResult8!=null&&queryByResult8.size()!=0){//不为空的话
										userDao.updateWins(queryByResult8);
										evaluationDao.update(3, queryByResult8);
									}
									List<String> queryByResult9 = contractDao.queryByResult(arrayList5, 0);//自定义猜错的 
									if(queryByResult9!=null&&queryByResult9.size()!=0){//不为空的话
										userDao.updateAll(queryByResult9);
									}
								}
								
								//需要结算群pk的，类似于好友赛的
								List<Integer> queryByMatchId2 = contractGroupDao.queryByMatchId(match.getId(), 0);//猜输赢的
								if(queryByMatchId2!=null&&queryByMatchId2.size()!=0){
									contractGroupDao.updateResult(queryByMatchId2, myGuess0, "yes");
									contractGroupDao.updateResult(queryByMatchId2, myGuess0, "no");
								}
								List<Integer> queryByMatchId3 = contractGroupDao.queryByMatchId(match.getId(), 1);//猜比分的
								if(queryByMatchId3!=null&&queryByMatchId3.size()!=0){
									contractGroupDao.updateResult(queryByMatchId3, myGuess1, "yes");
									contractGroupDao.updateResult(queryByMatchId3, myGuess1, "no");
								}
								queryByMatchId2.addAll(queryByMatchId3);//这是把猜输赢的和猜比分的加在一起
								if(queryByMatchId2!=null&&queryByMatchId2.size()!=0){
									List<ContractCome> queryByResult10 = contractGroupDao.queryByResult(queryByMatchId2, 0);//猜测错误
									if(queryByResult10!=null&&queryByResult10.size()!=0){
										for (ContractCome contractCome : queryByResult10) {
											userDao.addCurrencyGroup(contractCome, "no");
										}
									}
									List<String> openids = new ArrayList<String>();//猜测正确的openid
									List<ContractCome> queryByResult11 = contractGroupDao.queryByResult(queryByMatchId2, 1);//猜测正确
									if(queryByResult11!=null&&queryByResult11.size()!=0){
										for (ContractCome contractCome : queryByResult11) {
											userDao.addCurrencyGroup(contractCome, "yes");
											openids.add(contractCome.getOpenId());
										}
										evaluationDao.update(5, openids);
									}
								}
							}
						}
					}//if结束
					
				}
			}
		}
	}

	@Override
	public void autoData() {
		// TODO Auto-generated method stub
		String asString=null;
		try {
			asString = Request.Get("http://open.leisu.com/api/sports/football/wc2018/fixtures?user=cqdr&secret=JyN1wifrX2T0orlp")
					.connectTimeout(2000)  
	                .socketTimeout(2000)
					.setHeader("content-type", "application/x-www-form-urlencoded")
					.execute().returnContent().asString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("请求数据出错");
		}
				//System.out.println("反会结果-=================================="+asString);
				//String decodeUnicode = CharSetUtil.decodeUnicode(asString);//把unicode編碼的都變回來
		if(asString!=null){
			JSONObject fromObject = JSONObject.fromObject(asString);
			String string = fromObject.get("teams").toString();//整个team
			JSONArray json_Arr = JSONArray.fromObject(string);
			List<Team> teams = new ArrayList<Team>();
			for (Object obj : json_Arr) {
	            net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(obj);
	            Team bean = (Team) net.sf.json.JSONObject.toBean(jsonObject, Team.class);
	            String logo = bean.getLogo();
	            bean.setLogo("https://cdn.leisu.com/teamflag_s/"+logo);
	            String name = bean.getName_zh();
	            bean.setCountry_logo(CountryUtil.getLogo(name));
	            /*String country_logo = bean.getCountry_logo();
	            bean.setCountry_logo("https://cdn.leisu.com/teamflag_s/"+country_logo);*/
	            teams.add(bean);
			 }
			teamDao.insertTeam(teams);//插入球队信息
			String stagestring = fromObject.get("stages").toString();//整个Stage
			JSONArray json_Arr1 = JSONArray.fromObject(stagestring);
			List<Stage> stages = new ArrayList<Stage>();
			for (Object obj : json_Arr1) {
				net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(obj);
				int type = jsonObject.getInt("type");
				int mode = jsonObject.getInt("mode");
				int id = jsonObject.getInt("id");
				String name_zh = jsonObject.get("name_zh").toString();
				stages.add(new Stage(id, type, mode, name_zh));
			}
			stageDao.insert(stages);//插入球队信息
			
			String string2 = fromObject.get("event").toString();//整个Event对象
			net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(string2);
	        Events bean = (Events) JSONObject.toBean(jsonObject, Events.class);
	        String logo = bean.getLogo();
	        bean.setLogo("https://cdn.leisu.com/eventlogo/"+logo);
			eventDao.insertEventBean(bean);//插入赛事信息
			String string3 = fromObject.get("matches").toString();//这是最后的比赛数组
			JSONArray jsonArray = JSONArray.fromObject(string3);
			List<Match> matches = new ArrayList<Match>();
			for (Object object : jsonArray) {
				JSONArray jsonArray2 = JSONArray.fromObject(object);
				int id = jsonArray2.getInt(0);//比赛id
				int stageid = jsonArray2.getInt(1);//阶段id
				int homeid = jsonArray2.getInt(2);//主队id
				int visitid = jsonArray2.getInt(3);//主队id
				int round = jsonArray2.getInt(3);//比赛轮次
				int status = jsonArray2.getInt(5);//比赛轮次
				long time = jsonArray2.getLong(6);//比赛时间
				
				Object object2 = jsonArray2.get(8);//这是主队比分
				JSONArray objhome = JSONArray.fromObject(object2);
				int home_grade = objhome.getInt(0);//主队比分
				int home_addgrade = objhome.getInt(5);//主队加时比分
				int homediangrade = objhome.getInt(6);//主队点球比分
				Object object3 = jsonArray2.get(9);//客队比分
				JSONArray objvisit = JSONArray.fromObject(object3);
				int visit_grade = objvisit.getInt(0);//ke队比分
				int visit_addgrade = objvisit.getInt(5);//ke队加时比分
				int visitdiangrade = objvisit.getInt(6);//ke队点球比分
				Match match = new Match(id, stageid, status, new Date(time*1000), homeid,
				home_grade+home_addgrade+homediangrade, visitid, visit_grade+visit_addgrade+visitdiangrade,round);
				matches.add(match);
			}
			//需要把这些数据插入数据库
			matchDao.insertMatches(matches);
		}
	}

}
