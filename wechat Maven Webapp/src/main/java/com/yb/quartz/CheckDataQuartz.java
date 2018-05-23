package com.yb.quartz;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckDataQuartz {
	//每分钟检测一次，看比赛是否有结果了，有结果的话，就进行结算
	@Scheduled(cron="0 * * * * ?")//每分钟一次
	public void  autoCheck() throws ClientProtocolException, IOException {
		
	}
}
