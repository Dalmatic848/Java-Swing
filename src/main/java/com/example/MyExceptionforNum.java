package com.example;

import org.apache.commons.lang3.StringUtils;

public class MyExceptionforNum extends Exception {
    public MyExceptionforNum() { 
        super("Данное значение не может быть отрицательным, содержать буквы или начинаться с 0");

    }
    public static void checkNumber (String snum) throws MyExceptionforNum, NullPointerException {
        
        
        if (snum.charAt(0) == '-') throw new MyExceptionforNum();
        if (snum.charAt(0) == '0') throw new MyExceptionforNum();
        if (StringUtils.isNumeric(snum) == false) throw new MyExceptionforNum();
        
    }
}