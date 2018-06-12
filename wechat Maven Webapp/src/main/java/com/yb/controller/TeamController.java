package com.yb.controller;

import com.yb.dao.TeamDao;
import com.yb.entity.Team;
import com.yb.service.TeamService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/team")
@Scope("prototype")
public class TeamController {
    @Resource
    private TeamService teamService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Team> queryAll(){
        List<Team> teams = teamService.queryAll();
        return teams;
    }
    @RequestMapping("/queryById")
    @ResponseBody
    public Team queryById(Integer id){
        Team team = teamService.queryById(id);
        return team;
    }
    @RequestMapping("/update")
    @ResponseBody
    public void update(Team team){
        try {
            teamService.update(team);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
