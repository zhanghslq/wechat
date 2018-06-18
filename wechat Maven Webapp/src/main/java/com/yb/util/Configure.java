package com.yb.util;

public class Configure {
    private static String key = "你的商户的api秘钥";

    //小程序ID
    private static String appID = "wx3a5373020d49f671";
    //商户号
    private static String mch_id = "你的商户号";
    //
    private static String secret = "bb6e6f75e021e88be7ebfda9ffcc14b2";

    public static String getSecret() {
        return secret;
    }

    public static void setSecret(String secret) {
        Configure.secret = secret;
    }

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        Configure.key = key;
    }

    public static String getAppID() {
        return appID;
    }

    public static void setAppID(String appID) {
        Configure.appID = appID;
    }

    public static String getMch_id() {
        return mch_id;
    }

    public static void setMch_id(String mch_id) {
        Configure.mch_id = mch_id;
    }

}
