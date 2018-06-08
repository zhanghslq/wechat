package com.yb.entity;

public class KeyWord {
    private String value;

    public KeyWord() {
    }

    @Override
    public String toString() {
        return "KeyWord{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public KeyWord(String value) {

        this.value = value;
    }
}
