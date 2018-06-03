package com.yb.entity;
/**
 * 用来存放直播的事件
 * @author lenovo
 *
 */
public class Incident {
	/*{"type":1,"position":1,"time":31,"player_name":""},*/
	private Integer type;// 类型，详见状态码->足球技术统计
	private Integer position;//事件发生方,0-中立 1,主队 2,客队
	private Integer time;//时间(分钟)
	private  String player_name;// "B.費南迪斯 (助攻:G.艾賓)"//球员名称,可能为空
	public Incident() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Incident(Integer type, Integer position, Integer time,
			String player_name) {
		super();
		this.type = type;
		this.position = position;
		this.time = time;
		this.player_name = player_name;
	}
	@Override
	public String toString() {
		return "Incident [type=" + type + ", position=" + position + ", time="
				+ time + ", player_name=" + player_name + "]";
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	
}
