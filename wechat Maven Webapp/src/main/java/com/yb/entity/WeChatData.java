package com.yb.entity;
/**
 * 利用code从微信接口获取openid
 * @author lenovo
 *
 */
public class WeChatData {
	private String openid;
	private String session_key;
	private String unionid;
	public WeChatData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WeChatData(String openid, String session_key, String unionid) {
		super();
		this.openid = openid;
		this.session_key = session_key;
		this.unionid = unionid;
	}
	@Override
	public String toString() {
		return "WeChatData [openid=" + openid + ", session_key=" + session_key
				+ ", unionid=" + unionid + "]";
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
}
