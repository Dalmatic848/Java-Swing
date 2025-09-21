package com.example;



public class MyExceptionforName extends Exception {
    public MyExceptionforName() {
        super("Имя должно состоять из символов");
    }
    public static void checkName(String a) throws MyExceptionforName, NullPointerException {
        if (a.matches(".*\\d+.*") == true) throw new MyExceptionforName();
    } 
}
