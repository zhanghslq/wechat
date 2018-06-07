package com.yb.thread;

import com.yb.entity.AccessToken;
import com.yb.util.AccessTokenUtil;
public
class  AccessTokenThread implements Runnable
{
    public static  AccessToken accessToken;
    @Override
    public void  run(){
        while(true)
        {
        	try{
                AccessToken token = AccessTokenUtil.freshAccessToken(); // 从微信服务器刷新access_token
                if(token != null){
                    accessToken = token;
                }else{
                    System.out.println("get access_token failed------------------------------");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                if(null!= accessToken){
                    Thread.sleep((accessToken.getExpires_in() - 200) * 1000);    // 休眠7000秒
                }else{
                    Thread.sleep(60 * 1000);    // 如果access_token为null，60秒后再获取
                }
            }catch(InterruptedException e){
                try{
                    Thread.sleep(60* 1000);
                }catch(InterruptedException e1){
                    e1.printStackTrace();
                }

            }

        }

    }
}
