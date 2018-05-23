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
	//检查契约数据是否符合开局的条件，如果创建超过30分钟，人数不大于2
	@Scheduled(cron="* * * * * ?")//每天晚上1点
	public void  autoClear() throws ClientProtocolException, IOException {
		
	}
}
