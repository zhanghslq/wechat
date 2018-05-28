package com.yb.entity;

import java.util.Date;
/*为了查询用户进程
 * 
 */
public class Proceed {
	private String cid;
	private Date time;
	private Integer result;
	public Proceed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proceed(String cid, Date time, Integer result) {
		super();
		this.cid = cid;
		this.time = time;
		this.result = result;
	}
	@Override
	public String toString() {
		return "Proceed [cid=" + cid + ", time=" + time + ", result=" + result
				+ "]";
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	
}
