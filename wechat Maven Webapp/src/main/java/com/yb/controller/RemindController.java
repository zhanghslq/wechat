package com.yb.controller;

import com.yb.entity.Remind;
import com.yb.entity.ResultPack;
import com.yb.service.RemindService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Scope("prototype")
@RequestMapping("/remind")
public class RemindController {
    @Resource
    private RemindService remindService;

    @RequestMapping(value="/insertRemind",method = RequestMethod.POST)
    @ResponseBody
    public ResultPack insertRemind(@RequestBody Remind remind){//需要uid,matchId,form_id
        try {
            remindService.insert(remind);
            return new ResultPack(1,"设置提醒成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultPack(0,e.getMessage());
        }
    }
}
