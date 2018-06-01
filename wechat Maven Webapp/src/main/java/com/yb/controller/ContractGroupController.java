package com.yb.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.entity.ContractCome;
import com.yb.entity.ContractGroupDetails;
import com.yb.entity.ContractGroupResult;
import com.yb.entity.ResultPack;
import com.yb.service.ContractGroupService;

@RequestMapping("/contractGroup")
@Scope("prototype")
@Controller
public class ContractGroupController {//群pk
	@Resource
	private ContractGroupService contractGroupService;
	//生成契约
	@ResponseBody
	@RequestMapping("/createContractGroup")
	public ResultPack createContractGroup(ContractCome contractCome){
		try {
			Integer createContractGroup = contractGroupService.createContractGroup(contractCome);
			return new ResultPack(1, createContractGroup);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
	//加入契约
	@ResponseBody
	@RequestMapping("/joinContractGroup")
	public ResultPack joinContractGroup(String openId,Integer cid,String myGuess){
		try {
			contractGroupService.joinContractGroup(openId, cid, myGuess);
			return new ResultPack(1, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
	//获取群pk详情
	@RequestMapping("/queryGroupDetails")
	@ResponseBody
	public ResultPack queryGroupDetails(Integer cid){
		try {
			ContractGroupDetails queryGroupDetails = contractGroupService.queryGroupDetails(cid);
			
			return new ResultPack(1, queryGroupDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
		
	}
	//群pk开局
	@ResponseBody
	@RequestMapping("/beginContractGroup")
	public ResultPack beginContractGroup(Integer cid){
		try {
			contractGroupService.beginContractGroup(cid);
			return new ResultPack(1, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
	//获取群pk结果
	@ResponseBody
	@RequestMapping("/queryContractGroupResult")
	public ResultPack queryContractGroupResult(Integer cid,String openId){
		try {
			ContractGroupResult queryContractGroupResult = contractGroupService.queryContractGroupResult(cid, openId);
			return new ResultPack(1, queryContractGroupResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
		
	}
}
