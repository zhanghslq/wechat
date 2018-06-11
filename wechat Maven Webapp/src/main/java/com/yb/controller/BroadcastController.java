package com.yb.controller;

import com.yb.entity.ResultPack;
import com.yb.service.BroadcastService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/broadcast")
@Scope("prototype")
public class BroadcastController {
    @Resource
    private BroadcastService broadcastService;

    @ResponseBody
    @RequestMapping("/queryMessage")
    public ResultPack getMessage(){
        try {
            Object o = broadcastService.autoBroadcast();
            return new ResultPack(1,0);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultPack(0,e.getMessage());
        }
    }
}
