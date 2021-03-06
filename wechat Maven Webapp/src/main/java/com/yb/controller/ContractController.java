package com.yb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.entity.ContractCome;
import com.yb.entity.ContractDetails;
import com.yb.entity.ContractDone;
import com.yb.entity.JoinContract;
import com.yb.entity.ResultPack;
import com.yb.entity.TheGuess;
import com.yb.service.ContractService;

@Controller
@RequestMapping("/contract")
@Scope("prototype")
public class ContractController {//0代表失败，1代表成功
	@Resource
	private ContractService contractService;
	
	//生成契约
	@RequestMapping(value="/insertContract",method = RequestMethod.POST)
	@ResponseBody
	public ResultPack insertContract(@RequestBody ContractCome contractCome){//生成契约，返回字符串，契约id
		try {
			Integer contract = contractService.insertContract(contractCome);
			return new ResultPack(1, contract);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
	//获取契约详情
	@ResponseBody
	@RequestMapping("/queryContract")
	public ResultPack queryContract(Integer cid){
		try {
			ContractDetails queryContract = contractService.queryContract(cid);
			return new ResultPack(1,  queryContract);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
		
	}
	//参与契约
	//重新预测,两个是一样的
	@ResponseBody
	@RequestMapping(value="/joinContract",method=RequestMethod.POST)
	public ResultPack joinContract(@RequestBody JoinContract joinData){
		try {
			String joinContract = contractService.joinContract(joinData.getOpenId(), joinData.getCid(), joinData.getMyGuess());
			return new ResultPack(1, joinContract);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
	//开局
	@RequestMapping("/beginStake")
	@ResponseBody
	public ResultPack beginStake(Integer cid){
		try {
			String beginStake = contractService.beginStake(cid);
			return new ResultPack(1, beginStake);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
	//获取完成状态的契约
	@ResponseBody
	@RequestMapping("/queryContractDone")
	public ResultPack queryContractDone(Integer cid,String openId){
		try {
			ContractDone queryContractDone = contractService.queryContractDone(cid, openId);
			return new ResultPack(1, queryContractDone);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultPack(0,e.getMessage());
		}
	}
	/**
	 * 本场竞猜
	 */
	@ResponseBody
	@RequestMapping("/theGuess")
	public ResultPack queryTheGuess(String openId,Integer matchId){
		try {
			List<TheGuess> queryByMatchIdAndUid = contractService.queryByMatchIdAndUid(openId, matchId);
			return new ResultPack(1, queryByMatchIdAndUid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultPack(0, e.getMessage());
		}
	}
	//查询契约是否可以加入
	@ResponseBody
	@RequestMapping("/queryJoinContract")
	public  Object queryJoinContract(String openId,Integer cid){
		try {
			ResultPack joinContract = contractService.isJoinContract(openId, cid);
			return  joinContract;
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultPack(0,"查询出错");
		}
	}
}
