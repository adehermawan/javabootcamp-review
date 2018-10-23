package com.mitrais.javabootcamp;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Date {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }

    public static String getDay(String day, String month, String year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.valueOf(year), (Integer.valueOf(month) - 1), Integer.valueOf(day));
        String dayresult = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        return dayresult.toUpperCase();
    }
}
