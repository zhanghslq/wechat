package com.yb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.entity.Stake;
import com.yb.service.StakeService;

@Controller
@RequestMapping("/stake")
@Scope("prototype")
public class StakeController {

	@Resource
	private StakeService stakeService;
	
	@RequestMapping("/queryAll")
	@ResponseBody
	public List<Stake> queryAll(){
		List<Stake> queryAll = stakeService.queryAll();
		return queryAll;
	}
}
