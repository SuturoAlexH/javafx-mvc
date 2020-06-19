package com.javafxMvc.util;

/**
 * This is a util class that provides methods for numbers.
 */
public class NumberUtil {

    private NumberUtil(){}

    /**
     * Return true if the given input is a number. This means the input only contains number.
     *
     * @param input the input
     * @return true if the input is a number and false otherwise
     */
    public static boolean isInteger(final String input){
        return input != null && input.matches("\\d+");
    }

    /**
     * Return true if the given input is a double. This means the input only contains number
     * separated by one dot or comma.
     *
     * @param input the input
     * @return true if the input is a double and false otherwise
     */
    public static boolean isDouble(final String input){
        return input != null && input.matches("\\d+([,.]\\d+)?");
    }
}
