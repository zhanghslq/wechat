package com.yb.util;

import java.text.DecimalFormat;

public class DoubleUtils {
    private static DecimalFormat    df   = new DecimalFormat("######0.00");
    public static void main(String[] args) {

    }
    public static Double format(Double value){
        String format = df.format(value);
        Double aDouble = Double.valueOf(format);
        return  aDouble;
    }
}
