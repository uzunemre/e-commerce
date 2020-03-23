package com.emreuzun.util;

public class NumberUtil {

    public static boolean isNumber(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
