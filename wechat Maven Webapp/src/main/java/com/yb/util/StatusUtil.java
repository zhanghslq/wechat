package com.yb.util;

import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
/**
 * 准备用做状态码获取的工具类
 * @author lenovo
 *
 */
public class StatusUtil {
	@Cacheable
	public static Map<Integer, String> queryMap(){
		
		return null;
	}
}
