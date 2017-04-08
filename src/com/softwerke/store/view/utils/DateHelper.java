package com.softwerke.store.view.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

/**
 * A utility that helps in working with dates.
 */
public class DateHelper {
    public static Date readDate(Scanner scanner) {
        Date answer = null;
        boolean correctValue = false;
        while (!correctValue) {
            try {
                System.out.println("Enter date (in \"dd-mm-yyyy\" format): ");
                answer = new java.util.Date(
                        (new SimpleDateFormat("dd-MM-yyyy")).parse(scanner.next()).getTime());
                correctValue = true;
            } catch (ParseException e) {
                System.out.println("Wrong date. Try again.");
            }
        }
        return answer;
    }


    public static boolean datesAreInOneDay(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.setTime(date1);
        calendar2.setTime(date2);

        boolean answer = false;

        if (calendar1.get(YEAR) == calendar2.get(YEAR) &&
                calendar1.get(MONTH) == calendar2.get(MONTH) &&
                calendar1.get(DAY_OF_MONTH) == calendar2.get(DAY_OF_MONTH)) {
            answer = true;
        }
        return answer;
    }
}
