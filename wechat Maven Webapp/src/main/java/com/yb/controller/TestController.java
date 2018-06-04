package com.yb.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb.test.TestImage;

@Controller
@RequestMapping("/test")
@Scope("prototype")
public class TestController {
	
	@RequestMapping("/test")
	@ResponseBody
	public void test(HttpServletRequest request){
		 try {
			URL url = new URL("http://img.hexun.com/2011-06-21/130726386.jpg");  
			 //打开链接  
			 HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
			 //设置请求方式为"GET"  
			 conn.setRequestMethod("GET");  
			 //超时响应时间为5秒  
			 conn.setConnectTimeout(5 * 1000);  
			 //通过输入流获取图片数据  
			 InputStream inStream = conn.getInputStream();  
			 //得到图片的二进制数据，以二进制封装得到数据，具有通用性  
			 byte[] data = TestImage.readInputStream(inStream);  
			 //new一个文件对象用来保存图片，默认保存当前工程根目录  
			
			 File imageFile = new File("images/BeautyGirl.jpg");  
			 //创建输出流  
			 System.out.println("test");
			 FileOutputStream outStream = new FileOutputStream(imageFile);  
			 //写入数据  
			 outStream.write(data);  
			 //关闭输出流  
			 outStream.close();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("异常");
		}  
	}
}
