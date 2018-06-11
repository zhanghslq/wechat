package com.yb.entity;

import java.util.List;

/**
 * 用于返回给页面直播数据
 */
public class BroadcastData {
    private List<BroadcastMessage> data;
    private Team home;
    private Team visit;

    public BroadcastData() {

    }

    @Override
    public String toString() {
        return "BroadcastData{" +
                "data=" + data +
                ", home=" + home +
                ", visit=" + visit +
                '}';
    }

    public List<BroadcastMessage> getData() {
        return data;
    }

    public void setData(List<BroadcastMessage> data) {
        this.data = data;
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

    public BroadcastData(List<BroadcastMessage> data, Team home, Team visit) {

        this.data = data;
        this.home = home;
        this.visit = visit;
    }
}
