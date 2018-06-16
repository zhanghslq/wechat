package com.yb.util;

import java.util.HashMap;
import java.util.Map;

public class BroadcastUtils {
    private static Map<Integer,String> map=new HashMap<Integer,String>();
    private static Map<Integer,String> mapLogo=new HashMap<Integer,String>();
    public static void main(String[] args) {

    }
    public static String getMessage(Integer type,String name){
        if(map.size()!=7){
            map.clear();
            init();
        }
        String s = map.get(type);
        if (s==null){
            return null;
        }
        return name+s;
    }  public static String getLogo(Integer type){
        if(mapLogo.size()!=4){
            mapLogo.clear();
            init();
        }
        String s = mapLogo.get(type);
        if (s==null){
            return "images/broadcast/事件.png";
        }
        return s;
    }
    public static void init(){
        map.put(3,"被裁判出示了一张黄牌");
        map.put(4,"被裁判出示了一张红牌");
        map.put(15,"两黄合并一红");
        map.put(1,"射门了！");
        map.put(6,"发任意球");
        map.put(2,"发角球");
        map.put(8,"射点球");
    }public static void initLogo(){
        mapLogo.put(3,"images/broadcast/黄牌.png");
        mapLogo.put(4,"images/broadcast/红牌.png");
        mapLogo.put(15,"images/broadcast/事件.png");
        mapLogo.put(8,"images/broadcast/点球.png");
    }
}
