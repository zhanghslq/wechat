package com.yb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.entity.ResultPack;
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
	@Cacheable(value ="stake")
	public ResultPack queryAll(){
		try {
			List<Stake> queryAll = stakeService.queryAll();
			return new ResultPack(1, queryAll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
}
