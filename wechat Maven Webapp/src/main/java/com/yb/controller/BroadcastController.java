package com.yb.controller;

import com.yb.entity.ResultPack;
import com.yb.service.BroadcastService;
import org.springframework.cache.annotation.Cacheable;
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
    //备用直播
    @ResponseBody
    @RequestMapping("/queryMessage")
    @Cacheable(value = "broadcast")
    public ResultPack getMessage(){
        try {
            Object o = broadcastService.autoBroadcast();
            return new ResultPack(1,o);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultPack(0,e.getMessage());
        }
    }
    @ResponseBody
    @RequestMapping("/queryTestMessage")
    @Cacheable(value = "broadcast")
    public ResultPack getTestMessage(){
        try {
            Object o = broadcastService.testBroadcast();
            return new ResultPack(1,o);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultPack(0,e.getMessage());
        }
    }
}
