package com.yb.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtil {
	public static void main(String[] args) {
		getTomorrow();
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
	public static String getToday() {
		Date date=new Date();//取时间
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(date);
		return dateString;
	}
	
}
