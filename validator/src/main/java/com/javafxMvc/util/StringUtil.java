package com.javafxMvc.util;

/**
 * This is a util class that provides methods for strings.
 */
public class StringUtil {

    private StringUtil(){}

    /**
     * Return true if the given input is null or empty.
     *
     * @param input the input
     * @return true if the given input is null or empty and false otherwise
     */
    public static boolean isNullOrEmpty(final String input){
        return input == null || input.trim().isEmpty();
    }
}
