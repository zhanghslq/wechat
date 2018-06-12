package com.yb.service.impl;

import com.yb.dao.TeamDao;
import com.yb.entity.Team;
import com.yb.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {


    @Autowired
    private TeamDao teamDao;

    @Override
    public void update(Team team) {
        teamDao.update(team);
    }

    @Override
    public List<Team> queryAll() {
        List<Team> teams = teamDao.queryAll();
        return teams;
    }
    @Override
    public Team queryById(Integer id) {
        Team team = teamDao.queryById(id);
        return team;
    }
}
