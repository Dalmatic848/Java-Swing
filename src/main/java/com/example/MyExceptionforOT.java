package com.example;

public class MyExceptionforOT extends Exception{
    public MyExceptionforOT() {
        super ("Команда должна входить в состав РПЛ. Весь список есть в выпадающем списке поиска");
    }
    public static void checkOT(String a, String[] b) throws MyExceptionforOT, NullPointerException{
        boolean flag = false;
        for (String i : b) {
            if (a.equals(i) == true) {
                flag = true;
            }
        }
        if (a.equals("") == true) {
            flag = true;
        }
        if (a.equals("Команда соперников")) throw new MyExceptionforOT();
        if (flag == false) throw new MyExceptionforOT();
    }
}
