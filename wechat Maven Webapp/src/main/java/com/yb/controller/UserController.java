package com.yb.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yb.entity.User;
import com.yb.service.UserService;
import com.yb.util.OpenUtils;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	//微信授权登录
	@RequestMapping("/regist")
	@ResponseBody
	public Object regist(String nickname,String code,MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		 String openId = OpenUtils.getOpenId(code);
		 if(!file.isEmpty()) {
	            //上传文件路径
	            String path = request.getServletContext().getRealPath("/images/");
	            //上传文件名
	            String filename = UUID.randomUUID().toString()+".jpg";
	            File filepath = new File(path,filename);
	            //判断路径是否存在，如果不存在就创建一个
	            if (!filepath.getParentFile().exists()) { 
	                filepath.getParentFile().mkdirs();
	            }
	            //将上传文件保存到一个目标文件当中
	            file.transferTo(new File(path + File.separator + filename));
	            String imageUrl="http://lcoahost:8989/wechat/images/"+filename;
	            User user = userService.getUser(openId);
	            if(user==null){
	            	User user2 = new User(openId,imageUrl,nickname,8000,0,new Date());
	            	userService.insertUser(user2);
	            }else {
	            	user.setCurrency(null);
					return user;
				}
	            return "success";
		 }
		 return null;
	}
	//直接登录
	@RequestMapping("/login")
	@ResponseBody
	public Object login(String code) throws IllegalStateException, IOException{
		try {
			String openId = OpenUtils.getOpenId(code);
			User user = userService.getUser(openId);//需要判断是不是当天第一次登陆，第一次登陆送100金币
			Date lasttime = user.getLasttime();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String format = simpleDateFormat.format(lasttime);
			if(!simpleDateFormat.format(new Date()).equals(format)){//当天第一次登陆
				
			}
			user.setCurrency(null);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	@RequestMapping("/getMessage")
	@ResponseBody
	public Object getMessage(String code) throws IllegalStateException, IOException{
		try {
			String openId = OpenUtils.getOpenId(code);
			User user = userService.getUser(openId);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
