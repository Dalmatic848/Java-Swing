package com.example;

public class MyExceptionforSp extends Exception {
    public MyExceptionforSp() {
        super("Специализация должна быть инициализированной. Весь список есть в выпадающем списке поиска");
    }
    public static void checkSp(String a, String[] b) throws MyExceptionforSp, NullPointerException {
        boolean flag = false;
        for (String i : b) {
            if (a.equals(i) == true) {
                flag = true;
            }
        }
        if (a.equals("") == true) {
            flag = true;
        }
        if (a.equals("Специализация")) throw new MyExceptionforSp();
        if (flag == false) throw new MyExceptionforSp();
    }
}