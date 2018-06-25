package com.yb.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 随机增加猜球人数
 */
public class RandomMatchUtil {
    private static Map<Integer,Integer>map=new HashMap<Integer,Integer>();

    public static void main(String[] args) {
        Integer integer = get(2306734);
        System.out.println(integer);
    }
    public static Integer get(Integer key){
        if(map.size()!=64){
            init();
        }
        Integer integer = map.get(key);
        if(integer!=null){
            return integer;
        }else {
            return 3000;
        }

    }
    public static void init(){
        map.clear();
        map.put(2306734,1234);
        map.put(2306735,2134);
        map.put(2306740,1234);
        map.put(2306741,4321);
        map.put(2306746,3423);
        map.put(2306752,4231);
        map.put(2306747,2341);
        map.put(2306753,4322);
        map.put(2306758,1432);
        map.put(2306764,4321);
        map.put(2306759,4323);
        map.put(2306765,4532);
        map.put(2306770,3543);
        map.put(2306771,2134);
        map.put(2306776,2431);
        map.put(2306777,4678);
        map.put(2306736,4789);
        map.put(2306742,2756);
        map.put(2306737,3534);
        map.put(2306743,4764);
        map.put(2306748,3762);
        map.put(2306749,1231);
        map.put(2306754,3456);
        map.put(2306760,2546);
        map.put(2306755,3213);
        map.put(2306761,4213);
        map.put(2306772,4543);
        map.put(2306766,3423);
        map.put(2306767,2134);
        map.put(2306773,2134);
        map.put(2306778,2134);
        map.put(2306779,2314);
        map.put(2306739,2313);
        map.put(2306745,1234);
        map.put(2306744,2345);
        map.put(2306750,4542);
        map.put(2306751,3213);
        map.put(2306756,2132);
        map.put(2306757,2132);
        map.put(2306769,2314);
        map.put(2306768,2341);
        map.put(2306762,4321);
        map.put(2306780,3421);
        map.put(2306781,4231);
        map.put(2306774,4123);
        map.put(2306775,2341);
        map.put(2311284,3124);
        map.put(2311283,4231);
        map.put(2311285,4321);
        map.put(2311286,2341);
        map.put(2311288,3421);
        map.put(2311289,2341);
        map.put(2311290,2341);
        map.put(2311291,3421);
        map.put(2311292,2342);
        map.put(2311294,3241);
        map.put(2311293,2341);
        map.put(2311295,2341);
        map.put(2311296,2341);
        map.put(2311298,1423);
    }
}
