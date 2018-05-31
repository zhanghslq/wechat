package com.yb.entity;

public class Evaluation {
	private Integer id;
	private String openid;
	private Integer tricky_brains;
	private Integer food_anchor;
	private Integer imagination_talent;
	private Integer iron_cock;
	private Integer  wealthy;
	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Evaluation(String openid, Integer tricky_brains,
			Integer food_anchor, Integer imagination_talent, Integer iron_cock,
			Integer wealthy) {
		super();
		this.openid = openid;
		this.tricky_brains = tricky_brains;
		this.food_anchor = food_anchor;
		this.imagination_talent = imagination_talent;
		this.iron_cock = iron_cock;
		this.wealthy = wealthy;
	}
	@Override
	public String toString() {
		return "Evaluation [openid=" + openid + ", tricky_brains="
				+ tricky_brains + ", food_anchor=" + food_anchor
				+ ", imagination_talent=" + imagination_talent + ", iron_cock="
				+ iron_cock + ", wealthy=" + wealthy + "]";
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getTricky_brains() {
		return tricky_brains;
	}
	public void setTricky_brains(Integer tricky_brains) {
		this.tricky_brains = tricky_brains;
	}
	public Integer getFood_anchor() {
		return food_anchor;
	}
	public void setFood_anchor(Integer food_anchor) {
		this.food_anchor = food_anchor;
	}
	public Integer getImagination_talent() {
		return imagination_talent;
	}
	public void setImagination_talent(Integer imagination_talent) {
		this.imagination_talent = imagination_talent;
	}
	public Integer getIron_cock() {
		return iron_cock;
	}
	public void setIron_cock(Integer iron_cock) {
		this.iron_cock = iron_cock;
	}
	public Integer getWealthy() {
		return wealthy;
	}
	public void setWealthy(Integer wealthy) {
		this.wealthy = wealthy;
	}
}
