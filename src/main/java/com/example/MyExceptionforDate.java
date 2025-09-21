package com.example;

import org.apache.commons.lang3.StringUtils;

public class MyExceptionforDate extends Exception {
    public MyExceptionforDate() { 
        super("Вы должны ввести дату. Дата должна иметь формат: xx.xx.xxxx . День и месяц не должны быть 0. А также в один день не может быть 2 и более игр.");
    }
    public static void checkDate(String a, String c[][], int pos) throws MyExceptionforDate, NullPointerException {
        if (a.length() < 10 && a.length() > 0) throw new MyExceptionforDate();
        if (a.charAt(2) != '.') throw new MyExceptionforDate();
        if (a.charAt(5) != '.') throw new MyExceptionforDate();
        if (a.charAt(0) == '0' && a.charAt(1) == '0') throw new MyExceptionforDate();
        if (a.charAt(3) == '0' && a.charAt(4) == '0') throw new MyExceptionforDate();
        String b = a.substring(0, 2);
        if (StringUtils.isNumeric(b) == false) throw new MyExceptionforDate();
        b = a.substring(3, 5);
        if (StringUtils.isNumeric(b) == false) throw new MyExceptionforDate();
        b = a.substring(6, 10);
        if (StringUtils.isNumeric(b) == false) throw new MyExceptionforDate();
        boolean flag = false;
        int k = 0;
        for (String[] i : c) {
            if (k != pos) {
                if (a.equals(i[4])) {
                    flag = true;
                }
            }
            k++;
        }
        if (flag) throw new MyExceptionforDate();
    } 
}