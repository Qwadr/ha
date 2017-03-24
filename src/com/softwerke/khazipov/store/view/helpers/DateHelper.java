package com.softwerke.khazipov.store.view.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Scanner;

/**
 * eeeeeeee TODO javadoc
 */
public class DateHelper {
    public static Date readDate(Scanner scanner){
        Date answer = null;
        boolean correctValue = false;
        while (!correctValue) {
            try {
                System.out.println("Enter date (in \"dd-mm-yyyy\" format): ");
                answer = new java.sql.Date(
                        (new SimpleDateFormat("dd-MM-yyyy")).parse(scanner.next()).getTime());
                correctValue = true;
            } catch (ParseException e) {
                System.out.println("Wrong date. Try again.");
            }
        }
        return answer;
    }
}
