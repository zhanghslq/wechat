package com.yb.quartz;

import java.io.IOException;

import javax.annotation.Resource;

import com.yb.entity.AccessToken;
import com.yb.entity.Match;
import com.yb.service.RemindService;
import org.apache.http.client.ClientProtocolException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yb.service.AutoService;

@Component
public class MachesQuartz {
	@Resource
	private AutoService autoService;
	@Resource
	private RemindService remindService;
	@Scheduled(cron="0 0 7 * * ?")//每天早上七点，相当于俄罗斯两点，不会有比赛数据
	public void  autoGrade(){
		try {
			autoService.autoData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("定时抽取比赛数据任务异常");
			e.printStackTrace();
		}
	}
	@Scheduled(cron="0 */4 * * * ?")//每3分钟一次，取当天的数据
	public void  autoResult(){
		try {
			autoService.autoResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("定时结算任务异常");
			e.printStackTrace();
		}
	}
	@Scheduled(cron="0 */4 * * * ?")//每分钟一次，取超过时间未开局的契约
	public void  autoCheck(){
		try {
			autoService.autoCheck();
		} catch (Exception e) {
			System.out.println("定时开局和删除不符合条件的任务异常");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Scheduled(cron="0 */4 * * * ?")//每2分钟一次，取定时提醒的
	public void  autoRemind(){
		try {
			remindService.remind();
		} catch (Exception e) {
			System.out.println("定时发送提醒");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Scheduled(cron="0 0/30 * * * ?")//每30分钟检查一次，定时获取token
	public void  autoAcessToken(){
		try {
			autoService.autoAccessToken();
		} catch (Exception e) {
			System.out.println("定时更新token");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//暂时注释，正式上线必须去掉
	//@Scheduled(cron="0 10 22 * * ?")//每分钟一次，取超过时间未开局的契约
	public void  autoTest(){
		try {
			autoService.handResult(new Match());
		} catch (Exception e) {
			System.out.println("假的比赛结束");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
