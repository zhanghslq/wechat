package com.yb.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
        Date parse =
                yyyyMMdd.parse("20180614");
        System.out.println(parse.getTime());
    }
}
