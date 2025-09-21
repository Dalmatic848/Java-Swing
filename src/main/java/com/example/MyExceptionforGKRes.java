package com.example;
public class MyExceptionforGKRes extends Exception{
    public MyExceptionforGKRes() {
        super("Так как, игрок является вратарем, данное значение должно иметь формат (M >= GIB) M:xx GIB:xx СONS:xx");
    }
    public static void checkGKRes(String a) throws MyExceptionforGKRes, NullPointerException {
        if (a.length() < 19 && a.length() > 0) throw new MyExceptionforGKRes();
        if (a.charAt(0) != 'M') throw new MyExceptionforGKRes();
        if (a.charAt(1) != ':') throw new MyExceptionforGKRes();
        if (a.charAt(4) != ' ') throw new MyExceptionforGKRes();
        if (a.charAt(5) != 'G') throw new MyExceptionforGKRes();
        if (a.charAt(6) != 'I') throw new MyExceptionforGKRes();
        if (a.charAt(7) != 'B') throw new MyExceptionforGKRes();
        if (a.charAt(8) != ':') throw new MyExceptionforGKRes();
        if (a.charAt(11) != ' ') throw new MyExceptionforGKRes();
        if (a.charAt(12) != 'C') throw new MyExceptionforGKRes();
        if (a.charAt(13) != 'O') throw new MyExceptionforGKRes();
        if (a.charAt(14) != 'N') throw new MyExceptionforGKRes();
        if (a.charAt(15) != 'S') throw new MyExceptionforGKRes();
        if (a.charAt(16) != ':') throw new MyExceptionforGKRes();
        String d = a.substring(2, 4);
        String c = a.substring(9, 11);
        if (Integer.valueOf(d) < Integer.valueOf(c)) throw new MyExceptionforGKRes();
        int flag = 0;
        char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int j : new int[] {2, 3, 9, 10, 17, 18}) {
            for (char i : b) {
                if (a.charAt(j) == i) { 
                    flag++;
                }
            }
        }   
        if (flag != 6) throw new MyExceptionforGKRes(); 
    }
}