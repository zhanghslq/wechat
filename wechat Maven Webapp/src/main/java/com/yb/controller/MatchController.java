package com.yb.controller;

import java.util.List;

import javax.annotation.Resource;

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
	public ResultPack queryBanner(String code){
		try {
			List<Banner> queryBanner = matchService.queryBanner(code);
			return new ResultPack(1, queryBanner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
}
