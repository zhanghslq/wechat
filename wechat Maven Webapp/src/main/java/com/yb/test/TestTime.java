package com.yb.test;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import java.util.Date;

public class TestTime {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getTime());
        long l = date.getTime() + 7200000l;
        Date date1 = new Date(l);
        System.out.println(date1);
    }
}
