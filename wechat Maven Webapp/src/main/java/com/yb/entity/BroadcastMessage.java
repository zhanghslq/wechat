package com.yb.entity;

/**
 * 单条的直播消息
 */
public class BroadcastMessage {
    private Integer minutes;
    private String text;
    private Integer type;
    private String logo;

    @Override
    public String toString() {
        return "BroadcastMessage{" +
                "minutes=" + minutes +
                ", text='" + text + '\'' +
                ", type=" + type +
                ", logo='" + logo + '\'' +
                '}';
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public BroadcastMessage(Integer minutes, String text, Integer type, String logo) {

        this.minutes = minutes;
        this.text = text;
        this.type = type;
        this.logo = logo;
    }

    public BroadcastMessage() {

    }
}
