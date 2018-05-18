package com.yb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.entity.DataPack;
import com.yb.entity.Evaluation;
import com.yb.service.EvaluationService;
import com.yb.util.OpenUtils;

@Controller
@RequestMapping("/evaluation")
@Scope("prototype")
public class EvaluationController {
	
	@Resource
	private EvaluationService evaluationService;
	
	@RequestMapping("/queryEvaluation")
	@ResponseBody
	public Object queryEvaluation(String code){
		try {
			String openId = OpenUtils.getOpenId(code);
			Evaluation queryById = evaluationService.queryById(openId);
			if(queryById!=null){
				List<DataPack> list = new ArrayList<DataPack>();
				list.add(new DataPack("整蛊专家",queryById.getTricky_brains(), "你看那个人好像一条柯基"));
				list.add(new DataPack("美食主播", queryById.getFood_anchor(), "别动筷子，别张嘴，我先拍个照。"));
				list.add(new DataPack("脑洞达人", queryById.getImagination_talent(), "我的脑洞是星辰大海!"));
				list.add(new DataPack("铁公鸡", queryById.getIron_cock(), "说起来你可能不相信，我差点被TA包养！"));
				list.add(new DataPack("富甲一方", queryById.getWealthy(), "我打算先给自己定一个亿的小目标"));
				return list;
			}else {
				return "error";
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
		
	}
}
