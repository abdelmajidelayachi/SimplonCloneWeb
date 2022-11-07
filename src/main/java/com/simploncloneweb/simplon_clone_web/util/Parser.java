package com.simploncloneweb.simplon_clone_web.util;

public class Parser {
    public static int parseInt(String number){
        int parsedInt = -1;
        try {
            parsedInt = Integer.parseInt(number);
        }catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
        }
        return parsedInt;
    }
}
