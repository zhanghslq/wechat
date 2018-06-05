package com.yb.util;

import java.util.HashMap;
import java.util.Map;

public class CountryUtil {
	private static Map<String, String> map=new HashMap<String,String>();
	public static void init(){
		map.put("法国", "images/country/1_0024_法国.png");
		map.put("塞尔维亚", "images/country/1_0007_塞尔维亚.png");
		map.put("比利时", "images/country/1_0026_比利时.png");
		map.put("哥伦比亚", "images/country/1_0019_哥伦比亚.png");
		map.put("巴西", "images/country/1_0029_巴西.png");
		map.put("沙特阿拉伯", "images/country/1_0000_沙特.png");
		map.put("韩国", "images/country/1_0001_韩国.png");
		map.put("波兰", "images/country/1_0025_波兰.png");
		map.put("丹麦", "images/country/1_0015_丹麦.png");
		map.put("瑞典", "images/country/1_0012_瑞典.png");
		map.put("瑞士", "images/country/1_0021_瑞士.png");
		map.put("英格兰", "images/country/1_0020_英格兰.png");
		map.put("冰岛", "images/country/1_0014_冰岛.png");
		map.put("克罗地亚", "images/country/1_0016_克罗地亚.png");
		map.put("德国", "images/country/1_0030_德国.png");
		map.put("摩洛哥", "images/country/1_0003_摩洛哥.png");
		map.put("墨西哥", "images/country/1_0018_墨西哥.png");
		map.put("哥斯达黎加", "images/country/1_0013_哥斯达黎加.png");
		map.put("巴拿马", "images/country/1_0002_巴拿马.png");
		map.put("葡萄牙", "images/country/1_0028_葡萄牙.png");
		map.put("俄罗斯", "images/country/1_0031_俄罗斯.png");
		map.put("塞内加尔", "images/country/1_0009_塞内加尔.png");
		map.put("乌拉圭", "images/country/1_0017_乌拉圭.png");
		map.put("秘鲁", "images/country/1_0022_秘鲁.png");
		map.put("埃及", "images/country/1_0010_埃及.png");
		map.put("突尼斯", "images/country/1_0011_突尼斯.png");
		map.put("阿根廷", "images/country/1_0027_阿根廷.png");
		map.put("尼日利亚", "images/country/1_0006_尼日利亚.png");
		map.put("澳大利亚", "images/country/1_0005_澳大利亚.png");
		map.put("西班牙", "images/country/1_0023_西班牙.png");
		map.put("伊朗", "images/country/1_0008_伊朗.png");
		map.put("日本", "images/country/1_0004_日本.png");
	}
	
	public static void main(String[] args) {
		init();
	}
	public static String getLogo(String name){
		if(map.size()!=32){
			init();
		}
		return map.get(name);
	}
}
