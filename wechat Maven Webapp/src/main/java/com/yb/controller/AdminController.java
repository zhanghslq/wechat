package com.yb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.entity.Admin;

@Controller
@Scope("prototype")
@RequestMapping("/admin")
public class AdminController {
	//后台管理登陆
	@RequestMapping("/login")
	@ResponseBody
	public String login(String name,String password,HttpServletRequest request){
			 	try {

						Subject subject = SecurityUtils.getSubject();
						subject.login(new UsernamePasswordToken(name,password));
						return "success";
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "password";
				}
	        
	}

}
