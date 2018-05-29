package com.yb.quartz;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 自动结算赌局
 * @author lenovo
 *
 */
@Component
public class ResultQuartz {
	//@Scheduled(cron="0 * * * * ?")//每天晚上1点,需要直接根据数据对比赛结果进行修改
	public void  autoResult() throws ClientProtocolException, IOException {
		
	}
}
