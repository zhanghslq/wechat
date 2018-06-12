package com.yb.controller;

import java.util.List;

import javax.annotation.Resource;

import com.yb.entity.Match;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.entity.Banner;
import com.yb.entity.ResultPack;
import com.yb.service.MatchService;


@Controller
@RequestMapping("/match")
@Scope("prototype")
public class MatchController {
	@Resource
	private MatchService matchService;
	@ResponseBody
	@RequestMapping("/queryBanner")
	public ResultPack queryBanner(String openId){
		try {
			List<Banner> queryBanner = matchService.queryBanner(openId);
			return new ResultPack(1, queryBanner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
	@RequestMapping("/queryMatchDone")
	@ResponseBody
	public List<Match> queryMatchDone(){
		List<Match> matches = matchService.queryMatchDone();
		return matches;
	}
	@ResponseBody
	@RequestMapping("/updateMatch")
	public void updateMatch(Match match){
		try {
			matchService.updateMatch(match.getId(),match.getStatus(),match.getHome_grade(),match.getVisit_grade());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@ResponseBody
	@RequestMapping("/queryById")
	public Match queryById(Integer id){
		Match match = matchService.queryById(id);
		return match;
	}
}
