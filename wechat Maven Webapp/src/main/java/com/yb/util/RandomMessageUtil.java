package com.yb.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomMessageUtil {
    private static Map<Integer,String> map=new HashMap<Integer,String>();
    public static void init(){
        map.clear();
        map.put(1,"大赛起兮，群雄并起，老夫夜观星象掐指一算，此为比赛结果。以此为证，敢应战否？");
        map.put(2,"各路豪强汗洒球场，忠实球迷摇旗助威。德比之战，势如水火，你站哪边？！");
        map.put(3,"谁将大胜而归，谁又将黯然离场？球场上比拼毅力，猜结果需要运气。你，是运气的宠儿吗？");
        map.put(4,"点了外卖没吃饱？给你大餐要不要？是吃好料还是被恶搞？猜后见分晓。");
        map.put(5,"不怕玩过界，只怕没勇气！我敢想也敢做，就看你够不够胆！今晚世界杯比赛，一起来high！");
        map.put(6,"不能一夜暴富，零花也聊胜无。今晚地铁还是车载，只需竞猜，静待比赛。");
    }
    public static String getMessage(){
        Random random = new Random();
        int i = random.nextInt(6)+1;
        if(map.size()!=6){
            init();
        }
        String s = map.get(i);
        return s;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
           getMessage();

        }
    }
}
