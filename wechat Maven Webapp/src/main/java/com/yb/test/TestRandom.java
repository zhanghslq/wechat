package com.yb.test;

import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Random rand = new Random();
            int randNum = rand.nextInt(9999)+1000;
            System.out.println(randNum);
        }

    }
}
