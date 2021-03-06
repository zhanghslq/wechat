//package com.yb.quartz;
//
//import java.io.IOException;
//
//import javax.annotation.Resource;
//
//import com.yb.entity.AccessToken;
//import com.yb.entity.Match;
//import com.yb.service.RemindService;
//import org.apache.http.client.ClientProtocolException;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.yb.service.AutoService;
//
//@Component
//public class MachesQuartz {
//	@Resource
//	private AutoService autoService;
//	@Resource
//	private RemindService remindService;
//
//	@Scheduled(cron="0 0 7 * * ?")//每天早上七点，相当于俄罗斯两点，不会有比赛数据
//	public void  autoGrade(){
//		try {
//			autoService.autoData();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("定时抽取比赛数据任务异常");
//			e.printStackTrace();
//		}
//	}
//	@Scheduled(cron="0 */4 * * * ?")//每3分钟一次，取当天的数据
//	public void  autoResult(){
//		try {
//			autoService.autoResult();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("定时结算任务异常");
//			e.printStackTrace();
//		}
//	}
//	@Scheduled(cron="0 */4 * * * ?")//每4分钟一次，取超过时间未开局的契约
//	public void  autoCheck(){
//		try {
//			autoService.autoCheck();
//		} catch (Exception e) {
//			System.out.println("定时开局和删除不符合条件的任务异常");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Scheduled(cron="0 */6 * * * ?")//每2分钟一次，取定时提醒的
//	public void  autoRemind(){
//		try {
//			remindService.remind();
//		} catch (Exception e) {
//			System.out.println("定时发送提醒");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Scheduled(cron="0 0/20 * * * ?")//每20分钟检查一次，定时获取token,也就是最迟是一小时五十分钟的时候会刷新token
//	public void  autoAcessToken(){
//		try {
//			autoService.autoAccessToken();
//		} catch (Exception e) {
//			System.out.println("定时更新token");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
