package com.example;

import org.apache.commons.lang3.StringUtils;

public class MyExceptionforScore extends Exception {
    public MyExceptionforScore() { 
        super("Данное значение не может быть отрицательным, пустым или содержать буквы");

    }
    public static void checkNumber (String snum) throws MyExceptionforScore, NullPointerException {
        if (snum.charAt(0) == '-') throw new MyExceptionforScore();
        if (StringUtils.isNumeric(snum) == false) throw new MyExceptionforScore();
        
    }
}