package com.yb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtil {
	public static void main(String[] args) {
		Date date = new Date(1530288000000L);
		System.out.println(date);
	}
	public static String getTomorrow() {
		 Date date=new Date();//取时间
		 Calendar calendar = new GregorianCalendar();
		 calendar.setTime(date);
		 calendar.add(calendar.DAY_OF_MONTH,1);//把日期往后增加一天.整数往后推,负数往前移动
		 Date time = calendar.getTime(); //这个时间就是日期往后推一天的结果 
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		 String dateString = formatter.format(time);
		 return dateString;
	}
	/*public static long getTomorrowDate(Date date) {
			String time = "2018/06/30 00:00:00";  
			Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(time);  
			long unixTimestamp = /1000;  
			System.out.println(unixTimestamp);  
			return unixTimestamp;  
	}  */
	public static String getToday() {
		Date date=new Date();//取时间
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(date);
		return dateString;
	}
	
}
