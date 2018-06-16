package com.yb.entity;

/**
 * 用来赛事提醒
 */
public class Remind {
    private Integer id;
    private String openId;
    private String form_id;
    private Integer matchId;
    private Integer isSended;

    @Override
    public String toString() {
        return "Remind{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", form_id='" + form_id + '\'' +
                ", matchId=" + matchId +
                ", isSended=" + isSended +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getIsSended() {
        return isSended;
    }

    public void setIsSended(Integer isSended) {
        this.isSended = isSended;
    }

    public Remind(Integer id, String openId, String form_id, Integer matchId, Integer isSended) {

        this.id = id;
        this.openId = openId;
        this.form_id = form_id;
        this.matchId = matchId;
        this.isSended = isSended;
    }

    public Remind() {

    }
}
