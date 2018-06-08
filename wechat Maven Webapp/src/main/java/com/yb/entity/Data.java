package com.yb.entity;

/**
 * 暂定，先放着
 */
public class Data {
    private KeyWord keyWord1;
    private KeyWord keyWord2;
    private KeyWord keyWord3;
    private KeyWord keyWord4;

    @Override
    public String toString() {
        return "Data{" +
                "keyWord1=" + keyWord1 +
                ", keyWord2=" + keyWord2 +
                ", keyWord3=" + keyWord3 +
                ", keyWord4=" + keyWord4 +
                '}';
    }

    public KeyWord getKeyWord2() {
        return keyWord2;
    }

    public void setKeyWord2(KeyWord keyWord2) {
        this.keyWord2 = keyWord2;
    }

    public KeyWord getKeyWord3() {
        return keyWord3;
    }

    public void setKeyWord3(KeyWord keyWord3) {
        this.keyWord3 = keyWord3;
    }

    public KeyWord getKeyWord4() {
        return keyWord4;
    }

    public void setKeyWord4(KeyWord keyWord4) {
        this.keyWord4 = keyWord4;
    }

    public KeyWord getKeyWord1() {

        return keyWord1;
    }

    public void setKeyWord1(KeyWord keyWord1) {
        this.keyWord1 = keyWord1;
    }

    public Data() {

    }

    public Data(KeyWord keyWord1, KeyWord keyWord2, KeyWord keyWord3, KeyWord keyWord4) {
        this.keyWord1 = keyWord1;
        this.keyWord2 = keyWord2;
        this.keyWord3 = keyWord3;
        this.keyWord4 = keyWord4;
    }

    public Data(KeyWord keyWord1) {

        this.keyWord1 = keyWord1;
    }
}
