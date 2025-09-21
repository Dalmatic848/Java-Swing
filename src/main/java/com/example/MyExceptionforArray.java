package com.example;

public class MyExceptionforArray extends Exception {
    public MyExceptionforArray() {
        super("Удалять нечего");
    }
    public static void checkLen(int len) throws MyExceptionforArray, NullPointerException {
        if (len == 0) throw new MyExceptionforArray();

    } 
} 