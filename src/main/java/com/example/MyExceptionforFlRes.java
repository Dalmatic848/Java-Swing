package com.example;

public class MyExceptionforFlRes extends Exception{
    public MyExceptionforFlRes() {
        super("Так как, игрок является полевым, данное значение должно иметь формат (M >= GIB) M:xx GIB:xx G:xx MS:xx");
    }
    public static void checkFlRes(String a) throws MyExceptionforFlRes, NullPointerException {
        if (a.length() < 22 && a.length() > 0) throw new MyExceptionforFlRes();
        if (a.charAt(0) != 'M') throw new MyExceptionforFlRes();
        if (a.charAt(1) != ':') throw new MyExceptionforFlRes();
        if (a.charAt(4) != ' ') throw new MyExceptionforFlRes();
        if (a.charAt(5) != 'G') throw new MyExceptionforFlRes();
        if (a.charAt(6) != 'I') throw new MyExceptionforFlRes();
        if (a.charAt(7) != 'B') throw new MyExceptionforFlRes();
        if (a.charAt(8) != ':') throw new MyExceptionforFlRes();
        if (a.charAt(11) != ' ') throw new MyExceptionforFlRes();
        if (a.charAt(12) != 'G') throw new MyExceptionforFlRes();
        if (a.charAt(13) != ':') throw new MyExceptionforFlRes();
        if (a.charAt(16) != ' ') throw new MyExceptionforFlRes();
        if (a.charAt(17) != 'M') throw new MyExceptionforFlRes();
        if (a.charAt(18) != 'S') throw new MyExceptionforFlRes();
        if (a.charAt(19) != ':') throw new MyExceptionforFlRes();
        String d = a.substring(2, 4);
        String c = a.substring(9, 11);
        if (Integer.valueOf(d) < Integer.valueOf(c)) throw new MyExceptionforFlRes();
        int flag = 0;
        char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int j : new int[] {2, 3, 9, 10, 14, 15, 20, 21}) {
            for (char i : b) {
                if (a.charAt(j) == i) { 
                    flag++;
                }
            }
        }   
        if (flag != 8) throw new MyExceptionforFlRes();  
    }
}