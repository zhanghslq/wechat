/*
package com.yb.proto;

import com.yb.entity.Miniprogram;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import java.io.IOException;
public class Test1 {
    public static Object test(String[] args) {
        Miniprogram.CJdZtMiniProgramData p = Miniprogram.CJdZtMiniProgramData.newBuilder()
                .setSAppId("wx8876bdc7311e2d4a")
                .setSOriginalId("gh_5c9b3b59571b")
                .setSAccessToken("ssssxxxxx")
                .setDdwValidBeginTime(1234566545)
                .setDdwValidEndTime(1234566545)
                .build();
        Miniprogram.CJdZtMiniProgramReq req = Miniprogram.CJdZtMiniProgramReq.newBuilder().addVData(p).build();
        byte[] content = req.toByteArray();
        //byte[] bytes = requestRemote("http://192.168.145.73:8083/fapp/jdzt/miniprogram/updatetoken", conten);
        HttpClient client=new HttpClient();
        PostMethod postMethod=new PostMethod(bytes);
        try{
        postMethod.addRequestHeader("Content-Type","application/octet-stream;charset=utf-8");
        postMethod.setRequestEntity(new ByteArrayRequestEntity(content));

            try {
                client.executeMethod(postMethod);
            } catch (IOException e) {
                e.printStackTrace();
            }


            return postMethod.getResponseBody();
        }catch(Exception e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            postMethod.releaseConnection();
            client.getHttpConnectionManager().closeIdleConnections(0);
        }
        Miniprogram.CJdZtMiniProgramResp cJdZtMiniProgram = Miniprogram.CJdZtMiniProgramResp.parseFrom(httpBody);
// 如果返回不为0失败
        if (cJdZtMiniProgram.getORet().getIRet() != 0)
            throw new Exception("fail");
    }
}
*/
