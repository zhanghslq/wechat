package com.yb.quartz;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yb.service.AutoService;

@Component
public class MachesQuartz {
	@Resource
	private AutoService autoService;
	@Scheduled(cron="1 0 0 * * ?")//每天晚上第一秒点
	public void  autoGrade() throws ClientProtocolException, IOException {
		try {
			autoService.autoData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("定时抽取比赛数据任务异常");
			e.printStackTrace();
		}
	}
	@Scheduled(cron="0 */3 * * * ?")//每3分钟一次，取当天的数据
	public void  autoResult() throws ClientProtocolException, IOException {
		try {
			autoService.autoResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("定时结算任务异常");
			e.printStackTrace();
		}
	}
	@Scheduled(cron="0 */2 * * * ?")//每分钟一次，取超过时间未开局的契约
	public void  autoCheck(){
		try {
			autoService.autoCheck();
		} catch (Exception e) {
			System.out.println("定时开局和删除不符合条件的任务异常");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
