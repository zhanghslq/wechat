package com.yb.service;

import com.yb.entity.Team;

import java.util.List;

/**
 * 为人工后台管理
 */
public interface TeamService {
    void update(Team team);
    List<Team> queryAll();
    Team queryById(Integer id);
}
