package com.yb.entity;

/**
 * 用来赛事提醒
 */
public class Remind {
    private Integer id;
    private String uid;
    private String form_id;
    private Integer matchId;
    private Integer isSended;

    @Override
    public String toString() {
        return "Remind{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public Remind(Integer id, String uid, String form_id, Integer matchId, Integer isSended) {

        this.id = id;
        this.uid = uid;
        this.form_id = form_id;
        this.matchId = matchId;
        this.isSended = isSended;
    }

    public Remind() {

    }

    public Remind(String uid, String form_id, Integer matchId, Integer isSended) {

        this.uid = uid;
        this.form_id = form_id;
        this.matchId = matchId;
        this.isSended = isSended;
    }
}
