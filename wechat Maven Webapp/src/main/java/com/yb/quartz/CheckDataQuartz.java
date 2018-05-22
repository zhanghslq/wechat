package com.yb.quartz;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckDataQuartz {
	//检查契约数据是否符合开局的条件，如果创建超过30分钟，人数不大于2
	@Scheduled(cron="0 * * * * ?")//每天晚上1点
	public void  autoCheck() throws ClientProtocolException, IOException {
		
	}
	public static void main(String[] args) {
	}
}
