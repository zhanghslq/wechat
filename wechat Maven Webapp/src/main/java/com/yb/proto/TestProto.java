package com.yb.proto;

import com.google.protobuf.ByteString;
import com.yb.entity.Miniprogram;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;


public class TestProto {
    public static void main(String[] args) {
        Miniprogram.CJdZtMiniProgramData p = Miniprogram.CJdZtMiniProgramData.newBuilder()
                .setSAccessToken(ByteString.copyFromUtf8(""))
                .setDdwValidBeginTime(1l)
                .setSAccessToken(ByteString.copyFromUtf8(""))
                .setDdwValidEndTime(1l)
                .setSAppId(ByteString.copyFromUtf8(""))
                .setSOriginalId(ByteString.copyFromUtf8(""))
                .build();
        Miniprogram.CJdZtMiniProgramReq req = Miniprogram.CJdZtMiniProgramReq.newBuilder().addVData(p).build();
        byte[] content = req.toByteArray();
       // byte[] bytes = requestRemote("http://192.168.145.73:8083/fapp/jdzt/miniprogram/updatetoken", content);
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod("http://192.168.145.73:8083/fapp/jdzt/miniprogram/updatetoken");
        System.out.println("进try");
        try {
            System.out.println("准备");
            postMethod.addRequestHeader("Content-Type", "application/octet-stream;charset=utf-8");
            postMethod.setRequestEntity(new ByteArrayRequestEntity(content));
            System.out.println("发送");
            client.executeMethod(postMethod);
            System.out.println("返回值");
            byte[] responseBody = postMethod.getResponseBody();
            Miniprogram.CJdZtMiniProgramResp cJdZtMiniProgram = Miniprogram.CJdZtMiniProgramResp.parseFrom(responseBody);
            System.out.println("========================="+cJdZtMiniProgram+"=========================");
            if (cJdZtMiniProgram.getORet().getIRet() != 0){
                throw new RuntimeException("fail");
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("一场");
        } finally {
            postMethod.releaseConnection();
            client.getHttpConnectionManager().closeIdleConnections(0);
        }
       // Miniprogram.CJdZtMiniProgramResp cJdZtMiniProgram = Miniprogram.CJdZtMiniProgramResp.parseFrom(httpBody);
        // 如果返回不为0失败
    }
}
