package com.yb.entity;

import java.util.Date;
/**
 * 赛事banner
 * @author lenovo
 * 之后加上了时间格式化的，还有第几场的信息，第几场的待查询
 */
public class Banner {
	private Integer id;//比赛id
	private Date time;
	private Team home;
	private Team visit;
	private Integer number;//参与本场竞猜人数
	private Boolean create;//是否创建
	private Boolean join;//是否参与
	private Boolean createGroup;
	private Boolean joinGroup;
	private String timeDesc;
	private Integer rownum;
	private Integer contractStatus;
	private Integer status;

	@Override
	public String toString() {
		return "Banner{" +
				"id=" + id +
				", time=" + time +
				", home=" + home +
				", visit=" + visit +
				", number=" + number +
				", create=" + create +
				", join=" + join +
				", createGroup=" + createGroup +
				", joinGroup=" + joinGroup +
				", timeDesc='" + timeDesc + '\'' +
				", rownum=" + rownum +
				", contractStatus=" + contractStatus +
				", status=" + status +
				'}';
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Banner(Integer id, Date time, Team home, Team visit, Integer number, Boolean create, Boolean join, Boolean createGroup, Boolean joinGroup, String timeDesc, Integer rownum, Integer contractStatus, Integer status) {

		this.id = id;
		this.time = time;
		this.home = home;
		this.visit = visit;
		this.number = number;
		this.create = create;
		this.join = join;
		this.createGroup = createGroup;
		this.joinGroup = joinGroup;
		this.timeDesc = timeDesc;
		this.rownum = rownum;
		this.contractStatus = contractStatus;
		this.status = status;
	}

	public Integer getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(Integer contractStatus) {
		this.contractStatus = contractStatus;
	}
	public Banner(Integer id, Date time, Team home, Team visit, Integer number,
			Boolean create, Boolean join, Boolean createGroup,
			Boolean joinGroup, String timeDesc, Integer rownum,
			Integer contractStatus) {
		super();
		this.id = id;
		this.time = time;
		this.home = home;
		this.visit = visit;
		this.number = number;
		this.create = create;
		this.join = join;
		this.createGroup = createGroup;
		this.joinGroup = joinGroup;
		this.timeDesc = timeDesc;
		this.rownum = rownum;
		this.contractStatus = contractStatus;
	}
	public Integer getRownum() {
		return rownum;
	}
	public void setRownum(Integer rownum) {
		this.rownum = rownum;
	}
	public Banner(Integer id, Date time, Team home, Team visit, Integer number,
			Boolean create, Boolean join, Boolean createGroup,
			Boolean joinGroup, String timeDesc, Integer rownum) {
		super();
		this.id = id;
		this.time = time;
		this.home = home;
		this.visit = visit;
		this.number = number;
		this.create = create;
		this.join = join;
		this.createGroup = createGroup;
		this.joinGroup = joinGroup;
		this.timeDesc = timeDesc;
		this.rownum = rownum;
	}
	public String getTimeDesc() {
		return timeDesc;
	}
	public void setTimeDesc(String timeDesc) {
		this.timeDesc = timeDesc;
	}
	public Banner(Integer id, Date time, Team home, Team visit, Integer number,
			Boolean create, Boolean join, Boolean createGroup,
			Boolean joinGroup, String timeDesc) {
		super();
		this.id = id;
		this.time = time;
		this.home = home;
		this.visit = visit;
		this.number = number;
		this.create = create;
		this.join = join;
		this.createGroup = createGroup;
		this.joinGroup = joinGroup;
		this.timeDesc = timeDesc;
	}
	public Banner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Banner(Integer id, Date time, Team home, Team visit, Integer number,
			Boolean create, Boolean join, Boolean createGroup, Boolean joinGroup) {
		super();
		this.id = id;
		this.time = time;
		this.home = home;
		this.visit = visit;
		this.number = number;
		this.create = create;
		this.join = join;
		this.createGroup = createGroup;
		this.joinGroup = joinGroup;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Team getHome() {
		return home;
	}
	public void setHome(Team home) {
		this.home = home;
	}
	public Team getVisit() {
		return visit;
	}
	public void setVisit(Team visit) {
		this.visit = visit;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Boolean getCreate() {
		return create;
	}
	public void setCreate(Boolean create) {
		this.create = create;
	}
	public Boolean getJoin() {
		return join;
	}
	public void setJoin(Boolean join) {
		this.join = join;
	}
	public Boolean getCreateGroup() {
		return createGroup;
	}
	public void setCreateGroup(Boolean createGroup) {
		this.createGroup = createGroup;
	}
	public Boolean getJoinGroup() {
		return joinGroup;
	}
	public void setJoinGroup(Boolean joinGroup) {
		this.joinGroup = joinGroup;
	}
	
	
	
}
