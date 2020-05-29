package com.javafxMvc.util;

public class NumberUtil {
    public static boolean isInteger(final String input){
        return input != null && input.matches("\\d+");
    }

    public static boolean isDouble(final String input){
        return input != null && input.matches("\\d+([,.]\\d+)?");
    }
}
