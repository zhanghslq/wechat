package com.yb.quartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yb.dao.ContractDao;
import com.yb.dao.ContractGroupDao;
/**
 * 检测契约是否超时未开局，未开局的检测状态，符合条件的开局，不符合条件的删除
 * @author lenovo
 *
 */

@Component
public class CheckDataQuartz {
	@Autowired
	private ContractGroupDao contractGroupDao;
	@Autowired
	private ContractDao contractDao;
	//每分钟检测一次，
	@Scheduled(cron="0 * * * * ?")//每分钟一次，取超过时间未开局的契约
	public void  autoCheck(){
		List<Integer> list = contractDao.queryList();//超过30分钟未开局的契约id
		if(list!=null&&list.size()!=0){//这是好友契约的遍历
			for (Integer cid : list) {
				Integer queryNumberByCid = contractDao.queryNumberByCid(cid);//参与契约的人数
				if(queryNumberByCid>1){
					contractDao.updateStatus(cid);//人数大于1开局
				}else {
					contractDao.deleteFromCrateByCid(cid);
					contractDao.deleteFromCuByCid(cid);
				}
			}
		}
		List<Integer> queryList = contractGroupDao.queryList();//群pk的超过30分钟未开局的契约
		if(queryList!=null&&queryList.size()!=0){
			for (Integer cid : queryList) {
				Integer queryNumberByCid = contractGroupDao.queryNumberByCid(cid);//参与群pk的人数
				if(queryNumberByCid>1){//群pk超过1人，自动开局
					contractGroupDao.updateStatus(cid);
				}else {//不符合开局条件的删除
					contractGroupDao.deleteFromCrateByCid(cid);
					contractGroupDao.deleteFromCuByCid(cid);
				}
			}
		}
	}
}
